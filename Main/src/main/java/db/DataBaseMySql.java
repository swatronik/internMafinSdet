package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static baseConfig.Config.*;

public class DataBaseMySql {

    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPassword);

        return dbConnection;
    }
}
