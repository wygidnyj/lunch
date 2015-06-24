package complex.utils;

import complex.objects.Dish;
import complex.objects.DishCategory;
import complex.objects.Menu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class DBHelper {
    static String pathToDB = "jdbc:sqlite:testDB.db";
    static String tableName = "DISHES2";
    static Connection connection = null;
    static Statement statement;
    static ResultSet resultSet = null;

    public static void main(String[] args) {

        Menu menuOut = new Menu(); // Menu for writing to DB
        Menu menuIn; // Menu for reading from DB
        menuOut.fillDishList();
        List<Dish> dishList = menuOut.getAllDishes();

        // Creating db
        createDishesTable();

        // write all dishes to our DataBase
        for (Dish j : dishList) {
            addDishToTable(j);
        }

        // read all dishes from out DataBase
        menuIn = readDishesFromTable();
        // show all dishes from menuIn
        dishList = menuIn.getAllDishes();
        for (Dish j1 : dishList) {
            System.out.print(j1.getDishName() + ", " + j1.getDishCategory()
                    + ", " + j1.getDishPrice() + "\n");
        }

    }

    public static void addDishToTable(Dish dish) {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(pathToDB);
            statement = connection.createStatement();

            String cat = "\'" + dish.getDishCategory() + "\'";
            String sql = "INSERT INTO " + tableName + " (ID,NAME,PRICE,CATEGORY)"
                    + "VALUES(" + null + "," + "\'" + (dish.getDishName()).trim()
                    + "\'" + "," + dish.getDishPrice() + "," + cat + ")";

            statement.executeUpdate(sql);
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }

    public static void createDishesTable() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(pathToDB);
            statement = connection.createStatement();

            // creating of table DISHES (ID,NAME,PRICE,CATEGORY) in DataBase
            String sql = "CREATE TABLE if not exists " + tableName +
                    " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT NOT NULL,"
                    + "PRICE DOUBLE NOT NULL, CATEGORY TEXT NOT NULL)";
            statement.executeUpdate(sql);
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static Menu readDishesFromTable() {
        Menu menu = new Menu();
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(pathToDB);
            statement = connection.createStatement();

            resultSet = statement.executeQuery("SELECT * FROM " + tableName + ";");
            while (resultSet.next()) {
                String name = (resultSet.getString("NAME").trim());
                double price = resultSet.getDouble("PRICE");
                DishCategory cat;
                switch ((resultSet.getString("CATEGORY")).trim()) {
                    case "FIRST":
                        cat = DishCategory.FIRST;
                        break;
                    case "SECOND":
                        cat = DishCategory.SECOND;
                        break;
                    case "DRINK":
                        cat = DishCategory.DRINK;
                        break;
                    default:
                        cat = DishCategory.DRINK;
                        break;
                }
                Dish tmp = new Dish(name, cat);
                tmp.setDishPrice(price);
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

}
