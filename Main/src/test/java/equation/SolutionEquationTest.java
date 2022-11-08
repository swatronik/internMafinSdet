package equation;

import exception.ExceptionMessage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SolutionEquationTest {

    @DataProvider(name = "solutionEquation")
    public static Object[][] solutionEquation() {
        return new Object[][]{

                {2.0, -11.2, 15.5, 3.1, 2.5},

//                {1.1, 2.2, 3.3, 0.31, -0.81},
//                {4.0, 2.0, -1.0, 0.31, -0.81, Roots.CountRoot.TWO_ROOTS},
//                {"1x^2-6x+9=0", 1.1, 2.2, 3.3, 3.00, null},
//                {"4x^2+0x+1=0", 1.1, 2.2, 3.3, null, null}
        };
    }

    @Test(description = "Проверка решения уравнения на получение разных видов корней",
            dataProvider = "solutionEquation",
            expectedExceptions = {ExceptionMessage.class})
    public void testSolutionEquation(Double a, Double b, Double c, Double x1, Double x2) {

        Equation equation = new Equation(a, b, c);
        Roots roots = SolutionEquation.solution(equation);

        Assert.assertEquals(roots.getX1(), x1);
        Assert.assertEquals(roots.getX2(), x2);
    }
}