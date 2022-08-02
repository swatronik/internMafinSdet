package spring;

import equations.Equation;
import equations.Roots;
import org.apache.commons.cli.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static equations.EquationDecision.decision;
import static util.Parser.parseEquation;

@Controller
public class EquationController {


    @RequestMapping("/")
    public String greeting() {
        return "equation";
    }

    @GetMapping("/quadratic/{equals}")
    public ResponseEntity<String> runQuadratic(@PathVariable(value = "equals") String equals) {
        try {
            Equation equation = parseEquation(equals);
            Roots decision = decision(equation);
            return ResponseEntity.ok().body(decision.toString());
        } catch (ParseException | NumberFormatException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}

