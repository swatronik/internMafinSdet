package util;

import equation.Equation;
import exception.ExceptionMessage;
import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParserArgumentUtil {

    public static Logger logger = LoggerFactory.getLogger(ParserArgumentUtil.class);

    public static Equation parserArgument(String[] args) throws ExceptionMessage, ParseException {
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
            logger.info("Получили целое уравнение при eq " + eq);
            return PatternEquation.getFullEquation(eq);
        } else if (cmd.hasOption("a") && cmd.hasOption("b") && cmd.hasOption("c")) {
            logger.info("Получили аргументы а-б-с");
            return PatternEquation.getArgs(cmd);
        } else {
            throw new ExceptionMessage("неверный аргумент, надо а - б - с или eq");
        }
    }
}

