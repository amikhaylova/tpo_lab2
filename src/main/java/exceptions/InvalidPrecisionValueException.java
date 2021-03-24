package exceptions;

public class InvalidPrecisionValueException extends RuntimeException{
    public InvalidPrecisionValueException(Double eps){
        super("Invalid precision value: " + eps + ". Must be positive and less than 1.0.");
    }
}
