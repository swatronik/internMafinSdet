package spring;

import equations.Equation;
import equations.Roots;
import org.apache.commons.cli.ParseException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static equations.EquationDecision.decision;
import static java.time.ZoneOffset.UTC;
import static util.Parser.parseEquation;

@Controller
public class EquationController {

    private int count = 1;

    private static final Logger LOGGER = LoggerFactory.getLogger(EquationController.class);

    @RequestMapping("/")
    public String greeting() {
        return "equation";
    }


    @PostMapping("/quadratic/")
    public ResponseEntity<String> runQuadratic(@RequestBody String equals) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
            LocalDateTime localDateTime = LocalDateTime.now(UTC);
            String date = localDateTime.format(formatter);
            Equation equation = parseEquation(equals);
            Roots decision = decision(equation);

            JSONObject resultJson = new JSONObject();
            resultJson.put("equation", equation.toString());
            resultJson.put("roots", decision.toString());
            resultJson.put("date", date);
            resultJson.put("count", count);

            count++;

            LOGGER.info(equation.toString());
            LOGGER.info(decision.toString());
            LOGGER.info(date);
            return ResponseEntity.ok().body(resultJson.toString());
        } catch (ParseException | NumberFormatException e) {
            LOGGER.error(e.getMessage());
            JSONObject resultJson = new JSONObject();
            resultJson.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(resultJson.toString());
        }

    }
}

