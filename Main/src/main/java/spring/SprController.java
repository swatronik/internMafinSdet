package spring;

import equation.Equation;
import equation.Roots;
import equation.SolutionEquation;
import exception.ExceptionMessage;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import util.PatternEquation;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

import static sun.security.ssl.SSLLogger.info;

@org.springframework.stereotype.Controller
public class SprController {

    public static Logger logger = LoggerFactory.getLogger(SprController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String greetingSubmit(Model model) {
        return "index";
    }

    public AtomicInteger atomicInteger = new AtomicInteger(0);

    @PostMapping(value = "/postEqualsEquation", headers = {"Accept=*/*"})
    public ResponseEntity<String> postEqualsEquation(@RequestBody String equals) throws ExceptionMessage {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("Время: HH:mm:ss Дата: dd.MM.yyyy");
        LocalDateTime localDateTime = LocalDateTime.now();
        String date = localDateTime.format(formatter);
        logger.debug("DateTimeFormatter выводит дату: " + date);

        Equation equation = PatternEquation.getFullEquation(equals);
        Roots solution = SolutionEquation.solution(equation);

        logger.info("Получено уравнение на вход: " + equals,
                "Распарсили уравнение на вход: " + equation.toString(),
                "Получено решение уравнения: " + solution.toString(),
                "Генерируем текущую дату по шаблону: " + date);

        JSONObject responseJSON = new JSONObject();
        responseJSON.put("number", atomicInteger.incrementAndGet());
        logger.debug("атомик пишет: " + atomicInteger);
        responseJSON.put("equation", equation.toString());
        responseJSON.put("roots", solution);
        responseJSON.put("date", date);

        return ResponseEntity
                .ok()
                .body(responseJSON.toString());
    }
}