package ConnectionDB;

import exception.ExceptionMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateNewTable {
    public static Logger logger = LoggerFactory.getLogger(CreateNewTable.class);
    private static final GetJdbcConnection getJdbcConnection = new GetJdbcConnection();

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connect = getJdbcConnection.getConnection()){
                logger.info("Database connect has been created - ok");

                // Для взаимодействия с базой данных\выполнения комманд - используем statement
                Statement statement = connect.createStatement();

                // команда создания таблицы + создание таблицы
                String createNewSqlTable =
                        "CREATE TABLE IF NOT EXISTS `SolutionEquation` (" +
                                "`Number` INT PRIMARY KEY AUTO_INCREMENT," +
                                "`Equation` VARCHAR(200)," +
                                "`Roots` VARCHAR(200)," +
                                "`Date` VARCHAR(200))";
                statement.executeUpdate(createNewSqlTable);
                logger.info("New SqlTable table was created - successful - ok");

                // Добавляем данные в таблицу
                String addDataInToTable = "INSERT INTO SolutionEquation(`Number`, `Equation`, `Roots`, `Date`) VALUES (4, 'x1', 1, 25)";
                statement.executeUpdate(addDataInToTable);
            } catch (SQLException e) {
                throw new ExceptionMessage(e.getMessage());
            }
        } catch (Exception ex) {
            logger.error("Connection failed - error");
            logger.error(String.valueOf(ex));
        }
    }
}