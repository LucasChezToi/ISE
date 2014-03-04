package ise;

import java.util.ArrayList;
import java.util.List;

public class Path {
	private List<Node> nodes;

	public Path(List<Node> nodes) {
		super();
		this.nodes = nodes;
	} 
	
	public Path() {
		super();
		this.nodes = new ArrayList<Node>();
	} 
	
	public void setNode(Node node) {
		nodes.add(node);
	}
	
	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}
	
	public Path pathRestrictedToH(Node H) {
		return null;
	}
}
