import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EquationSolver {
    private static final Logger logger = LoggerFactory.getLogger(EquationParser.class);

    public static Roots solve() {
        double a = EquationParser.getA();
        double b = EquationParser.getB();
        double c = EquationParser.getC();
        double discr = b * b - 4 * a * c;
        double x, x1, x2;

        if (discr > 0) {
            x1 = (b * (-1) + Math.sqrt(discr)) / (2 * a);
            x2 = (b * (-1) - Math.sqrt(discr)) / (2 * a);
            logger.info("Решение: x1 = {}, x2 = {}.", x1, x2);
            return new Roots(x1, x2);
        } else if (discr == 0) {
            x = (b * (-1)) / (2 * a);
            logger.info("Решение: x = {}", x);
            return new Roots(x);
        } else {
            logger.info("Уравнение не имеет корней.");
            return new Roots();
        }
    }
}
