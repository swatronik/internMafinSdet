package equation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SolutionEquationTest {

    public static Logger logger = LoggerFactory.getLogger(SolutionEquationTest.class);

    @DataProvider(name = "patternEquationPositive")
    public static Object[][] patternEquationPositive() {
        return new Object[][]{
                {new Equation(4.0, 2.0, 1.0), new Roots()},
                {new Equation(1.0, -6.0, 9.0), new Roots(3.0)},
                {new Equation(1.0, -7.0, -30.0), new Roots(10.0, -3.0)},
                {new Equation(1.0, -7.0, -30.0), new Roots(-3.0, 10.0)},
                {new Equation(1.0, -7.0, -30.0), new Roots()}
        };
    }

    @Test(description = "Проверка решения уравнения",
            dataProvider = "patternEquationPositive")
    public void patternEquationPositive(Equation equation, Roots roots) {
        Roots solution = SolutionEquation.solution(equation);
        Assert.assertEquals(solution, roots);
        logger.info(String.format("Solution = %s, Roots = %s", solution, roots));
    }
}