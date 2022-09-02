package db;

import db.entity.DataBaseEquationModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataBaseMySql {

    private static final JDBC db = new JDBC();

    public static int getNumber() {
        int number = 0;
        try (Connection dbConnection = db.getDbConnection()) {
            Statement statement = dbConnection.createStatement();
            ResultSet set = statement.executeQuery("select count(Numb) from equations");
            set.next();
            number = set.getInt(1);
            return number;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return number;
    }

    public static void insertRow(DataBaseEquationModel dataBaseEquationModel) {
        try (Connection dbConnection = db.getDbConnection()) {
            Statement statement = dbConnection.createStatement();
            statement.executeUpdate(String.format("INSERT INTO equations (Numb,Equation,Roots,DateEq) VALUES (%d,'%s','%s','%s')",
                    dataBaseEquationModel.number, dataBaseEquationModel.quadratic, dataBaseEquationModel.roots, dataBaseEquationModel.date));

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<DataBaseEquationModel> getNumberRows(Integer number) {
        ArrayList<DataBaseEquationModel> arrayList = new ArrayList<DataBaseEquationModel>();
        try (Connection dbConnection = db.getDbConnection()) {
            Statement statement = dbConnection.createStatement();
            ResultSet set = statement.executeQuery(String.format("SELECT Numb,Equation,Roots,DateEq from equations ORDER BY Numb DESC limit %d", number));
            while (set.next()) {
                DataBaseEquationModel dataBaseEquationModel = new DataBaseEquationModel();
                dataBaseEquationModel.number = set.getInt(1);
                dataBaseEquationModel.quadratic = set.getString(2);
                dataBaseEquationModel.roots = set.getString(3);
                dataBaseEquationModel.date = set.getString(4);
                arrayList.add(dataBaseEquationModel);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
