package model;

import java.sql.*;

public class ProfileDAO {

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

	//		コネクトメソッド    データベースに接続する
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

	//社員情報取得のセレクト
	public ProfileDTO selectInfo(EmployeeBean eb) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProfileDTO pdto = new ProfileDTO();
		String sql = "select mail_address,password,name from emp.employee where mail_address = ?";
		try {
			connection(1);
			// ②ステートメントを生成
			pstmt = con.prepareStatement(sql);
			//idを任意の値に入れ替えたい
			pstmt.setString(1, eb.getMailaddress());
			// ③SQLを実行
			rs = pstmt.executeQuery(sql);
			// ④検索結果の処理
			while (rs.next()) {
				ProfileBean probn = new ProfileBean();
				probn.setMail(rs.getString("mail_address"));
				probn.setPass(rs.getString("password"));
				probn.setName(rs.getString("name"));
				pdto.add(probn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		disconnect();
		return pdto;
	}

	//社員プロフィール情報（自己紹介）取得のセレクト
	public ProfileDTO selectAppeal(EmployeeBean eb) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProfileDTO pdto = new ProfileDTO();
		String sql = "select appeal from profile where id = ?";
		try {
			connection(1);
			// ②ステートメントを生成
			pstmt = con.prepareStatement(sql);
			//idを任意の値に入れ替えたい
			pstmt.setString(1, eb.getMailaddress());
			// ③SQLを実行
			rs = pstmt.executeQuery(sql);
			// ④検索結果の処理
			while (rs.next()) {
				ProfileBean probn = new ProfileBean();
				probn.setAppeal(rs.getString("appeal"));
				pdto.add(probn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		disconnect();
		return pdto;
	}

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
