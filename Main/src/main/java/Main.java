import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int a = 0, b = 0, c = 0;
        double discr, x1, x2;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите коэффициент \"a\": ");
        try {
            a = scanner.nextInt();
            while (a == 0) {
                System.out.print("Введите коэффициент \"a\" не равный нулю: ");
                a = scanner.nextInt();
            }
        }
        catch(Exception e) {
            System.out.println("Неверный тип данных. Перезапустите программу.");
            System.exit(1);
        }

        System.out.print("Введите коэффициент \"b\": ");
        try {
            b = scanner.nextInt();
        }
        catch(Exception e) {
            System.out.println("Неверный тип данных. Перезапустите программу.");
            System.exit(1);
        }

        System.out.print("Введите коэффициент \"c\": ");
        try {
            c = scanner.nextInt();
        }
        catch(Exception e) {
            System.out.println("Неверный тип данных. Перезапустите программу.");
            System.exit(1);
        }

        System.out.printf("\nВаше квадратное уравнение: (%d)x^2+(%d)x+(%d)=0\n\n", a, b, c);

        discr = b * b - 4 * a * c;

        if(discr > 0) {
            x1 = (b*(-1) + Math.sqrt(discr))/(2*a);
            x2 = (b*(-1) - Math.sqrt(discr))/(2*a);
            System.out.printf("Решение: x1 = %f, x2 = %f.", x1, x2);
        } else if (discr == 0) {
            x1 = (b*(-1))/(2*a);
            System.out.printf("Решение: x = %f", x1);
        } else
            System.out.println("Уравнение не имеет корней.");
    }
}
