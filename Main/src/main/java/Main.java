import equation.Equation;
import exception.ExceptionMessage;
import org.apache.commons.cli.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Math.sqrt;

public class Main {

    public static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws ParseException, ExceptionMessage {

        ParserArgument parserArgument = new ParserArgument(args);

        double a = PatternEquation.getEquation(parserArgument.getEq()).getA();
        double b = PatternEquation.getEquation(parserArgument.getEq()).getB();
        double c = PatternEquation.getEquation(parserArgument.getEq()).getC();

        double discriminant = b * b - 4 * a * c;
        logger.info("discriminant = " + discriminant);

        try {
            if (discriminant == 0) {
                logger.info("discriminant = 0, get one root");
                double x = -b / (2 * a);
                logger.info("root = " + x);
            } else if (discriminant > 0) {
                logger.info("discriminant is positive, get two roots");
                double x1 = (-b + sqrt(discriminant)) / (2 * a);
                double x2 = (-b - sqrt(discriminant)) / (2 * a);
                logger.info("root 1 = " + x1);
                logger.info("root 2 = " + x2);
            } else
                logger.info("discriminant is negative, no roots");
        } catch (Exception exp) {
            logger.error(exp.getMessage());
        }
    }
}


//как было: под аргументы а б с
//        double discriminant = parserArgument.getB() * parserArgument.getB() - 4 * parserArgument.getA() * parserArgument.getC();
//        logger.info("discriminant = " + discriminant);
//
//        try {
//            if (discriminant == 0) {
//                logger.info("discriminant = 0, get one root");
//                double x = -parserArgument.getB() / (2 * parserArgument.getA());
//                logger.info("root = " + x);
//            } else if (discriminant > 0) {
//                logger.info("discriminant is positive, get two roots");
//                double x1 = (-parserArgument.getB() + sqrt(discriminant)) / (2 * parserArgument.getA());
//                double x2 = (-parserArgument.getB() - sqrt(discriminant)) / (2 * parserArgument.getA());
//                logger.info("root 1 = " + x1);
//                logger.info("root 2 = " + x2);
//            } else
//                logger.info("discriminant is negative, no roots");
//        } catch (Exception exp) {
//            logger.error(exp.getMessage());
//        }