package util;

import constants.Const;
import equations.Equation;
import exceptions.ParseArgumentsException;
import org.apache.commons.cli.CommandLine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    public static Equation parseEquation(CommandLine line) throws ParseArgumentsException {

        Pattern pattern = Pattern.compile(Const.ARG_EQUATION_PATTERN);

        String eq = line.getOptionValue("e");

        Matcher matcher = pattern.matcher(eq);

        if (matcher.matches()) {
            double a;
            double b;
            double c;

            if (matcher.group(2).equals("-")) {
                a = -1.0;
            } else if (matcher.group(2) == (null) || matcher.group(2).equals("") || (matcher.group(2).equals("+"))) {
                a = 1;
            } else {
                a = Double.parseDouble(matcher.group(2));
            }

            if (matcher.group(7) == (null) || matcher.group(7).equals("")) {
                b = 0.0;
            } else if (matcher.group(7).equals("+")) {
                b = 1.0;
            } else if (matcher.group(7).equals("-")) {
                b = -1.0;
            } else {
                b = Double.parseDouble(matcher.group(7));
            }

            if (matcher.group(10) == null || matcher.group(10).equals("")) {
                c = 0.0;
            } else {
                c = Double.parseDouble(matcher.group(10));
            }
            return new Equation(a, b, c);
        } else {
            throw new ParseArgumentsException(String.format("Bad arguments - this is no quadratic equation %s ", eq));
        }
    }

    public static Equation parseArgs(CommandLine line) throws ParseArgumentsException {
        double a;
        double b;
        double c;
        if (line.hasOption("a")) {
            a = Double.parseDouble(line.getOptionValue("a"));
        } else
            throw new ParseArgumentsException(String.format("Bad arguments - this is no quadratic equation %s ", line.toString()));
        if (line.hasOption("b")) {
            b = Double.parseDouble(line.getOptionValue("b"));
        } else
            throw new ParseArgumentsException(String.format("Bad arguments - this is no quadratic equation %s ", line.toString()));
        if (line.hasOption("c")) {
            c = Double.parseDouble(line.getOptionValue("c"));
        } else
            throw new ParseArgumentsException(String.format("Bad arguments - this is no quadratic equation %s ", line.toString()));
        return new Equation(a, b, c);
    }
}
