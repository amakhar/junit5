package com.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

class TestInstanceLifeCycleDemo {

	TestInstanceLifeCycleDemo(){
		System.out.println("Initializing Test Class...");
	}
	
	@Test
	void test1() {
		System.out.println("Test1 executed..");
	}
	
	@Test
	void test2() {
		System.out.println("Test2 executed..");
	}
	
	@Test
	void test3() {
		System.out.println("Test3 executed..");
	}

}
