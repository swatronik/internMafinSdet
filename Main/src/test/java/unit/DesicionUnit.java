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

    @DataProvider
    public Object[][] tablesDataNoRoots() {
        return new Object[][]{
                {1.0,2.0,3.0,Roots.CountRoot.NO_ROOTS}
        };
    }

    @Test(dataProvider = "tablesDataNoRoots")
    public void testDesicionNoRoots(double a, double b, double c, Roots.CountRoot root) {
        Equation equation = new Equation(a, b, c);
        Roots roots = EquationDecision.decision(equation);
        Assert.assertNull(roots.getX1());
        Assert.assertNull(roots.getX2());
        Assert.assertEquals(roots.getCountRoot(),root);
    }

    @DataProvider
    public Object[][] tablesDataTwoRoots() {
        return new Object[][]{
                {1.0,2.0,-3.0,-3.0,1.0,Roots.CountRoot.TWO_ROOTS}
        };
    }

    @Test(dataProvider = "tablesDataTwoRoots")
    public void testDesicionTwoRoots(double a, double b, double c, double x1,double x2, Roots.CountRoot root) {
        Equation equation = new Equation(a, b, c);
        Roots roots = EquationDecision.decision(equation);
        Assert.assertEquals(x1, roots.getX1());
        Assert.assertEquals(x2,roots.getX2());
        Assert.assertEquals(roots.getCountRoot(),root);
    }

}
