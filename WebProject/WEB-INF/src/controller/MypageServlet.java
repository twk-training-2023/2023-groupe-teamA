package controller;
<<<<<<< HEAD

=======
>>>>>>> branch 'work_karasawa' of ssh://git@github.com/twk-training-2023/2023-groupe-teamA

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

<<<<<<< HEAD
public class MypageServlet {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database_name";
	private static final String DB_USER = "your_username";
	private static final String DB_PASSWORD = "your_password";

	public static void insertSkillByEmployeeNumber(String employeeNumber, String skill) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			// データベースに接続
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			// SQL文を準備
			String sql = "INSERT INTO skill_appeal (employee_number, evidence) VALUES (?,?)";
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
=======
public class MypageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		// DAOを使用してデータベースから該当の社員情報を取得する
		Employee employee = EmployeeDAO.getEmployeeByUsername(username);
		// マイページのJSPに社員情報を渡して表示する
		request.setAttribute("employee", employee);
		request.getRequestDispatcher("mypage.jsp").forward(request, response);
>>>>>>> branch 'work_karasawa' of ssh://git@github.com/twk-training-2023/2023-groupe-teamA
	}
}
