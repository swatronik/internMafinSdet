package controllers;

import services.ParserCmdlineArguments;
import services.QuadraticEquationRootsFinder;

public class Controller {

    private ParserCmdlineArguments cmdlineArguments;
    private QuadraticEquationRootsFinder rootsFinder;

    private String ds;

    public void getDecision (String[] args) {
        cmdlineArguments = new ParserCmdlineArguments();
        rootsFinder = new QuadraticEquationRootsFinder();
        if (ds == null) {
            rootsFinder.run(cmdlineArguments.);

            ds = finder.getDecision();
        }
    }
}