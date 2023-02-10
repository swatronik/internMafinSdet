package ConnectionDB;

import ConnectionDB.entity.DataRowList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GetDataFromDB {

    private final GetJdbcConnection getJdbcConnection = new GetJdbcConnection();

    public ArrayList<DataRowList> getDataFromDB()  {
        ArrayList<DataRowList> dataRowsArrayList = new ArrayList<>();
        try (Connection connect = getJdbcConnection.getConnection()) {
            Statement statement = connect.createStatement();
            ResultSet setResult = statement.executeQuery("SELECT number, equation, roots, date FROM solutionEquation");
            while (setResult.next()) {
                DataRowList dataRowList = new DataRowList();
                dataRowList.number = setResult.getInt(1);
                dataRowList.equation = setResult.getString(2);
                dataRowList.roots = setResult.getString(3);
                dataRowList.date = setResult.getDate(4);
                dataRowsArrayList.add(dataRowList);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dataRowsArrayList;
    }
}