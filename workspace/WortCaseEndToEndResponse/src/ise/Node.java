package ise;

import java.util.HashMap;

public class Node {
	private HashMap<Flow, Integer> capacity;

	public Node(HashMap<Flow, Integer> capacity) {
		super();
		this.capacity = capacity;
	}
	public HashMap<Flow, Integer> getCapacity() {
		return capacity;
	}

	public void setCapacity(HashMap<Flow, Integer> capacity) {
		this.capacity = capacity;
	}
}
