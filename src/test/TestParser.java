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
	Network network;
	
	@Before
	public void setUp() throws Exception {
		XmlParser parser = new XmlParser("xml/example1.xml");
		parser.parse();
		network = parser.getNetwork();
	}

	@Test
	public void testNetwork() {
		assertNotNull(network);
		assertEquals(1, network.getLmax());
		assertEquals(1, network.getLmin());
		assertNotNull(network.getNodes());
		assertNotNull(network.getFlows());
		assertEquals(11, network.getNodes().size());
		assertEquals(5, network.getFlows().size());
	}
	
	// Test des valeurs communes à tous les flows
	@Test
	public void testFlows() {
		for (Flow flow : network.getFlows()) {
			assertNotNull(flow);
			assertEquals(36, flow.getPeriod());
			assertEquals(0, flow.getJitter());
			assertNotNull(flow.getPath());
		}
	}

	@Test
	public void testFlow1() {
		Flow flow = network.getFlows().get(0);

		assertNotNull(flow);
		assertEquals(10, flow.getPriority());
		assertEquals(36, flow.getDeadline());
	}

	@Test
	public void testFlow2() {
		Flow flow = network.getFlows().get(1);

		assertNotNull(flow);
		assertEquals(10, flow.getPriority());
		assertEquals(36, flow.getDeadline());
	}

	@Test
	public void testFlow3() {
		Flow flow = network.getFlows().get(2);

		assertNotNull(flow);
		assertEquals(11, flow.getPriority());
		assertEquals(54, flow.getDeadline());
	}

	@Test
	public void testFlow4() {
		Flow flow = network.getFlows().get(3);

		assertNotNull(flow);
		assertEquals(11, flow.getPriority());
		assertEquals(54, flow.getDeadline());
	}

	@Test
	public void testFlow5() {
		Flow flow = network.getFlows().get(4);

		assertNotNull(flow);
		assertEquals(12, flow.getPriority());
		assertEquals(45, flow.getDeadline());
	}
	
	@Test
	public void testPath1() {
		Path path = network.getFlows().get(0).getPath();
		assertNotNull(path);
		assertEquals(network.getNodes().get(0), path.getNodes().get(0));
		assertEquals(network.getNodes().get(2), path.getNodes().get(1));
		assertEquals(network.getNodes().get(3), path.getNodes().get(2));
		assertEquals(network.getNodes().get(4), path.getNodes().get(3));
	}
	
	@Test
	public void testPath2() {
		Path path = network.getFlows().get(1).getPath();
		assertNotNull(path);
		assertEquals(network.getNodes().get(8), path.getNodes().get(0));
		assertEquals(network.getNodes().get(9), path.getNodes().get(1));
		assertEquals(network.getNodes().get(6), path.getNodes().get(2));
		assertEquals(network.getNodes().get(5), path.getNodes().get(3));
		
	}
	
	@Test
	public void testPath3() {
		Path path = network.getFlows().get(2).getPath();
		assertNotNull(path);
		assertEquals(network.getNodes().get(1), path.getNodes().get(0));
		assertEquals(network.getNodes().get(2), path.getNodes().get(1));
		assertEquals(network.getNodes().get(3), path.getNodes().get(2));
		assertEquals(network.getNodes().get(6), path.getNodes().get(3));
		assertEquals(network.getNodes().get(9), path.getNodes().get(4));
		assertEquals(network.getNodes().get(10), path.getNodes().get(5));
	}
	
	@Test
	public void testPath4() {
		Path path = network.getFlows().get(3).getPath();
		assertNotNull(path);
		assertEquals(network.getNodes().get(1), path.getNodes().get(0));
		assertEquals(network.getNodes().get(2), path.getNodes().get(1));
		assertEquals(network.getNodes().get(3), path.getNodes().get(2));
		assertEquals(network.getNodes().get(6), path.getNodes().get(3));
		assertEquals(network.getNodes().get(9), path.getNodes().get(4));
		assertEquals(network.getNodes().get(10), path.getNodes().get(5));
	}
	
	@Test
	public void testPath5() {
		Path path = network.getFlows().get(4).getPath();
		assertNotNull(path);
		assertEquals(network.getNodes().get(1), path.getNodes().get(0));
		assertEquals(network.getNodes().get(2), path.getNodes().get(1));
		assertEquals(network.getNodes().get(3), path.getNodes().get(2));
		assertEquals(network.getNodes().get(6), path.getNodes().get(3));
		assertEquals(network.getNodes().get(7), path.getNodes().get(4));
	}
	
	@Test
	public void testNodes() {
		for(Node node : network.getNodes()){
			for(Flow flow : network.getFlows()){
				assertEquals("Node with id : " + node.getId(), 
						4, node.getCapacity().containsKey(flow));
			}
		}
	}

}
