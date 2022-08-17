package spring;

import equation.Equation;
import equation.SolutionEquation;
import exception.ExceptionMessage;
import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import util.ParserArgumentUtil;
import util.PatternEquation;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class GreetingController {

    public static Logger logger = LoggerFactory.getLogger(SolutionEquation.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String greetingSubmit(Model model) {
        return "index";
    }

    private int count = 1;

    @PostMapping(value = "/postEqualsEquation", headers = {"Accept=*/*"})
    public ResponseEntity<String> postEqualsEquation(@RequestBody String equals) throws ExceptionMessage {

        Date dateNow = new Date();
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //SimpleDateFormat formatForDateNow = new SimpleDateFormat("E yyyy.MM.dd 'и время' hh:mm:ss a zzz");
        String date = ("Текущая дата " + formater.format(dateNow));
        logger.info(date);


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