package ise;

public class NodeDoesNotExistException extends Exception {
	public String message;
	/**
	 * generated ID
	 */
	private static final long serialVersionUID = 6905916248289513991L;
	
	public NodeDoesNotExistException(String message) {
		this.message = message;
	}
}
