package unit;

import equations.Equation;
import exceptions.ParseArgumentsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static util.Parser.parseEquation;

public class ParseEquationUnit extends BaseTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParseEquationUnit.class);

    @DataProvider
    public Object[][] tablesDataPositive() {
        return new Object[][]{
                {"4x^2+0x+1=0", 4.0, 0.0, 1},
                {"-4x^2+2x+1=0", -4.0, 2.0, 1},
                {"5675.3243x^2-8x+12=0", 5675.3243, -8, 12},
                {"5675.3243x^2-8.45435435x+12.1223=0", 5675.3243, -8.45435435, 12.1223},
                {"x^2=0", 1, 0, 0},
                {"x^2+1=0", 1, 0, 1},
                {"x^2+2x=0", 1, 2, 0},
        };
    }

    @Test(dataProvider = "tablesDataPositive")
    void equationValidatorTestPositive(String equation, double a, double b, double c) throws ParseArgumentsException {
        equationToLog(LOGGER, equation);
        LOGGER.debug("a=" + a);
        LOGGER.debug("b=" + b);
        LOGGER.debug("c=" + c);
        Equation equation1 = parseEquation(equation);
        Assert.assertEquals(equation1.getA(), a);
        Assert.assertEquals(equation1.getB(), b);
        Assert.assertEquals(equation1.getC(), c);
    }

    @DataProvider
    public Object[][] tablesDataNegative() {
        return new Object[][]{
                {"x=0"},
                {"1=0"},
                {"ololo"},
                {"12345"},
                {"ололо"},
                {"x^2+2x+2x"},
                {"x^22x=0"},
        };
    }

    @Test(dataProvider = "tablesDataNegative", expectedExceptions = {ParseArgumentsException.class})
    void equationValidatorTestNegative(String equation) throws ParseArgumentsException {
        equationToLog(LOGGER, equation);
        parseEquation(equation);
    }
}



