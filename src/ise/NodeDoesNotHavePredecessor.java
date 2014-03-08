package ise;
 
public class NodeDoesNotHavePredecessor extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5602831760625906553L;
	public String message;
    
    public NodeDoesNotHavePredecessor(String message) {
	this.message = message;
    }
}
