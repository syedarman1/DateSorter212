/**
 * The IllegalDate212Exception class represents an exception specific to invalid Date212 instances.
 *
 * <p>This exception is a subclass of IllegalArgumentException and can be thrown when attempting
 * to create or manipulate Date212 objects with invalid data.</p>
 */
public class IllegalDate212Exception extends IllegalArgumentException {

    /**
     * Constructs an IllegalDate212Exception with no detail message.
     */
    public IllegalDate212Exception() {
        super();
    }

    /**
     * Constructs an IllegalDate212Exception with the specified detail message.
     *
     * @param message The detail message that provides information about the exception.
     */
    public IllegalDate212Exception(String message) {
        super(message);
    }

    /**
     * Constructs an IllegalDate212Exception with the specified detail message and a reference
     * to the runtime exception that caused this exception.
     *
     * @param message The detail message that provides information about the exception.
     * @param e       The runtime exception that caused this exception.
     */
    public IllegalDate212Exception(String message, RuntimeException e) {
        super(message, e);
    }
}