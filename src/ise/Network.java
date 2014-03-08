package ise;

import java.util.ArrayList;
import java.util.List;

public class Network {
	List<Flow> flows;
	List<Node> nodes;
	int lmax;
	int lmin;
	
	public Network() {
		super();
		flows = new ArrayList<Flow>();
		nodes = new ArrayList<Node>();
	}
	
	public Network(List<Flow> flows, List<Node> nodes, int lmax, int lmin) {
		super();
		this.flows = flows;
		this.nodes = nodes;
		this.lmax = lmax;
		this.lmin = lmin;
	}
	
	/**
	 * Initialisation pour chaque Flow de leurs variables hpf, spf et lpf
	 */
	public void init(){
		int i = 0, j = 0;
		Flow current_flow = null, compared_flow = null;
		for(i = 0; i < flows.size(); i++){
			List<Flow> hpf = new ArrayList<Flow>();
			List<Flow> spf = new ArrayList<Flow>();
			List<Flow> lpf = new ArrayList<Flow>();
			current_flow = flows.get(i); 
			for(j = 0; j < flows.size(); j++){
				compared_flow = flows.get(j);
				if(current_flow.getPriority() == compared_flow.getPriority()){
					if(j != i) spf.add(compared_flow);
				}
				else if(current_flow.getPriority() > compared_flow.getPriority()) lpf.add(compared_flow);
				else if(current_flow.getPriority() < compared_flow.getPriority()) hpf.add(compared_flow);
			}
			current_flow.setHigherPriorityFlows(hpf);
			current_flow.setLowerPriorityFlows(lpf);
			current_flow.setSamePriorityFlows(spf);
		}
	}
	
	public void addFlow(Flow flow) {
		flows.add(flow);
	}
	
	public void addNode(Node node) {
		nodes.add(node);
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
