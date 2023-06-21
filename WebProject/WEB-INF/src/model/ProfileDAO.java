package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//社員情報 取得のセレクト
	public ProfileDTO selectInfo(LoginInfo loginInfo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ProfileDTO pdto = new ProfileDTO();
		String sql = "select name, mail_address, password from employee where id = ?";
		
		try {
			connection(loginInfo.getPermissionLevel());
			// ②ステートメントを生成
			pstmt = con.prepareStatement(sql);
			//idを任意の値に入れ替えたい
			pstmt.setInt(1, loginInfo.getEmployeeID());
			// ③SQLを実行
			rset = pstmt.executeQuery();
			// ④検索結果の処理
			while (rset.next()) {
				ProfileBean pb = new ProfileBean();
				pb.setName(rset.getString("name"));
				pb.setMail(rset.getString("mail_address"));
				pb.setPass(rset.getString("password"));
				pdto.add(pb);
			}
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
		return pdto;
	}


	//社員プロフィール情報（自己紹介）取得のセレクト
	public ProfileDTO selectAppeal(ProfileDTO pdto, LoginInfo loginInfo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select appeal from profile where id = ?";
		try {
			connection(loginInfo.getPermissionLevel());
			// ②ステートメントを生成
			pstmt = con.prepareStatement(sql);
			//idを任意の値に入れ替えたい
			pstmt.setInt(1, loginInfo.getEmployeeID());
			// ③SQLを実行
			rset = pstmt.executeQuery();
			// ④検索結果の処理
			while (rset.next()) {
				ProfileBean pb = pdto.get(0);
				pdto = new ProfileDTO();
				pb.setAppeal(rset.getString("appeal"));
				pdto.add(pb);
			}
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
		return pdto;
	}

	


	//社員プロフィール情報（自己紹介）の更新　アップデート
	public int selfUpdateAppeal(ProfileBean pb, LoginInfo loginInfo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int flg = 0;
		String sql = "update profile set appeal = ? where id = ?;";
		try {
			connection(loginInfo.getPermissionLevel());
			// ②ステートメントを生成
			pstmt = con.prepareStatement(sql);
			//idを任意の値に入れ替えたい
			pstmt.setString(1, pb.getAppeal());
			pstmt.setInt(2, pb.getEmployeeID());
			// ③SQLを実行
			flg = pstmt.executeUpdate();
			// ④更新処理
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
