package ConnectionDB;

import ConnectionDB.entity.DataRowList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetDataFromDB {
    public static Logger logger = LoggerFactory.getLogger(GetDataFromDB.class);

    //получаем все данные из БД - неактивно, сохранено как пример
    public static ArrayList<DataRowList> getAllDataFromDB() {
        ArrayList<DataRowList> dataRowsArrayList = new ArrayList<>();
        try {
            ResultSet setResult = GetJdbcConnection.getStatement().executeQuery(SQLQueries.GET_ALL_DATA_FROM_DB);
            while (setResult.next()) {
                DataRowList dataRowList = new DataRowList();
                dataRowList.setNumber(setResult.getInt("number"));
                dataRowList.setEquation(setResult.getString("equation"));
                dataRowList.setRoots(setResult.getString("roots"));
                dataRowList.setDate(setResult.getString(4));
                dataRowsArrayList.add(dataRowList);
                logger.info((String.format("%d %s %s %s", dataRowList.getNumber(), dataRowList.getEquation(), dataRowList.getRoots(), dataRowList.getDate())));
            }
        } catch (Exception ex) {
            logger.error("getAllDataFromDB - error: " + ex);
        }
        return dataRowsArrayList;
    }

    //получаем данные из БД и выводим кол-во строк из БД (указывая в number)
    public static ArrayList<DataRowList> getDataOnNumberRows(Integer number) {
        ArrayList<DataRowList> dataRowListArrayList = new ArrayList<>();
        try {
            ResultSet setResult = GetJdbcConnection.getStatement().executeQuery(String.format(SQLQueries.GET_DATA_ON_NUMBER_ROWS, number));
            while (setResult.next()) {
                DataRowList dataRowList = new DataRowList();
                dataRowList.setNumber(setResult.getInt(1));
                dataRowList.setEquation(setResult.getString(2));
                dataRowList.setRoots(setResult.getString(3));
                dataRowList.setDate(setResult.getString(4));
                dataRowListArrayList.add(dataRowList);
                logger.info((String.format("%d %s %s %s",
                        dataRowList.getNumber(), dataRowList.getEquation(), dataRowList.getRoots(), dataRowList.getDate())));
            }
        } catch (Exception ex) {
            logger.error("getDataOnNumber - error: " + ex);
        }
        return dataRowListArrayList;
    }

    //получаем кол-во записей из бд, чтобы начать отсчет с последняя запись +1
    public static int getNumber() {
        int number = 0;
        try {
            ResultSet setResult = GetJdbcConnection.getStatement().executeQuery(SQLQueries.SELECT_MAX_NUMBER_FROM_TABLE);
            setResult.next();
            number = setResult.getInt(1);
            logger.info((String.format("Последняя строка Number в БД = " + number)));
            return number;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}