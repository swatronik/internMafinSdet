package ConnectionDB;

import ConnectionDB.entity.DataRowList;
import exception.ExceptionMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DeleteDataFromDB {
    public static Logger logger = LoggerFactory.getLogger(DeleteDataFromDB.class);

    public int getLastDataFromBase() {
        int id = 0;
        try (Connection connect = GetJdbcConnection.getConnection()) {
            Statement statement = connect.createStatement();
            ResultSet setResult = statement.executeQuery("select MAX(Number) from solutionequation");
            while (setResult.next()) {
                id = setResult.getInt(1);
                logger.info((String.format("Кол-во колонок равно = " + id)));
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

    public void deleteLastData() throws SQLException {
        DeleteDataFromDB deleteDataFromDB = new DeleteDataFromDB();
        int lastRow = deleteDataFromDB.getLastDataFromBase();
        deleteDataFromDB.deleteLastDataFromBase(lastRow);
        logger.info("Последняя строка в базе удалена");
    }
}
