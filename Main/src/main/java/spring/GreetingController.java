package spring;

import equation.Equation;
import equation.SolutionEquation;
import exception.ExceptionMessage;
import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;
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

    //@RequestMapping - нужен чтобы задать адрес методам контроллера
    //value - предназначен для указания адреса
    //method - определяет метод доступа. Варианты - RequestMethod.GET, POST, DELETE

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String greetingSubmit(Model model) {
        return "index"; //возвращаем класс\тело хтмл страницы из templates
    }

    //добавили /getV/{equals} ??????
    @GetMapping(value = "/getV/{equals}", headers = {"Accept=*/*"}) //Accept - без этого не работает
    public ResponseEntity<String> getMethod1(@PathVariable("equals") String equals) throws ExceptionMessage {

        System.out.println(equals);

        Equation equation = PatternEquation.getFullEquation(equals);
        SolutionEquation.solution(equation.getA(), equation.getB(), equation.getC());

        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(SolutionEquation.solution(equation.getA(), equation.getB(), equation.getC()));
    }









    //для работы с джейсонами использовать либу Gson
    @PostMapping(value = "/postV", headers = {"Accept=*/*"})
    public ResponseEntity postMethod1(@RequestBody String body) {
        //как вывести в джейсон формате ответ
        JSONObject responseBody = new JSONObject();

        //тут надо вставить решение уравнения и вытащить отдельно корни

        //тут надо записать корни ответа в джейсон формат
        responseBody
                .put("x1", 3)
                .put("x2", 4);

//        //как сделать массив обьектов
//        JSONArray jsonArray = new JSONArray();
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(responseBody.toString());
    }


//    //пример запроса - работает
//    @GetMapping("/hello")
//    ResponseEntity<String> hello() {
//        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
//   }

//    @GetMapping("/age")
//    ResponseEntity<String> age(
//            @RequestParam("yearOfBirth") int yearOfBirth) {
//
//        if (isInFuture(yearOfBirth)) {
//            return new ResponseEntity<>(
//                    "Year of birth cannot be in the future",
//                    HttpStatus.BAD_REQUEST);
//        }
//
//        return new ResponseEntity<>(
//                "Your age is " + calculateAge(yearOfBirth),
//                HttpStatus.OK);
//    }


}
