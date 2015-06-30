package complex.utils;

import complex.objects.Info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MetaDAO {
    static String tableName = "META";
    static Connection connection = null;
    static Statement statement;
    static ResultSet resultSet = null;

    public MetaDAO() {
        createTable();
    }

    public void createTable() {

        String sql = "CREATE TABLE if not exists " + tableName +
                " (ID_DISH INT NOT NULL," +
                " ID_INGREDIENT INT NOT NULL," +
                " WEIGHT DOUBLE NOT NULL " +
                ")";
        executeUpdateSQL(sql);
    }

    public void addInfo(Info info) {


        String sql = "INSERT INTO " +
                tableName +
                " (ID_DISH,ID_INGREDIENT,WEIGHT )" +
                " VALUES(" +info.getIdDish() + "," +
                "\'" + info.getIdIngr() + "\'" + ", " +
                "\'" + info.getWeight() + "\'"  +
                " )";

        executeUpdateSQL(sql);


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
