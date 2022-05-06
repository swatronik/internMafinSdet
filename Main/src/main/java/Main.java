import equations.Equation;
import equations.EquationDecision;
import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.ParserArgumentsUtil;

import java.util.Arrays;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {
        try {
            Equation equation = ParserArgumentsUtil.parserArgumentsUtil(args);
            LOGGER.info(equation.toString());
            if (EquationDecision.decision(equation) != null) {
                LOGGER.info(String.format("The result of equation:%s ", Arrays.toString(EquationDecision.decision(equation))));
            } else LOGGER.info("There are no roots");
        } catch (ParseException | NumberFormatException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
