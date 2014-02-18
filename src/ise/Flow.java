package ise;

import java.util.ArrayList;
import java.util.List;

public class Flow {
	private Path path;
	private int priority;
	private int deadline;
	private int period;
	private int jitter;
	private List<Flow> higherPriorityFlows;
	private List<Flow> samePriorityFlows;
	private List<Flow> LowerPriorityFlows;
	
	public Flow() {
		super();
	}
	
	public Flow(Path path, int priority, int deadline, int periode, int jitter) {
		super();
		this.path = path;
		this.priority = priority;
		this.deadline = deadline;
		this.period = periode;
		this.jitter = jitter;
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
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int periode) {
		this.period = periode;
	}
	public int getJitter() {
		return jitter;
	}
	public void setJitter(int jitter) {
		this.jitter = jitter;
	}
	public List<Flow> getHigherPriorityFlows() {
		return higherPriorityFlows;
	}

	public void setHigherPriorityFlows(List<Flow> higherPriorityFlows) {
		this.higherPriorityFlows = higherPriorityFlows;
	}

	public List<Flow> getSamePriorityFlows() {
		return samePriorityFlows;
	}

	public void setSamePriorityFlows(List<Flow> samePriorityFlows) {
		this.samePriorityFlows = samePriorityFlows;
	}

	public List<Flow> getLowerPriorityFlows() {
		return LowerPriorityFlows;
	}
	public void setLowerPriorityFlows(List<Flow> lowerPriorityFlows) {
		LowerPriorityFlows = lowerPriorityFlows;
	}
}
