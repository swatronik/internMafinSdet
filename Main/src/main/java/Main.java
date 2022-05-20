import equations.Equation;
import equations.EquationDecision;
import equations.Roots;
import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.ParserArgumentsUtil;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {
        try {
            Equation equation = ParserArgumentsUtil.parserArgumentsUtil(args);
            Roots roots = EquationDecision.decision(equation);
            LOGGER.info(equation.toString());
            LOGGER.info(roots.toString());
        } catch (ParseException | NumberFormatException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
