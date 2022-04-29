package services.Commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import services.Validators.EquationFormulaValidation;

@Parameters(
        commandNames = "formula",
        commandDescription = "Parametr means that full formula of quadratic equation expected afet space"
)
public class CommandFormula {
    @Parameter(
            description = "Required parametr after cmd 'formula'",
            required = true,
            validateWith = EquationFormulaValidation.class
    )
    private String equation;


    private String[] parseArgsFromString() {
        Pattern pattern = Pattern.compile(EquationFormulaValidation.QUADRATIC_EQUATION_VALIDATE_REGEX);
        Matcher matcher = pattern.matcher(equation);
        String[] ArgsArray = new String[3];
        while (matcher.find()) {
            ArgsArray[0] = String.valueOf(matcher.group(1));
            ArgsArray[1] = String.valueOf(matcher.group(3));
            ArgsArray[2] = String.valueOf(matcher.group(5));
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
        return Double.parseDouble(parseArgsFromString()[1]);
    }

    public double getThirdArr() {
        return Double.parseDouble(parseArgsFromString()[2]);
    }
}