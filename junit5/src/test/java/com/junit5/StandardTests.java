package com.junit5;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

class StandardTests {

	@BeforeAll
	void initAll() {
		System.out.println("@BeforeAll method.");
	}

	@AfterAll
	static void tearDownAll() {
		System.out.println("@AfterAll method.");
	}

	@BeforeEach
	void init() throws Exception {
		System.out.println("@BeforeEach method.");
		
	}
	
	@AfterEach
	void tearDown() throws Exception {
		System.out.println("@AfterEach method.");
	}

	@Test
	void succeedingTest() {
	}

	@Test
	void failingTest() {
		fail("a failing test");
	}
	
	@Test
	//@Disabled("for demonstration purposes")
	void skippedTest() {
	// not executed
	}

}
