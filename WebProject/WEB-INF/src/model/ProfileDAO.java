
public class ProfileDAO {

	private final String URL = "";
	private final String USER = "";
	private final String PASS = "";
	private Connection con = null;

	public void connect() {
		try {
			// ①DBに接続
			con = DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//引数はログインでの社員情報のid
	public ProfileDTO select(int id) {
		Statement stmt = null;
		ResultSet rs = null;
		ProfileDTO pdto = new ProfileDTO();
		String sql = "select mail_address,password,profile.name,appeal from"
				+ " employee left join profile on employee."
				+ id + "= profile." + id;
		try {
			connect();
			// ②ステートメントを生成
			stmt = con.createStatement();
			// ③SQLを実行
			rs = stmt.executeQuery(sql);
			// ④検索結果の処理
			while (rs.next()) {
				ProfileBean probn = new ProfileBean();
				probn.setMail(rs.getString("mail_address"));
				probn.setPass(rs.getString("password"));
				probn.setNamme(rs.getString("name"));
				probn.setAppeal(rs.getString("appeal"));
				pdto.add(probn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
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
