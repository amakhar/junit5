package com.junit5.example;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class ClassATest {

	@Test
    @Tag("development")
    @Tag("production")
    void testCaseA(TestInfo testInfo) { //run in all environments
    }

}
