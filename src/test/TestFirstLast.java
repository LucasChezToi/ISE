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
	Network net;
	Algorithm algo;
	List<Flow> flows;

	@Before
	public void setUp() throws Exception {
		XmlParser parser = new XmlParser("xml/example1.xml");
		parser.parse();
		net = parser.getNetwork();
		flows = net.getFlows();
		algo = new Algorithm(net);
	}
	
	/*
	 * FirstNodeVisitedByJonI
	 */
	@Test
	public void testFirstNodeVisitedByJonIForFlow1() throws NodeDoesNotExistException {
		Flow flowI = net.getFlows().get(0);
		assertEquals(net.getNodes().get(0), algo.firstNodeVisitedByJonI(flows.get(0), flowI));
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(1), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(net.getNodes().get(1), algo.firstNodeVisitedByJonI(flows.get(2), flowI));
		assertEquals(net.getNodes().get(1), algo.firstNodeVisitedByJonI(flows.get(3), flowI));
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(4), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(net.getNodes().get(0), algo.firstNodeVisitedByJonI(flows.get(5), flowI));
		assertEquals(net.getNodes().get(1), algo.firstNodeVisitedByJonI(flows.get(6), flowI));
	}
	
	@Test
	public void testFirstNodeVisitedByJonIForFlow2() throws NodeDoesNotExistException {
		Flow flowI = net.getFlows().get(1);
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(0), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(net.getNodes().get(8), algo.firstNodeVisitedByJonI(flows.get(1), flowI));
		assertEquals(net.getNodes().get(3), algo.firstNodeVisitedByJonI(flows.get(2), flowI));
		assertEquals(net.getNodes().get(3), algo.firstNodeVisitedByJonI(flows.get(3), flowI));
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(4), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(net.getNodes().get(4), algo.firstNodeVisitedByJonI(flows.get(5), flowI));
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(6), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
	}
	
	@Test
	public void testFirstNodeVisitedByJonIForFlow3() throws NodeDoesNotExistException {
		Flow flowI = net.getFlows().get(2);
		assertEquals(net.getNodes().get(2), algo.firstNodeVisitedByJonI(flows.get(0), flowI));
		assertEquals(net.getNodes().get(9), algo.firstNodeVisitedByJonI(flows.get(1), flowI));
		assertEquals(net.getNodes().get(1), algo.firstNodeVisitedByJonI(flows.get(2), flowI));
		assertEquals(net.getNodes().get(1), algo.firstNodeVisitedByJonI(flows.get(3), flowI));
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(4), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(net.getNodes().get(2), algo.firstNodeVisitedByJonI(flows.get(5), flowI));
		assertEquals(net.getNodes().get(1), algo.firstNodeVisitedByJonI(flows.get(6), flowI));
	}
	
	@Test
	public void testFirstNodeVisitedByJonIForFlow4() throws NodeDoesNotExistException {
		Flow flowI = net.getFlows().get(3);
		assertEquals(net.getNodes().get(2), algo.firstNodeVisitedByJonI(flows.get(0), flowI));
		assertEquals(net.getNodes().get(9), algo.firstNodeVisitedByJonI(flows.get(1), flowI));
		assertEquals(net.getNodes().get(1), algo.firstNodeVisitedByJonI(flows.get(2), flowI));
		assertEquals(net.getNodes().get(1), algo.firstNodeVisitedByJonI(flows.get(3), flowI));
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(4), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(net.getNodes().get(2), algo.firstNodeVisitedByJonI(flows.get(5), flowI));
		assertEquals(net.getNodes().get(1), algo.firstNodeVisitedByJonI(flows.get(6), flowI));
	}
	
	@Test
	public void testFirstNodeVisitedByJonIForFlow5() throws NodeDoesNotExistException {
		Flow flowI = net.getFlows().get(4);
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
		assertEquals(net.getNodes().get(5), algo.firstNodeVisitedByJonI(flows.get(5), flowI));
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(6), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
	}
	
	@Test
	public void testFirstNodeVisitedByJonIForFlow6() throws NodeDoesNotExistException {
		Flow flowI = net.getFlows().get(5);
		assertEquals(net.getNodes().get(0), algo.firstNodeVisitedByJonI(flows.get(0), flowI));
		assertEquals(net.getNodes().get(4), algo.firstNodeVisitedByJonI(flows.get(1), flowI));
		assertEquals(net.getNodes().get(2), algo.firstNodeVisitedByJonI(flows.get(2), flowI));
		assertEquals(net.getNodes().get(2), algo.firstNodeVisitedByJonI(flows.get(3), flowI));
		assertEquals(net.getNodes().get(11), algo.firstNodeVisitedByJonI(flows.get(4), flowI));
		assertEquals(net.getNodes().get(4), algo.firstNodeVisitedByJonI(flows.get(5), flowI));
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(6), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
	}
	
	@Test
	public void testFirstNodeVisitedByJonIForFlow7() throws NodeDoesNotExistException {
		Flow flowI = net.getFlows().get(6);
		assertEquals(net.getNodes().get(1), algo.firstNodeVisitedByJonI(flows.get(0), flowI));
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(1), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(net.getNodes().get(1), algo.firstNodeVisitedByJonI(flows.get(2), flowI));
		assertEquals(net.getNodes().get(1), algo.firstNodeVisitedByJonI(flows.get(3), flowI));
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
		Flow flowI = net.getFlows().get(0);
		assertEquals(net.getNodes().get(10), algo.lastNodeVisitedByJonI(flows.get(0), flowI));
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(1), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(net.getNodes().get(2), algo.lastNodeVisitedByJonI(flows.get(2), flowI));
		assertEquals(net.getNodes().get(2), algo.lastNodeVisitedByJonI(flows.get(3), flowI));
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(4), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(net.getNodes().get(2), algo.lastNodeVisitedByJonI(flows.get(5), flowI));
		assertEquals(net.getNodes().get(10), algo.lastNodeVisitedByJonI(flows.get(6), flowI));
	}
	
	@Test
	public void testLastNodeVisitedByJonIForFlow2() throws NodeDoesNotExistException {
		Flow flowI = net.getFlows().get(1);
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(0), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(net.getNodes().get(4), algo.lastNodeVisitedByJonI(flows.get(1), flowI));
		assertEquals(net.getNodes().get(9), algo.lastNodeVisitedByJonI(flows.get(2), flowI));
		assertEquals(net.getNodes().get(9), algo.lastNodeVisitedByJonI(flows.get(3), flowI));
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(4), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(net.getNodes().get(4), algo.lastNodeVisitedByJonI(flows.get(5), flowI));
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(6), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
	}
	
	@Test
	public void testLastNodeVisitedByJonIForFlow3() throws NodeDoesNotExistException {
		Flow flowI = net.getFlows().get(2);
		assertEquals(net.getNodes().get(1), algo.lastNodeVisitedByJonI(flows.get(0), flowI));
		assertEquals(net.getNodes().get(3), algo.lastNodeVisitedByJonI(flows.get(1), flowI));
		assertEquals(net.getNodes().get(9), algo.lastNodeVisitedByJonI(flows.get(2), flowI));
		assertEquals(net.getNodes().get(9), algo.lastNodeVisitedByJonI(flows.get(3), flowI));
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(4), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(net.getNodes().get(2), algo.lastNodeVisitedByJonI(flows.get(5), flowI));
		assertEquals(net.getNodes().get(1), algo.lastNodeVisitedByJonI(flows.get(6), flowI));
	}
	
	@Test
	public void testLastNodeVisitedByJonIForFlow4() throws NodeDoesNotExistException {
		Flow flowI = net.getFlows().get(3);
		assertEquals(net.getNodes().get(1), algo.lastNodeVisitedByJonI(flows.get(0), flowI));
		assertEquals(net.getNodes().get(3), algo.lastNodeVisitedByJonI(flows.get(1), flowI));
		assertEquals(net.getNodes().get(9), algo.lastNodeVisitedByJonI(flows.get(2), flowI));
		assertEquals(net.getNodes().get(9), algo.lastNodeVisitedByJonI(flows.get(3), flowI));
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(4), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(net.getNodes().get(2), algo.lastNodeVisitedByJonI(flows.get(5), flowI));
		assertEquals(net.getNodes().get(1), algo.lastNodeVisitedByJonI(flows.get(6), flowI));
	}
	
	@Test
	public void testLastNodeVisitedByJonIForFlow5() throws NodeDoesNotExistException {
		Flow flowI = net.getFlows().get(4);
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
		assertEquals(net.getNodes().get(11), algo.lastNodeVisitedByJonI(flows.get(5), flowI));
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(6), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
	}
	
	@Test
	public void testLastNodeVisitedByJonIForFlow6() throws NodeDoesNotExistException {
		Flow flowI = net.getFlows().get(5);
		assertEquals(net.getNodes().get(2), algo.lastNodeVisitedByJonI(flows.get(0), flowI));
		assertEquals(net.getNodes().get(4), algo.lastNodeVisitedByJonI(flows.get(1), flowI));
		assertEquals(net.getNodes().get(2), algo.lastNodeVisitedByJonI(flows.get(2), flowI));
		assertEquals(net.getNodes().get(2), algo.lastNodeVisitedByJonI(flows.get(3), flowI));
		assertEquals(net.getNodes().get(11), algo.lastNodeVisitedByJonI(flows.get(4), flowI));
		assertEquals(net.getNodes().get(11), algo.lastNodeVisitedByJonI(flows.get(5), flowI));
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(6), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
	}
	
	@Test
	public void testLastNodeVisitedByJonIForFlow7() throws NodeDoesNotExistException {
		Flow flowI = net.getFlows().get(6);
		assertEquals(net.getNodes().get(10), algo.lastNodeVisitedByJonI(flows.get(0), flowI));
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(1), flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(net.getNodes().get(1), algo.lastNodeVisitedByJonI(flows.get(2), flowI));
		assertEquals(net.getNodes().get(1), algo.lastNodeVisitedByJonI(flows.get(3), flowI));
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

	/*
	 *firstNodeVisitedByJonIRestrictedToH
	 */
	@Test
	public void testFirstNodeVisitedByJonIRestrictedToH() throws NodeDoesNotExistException {
		Flow flow1 = net.getFlows().get(0);
		Flow flow2 = net.getFlows().get(1);
		Flow flow3 = net.getFlows().get(2);
		Flow flow4 = net.getFlows().get(3);
		Flow flow5 = net.getFlows().get(4);
		Flow flow6 = net.getFlows().get(5);
		Flow flow7 = net.getFlows().get(6);
		/*
		 * TODO A tester
		 * 
		 * Cas h premiere node de 
		 * 	i mais pas j
		 *  j mais pas i
		 *  
		 * Cas h derniere node de 
		 *  i mais pas j
		 *  j mais pas i
		 *  i et j
		 *  
		 *  Cas pas de nodes en commun  
		 *  cas pas de node en commun avant h (mais en a après)
		 *  
		 *  Template
		 *  assertEquals(net.getNodes().get(), algo.firstNodeVisitedByJonIRestrictedToH(flow, flow, net.getNodes().get()));
		 * */
		
		// Cas chemin identique
		assertEquals(net.getNodes().get(1), algo.firstNodeVisitedByJonIRestrictedToH(flow3, flow4, net.getNodes().get(2)));
		
		// Cas h premiere node de i et j 
		assertEquals(net.getNodes().get(1), algo.firstNodeVisitedByJonIRestrictedToH(flow7, flow3, net.getNodes().get(1)));
		assertEquals(net.getNodes().get(1), algo.firstNodeVisitedByJonIRestrictedToH(flow7, flow4, net.getNodes().get(1)));
		
		// Cas h derniere node de i et j
		assertEquals(net.getNodes().get(1), algo.firstNodeVisitedByJonIRestrictedToH(flow3, flow4, net.getNodes().get(9)));
		assertEquals(net.getNodes().get(1), algo.firstNodeVisitedByJonIRestrictedToH(flow1, flow7, net.getNodes().get(10)));
	}
	

}
