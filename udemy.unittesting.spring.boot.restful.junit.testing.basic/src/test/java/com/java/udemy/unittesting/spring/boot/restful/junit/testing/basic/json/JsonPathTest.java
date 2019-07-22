package com.java.udemy.unittesting.spring.boot.restful.junit.testing.basic.json;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonPathTest {

	@Test
	public void TestLearningJsonPath() {
		
		String responseFromService = "[" + 
				"  {" + 
				"    \"planeType\": \"Boeing 787\"," + 
				"    \"code2\": \"0001\"," + 
				"    \"takeOffDate\": \"2016-01-20T00:00:00\"," + 
				"    \"code1\": \"rree\"," + 
				"    \"fromAirport\": \"MUA\"," + 
				"    \"price\": 541," + 
				"    \"seatsAvailable\": 0," + 
				"    \"toAirport\": \"LAX\"," + 
				"    \"ID\": 1," + 
				"    \"airlineName\": \"American Airlines\"," + 
				"    \"totalSeats\": 200" + 
				"  }," + 
				"  {" + 
				"    \"planeType\": \"Boeing 747\"," + 
				"    \"code2\": \"0123\"," + 
				"    \"takeOffDate\": \"2016-01-25T00:00:00\"," + 
				"    \"code1\": \"eefd\"," + 
				"    \"fromAirport\": \"MUA\"," + 
				"    \"price\": 300," + 
				"    \"seatsAvailable\": 7," + 
				"    \"toAirport\": \"CLE\"," + 
				"    \"ID\": 2," + 
				"    \"airlineName\": \"American Airlines\"," + 
				"    \"totalSeats\": 345" + 
				"  }," + 
				"  {" + 
				"    \"planeType\": \"Boeing 777\"," + 
				"    \"code2\": \"0192\"," + 
				"    \"takeOffDate\": \"2016-01-20T00:00:00\"," + 
				"    \"code1\": \"ffee\"," + 
				"    \"fromAirport\": \"MUA\"," + 
				"    \"price\": 300," + 
				"    \"seatsAvailable\": 0," + 
				"    \"toAirport\": \"LAX\"," + 
				"    \"ID\": 3," + 
				"    \"airlineName\": \"American Airlines\"," + 
				"    \"totalSeats\": 300" + 
				"  }" + 
				"]";
		
		// we created a context with a parse of the response. It will allow us to better validate the response
		DocumentContext context = JsonPath.parse(responseFromService);
		
		// in order to start validating, we need to start reading the parsing response from the beginning
		
		// for that, we need to get the number of object elements parsed. Basically, we are reading the parsing from the root ($)
		int length = context.read("$.length()");
		
		//verify that there is 3 objects in the response
		assertThat(length).isEqualTo(3);
		
		//read all planeTypes
		String planeTypes = context.read("$..planeType").toString();
		System.out.println(planeTypes);
		
		assertThat(planeTypes).contains("Boeing 787");
		
		System.out.println(context.read("$.[1]").toString());
		
		System.out.println(context.read("$.[0:1]").toString());
		
		System.out.println(context.read("$.[?(@.fromAirport=='MUA')]").toString());
	}
	
}
