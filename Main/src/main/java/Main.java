import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

        Logger logger = LoggerFactory.getLogger(Main.class);
        logger.info("Ваше квадратное уравнение: ({})x^2+({})x+({})=0", a, b, c);

        double discr = b * b - 4 * a * c;
        double x1, x2;

        if (discr > 0) {
            x1 = (b * (-1) + Math.sqrt(discr)) / (2 * a);
            x2 = (b * (-1) - Math.sqrt(discr)) / (2 * a);
            logger.info("Решение: x1 = {}, x2 = {}.", x1, x2);
        } else if (discr == 0) {
            x1 = (b * (-1)) / (2 * a);
            logger.info("Решение: x = {}", x1);
        } else {
            logger.info("Уравнение не имеет корней.");
        }
    }
}