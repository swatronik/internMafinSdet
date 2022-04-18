import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.cli.*;
import org.apache.commons.cli.Option.Builder;

import static java.lang.Math.sqrt;

public class Main {

    public static void main(String[] args) throws IOException {
        String a = "0", b = "0", c = "0";

        if (args.length > 0) {
            Options options = new Options();

            Option aFactor = new Option("a", "aValue", true, "input a-Factor");
            aFactor.setRequired(true);
            options.addOption(aFactor);

            Option bFactor = new Option("b", "bValue", true, "input b-Factor");
            bFactor.setRequired(true);
            options.addOption(bFactor);

            Option cFactor = new Option("c", "cValue", true, "input c-Factor");
            cFactor.setRequired(true);
            options.addOption(cFactor);

            CommandLineParser parser = new DefaultParser();
            HelpFormatter formatter = new HelpFormatter();
            CommandLine cmd = null;

            try {
                cmd = parser.parse(options, args);
            } catch (ParseException e) {
                System.out.println(e.getMessage());
                formatter.printHelp("utility-name", options);
                System.exit(1);
            }

            a = cmd.getOptionValue("aValue");
            b = cmd.getOptionValue("bValue");
            c = cmd.getOptionValue("cValue");

        } else {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));

            System.out.println("Enter a from aX^2 + bX + c = 0");
            a = reader.readLine();
            System.out.println(a + " is a-factor");

            System.out.println("Enter b from aX^2 + bX + c = 0");
            b = reader.readLine();
            System.out.println(b + " is b-factor");

            System.out.println("Enter c from aX^2 + bX + c = 0");
            c = reader.readLine();
            System.out.println(c + " is c-factor");
        }

        try {
            Float aFactor = Float.parseFloat(a);
            Float bFactor = Float.parseFloat(b);
            Float cFactor = Float.parseFloat(c);

            Float D = bFactor * bFactor - 4 * aFactor * cFactor;

            if (D < 0) {
                System.out.println("There is no solution");
            } else if (D == 0) {
                Float Result = -1 * bFactor / (2 * aFactor);
                System.out.println(Result);
            } else if (D > 0) {
                double Result1 = (-1 * bFactor + sqrt(D)) / (2 * aFactor);
                double Result2 = (-1 * bFactor - sqrt(D)) / (2 * aFactor);
                System.out.println(String.format("Result 1 is: %f \nResult 2 is: %f", Result1, Result2));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
