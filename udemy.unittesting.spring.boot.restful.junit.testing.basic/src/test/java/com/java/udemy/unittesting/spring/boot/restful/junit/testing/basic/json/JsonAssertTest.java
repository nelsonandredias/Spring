package com.java.udemy.unittesting.spring.boot.restful.junit.testing.basic.json;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.test.context.junit4.SpringRunner;


public class JsonAssertTest {

	
	String actualResponse = "{ \"id\": 1, \"name\": \"Item 1\", \"price\": 10, \"quantity\": 100 }";
	
	@Test
	public void JsonAssertExactMatch() throws JSONException {
		
		String expectedResponse = "{ \"id\": 1, \"name\": \"Item 1\", \"price\": 10, \"quantity\": 100 }";
		
		//JSONAssert.assertEquals(expected, actual, true/false);
		JSONAssert.assertEquals(expectedResponse, actualResponse, true);
		
		
		String expectedResponse2 = "{ \"id\": 1, \"name\": \"Item 1\", \"price\": 10}";
		
		//JSONAssert.assertEquals(expected, actual, true/false);
		JSONAssert.assertNotEquals(expectedResponse2, actualResponse, true);
		
	}
	
	@Test
	public void JsonAssertDifferentMatch() throws JSONException {
			
		
		String expectedResponse2 =  "{ \"id\": 1, \"name\": \"Item 1\", \"price\": 10}";
		
		//JSONAssert.assertEquals(expected, actual, true/false);
		JSONAssert.assertEquals(expectedResponse2, actualResponse, false);
		
	}
	
	@Test
	public void JsonAssertDifferentValues() throws JSONException {
			
		
		String expectedResponse3 = "{ \"id\": 1, \"name\": \"Item 1\", \"price\": 11}";
		
		//JSONAssert.assertEquals(expected, actual, true/false);
		JSONAssert.assertEquals(expectedResponse3, actualResponse, false);
		
	}
	
}
