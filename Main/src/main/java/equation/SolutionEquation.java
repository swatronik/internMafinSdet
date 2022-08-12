package equation;

import static java.lang.Math.sqrt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SolutionEquation {

    public static Logger logger = LoggerFactory.getLogger(SolutionEquation.class);

    public static String solution(Equation equation) {

        Double a = equation.getA();
        Double b = equation.getB();
        Double c = equation.getC();

        Double discriminant = b * b - 4 * a * c;
        logger.info("discriminant равен = " + discriminant);

        if (discriminant == 0) {
            logger.info("discriminant равен = 0, получаем 1 корень");
            Double x = -b / (2 * a);
            logger.info("root = " + x);

            return "root = " + x;

        } else if (discriminant > 0) {
            logger.info("discriminant is positive, get two roots");
            Double x1 = (-b + sqrt(discriminant)) / (2 * a);
            Double x2 = (-b - sqrt(discriminant)) / (2 * a);
            logger.info("root 1 = " + x1, "root 2 = " + x2);

            return "root 1 = " + x1 + " root 2 = " + x2;

        } else
            logger.info("discriminant is negative, no roots");
        return "discriminant is negative, no roots";
    }
}
