package test;

import static org.junit.Assert.*;
import ise.Network;

import org.junit.Before;
import org.junit.Test;

import xml.XmlParser;


// TODO : Par et Pour Clement
// TODO : Rename
public class TestSomeFunctions {
	Network network;

	@Before
	public void setUp() throws Exception {
		XmlParser parser = new XmlParser("xml/example1.xml");
		parser.parse();
		network = parser.getNetwork();
	}

	@Test
	public void testFirstNodeVisitedByJonI() {
		// Cas première node de i et j
		// Cas première node de i 
		// Cas première node de j
		
		// Cas dernière node de i et j
		// Cas dernière node de i 
		// Cas dernière node de j 
		
		// Cas général
		
		// Cas aucune node
		fail("Not yet implemented");
	}

}
