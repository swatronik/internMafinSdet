package ConnectionDB;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

public class CreateNewTable {
    public static Logger logger = LoggerFactory.getLogger(CreateNewTable.class);

    //Создать новую таблицу в БД если такой нет
    public void createNewTableInDB() {

        try {
            GetJdbcConnection.getStatement().executeUpdate(SQLQueries.CREATE_NEW_SQL_TABLE);
            logger.info("New Sql_Table successfully created");
        } catch (SQLException e) {
            logger.error(String.valueOf(e));
            logger.error("Таблица не создалась или уже есть");
        }

    }
}