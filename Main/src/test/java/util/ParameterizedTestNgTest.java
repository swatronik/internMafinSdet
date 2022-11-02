package util;

import equation.Equation;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import patternRegexp.PatternRegexp;

import java.util.Optional;

import static util.ParserArgumentUtil.parserArgument;

public class ParameterizedTestNgTest {
    private PrimeNumberChecker primeNumberChecker;

//    @BeforeMethod
//    public void initialize() {
//        primeNumberChecker = new PrimeNumberChecker();
//    }
//
//    @DataProvider(name = "test1")
//    public static Object[][] primeNumbers() {
//        return new Object[][] {
//                {2, true},
//                {6, false},
//                {19, true},
//                {22, false},
//                {23, true}};
//    }
//
//    @Test(dataProvider = "test1")
//    public void testPrimeNumberChecker(Integer inputNumber, Boolean expectedResult) {
//        System.out.println(inputNumber + " " + expectedResult);
//        Assert.assertEquals(expectedResult, primeNumberChecker.validate(inputNumber));
//    }


    @DataProvider(name = "equationExamplePositive")
    public static Object[][] equationNumbers() {
        return new Object[][] {
                {"111x^2+222x+335g3=0"},
                {"bad test3"},
                {"4x^2+0x+1=0"}};

        }

        @Test(dataProvider = "equationExamplePositive")
        public void equationExamplePositive(String inputEquation) {
            //Assert.assertEquals(expectedResult, primeNumberChecker.validate(inputNumber));
            //boolean resultPatternRegexp = inputEquation.matches(PatternRegexp.patternEquation);
            //Assert(resultPatternRegexp);

            boolean result = inputEquation.matches(PatternRegexp.patternEquation);
            Assert.assertEquals(result, true);
        }
}
