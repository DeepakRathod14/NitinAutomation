package nitin.automation.beans;

public class Authentication {

	private String username;
	private String password;
	
	private Authentication() {
		this.username="admin";
		this.password="password123";
	}

	public static Authentication newBuilder() {
		return new Authentication();
	}
	
	public Authentication build() {
		setUsername(this.username);
		setPassword(this.password);
		return this;
	}
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public Authentication setUsername(String username) {
		this.username = username;
		return this;
	}

	public Authentication setPassword(String password) {
		this.password = password;
		return this;
	}
	
	
}
