import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ParserCmdlineArguments;
import java.util.Arrays;
import static java.lang.Math.sqrt;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        ParserCmdlineArguments read = new ParserCmdlineArguments(args);
        run(read.firstArr, read.secondArr, read.thirdArr);
    }

    private static void run(double firstArr, double secondArr, double thirdArr) {
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