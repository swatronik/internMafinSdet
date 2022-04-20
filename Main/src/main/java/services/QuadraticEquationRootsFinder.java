package services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static java.lang.Math.sqrt;

public class QuadraticEquationRootsFinder {

    private static final Logger logger = LoggerFactory.getLogger(QuadraticEquationRootsFinder.class);

    private String decision;

    public void run(double firstArr, double secondArr, double thirdArr) {
        double disc = getDescriminant(firstArr, secondArr, thirdArr);
        logger.info(String.format("\nDiscriminant = %s", disc));
        if (disc > 0) {
            decision = getFullDecision(firstArr, secondArr, thirdArr);
        } else if (disc == 0) {
            decision = String.valueOf(getOneDecision(firstArr, secondArr));
        } else if (disc < 0) {
            decision = getNoDecisions();
        }
        logger.info("\nSo your decision is: {}", decision);
    }

    public String getDecision() {
        return decision;
    }

    private double getDescriminant(double firstArr, double secondArr, double thirdArr) {
        return (secondArr * secondArr) - (4 * (firstArr * thirdArr));
    }

    private String getFullDecision(double firstArr, double secondArr, double thirdArr) {
        double x1 = ((-secondArr + sqrt(getDescriminant(firstArr, secondArr, thirdArr))) / (firstArr * 2));
        double x2 = ((-secondArr - sqrt(getDescriminant(firstArr, secondArr, thirdArr))) / (firstArr * 2));
        return Arrays.toString(new double[]{x1, x2});
    }

    private double getOneDecision(double firstArr, double secondArr) {
        return (secondArr * -1) / (2 * firstArr);
    }

    private String getNoDecisions() {
        return ("Discriminant < 0, there's no decisions");
    }
}