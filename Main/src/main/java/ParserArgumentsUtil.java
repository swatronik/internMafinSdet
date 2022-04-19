import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParserArgumentsUtil {

    double a = 0.0;
    double b = 0.0;
    double c = 0.0;

    private static final Logger LOGGER = LoggerFactory.getLogger(ParserArgumentsUtil.class);

    public ParserArgumentsUtil(String[] args) {

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
                    this.a = Double.parseDouble(line.getOptionValue("a"));
                }
                if (line.hasOption("b")) {
                    this.b = Double.parseDouble(line.getOptionValue("b"));
                }
                if (line.hasOption("c")) {
                    this.c = Double.parseDouble(line.getOptionValue("c"));
                }
            } catch (ParseException e) {
                LOGGER.error("Failed to read arguments {}", e.getMessage());
            }
        } else {
            LOGGER.error("Bad arguments");
        }
    }
}
