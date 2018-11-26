package com.junit5;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TaggingDemo {

	@Test
	@Tag("taxes")
	void testingTaxCalculation() {
	}
	
}