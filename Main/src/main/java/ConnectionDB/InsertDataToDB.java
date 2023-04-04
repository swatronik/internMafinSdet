package ConnectionDB;

import ConnectionDB.entity.DataRowList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InsertDataToDB {
    public static Logger logger = LoggerFactory.getLogger(InsertDataToDB.class);

    //Добавляем данные в таблицу
    public static DataRowList insertData(DataRowList dataRowList) {
        try {
            int den = GetJdbcConnection.getStatement().executeUpdate(String.format(SQLQueries.INSERT_DATA_INTO_TABLE,
                    dataRowList.getNumber(), dataRowList.getEquation(), dataRowList.getRoots(), dataRowList.getDate()));
            logger.info("Добавлено строк в БД: " + den);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("Ошибка добавления данных в ДБ");
        }
        return dataRowList;
    }
}