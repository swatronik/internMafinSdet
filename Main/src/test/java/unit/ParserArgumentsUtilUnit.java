package unit;

import equations.Equation;
import org.apache.commons.cli.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static util.ParserArgumentsUtil.parserArgumentsUtil;

public class ParserArgumentsUtilUnit {
    @DataProvider
    public Object[][] tablesDataCoefficients() {
        return new Object[][]{
                {new String[]{"-type", "coefficient", "-a", "9", "-b", "8", "-c", "1"}, 9.0, 8.0, 1.0},
                {new String[]{"-type", "coefficient", "-a", "-9", "-b", "-8", "-c", "-1"}, -9.0, -8.0, -1.0},
                {new String[]{"-type", "coefficient", "-a", "-9", "-b", "0", "-c", "0"}, -9.0, 0, 0},
                {new String[]{"-type", "coefficient", "-a", "-9.2", "-b", "0.1", "-c", "1.4"}, -9.2, 0.1, 1.4}

        };
    }

    @Test(dataProvider = "tablesDataCoefficients")
    public void testParserArgumentsUtilUnitCoef(String[] args, double a, double b, double c) throws ParseException, NumberFormatException {
        Equation equation1 = parserArgumentsUtil(args);
        Assert.assertEquals(a, equation1.getA());
        Assert.assertEquals(b, equation1.getB());
        Assert.assertEquals(c, equation1.getC());
    }

    @DataProvider
    public Object[][] tablesDataEquaitions() {
        return new Object[][]{
                {new String[]{"-type", "equation", "-e", "9x^2+8x+1=0"}, 9.0, 8.0, 1.0},
                {new String[]{"-type", "equation", "-e", "-9x^2-8x-1=0"}, -9.0, -8.0, -1.0},
                {new String[]{"-type", "equation", "-e", "-9x^2=0"}, -9.0, 0, 0},
                {new String[]{"-type", "equation", "-e", "-9.2x^2+0.1x+1.4=0"}, -9.2, 0.1, 1.4}

        };
    }

    @Test(dataProvider = "tablesDataEquaitions")
    public void testParserArgumentsUtilUnitEq(String[] args, double a, double b, double c) throws ParseException, NumberFormatException {
        Equation equation1 = parserArgumentsUtil(args);
        Assert.assertEquals(a, equation1.getA());
        Assert.assertEquals(b, equation1.getB());
        Assert.assertEquals(c, equation1.getC());
    }
}
