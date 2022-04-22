package controllers;

import services.ParserMainArgument;
import services.QuadraticEquationRootsFinder;

public class Controller {

    ParserMainArgument arguments;
    QuadraticEquationRootsFinder finder;

    private String ds;

    public Controller(String[] args) {
        arguments = new ParserMainArgument(args);
        finder = new QuadraticEquationRootsFinder();
    }

    public String getDecision() {
        if (ds == null) {
            finder.run(5,6,7);
            ds = finder.getDecision();
        }
        return ds;
    }
}