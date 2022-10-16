import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InputMismatchException {
        double a = 0, b = 0, c = 0;
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите коэффициент \"a\": ");
            a = scanner.nextDouble();
            while (a == 0) {
                System.out.print("Введите коэффициент \"a\" не равный нулю: ");
                a = scanner.nextDouble();
            }
            System.out.print("Введите коэффициент \"b\": ");
            b = scanner.nextDouble();
            System.out.print("Введите коэффициент \"c\": ");
            c = scanner.nextDouble();
        } catch (RuntimeException e) {
            System.out.println("Ошибка: неверный тип данных. Перезапустите программу.");
            throw e;
        }

        System.out.println(String.format("\nВаше квадратное уравнение: (%f)x^2+(%f)x+(%f)=0\n", a, b, c));

        double discr = b * b - 4 * a * c;
        double x1, x2;

        if (discr > 0) {
            x1 = (b * (-1) + Math.sqrt(discr)) / (2 * a);
            x2 = (b * (-1) - Math.sqrt(discr)) / (2 * a);
            System.out.print(String.format("Решение: x1 = %f, x2 = %f.", x1, x2));
        } else if (discr == 0) {
            x1 = (b * (-1)) / (2 * a);
            System.out.print(String.format("Решение: x = %f", x1));
        } else {
            System.out.print("Уравнение не имеет корней.");
        }
    }
}