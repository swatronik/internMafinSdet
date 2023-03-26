package ConnectionDB;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteDataFromDB {
    public static Logger logger = LoggerFactory.getLogger(DeleteDataFromDB.class);

    public int getLastNumberFromBase() {
        int id = 0;
        try (Connection connect = GetJdbcConnection.getConnection()) {
            Statement statement = connect.createStatement();
            ResultSet setResult = statement.executeQuery("select MAX(Number) from solutionequation");
            while (setResult.next()) {
                id = setResult.getInt(1);
                logger.info((String.format("Максимальное значение в колонке Number = " + id)));
            }
            return id;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void deleteLastDataFromBase(int number) throws SQLException {
        try (Connection connect = GetJdbcConnection.getConnection()) {
            Statement statement = connect.createStatement();
            int rows = statement.executeUpdate(
                    String.format("delete from solutionequation where Number = %d", number));
            logger.info((String.format("%d row(s) deleted", rows)));
        }
    }

    //удаляем последнее значение Number из БД
    public void deleteLastData() throws SQLException {
        DeleteDataFromDB deleteDataFromDB = new DeleteDataFromDB();
        int lastRow = deleteDataFromDB.getLastNumberFromBase();
        deleteDataFromDB.deleteLastDataFromBase(lastRow);
        logger.info("Последняя строка в базе удалена");
    }
}
