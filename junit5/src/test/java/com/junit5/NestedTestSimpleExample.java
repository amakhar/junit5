package com.junit5;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

class NestedTestSimpleExample {

	public NestedTestSimpleExample() {
		System.out.println("Outer class instantiated..");
	}
	
	@BeforeAll
	static void initAll() {
		System.out.println("@BeforeAll method.");
	}

	@AfterAll
	static void tearDownAll() {
		System.out.println("@AfterAll method.");
	}
	
	@Test
	void test() {
		System.out.println("Outer Class Test");
	}
	
	@TestInstance(Lifecycle.PER_CLASS)
	@Nested
	class InnerClass {
	
		@BeforeAll
		void initAll() {
			System.out.println("@BeforeAll method.");
		}

		@AfterAll
		void tearDownAll() {
			System.out.println("@AfterAll method.");
		}
		
		public InnerClass() {
			System.out.println("Inner class instantiated..");
		}
		
		@Test
		void test1() {
			System.out.println("Inner Class Test1");
		}
		
		@Test
		void test2() {
			System.out.println("Inner Class Test2");
		}
	}

}
