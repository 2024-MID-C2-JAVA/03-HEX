package co.com.sofka.exceptions;

public class MinimumAmountNotReachedException extends RuntimeException {
    public MinimumAmountNotReachedException(String message) {
        super(message);
    }
}
