package com.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

@DisplayName("TestInfo Demo")
@Tag("DemoTag")
class TestInfoDemo {

	TestInfoDemo(TestInfo testInfo) {
		System.out.println("Constructor");
		display(testInfo);
		
		assertEquals("TestInfo Demo", testInfo.getDisplayName());
	}

	@BeforeEach
	void init(TestInfo testInfo) {
		System.out.println("BeforeEach : ");
		display(testInfo);
		
		String displayName = testInfo.getDisplayName();
		assertTrue(displayName.equals("TEST 1") || displayName.equals("test2()"));
	}

	@Test
	@DisplayName("TEST 1")
	@Tag("my-tag")
	void test1(TestInfo testInfo) {
		System.out.println("Test1 : ");
		display(testInfo);
		
		assertEquals("TEST 1", testInfo.getDisplayName());
		assertTrue(testInfo.getTags().contains("my-tag"));
	}

	@Test
	void test2(TestInfo testInfo) {
		System.out.println("Test2 : ");
		display(testInfo);
		
	}
	
	void display(TestInfo testInfo) {
		System.out.println("Display Name : " + testInfo.getDisplayName() +
				"Tags : " + testInfo.getTags()
				);
	}
}
