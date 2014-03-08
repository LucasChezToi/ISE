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
	
	@Before
	public void setUp() throws Exception {
		XmlParser parser = new XmlParser("xml/example1.xml");
		parser.parse();
		net = parser.getNetwork();
		algo = new Algorithm(net);
		
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
	
	/*
	 * FirstNodeVisitedByJonI
	 */
	@Test
	public void testFirstNodeVisitedByJonIForFlow1() throws NodeDoesNotExistException {
		Flow flowI = flow1;
		assertEquals(node1, algo.firstNodeVisitedByJonI(flow1, flowI));
		try{
			algo.firstNodeVisitedByJonI(flow2, flowI);
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(node2, algo.firstNodeVisitedByJonI(flow3, flowI));
		assertEquals(node2, algo.firstNodeVisitedByJonI(flow4, flowI));
		try{
			algo.firstNodeVisitedByJonI(flow5, flowI);
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(node1, algo.firstNodeVisitedByJonI(flow6, flowI));
		assertEquals(node2, algo.firstNodeVisitedByJonI(flow7, flowI));
	}
	
	@Test
	public void testFirstNodeVisitedByJonIForFlow2() throws NodeDoesNotExistException {
		Flow flowI = flow2;
		try{
			algo.firstNodeVisitedByJonI(flow1, flowI);
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){System.out.println("passé");}
		assertEquals(node9, algo.firstNodeVisitedByJonI(flow2, flowI));
		assertEquals(node4, algo.firstNodeVisitedByJonI(flow3, flowI));
		assertEquals(node4, algo.firstNodeVisitedByJonI(flow4, flowI));
		try{
			algo.firstNodeVisitedByJonI(flow5, flowI);
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
			algo.firstNodeVisitedByJonI(flow5, flowI);
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
			algo.firstNodeVisitedByJonI(flow5, flowI);
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(node3, algo.firstNodeVisitedByJonI(flow6, flowI));
		assertEquals(node2, algo.firstNodeVisitedByJonI(flow7, flowI));
	}
	
	@Test
	public void testFirstNodeVisitedByJonIForFlow5() throws NodeDoesNotExistException {
		Flow flowI = flow5;
		try{
			algo.firstNodeVisitedByJonI(flow1, flowI);
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		try{
			algo.firstNodeVisitedByJonI(flow2, flowI);
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		try{
			algo.firstNodeVisitedByJonI(flow3, flowI);
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		try{
			algo.firstNodeVisitedByJonI(flow4, flowI);
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		try{
			algo.firstNodeVisitedByJonI(flow5, flowI);
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(node6, algo.firstNodeVisitedByJonI(flow6, flowI));
		try{
			algo.firstNodeVisitedByJonI(flow7, flowI);
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
		assertEquals(node6, algo.firstNodeVisitedByJonI(flow5, flowI));
		assertEquals(node5, algo.firstNodeVisitedByJonI(flow6, flowI));
		try{
			algo.firstNodeVisitedByJonI(flow7, flowI);
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
	}
	
	@Test
	public void testFirstNodeVisitedByJonIForFlow7() throws NodeDoesNotExistException {
		Flow flowI = flow7;
		assertEquals(node2, algo.firstNodeVisitedByJonI(flow1, flowI));
		try{
			algo.firstNodeVisitedByJonI(flow2, flowI);
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(node2, algo.firstNodeVisitedByJonI(flow3, flowI));
		assertEquals(node2, algo.firstNodeVisitedByJonI(flow4, flowI));
		try{
			algo.firstNodeVisitedByJonI(flow5, flowI);
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		try{
			algo.firstNodeVisitedByJonI(flow6, flowI);
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		try{
			algo.firstNodeVisitedByJonI(flow7, flowI);
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
	}

	/*
	 * LastNodeVisitedByJonI
	 //
	@Test
	public void testLastNodeVisitedByJonIForFlow1() throws NodeDoesNotExistException {
		Flow flowI = flow1;
		assertEquals(node11, algo.lastNodeVisitedByJonI(flow1, flowI));
		try{
			algo.lastNodeVisitedByJonI(flow2, flowI);
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(node3, algo.lastNodeVisitedByJonI(flow3, flowI));
		assertEquals(node3, algo.lastNodeVisitedByJonI(flow4, flowI));
		try{
			algo.lastNodeVisitedByJonI(flow5, flowI);
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(node3, algo.lastNodeVisitedByJonI(flow6, flowI));
		assertEquals(node11, algo.lastNodeVisitedByJonI(flow7, flowI));
	}
	
	@Test
	public void testLastNodeVisitedByJonIForFlow2() throws NodeDoesNotExistException {
		Flow flowI = flow2;
		try{
			algo.lastNodeVisitedByJonI(flow1, flowI);
			//fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(node5, algo.lastNodeVisitedByJonI(flow2, flowI));
		assertEquals(node10, algo.lastNodeVisitedByJonI(flow3, flowI));
		assertEquals(node10, algo.lastNodeVisitedByJonI(flow4, flowI));
		try{
			algo.lastNodeVisitedByJonI(flow5, flowI);
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(node5, algo.lastNodeVisitedByJonI(flow6, flowI));
		try{
			algo.lastNodeVisitedByJonI(flow7, flowI);
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
			algo.lastNodeVisitedByJonI(flow5, flowI);
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
			algo.lastNodeVisitedByJonI(flow5, flowI);
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(node3, algo.lastNodeVisitedByJonI(flow6, flowI));
		assertEquals(node2, algo.lastNodeVisitedByJonI(flow7, flowI));
	}
	
	@Test
	public void testLastNodeVisitedByJonIForFlow5() throws NodeDoesNotExistException {
		Flow flowI = flow5;
		try{
			algo.lastNodeVisitedByJonI(flow1, flowI);
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		try{
			algo.lastNodeVisitedByJonI(flow2, flowI);
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		try{
			algo.lastNodeVisitedByJonI(flow3, flowI);
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		try{
			algo.lastNodeVisitedByJonI(flow4, flowI);
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		try{
			algo.lastNodeVisitedByJonI(flow5, flowI);
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(node6, algo.lastNodeVisitedByJonI(flow6, flowI));
		try{
			algo.lastNodeVisitedByJonI(flow7, flowI);
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
		assertEquals(node6, algo.lastNodeVisitedByJonI(flow5, flowI));
		assertEquals(node6, algo.lastNodeVisitedByJonI(flow6, flowI));
		try{
			algo.lastNodeVisitedByJonI(flow7, flowI);
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
	}
	
	@Test
	public void testLastNodeVisitedByJonIForFlow7() throws NodeDoesNotExistException {
		Flow flowI = flow7;
		assertEquals(node11, algo.lastNodeVisitedByJonI(flow1, flowI));
		try{
			algo.lastNodeVisitedByJonI(flow2, flowI);
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		assertEquals(node2, algo.lastNodeVisitedByJonI(flow3, flowI));
		assertEquals(node2, algo.lastNodeVisitedByJonI(flow4, flowI));
		try{
			algo.lastNodeVisitedByJonI(flow5, flowI);
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		try{
			algo.lastNodeVisitedByJonI(flow6, flowI);
			fail("NodeDoesNotExistException doit lancée");
		}catch(NodeDoesNotExistException e){}
		try{
			algo.lastNodeVisitedByJonI(flow7, flowI);
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
		assertEquals(node6, algo.firstNodeVisitedByJonIRestrictedToH(flow5, flow6, node6));
		
		// Cas h derniere node de j mais pas i
		assertEquals(node5, algo.firstNodeVisitedByJonIRestrictedToH(flow2, flow6, node5));
		assertEquals(node5, algo.firstNodeVisitedByJonIRestrictedToH(flow3, flow2, node10));
		assertEquals(node6, algo.firstNodeVisitedByJonIRestrictedToH(flow6, flow5, node10));
		

	}
	
	/*
	 * TODO
	 * lastNodeVisitedByJonIRestrictedToH
	 */
	

}
