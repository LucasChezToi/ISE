package test;

import static org.junit.Assert.*;

import java.util.List;

import ise.Algorithm;
import ise.Flow;
import ise.Network;
import ise.NodeDoesNotExistException;

import org.junit.Before;
import org.junit.Test;

import xml.XmlParser;

/**
 * 	Classe de test des méthodes de la classe Algorithm  
 *   - fisrtNodeVisitedByJonI
 *   - lastNodeVisitedByJonI
 * 	 - firstNodeVisitedByJonIRestrictedToH TODO
 *   - lastNodeVisitedByJonIRestrictedToH TODO
 *   
 */
public class TestFirstLast {
	Network network;
	Algorithm algo;
	List<Flow> flows;

	@Before
	public void setUp() throws Exception {
		XmlParser parser = new XmlParser("xml/example1.xml");
		parser.parse();
		network = parser.getNetwork();
		flows = network.getFlows();
		algo = new Algorithm(network);
	}
	
	/*
	 * FirstNodeVisitedByJonI
	 */
	@Test
	public void testFirstNodeVisitedByJonIForFlow1() throws NodeDoesNotExistException {
		Flow flowI = network.getFlows().get(0);
		assertEquals(network.getNodes().get(0), algo.firstNodeVisitedByJonI(flows.get(0), flowI));
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(1), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(network.getNodes().get(1), algo.firstNodeVisitedByJonI(flows.get(2), flowI));
		assertEquals(network.getNodes().get(1), algo.firstNodeVisitedByJonI(flows.get(3), flowI));
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(4), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(network.getNodes().get(0), algo.firstNodeVisitedByJonI(flows.get(5), flowI));
		assertEquals(network.getNodes().get(1), algo.firstNodeVisitedByJonI(flows.get(6), flowI));
	}
	
	@Test
	public void testFirstNodeVisitedByJonIForFlow2() throws NodeDoesNotExistException {
		Flow flowI = network.getFlows().get(1);
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(0), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(network.getNodes().get(8), algo.firstNodeVisitedByJonI(flows.get(1), flowI));
		assertEquals(network.getNodes().get(3), algo.firstNodeVisitedByJonI(flows.get(2), flowI));
		assertEquals(network.getNodes().get(3), algo.firstNodeVisitedByJonI(flows.get(3), flowI));
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(4), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(network.getNodes().get(4), algo.firstNodeVisitedByJonI(flows.get(5), flowI));
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(6), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
	}
	
	@Test
	public void testFirstNodeVisitedByJonIForFlow3() throws NodeDoesNotExistException {
		Flow flowI = network.getFlows().get(2);
		assertEquals(network.getNodes().get(2), algo.firstNodeVisitedByJonI(flows.get(0), flowI));
		assertEquals(network.getNodes().get(9), algo.firstNodeVisitedByJonI(flows.get(1), flowI));
		assertEquals(network.getNodes().get(1), algo.firstNodeVisitedByJonI(flows.get(2), flowI));
		assertEquals(network.getNodes().get(1), algo.firstNodeVisitedByJonI(flows.get(3), flowI));
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(4), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(network.getNodes().get(2), algo.firstNodeVisitedByJonI(flows.get(5), flowI));
		assertEquals(network.getNodes().get(1), algo.firstNodeVisitedByJonI(flows.get(6), flowI));
	}
	
	@Test
	public void testFirstNodeVisitedByJonIForFlow4() throws NodeDoesNotExistException {
		Flow flowI = network.getFlows().get(3);
		assertEquals(network.getNodes().get(2), algo.firstNodeVisitedByJonI(flows.get(0), flowI));
		assertEquals(network.getNodes().get(9), algo.firstNodeVisitedByJonI(flows.get(1), flowI));
		assertEquals(network.getNodes().get(1), algo.firstNodeVisitedByJonI(flows.get(2), flowI));
		assertEquals(network.getNodes().get(1), algo.firstNodeVisitedByJonI(flows.get(3), flowI));
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(4), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(network.getNodes().get(2), algo.firstNodeVisitedByJonI(flows.get(5), flowI));
		assertEquals(network.getNodes().get(1), algo.firstNodeVisitedByJonI(flows.get(6), flowI));
	}
	
	@Test
	public void testFirstNodeVisitedByJonIForFlow5() throws NodeDoesNotExistException {
		Flow flowI = network.getFlows().get(4);
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(0), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(1), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(2), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(3), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(4), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(network.getNodes().get(5), algo.firstNodeVisitedByJonI(flows.get(5), flowI));
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(6), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
	}
	
	@Test
	public void testFirstNodeVisitedByJonIForFlow6() throws NodeDoesNotExistException {
		Flow flowI = network.getFlows().get(5);
		assertEquals(network.getNodes().get(0), algo.firstNodeVisitedByJonI(flows.get(0), flowI));
		assertEquals(network.getNodes().get(4), algo.firstNodeVisitedByJonI(flows.get(1), flowI));
		assertEquals(network.getNodes().get(2), algo.firstNodeVisitedByJonI(flows.get(2), flowI));
		assertEquals(network.getNodes().get(2), algo.firstNodeVisitedByJonI(flows.get(3), flowI));
		assertEquals(network.getNodes().get(11), algo.firstNodeVisitedByJonI(flows.get(4), flowI));
		assertEquals(network.getNodes().get(4), algo.firstNodeVisitedByJonI(flows.get(5), flowI));
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(6), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
	}
	
