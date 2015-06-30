package complex.utils;

import complex.objects.Dish;
import complex.objects.DishCategory;
import complex.objects.Info;
import complex.objects.Ingredient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DishDAOtoDB {

    static String tableName = "DISHES2";
    static Connection connection = null;
    static Statement statement;
    static ResultSet resultSet = null;
    private IngredientDAOtoDB ingredientDAO;
    private MetaDAO metaDAO;

    public DishDAOtoDB() {

        createDishesTable();
        ingredientDAO = new IngredientDAOtoDB();
        metaDAO = new MetaDAO();

    }

    public void addDish(Dish dish) {


        if (!isInTable(dish.getDishName())){
            String cat = "\'" + dish.getDishCategory() + "\'";
            String ingredients = IngredientDAOtoJson.
                    ingredientListToJson(dish.getIngredients());

            String sql = "INSERT INTO " +
                    tableName +
                    " (ID,NAME,CATEGORY)"
                    + "VALUES(" + null + "," +
                    "\'" + (dish.getDishName()).trim() + "\'," +
                    cat +
                    " )";
            executeUpdateSQL(sql);

            int dishID = getIdByNAme(dish.getDishName());

            for (Ingredient i:dish.getIngredients()){
                ingredientDAO.addIngredient(i);
                int ingredientID = ingredientDAO.getIdByName(i.getName());
                Info info = new Info();
                info.setIdDish(dishID);
                info.setIdIngr(ingredientID);
                info.setWeight(i.getWeight());
                metaDAO.addInfo(info);

            }
        }



    }

    public void createDishesTable() {

        String sql = "CREATE TABLE if not exists " + tableName +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " NAME TEXT NOT NULL," +
                " CATEGORY TEXT NOT NULL " +
                ")";
        executeUpdateSQL(sql);
    }

    public List<Dish> getAllDishes() {

        List<Dish> dishList = new ArrayList<>();
        try {
            Class.forName(DbParams.DB_PARAM);
            connection = DriverManager.getConnection(DbParams.PATH_TO_DB);
            statement = connection.createStatement();

            resultSet = statement.executeQuery("SELECT * FROM " + tableName + ";");
            while (resultSet.next()) {
                int dishID = resultSet.getInt("ID");
                String name = (resultSet.getString("NAME").trim());
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

                List<Ingredient> ingredients = ingredientDAO.getIngredientByDishID(dishID);

                Dish tmp = new Dish(name, category);
                tmp.setIngredients(ingredients);
                dishList.add(tmp);
            }
            resultSet.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return dishList;
    }

    public int getIdByNAme(String name){

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
            System.out.print("in this");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }


        return id;
    }


    private void executeUpdateSQL(String sql) {

        try {
            Class.forName(DbParams.DB_PARAM);
            connection = DriverManager.getConnection(DbParams.PATH_TO_DB);
            statement = connection.createStatement();

            statement.executeUpdate(sql);
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.print("Some problems in execute");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    private Boolean isInTable(String dishName) {
        Boolean isInTable = false;
        try {
            Class.forName(DbParams.DB_PARAM);
            connection = DriverManager.getConnection(DbParams.PATH_TO_DB);
            statement = connection.createStatement();
            String sql = "SELECT * FROM " + tableName + " WHERE NAME = '" + dishName + "' ";
            resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                isInTable = true;
            }
            resultSet.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return isInTable;
    }


}
