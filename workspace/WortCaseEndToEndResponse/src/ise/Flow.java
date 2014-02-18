package ise;

import java.util.ArrayList;
import java.util.List;

public class Flow {
	private Path path;
	private int priority;
	private int deadline;
	private int periode;
	private int jitter;
	
	public Flow(Path path, int priority, int deadline, int periode, int jitter) {
		super();
		this.path = path;
		this.priority = priority;
		this.deadline = deadline;
		this.periode = periode;
		this.jitter = jitter;
	}
	
	List<Flow> higherPriorityFlows() {
		return null;
	}
	
	List<Flow> samePriorityFlows() {
		return null;
	}
	
	List<Flow> LowerPriorityFlows() {
		return null;
	}
	
	public Path getPath() {
		return path;
	}
	public void setPath(Path path) {
		this.path = path;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getDeadline() {
		return deadline;
	}
	public void setDeadline(int deadline) {
		this.deadline = deadline;
	}
	public int getPeriode() {
		return periode;
	}
	public void setPeriode(int periode) {
		this.periode = periode;
	}
	public int getJitter() {
		return jitter;
	}
	public void setJitter(int jitter) {
		this.jitter = jitter;
	}
}