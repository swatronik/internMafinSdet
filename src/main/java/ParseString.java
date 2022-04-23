import java.util.*;

public class ParseString {
    public static List<String> abcValues(String equation) throws Exception {
        try {
            String eq = equation;
            eq = eq.replace("=0", "");
            eq = eq.replace("x^2", "x");
            eq = eq.replace("+", "");
            String abcValue = eq.replaceAll("[^((\\d)|(\\-)|(\\.))]", ";");
            List<String> result = new ArrayList<String>(Arrays.asList(abcValue.split(";")));
            return result;
        } catch (Exception e) {
            throw new Exception("some error in formula");
        }
    }
}
