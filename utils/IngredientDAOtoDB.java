package complex.utils;


import complex.objects.Ingredient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IngredientDAOtoDB {

    static String tableName = "INGREDIENTS";
    static Connection connection = null;
    static Statement statement;
    static ResultSet resultSet = null;

    public IngredientDAOtoDB() {
        createIngredientsTable();
    }

    public void createIngredientsTable() {

        String sql = "CREATE TABLE if not exists " + tableName +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " NAME TEXT NOT NULL," +
                " PRICE DOUBLE NOT NULL " +
                ")";
        executeUpdateSQL(sql);
    }

    public void addIngredient(Ingredient ingredient) {


        String sql = "INSERT INTO " +
                tableName +
                " (ID,NAME,PRICE )" +
                " VALUES(" + null + "," +
                "\'" + (ingredient.getName()).trim() + "\'" + ", " +
                "\'" + ingredient.getPrice() + "\'"  +
                " )";

        executeUpdateSQL(sql);


    }

    public List<Ingredient> getAllIngredients() {
        List<Ingredient> ingredients = new ArrayList<>();
        try {
            Class.forName(DbParams.DB_PARAM);
            connection = DriverManager.getConnection(DbParams.PATH_TO_DB);
            statement = connection.createStatement();

            resultSet = statement.executeQuery("SELECT * FROM " + tableName + ";");
            while (resultSet.next()) {
                String name = (resultSet.getString("NAME").trim());
                double price = resultSet.getDouble("PRICE");
                Ingredient tmpIngredient = new Ingredient(name, price);

                ingredients.add(tmpIngredient);
            }
            resultSet.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }


        return ingredients;

    }
    public List<Ingredient> getIngredientByDishID(int id){
        List<Ingredient> ingredients = new ArrayList<>();
        try {
            Class.forName(DbParams.DB_PARAM);
            connection = DriverManager.getConnection(DbParams.PATH_TO_DB);
            statement = connection.createStatement();

            String sql = "SELECT INGREDIENTS.ID, INGREDIENTS.NAME, INGREDIENTS.PRICE, META.WEIGHT\n" +
                    "FROM META\n" +
                    "JOIN INGREDIENTS\n" +
                    "ON META.ID_INGREDIENT=INGREDIENTS.ID\n" +
                    "WHERE META.ID_DISH="+id;
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String name = (resultSet.getString("NAME").trim());
                double price = resultSet.getDouble("PRICE");
                double weight = resultSet.getInt("WEIGHT");
                Ingredient tmpIngredient = new Ingredient();
                tmpIngredient.setName(name);
                tmpIngredient.setPrice(price);
                tmpIngredient.setWeight(weight);
                ingredients.add(tmpIngredient);
            }
            resultSet.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }


        return ingredients;
    }

    public int getIdByName(String name){
        int id = 0;
        try {
            Class.forName(DbParams.DB_PARAM);
            connection = DriverManager.getConnection(DbParams.PATH_TO_DB);
            statement = connection.createStatement();

            String sql = "SELECT * FROM "+tableName + " WHERE NAME = '"+name+"' ";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                id = resultSet.getInt("ID");

            }
            resultSet.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }


        return id;

    }

    public void executeUpdateSQL(String sql) {

        try {
            Class.forName(DbParams.DB_PARAM);
            connection = DriverManager.getConnection(DbParams.PATH_TO_DB);
            statement = connection.createStatement();

            statement.executeUpdate(sql);
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }


}
