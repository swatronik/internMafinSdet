package unit_tests;
import org.testng.Assert;
import parser.ParseString;

import org.testng.annotations.Test;

import java.util.List;

public class UnitTest extends BaseTest {
    @Test(description = "check regular expression from parser.ParseString class")
    public void checkRegular(){
        List<String> result = ParseString.abcValues("3x^2+5x+6=0");
        Assert.assertTrue(Float.parseFloat(result.get(0)) == 3);
        Assert.assertTrue(Float.parseFloat(result.get(1)) == 5);
        Assert.assertTrue(Float.parseFloat(result.get(2)) == 6);
//        System.out.println(result.get(0).toString());
    }
}
