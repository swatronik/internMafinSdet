import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.cli.*;
import org.apache.commons.cli.Option.Builder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Math.sqrt;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException, ParseException {
        float aFactor = 0, bFactor = 0, cFactor = 0;

        if (args.length > 0) {
            Options options = new Options();

            Option aFactorOpt = new Option("a", "aValue", true, "input a-Factor");
            aFactorOpt.setRequired(true);
            options.addOption(aFactorOpt);

            Option bFactorOpt = new Option("b", "bValue", true, "input b-Factor");
            bFactorOpt.setRequired(true);
            options.addOption(bFactorOpt);

            Option cFactorOpt = new Option("c", "cValue", true, "input c-Factor");
            cFactorOpt.setRequired(true);
            options.addOption(cFactorOpt);

            CommandLineParser parser = new DefaultParser();
            HelpFormatter formatter = new HelpFormatter();
            CommandLine cmd = null;

            try {
                cmd = parser.parse(options, args);
            } catch (ParseException e) {
                logger.info(e.getMessage());
                formatter.printHelp("utility-name", options);
                throw e;
            }

            aFactor = Float.parseFloat(cmd.getOptionValue("aValue"));
            bFactor = Float.parseFloat(cmd.getOptionValue("bValue"));
            cFactor = Float.parseFloat(cmd.getOptionValue("cValue"));

        }

        try {
            Float D = bFactor * bFactor - 4 * aFactor * cFactor;

            if (D < 0) {
                logger.info("There is no solution");
            } else if (D == 0) {
                Float Result = -1 * bFactor / (2 * aFactor);
                logger.info("Only one result: {}", Result);
            } else if (D > 0) {
                double Result1 = (-1 * bFactor + sqrt(D)) / (2 * aFactor);
                double Result2 = (-1 * bFactor - sqrt(D)) / (2 * aFactor);
                logger.info("Result 1 is: {} Result 2 is: {}", Result1, Result2);
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
