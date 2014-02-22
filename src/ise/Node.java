package ise;

import java.util.HashMap;

public class Node {
	private HashMap<Flow, Integer> capacity;
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Node() {
		super();
	}
	public Node(int id) {
		this.id = id;
	}
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
