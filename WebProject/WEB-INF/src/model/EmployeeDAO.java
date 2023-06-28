package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



	public class EmployeeDAO {
		//接続用の情報をフィールドに定数として定義
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

		//	コネクトメソッド    データベースに接続する
		private void connection(int permissionLevel) {
			try {
				Class.forName(RDB_DRIVE);
				if (permissionLevel > 3) {
					con = DriverManager.getConnection(ADMIN_URL, ADMIN_USER, ADMIN_PASS);
				}else {
					con = DriverManager.getConnection(GENERAL_URL, GENERAL_USER, GENERAL_PASS);
				}
			} catch (Exception e) {
				throw new IllegalStateException(e);
			}
		}

		//	ログイン認証メソッド
		//	ログインの際に入力されたメールアドレスとパスワードをデータベースで検索してヒットした場合に社員番号、名前、権限レベルを格納したLoginInfoを返す
		public LoginInfo selectCheckPass(EmployeeBean eb) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			LoginInfo logininfo = null;
			try {
				// ①DBに接続	
				connection(1);

				String sql = "select id, name, permission_level from employee where mail_address = ? and password = ?;";
				pstmt = con.prepareStatement(sql);


				pstmt.setString(1, eb.getMailaddress());
				pstmt.setString(2, eb.getPassword());

				// ③SQLを実行
				rset = pstmt.executeQuery();

				// ④検索結果の処理
				while (rset.next()) {
					logininfo = new LoginInfo();
					logininfo.setEmployeeID(rset.getInt("id"));
					logininfo.setName(rset.getString("name"));
					logininfo.setPermissionLevel(rset.getInt("permission_level"));	
				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				try {
					if (rset != null)
						rset.close();
					if (pstmt != null)
						pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			disconnect();
			return logininfo;
		}

		//社員一覧取得処理
		public EmployeeDTO selectAll(LoginInfo loginInfo) {

			PreparedStatement pstmt = null;
			ResultSet rset = null;
			EmployeeDTO edto = new EmployeeDTO();
			try {
				// ①DBに接続    
				connection(loginInfo.getPermissionLevel());
				String sql = "select id, name, mail_address, password, permission_level from employee;";
				pstmt = con.prepareStatement(sql);
				// ③SQLを実行
				rset = pstmt.executeQuery();
				// ④検索結果の処理
				while (rset.next()) {
					EmployeeBean eb = new EmployeeBean();

					eb.setEmployeeID(rset.getInt("id"));
					eb.setName(rset.getString("name"));
					eb.setMailaddress(rset.getString("mail_address"));
					eb.setPassword(rset.getString("password"));
					eb.setPermissionLevel(rset.getInt("permission_level"));

					edto.add(eb);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				try {
					if (rset != null)
						rset.close();
					if (pstmt != null)
						pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			disconnect();
			return edto;
		}


		
	//社員情報の更新　アップデート
	public int selfUpdateInfo(EmployeeBean eb, LoginInfo loginInfo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int flg = 0;
		String sql = "update employee set mail_address = ?, password = ? where id = ?;";
		try {
			connection(loginInfo.getPermissionLevel());
			// ②ステートメントを生成
			pstmt = con.prepareStatement(sql);
			//idを任意の値に入れ替えたい
			pstmt.setString(1, eb.getMailaddress());
			pstmt.setString(2, eb.getPassword());
			pstmt.setInt(3, eb.getEmployeeID());
			// ③SQLを実行
			flg = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null)
					rset.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		disconnect();
		return flg;
	}
	
	public boolean insertEmployeeCSV(EmployeeDTO edto,LoginInfo loginInfo) throws SQLException {
		PreparedStatement pstmtID = null;
		PreparedStatement pstmtEmployee = null;
		PreparedStatement pstmtProfile = null;
		ResultSet rset = null;
		int employeeflg = 0;
		int profileflg = 0;
		boolean result = false;
		EmployeeBean eb;
		ProfileBean pb;
		//社員番号の生成している最後の番号を取得する
		String employeeIDSQL = "select last_value from employee_id_seq;";
		
		//社員テーブルに追加するSQL文
		String insertEmployeeSQL = "INSERT INTO employee (mail_address, password, name, permission_level) VALUES ";
		String valueEmployeeSQL = "(?,?,?,?),";
		StringBuilder employeeSQLBuild = new StringBuilder();
		employeeSQLBuild.append(insertEmployeeSQL);
		
		//プロフィールテーブルに追加するSQL文
		String insertProfileSQL = "INSERT INTO profile (id, name, appeal) VALUES ";
		String valueProfileSQL = "(?,?,?),";
		
		
		StringBuilder profileSQLBuild = new StringBuilder();
		profileSQLBuild.append(insertProfileSQL);
		for (int i = 0; i < edto.size(); i++) {
			employeeSQLBuild.append(valueEmployeeSQL);
			profileSQLBuild.append(valueProfileSQL);
		}
		employeeSQLBuild.deleteCharAt(employeeSQLBuild.length() - 1);
		employeeSQLBuild.append(";");
		String employeeSQL = employeeSQLBuild.toString();
		
		profileSQLBuild.deleteCharAt(profileSQLBuild.length() - 1);
		profileSQLBuild.append(";");
		String profileSQL = profileSQLBuild.toString();
		
		try {
			connection(loginInfo.getPermissionLevel());
			
			//自動コミットOFF
            con.setAutoCommit(false);
			
            pstmtID = con.prepareStatement(employeeIDSQL);
            rset = pstmtID.executeQuery();
            int lastID = 0;
            while (rset.next()) {
            	lastID = rset.getInt("last_value");
            }
            
            pstmtEmployee = con.prepareStatement(employeeSQL);
            pstmtProfile = con.prepareStatement(profileSQL);
			//idを任意の値に入れ替えたい
			for (int i = 0; i < edto.size(); i++) {
				int index = i * 4;
				eb = edto.get(i);
				pstmtEmployee.setString(1 + index, eb.getMailaddress());
				pstmtEmployee.setString(2 + index, eb.getPassword());
				pstmtEmployee.setString(3 + index, eb.getName());
				pstmtEmployee.setInt(4 + index, eb.getPermissionLevel());
			}
			
			for (int i = 0; i < edto.size(); i++) {
				int index = i * 3;
				eb = edto.get(i);
				pstmtProfile.setInt(1 + index, 1 + lastID + i);
				pstmtProfile.setString(2 + index, eb.getName());
				pstmtProfile.setString(3 + index, "未設定");
			}
			

			employeeflg = pstmtEmployee.executeUpdate();
			if (employeeflg == edto.size()) {
				profileflg = pstmtProfile.executeUpdate();
				if (profileflg == edto.size()) {
					result = true;
					con.commit();
				}
			}
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
		} finally {
			try {
				if (rset != null)
					rset.close();
				if (pstmtEmployee != null)
					pstmtEmployee.close();
					pstmtProfile.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		disconnect();
		return result;
	}
	
	
	
	
	// 社員追加処理
		public int addEmployee(String name,String mail,String password,int level,LoginInfo loginInfo) {

			PreparedStatement pstmt = null;

			ResultSet rset = null;

			int i = 0;

			String sql = "insert into employee (name, mail_address, password , permission_level) values(?,?,?,?);";

			try {

				// ①DBに接続    
				connection(loginInfo.getPermissionLevel());
				//自動コミットoff
				con.setAutoCommit(false);

				// ②ステートメントを生成
				pstmt = con.prepareStatement(sql);

				pstmt.setString(1,name);
				pstmt.setString(2,mail);
				pstmt.setString(3,password);
				pstmt.setInt(4,level);

				// ③SQLを実行
				i = pstmt.executeUpdate();
				con.commit();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rset != null)
						rset.close();
					if (pstmt != null)
						pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			disconnect();
			return i;
		}

	
	  
//	ディスコネクトメソッド   データベースからの接続を終了する
	public void disconnect() {
		try {
			// ⑤DBを切断
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
