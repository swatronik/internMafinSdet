import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EquationParser {
    private static final Logger logger = LoggerFactory.getLogger(EquationParser.class);
    public static EquationParser parse;
    private static Double a, b, c;

    public String parse(String[] args) throws ParseException {

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

        return "Ваше квадратное уравнение: (" + a + ")x^2+(" + b + ")x+(" + c + ")=0";
    }

    public static Double getA() {
        return a;
    }

    public static Double getB() {
        return b;
    }

    public static Double getC() {
        return c;
    }
}
