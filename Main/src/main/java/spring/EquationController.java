package spring;

import ConnectionDB.DeleteDataFromDB;
import ConnectionDB.GetDataFromDB;
import ConnectionDB.InsertDataToDB;
import ConnectionDB.entity.DataRowList;
import com.mysql.cj.xdevapi.JsonArray;
import equation.Equation;
import equation.Roots;
import equation.SolutionEquation;
import exception.ExceptionMessage;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import util.PatternEquation;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import static ConnectionDB.GetDataFromDB.getDataOnNumberRows;
import static ConnectionDB.GetDataFromDB.getNumber;

@Controller
public class EquationController {

    public static Logger logger = LoggerFactory.getLogger(EquationController.class);

    public AtomicInteger countRequest = new AtomicInteger(getNumber());

    //как загружать данные из базы и продолжать с последнего числа

    //метод для расчета уравнения и записи ответа в БД
    @PostMapping(value = "/postEqualsEquation", headers = {"Accept=*/*"})
    public ResponseEntity<String> postEqualsEquation(@RequestBody String equals) throws ExceptionMessage {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("Время: HH:mm:ss Дата: dd.MM.yyyy");
        LocalDateTime localDateTime = LocalDateTime.now();
        String date = localDateTime.format(formatter);
        Equation equation = PatternEquation.getFullEquation(equals);
        Roots solution = SolutionEquation.solution(equation);

        logger.info(String.format("Получено уравнение на вход: %s Распарсили уравнение на вход: %s Получено решение уравнения: %s Генерируем текущую дату по шаблону: %s",
                equals, equation, solution, date));


        //получаем данные из базы и увеличиваем значение на 1
        DeleteDataFromDB deleteDataFromDB = new DeleteDataFromDB();
        int lastDataNumberFromDB = deleteDataFromDB.getLastDataFromBase();
        int numberDecision = countRequest.incrementAndGet();

        //вставка метода из JDBC для записи в БД новых данных
        InsertDataToDB.insertData(new DataRowList(numberDecision, equation.toString(), solution.toString(), date));

        JSONObject responseJSON = new JSONObject();
        responseJSON.put("number", numberDecision);
        responseJSON.put("equation", equation.toString());
        responseJSON.put("roots", solution.toString());
        responseJSON.put("date", date);

        return ResponseEntity.ok().body(responseJSON.toString());
    }

    //Метод для получения данных из БД
    @GetMapping("/getAllDataFromDB")
    public ResponseEntity<String> getAllDataFromDB() {
        JSONArray jsonArray = new JSONArray();
        ArrayList<DataRowList> allData = getDataOnNumberRows(getNumber());

        for (DataRowList dataRowList : allData) {
            JSONObject responseJSON = new JSONObject();
            responseJSON.put("number", dataRowList.number);
            responseJSON.put("equation", dataRowList.equation);
            responseJSON.put("roots", dataRowList.roots);
            responseJSON.put("date", dataRowList.date);
            jsonArray.put(responseJSON);
        }
        return ResponseEntity.ok().body(jsonArray.toString());
    }

    //Метод для удаления данных из БД
    @DeleteMapping("/deleteLastDataFromDB")
    public ResponseEntity<String> deleteLastDataFromDB() throws SQLException {

        DeleteDataFromDB deleteDataFromDB = new DeleteDataFromDB();
        deleteDataFromDB.deleteLastData();

        JSONArray jsonArray = new JSONArray();
        ArrayList<DataRowList> allData = getDataOnNumberRows(getNumber());

        for (DataRowList dataRowList : allData) {
            JSONObject responseJSON = new JSONObject();
            responseJSON.put("number", dataRowList.number);
            responseJSON.put("equation", dataRowList.equation);
            responseJSON.put("roots", dataRowList.roots);
            responseJSON.put("date", dataRowList.date);
            jsonArray.put(responseJSON);
        }
        return ResponseEntity.ok().body(jsonArray.toString());
    }


}