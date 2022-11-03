package util;

import com.sun.org.glassfish.gmbal.Description;
import equation.Equation;
import org.apache.commons.cli.CommandLine;
import org.junit.jupiter.api.DisplayName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import patternRegexp.PatternRegexp;

public class PatternEquationTestNgTest {

    public static Logger logger = LoggerFactory.getLogger(PatternEquationTestNgTest.class);

    @BeforeMethod
    public void initialize() {

    }

    @DataProvider(name = "patternEquationPositive")
    public static Object[][] patternEquationPositive() {
        return new Object[][]{
                {"4x^2+0x+1=0"},
                {"-4x^2+2x+1=0"},
                {"4x^2+2x+1=0"},
                {"-4x^2-2x-1=0"},
                {"44x^2+2x+1=0"},
                {"111x^2-222x-333=0"},
                {"111x^2+222x+333=0"},
                {"5675.3243x^2-8x+12=0"},
                {"5675.3243x^2-88888.8888x+12=0"},
                {"5675.3243x^2-88888.8888x+999.9999=0"}
        };
    }

    @DisplayName("Позитивный тест 1 ???? не выводится")
    @Description("Позитивный тест 2 ???? не выводится")
    @Test(dataProvider = "patternEquationPositive")
    public void patternEquationPositive(String inputEquation) {
        boolean result = inputEquation.matches(PatternRegexp.patternEquation);
        Assert.assertEquals(result, true, "Должно быть true");
    }

    @DataProvider(name = "equationExampleNegative")
    public static Object[][] equationExampleNegative() {
        return new Object[][]{
                {"111x^2+222x+335g3=0"},
                {"bad test3"},
                {"11y2+2x+1=0"},
                {"ololo"},
                {"5675.3243x^2-8x+12=0"},
                {""}
        };
    }

    @Test(dataProvider = "equationExampleNegative")
    public void equationExampleNegative(String inputEquation) {
        coeffToLog(logger, inputEquation);
        boolean result = inputEquation.matches(PatternRegexp.patternEquation);
        Assert.assertEquals(result, false, "Должно быть false");
    }



    @DataProvider(name = "getArgs")
    public static Object[][] getArgs() {
        return new Object[][]{
                {1.1, 2.2, 3.3}
        };
    }

//    @Test(dataProvider = "getArgs")
//    public void getArgs() {
//       Equation equation1 = cmd.getArgs();
//    }
//        Double a = equation.getA();
//        Double b = equation.getB();
//        Double c = equation.getC();
//
//        Assert.assertEquals(a, false);
//    }
//
//
//    public static Equation getArgs(CommandLine cmd) {
//
//        double a = Double.parseDouble(cmd.getOptionValue("a"));
//        double b = Double.parseDouble(cmd.getOptionValue("b"));
//        double c = Double.parseDouble(cmd.getOptionValue("c"));
//
//        return new Equation(a, b, c);
}
