package test;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import ise.*;


public class TestAlgorithm {
	Algorithm algo;
	/* j1 i1 : intersection non nulle, meme direction */
	Path j1;
	Path i1;
	Node firstj1i1;
	Node lastj1i1;
	
	@Before
	public void init() {
		algo = new Algorithm();
		j1 = new Path();
		i1 = new Path();
		firstj1i1 = new Node();
		lastj1i1 = new Node();
		
		for(int i=0; i<10; i++) {
			i1.getNodes().add(new Node());
			j1.getNodes().add(new Node());
		}

		i1.getNodes().add(firstj1i1);
		j1.getNodes().add(firstj1i1);
		
		for(int i=0; i<10; i++) {
			Node n = new Node();
			i1.getNodes().add(n);
			j1.getNodes().add(n);
		}
	
		i1.getNodes().add(lastj1i1);
		j1.getNodes().add(lastj1i1);
		
		for(int i=0; i<10; i++) {
			i1.getNodes().add(new Node());
			j1.getNodes().add(new Node());
		}
	}
	
	@Test
	public void test_firstNodeVisitedByJonI() {
		try {
			assertEquals(firstj1i1, algo.firstNodeVisitedByJonI(j1, i1));
		} catch (Exception e) {
			assertTrue(false);
		}
	}
	
	@Test
	public void test_lastNodeVisitedByJonI() {
		try {
			assertEquals(lastj1i1, algo.lastNodeVisitedByJonI(j1, i1));
		} catch (Exception e) {
			assertTrue(false);
		}
	}
}