import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Math.sqrt;

public class Main {

    double firstArr;
    double secondArr;
    double thirdArr;
    double discr;

    public static void main(String[] args) {
        Main exampleEquation = new Main();
        Scanner in = new Scanner(System.in);
        System.out.print("Input first argument: ");
        exampleEquation.firstArr = in.nextDouble();
        System.out.print("Input second argument: ");
        exampleEquation.secondArr = in.nextDouble();
        System.out.print("Input third argument: ");
        exampleEquation.thirdArr = in.nextDouble();
        in.close();
        exampleEquation.discr = exampleEquation.getDescriminant(exampleEquation.firstArr, exampleEquation.secondArr, exampleEquation.thirdArr);
        System.out.print("Discriminant = ");
        System.out.println(exampleEquation.discr);
        if (exampleEquation.discr > 0) {
            System.out.println("Discriminant > 0, so decision is: ");
            System.out.print(Arrays.toString(exampleEquation.getFullDecision(exampleEquation.firstArr, exampleEquation.secondArr, exampleEquation.thirdArr)));
        } else if (exampleEquation.discr == 0) {
            System.out.println("Discriminant = 0, so decision is: ");
            System.out.print(exampleEquation.getOneDecision(exampleEquation.firstArr, exampleEquation.secondArr));
        } else if (exampleEquation.discr < 0) {
            System.out.println("Decision is: ");
            System.out.print(exampleEquation.getNoDecisions());
        }
    }

    public double getDescriminant(double firstArr, double secondArr, double thirdArr) {
        return (secondArr * secondArr) - (4 * (firstArr * thirdArr));
    }

    public double[] getFullDecision(double firstArr, double secondArr, double thirdArr) {
        double x1 = ((-secondArr - sqrt((secondArr * secondArr) - (4 * (firstArr * thirdArr)))) / 2 * firstArr);
        double x2 = ((-secondArr + sqrt((secondArr * secondArr) - (4 * (firstArr * thirdArr)))) / 2 * firstArr);
        double[] Decisions  = {x1, x2};
        return Decisions;
    }

    public double getOneDecision (double firstArr, double secondArr) {
        double x1 = secondArr * -1 / 2 * firstArr;
        return x1;
    }

    public String getNoDecisions() {
        return ("Discriminant < 0, there's no decisions");
    }
}