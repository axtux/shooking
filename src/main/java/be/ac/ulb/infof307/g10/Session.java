package be.ac.ulb.infof307.g10;

public class Session {

	private String userName;
	/* Possible other data
	 * 
	 * private String mail;
	 * private String address;
	 */
	
	public Session(String userName) {
		this.userName = userName;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
}
