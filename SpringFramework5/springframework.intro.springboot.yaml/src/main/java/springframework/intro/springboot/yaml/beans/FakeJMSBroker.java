package springframework.intro.springboot.yaml.beans;

public class FakeJMSBroker {

	private String username;
	private String password;
	private String url;
	
	public FakeJMSBroker(String username, String password, String url) {
		super();
		this.username = username;
		this.password = password;
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "FakeJMSBroker [username=" + username + ", password=" + password + ", url=" + url + "]";
	}
	
	
	
}
