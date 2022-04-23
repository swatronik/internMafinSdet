package controllers;

import services.ParserCmdlineArguments;
import services.QuadraticEquationRootsFinder;

public class Controller {

    private ParserCmdlineArguments cmdlineArguments;
    private QuadraticEquationRootsFinder rootsFinder;


    private String ds;

    public Controller(String[] args) {
        cmdlineArguments = new ParserCmdlineArguments(args);
    }

    public String getDecision () {
        rootsFinder = new QuadraticEquationRootsFinder();
        if (ds == null) {
            rootsFinder.run(cmdlineArguments.getFirstArr(), cmdlineArguments.getSecondArr(), cmdlineArguments.getThirdArr());
            ds = rootsFinder.getDecision();
        }
        return ds;
    }
}