package test;

import static org.junit.Assert.*;
import ise.Algorithm;
import ise.Flow;
import ise.Network;
import ise.Node;

import org.junit.Before;
import org.junit.Test;

import exception.NodeDoesNotExistException;
import xml.XmlParser;

public class TestSlowest {
	Network net;
	Algorithm algo;
	/*
	Flow flow1;
	Flow flow2;
	Flow flow3;
	Flow flow4;
	Flow flow5;
	Flow flow6;
	Flow flow7;
	
	Node node1;
	Node node2;
	Node node3;
	Node node4;
	Node node5;
	Node node6;
	Node node7;
	Node node8;
	Node node9;
	Node node10;
	Node node11;
	Node node12;
	*/
	@Before
	public void setUp() throws Exception {
		XmlParser parser = new XmlParser("xml/example2.xml");
		parser.parse();
		net = parser.getNetwork();
		algo = new Algorithm(net);
		/*
		flow1 = net.findFlowById("f1");
		flow2 = net.findFlowById("f2");
		flow3 = net.findFlowById("f3");
		flow4 = net.findFlowById("f4");
		flow5 = net.findFlowById("f5");
		flow6 = net.findFlowById("f6");
		flow7 = net.findFlowById("f7");
		
		node1 = net.findNodeById("n1");
		node2 = net.findNodeById("n2");
		node3 = net.findNodeById("n3");
		node4 = net.findNodeById("n4");
		node5 = net.findNodeById("n5");
		node6 = net.findNodeById("n6");
		node7 = net.findNodeById("n7");
		node8 = net.findNodeById("n8");
		node9 = net.findNodeById("n9");
		node10 = net.findNodeById("n10");
		node11 = net.findNodeById("n11");
		node12 = net.findNodeById("n12");*/
	}
	
	/* Dans notre cas on devra toujours retomber sur les dernières 
	 * nodes car les capacités sont toutes égales 
	 * 
	 * Dans ces tests on utilise les fonctions lastXXX en supposant 
	 * qu'elles sont correctes */
	
	@Test
	public void testSlowestNodeVisitedByJonI(){
		for(Flow flowJ : net.getFlows() ){
			for(Flow flowI : net.getFlows()){
				try {
					assertEquals("J : " + flowJ.getId() + ", I : " + flowI.getId() + " ; Node calculé : " + algo.slowestNodeVisitedByJonI(flowJ, flowI).getId(),
							algo.lastNodeVisitedByJonI(flowJ, flowI), algo.slowestNodeVisitedByJonI(flowJ, flowI));
				}catch (NodeDoesNotExistException e) {
					System.out.println("Catched for, J=" + flowJ.getId() + ", I=" + flowI.getId());
				}
			}
		}
	}
	
	@Test
	public void testSlowestNodeVisitedByIonHisPathRestrictedToH() {
		for(Flow flow : net.getFlows()){
			for(Node node : net.getNodes()){
				try {
					assertEquals("flow= : " + flow.getId() + ", node attendue :" + node.getId() + " trouvée : " + algo.slowestNodeVisitedByIonHisPathRestrictedToH(flow, node).getId(),
							node, algo.slowestNodeVisitedByIonHisPathRestrictedToH(flow, node));
				}catch (NodeDoesNotExistException e) {
					System.out.println("Catched for, flow= : " + flow.getId() + ", node=" + node.getId());
				}
			}
		}
	}
	
	
	@Test
	public void testSlowestNodeVisitedByJonIRestrictedToH(){
		for(Flow flowJ : net.getFlows() ){
			for(Flow flowI : net.getFlows()){
				for(Node node : net.getNodes()){
					try {
						assertEquals("J : " + flowJ.getId() + ", I : " + flowI.getId() + " restriction : " + node.getId() + " ; Node calculé : " + algo.slowestNodeVisitedByJonI(flowJ, flowI).getId(),
								algo.lastNodeVisitedByJonIRestrictedToH(flowJ, flowI, node), algo.slowestNodeVisitedByJonIRestrictedToH(flowJ, flowI, node));
					}catch (NodeDoesNotExistException e) {
						System.out.println("Catched for, J=" + flowJ.getId() + ", I=" + flowI.getId());
					}
				}
			}
		}
	}
}
