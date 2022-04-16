import org.apache.commons.cli.*;

import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Main {

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
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }
        } else {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter a");
            a = scanner.nextDouble();
            System.out.println("Enter b");
            b = scanner.nextDouble();
            System.out.println("Enter c");
            c = scanner.nextDouble();
        }

        double disc = b * b - 4 * a * c;

        if (disc > 0) {
            double root1 = (-b - sqrt(disc)) / (2 * a);
            double root2 = (-b + sqrt(disc)) / (2 * a);
            System.out.println(String.format("1st root=%s 2nd root=%s", root1, root2));
        } else if (disc == 0) {
            double root = -b / (2 * a);
            System.out.println(String.format("Root=%s", root));
        } else
            System.out.println("There are no roots");
    }

}
