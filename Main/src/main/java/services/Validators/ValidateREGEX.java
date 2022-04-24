package services.Validators;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Pattern;

public class ValidateREGEX implements IParameterValidator {

    private static final String QuadraticEquation_REGEX = "((-?[1-9][\\d]+\\.?[\\d]+)|(-?[1-9]\\.?[\\d]?)|(-?[\\d]\\.[\\d]+))(x\\^2)(\\+|-)((-?[1-9][\\d]+\\.?[\\d]+)|(-?[1-9]\\.?[\\d]?)|(-?[\\d]\\.[\\d]+))(x)(\\+|-)((-?[1-9][\\d]+\\.?[\\d]+)|(-?[1-9]\\.?[\\d]?)|(-?[\\d]\\.[\\d]+))([=])([0])";

    public void validate(String name, String value) throws ParameterException {
        if (!isValidUUID(value)) {
            logger.error("Validation equation formula...failed");
            throw new ParameterException(
                    "Equation " + value + " is not a valid quadratic equation formula. Expected ax^2+bx+c=0.");
        }
    }

    private boolean isValidUUID(String value) {
        return Pattern.compile(QuadraticEquation_REGEX)
                .matcher(value)
                .matches();
    }
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
}