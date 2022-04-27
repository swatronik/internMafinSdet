import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.ParserArgumentsUtil;

import static java.lang.Math.sqrt;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {

        try {
            ParserArgumentsUtil parserArgumentsUtil = new ParserArgumentsUtil(args);
            double disc = parserArgumentsUtil.getEquation().getB() * parserArgumentsUtil.getEquation().getB() - 4 * parserArgumentsUtil.getEquation().getA() * parserArgumentsUtil.getEquation().getC();

            if (disc > 0) {
                double root1 = (-parserArgumentsUtil.getEquation().getB() - sqrt(disc)) / (2 * parserArgumentsUtil.getEquation().getA());
                double root2 = (-parserArgumentsUtil.getEquation().getB() + sqrt(disc)) / (2 * parserArgumentsUtil.getEquation().getA());
                LOGGER.info("Result of quadratic equation is: 1st root={} 2nd root={}", root1, root2);
            } else if (disc == 0) {
                double root = -parserArgumentsUtil.getEquation().getB() / (2 * parserArgumentsUtil.getEquation().getA());
                LOGGER.info("Result of quadratic equation is: root={}", root);
            } else
                LOGGER.info("There are no roots");
        } catch (ParseException | NumberFormatException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
