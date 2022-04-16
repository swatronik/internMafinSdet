import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Math.sqrt;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input first argument: ");
        double firstArr = in.nextDouble();
        System.out.print("Input second argument: ");
        double secondArr = in.nextDouble();
        System.out.print("Input third argument: ");
        double thirdArr = in.nextDouble();
        in.close();
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
        double x1 = ((-secondArr + sqrt(getDescriminant(firstArr,secondArr,thirdArr))) / (firstArr * 2));
        double x2 = ((-secondArr - sqrt(getDescriminant(firstArr,secondArr,thirdArr))) / (firstArr * 2));
        return Arrays.toString(new double[]{x1, x2});
    }

    public static double getOneDecision(double firstArr, double secondArr) {
        return secondArr * -1 / 2 * firstArr;
    }

    public static String getNoDecisions() {
        return ("Discriminant < 0, there's no decisions");
    }
}