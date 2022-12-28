import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите число а");
        int a = scan.nextInt();

        System.out.println("Введите число b");
        int b = scan.nextInt();

        System.out.println("Введите число c");
        int c = scan.nextInt();

        int discriminant = (b * b) - (4 * a * c);
        System.out.print("D = ");
        System.out.println(discriminant);

        double d = Math.sqrt(discriminant);
        System.out.println("Корень D = " + d);
        if (d > 0) {
            double x1 = (-b + d) / (2 * a);
            System.out.println("x1 = " + x1);
            double x2 = (-b - d) / (2 * a);
            System.out.println("x2 = " + x2);
        } else if (d == 0) {
            int x = -b / (2 * a);
            System.out.println("x = " + x);
        } else {
            System.out.println("нет корней");
        }
    }
}