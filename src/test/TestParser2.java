package test;

import static org.junit.Assert.*;
import ise.Flow;
import ise.Network;
import ise.Node;
import ise.Path;

import org.junit.Before;
import org.junit.Test;

import xml.XmlParser;

public class TestParser2 {
	Network net;
	
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


	@Before
	public void setUp() throws Exception {
			XmlParser parser = new XmlParser("xml/example2.xml");
			parser.parse();
			net = parser.getNetwork();
			
			// Premet de rendre les tests plus compréhensibles
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
			
	}

	@Test
	public void testNetwork() {
		assertNotNull(net);
		assertEquals(1, net.getLmax());
		assertEquals(1, net.getLmin());
		assertNotNull(net.getNodes());
		assertNotNull(net.getFlows());
		assertEquals(11, net.getNodes().size());
		assertEquals(7, net.getFlows().size());
	}
	
	// Test des valeurs communes à tous les flows
	@Test
	public void testFlows() {
		assertEquals(7, net.getFlows().size());
		assertNotNull(flow1);
		assertNotNull(flow2);
		assertNotNull(flow3);
		assertNotNull(flow4);
		assertNotNull(flow5);
		assertNotNull(flow6);
		assertNotNull(flow7);
		
		for (Flow flow : net.getFlows()) {
			assertNotNull(flow);
			assertEquals(36, flow.getPeriod());
			assertEquals(0, flow.getJitter());
			assertNotNull(flow.getPath());
			assertEquals(11, flow.getPriority());
			assertEquals(54, flow.getDeadline());
		}
	}
	
	@Test
	public void testPath1(){
		Path path = net.getFlows().get(0).getPath();
		assertNotNull(path);
		assertEquals(node1, path.getNodes().get(0));
		assertEquals(node3, path.getNodes().get(1));
		assertEquals(node2, path.getNodes().get(2));
		assertEquals(node11, path.getNodes().get(3));
	}

	@Test
	public void testPath2(){
		Path path = net.getFlows().get(1).getPath();
		assertNotNull(path);
		assertEquals(node9, path.getNodes().get(0));
		assertEquals(node10, path.getNodes().get(1));
		assertEquals(node7, path.getNodes().get(2));
		assertEquals(node4, path.getNodes().get(3));
		assertEquals(node5, path.getNodes().get(4));
		
	}

	@Test
	public void testPath3(){
		Path path = net.getFlows().get(2).getPath();
		assertNotNull(path);
		assertEquals(node2, path.getNodes().get(0));
		assertEquals(node3, path.getNodes().get(1));
		assertEquals(node4, path.getNodes().get(2));
		assertEquals(node7, path.getNodes().get(3));
		assertEquals(node10, path.getNodes().get(4));
		
	}

	@Test
	public void testPath4(){
		Path path = net.getFlows().get(3).getPath();
		assertNotNull(path);
		assertEquals(node2, path.getNodes().get(0));
		assertEquals(node3, path.getNodes().get(1));
		assertEquals(node4, path.getNodes().get(2));
		assertEquals(node7, path.getNodes().get(3));
		assertEquals(node10, path.getNodes().get(4));
		
	}

	@Test
	public void testPath5(){
		Path path = net.getFlows().get(4).getPath();
		assertNotNull(path);
		assertEquals(node8, path.getNodes().get(0));
		assertEquals(node6, path.getNodes().get(1));
		assertEquals(node10, path.getNodes().get(2));
		
	}

	@Test
	public void testPath6(){
		Path path = net.getFlows().get(5).getPath();
		assertNotNull(path);
		assertEquals(node5, path.getNodes().get(0));
		assertEquals(node1, path.getNodes().get(1));
		assertEquals(node3, path.getNodes().get(2));
		assertEquals(node6, path.getNodes().get(3));
		
	}

	@Test
	public void testPath7(){
		Path path = net.getFlows().get(6).getPath();
		assertNotNull(path);
		assertEquals(node2, path.getNodes().get(0));
		assertEquals(node11, path.getNodes().get(1));
		
	}
	
	@Test
	public void testNodes() {
		assertEquals(11, net.getNodes().size());
		assertNotNull(node1);
		assertNotNull(node2);
		assertNotNull(node3);
		assertNotNull(node4);
		assertNotNull(node5);
		assertNotNull(node6);
		assertNotNull(node7);
		assertNotNull(node8);
		assertNotNull(node9);
		assertNotNull(node10);
		assertNotNull(node11);
	}
}
