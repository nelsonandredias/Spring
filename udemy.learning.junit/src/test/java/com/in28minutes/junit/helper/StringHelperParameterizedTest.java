package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

//Run the class "StringHelperParameterizedTest" as parameterized
@RunWith(Parameterized.class)
public class StringHelperParameterizedTest {

	StringHelper helper = new StringHelper();
	
	//create local arguments so they can be used in test
	private String input;
	private String expectedOutput;
	
	
	//pass the argument parameters as constructor 
	public StringHelperParameterizedTest(String input, String expectedOutput) {
		super();
		this.input = input;
		this.expectedOutput = expectedOutput;
	}


	//definition of constructor argument parameters to test
	@Parameters
	public static Collection<String[]> testConditions() {
		
		//{expected input / expected output}
		String expectedOutputs[][] = {
				{"AACD", "CD"},
				{"ACD", "CD"},
				{"CDEF", "CDEF"},
				{"CDAA", "CDAA"}
		};
		
		//convert an array into a collection of String[]
		return Arrays.asList(expectedOutputs);
	}
	 

	@Test
	public void testTruncateAInFirst2Positions_AinFirst2Position() {
		
		//AACD => CD ; ACD => CD ; CDEF => CDEF; CDAA => CDAA
		//asertEquals(expected, actual)
		assertEquals(expectedOutput, helper.truncateAInFirst2Positions(input));
	}
	
}
