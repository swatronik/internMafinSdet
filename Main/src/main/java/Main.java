import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.util.Arrays;

import static java.lang.Math.sqrt;

public class Main {
    @Parameter(
            names = {"--firstArr", "-a"},
            description = "first argument in our equation",
            required = true
    )
    double firstArr;
    @Parameter(
            names = {"--secondArr", "-b"},
            description = "second argument in our equation",
            required = true
    )
    double secondArr;
    @Parameter(
            names = {"--thirdArr", "-c"},
            description = "third argument in our equation",
            required = true
    )
    double thirdArr;

    public static void main(String[] args) {
        Main Equation = new Main();
        JCommander.newBuilder()
                .addObject(Equation)
                .build()
                .parse(args);
        Equation.run();
    }

    public void run() {
        double disc = getDescriminant(firstArr, secondArr, thirdArr);
        System.out.println(String.format("Discriminant = %s", disc));
        if (disc > 0) {
            System.out.println(String.format("Discriminant > 0, so decision is: %s ", getFullDecision(firstArr, secondArr, thirdArr)));
        } else if (disc == 0) {
            System.out.println(String.format("Discriminant = 0, so decision is: %s ", getOneDecision(firstArr, secondArr)));
        } else if (disc < 0) {
            System.out.println(String.format("Decision is: %s", getNoDecisions()));
        }
    }

    public static double getDescriminant(double firstArr, double secondArr, double thirdArr) {
        return (secondArr * secondArr) - (4 * (firstArr * thirdArr));
    }

    public static String getFullDecision(double firstArr, double secondArr, double thirdArr) {
        double x1 = ((-secondArr + sqrt(getDescriminant(firstArr, secondArr, thirdArr))) / (firstArr * 2));
        double x2 = ((-secondArr - sqrt(getDescriminant(firstArr, secondArr, thirdArr))) / (firstArr * 2));
        return Arrays.toString(new double[]{x1, x2});
    }

    public static double getOneDecision(double firstArr, double secondArr) {
        return (secondArr * -1) / (2 * firstArr);
    }

    public static String getNoDecisions() {
        return ("Discriminant < 0, there's no decisions");
    }
}