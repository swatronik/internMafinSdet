package util;

import equation.Equation;
import exception.ExceptionMessage;
import org.apache.commons.cli.*;

public class ParserArgumentUtil {

    public static Equation parserArgument(String[] args) throws ExceptionMessage, ParseException {

        Equation equation;
        Options options = new Options();

        Option argA = new Option("a", "value a", true, "select argument a");
        Option argB = new Option("b", "value b", true, "select argument b");
        Option argC = new Option("c", "value c", true, "select argument c");
        Option parseFullEquation = new Option("eq", "equation", true, "select full equation");

        options.addOption(argA);
        options.addOption(argB);
        options.addOption(argC);
        options.addOption(parseFullEquation);

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);

        if (cmd.hasOption("eq")) {
            String eq = cmd.getOptionValue("eq");
            equation = PatternEquation.getFullEquation(eq); //получили целое уравнение при eq
        } else if (cmd.hasOption("a") || cmd.hasOption("b") || cmd.hasOption("c")) {
            equation = PatternEquation.getArgs(cmd); //получили аргументы а-б-с при a
        } else
            throw new ExceptionMessage("неверный аргумент, надо а - б - с или eq");

        return equation;
    }
}

