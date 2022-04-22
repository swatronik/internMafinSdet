package util;

import exceptions.ParseArgumentsException;
import org.apache.commons.cli.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserArgumentsUtil {

    private double a = 0.0;
    private double b = 0.0;
    private double c = 0.0;

    public double getA() {
        return a;
    }

    public double getC() {
        return c;
    }

    public double getB() {
        return b;
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

                    String equation = "";
                    equation = line.getOptionValue("e");
                    String argEquationPattern = "(((-|\\+)?[0-9]*\\.?[0-9]*)x\\^2){1}(((-|\\+)?[0-9]*\\.?[0-9]*)x)?((-|\\+)?[0-9]*\\.?[0-9]*)?(=0)";

                    Pattern pattern = Pattern.compile(argEquationPattern);

                    Matcher matcher = pattern.matcher(equation);

                    if (matcher.matches()) {

                        if (matcher.group(1).equals("-x^2")) {
                            this.a = -1.0;
                        } else if (matcher.group(1).equals("x^2")) {
                            this.a = 1.0;
                        } else {
                            this.a = Double.parseDouble(matcher.group(2));
                        }

                        if (matcher.group(4) == (null) || matcher.group(4).equals("")) {
                            this.b = 0.0;
                        } else if (matcher.group(4).equals("+x")) {
                            this.b = 1.0;
                        } else if (matcher.group(4).equals("-x")) {
                            this.b = -1.0;
                        } else {
                            this.b = Double.parseDouble(matcher.group(5));
                        }

                        if (matcher.group(7) == null || matcher.group(7).equals("")) {
                            this.c = 0.0;
                        } else {
                            this.c = Double.parseDouble(matcher.group(7));
                        }
                    } else
                        throw new ParseArgumentsException(String.format("Bad arguments - this is no quadratic equation %s ", args));
                }
            } else if (type.equals("coefficient")) {
                if (line.hasOption("a")) {
                    this.a = Double.parseDouble(line.getOptionValue("a"));
                }
                if (line.hasOption("b")) {
                    this.b = Double.parseDouble(line.getOptionValue("b"));
                }
                if (line.hasOption("c")) {
                    this.c = Double.parseDouble(line.getOptionValue("c"));
                }
            } else throw new ParseArgumentsException(String.format("Bad arguments, provide correct type %s ", args));

        } catch (NumberFormatException e) {
            throw new NumberFormatException(String.format("Invalid value of argument %s ", args));
        }

    }
}
