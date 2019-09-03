package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

//Run the class "StringHelperParameterizedTest2" as parameterized
@RunWith(Parameterized.class)
public class StringHelperParameterizedTest2 {

	StringHelper helper = new StringHelper();
	
	//create local argument so they can be used in test
	private String input;
	
	
	//pass the argument parameter as constructor 
	public StringHelperParameterizedTest2(String input) {
		super();
		this.input = input;
	}


	//definition of constructor argument parameters to test
	@Parameters
	public static Collection<String> testConditions() {
		
		//{expected input / expected output}
		String inputValues[] = {"ABCD","A"};
		
		//convert an array into a collection of String[]
		return Arrays.asList(inputValues);
	}
	 

	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_BasicNegativeScenario() {
		
		//ABCD => false ; ABAB => true ; AB => true ; A => false
		assertFalse(helper.areFirstAndLastTwoCharactersTheSame(input));
	}

	
}
