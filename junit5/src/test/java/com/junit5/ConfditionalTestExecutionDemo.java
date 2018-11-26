package com.junit5;

import static org.junit.jupiter.api.condition.OS.LINUX;
import static org.junit.jupiter.api.condition.OS.WINDOWS;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnOs;


class ConfditionalTestExecutionDemo {

	@EnabledOnOs({WINDOWS,LINUX})
	@Test
	void OnlyOnWindowsOS() {
		System.out.println("Runing on Windows/Linux OS");
	}
	
	@Test
	@EnabledIfEnvironmentVariable(named = "ENV", matches = "DEV")
	void onlyInDev() {
		System.out.println("Only IN DEV env.");
	}
	
	@Test // Static JavaScript expression.
	@EnabledIf("2 * 3 == 6")
	void willBeExecuted() {
		
	}
	
	@RepeatedTest(10) // Dynamic JavaScript expression.
	@DisabledIf("Math.random() < 0.314159")
	void mightNotBeExecuted() {
		System.out.println("Might not be executed test..");
	}

}
