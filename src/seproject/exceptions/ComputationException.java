package seproject.exceptions;

/**
 * Exception class to handle computation-related failures. This exception is
 * thrown for an issue with the computation proccess, such as invalid input,
 * processing failures, or output storage errors.
 */

/*
 * Constructs a new ComputationException with the specified message
 * 
 * @param message The message explaining the reason for the exception
 * 
 */
public class ComputationException extends Exception {
	public ComputationException(String message) {
		super(message);
	}

	/*
	 * Constructs a new ComputationException with the specified message and cause.
	 *
	 * @param message the message explaining the reason for the exception
	 * 
	 * @param cause The underlying cause of the exception
	 */
	public ComputationException(String message, Throwable cause) {
		super(message, cause);
	}

}
