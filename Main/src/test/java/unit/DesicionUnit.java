package unit;

import equations.Equation;
import equations.EquationDecision;
import equations.Roots;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DesicionUnit {
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

    @Test
    public void testDesicionOneRoots() {
        Equation equation = new Equation(9, 6, 1);
        Roots roots = EquationDecision.decision(equation);
        Assert.assertEquals(-0.3333333333333333, roots.getX1());
    }
}
