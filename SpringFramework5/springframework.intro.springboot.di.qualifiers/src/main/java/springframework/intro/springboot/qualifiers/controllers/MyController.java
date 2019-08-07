package springframework.intro.springboot.qualifiers.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {

	
	public String hello() {
		return "Hello World";
	}
	
}
