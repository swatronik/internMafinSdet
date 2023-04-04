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
            Double x1 = -b / (2 * a);
            logger.info("root = " + x1);
            return new Roots(x1);

        } else if (discriminant > 0) {
            logger.debug("discriminant is positive, get two roots");
            Double x1 = (-b + sqrt(discriminant)) / (2 * a);
            Double x2 = (-b - sqrt(discriminant)) / (2 * a);
            logger.info(String.format("Root 1: %s Root 2: %s", x1, x2));
            logger.debug("Temperature set to {}. Old value was {}.", x1, x2);
            return new Roots(x1, x2);
        } else logger.debug("discriminant is negative, no roots");
        return new Roots();
    }
}