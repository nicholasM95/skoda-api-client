package be.nicholasmeyers.skoda.api.client;

/**
 * Exception thrown to indicate a failure during car service operations.
 * <p>
 * This exception provides both a user-friendly message and the original message
 * from a lower-level service or component, allowing for more detailed diagnostics.
 * </p>
 */
public class CarServiceException extends RuntimeException {

    private final String originalMessage;

    /**
     * Constructs a new {@code CarServiceException} with the specified detail message
     * and the original message from the source of the error.
     *
     * @param message         a user-friendly message describing the exception
     * @param originalMessage the original message from the underlying system or service
     */
    public CarServiceException(String message, String originalMessage) {
        super(message);
        this.originalMessage = originalMessage;
    }

    /**
     * Returns the original message from the underlying system or service that caused the exception.
     *
     * @return the original error message
     */
    public String getOriginalMessage() {
        return originalMessage;
    }
}
