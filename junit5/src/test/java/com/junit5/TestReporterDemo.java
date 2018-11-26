package com.junit5;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

class TestReporterDemo {

	@Test
	void testReporterSingleValue(TestReporter testReporter) {
		testReporter.publishEntry("a status message");
	}
	
	@Test
	void testReporterKeyValue(TestReporter testReporter){
	    testReporter.publishEntry("myKey","myValue");
	}
	@Test
	void testReporterMap(TestReporter testReporter){
	    Map <String, String> myMap = new HashMap();
	    myMap.put("myMapKey","myValue");
	    testReporter.publishEntry(myMap);
	}
}
