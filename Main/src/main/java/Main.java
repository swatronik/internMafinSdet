import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws ParseException {
        EquationParser equationParser = new EquationParser();
        logger.info(equationParser.parse(args));
        EquationSolver equationSolver = new EquationSolver();
        equationSolver.solve();
    }
}