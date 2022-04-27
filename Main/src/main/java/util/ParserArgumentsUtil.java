package util;

import exceptions.ParseArgumentsException;
import org.apache.commons.cli.*;

public class ParserArgumentsUtil {

    private final double a = 0.0;
    private final double b = 0.0;
    private final double c = 0.0;

    Equation equation = new Equation(a, b, c);

    public Equation getEquation() {
        return equation;
    }

    public ParserArgumentsUtil(String[] args) throws ParseException, NumberFormatException {

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
                    EquationParser eqArgs = new EquationParser(line.getOptionValue("e"));
                    this.equation.setA(eqArgs.equation.getA());
                    this.equation.setB(eqArgs.equation.getB());
                    this.equation.setC(eqArgs.equation.getC());
                }

            } else if (type.equals("coefficient")) {
                ArgumentsParser parseArguments = new ArgumentsParser(line);
                this.equation.setA(parseArguments.equation.getA());
                this.equation.setB(parseArguments.equation.getB());
                this.equation.setC(parseArguments.equation.getC());

            } else
                throw new ParseArgumentsException(String.format("Bad arguments, provide correct type %s ", args));

        } catch (NumberFormatException e) {
            throw new NumberFormatException(String.format("Invalid value of argument %s ", args));
        }

    }
}
