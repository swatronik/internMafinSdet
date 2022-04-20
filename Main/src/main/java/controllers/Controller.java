package controllers;

import services.ParserCmdlineArguments;
import services.QuadraticEquationRootsFinder;

public class Controller {

    ParserCmdlineArguments arguments;
    QuadraticEquationRootsFinder finder;

    private String ds;

    public Controller(String[] args) {
        arguments = new ParserCmdlineArguments(args);
        finder = new QuadraticEquationRootsFinder();
    }

    public String getDecision() {
        if (ds == null) {
            finder.run(arguments.firstArr, arguments.secondArr, arguments.thirdArr);
            ds = finder.getDecision();
        }
        return ds;
    }
}