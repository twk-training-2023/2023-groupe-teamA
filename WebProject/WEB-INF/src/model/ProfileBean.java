package model;

public class EmployeeBean {
	private String mail;//	社員情報テーブル
	private String pass;//	社員情報テーブル
	private String name;//	プロフィールテーブル
	private String appeal;// プロフィールテーブル
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public void setName(int name) {
		this.name = name;
	}
	
	public void setAppeal(String appeal) {
		this.appeal = appeal;
	}
	
	public int getMail() {
		return mail;
	}
	
	public String getPass() {
		return pass;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAppeal() {
		return appeal;
	}
		
}
