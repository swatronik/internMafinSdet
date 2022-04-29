package services.Validators;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Pattern;

public class EquationFormulaValidation implements IParameterValidator {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static final String QUADRATIC_EQUATION_VALIDATE_REGEX = "(^-?[\\d]*.?[\\d]*)([x][\\^][2])(-?[\\d]*.?[\\d]*)([x])(-?[\\d]*.?[\\d]*)([\\=][0])";

    public void validate(String name, String value) throws ParameterException {
        if (!isValidFormula(value)) {
            logger.error("Validation equation formula...failed");
            throw new ParameterException(
                    "Equation " + value + " is not a valid quadratic equation formula. Expected ax^2+bx+c=0.");
        }
    }

    private boolean isValidFormula(String value) {
        return Pattern.compile(QUADRATIC_EQUATION_VALIDATE_REGEX)
                .matcher(value)
                .matches();
    }
}