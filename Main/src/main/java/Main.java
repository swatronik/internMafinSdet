import equation.Equation;
import exception.ExceptionMessage;
import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.ParserArgumentUtil;

import static java.lang.Math.sqrt;

public class Main {

    public static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws ExceptionMessage, ParseException {

        //!
        Equation equation = ParserArgumentUtil.parserArgument(args);

        double discriminant = equation.getB() * equation.getB() - 4 * equation.getA() * equation.getC();
        logger.info("discriminant = " + discriminant);

        if (discriminant == 0) {
            logger.info("discriminant = 0, get one root");
            double x = -equation.getB() / (2 * equation.getA());
            logger.info("root = " + x);
        } else if (discriminant > 0) {
            logger.info("discriminant is positive, get two roots");
            double x1 = (-equation.getB() + sqrt(discriminant)) / (2 * equation.getA());
            double x2 = (-equation.getB() - sqrt(discriminant)) / (2 * equation.getA());
            logger.info("root 1 = " + x1);
            logger.info("root 2 = " + x2);
        } else
            logger.info("discriminant is negative, no roots");
    }
}