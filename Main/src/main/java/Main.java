import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Math.sqrt;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        ParserArgumentsUtil parserArgumentsUtil = new ParserArgumentsUtil();

        parserArgumentsUtil.parserArgumentsUtil(args);

        double disc = parserArgumentsUtil.b * parserArgumentsUtil.b - 4 * parserArgumentsUtil.a * parserArgumentsUtil.c;

        if (disc > 0) {
            double root1 = (-parserArgumentsUtil.b - sqrt(disc)) / (2 * parserArgumentsUtil.a);
            double root2 = (-parserArgumentsUtil.b + sqrt(disc)) / (2 * parserArgumentsUtil.a);
            LOGGER.info("Result of quadratic equation is: 1st root={} 2nd root={}", root1, root2);
        } else if (disc == 0) {
            double root = -parserArgumentsUtil.b / (2 * parserArgumentsUtil.a);
            LOGGER.info("Result of quadratic equation is: root={}", root);
        } else
            LOGGER.info("There are no roots");
    }

}
