package be.ac.ulb.infof307.g10;

public class Session {

	private String username;
	/* Possible other data
	 * 
	 * private String mail;
	 * private String address;
	 */
	
	public Session(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return this.username;
	}
	
}
