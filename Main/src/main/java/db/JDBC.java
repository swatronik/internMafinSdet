package db;

import baseConfig.Credentials;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBC {

    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + Credentials.config.dbHost() + ":" + Credentials.config.dbPort() + "/" + Credentials.config.dbName();

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, Credentials.config.dbUser(), Credentials.config.dbPassword());

        return dbConnection;

    }
}