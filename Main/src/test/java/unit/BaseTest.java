package unit;

import org.slf4j.Logger;

public class BaseTest {

    public static void argsToLog(Logger LOGGER, String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : args) {
            stringBuilder
                    .append(str)
                    .append(" ");
        }
        LOGGER.debug("Args " + stringBuilder.toString());
    }

    public static void equationToLog(Logger LOGGER, String equation) {
        LOGGER.debug("Equation " + equation);
    }

    public static void coeffToLog(Logger LOGGER, double a, double b, double c) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("a=")
                .append(a)
                .append(" ")
                .append("b=")
                .append(b)
                .append(" ")
                .append("c")
                .append(c);
        LOGGER.debug("Coeffs " + stringBuilder.toString());

    }
}
