package com.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

class TestInterfaceDemo implements TestInterface{

	@RepeatedTest(10)
	void repeatedTest() {
		assertEquals(1, 1);
	}
	
	@RepeatedTest(5)
	void repeatedTestWithRepetitionInfo(RepetitionInfo repetitionInfo) {
		assertEquals(5, repetitionInfo.getTotalRepetitions());
	}
	
	@RepeatedTest(value = 1, name = "{displayName} {currentRepetition}/{totalRepetitions}")
	@DisplayName("Repeat!")
	void customDisplayName(TestInfo testInfo) {
		assertEquals(testInfo.getDisplayName(), "Repeat! 1/1");
	}
	
	@RepeatedTest(value = 1, name = RepeatedTest.LONG_DISPLAY_NAME)
	@DisplayName("Details...")
	void customDisplayNameWithLongPattern(TestInfo testInfo) {
		assertEquals(testInfo.getDisplayName(), "Details... :: repetition 1 of 1");
	}
}
