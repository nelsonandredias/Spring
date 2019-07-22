package com.java.udemy.unittesting.spring.boot.restful.junit.testing.basic.json;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.text.IsEmptyString;
import org.junit.Test;

public class AssertJTest {

	
	@Test
	public void testLearningAssertJ() {
		
		List<Integer> numbers = Arrays.asList(12, 15, 45);
		
		assertThat(numbers)
			.hasSize(3)
			.contains(12,45)
			.allMatch(number -> number>10)
			.noneMatch(number -> number<0);
		
		assertThat("").isEmpty();
		
		assertThat("ABCD")
			.contains("BCD")
			.startsWith("AB");
		
	}
}
