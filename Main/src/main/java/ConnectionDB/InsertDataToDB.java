package ConnectionDB;

import ConnectionDB.entity.DataRowList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.Statement;

public class InsertDataToDB {
    public static Logger logger = LoggerFactory.getLogger(InsertDataToDB.class);

    //Добавляем данные в таблицу
    public static DataRowList insertData(DataRowList dataRowList) {
        try (Connection connect = GetJdbcConnection.getConnection()) {
            Statement statement = connect.createStatement();

            int den = statement.executeUpdate(String.format("INSERT INTO SolutionEquation(Number, Equation, Roots, Date) VALUES (%d,'%s','%s','%s')",
                    dataRowList.number, dataRowList.equation, dataRowList.roots, dataRowList.date));
            logger.info("Добавлено строк в БД: " + den);

/**            //старый варик для примера оставить
            int den = statement.executeUpdate("INSERT INTO SolutionEquation(`Number`, `Equation`, `Roots`, `Date`) " +
                    "VALUES (dataRowList.number, dataRowList.equation, dataRowList.roots, dataRowList.date)");*/

        } catch (Exception ex) {
            logger.error("InsertDataToDB - error - ошибка добавления данных в ДБ");
            ex.printStackTrace();
        }
        return dataRowList;
    }
}

