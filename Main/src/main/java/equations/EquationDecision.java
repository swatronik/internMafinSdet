package equations;

import static java.lang.Math.sqrt;

public class EquationDecision {


    public static double[] decision(Equation equation) throws NumberFormatException {

        double disc = equation.getB() * equation.getB() - 4 * equation.getA() * equation.getC();

        if (disc > 0) {
            double root1 = (-equation.getB() - sqrt(disc)) / (2 * equation.getA());
            double root2 = (-equation.getB() + sqrt(disc)) / (2 * equation.getA());
            return new double[]{root1, root2};
        } else if (disc == 0) {
            double root = -equation.getB() / (2 * equation.getA());
            return new double[]{root};
        } else {
            return null;
        }
    }
}

