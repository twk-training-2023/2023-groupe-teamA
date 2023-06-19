package model;

public class GeneralConstList {
	private final String url = "jdbc:postgresql://localhost:5432/teambdb";
	private final String user = "general";
	private final String pass = "twkgeneral";
		
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
