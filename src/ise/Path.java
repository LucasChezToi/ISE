package ise;

import java.util.List;

public class Path {
	private List<Node> nodes;

	public Path(List<Node> nodes) {
		super();
		this.nodes = nodes;
	} 
	
	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}
}
