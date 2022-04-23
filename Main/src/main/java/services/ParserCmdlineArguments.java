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
        String parsedCmdStr = jct.getParsedCommand();
        switch (parsedCmdStr) {
            case "formula":
                this.equation = commandFormula.getEquation();
                logger.info("\n Found command '{}'", parsedCmdStr);
                logger.info("\n Found correct equation {}", commandFormula.getEquation());
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
                System.err.println("Invalid command: " + parsedCmdStr);
        }
    }

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
}