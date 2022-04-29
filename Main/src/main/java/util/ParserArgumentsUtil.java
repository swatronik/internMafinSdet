package util;

import equations.Equation;
import exceptions.ParseArgumentsException;
import org.apache.commons.cli.*;

public class ParserArgumentsUtil {


    public static Equation parserArgumentsUtil(String[] args) throws ParseException, NumberFormatException {

        Equation equation;

        if (args.length == 0) {
            throw new ParseArgumentsException(String.format("Bad arguments %s ", args));
        }
        try {

            Options options = new Options();
            Option optionType = new Option("type", "type of arguments", true, "type of arguments");
            Option countA = new Option("a", "koeff a", true, "define a koef");
            Option countB = new Option("b", "koeff b", true, "define b koef");
            Option countC = new Option("c", "koeff c", true, "define c koef");
            Option optionEquation = new Option("e", "equation", true, "define equation");

            options.addOption(optionEquation);
            options.addOption(countA);
            options.addOption(countB);
            options.addOption(countC);
            options.addOption(optionType);

            CommandLineParser parser = new DefaultParser();
            CommandLine line = parser.parse(options, args);

            String type = "";

            if (line.hasOption("type")) {
                type = line.getOptionValue("type");
            } else
                throw new ParseArgumentsException(String.format("Bad arguments - no type %s  ", args));

            if (type.equals("equation")) {
                if (line.hasOption("e")) {
                    equation = Parser.parseEquation(line);
                } else
                    throw new ParseArgumentsException(String.format("Bad arguments, provide correct type %s ", args));

            } else if (type.equals("coefficient")) {
                equation = Parser.parseArgs(line);

            } else
                throw new ParseArgumentsException(String.format("Bad arguments, provide correct type %s ", args));

        } catch (NumberFormatException e) {
            throw new NumberFormatException(String.format("Invalid value of argument %s ", args));
        }
        return equation;
    }
}
