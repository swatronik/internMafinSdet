package ConnectionDB;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

/**
 * Данный класс служит для того чтобы тестировать работу классов, без запуска спринг приложения.
 * Оставить для тестов
 */

public class testMain {

    public static Logger logger = LoggerFactory.getLogger(testMain.class);

    public static void main(String[] args) throws SQLException {
        CreateNewTable createNewTable = new CreateNewTable();
        GetDataFromDB getDataFromDB = new GetDataFromDB();
        InsertDataToDB insertDataToDB = new InsertDataToDB();
        DeleteDataFromDB deleteDataFromDB = new DeleteDataFromDB();

//        deleteDataFromDB.getLastDataFromBase();
//        GetDataFromDB.getNumber();
//        deleteDataFromDB.deleteLastData();
//        создание таблицы в бд - работает
//        createNewTable.createNewTableInDB();
//        insertDataToDB.insertData(new DataRowList( ));

//        получить все данные из БД - работает
//        getDataFromDB.getAllDataFromDB();

//        получить данные из БД по номеру строки - работает
//        getDataFromDB.getDataOnNumberRows(4);

    }
}