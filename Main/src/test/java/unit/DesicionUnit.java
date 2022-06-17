package unit;

import equations.Equation;
import equations.EquationDecision;
import equations.Roots;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DesicionUnit {
    @DataProvider
    public Object[][] tablesDataOneRoot() {
        return new Object[][]{
                {9.0,6.0,1.0,-1.0/3.0,Roots.CountRoot.ONE_ROOT}
        };
    }

    @Test(dataProvider = "tablesDataOneRoot")
    public void testDesicionOneRoots(double a, double b, double c, double x1, Roots.CountRoot root) {
        Equation equation = new Equation(a, b, c);
        Roots roots = EquationDecision.decision(equation);
        Assert.assertEquals(x1, roots.getX1());
        Assert.assertNull(roots.getX2());
        Assert.assertEquals(roots.getCountRoot(),root);
    }


    @Test
    public void testDesicionNoRoots() {
        Equation equation = new Equation(1, 3, 3);
        Roots roots = EquationDecision.decision(equation);
        Assert.assertEquals("No roots", roots.toString());
    }

    @Test
    public void testDesicionTwoRoots() {
        Equation equation = new Equation(1, 2, -3);
        Roots roots = EquationDecision.decision(equation);
        Assert.assertEquals(-3.0, roots.getX1());
        Assert.assertEquals(1.0, roots.getX2());
    }

}
