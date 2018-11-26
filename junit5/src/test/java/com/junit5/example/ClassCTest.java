package com.junit5.example;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class ClassCTest {

	@Test
    @Tag("development")
    void testCaseC(TestInfo testInfo) {
    }

}
