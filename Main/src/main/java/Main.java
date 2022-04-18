import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static java.lang.Math.sqrt;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);


    @Parameter(
            names = {"--firstArr", "-a"},
            description = "Enter number that will be first argument of quadratic equation",
            required = true
    )
    double firstArr;
    @Parameter(
            names = {"--secondArr", "-b"},
            description = "Enter number that will be second argument of quadratic equation",
            required = true
    )
    double secondArr;
    @Parameter(
            names = {"--thirdArr", "-c"},
            description = "Enter number that will be third argument of quadratic equation",
            required = true
    )
    double thirdArr;

    @Parameter(
            names = {"--help", "-h"},
            help = true
    )
    private boolean help = false;

    private boolean ishelp() {
        return help;
    }


    public static void main(String[] args) {
        Main Equation = new Main();
        JCommander jct = JCommander.newBuilder().addObject(Equation).build();
        try {
            jct.parse(args);
            if (Equation.ishelp()) {
                jct.usage();
            } else Equation.run();
        } catch (ParameterException e) {
            logger.error(e.getLocalizedMessage());
            jct.usage();
        }
    }

    private void run() {
        logger.info("firstArr set to {}.\n secondArr set to {}.\n thirdArr set to {}.", firstArr, secondArr, thirdArr);
        double disc = getDescriminant(firstArr, secondArr, thirdArr);
        logger.info(String.format("Discriminant = %s", disc));
        if (disc > 0) {
            logger.info(String.format("Discriminant > 0, so decision is: %s ", getFullDecision(firstArr, secondArr, thirdArr)));
        } else if (disc == 0) {
            logger.info(String.format("Discriminant = 0, so decision is: %s ", getOneDecision(firstArr, secondArr)));
        } else if (disc < 0) {
            logger.info(String.format("Decision is: %s", getNoDecisions()));
        }
    }

    private static double getDescriminant(double firstArr, double secondArr, double thirdArr) {
        return (secondArr * secondArr) - (4 * (firstArr * thirdArr));
    }

    private static String getFullDecision(double firstArr, double secondArr, double thirdArr) {
        double x1 = ((-secondArr + sqrt(getDescriminant(firstArr, secondArr, thirdArr))) / (firstArr * 2));
        double x2 = ((-secondArr - sqrt(getDescriminant(firstArr, secondArr, thirdArr))) / (firstArr * 2));
        return Arrays.toString(new double[]{x1, x2});
    }

    private static double getOneDecision(double firstArr, double secondArr) {
        return (secondArr * -1) / (2 * firstArr);
    }

    private static String getNoDecisions() {
        return ("Discriminant < 0, there's no decisions");
    }
}