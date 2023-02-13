package ConnectionDB;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class GetJdbcConnection {
    public static Logger logger = LoggerFactory.getLogger(GetJdbcConnection.class);

    //Подключение к БД используя проперти
    public static Connection getConnection() throws SQLException {
        Properties propertiesDB = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get("C:\\Users\\Vitalii\\IdeaProjects\\internMafinSdet\\Main\\src\\main\\resources\\database.properties"))) {
            propertiesDB.load(in);
        } catch (Exception ex) {
            logger.error(String.valueOf(ex));
        }
        String url = propertiesDB.getProperty("url");
        String username = propertiesDB.getProperty("username");
        String password = propertiesDB.getProperty("password");
        return DriverManager.getConnection(url, username, password);
    }
}