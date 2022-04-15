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

        if (disc < 0)
            System.out.println("Нет корней");
        else if (disc == 0)
            System.out.println("Корень=" + (-b - sqrt(disc)) / 2 * a);
        else
            System.out.println("1й корень=" + (-b - sqrt(disc)) / 2 * a + "2й корень=" + (-b + sqrt(disc)) / 2 * a);

    }

}
