package util;

import exceptions.ParseArgumentsException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class EquationParser {
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

   private static final String ARGEQUATIONPATTERN = "(((-|\\+)?[\\d]*\\.?[\\d]*)x\\^2){1}(((-|\\+)?[\\d]*\\.?[\\d]*)x)?((-|\\+)?[\\d]*\\.?[\\d]*)?(=0)";

    public EquationParser(String equation) throws ParseArgumentsException {

        Pattern pattern = Pattern.compile(ARGEQUATIONPATTERN);

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
        } else {
            throw new ParseArgumentsException(String.format("Bad arguments - this is no quadratic equation %s ", equation));
        }
    }
}
