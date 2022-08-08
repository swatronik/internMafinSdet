package spring;

import equations.Equation;
import equations.Roots;
import org.apache.commons.cli.ParseException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static equations.EquationDecision.decision;
import static util.Parser.parseEquation;

@Controller
public class EquationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EquationController.class);

    @RequestMapping("/")
    public String greeting() {
        return "equation";
    }

    @PostMapping("/quadratic/{equals}")
    public ResponseEntity<String> runQuadratic(@PathVariable(value = "equals") String equals) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
            LocalDateTime localDateTime = LocalDateTime.now();
            String date = localDateTime.format(formatter);
            Equation equation = parseEquation(equals);
            Roots decision = decision(equation);

            JSONObject resultJson = new JSONObject();
            JSONArray ar = new JSONArray();
            if (decision.getCountRoot() == Roots.CountRoot.ONE_ROOT) {
                ar.put(0, decision.getX1());
            }
            if (decision.getCountRoot() == Roots.CountRoot.TWO_ROOTS) {
                ar.put(0, decision.getX1());
                ar.put(1, decision.getX2());
            }
            resultJson.put("equation", equation.toString());
            resultJson.put("roots", ar);
            resultJson.put("date", date);

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

