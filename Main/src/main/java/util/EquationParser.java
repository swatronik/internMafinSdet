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

   private static final String ARGEQUATIONPATTERN = "(?<x2>(?<a>(-|\\+)?([\\d]+\\.?[\\d]*))?x\\^2){1}(?<x>((?<b>(-|\\+)?([\\d]+\\.?[\\d]*)?)x))?(?<c>(-|\\+)?[\\d]+\\.?[\\d]*)?(=0)";

    public EquationParser(String equation) throws ParseArgumentsException {

        Pattern pattern = Pattern.compile(ARGEQUATIONPATTERN);

        Matcher matcher = pattern.matcher(equation);

        if (matcher.matches()) {
            if (matcher.group("x2").equals("-x^2")) {
                this.a = -1.0;
            } else if (matcher.group("x2").equals("x^2")) {
                this.a = 1.0;
            } else {
                this.a = Double.parseDouble(matcher.group("a"));
            }

            if (matcher.group("x") == (null) || matcher.group("x").equals("")) {
                this.b = 0.0;
            } else if (matcher.group("x").equals("+x")) {
                this.b = 1.0;
            } else if (matcher.group("x").equals("-x")) {
                this.b = -1.0;
            } else {
                this.b = Double.parseDouble(matcher.group("b"));
            }

            if (matcher.group("c") == null || matcher.group("c").equals("")) {
                this.c = 0.0;
            } else {
                this.c = Double.parseDouble(matcher.group("c"));
            }
        } else {
            throw new ParseArgumentsException(String.format("Bad arguments - this is no quadratic equation %s ", equation));
        }
    }
}
