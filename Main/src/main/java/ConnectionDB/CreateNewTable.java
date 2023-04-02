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
            try {
                GetJdbcConnection.getStatement().executeUpdate(SQLQueries.CREATE_NEW_SQL_TABLE);
                logger.info("New Sql_Table successfully created");
            } catch (SQLException e) {
                logger.error(String.valueOf(e));
            }
        } catch (Exception ex) {
            logger.error("Connection failed - error");
            logger.error(String.valueOf(ex));
        }
    }
}