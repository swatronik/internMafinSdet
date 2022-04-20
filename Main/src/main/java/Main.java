import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Main {

    public static void main(String[] args) {

        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);

        double discriminant = b * b - 4 * a * c;
        System.out.println("discriminant = " + discriminant);

        if (discriminant == 0) {
            System.out.println("дискриминант равен нулю, вычислим единственный корень уравнения");
            double x = -b / (2 * a);
            System.out.println("Корень равен =  " + x);
        } else if (discriminant > 0) {
            System.out.println("Дискриминант положительный, найдем два действительных корня квадратного уравнения");
            double x1 = (-b + sqrt(discriminant)) / (2 * a);
            double x2 = (-b - sqrt(discriminant)) / (2 * a);
            System.out.println("Корень 1 равен " + x1);
            System.out.println("Корень 2 равен " + x2);
        } else
            System.out.println("Дискриминант отрицательный, действительных корней нет");
    }
}
