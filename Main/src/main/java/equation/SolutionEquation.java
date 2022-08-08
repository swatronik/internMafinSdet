package equation;

import static java.lang.Math.sqrt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SolutionEquation {

    public static Logger logger = LoggerFactory.getLogger(SolutionEquation.class);

    @Override
    public String toString() {
        return super.toString();
    }

    public static String solution(double a, double b, double c) {
        double discriminant = b * b - 4 * a * c;
        logger.info("discriminant = " + discriminant);

        if (discriminant == 0) {
            logger.info("discriminant = 0, get one root");
            double x = -b / (2 * a);
            logger.info("root = " + x);

            return "root = " + x;

        } else if (discriminant > 0) {
            logger.info("discriminant is positive, get two roots");
            double x1 = (-b + sqrt(discriminant)) / (2 * a);
            double x2 = (-b - sqrt(discriminant)) / (2 * a);
            logger.info("root 1 = " + x1);
            logger.info("root 2 = " + x2);

            return "root 1 = " + x1 + "root 2 = " + x2;

        } else
            logger.info("discriminant is negative, no roots");
        return "discriminant is negative, no roots";
    }
}
