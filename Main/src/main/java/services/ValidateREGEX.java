package services;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

import java.util.regex.Pattern;

public class ValidateREGEX implements IParameterValidator {

    private static final String QuadraticEquation_REGEX = "[0-9a-fA-F]{8}(-[0-9a-fA-F]{4}){3}-[0-9a-fA-F]{12}";

    public void validate(String name, String value) throws ParameterException {
        if (!isValidUUID(value)) {
            throw new ParameterException(
                    "Equation " + value + " is not a valid equation.");
        }
    }

    private boolean isValidUUID(String value) {
        return Pattern.compile(QuadraticEquation_REGEX)
                .matcher(value)
                .matches();
    }


}
