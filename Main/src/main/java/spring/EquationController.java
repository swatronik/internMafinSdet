package spring;

import equations.Equation;
import equations.Roots;
import exceptions.ParseArgumentsException;
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

    @GetMapping("/abc/{equals}")
    public ResponseEntity<String> run(@PathVariable("equals") String equals) throws ParseArgumentsException {
        Equation equation = parseEquation(equals);
        Roots desicion = decision(equation);
        return ResponseEntity.ok().body(desicion.toString());
    }
}

