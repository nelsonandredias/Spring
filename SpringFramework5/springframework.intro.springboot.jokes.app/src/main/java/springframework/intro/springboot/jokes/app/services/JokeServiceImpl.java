package springframework.intro.springboot.jokes.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;

@Service
public class JokeServiceImpl implements JokeService {

	private final ChuckNorrisQuotes chuckNorrisQuotes;

	@Autowired
	public JokeServiceImpl() {
		
		this.chuckNorrisQuotes = new ChuckNorrisQuotes();
	}


	@Override
	public String getJoke() {
		return chuckNorrisQuotes.getRandomQuote();
	}

	
}
