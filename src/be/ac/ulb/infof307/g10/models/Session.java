package be.ac.ulb.infof307.g10.models;

public class Session {

	private User user;
	
	public Session(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return this.user;
	}
	
}
