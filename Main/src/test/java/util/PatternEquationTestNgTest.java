package util;

import equation.Equation;
import exception.ExceptionMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static util.PatternEquation.getFullEquation;

public class PatternEquationTestNgTest {

    public static Logger logger = LoggerFactory.getLogger(PatternEquationTestNgTest.class);

    @Test(description = "Подаем уравнение на вход и проверяем что оно проходит регулярное выражение",
            dataProvider = "patternEquationPositive")
    public void patternEquationPositive(String inputEquation, Equation equation) throws ExceptionMessage {
        Equation fullEquation = getFullEquation(inputEquation);
        Assert.assertEquals(fullEquation, equation);
        logger.info(String.format("InputEquation = %s, Equation = %s", fullEquation, equation));
    }

    @DataProvider(name = "patternEquationPositive")
    public static Object[][] patternEquationPositive() {
        return new Object[][]{
                {"4x^2+0x+1=0", new Equation(4.0, 0.0, 1.0)},
                {"-4x^2+2x+1=0", new Equation(-4.0, 2.0, 1.0)},
                {"4x^2+2x+1=0", new Equation(4.0, 2.0, 1.0)},
                {"-4x^2-2x-1=0", new Equation(-4.0, 2.0, -1.0)}, //-
                {"44x^2+2x+1=0", new Equation(44.0, 2.0, 1.0)},
                {"111x^2-222x-333=0", new Equation(111.0, -222.0, -333.0)},
                {"111x^2+222x+333=0", new Equation(111.0, 222.0, 333.0)},
                {"5675.3243x^2-8x+12=0", new Equation(5675.3243, -8.0, 12.0)},
                {"5675.3243x^2-88888.8888x+12=0", new Equation(5675.3243, -88888.8888, 12.0)},
                {"5675.3243x^2-88888.8888x+999.9999=0", new Equation(5675.3243, -88888.8888, 999.9999)}
        };
    }

    @Test(description = "Проверяем выпадение ExceptionMessage если уравнение на вход не проходит проверку регурярки",
            dataProvider = "tablesDataException",
            expectedExceptions = ExceptionMessage.class)
    void equationExceptionMessageTest(String inputEquation) throws ExceptionMessage {
        getFullEquation(inputEquation);
    }

    @DataProvider
    public Object[][] tablesDataException() {
        return new Object[][]{
                {"111x^2+222x+335g3=0"},
                {"bad test3"},
                {"11y2+2x+1=0"},
                {"ololo"},
                {"4x^2+0x+1=0"}, //-
                {""}
        };
    }

    /**
     * Оставить для примера. Заметка: Текст обычно не проверяем, потому что текст могут поменять
     * @Test(description = "Проверяем текст ExceptionMessage если уравнение на вход не проходит проверку регурярки",
     *             dataProvider = "tablesDataException",
     *             expectedExceptions = ExceptionMessage.class,
     *             expectedExceptionsMessageRegExp = "Bad value: The equation you entered does NOT pass the regExp pattern test")
     *     void equationExceptionMessageTextTest(String inputEquation) throws ExceptionMessage {
     *
     *         getFullEquation(inputEquation);
     *     }
     */
}