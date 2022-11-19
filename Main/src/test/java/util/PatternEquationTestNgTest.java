package util;

import com.sun.org.glassfish.gmbal.Description;
import equation.Equation;
import equation.Roots;
import equation.SolutionEquation;
import exception.ExceptionMessage;
import org.apache.commons.cli.CommandLine;
import org.junit.jupiter.api.DisplayName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import patternRegexp.PatternRegexp;

import static util.PatternEquation.getFullEquation;

public class PatternEquationTestNgTest {

    public static Logger logger = LoggerFactory.getLogger(PatternEquationTestNgTest.class);

    @DataProvider(name = "patternEquationPositive")
    public static Object[][] patternEquationPositive() {
        return new Object[][]{
                {new Equation(4.0, 2.0, 1.0), new Roots()},
                {new Equation(1.0, -6.0, 9.0), new Roots(3.0)},
                {new Equation(1.0, -7.0, -30.0), new Roots(10.0, -3.0)},
                {new Equation(1.0, -7.0, -30.0), new Roots(-3.0, 10.0)}
        };
    }

    @Test(description = "Подаем уравнение на вход и проверяем что оно проходит регулярное выражение",
            dataProvider = "patternEquationPositive")
    public void patternEquationPositive(Equation equation, Roots roots) {

        Roots solution = SolutionEquation.solution(equation);
        Assert.assertEquals(solution, roots);
        logger.info(String.format("Solution = %s, Roots = %s", solution, roots));
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

    @Test(description = "Подаем уравнение на вход и проверяем что оно НЕ проходит регулярное выражение",
            dataProvider = "equationExampleNegative")
    public void equationExampleNegative(String inputEquation) {
        boolean result = inputEquation.matches(PatternRegexp.patternEquation);
        Assert.assertEquals(result, false, "Должно быть false");
    }


    @DataProvider(name = "getArgsParemeters")
    public static Object[][] getArgsParemeters() {
        return new Object[][]{
                {1.1, 2.2, 3.3},
                {0.1, 0.2, 0.3},
                {-1.1, -2.2, -3.3},
                {1.0, 2.0, 3.0},
                {1.11, 2.22, +3.33},
//                {1, 2, 3} ошибка??
        };
    }

    @Test(description = "Проверяет позитивные значения аргументов на вход",
            dataProvider = "getArgsParemeters")
    public void testGetArgs(Double a, Double b, Double c) {
        Equation equation = new Equation(a, b, c);

        Assert.assertEquals(a, equation.getA(), "Какая-то ошибка");
        Assert.assertEquals(b, equation.getB());
        Assert.assertEquals(c, equation.getC());
    }

    @DataProvider
    public Object[][] tablesDataNegative() {
        return new Object[][]{
                {"111x^2+222x+335g3=0"},
                {"bad test3"},
                {"11y2+2x+1=0"},
                {"ololo"},
                {"5675.3243x^2-8x+12=0"},
                {""}
        };
    }

    @Test(description = "Проверяем регулярное выражение, подавая недопустимые уравнения на вход",
            dataProvider = "tablesDataNegative")
    void equationValidatorTestNegative(String equation) throws ExceptionMessage {
        getFullEquation(equation);
    }

}
