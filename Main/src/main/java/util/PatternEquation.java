package util;

import equation.Equation;
import exception.ExceptionMessage;
import org.apache.commons.cli.CommandLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import patternRegexp.PatternRegexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternEquation {

    public static Logger logger = LoggerFactory.getLogger(PatternEquation.class);

    //Метод для парсинга значений целого уравнения и его проверки через шаблон регексп
    public static Equation getFullEquation(String eq) throws ExceptionMessage {
        Pattern pattern = Pattern.compile(PatternRegexp.patternEquation);
        Matcher matcher = pattern.matcher(eq);

        if (matcher.matches()) {
            logger.info("Введенное уравнение проходит проверку шаблона регулярки - ок");
            double a = Double.parseDouble(matcher.group(2));
            double b = Double.parseDouble(matcher.group(5));
            double c = Double.parseDouble(matcher.group(8));
            return new Equation(a, b, c);
        } else {
            logger.info("Введенное уравнение НЕ проходит проверку шаблона регулярки - не ок");
            throw new ExceptionMessage("The equation you entered does NOT pass the regExp pattern test");
        }
    }

    //метод для парсинга значений аргументов
    public static Equation getArgs(CommandLine cmd) {
        double a = Double.parseDouble(cmd.getOptionValue("a"));
        double b = Double.parseDouble(cmd.getOptionValue("b"));
        double c = Double.parseDouble(cmd.getOptionValue("c"));
        return new Equation(a, b, c);
    }
}