package util;

import org.apache.commons.cli.CommandLine;

public class ParseArguments {
    private double a = 0.0;
    private double b = 0.0;
    private double c = 0.0;

    public double getA() {
        return a;
    }

    public double getC() {
        return c;
    }

    public double getB() {
        return b;
    }

    public ParseArguments(CommandLine line) {
        if (line.hasOption("a")) {
            this.a = Double.parseDouble(line.getOptionValue("a"));
        }
        if (line.hasOption("b")) {
            this.b = Double.parseDouble(line.getOptionValue("b"));
        }
        if (line.hasOption("c")) {
            this.c = Double.parseDouble(line.getOptionValue("c"));
        }
    }
}
