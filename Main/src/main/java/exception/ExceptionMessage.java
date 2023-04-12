package exception;

public class ExceptionMessage extends Exception {

    public ExceptionMessage(String message) {
        super("Bad value: " + message);
    }
}