package util;

import org.apache.commons.cli.CommandLine;

public class ArgumentsParser {
    private final double a = 0.0;
    private final double b = 0.0;
    private final double c = 0.0;

    Equation equation=new Equation(a,b,c);

    public ArgumentsParser(CommandLine line) {
        if (line.hasOption("a")) {
            this.equation.setA(Double.parseDouble(line.getOptionValue("a")));
        }
        if (line.hasOption("b")) {
            this.equation.setB(Double.parseDouble(line.getOptionValue("b")));
        }
        if (line.hasOption("c")) {
            this.equation.setC(Double.parseDouble(line.getOptionValue("c")));
        }
    }
}
