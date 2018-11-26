package com.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

interface TestInterface {

	@Test
	default void testInterface() {
		assertEquals(1, 1);
	}

}
