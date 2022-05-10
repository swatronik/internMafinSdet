import equation.Equation;
import org.apache.commons.cli.*;

public class ParserArgument {
    private double a;
    private double b;
    private double c;
    private String eq;

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public String getEq() {
        return eq;
    }

    public ParserArgument(String[] args) throws ParseException {

        Options options = new Options();

        Option argA = new Option("a", "value a", true, "select a");
        Option argB = new Option("b", "value b", true, "select b");
        Option argC = new Option("c", "value c", true, "select c");
        Option equation = new Option("eq", "equation", true, "select full equation");

        options.addOption(argA);
        options.addOption(argB);
        options.addOption(argC);
        options.addOption(equation);

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);

        if (cmd.hasOption("a")) {
            this.a = Double.parseDouble(cmd.getOptionValue("a"));
            this.b = Double.parseDouble(cmd.getOptionValue("b"));
            this.c = Double.parseDouble(cmd.getOptionValue("c"));

        } else if (cmd.hasOption("eq"))
            this.eq = cmd.getOptionValue("eq");
    }
}

