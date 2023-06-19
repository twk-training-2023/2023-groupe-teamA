package model;

public class AdminConstList {
	private final String url = "jdbc:postgresql://localhost:5432/teambdb";
	private final String user = "administrator";
	private final String pass = "twkadmin";
		
	public String getUrl() {
		return this.url;
	}
	
	public String getUser() {
		return this.user;
	}
	
	public String getPass() {
		return this.pass;
	}
}
