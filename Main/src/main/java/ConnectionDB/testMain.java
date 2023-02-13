package ConnectionDB;

import ConnectionDB.entity.DataRowList;
import equation.Equation;
import equation.Roots;
import equation.SolutionEquation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.PatternEquation;

public class testMain {

    public static Logger logger = LoggerFactory.getLogger(testMain.class);

    public static void main(String[] args) {
        CreateNewTable createNewTable = new CreateNewTable();
        GetDataFromDB getDataFromDB = new GetDataFromDB();
        InsertDataToDB insertDataToDB = new InsertDataToDB();



        //createNewTable.createNewTableInDB();
        insertDataToDB.insertData(new DataRowList( ));
        //getDataFromDB.getAllDataFromDB();
        //getDataFromDB.getDataOnNumber(3);

    }
}
