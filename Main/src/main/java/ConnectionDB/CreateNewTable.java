package ConnectionDB;

import exception.ExceptionMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateNewTable {
    public static Logger logger = LoggerFactory.getLogger(CreateNewTable.class);

    //Создать новую таблицу в БД если такой нет
    public void createNewTableInDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connect = GetJdbcConnection.getConnection()) {
                logger.info("Database connect has been created - ok");
                Statement statement = connect.createStatement();
                String createNewSqlTable =
                        "CREATE TABLE IF NOT EXISTS `SolutionEquation` (" +
                                "`Number` INT PRIMARY KEY AUTO_INCREMENT," +
                                "`Equation` VARCHAR(200)," +
                                "`Roots` VARCHAR(200)," +
                                "`Date` VARCHAR(200))";
                statement.executeUpdate(createNewSqlTable);
                logger.info("New SqlTable table was created - successful - ok");
            } catch (SQLException e) {
                throw new ExceptionMessage(e.getMessage());
            }
        } catch (Exception ex) {
            logger.error("Connection failed - error");
            logger.error(String.valueOf(ex));
        }
    }
}