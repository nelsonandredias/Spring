package com.java.udemy.unittesting.spring.boot.restful.junit.testing.basic;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) 
@SpringBootTest
@TestPropertySource(locations={"classpath:test-configuration.properties"}) // location of test property file
public class ApplicationTests {

	@Test
	public void contextLoads() {
	}

}
