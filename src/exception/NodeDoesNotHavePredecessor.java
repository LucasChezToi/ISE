package exception;

public class NodeDoesNotHavePredecessor extends Exception {
	public String message;
	
	public NodeDoesNotHavePredecessor(String message) {
		this.message = message;
	}
}
