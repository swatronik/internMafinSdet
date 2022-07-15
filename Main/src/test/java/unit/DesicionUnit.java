package unit;

import equations.Equation;
import equations.EquationDecision;
import equations.Roots;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DesicionUnit extends BaseTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(DesicionUnit.class);


    @DataProvider
    public Object[][] tablesData() {
        return new Object[][]{
                {9.0, 6.0, 1.0, -1.0 / 3.0, null, Roots.CountRoot.ONE_ROOT},
                {1.0, 2.0, -3.0, -3.0, 1.0, Roots.CountRoot.TWO_ROOTS},
                {1.0, 2.0, 3.0, null, null, Roots.CountRoot.NO_ROOTS}
        };
    }

    @Test(dataProvider = "tablesData")
    public void testDesicionTwoRoots(double a, double b, double c, Double x1, Double x2, Roots.CountRoot root) {
        coeffToLog(LOGGER, a, b, c);
        LOGGER.debug("x1=" + x1);
        LOGGER.debug("x2=" + x2);
        Equation equation = new Equation(a, b, c);
        Roots roots = EquationDecision.decision(equation);
        Assert.assertEquals(x1, roots.getX1());
        Assert.assertEquals(x2, roots.getX2());
        Assert.assertEquals(roots.getCountRoot(), root);
    }

}
