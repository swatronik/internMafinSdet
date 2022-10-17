import org.apache.commons.cli.*;

public class Main {

    public static void main(String[] args) throws ParseException {
        double a, b, c;

        Options options = new Options();
        options.addOption("a",true, "Коэффициент a");
        options.addOption("b", true,"Коэффициент b");
        options.addOption("c", true,"Коэффициент c");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);

        a = Double.parseDouble(cmd.getOptionValue("a"));
        if (a == 0) {
            throw new ParseException("Коэффициент \"a\" равен нулю. Данное уравнение не является квадратным.");
        }
        b = Double.parseDouble(cmd.getOptionValue("b"));
        c = Double.parseDouble(cmd.getOptionValue("c"));

        System.out.printf("\nВаше квадратное уравнение: (%f)x^2+(%f)x+(%f)=0\n%n", a, b, c);

        double discr = b * b - 4 * a * c;
        double x1, x2;

        if (discr > 0) {
            x1 = (b * (-1) + Math.sqrt(discr)) / (2 * a);
            x2 = (b * (-1) - Math.sqrt(discr)) / (2 * a);
            System.out.printf("Решение: x1 = %f, x2 = %f.", x1, x2);
        } else if (discr == 0) {
            x1 = (b * (-1)) / (2 * a);
            System.out.printf("Решение: x = %f", x1);
        } else {
            System.out.print("Уравнение не имеет корней.");
        }
    }
}