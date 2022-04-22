package services;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.beust.jcommander.Parameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.Validators.ParametrsValidator;
import services.Validators.ValidateREGEX;

public class ParserCmdlineArguments {

    @Parameters(
            commandNames = "formula",
            commandDescription = "Parametr means that full formula of quadratic equation expected afet space"
    )
    public class FormulaUsageCommand {
        @Parameter(
                names = {"--equation", "-e"},
                description = "Required parametr after cmd 'formula'",
                required = true,
                validateWith = ValidateREGEX.class
        )
        private String equation;

        private void parseInputFormula (String[] args) {
            JCommander jct = JCommander.newBuilder().build();
            try {
                jct.parse(args);
            } catch (ParameterException e) {
                logger.error(e.getLocalizedMessage());
                jct.usage();
            }
        }

        public String getEquation() {
            return equation;
        }
    }

    @Parameters(
            commandNames = "arguments",
            commandDescription = "Parametr means that three arguments expected after command 'arguments'"
    )
    public class ArgumentsUsageCommand {
        @Parameter(
                names = {"--firstArr", "-a"},
                description = "Required parametr of first argument of equation",
                required = true,
                validateWith = ParametrsValidator.class
        )
        private double firstArr;

        @Parameter(
                names = {"--secondArr", "-b"},
                description = "Required parametr of second argument of equation",
                required = true
        )
        private double secondArr;

        @Parameter(
                names = {"--thirdArr", "-c"},
                description = "Required parametr of third argument of equation",
                required = true
        )
        private String equation;

        private void parseInputParametrs (String[] args) {
            JCommander jct = JCommander.newBuilder().build();
            try {
                jct.parse(args);
            } catch (ParameterException e) {
                logger.error(e.getLocalizedMessage());
                jct.usage();
            }
        }

        public double getFirstArr() {
            return firstArr;
        }

        public double getSecondArr() {
            return secondArr;
        }

        public String getEquation() {
            return equation;
        }
    }

    private void parseCmdArgs(String[] args) {
        FormulaUsageCommand formulaUC = new FormulaUsageCommand();
        ArgumentsUsageCommand argumentsUC = new ArgumentsUsageCommand();
        JCommander jct = JCommander.newBuilder()
                .addCommand(formulaUC)
                .addCommand(argumentsUC)
                .build();
        try {
            jct.parse(args);
            String parsedCmdStr = jct.getParsedCommand();
            switch (parsedCmdStr) {
                case "formula":
                    formulaUC.parseInputFormula(args);
                    break;
                case "arguments":
                    argumentsUC.parseInputParametrs(args);
                    break;
                default:
                    logger.error("Invalid command: " + parsedCmdStr);
            }
        } catch (ParameterException e) {
            logger.error(e.getLocalizedMessage());
            jct.usage();
        }
    }
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


}