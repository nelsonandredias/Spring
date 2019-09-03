package udemy.learning.springframework.intro.cdi;

import javax.inject.Named;

import org.springframework.stereotype.Component;

@Named
public class SomeCdiDAO {

	//replacing a database
	public int[] getData() {
		return new int[] {3,84,100};
	}
	
}
