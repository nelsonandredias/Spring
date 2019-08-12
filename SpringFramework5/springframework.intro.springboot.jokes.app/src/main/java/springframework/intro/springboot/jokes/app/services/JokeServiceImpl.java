package springframework.intro.springboot.jokes.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;

@Service
public class JokeServiceImpl implements JokeService {

	private ChuckNorrisQuotes chuckNorrisQuotes;
	
	
	@Autowired
	public ChuckNorrisQuotes getChuckNorrisQuotes() {
		return chuckNorrisQuotes;
	}



	@Override
	public String getJoke() {
		return chuckNorrisQuotes.getRandomQuote();
	}

	
}
