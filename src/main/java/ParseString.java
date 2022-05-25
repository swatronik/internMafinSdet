import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseString {
    public static List<String> abcValues(String equation) throws Exception {
        try {
            String eq = equation;
            eq = eq.replace("=0", "");
            eq = eq.replace("x^2", "x");
            eq = eq.replace("+", "");
            String abcValue = eq.replaceAll("[^((\\d)|(\\-)|(\\.))]", ";");
//          [-][0-9]+[.][0-9]+|[0-9]+[.][0-9]+|[-][0-9]+[.][0-9]+|[+][0-9]+[.][0-9]+|[-][0-9]+|[+][0-9]+
            List<String> result = new ArrayList<String>(Arrays.asList(abcValue.split(";")));

            String testEq = "23x^2+2x+4=0";
            Pattern pattern = Pattern.compile("[-][0-9]+[.][0-9]+|[0-9]+[.][0-9]+|[-][0-9]+[.][0-9]+|[+][0-9]+[.][0-9]+|[-][0-9]+|[+][0-9]+");
            Matcher matcher = pattern.matcher(testEq);
            System.out.println(matcher.end() + " enters");

            return result;
        } catch (Exception e) {
            throw new Exception("some error in formula");
        }
    }
}
