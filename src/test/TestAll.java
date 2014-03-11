package test;

import static org.junit.Assert.*;

import java.util.List;

import ise.Algorithm;
import ise.Network;

import org.junit.Ignore;
import org.junit.Test;

import xml.XmlParser;

public class TestAll {
	Network net;
	Algorithm algo;
	
	
	@Test
	public void testWithExemple1() {
		XmlParser parser = new XmlParser("xml/example1.xml");
		parser.parse();
		net = parser.getNetwork();
		algo = new Algorithm(net);
		
		List<Integer> res = algo.computeWorstCaseEndToEndResponse();
		assertNotNull(res);
		assertEquals(5, res.size());
		
		assertEquals((Integer) 31, res.get(0));
		assertEquals((Integer) 31, res.get(1));
		assertEquals((Integer) 46, res.get(2));
		assertEquals((Integer) 46, res.get(3));
		assertEquals((Integer) 33, res.get(4));
	}
	
	@Ignore
	@Test
	public void testWithExemple2(){
		XmlParser parser = new XmlParser("xml/example2.xml");
		parser.parse();
		net = parser.getNetwork();
		algo = new Algorithm(net);
		
		// TODO il faudrait calculer à la main pour avoir les WCET
	}

}
