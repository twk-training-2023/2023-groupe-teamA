package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
