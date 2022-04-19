package models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static java.lang.Math.sqrt;

public class QuadraticEquationRootsFinder {

    private static final Logger logger = LoggerFactory.getLogger(QuadraticEquationRootsFinder.class);

    private static String decision;

    public static void run(double firstArr, double secondArr, double thirdArr) {
        double disc = getDescriminant(firstArr, secondArr, thirdArr);
        logger.info(String.format("\nDiscriminant = %s", disc));
        if (disc > 0) {
            decision = getFullDecision(firstArr, secondArr, thirdArr);
        } else if (disc == 0) {
            decision = String.valueOf(getOneDecision(firstArr, secondArr));
        } else if (disc < 0) {
            decision = getNoDecisions();
        }
    }

    public String getDecision() {
        return decision;
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