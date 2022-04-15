import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите коэффицент а");
        double a = scanner.nextDouble();
        System.out.println("Введите коэффицент b");
        double b = scanner.nextDouble();
        System.out.println("Введите коэффицент c");
        double c = scanner.nextDouble();

        double disc = b * b - 4 * a * c;

        if (disc > 0) {
            double root1 = (-b - sqrt(disc)) / 2 * a;
            double root2 = (-b + sqrt(disc)) / 2 * a;
            System.out.println(String.format("1й корень=%s 2й корень=%s", root1, root2));
        } else if (disc == 0) {
            double root = -b / 2 * a;
            System.out.println(String.format("Корень=%s", root));
        } else
            System.out.println("Нет корней");
    }

}
