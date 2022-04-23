package services;

import com.beust.jcommander.JCommander;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.Commands.CommandArguments;
import services.Commands.CommandFormula;

public class ParserCmdlineArguments {

    CommandFormula commandFormula = new CommandFormula();
    CommandArguments commandArguments = new CommandArguments();
    private double firstArr;
    private double secondArr;
    private double thirdArr;

    public double getFirstArr() {
        return firstArr;
    }

    public double getSecondArr() {
        return secondArr;
    }

    public double getThirdArr() {
        return thirdArr;
    }

    public ParserCmdlineArguments(String[] args) {
        parseCmdLine(args);
    }

    private void parseCmdLine(String[] args) {
        JCommander jct = JCommander.newBuilder()
                .addCommand("formula", commandFormula)
                .addCommand("arguments", commandArguments)
                .addObject(this)
                .build();
        jct.parse(args);
        this.firstArr = commandArguments.getFirstArr();
        this.secondArr = commandArguments.getSecondArr();
        this.thirdArr = commandArguments.getThirdArr();
        String parsedCmdStr = jct.getParsedCommand();
        switch (parsedCmdStr) {
            case "formula":
                logger.info("\n found command, {}", parsedCmdStr);
                logger.info("\n firstArr set to {} ", commandFormula.getEquation());
                break;
            case "arguments":
                logger.info("\n found command '{}'", parsedCmdStr);
                logger.info("\n firstArr set to {} \n secondArr set to {} \n thirdArr set to {}", firstArr, secondArr, thirdArr);
                break;
            default:
                System.err.println("Invalid command: " + parsedCmdStr);
        }
    }

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
}