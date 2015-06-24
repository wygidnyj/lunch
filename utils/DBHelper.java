package complex.utils;

import complex.objects.Dish;
import complex.objects.DishCategory;
import complex.objects.Ingredient;
import complex.objects.Menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBHelper {
    static String pathToDB = "jdbc:sqlite:testDB.db";
    static String tableName = "DISHES2";
    static Connection connection = null;
    static Statement statement;
    static ResultSet resultSet = null;

    public DBHelper() {
        // Creating db
        createDishesTable();

    }

    public void addDishToTable(Dish dish) {

        String cat = "\'" + dish.getDishCategory() + "\'";
        String ingredients = JsonHelper.
                ingredientListToJson(dish.getIngredients());

        String sql = "INSERT INTO " +
                tableName +
                " (ID,NAME,PRICE,CATEGORY,INGREDIENTS)"
                + "VALUES(" + null + "," +
                "\'" + (dish.getDishName()).trim() + "\'" + "," +
                dish.getDishPrice() + "," +
                cat + ",\'" +
                ingredients + "\' )";
        executeUpdateSQL(sql);


    }

    public void createDishesTable() {

        // creating of table DISHES (ID,NAME,PRICE,CATEGORY) in DataBase
        String sql = "CREATE TABLE if not exists " + tableName +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " NAME TEXT NOT NULL," +
                " PRICE DOUBLE NOT NULL," +
                " CATEGORY TEXT NOT NULL," +
                " INGREDIENTS TEXT NOT NULL" +
                ")";
        executeUpdateSQL(sql);
    }

    public Menu readDishesFromTable() {
        Menu menu = new Menu();
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(pathToDB);
            statement = connection.createStatement();

            resultSet = statement.executeQuery("SELECT * FROM " + tableName + ";");
            while (resultSet.next()) {
                String name = (resultSet.getString("NAME").trim());
                double price = resultSet.getDouble("PRICE");
                DishCategory category;
                switch ((resultSet.getString("CATEGORY")).trim()) {
                    case "FIRST":
                        category = DishCategory.FIRST;
                        break;
                    case "SECOND":
                        category = DishCategory.SECOND;
                        break;
                    default:
                        category = DishCategory.DRINK;
                        break;
                }
                String json = (resultSet.getString("INGREDIENTS").trim());
                ArrayList<Ingredient> ingredients = JsonHelper
                        .ingredientListFromJson(json);
                Dish tmp = new Dish(name, category);
                tmp.setDishPrice(price);
                tmp.setIngredients(ingredients);
                menu.addDish(tmp);
            }
            resultSet.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return menu;
    }

    public void executeUpdateSQL(String sql) {

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(pathToDB);
            statement = connection.createStatement();

            statement.executeUpdate(sql);
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void executeQuerySQL(String sql){


    }

}
