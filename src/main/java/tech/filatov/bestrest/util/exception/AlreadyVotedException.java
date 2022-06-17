package tech.filatov.bestrest.util.exception;

public class AlreadyVotedException extends RuntimeException {
    public AlreadyVotedException(String message) {
        super(message);
    }
}
