package services.Commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import services.Validators.ValidateREGEX;

@Parameters(
        commandNames = "formula",
        commandDescription = "Parametr means that full formula of quadratic equation expected afet space"
)
public class CommandFormula {
    @Parameter(
            description = "Required parametr after cmd 'formula'",
            required = true,
            validateWith = ValidateREGEX.class
    )
    private String equation;


    private String[] parseArgsFromString() {
        Pattern pattern = Pattern.compile("([-+]?\\d*\\.?\\d+(?:[eE][+-]?\\d+)?)");
        Matcher matcher = pattern.matcher(equation);
        String[] ArgsArray = new String[5];
        int i = 0;
        while (matcher.find()) {
            ArgsArray[i] = equation.substring(matcher.start(), matcher.end());
            i++;
            }
        return ArgsArray;
        }


    public String getEquation() {
        return equation;
    }

    public double getFirstArr() {
        return Double.parseDouble(parseArgsFromString()[0]);
    }

    public double getSecondArr() {
        return Double.parseDouble(parseArgsFromString()[2]);
    }

    public double getThirdArr() {
        return Double.parseDouble(parseArgsFromString()[3]);
    }
}