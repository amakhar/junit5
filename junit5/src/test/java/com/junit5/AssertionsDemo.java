package com.junit5;

import static java.time.Duration.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.junit5.vo.Person;

class AssertionsDemo {

	@Test
	void standardAssertions() {
		assertEquals(2,2);
		assertEquals(1, 1, "Optional assertion message.");
		assertTrue('a'<'b' , ()->"Assertion messages can be lazily evaluated -- "
				+ "to avoid constructing complex messages unnecessarily." );
	}

	@Test
	void groupedAssertions() {
		
		Person person = new Person("John", "Doe");
		
		assertAll("Person Group assertion Error",
				() -> assertEquals("John", person.getFirstName()),
				() -> assertEquals("Doe", person.getLastName())
		);
		
	}
	
	@Test
	void dependentAssertions() {
		
		Person person = new Person("John", "Doe");
		
		assertAll("Dependent Assertions",
					()->{
					
						String firstName=person.getFirstName();
						assertNotNull(firstName);
						
						assertAll("FirstName Assertion",
								()->{
									assertTrue(firstName.startsWith("J"));
									assertTrue(firstName.endsWith("n"));
								}
						);
					},
					()->{
						
						String lastName=person.getLastName();
						assertNotNull(lastName);
						
						assertAll("LastName Assertion",
								()->{
									assertTrue(lastName.startsWith("D"));
									assertTrue(lastName.endsWith("e"));
								});
					}
		);
	}
	
	
	@Test
	void exceptionTesting() {
		
		Throwable exception = assertThrows(IllegalArgumentException.class, 
					()-> {throw new IllegalArgumentException("a message");}
				);
		assertEquals("a message", exception.getMessage());
	}
	
	@Test
	void timeoutNotExceeded() {
		//assertTimeoutPreemptively
		//assertTimeout
		assertTimeoutPreemptively(ofSeconds(2), 
				()->{
					Thread.sleep(1000);
				}
		);
	}
	
	@Test
	void timeoutNotExceededWithResult() {
		
		String greeting = assertTimeout(ofSeconds(2), 
				()->{
					return "Hello World";
				}
		);
		
		assertEquals("Hello World", greeting);
	}
	
	@Test
	void timeoutNotExceededWithMethod() {
		String greeting = assertTimeout(
					ofSeconds(2),
					AssertionsDemo::greeting
				);
	
		assertEquals("Hello World", greeting);
	}
	
	public static String greeting() {
		return "Hello World";
	}
	
}
