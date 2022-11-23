package spring;

import equation.Equation;
import equation.Roots;
import equation.SolutionEquation;
import exception.ExceptionMessage;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import util.PatternEquation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class EquationController {

    public static Logger logger = LoggerFactory.getLogger(EquationController.class);

    public AtomicInteger countRequest = new AtomicInteger(0);

    @PostMapping(value = "/postEqualsEquation", headers = {"Accept=*/*"})
    public ResponseEntity<String> postEqualsEquation(@RequestBody String equals) throws ExceptionMessage {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("Время: HH:mm:ss Дата: dd.MM.yyyy");
        LocalDateTime localDateTime = LocalDateTime.now();
        String date = localDateTime.format(formatter);
        Equation equation = PatternEquation.getFullEquation(equals);
        Roots solution = SolutionEquation.solution(equation);

        logger.info(String.format("Получено уравнение на вход: %s Распарсили уравнение на вход: %s Получено решение уравнения: %s Генерируем текущую дату по шаблону: %s",
                equals, equation, solution, date));

        int numberDecision = countRequest.incrementAndGet();

        JSONObject responseJSON = new JSONObject();
        responseJSON.put("number", numberDecision);
        responseJSON.put("equation", equation.toString());
        responseJSON.put("roots", solution.toString());
        responseJSON.put("date", date);

        return ResponseEntity.ok().body(responseJSON.toString());
    }
}