package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BeforeAfterTest {

	//beforeClass will be executed once
	//beforeClass can be used for specific cases like initializing some database connection for instance
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Executed before class");
	}
	
	
	//setup executed before every test: in this case, will be executed twice
	@Before
	public void setup() {
		System.out.println("setting up all before testing");
	}
	
	
	@Test
	public void testBeforeAfter_execution1() {
		System.out.println("test 1 executed");
	}

	@Test
	public void testBeforeAfter_execution2() {
		System.out.println("test 2 executed");
	}
	
	//tear down executed before every test: in this case, will be executed twice
	@After
	public void teardown() {
		System.out.println("tear down after testing");
	}
	
	//afterClass will be executed once
	@AfterClass
	public static void afterClass() {
		System.out.println("Executed after class");
	}
	
}
