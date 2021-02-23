package models;

public class User {

	private String email;
	private String password;

	public User(String Email, String password) {
		setEmail(Email);
		setPassword(password);
	}

	public String getEmail() {
		return email;
	}

	public User setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public User setPassword(String password) {
		this.password = password;
		return this;
	}



	@Override
	public String toString() {

		return "I am a user.";
	}

}
