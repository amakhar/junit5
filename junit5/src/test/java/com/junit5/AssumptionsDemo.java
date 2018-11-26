package com.junit5;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.Test;

class AssumptionsDemo {

	@Test
	void testOnlyOnCiServer() {
		assumeTrue("CI".equals(System.getenv("ENV")));
		
		//Remainder of test case
		assertEquals(1,1);
	}

	@Test
	void testOnlyOnDeveloperWorkstation(){
		assumeTrue("DEV".equals(System.getenv("ENV")), 
					()->{
						return "Aborting Test : Not a developer Workstation.";
					}
				);
		
		//Remainder of the test
		assertEquals(1, 1);
	}
	
	@Test
	void testInAllEnvironments() {
		assumingThat("DEV".equals(System.getenv("ENV")), 
				()->{
					assertEquals(1, 1);
				}
				);
		
		assertTrue("a".equals("a"));
		
	}
}
