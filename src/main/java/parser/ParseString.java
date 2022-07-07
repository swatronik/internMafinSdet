package parser;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseString {
    public static List<String> abcValues(String equation) {
        List<String> result = new LinkedList<>();
        String eq = equation;
        Pattern pattern = Pattern.compile("(((\\+|-|)((\\d+)|(\\d+\\.\\d+)))(x\\^2)((\\+|-|)((\\d+)|(\\d+\\.\\d+)))(x)((\\+|-|)((\\d+)|(\\d+\\.\\d+)))(=0))");
        Matcher matcher = pattern.matcher(eq);
        System.out.println(matcher.matches());
        if (matcher.matches()) {
            result.add(matcher.group(2).replace("+", ""));
            result.add(matcher.group(8).replace("+", ""));
            result.add(matcher.group(14).replace("+", ""));
        }
        return result;
    }
}
