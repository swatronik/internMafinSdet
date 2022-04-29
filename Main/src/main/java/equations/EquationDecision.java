package equations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Math.sqrt;

public class EquationDecision {

    private static final Logger LOGGER = LoggerFactory.getLogger(EquationDecision.class);


    public static void decision(Equation equation) throws NumberFormatException {

        double disc = equation.getB() * equation.getB() - 4 * equation.getA() * equation.getC();

        if (disc > 0) {
            double root1 = (-equation.getB() - sqrt(disc)) / (2 * equation.getA());
            double root2 = (-equation.getB() + sqrt(disc)) / (2 * equation.getA());
            LOGGER.info("Result of quadratic equation is: 1st root={} 2nd root={}", root1, root2);
        } else if (disc == 0) {
            double root = -equation.getB() / (2 * equation.getA());
            LOGGER.info("Result of quadratic equation is: root={}", root);
        } else
            LOGGER.info("There are no roots");
    }
}

