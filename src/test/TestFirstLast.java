package test;

import static org.junit.Assert.*;

import ise.Algorithm;
import ise.Flow;
import ise.Network;
import ise.Node;
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

	@Before
	public void setUp() throws Exception {
		XmlParser parser = new XmlParser("xml/example1.xml");
		parser.parse();
		net = parser.getNetwork();
		algo = new Algorithm(net);
		
		// Premet de rendre les tests plus compréhensibles
		flow1 = net.getFlows().get(0);
		flow2 = net.getFlows().get(1);
		flow3 = net.getFlows().get(2);
		flow4 = net.getFlows().get(3);
		flow5 = net.getFlows().get(4);
		flow6 = net.getFlows().get(5);
		flow7 = net.getFlows().get(6);
		
		node1 = net.getNodes().get(0);
		node2 = net.getNodes().get(1);
		node3 = net.getNodes().get(2);
		node4 = net.getNodes().get(3);
		node5 = net.getNodes().get(4);
		node6 = net.getNodes().get(5);
		node7 = net.getNodes().get(6);
		node8 = net.getNodes().get(7);
		node9 = net.getNodes().get(8);
		node10 = net.getNodes().get(9);
		node11 = net.getNodes().get(10);
		node12 = net.getNodes().get(11);
		
	}
	
	/*
	 * FirstNodeVisitedByJonI
	 */
	@Test
	public void testFirstNodeVisitedByJonIForFlow1() throws NodeDoesNotExistException {
		Flow flowI = flow1;
		assertEquals(node1, algo.firstNodeVisitedByJonI(flow1, flowI));
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flow2, flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(node2, algo.firstNodeVisitedByJonI(flow3, flowI));
		assertEquals(node2, algo.firstNodeVisitedByJonI(flow4, flowI));
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flow5, flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(node1, algo.firstNodeVisitedByJonI(flow6, flowI));
		assertEquals(node2, algo.firstNodeVisitedByJonI(flow7, flowI));
	}
	
	@Test
	public void testFirstNodeVisitedByJonIForFlow2() throws NodeDoesNotExistException {
		Flow flowI = flow2;
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flow1, flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(node9, algo.firstNodeVisitedByJonI(flow2, flowI));
		assertEquals(node4, algo.firstNodeVisitedByJonI(flow3, flowI));
		assertEquals(node4, algo.firstNodeVisitedByJonI(flow4, flowI));
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flow5, flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(node5, algo.firstNodeVisitedByJonI(flow6, flowI));
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flow7, flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
	}
	
	@Test
	public void testFirstNodeVisitedByJonIForFlow3() throws NodeDoesNotExistException {
		Flow flowI = flow3;
		assertEquals(node3, algo.firstNodeVisitedByJonI(flow1, flowI));
		assertEquals(node10, algo.firstNodeVisitedByJonI(flow2, flowI));
		assertEquals(node2, algo.firstNodeVisitedByJonI(flow3, flowI));
		assertEquals(node2, algo.firstNodeVisitedByJonI(flow4, flowI));
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flow5, flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(node3, algo.firstNodeVisitedByJonI(flow6, flowI));
		assertEquals(node2, algo.firstNodeVisitedByJonI(flow7, flowI));
	}
	
	@Test
	public void testFirstNodeVisitedByJonIForFlow4() throws NodeDoesNotExistException {
		Flow flowI = flow4;
		assertEquals(node3, algo.firstNodeVisitedByJonI(flow1, flowI));
		assertEquals(node10, algo.firstNodeVisitedByJonI(flow2, flowI));
		assertEquals(node2, algo.firstNodeVisitedByJonI(flow3, flowI));
		assertEquals(node2, algo.firstNodeVisitedByJonI(flow4, flowI));
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flow5, flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(node3, algo.firstNodeVisitedByJonI(flow6, flowI));
		assertEquals(node2, algo.firstNodeVisitedByJonI(flow7, flowI));
	}
	
	@Test
	public void testFirstNodeVisitedByJonIForFlow5() throws NodeDoesNotExistException {
		Flow flowI = flow5;
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flow1, flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flow2, flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flow3, flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flow4, flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flow5, flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(node6, algo.firstNodeVisitedByJonI(flow6, flowI));
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flow7, flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
	}
	
	@Test
	public void testFirstNodeVisitedByJonIForFlow6() throws NodeDoesNotExistException {
		Flow flowI = flow6;
		assertEquals(node1, algo.firstNodeVisitedByJonI(flow1, flowI));
		assertEquals(node5, algo.firstNodeVisitedByJonI(flow2, flowI));
		assertEquals(node3, algo.firstNodeVisitedByJonI(flow3, flowI));
		assertEquals(node3, algo.firstNodeVisitedByJonI(flow4, flowI));
		assertEquals(node12, algo.firstNodeVisitedByJonI(flow5, flowI));
		assertEquals(node5, algo.firstNodeVisitedByJonI(flow6, flowI));
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flow7, flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
	}
	
	@Test
	public void testFirstNodeVisitedByJonIForFlow7() throws NodeDoesNotExistException {
		Flow flowI = flow7;
		assertEquals(node2, algo.firstNodeVisitedByJonI(flow1, flowI));
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flow2, flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(node2, algo.firstNodeVisitedByJonI(flow3, flowI));
		assertEquals(node2, algo.firstNodeVisitedByJonI(flow4, flowI));
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flow5, flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flow6, flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		try{
			assertEquals(null, algo.firstNodeVisitedByJonI(flow7, flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
	}

	/*
	 * LastNodeVisitedByJonI
	 */
	@Test
	public void testLastNodeVisitedByJonIForFlow1() throws NodeDoesNotExistException {
		Flow flowI = flow1;
		assertEquals(node11, algo.lastNodeVisitedByJonI(flow1, flowI));
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flow2, flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(node3, algo.lastNodeVisitedByJonI(flow3, flowI));
		assertEquals(node3, algo.lastNodeVisitedByJonI(flow4, flowI));
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flow5, flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(node3, algo.lastNodeVisitedByJonI(flow6, flowI));
		assertEquals(node11, algo.lastNodeVisitedByJonI(flow7, flowI));
	}
	
	@Test
	public void testLastNodeVisitedByJonIForFlow2() throws NodeDoesNotExistException {
		Flow flowI = flow2;
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flow1, flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(node5, algo.lastNodeVisitedByJonI(flow2, flowI));
		assertEquals(node10, algo.lastNodeVisitedByJonI(flow3, flowI));
		assertEquals(node10, algo.lastNodeVisitedByJonI(flow4, flowI));
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flow5, flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(node5, algo.lastNodeVisitedByJonI(flow6, flowI));
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flow7, flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
	}
	
	@Test
	public void testLastNodeVisitedByJonIForFlow3() throws NodeDoesNotExistException {
		Flow flowI = flow3;
		assertEquals(node2, algo.lastNodeVisitedByJonI(flow1, flowI));
		assertEquals(node4, algo.lastNodeVisitedByJonI(flow2, flowI));
		assertEquals(node10, algo.lastNodeVisitedByJonI(flow3, flowI));
		assertEquals(node10, algo.lastNodeVisitedByJonI(flow4, flowI));
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flow5, flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(node3, algo.lastNodeVisitedByJonI(flow6, flowI));
		assertEquals(node2, algo.lastNodeVisitedByJonI(flow7, flowI));
	}
	
	@Test
	public void testLastNodeVisitedByJonIForFlow4() throws NodeDoesNotExistException {
		Flow flowI = flow4;
		assertEquals(node2, algo.lastNodeVisitedByJonI(flow1, flowI));
		assertEquals(node4, algo.lastNodeVisitedByJonI(flow2, flowI));
		assertEquals(node10, algo.lastNodeVisitedByJonI(flow3, flowI));
		assertEquals(node10, algo.lastNodeVisitedByJonI(flow4, flowI));
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flow5, flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(node3, algo.lastNodeVisitedByJonI(flow6, flowI));
		assertEquals(node2, algo.lastNodeVisitedByJonI(flow7, flowI));
	}
	
	@Test
	public void testLastNodeVisitedByJonIForFlow5() throws NodeDoesNotExistException {
		Flow flowI = flow5;
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flow1, flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flow2, flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flow3, flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flow4, flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flow5, flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(node12, algo.lastNodeVisitedByJonI(flow6, flowI));
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flow7, flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
	}
	
	@Test
	public void testLastNodeVisitedByJonIForFlow6() throws NodeDoesNotExistException {
		Flow flowI = flow6;
		assertEquals(node3, algo.lastNodeVisitedByJonI(flow1, flowI));
		assertEquals(node5, algo.lastNodeVisitedByJonI(flow2, flowI));
		assertEquals(node3, algo.lastNodeVisitedByJonI(flow3, flowI));
		assertEquals(node3, algo.lastNodeVisitedByJonI(flow4, flowI));
		assertEquals(node12, algo.lastNodeVisitedByJonI(flow5, flowI));
		assertEquals(node12, algo.lastNodeVisitedByJonI(flow6, flowI));
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flow7, flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
	}
	
	@Test
	public void testLastNodeVisitedByJonIForFlow7() throws NodeDoesNotExistException {
		Flow flowI = flow7;
		assertEquals(node11, algo.lastNodeVisitedByJonI(flow1, flowI));
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flow2, flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(node2, algo.lastNodeVisitedByJonI(flow3, flowI));
		assertEquals(node2, algo.lastNodeVisitedByJonI(flow4, flowI));
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flow5, flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flow6, flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		try{
			assertEquals(null, algo.lastNodeVisitedByJonI(flow7, flowI));
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
	}

	/*
	 *firstNodeVisitedByJonIRestrictedToH
	 */
	@Test
	public void testFirstNodeVisitedByJonIRestrictedToH() throws NodeDoesNotExistException {
		/*
		 * On test en essayant de mettre h sur les nodes aux extrémitées des 
		 * chemins 
		 * 
		 * TODO 
		 *  Cas pas de nodes en commun  
		 *  cas pas de node en commun avant h (mais en a après)
		 *  => test avec exceptions
		 *  
		 *  Template
		 *  assertEquals(node, algo.firstNodeVisitedByJonIRestrictedToH(flow, flow, node));
		 *  															  j      i
		 * */
		
		// Cas chemin identique
		assertEquals(node2, algo.firstNodeVisitedByJonIRestrictedToH(flow3, flow4, node3));
		assertEquals(node2, algo.firstNodeVisitedByJonIRestrictedToH(flow3, flow4, node2));
		
		// Cas h premiere node de i et j 
		assertEquals(node2, algo.firstNodeVisitedByJonIRestrictedToH(flow7, flow3, node2));
		assertEquals(node2, algo.firstNodeVisitedByJonIRestrictedToH(flow7, flow4, node2));
		
		// Cas h premiere node de i mais pas j
		assertEquals(node5, algo.firstNodeVisitedByJonIRestrictedToH(flow2, flow6, node5));
		assertEquals(node2, algo.firstNodeVisitedByJonIRestrictedToH(flow3, flow7, node2));
		assertEquals(node1, algo.firstNodeVisitedByJonIRestrictedToH(flow6, flow1, node1));
		
		// Cas h premiere node de j mais pas i
		assertEquals(node1, algo.firstNodeVisitedByJonIRestrictedToH(flow1, flow6, node1));
		
		// Cas h derniere node de i et j
		assertEquals(node2, algo.firstNodeVisitedByJonIRestrictedToH(flow3, flow4, node10));
		assertEquals(node2, algo.firstNodeVisitedByJonIRestrictedToH(flow1, flow7, node11));
		
		// Cas h derniere node de i mais pas j
		assertEquals(node5, algo.firstNodeVisitedByJonIRestrictedToH(flow6, flow2, node5));
		assertEquals(node10, algo.firstNodeVisitedByJonIRestrictedToH(flow2, flow3, node10));
		assertEquals(node12, algo.firstNodeVisitedByJonIRestrictedToH(flow5, flow6, node12));
		
		// Cas h derniere node de j mais pas i
		assertEquals(node5, algo.firstNodeVisitedByJonIRestrictedToH(flow2, flow6, node5));
		assertEquals(node5, algo.firstNodeVisitedByJonIRestrictedToH(flow3, flow2, node10));
		assertEquals(node12, algo.firstNodeVisitedByJonIRestrictedToH(flow6, flow5, node10));
		

	}
	
	/*
	 * TODO
	 * lastNodeVisitedByJonIRestrictedToH
	 */
	

}
