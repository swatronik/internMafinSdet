package unit;

import equations.Equation;
import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static util.ParserArgumentsUtil.parserArgumentsUtil;

public class ParserArgumentsUtilUnit extends BaseTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParserArgumentsUtilUnit.class);


    @DataProvider
    public Object[][] tablesDataCoefficients() {
        return new Object[][]{
                {new String[]{"-type", "coefficient", "-a", "9", "-b", "8", "-c", "1"}, 9.0, 8.0, 1.0},
                {new String[]{"-type", "coefficient", "-a", "-9", "-b", "-8", "-c", "-1"}, -9.0, -8.0, -1.0},
                {new String[]{"-type", "coefficient", "-a", "-9", "-b", "0", "-c", "0"}, -9.0, 0, 0},
                {new String[]{"-type", "coefficient", "-a", "-9.2", "-b", "0.1", "-c", "1.4"}, -9.2, 0.1, 1.4},
                {new String[]{"-type", "equation", "-e", "9x^2+8x+1=0"}, 9.0, 8.0, 1.0},
                {new String[]{"-type", "equation", "-e", "-9x^2-8x-1=0"}, -9.0, -8.0, -1.0},
                {new String[]{"-type", "equation", "-e", "-9x^2=0"}, -9.0, 0, 0},
                {new String[]{"-type", "equation", "-e", "-9.2x^2+0.1x+1.4=0"}, -9.2, 0.1, 1.4}

        };
    }

    @Test(dataProvider = "tablesDataCoefficients")
    public void testParserArgumentsUtilUnitCoef(String[] args, double a, double b, double c) throws ParseException, NumberFormatException {
        argsToLog(LOGGER, args);
        LOGGER.debug("a=" + a);
        LOGGER.debug("b=" + b);
        LOGGER.debug("c=" + c);
        Equation equation1 = parserArgumentsUtil(args);
        Assert.assertEquals(a, equation1.getA());
        Assert.assertEquals(b, equation1.getB());
        Assert.assertEquals(c, equation1.getC());
    }

    @DataProvider
    public Object[][] tablesDataNegative() {
        return new Object[][]{
                {new String[]{"-type", "-ffuuu", "-a", "9", "-b", "8", "-c", "1"}},
                {new String[]{"-type", "coefficient", "k", "-9", "-b", "-8", "-c", "-1"}},
                {new String[]{"-type", "coefficient", "53553..6646", "-9", "-b", "0", "-c", "0"}},
                {new String[]{"-rrr", "coefficient", "-a", "-9.2", "-b", "0.1", "-c", "1.4"}},
                {new String[]{"-type", "-ffuu", "-e", "9x^2+8x+1=0"}},
                {new String[]{"-type", "equation", "-ttt", "-9x^2-8x-1=0"}},
                {new String[]{"-rrr", "equation", "-e", "-9x^2=0"}},
        };
    }

    @Test(dataProvider = "tablesDataNegative", expectedExceptions = {ParseException.class})
    void argumentsValidatorTestNegative(String[] args) throws ParseException {
        argsToLog(LOGGER, args);
        parserArgumentsUtil(args);
    }

}
