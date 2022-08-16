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

@Controller
public class GreetingController {

    public static Logger logger = LoggerFactory.getLogger(SolutionEquation.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String greetingSubmit(Model model) {
        return "index";
    }

    @PostMapping(value = "/postEqualsEquation", headers = {"Accept=*/*"})
    public ResponseEntity<String> postEqualsEquation(@RequestBody String equals) throws ExceptionMessage {

        Equation equation = PatternEquation.getFullEquation(equals);
        String solution = String.valueOf(SolutionEquation.solution(equation));

        logger.info(equals);
        logger.info(String.valueOf(equation));
        logger.info(solution);

        JSONObject responseJSON = new JSONObject();
        responseJSON.put("equation", equation.toString());

        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(solution);
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