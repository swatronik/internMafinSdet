package spring;

import db.DataBaseMySql;
import db.entity.DataBaseEquationModel;
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
import java.util.concurrent.atomic.AtomicInteger;

import static db.DataBaseMySql.getNumber;
import static db.DataBaseMySql.insertRow;
import static equations.EquationDecision.decision;
import static java.time.ZoneOffset.UTC;
import static util.Parser.parseEquation;

@Controller
public class EquationController {


    private AtomicInteger count = new AtomicInteger(getNumber());

    private static final Logger LOGGER = LoggerFactory.getLogger(EquationController.class);

    @RequestMapping("/")
    public String greeting() {
        return "equation";
    }


    @PostMapping("/quadratic")
    public ResponseEntity<String> runQuadratic(@RequestBody String equals) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
            LocalDateTime localDateTime = LocalDateTime.now(UTC);
            String date = localDateTime.format(formatter);
            Equation equation = parseEquation(equals);
            Roots decision = decision(equation);

            DataBaseEquationModel dataBaseEquationModel = new DataBaseEquationModel(count.incrementAndGet(), equation.toString(), date, decision.toString());
            insertRow(dataBaseEquationModel);

            JSONObject resultJson = new JSONObject();
            resultJson.put("count", count.get());
            resultJson.put("equation", equation.toString());
            resultJson.put("roots", decision.toString());
            resultJson.put("date", date);

            LOGGER.info(String.format("Request POST /quadratic sent: equation - %s, roots - %s, date - %s, count - %s", equation.toString(), decision.toString(), date, count.toString()));
            return ResponseEntity.ok().body(resultJson.toString());
        } catch (ParseException | NumberFormatException e) {
            LOGGER.error(e.getMessage());
            JSONObject resultJson = new JSONObject();
            resultJson.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(resultJson.toString());
        }

    }
}

