import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("������� ����� �");
        int a = scan.nextInt();

        System.out.println("������� ����� b");
        int b = scan.nextInt();

        System.out.println("������� ����� c");
        int c = scan.nextInt();

        int res1 = (b * b) - (4 * a * c);
        System.out.print("D = ");
        System.out.println(res1);


        double d = Math.sqrt(res1);
        System.out.println("������ D = " + d);
        if (d > 0)
        {

            double res2 = (-b + d) / 2 * a;
            System.out.println("x1 = " + res2);

            double res3 = (-b - d) / 2 * a;
            System.out.println("x2 = " + res3);
        }
       else if (d == 0)
        {
            int res3 = -b / (2 * a);
            System.out.println("x3 = " + res3);

        }
        else
        {
            System.out.println("��� ������");
        }
    }
}