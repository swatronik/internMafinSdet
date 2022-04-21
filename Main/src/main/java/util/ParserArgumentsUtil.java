package util;

import exceptions.ParseArgumentsException;
import org.apache.commons.cli.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserArgumentsUtil {

    private String equation = "";
    private String type = "";
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

            if (line.hasOption("type")) {
                this.type = line.getOptionValue("type");
            } else
                throw new ParseArgumentsException(String.format("Bad arguments %s ", args));

            if (type.equals("equation")) {
                if (line.hasOption("e")) {

                    this.equation = line.getOptionValue("e");
                    String argEquationPattern = "\\-?[0-9]+\\.?[0-9]*x\\^2|-|\\+|\\-?[0-9]+\\.?[0-9]*x|-|\\+|[0-9]*\\.?[0-9]*=0";

                    Pattern pattern = Pattern.compile(argEquationPattern);

                    Matcher matcher = pattern.matcher(equation);

                    if (matcher.find()) {

                        String argAPattern = "\\-?[0-9]*\\.?[0-9]*(?=x\\^2)";
                        String argBPattern = "(-|\\+)\\-?[0-9]*\\.?[0-9]*(?=x\\+|-|=)";
                        String argCPattern = "(-|\\+)[0-9]*\\.?[0-9]*(?==0)";

                        Pattern patternA = Pattern.compile(argAPattern);
                        Pattern patternB = Pattern.compile(argBPattern);
                        Pattern patternC = Pattern.compile(argCPattern);

                        Matcher matcherA = patternA.matcher(equation);
                        matcherA.find();
                        Matcher matcherB = patternB.matcher(equation);
                        matcherB.find();
                        Matcher matcherC = patternC.matcher(equation);
                        matcherC.find();

                        if (matcherA.group().equals("-")) {
                            this.a = -1.0;
                        } else {
                            this.a = Double.parseDouble(matcherA.group());
                        }

                        if (matcherB.group().equals("-")) {
                            this.b = -1.0;
                        } else {
                            this.b = Double.parseDouble(matcherB.group());
                        }

                        this.c = Double.parseDouble(matcherC.group());

                    } else throw new ParseArgumentsException(String.format("Bad arguments %s ", args));
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
            } else throw new ParseArgumentsException(String.format("Bad arguments %s ", args));

        } catch (ParseException e) {
            throw new ParseException(String.format("Failed to read arguments %s ", args));
        } catch (NumberFormatException e) {
            throw new NumberFormatException(String.format("Invalid value of argument %s ", args));
        }

    }
}
