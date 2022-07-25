import com.beust.jcommander.JCommander;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.Commands.CommandArguments;
import services.Commands.CommandFormula;

public class ParseArguments implements FindRootsOfAnyEquation {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private CommandFormula commandFormula = new CommandFormula();
    private CommandArguments commandArguments = new CommandArguments();
    private double firstArr;
    private double secondArr;
    private double thirdArr;
    private String equation;

    public double getFirstArr() {
        return firstArr;
    }

    public double getSecondArr() {
        return secondArr;
    }

    public double getThirdArr() {
        return thirdArr;
    }

    @Override
    public void findSolution() {
        JCommander jct = JCommander.newBuilder()
                .addCommand("formula", commandFormula)
                .addCommand("arguments", commandArguments)
                .addObject(this)
                .build();
        jct.parse(args);
        String parsedCmdStr = jct.getParsedCommand();
        switch (parsedCmdStr) {
            case "formula":
                this.equation = commandFormula.getEquation();
                logger.info("\n Found command '{}'", parsedCmdStr);
                logger.info("\n Found correct equation {}", equation);
                this.firstArr = commandFormula.getFirstArr();
                this.secondArr = commandFormula.getSecondArr();
                this.thirdArr = commandFormula.getThirdArr();
                logger.info("\n firstArr set to {} \n secondArr set to {} \n thirdArr set to {}", firstArr, secondArr, thirdArr);
                break;
            case "arguments":
                this.firstArr = commandArguments.getFirstArr();
                this.secondArr = commandArguments.getSecondArr();
                this.thirdArr = commandArguments.getThirdArr();
                logger.info("\n Found command '{}'", parsedCmdStr);
                logger.info("\n firstArr set to {} \n secondArr set to {} \n thirdArr set to {}", firstArr, secondArr, thirdArr);
                break;
            default:
                logger.error("Invalid command: " + parsedCmdStr);
        }
    }
}
