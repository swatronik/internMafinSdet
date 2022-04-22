package services;

import com.beust.jcommander.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParserMainArgument {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Parameter(
            names = {"--help", "-h"},
            help = true
    )
    private boolean help = false;

    private boolean isHelp() {
        return help;
    }

    @Parameters(
            commandNames = {"formula"},
            commandDescription = "After command full formula of equation expected",
            separators = "="
    )
    private class FormulaUsageCommand {
        @Parameter(
                names = {"--equation", "-e"},
                description = "Main parametr",
                required = true,
                validateWith = ValidateREGEX.class
        )
        public String equation;

        JCommander jct;

        private void inputFormula(String[] args) {
            jct = JCommander.newBuilder()
                    .addObject(this)
                    .build();
            try {
                jct.parse(args);
            } catch (ParameterException e) {
                logger.error(e.getLocalizedMessage());
                jct.usage();
            }
        }

        public FormulaUsageCommand(String[] args) {
            inputFormula(args);
        }
    }


    @Parameters(
            commandNames = {"arguments"},
            commandDescription = "After command three arguments expected"
    )
    private class ArgumentsUsageCommand {
        @Parameter(
                names = {"--firstArr", "-a"},
                description = "Enter number that will be first argument of quadratic equation",
                required = true,
                validateWith = ParametrsValidator.class
        )
        private double firstArr;
        @Parameter(
                names = {"--secondArr", "-b"},
                description = "Enter number that will be second argument of quadratic equation",
                required = true
        )
        private double secondArr;
        @Parameter(
                names = {"--thirdArr", "-c"},
                description = "Enter number that will be third argument of quadratic equation",
                required = true
        )
        private double thirdArr;

        JCommander jct;

        private void inputArguments(String[] args) {
            jct = JCommander.newBuilder()
                    .addObject(this)
                    .build();
            try {
                jct.parse(args);
            } catch (ParameterException e) {
                logger.error(e.getLocalizedMessage());
            }
        }

        public ArgumentsUsageCommand(String[] args) {
            inputArguments(args);
        }
    }

    FormulaUsageCommand formulaUC;
    ArgumentsUsageCommand argumentsUC;
    JCommander jct;

    public ParserMainArgument(String[] args) {
        inputCommand(args);
    }

    private void inputCommand(String[] args) {
        formulaUC = new FormulaUsageCommand(args);
        argumentsUC = new ArgumentsUsageCommand(args);
        jct = JCommander.newBuilder()
                .addObject(this)
                .addCommand(formulaUC)
                .addCommand(argumentsUC)
                .build();
        jct.setProgramName("Quadratic equation");
        try {
            jct.parse(args);
            String parsedCmdStr = jct.getParsedCommand();
            switch (parsedCmdStr) {
                case "formula":
                    formulaUC.inputFormula(args);
                    logger.info("Equation {} found", formulaUC.equation);
                    break;
                case "arguments":
                    argumentsUC.inputArguments(args);
                    logger.info("\nfirstArr set to {}.\nsecondArr set to {}.\nthirdArr set to {}.", argumentsUC.firstArr, argumentsUC.secondArr, argumentsUC.thirdArr);
                    break;
                default:
                    logger.error("Invalid command: " + parsedCmdStr);
                    if (this.isHelp()) {
                        jct.usage();
                    }
            }
        } catch (ParameterException e) {
            logger.error(e.getLocalizedMessage());
            jct.usage();
        }
    }
}