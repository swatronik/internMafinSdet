package util;

import constants.Constan;
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


    public EquationParser(String equation) throws ParseArgumentsException {

        Pattern pattern = Pattern.compile(Constan.ARG_EQUATION_PATTERN);

        Matcher matcher = pattern.matcher(equation);

        if (matcher.matches()) {
            if (matcher.group(1).equals("-")) {
                this.a = -1.0;
            } else if (matcher.group(1).equals("+")) {
                this.a = 1.0;
            } else {
                this.a = Double.parseDouble(matcher.group(1));
            }

            if (matcher.group(6) == (null) || matcher.group(6).equals("")) {
                this.b = 0.0;
            } else if (matcher.group(6).equals("+")) {
                this.b = 1.0;
            } else if (matcher.group(6).equals("-")) {
                this.b = -1.0;
            } else {
                this.b = Double.parseDouble(matcher.group(6));
            }

            if (matcher.group(9) == null || matcher.group(9).equals("")) {
                this.c = 0.0;
            } else {
                this.c = Double.parseDouble(matcher.group(9));
            }
        } else {
            throw new ParseArgumentsException(String.format("Bad arguments - this is no quadratic equation %s ", equation));
        }
    }
}
