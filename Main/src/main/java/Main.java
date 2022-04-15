import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Main {

    public static void main(String[] args) {
        double a = 0;
        double b = 0;
        double c = 0;
        if (args.length == 6) {
            for (int i = 0; i < 5; i++) {
                if (args[i].equals("-a")) {
                    a = Double.parseDouble(args[i + 1]);
                }
                if (args[i].equals("-b")) {
                    b = Double.parseDouble(args[i + 1]);
                }
                if (args[i].equals("-c")) {
                    c = Double.parseDouble(args[i + 1]);
                }
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
            double root1 = (-b - sqrt(disc)) / 2 * a;
            double root2 = (-b + sqrt(disc)) / 2 * a;
            System.out.println(String.format("1st root=%s 2nd root=%s", root1, root2));
        } else if (disc == 0) {
            double root = -b / 2 * a;
            System.out.println(String.format("Root=%s", root));
        } else
            System.out.println("There are no roots");
    }

}
