package unit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static constants.Const.ARG_EQUATION_PATTERN;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class RegExpUnit {

    @Test(dataProvider = "tablesData")
    void EquationValidatorTestPositive(String equation) {
        boolean result = equation.matches(ARG_EQUATION_PATTERN);
        assertTrue(result);
    }

    @DataProvider
    public Object[][] tablesDataPositive() {
        return new Object[][]{
                {"4x^2+0x+1=0"},
                {"-4x^2+2x+1=0"},
                {"5675.3243x^2-8x+12=0"},
                {"5675.3243x^2-8.45435435x+12.1223=0"},
                {"x^2=0"},
                {"x^2+1=0"},
                {"x^2+2x=0"},
        };
    }

    @Test(dataProvider = "tablesDataNegative")
    void EquationValidatorTestNegative(String equation) {
        boolean result = equation.matches(ARG_EQUATION_PATTERN);
        assertFalse(result);
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
}


