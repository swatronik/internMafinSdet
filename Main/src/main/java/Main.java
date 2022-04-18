import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Math.sqrt;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger("MainClassLogger");

    public static void main(String[] args) {

        double a = 0;
        double b = 0;
        double c = 0;
        if (args.length == 6) {
            try {
                Option countA = new Option("a", "koeff a", true, "define a koef");
                Option countB = new Option("b", "koeff b", true, "define b koef");
                Option countC = new Option("c", "koeff c", true, "define c koef");

                Options options = new Options();

                options.addOption(countA);
                options.addOption(countB);
                options.addOption(countC);

                CommandLineParser parser = new DefaultParser();
                CommandLine line = parser.parse(options, args);

                if (line.hasOption("a")) {
                    a = Double.parseDouble(line.getOptionValue("a"));
                }
                if (line.hasOption("b")) {
                    b = Double.parseDouble(line.getOptionValue("b"));
                }
                if (line.hasOption("c")) {
                    c = Double.parseDouble(line.getOptionValue("c"));
                }
            } catch (Exception e) {
                logger.error("Failed to read file {}", e.getMessage());
                return;
            }
        } else {
            logger.error("Bad arguments");
            return;
        }
        double disc = b * b - 4 * a * c;

        if (disc > 0) {
            double root1 = (-b - sqrt(disc)) / (2 * a);
            double root2 = (-b + sqrt(disc)) / (2 * a);
            logger.info("1st root={} 2nd root={}", root1, root2);
        } else if (disc == 0) {
            double root = -b / (2 * a);
            logger.info("Root={}", root);
        } else
            logger.info("There are no roots");
    }

}
