package model;
<<<<<<< HEAD

=======
>>>>>>> branch 'work_karasawa' of ssh://git@github.com/twk-training-2023/2023-groupe-teamA

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

<<<<<<< HEAD
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
=======
public class SkillAppealDAO {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database_name";
	private static final String DB_USER = "your_username";
	private static final String DB_PASSWORD = "your_password";
>>>>>>> branch 'work_karasawa' of ssh://git@github.com/twk-training-2023/2023-groupe-teamA

<<<<<<< HEAD
/**
 * Servlet implementation class MypageServlet
 */
@WebServlet("/MypageServlet")
public class SkillAppealDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SkillAppealDAO() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
=======
	public static void insertSkillByEmployeeNumber(String employeeNumber, String skill) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			// データベースに接続
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			// SQL文を準備
			String sql = "INSERT INTO skill_appeal (employee_number, skill_detail) VALUES (?,?)";
			stmt = conn.prepareStatement(sql);
			// パラメータを設定
			stmt.setString(1, employeeNumber);
			stmt.setString(2, skill);
			// クエリを実行
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// リソースを解放
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
>>>>>>> branch 'work_karasawa' of ssh://git@github.com/twk-training-2023/2023-groupe-teamA
	}

	public static void selectAllSkillsByEmployeeNumber(String employeeNumber) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			// データベースに接続
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			// SQL文を準備
			String sql = "SELECT * FROM skill_appeal WHERE employee_number = ?";
			stmt = conn.prepareStatement(sql);
			// パラメータを設定
			stmt.setString(1, employeeNumber);
			// クエリを実行
			rs = stmt.executeQuery();
			// 結果を処理
			while (rs.next()) {
				String evidence = rs.getString("evidence");
				System.out.println("Evidence: " + evidence);
				// 他のカラムの取得や処理もここで行う
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// リソースを解放
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}