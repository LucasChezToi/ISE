package test;

import static org.junit.Assert.*;
import ise.Flow;
import ise.Network;
import ise.Node;
import ise.Path;

import org.junit.Before;
import org.junit.Test;

import xml.XmlParser;

public class TestParser {
	Network net;
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
	
	Flow flow1;
	Flow flow2;
	Flow flow3;
	Flow flow4;
	Flow flow5;
	
	@Before
	public void setUp() throws Exception {
		XmlParser parser = new XmlParser("xml/example1.xml");
		parser.parse();
		net = parser.getNetwork();

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
		
		flow1 = net.findFlowById("f1");
		flow2 = net.findFlowById("f2");
		flow3 = net.findFlowById("f3");
		flow4 = net.findFlowById("f4");
		flow5 = net.findFlowById("f5");
		
	}

	@Test
	public void testNetwork() {
		assertNotNull(net);
		assertEquals(1, net.getLmax());
		assertEquals(1, net.getLmin());
		assertNotNull(net.getNodes());
		assertNotNull(net.getFlows());
		assertEquals(11, net.getNodes().size());
		assertEquals(5, net.getFlows().size());
	}
	
	// Test des valeurs communes à tous les flows
	@Test
	public void testFlows() {
		for (Flow flow : net.getFlows()) {
			assertNotNull(flow);
			assertEquals(36, flow.getPeriod());
			assertEquals(0, flow.getJitter());
			assertNotNull(flow.getPath());
		}
	}

	@Test
	public void testFlow1() {
		Flow flow = flow1;

		assertNotNull(flow);
		assertEquals("f1", flow.getId());
		assertEquals(10, flow.getPriority());
		assertEquals(36, flow.getDeadline());
	}

	@Test
	public void testFlow2() {
		Flow flow = flow2;

		assertNotNull(flow);
		assertEquals("f2", flow.getId());
		assertEquals(10, flow.getPriority());
		assertEquals(36, flow.getDeadline());
	}

	@Test
	public void testFlow3() {
		Flow flow = flow3;

		assertNotNull(flow);
		assertEquals("f3", flow.getId());
		assertEquals(11, flow.getPriority());
		assertEquals(54, flow.getDeadline());
	}

	@Test
	public void testFlow4() {
		Flow flow = flow4;

		assertNotNull(flow);
		assertEquals("f4", flow.getId());
		assertEquals(11, flow.getPriority());
		assertEquals(54, flow.getDeadline());
	}

	@Test
	public void testFlow5() {
		Flow flow = flow5;

		assertNotNull(flow);
		assertEquals("f5", flow.getId());
		assertEquals(12, flow.getPriority());
		assertEquals(45, flow.getDeadline());
	}
	
	@Test
	public void testPath1() {
		Path path = flow1.getPath();
		assertNotNull(path);
		assertEquals(4, path.getNodes().size());
		assertEquals(node1, path.getNodes().get(0));
		assertEquals(node3, path.getNodes().get(1));
		assertEquals(node4, path.getNodes().get(2));
		assertEquals(node5, path.getNodes().get(3));
	}
	
	@Test
	public void testPath2() {
		Path path = flow2.getPath();
		assertNotNull(path);
		assertEquals(4, path.getNodes().size());
		assertEquals(node9, path.getNodes().get(0));
		assertEquals(node10, path.getNodes().get(1));
		assertEquals(node7, path.getNodes().get(2));
		assertEquals(node6, path.getNodes().get(3));
		
	}
	
	@Test
	public void testPath3() {
		Path path = flow3.getPath();
		assertNotNull(path);
		assertEquals(6, path.getNodes().size());
		assertEquals(node2, path.getNodes().get(0));
		assertEquals(node3, path.getNodes().get(1));
		assertEquals(node4, path.getNodes().get(2));
		assertEquals(node7, path.getNodes().get(3));
		assertEquals(node10, path.getNodes().get(4));
		assertEquals(node11, path.getNodes().get(5));
	}
	
	@Test
	public void testPath4() {
		Path path = flow4.getPath();
		assertNotNull(path);
		assertEquals(6, path.getNodes().size());
		assertEquals(node2, path.getNodes().get(0));
		assertEquals(node3, path.getNodes().get(1));
		assertEquals(node4, path.getNodes().get(2));
		assertEquals(node7, path.getNodes().get(3));
		assertEquals(node10, path.getNodes().get(4));
		assertEquals(node11, path.getNodes().get(5));
	}
	
	@Test
	public void testPath5() {
		Path path = flow5.getPath();
		assertNotNull(path);
		assertEquals(5, path.getNodes().size());
		assertEquals(node2, path.getNodes().get(0));
		assertEquals(node3, path.getNodes().get(1));
		assertEquals(node4, path.getNodes().get(2));
		assertEquals(node7, path.getNodes().get(3));
		assertEquals(node8, path.getNodes().get(4));
	}
	

	
	@Test
	public void testNodes() {
		assertEquals(11, net.getNodes().size());
		for(Node node : net.getNodes()){
			for(Flow flow : net.getFlows()){
				if(flow.getPath().getNodes().contains(node)){
					assertEquals("Node with id : " + node.getId(), 
							(Integer) 4, node.getCapacity().get(flow));
				}else{
					// Si un flot ne passe pas par une node, la capacité de la node pour ce flot est de 0
					assertEquals("Node with id : " + node.getId(), 
							(Integer) 0,  node.getCapacity().get(flow));
				}
			}
		}
	}

}
