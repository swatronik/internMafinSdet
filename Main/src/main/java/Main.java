import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Math.sqrt;

public class Main {

    public static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws ParseException {

        ParserArgument parserArgument = new ParserArgument(args);

        double discriminant = parserArgument.getA() * parserArgument.getB() - 4 * parserArgument.getA() * parserArgument.getC();
        logger.info("discriminant = " + discriminant);

        if (discriminant == 0) {
            logger.info("discriminant = 0, get one root");
            double x = -parserArgument.getB() / (2 * parserArgument.getA());
            logger.info("root = " + x);
        } else if (discriminant > 0) {
            logger.info("discriminant is positive, get two roots");
            double x1 = (-parserArgument.getB() + sqrt(discriminant)) / (2 * parserArgument.getA());
            double x2 = (-parserArgument.getB() - sqrt(discriminant)) / (2 * parserArgument.getA());
            logger.info("root 1 = " + x1);
            logger.info("root 2 = " + x2);
        } else
            logger.info("discriminant is negative, no roots");
    }
}
