package ConnectionDB;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteDataFromDB {
    public static Logger logger = LoggerFactory.getLogger(DeleteDataFromDB.class);

    public int getLastNumberFromBase() {
        int id = 0;
        try {
            ResultSet setResult = GetJdbcConnection.getStatement().executeQuery(SQLQueries.SELECT_MAX_NUMBER_FROM_TABLE);
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
        try {
            int rows = GetJdbcConnection.getStatement().executeUpdate(
                    String.format(SQLQueries.DELETE_LAST_DATA_FROM_DB, number));
            logger.info((String.format("%d row(s) deleted", rows)));
        } catch (Exception ex) {
            logger.error("Ошибка удаления данных из БД");
            logger.error(String.valueOf(ex));
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