	@Test
	public void testFirstNodeVisitedByJonIForFlow7() throws NodeDoesNotExistException {
		Flow flowI = network.getFlows().get(6);
		assertEquals(network.getNodes().get(1), algo.firstNodeVisitedByJonI(flows.get(0), flowI));
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(1), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(network.getNodes().get(1), algo.firstNodeVisitedByJonI(flows.get(2), flowI));
		assertEquals(network.getNodes().get(1), algo.firstNodeVisitedByJonI(flows.get(3), flowI));
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(4), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(5), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(6), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		}
	
	/*
	 * LastNodeVisitedByJonI
	 */
	@Test
	public void testLastNodeVisitedByJonIForFlow1() throws NodeDoesNotExistException {
		Flow flowI = network.getFlows().get(0);
		assertEquals(network.getNodes().get(10), algo.lastNodeVisitedByJonI(flows.get(0), flowI));
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(1), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(network.getNodes().get(2), algo.lastNodeVisitedByJonI(flows.get(2), flowI));
		assertEquals(network.getNodes().get(2), algo.lastNodeVisitedByJonI(flows.get(3), flowI));
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(4), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(network.getNodes().get(2), algo.lastNodeVisitedByJonI(flows.get(5), flowI));
		assertEquals(network.getNodes().get(10), algo.lastNodeVisitedByJonI(flows.get(6), flowI));
	}
	
	@Test
	public void testLastNodeVisitedByJonIForFlow2() throws NodeDoesNotExistException {
		Flow flowI = network.getFlows().get(1);
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(0), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(network.getNodes().get(4), algo.lastNodeVisitedByJonI(flows.get(1), flowI));
		assertEquals(network.getNodes().get(9), algo.lastNodeVisitedByJonI(flows.get(2), flowI));
		assertEquals(network.getNodes().get(9), algo.lastNodeVisitedByJonI(flows.get(3), flowI));
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(4), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(network.getNodes().get(4), algo.lastNodeVisitedByJonI(flows.get(5), flowI));
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(6), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
	}
	
	@Test
	public void testLastNodeVisitedByJonIForFlow3() throws NodeDoesNotExistException {
		Flow flowI = network.getFlows().get(2);
		assertEquals(network.getNodes().get(1), algo.lastNodeVisitedByJonI(flows.get(0), flowI));
		assertEquals(network.getNodes().get(3), algo.lastNodeVisitedByJonI(flows.get(1), flowI));
		assertEquals(network.getNodes().get(9), algo.lastNodeVisitedByJonI(flows.get(2), flowI));
		assertEquals(network.getNodes().get(9), algo.lastNodeVisitedByJonI(flows.get(3), flowI));
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(4), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(network.getNodes().get(2), algo.lastNodeVisitedByJonI(flows.get(5), flowI));
		assertEquals(network.getNodes().get(1), algo.lastNodeVisitedByJonI(flows.get(6), flowI));
	}
	
	@Test
	public void testLastNodeVisitedByJonIForFlow4() throws NodeDoesNotExistException {
		Flow flowI = network.getFlows().get(3);
		assertEquals(network.getNodes().get(1), algo.lastNodeVisitedByJonI(flows.get(0), flowI));
		assertEquals(network.getNodes().get(3), algo.lastNodeVisitedByJonI(flows.get(1), flowI));
		assertEquals(network.getNodes().get(9), algo.lastNodeVisitedByJonI(flows.get(2), flowI));
		assertEquals(network.getNodes().get(9), algo.lastNodeVisitedByJonI(flows.get(3), flowI));
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(4), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(network.getNodes().get(2), algo.lastNodeVisitedByJonI(flows.get(5), flowI));
		assertEquals(network.getNodes().get(1), algo.lastNodeVisitedByJonI(flows.get(6), flowI));
	}
	
	@Test
	public void testLastNodeVisitedByJonIForFlow5() throws NodeDoesNotExistException {
		Flow flowI = network.getFlows().get(4);
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(0), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(1), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(2), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(3), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(4), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(network.getNodes().get(11), algo.lastNodeVisitedByJonI(flows.get(5), flowI));
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(6), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
	}
	
	@Test
	public void testLastNodeVisitedByJonIForFlow6() throws NodeDoesNotExistException {
		Flow flowI = network.getFlows().get(5);
		assertEquals(network.getNodes().get(2), algo.lastNodeVisitedByJonI(flows.get(0), flowI));
		assertEquals(network.getNodes().get(4), algo.lastNodeVisitedByJonI(flows.get(1), flowI));
		assertEquals(network.getNodes().get(2), algo.lastNodeVisitedByJonI(flows.get(2), flowI));
		assertEquals(network.getNodes().get(2), algo.lastNodeVisitedByJonI(flows.get(3), flowI));
		assertEquals(network.getNodes().get(11), algo.lastNodeVisitedByJonI(flows.get(4), flowI));
		assertEquals(network.getNodes().get(11), algo.lastNodeVisitedByJonI(flows.get(5), flowI));
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(6), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
	}
	
	@Test
	public void testLastNodeVisitedByJonIForFlow7() throws NodeDoesNotExistException {
		Flow flowI = network.getFlows().get(6);
		assertEquals(network.getNodes().get(10), algo.lastNodeVisitedByJonI(flows.get(0), flowI));
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(1), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(network.getNodes().get(1), algo.lastNodeVisitedByJonI(flows.get(2), flowI));
		assertEquals(network.getNodes().get(1), algo.lastNodeVisitedByJonI(flows.get(3), flowI));
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(4), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(5), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(6), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
	}

}
