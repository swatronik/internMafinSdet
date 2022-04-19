package util;

import exceptions.ParseArgumentsException;
import org.apache.commons.cli.*;

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

    public ParserArgumentsUtil(String[] args) throws ParseException, NumberFormatException, ParseArgumentsException {

        if (args.length != 6) {
            throw new ParseArgumentsException(String.format("Bad arguments %s ", args));
        }

        if (args.length == 6) {
            try {
                Option countA = new Option("a", "koeff a", true, "define a koef");
                Option countB = new Option("b", "koeff b", true, "define b koef");
                Option countC = new Option("c", "koeff c", true, "define c koef");

                Options options = new Options();

                options.addOption(countA);
                options.addOption(countB);
                options.addOption(countC);

                CommandLineParser parser = new DefaultParser();
                CommandLine line = parser.parse(options, args);

                if (line.hasOption("a")) {
                    this.a = Double.parseDouble(line.getOptionValue("a"));
                }
                if (line.hasOption("b")) {
                    this.b = Double.parseDouble(line.getOptionValue("b"));
                }
                if (line.hasOption("c")) {
                    this.c = Double.parseDouble(line.getOptionValue("c"));
                }
            } catch (ParseException e) {
                throw new ParseException(String.format("Failed to read arguments %s ", args));
            } catch (NumberFormatException e) {
                throw new NumberFormatException(String.format("Invalid value of argument %s ", args));
            }
        }
    }
}
