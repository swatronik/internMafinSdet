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
            if (roots != null) {
                if (roots.getX2() != null)
                    LOGGER.info(String.format("The result of equation:%s %s", roots.getX2(), roots.getX1()));
                else
                    LOGGER.info(String.format("The result of equation:%s ", roots.getX1()));
            } else LOGGER.info("There are no roots");
        } catch (ParseException | NumberFormatException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
