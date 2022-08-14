package equation;

import static java.lang.Math.sqrt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SolutionEquation {

    public static Logger logger = LoggerFactory.getLogger(SolutionEquation.class);

    public static Roots solution(Equation equation) {

        Double a = equation.getA();
        Double b = equation.getB();
        Double c = equation.getC();

        Double discriminant = b * b - 4 * a * c;
        logger.info("discriminant равен = " + discriminant);

        if (discriminant == 0) {
            logger.debug("discriminant равен = 0, получаем 1 корень");
            return new Roots(-b / (2 * a));

        } else if (discriminant > 0) {
            logger.debug("discriminant is positive, get two roots");
            return new Roots((-b + sqrt(discriminant)) / (2 * a), (-b - sqrt(discriminant)) / (2 * a));

        } else
            logger.debug("discriminant is negative, no roots");
            return new Roots();
    }
}
