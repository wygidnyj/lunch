package complex.utils;
import complex.objects.Dish;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBHelper {
    private Connection connection = null;
    private Statement statement = null;
    public final String TABLE_NAME = " MENU";
    public final String COLUMN_NAME = " NAME";
    public final String COLUMN_PRICE = " PRICE";
    public final String COLUMN_CATEGORY = " PRICE";

    public DBHelper() {

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Opened database successfully");


            statement = connection.createStatement();
            String sql = "CREATE TABLE if not exists "+TABLE_NAME +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    COLUMN_NAME+"     TEXT    NOT NULL, " +
                    COLUMN_PRICE+"    REAL    NOT NULL, " +
                    COLUMN_CATEGORY+" CHAR(50)    NOT NULL)";
            statement.executeUpdate(sql);
            statement.close();
            connection.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }
    public boolean saveToDB(Dish dish){

        return true;
    }
    public List<Dish> readAllDishesFromDB(){
        List<Dish> dishList = new ArrayList<>();


        return dishList;

    }
}
