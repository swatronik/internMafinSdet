package equations;

import static java.lang.Math.sqrt;

public class EquationDecision {


    public static Roots decision(Equation equation) throws NumberFormatException {

        double disc = equation.getB() * equation.getB() - 4 * equation.getA() * equation.getC();

        if (disc > 0) {
            return new Roots((-equation.getB() - sqrt(disc)) / (2 * equation.getA()), (-equation.getB() + sqrt(disc)) / (2 * equation.getA()));

        } else if (disc == 0) {
            return new Roots((-equation.getB() / (2 * equation.getA())));

        } else {
            return new Roots();
        }
    }
}
