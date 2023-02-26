package ConnectionDB;

import ConnectionDB.entity.DataRowList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class GetDataFromDB {
    public static Logger logger = LoggerFactory.getLogger(GetDataFromDB.class);

    //получаем все данные из БД
    public static ArrayList<DataRowList> getAllDataFromDB() {
        ArrayList<DataRowList> dataRowsArrayList = new ArrayList<>();
        try (Connection connect = GetJdbcConnection.getConnection()) {
            Statement statement = connect.createStatement();
            ResultSet setResult = statement.executeQuery("SELECT number, equation, roots, date FROM solutionEquation");
            while (setResult.next()) {
                DataRowList dataRowList = new DataRowList();
                dataRowList.number = setResult.getInt(1);
                dataRowList.equation = setResult.getString(2);
                dataRowList.roots = setResult.getString(3);
                dataRowList.date = setResult.getString(4);
                dataRowsArrayList.add(dataRowList);
                logger.info((String.format("%d %s %s %s", dataRowList.number, dataRowList.equation, dataRowList.roots, dataRowList.date)));
            }
        } catch (Exception ex) {
            logger.error("getDataOnNumber - error: " + ex);
        }
        return dataRowsArrayList;
    }

    //получаем данные по номеру строки
    public DataRowList getDataOnNumber(Integer number) {
        try (Connection connect = GetJdbcConnection.getConnection()) {
            Statement statement = connect.createStatement();
            ResultSet setResult = statement.executeQuery(
                    String.format("SELECT number, equation, roots, date FROM solutionEquation WHERE number = %s", number));
            if (setResult.next()) {
                DataRowList dataRowList = new DataRowList();
                dataRowList.number = setResult.getInt(1);
                dataRowList.equation = setResult.getString(2);
                dataRowList.roots = setResult.getString(3);
                dataRowList.date = setResult.getString(4);
                logger.info((String.format("%d %s %s %s", dataRowList.number, dataRowList.equation, dataRowList.roots, dataRowList.date)));
                return dataRowList;
            }
        } catch (Exception ex) {
            logger.error("getDataOnNumber - error: " + ex);
        }
        return null;
    }
}