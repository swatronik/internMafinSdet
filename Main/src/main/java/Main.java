import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.ParserArgumentsUtil;

import static java.lang.Math.sqrt;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        ParserArgumentsUtil parserArgumentsUtil = new ParserArgumentsUtil(args);

        double disc = parserArgumentsUtil.getB() * parserArgumentsUtil.getB() - 4 * parserArgumentsUtil.getA() * parserArgumentsUtil.getC();

        if (disc > 0) {
            double root1 = (-parserArgumentsUtil.getB() - sqrt(disc)) / (2 * parserArgumentsUtil.getA());
            double root2 = (-parserArgumentsUtil.getB() + sqrt(disc)) / (2 * parserArgumentsUtil.getA());
            LOGGER.info("Result of quadratic equation is: 1st root={} 2nd root={}", root1, root2);
        } else if (disc == 0) {
            double root = -parserArgumentsUtil.getB() / (2 * parserArgumentsUtil.getA());
            LOGGER.info("Result of quadratic equation is: root={}", root);
        } else
            LOGGER.info("There are no roots");
    }
}
