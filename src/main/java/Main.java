import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.cli.*;
import org.apache.commons.cli.Option.Builder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Math.sqrt;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException, ParseException {
        float aFactor = 0, bFactor = 0, cFactor = 0;

        String testEq = "-2.3x^2-2.1x-4.2=0";
        Pattern pattern = Pattern.compile("(((\\+|-|)((\\d+)|(\\d+\\.\\d+)))(x\\^2)((\\+|-|)((\\d+)|(\\d+\\.\\d+)))(x)((\\+|-|)((\\d+)|(\\d+\\.\\d+)))(=0))");
        Matcher matcher = pattern.matcher(testEq);
        System.out.println(matcher.matches());
        System.out.println(matcher.group(2) + "-a " + matcher.group(8) + "-b " + matcher.group(14) + "-c ");

        if (args.length == 2){
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
                aFactor = Float.parseFloat(abcValues.get(0));
                bFactor = Float.parseFloat(abcValues.get(1));
                cFactor = Float.parseFloat(abcValues.get(2));
            } catch (ParseException e) {
                logger.error(e.getMessage());
                formatter.printHelp("utility-name", options);
                throw e;
            } catch (Exception e) {
                e.printStackTrace();
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
            logger.error(e.getMessage());
            throw e;
        }
    }
}
