package ConnectionDB;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionDB {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try {
                Connection connect = getConnection();
                System.out.println("Database has been created!");

                Statement statement = connect.createStatement();
                // команда создания таблицы
                String sqlCommand = "CREATE TABLE products (Id INT PRIMARY KEY AUTO_INCREMENT, ProductName VARCHAR(20), Price INT)";
                // создание таблицы
                statement.executeUpdate(sqlCommand);
                //Добавляем в таблицу данные
                int rows = statement.executeUpdate("INSERT Products(ProductName, Price) VALUES ('iPhone X', 76000)," +
                        "('Galaxy S9', 45000), ('Nokia 9', 36000)");
                System.out.printf("Added %d rows", rows);


                System.out.println("Connection to QuadEquation DB succesfull!");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }




        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
    }

    //метод получения проперти для подключения
    public static Connection getConnection() throws SQLException {

        Properties propertiesDB = new Properties();
        try(InputStream in = Files.newInputStream(Paths.get("C:\\Users\\Vitalii\\IdeaProjects\\internMafinSdet\\Main\\src\\main\\resources\\database.properties"))){
            propertiesDB.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e + "не найден путь до database.properties");
        }
        String url = propertiesDB.getProperty("url");
        String username = propertiesDB.getProperty("username");
        String password = propertiesDB.getProperty("password");
        return DriverManager.getConnection(url, username, password);
    }
}