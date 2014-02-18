package ise;

import java.util.List;

public class Network {
	List<Flow> flows;
	List<Node> nodes;
	int lmax;
	int lmin;
	
	public Network(List<Flow> flows, List<Node> nodes, int lmax, int lmin) {
		super();
		this.flows = flows;
		this.nodes = nodes;
		this.lmax = lmax;
		this.lmin = lmin;
	}
	public List<Flow> getFlows() {
		return flows;
	}
	public void setFlows(List<Flow> flows) {
		this.flows = flows;
	}
	public List<Node> getNodes() {
		return nodes;
	}
	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}
	public int getLmax() {
		return lmax;
	}
	public void setLmax(int lmax) {
		this.lmax = lmax;
	}
	public int getLmin() {
		return lmin;
	}
	public void setLmin(int lmin) {
		this.lmin = lmin;
	}
}