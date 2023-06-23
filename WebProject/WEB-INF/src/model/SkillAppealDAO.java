package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SkillAppealDAO {
	private static final String RDB_DRIVE = "org.postgresql.Driver";
	static AdminConstList adminConPara = new AdminConstList();
	private static final String ADMIN_URL = adminConPara.getUrl();
	private static final String ADMIN_USER = adminConPara.getUser();
	private static final String ADMIN_PASS = adminConPara.getPass();
	static GeneralConstList generalConPara = new GeneralConstList();
	private static final String GENERAL_URL = generalConPara.getUrl();
	private static final String GENERAL_USER = generalConPara.getUser();
	private static final String GENERAL_PASS = generalConPara.getPass();
	private Connection con = null;

	private void connection(int permissionLevel) {
		try {
			Class.forName(RDB_DRIVE);
			if (permissionLevel > 3) {
				con = DriverManager.getConnection(ADMIN_URL, ADMIN_USER, ADMIN_PASS);
			} else {
				con = DriverManager.getConnection(GENERAL_URL, GENERAL_USER, GENERAL_PASS);
			}
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}


	public boolean insertSkillRequest(EmployeeBean employeeBean, String name, String skill_name, String skill_detail, int status) {
		
		PreparedStatement pstmt = null;
		boolean success = false;

		try {
			connection(1);

			String sql = "INSERT INTO skill_appeal VALUES (?, ?, ?, ?, ?, current_timestamp);";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, employeeBean.getEmployeeID());
			pstmt.setString(2, employeeBean.getName());
			pstmt.setString(3, skill_name);
			pstmt.setString(4, skill_detail);			
			pstmt.setInt(5, status);					

			int rowsAffected = pstmt.executeUpdate();

			if (rowsAffected > 0) {
				success = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		disconnect();
		return success;
	}

	public void disconnect() {
		try {
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
