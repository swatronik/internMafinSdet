import java.io.IOException;

import org.apache.commons.cli.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


import static java.lang.Math.sqrt;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException, ParseException {
        float aFactor = 0, bFactor = 0, cFactor = 0;

        if (args.length == 2) {
            Options options = new Options();

            Option eFull = new Option("e", "fullEquation", true, "input equation ax^2 + bx + c = 0");
            eFull.setRequired(true);
            options.addOption(eFull);

            CommandLineParser parser = new DefaultParser();
            HelpFormatter formatter = new HelpFormatter();
            CommandLine cmd = null;

            try {
                cmd = parser.parse(options, args);
                List<String> abcValues = ParseString.abcValues(cmd.getOptionValue("fullEquation"));
                if (!abcValues.isEmpty()) {
                    aFactor = Float.parseFloat(abcValues.get(0));
                    bFactor = Float.parseFloat(abcValues.get(1));
                    cFactor = Float.parseFloat(abcValues.get(2));
                }
            } catch (ParseException e) {
                logger.error(e.getMessage());
                formatter.printHelp("utility-name", options);
                throw e;
            }
        }

        if (args.length > 3) {
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
                logger.error(e.getMessage());
                formatter.printHelp("utility-name", options);
                throw e;
            }
            aFactor = Float.parseFloat(cmd.getOptionValue("aValue"));
            bFactor = Float.parseFloat(cmd.getOptionValue("bValue"));
            cFactor = Float.parseFloat(cmd.getOptionValue("cValue"));
        }

        if (aFactor != 0) {
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
        }

    }
}
