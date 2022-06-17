package util;

import equations.Equation;
import exceptions.ParseArgumentsException;
import org.apache.commons.cli.*;

public class ParserArgumentsUtil {


    public static Equation parserArgumentsUtil(String[] args) throws ParseException, NumberFormatException {

        Equation equation;

        if (args.length == 0) {
            throw new ParseArgumentsException(String.format("No arguments ", args));
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
                    String eq=line.getOptionValue("e");
                    equation=Parser.parseEquation(eq);

                } else
                    throw new ParseArgumentsException(String.format("Bad arguments, provide correct type %s ", args));

            } else if (type.equals("coefficient")) {
                double a;
                double b;
                double c;
                if (line.hasOption("a")) {
                    a = Double.parseDouble(line.getOptionValue("a"));
                } else
                    throw new ParseArgumentsException(String.format("Bad arguments - this is no quadratic equation \"a\" is %s", line.getOptionValue("a")));
                if (line.hasOption("b")) {
                    b = Double.parseDouble(line.getOptionValue("b"));
                } else
                    b = 0.0;
                if (line.hasOption("c")) {
                    c = Double.parseDouble(line.getOptionValue("c"));
                } else
                    c = 0.0;
                return new Equation(a, b, c);

            } else
                throw new ParseArgumentsException(String.format("Bad arguments, provide correct type %s ", args));

        } catch (NumberFormatException e) {
            throw new NumberFormatException(String.format("Invalid value of argument %s ", args));
        }
        return equation;
    }
}
