package util;

import equation.Equation;
import exception.ExceptionMessage;
import org.apache.commons.cli.*;

public class ParserArgumentUtil {

    public static Equation parserArgument(String[] args) throws ParseException, ExceptionMessage {

        Equation equation;

        Options options = new Options();

        Option argA = new Option("a", "value a", true, "select a");
        Option argB = new Option("b", "value b", true, "select b");
        Option argC = new Option("c", "value c", true, "select c");
        Option parseFullEquation = new Option("eq", "equation", true, "select full equation");

        options.addOption(argA);
        options.addOption(argB);
        options.addOption(argC);
        options.addOption(parseFullEquation);

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);

        if (cmd.hasOption("eq")) {
            equation = PatternEquation.getEquation(cmd); //получили целое уравнение при eq
        } else if (cmd.hasOption("a") || cmd.hasOption("b") || cmd.hasOption("c")) {
            equation = PatternEquation.getArgs(cmd); //получили аргументы абс при a
        } else
            throw new ExceptionMessage("неверный аргумент, надо а - б - с или eq");

        return equation;
    }
}

