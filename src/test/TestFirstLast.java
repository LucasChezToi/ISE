package test;

import static org.junit.Assert.*;

import java.util.List;

import ise.Algorithm;
import ise.Flow;
import ise.Network;

import org.junit.Before;
import org.junit.Test;

import xml.XmlParser;


// TODO : Par et Pour Clement
// TODO : Rename
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
	public void testFirstNodeVisitedByJonIForFlow1() {
		Flow flowI = network.getFlows().get(0);
		assertEquals(network.getNodes().get(0), algo.firstNodeVisitedByJonI(flows.get(0), flowI));
		assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(1), flowI));
		assertEquals(network.getNodes().get(1), algo.firstNodeVisitedByJonI(flows.get(2), flowI));
		assertEquals(network.getNodes().get(1), algo.firstNodeVisitedByJonI(flows.get(3), flowI));
		assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(4), flowI));
		assertEquals(network.getNodes().get(0), algo.firstNodeVisitedByJonI(flows.get(5), flowI));
		assertEquals(network.getNodes().get(1), algo.firstNodeVisitedByJonI(flows.get(6), flowI));
	}
	
	@Test
	public void testFirstNodeVisitedByJonIForFlow2() {
		Flow flowI = network.getFlows().get(1);
		assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(0), flowI));
		assertEquals(network.getNodes().get(8), algo.firstNodeVisitedByJonI(flows.get(1), flowI));
		assertEquals(network.getNodes().get(3), algo.firstNodeVisitedByJonI(flows.get(2), flowI));
		assertEquals(network.getNodes().get(3), algo.firstNodeVisitedByJonI(flows.get(3), flowI));
		assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(4), flowI));
		assertEquals(network.getNodes().get(4), algo.firstNodeVisitedByJonI(flows.get(5), flowI));
		assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(6), flowI));
	}
	
	@Test
	public void testFirstNodeVisitedByJonIForFlow3() {
		Flow flowI = network.getFlows().get(2);
		assertEquals(network.getNodes().get(2), algo.firstNodeVisitedByJonI(flows.get(0), flowI));
		assertEquals(network.getNodes().get(9), algo.firstNodeVisitedByJonI(flows.get(1), flowI));
		assertEquals(network.getNodes().get(1), algo.firstNodeVisitedByJonI(flows.get(2), flowI));
		assertEquals(network.getNodes().get(1), algo.firstNodeVisitedByJonI(flows.get(3), flowI));
		assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(4), flowI));
		assertEquals(network.getNodes().get(2), algo.firstNodeVisitedByJonI(flows.get(5), flowI));
		assertEquals(network.getNodes().get(1), algo.firstNodeVisitedByJonI(flows.get(6), flowI));
	}
	
	@Test
	public void testFirstNodeVisitedByJonIForFlow4() {
		Flow flowI = network.getFlows().get(3);
		assertEquals(network.getNodes().get(2), algo.firstNodeVisitedByJonI(flows.get(0), flowI));
		assertEquals(network.getNodes().get(9), algo.firstNodeVisitedByJonI(flows.get(1), flowI));
		assertEquals(network.getNodes().get(1), algo.firstNodeVisitedByJonI(flows.get(2), flowI));
		assertEquals(network.getNodes().get(1), algo.firstNodeVisitedByJonI(flows.get(3), flowI));
		assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(4), flowI));
		assertEquals(network.getNodes().get(2), algo.firstNodeVisitedByJonI(flows.get(5), flowI));
		assertEquals(network.getNodes().get(1), algo.firstNodeVisitedByJonI(flows.get(6), flowI));
	}
	
	@Test
	public void testFirstNodeVisitedByJonIForFlow5() {
		Flow flowI = network.getFlows().get(4);
		assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(0), flowI));
		assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(1), flowI));
		assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(2), flowI));
		assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(3), flowI));
		assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(4), flowI));
		assertEquals(network.getNodes().get(5), algo.firstNodeVisitedByJonI(flows.get(5), flowI));
		assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(6), flowI));
	}
	
	@Test
	public void testFirstNodeVisitedByJonIForFlow6() {
		Flow flowI = network.getFlows().get(5);
		assertEquals(network.getNodes().get(0), algo.firstNodeVisitedByJonI(flows.get(0), flowI));
		assertEquals(network.getNodes().get(4), algo.firstNodeVisitedByJonI(flows.get(1), flowI));
		assertEquals(network.getNodes().get(2), algo.firstNodeVisitedByJonI(flows.get(2), flowI));
		assertEquals(network.getNodes().get(2), algo.firstNodeVisitedByJonI(flows.get(3), flowI));
		assertEquals(network.getNodes().get(11), algo.firstNodeVisitedByJonI(flows.get(4), flowI));
		assertEquals(network.getNodes().get(4), algo.firstNodeVisitedByJonI(flows.get(5), flowI));
		assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(6), flowI));
	}
	
	@Test
	public void testFirstNodeVisitedByJonIForFlow7() {
		Flow flowI = network.getFlows().get(6);
		assertEquals(network.getNodes().get(1), algo.firstNodeVisitedByJonI(flows.get(0), flowI));
		assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(1), flowI));
		assertEquals(network.getNodes().get(1), algo.firstNodeVisitedByJonI(flows.get(2), flowI));
		assertEquals(network.getNodes().get(1), algo.firstNodeVisitedByJonI(flows.get(3), flowI));
		assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(4), flowI));
		assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(5), flowI));
		assertEquals(null, algo.firstNodeVisitedByJonI(flows.get(6), flowI));
	}
	
	/*
	 * LastNodeVisitedByJonI
	 */
	@Test
	public void testLastNodeVisitedByJonIForFlow1() {
		Flow flowI = network.getFlows().get(0);
		assertEquals(network.getNodes().get(10), algo.lastNodeVisitedByJonI(flows.get(0), flowI));
		assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(1), flowI));
		assertEquals(network.getNodes().get(2), algo.lastNodeVisitedByJonI(flows.get(2), flowI));
		assertEquals(network.getNodes().get(2), algo.lastNodeVisitedByJonI(flows.get(3), flowI));
		assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(4), flowI));
		assertEquals(network.getNodes().get(2), algo.lastNodeVisitedByJonI(flows.get(5), flowI));
		assertEquals(network.getNodes().get(10), algo.lastNodeVisitedByJonI(flows.get(6), flowI));
	}
	
	@Test
	public void testLastNodeVisitedByJonIForFlow2() {
		Flow flowI = network.getFlows().get(1);
		assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(0), flowI));
		assertEquals(network.getNodes().get(4), algo.lastNodeVisitedByJonI(flows.get(1), flowI));
		assertEquals(network.getNodes().get(9), algo.lastNodeVisitedByJonI(flows.get(2), flowI));
		assertEquals(network.getNodes().get(9), algo.lastNodeVisitedByJonI(flows.get(3), flowI));
		assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(4), flowI));
		assertEquals(network.getNodes().get(4), algo.lastNodeVisitedByJonI(flows.get(5), flowI));
		assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(6), flowI));
	}
	
	@Test
	public void testLastNodeVisitedByJonIForFlow3() {
		Flow flowI = network.getFlows().get(2);
		assertEquals(network.getNodes().get(1), algo.lastNodeVisitedByJonI(flows.get(0), flowI));
		assertEquals(network.getNodes().get(3), algo.lastNodeVisitedByJonI(flows.get(1), flowI));
		assertEquals(network.getNodes().get(9), algo.lastNodeVisitedByJonI(flows.get(2), flowI));
		assertEquals(network.getNodes().get(9), algo.lastNodeVisitedByJonI(flows.get(3), flowI));
		assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(4), flowI));
		assertEquals(network.getNodes().get(2), algo.lastNodeVisitedByJonI(flows.get(5), flowI));
		assertEquals(network.getNodes().get(1), algo.lastNodeVisitedByJonI(flows.get(6), flowI));
	}
	
	@Test
	public void testLastNodeVisitedByJonIForFlow4() {
		Flow flowI = network.getFlows().get(3);
		assertEquals(network.getNodes().get(1), algo.lastNodeVisitedByJonI(flows.get(0), flowI));
		assertEquals(network.getNodes().get(3), algo.lastNodeVisitedByJonI(flows.get(1), flowI));
		assertEquals(network.getNodes().get(9), algo.lastNodeVisitedByJonI(flows.get(2), flowI));
		assertEquals(network.getNodes().get(9), algo.lastNodeVisitedByJonI(flows.get(3), flowI));
		assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(4), flowI));
		assertEquals(network.getNodes().get(2), algo.lastNodeVisitedByJonI(flows.get(5), flowI));
		assertEquals(network.getNodes().get(1), algo.lastNodeVisitedByJonI(flows.get(6), flowI));
	}
	
	@Test
	public void testLastNodeVisitedByJonIForFlow5() {
		Flow flowI = network.getFlows().get(4);
		assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(0), flowI));
		assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(1), flowI));
		assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(2), flowI));
		assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(3), flowI));
		assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(4), flowI));
		assertEquals(network.getNodes().get(11), algo.lastNodeVisitedByJonI(flows.get(5), flowI));
		assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(6), flowI));
	}
	
	@Test
	public void testLastNodeVisitedByJonIForFlow6() {
		Flow flowI = network.getFlows().get(5);
		assertEquals(network.getNodes().get(2), algo.lastNodeVisitedByJonI(flows.get(0), flowI));
		assertEquals(network.getNodes().get(4), algo.lastNodeVisitedByJonI(flows.get(1), flowI));
		assertEquals(network.getNodes().get(2), algo.lastNodeVisitedByJonI(flows.get(2), flowI));
		assertEquals(network.getNodes().get(2), algo.lastNodeVisitedByJonI(flows.get(3), flowI));
		assertEquals(network.getNodes().get(11), algo.lastNodeVisitedByJonI(flows.get(4), flowI));
		assertEquals(network.getNodes().get(11), algo.lastNodeVisitedByJonI(flows.get(5), flowI));
		assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(6), flowI));
	}
	
	@Test
	public void testLastNodeVisitedByJonIForFlow7() {
		Flow flowI = network.getFlows().get(6);
		assertEquals(network.getNodes().get(10), algo.lastNodeVisitedByJonI(flows.get(0), flowI));
		assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(1), flowI));
		assertEquals(network.getNodes().get(1), algo.lastNodeVisitedByJonI(flows.get(2), flowI));
		assertEquals(network.getNodes().get(1), algo.lastNodeVisitedByJonI(flows.get(3), flowI));
		assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(4), flowI));
		assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(5), flowI));
		assertEquals(null, algo.lastNodeVisitedByJonI(flows.get(6), flowI));
	}

}
