package spring;

import equations.EquationDecision;
import equations.Roots;
import org.apache.commons.cli.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static util.Parser.parseEquation;

@Controller
public class EquationController {

    @RequestMapping("/")
    public String greeting() {
        return "equation";
    }

//    @PostMapping("/")
//    public String postEquation(@RequestParam String equation)throws ParseException, NumberFormatException{
//        Roots equationDecision=EquationDecision.decision(parseEquation(equation));
//        System.out.println(equationDecision);
//        return "equation";

}

