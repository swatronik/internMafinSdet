import org.apache.commons.cli.*;

public class ParserArgument {
    double a;
    double b;
    double c;

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public ParserArgument(String[] args) throws ParseException {

        Options options = new Options();

        Option argA = new Option("a", "value a", true, "select a");
        Option argB = new Option("b", "value b", true, "select b");
        Option argC = new Option("c", "value c", true, "select c");

        options.addOption(argA);
        options.addOption(argB);
        options.addOption(argC);

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);

        this.a = Double.parseDouble(cmd.getOptionValue("a"));
        this.b = Double.parseDouble(cmd.getOptionValue("b"));
        this.c = Double.parseDouble(cmd.getOptionValue("c"));

    }
}
