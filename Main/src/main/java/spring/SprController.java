package spring;

import equation.Equation;
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

@org.springframework.stereotype.Controller
public class SprController {

    public static Logger logger = LoggerFactory.getLogger(SprController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String greetingSubmit(Model model) {
        return "index";
    }

    private int count = 1;

    @PostMapping(value = "/postEqualsEquation", headers = {"Accept=*/*"})
    public ResponseEntity<String> postEqualsEquation(@RequestBody String equals) throws ExceptionMessage {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("Дата: dd.MM.yyyy Время: HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String date = localDateTime.format(formatter);
        logger.debug("DateTimeFormatter выводит дату: " + date);

        Equation equation = PatternEquation.getFullEquation(equals);
        String solution = String.valueOf(SolutionEquation.solution(equation));

        logger.info(equals);
        logger.info(String.valueOf(equation));
        logger.info(solution);
        logger.info(date);

        JSONObject responseJSON = new JSONObject();
        responseJSON.put("number", count);
        responseJSON.put("equation", equation.toString());
        responseJSON.put("roots", solution);
        responseJSON.put("date", date);
        count++;

        return ResponseEntity
                .ok()
                //.contentType(MediaType.APPLICATION_JSON)
                .body(responseJSON.toString());
    }
}


// Кусок работоспособного кода на метод GET
//    @GetMapping(value = "/getEquals/{equals}", headers = {"Accept=*/*"}) //Accept - без этого не работает
//    public ResponseEntity<String> getEquals(@PathVariable("equals") String equals) throws ExceptionMessage {
//
//        Equation equation = PatternEquation.getFullEquation(equals);
//        String solution = String.valueOf(SolutionEquation.solution(equation));
//
//        logger.info(equals);
//        logger.info(String.valueOf(equation));
//        logger.info(solution);
//
//        return ResponseEntity
//                .ok()
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(solution);
//    }