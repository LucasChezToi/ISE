package test;

import static org.junit.Assert.*;
import ise.Flow;
import ise.Network;
import ise.Path;

import org.junit.Before;
import org.junit.Test;

import xml.XmlParser;

public class TestParser2 {
	Network network;

	@Before
	public void setUp() throws Exception {
			XmlParser parser = new XmlParser("xml/example2.xml");
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
		assertEquals(12, network.getNodes().size());
		assertEquals(7, network.getFlows().size());
	}
	
	// Test des valeurs communes à tous les flows
	@Test
	public void testFlows() {
		for (Flow flow : network.getFlows()) {
			assertNotNull(flow);
			assertEquals(36, flow.getPeriod());
			assertEquals(0, flow.getJitter());
			assertNotNull(flow.getPath());
			assertEquals(11, flow.getPriority());
			assertEquals(54, flow.getDeadline());
		}
	}
	
	public void testPath1(){
		Path path = network.getFlows().get(0).getPath();
		assertNotNull(path);
		assertEquals(network.getNodes().get(0), path.getNodes().get(0));
		assertEquals(network.getNodes().get(2), path.getNodes().get(1));
		assertEquals(network.getNodes().get(1), path.getNodes().get(2));
		assertEquals(network.getNodes().get(10), path.getNodes().get(3));
	}
	
	public void testPath2(){
		Path path = network.getFlows().get(1).getPath();
		assertNotNull(path);
		assertEquals(network.getNodes().get(8), path.getNodes().get(0));
		assertEquals(network.getNodes().get(10), path.getNodes().get(1));
		assertEquals(network.getNodes().get(6), path.getNodes().get(2));
		assertEquals(network.getNodes().get(3), path.getNodes().get(3));
		assertEquals(network.getNodes().get(4), path.getNodes().get(4));
		
	}
	
	public void testPath3(){
		Path path = network.getFlows().get(2).getPath();
		assertNotNull(path);
		assertEquals(network.getNodes().get(1), path.getNodes().get(0));
		assertEquals(network.getNodes().get(2), path.getNodes().get(1));
		assertEquals(network.getNodes().get(3), path.getNodes().get(2));
		assertEquals(network.getNodes().get(6), path.getNodes().get(3));
		assertEquals(network.getNodes().get(9), path.getNodes().get(4));
		
	}
	
	public void testPath4(){
		Path path = network.getFlows().get(3).getPath();
		assertNotNull(path);
		assertEquals(network.getNodes().get(1), path.getNodes().get(0));
		assertEquals(network.getNodes().get(2), path.getNodes().get(1));
		assertEquals(network.getNodes().get(3), path.getNodes().get(2));
		assertEquals(network.getNodes().get(6), path.getNodes().get(3));
		assertEquals(network.getNodes().get(9), path.getNodes().get(4));
		
	}
	
	public void testPath5(){
		Path path = network.getFlows().get(4).getPath();
		assertNotNull(path);
		assertEquals(network.getNodes().get(7), path.getNodes().get(0));
		assertEquals(network.getNodes().get(11), path.getNodes().get(1));
		assertEquals(network.getNodes().get(9), path.getNodes().get(2));
		
	}
	
	public void testPath6(){
		Path path = network.getFlows().get(5).getPath();
		assertNotNull(path);
		assertEquals(network.getNodes().get(4), path.getNodes().get(0));
		assertEquals(network.getNodes().get(0), path.getNodes().get(1));
		assertEquals(network.getNodes().get(2), path.getNodes().get(2));
		assertEquals(network.getNodes().get(11), path.getNodes().get(3));
		
	}
	
	public void testPath7(){
		Path path = network.getFlows().get(6).getPath();
		assertNotNull(path);
		assertEquals(network.getNodes().get(1), path.getNodes().get(0));
		assertEquals(network.getNodes().get(10), path.getNodes().get(1));
		
	}
}
