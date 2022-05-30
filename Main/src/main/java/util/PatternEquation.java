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

    //отдельный логгер для util.PatternEquation. Для каждого класса - отдельный логгер
    public static Logger loggerPatternEquation = LoggerFactory.getLogger(PatternEquation.class);

    //метод для парсинга значений целого уравнения и его проверки.
    public static Equation getEquation(CommandLine cmd) throws ExceptionMessage {

        Pattern pattern = Pattern.compile(PatternRegexp.patternEquation);
        Matcher matcher = pattern.matcher(cmd.getOptionValue("eq"));

        if (matcher.matches()) {
            loggerPatternEquation.info("Введенное уравнение проходит проверку шаблона регулярки - ок");

            double a;
            double b;
            double c;

            a = Double.parseDouble(matcher.group(5));
            b = Double.parseDouble(matcher.group(7));
            c = Double.parseDouble(matcher.group(10));

            return new Equation(a, b, c);
        } else {
            throw new ExceptionMessage("Введенное уравнение НЕ проходит проверку шаблона регулярки");
        }
    }

    //метод для парсинга значений аргументов
    public static Equation getArgs(CommandLine cmd) {
        double a;
        double b;
        double c;

        a = Double.parseDouble(cmd.getOptionValue("a"));
        b = Double.parseDouble(cmd.getOptionValue("b"));
        c = Double.parseDouble(cmd.getOptionValue("c"));

        return new Equation(a, b, c);
    }
}