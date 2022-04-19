package controllers;
import models.ParserCmdlineArguments;
import models.QuadraticEquationRootsFinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Controller {

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    private static String d;

    public static void run(String[] args) {
        ParserCmdlineArguments arrgs = new ParserCmdlineArguments(args);
        QuadraticEquationRootsFinder findroot = new QuadraticEquationRootsFinder();
        logger.info("\nfirstArr set to {}.\nsecondArr set to {}.\nthirdArr set to {}.", arrgs.firstArr, arrgs.secondArr, arrgs.thirdArr);
        findroot.run(arrgs.firstArr, arrgs.secondArr,arrgs.thirdArr);
        d = findroot.getDecision();
        logger.info("\nSo your decision is: {}", d);
    }

    public String getD() {
        return d;
    }
}