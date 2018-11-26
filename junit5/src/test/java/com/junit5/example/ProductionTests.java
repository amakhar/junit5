package com.junit5.example;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;

@SelectPackages("com.junit5.example")
@IncludeTags("production")
class ProductionTests {

	@Test
	void test() {
		//fail("Not yet implemented");
	}

}
