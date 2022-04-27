package util;

import constants.Constan;
import exceptions.ParseArgumentsException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class EquationParser {
    private final double a = 0.0;
    private final double b = 0.0;
    private final double c = 0.0;

    Equation equation = new Equation(a, b, c);

    public EquationParser(String equation) throws ParseArgumentsException {

        Pattern pattern = Pattern.compile(Constan.ARG_EQUATION_PATTERN);

        Matcher matcher = pattern.matcher(equation);

        if (matcher.matches()) {
            if (matcher.group(1).equals("-")) {
                this.equation.setA(-1.0);
            } else if (matcher.group(1).equals("+")) {
                this.equation.setA(1.0);
            } else {
                this.equation.setA(Double.parseDouble(matcher.group(1)));
            }

            if (matcher.group(6) == (null) || matcher.group(6).equals("")) {
                this.equation.setB(0.0);
            } else if (matcher.group(6).equals("+")) {
                this.equation.setB(1.0);
            } else if (matcher.group(6).equals("-")) {
                this.equation.setB(-1.0);
            } else {
                this.equation.setB(Double.parseDouble(matcher.group(6)));
            }

            if (matcher.group(9) == null || matcher.group(9).equals("")) {
                this.equation.setC(0.0);
            } else {
                this.equation.setB(Double.parseDouble(matcher.group(9)));
            }
        } else {
            throw new ParseArgumentsException(String.format("Bad arguments - this is no quadratic equation %s ", equation));
        }
    }
}
