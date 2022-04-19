package exceptions;

import org.apache.commons.cli.ParseException;

public class ParseArgumentsException extends ParseException {

    public ParseArgumentsException(String message) {
        super("Invalid option "+ message);
    }
}
