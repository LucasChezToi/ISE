package ise;

import java.util.ArrayList;
import java.util.List;

import exception.NodeDoesNotExistException;

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
	
	public Path pathRestrictedToH(Node h) throws NodeDoesNotExistException{
		if(!this.getNodes().contains(h)) {
			throw new NodeDoesNotExistException("");
		}
		Path p = new Path();
		p.setNodes(this.nodes.subList(0, nodes.indexOf(h)+1));
		return p;
	}
}
