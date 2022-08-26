package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseMySql {

    public static void main(String[] args) {
        try {
            JDBC db = new JDBC();
            Connection dbConnection = db.getDbConnection();
            Statement statement = dbConnection.createStatement();
            ResultSet set = statement.executeQuery("select * from equation.staff");
            while (set.next()) {
                System.out.println(set.getString(2));
            }
            set.close();
            dbConnection.close();
            statement.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
