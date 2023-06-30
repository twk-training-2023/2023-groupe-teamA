package model;
//0619 仮完成

public class SkillAppealBean {
	private int employeeID;
	private String skill_level;
	private String skill_detail;
	private int skill_change_send;
	private String skill_send_date;
	//timestampが使えない様子

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getskill_level() {
		return skill_level;
	}

	public void setskill_level(String skill_level) {
		this.skill_level = skill_level;
	}

	public String getskill_detail() {
		return skill_detail;
	}

	public void setskill_detail(String skill_detail) {
		this.skill_detail = skill_detail;
	}

	public int getskill_change_send() {
		return skill_change_send;
	}

	public void setskill_change_send(int skill_change_send) {
		this.skill_change_send = skill_change_send;
	}

	public String getskill_send_date() {
		return skill_send_date;
	}

	public void setskill_send_date(String skill_send_date) {
		this.skill_send_date = skill_send_date;
	}
}
