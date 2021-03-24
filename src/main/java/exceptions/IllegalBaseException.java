package exceptions;

public class IllegalBaseException extends RuntimeException {
    public IllegalBaseException(int base){
        super("Invalid base value: " + base + ". Must be positive.");
    }
}
