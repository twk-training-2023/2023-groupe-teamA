package junitTest.model;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.EmployeeBean;
import model.EmployeeDAO;
import model.EmployeeDTO;
import model.LoginInfo;

class EmployeeDAOTest {

	EmployeeDAO edao;
	SetModel setmodel;
	ComparisonModel compar;
	
	@BeforeEach
	void setup() {
		setmodel = new SetModel();
		compar = new ComparisonModel();
		edao = new EmployeeDAO();
	}
	
	@Test
	@DisplayName("selectCheckPassメソッドのテスト(認証成功)")
	void test1() {
		LoginInfo ans = setmodel.setLoginInfo(4, "桃﨑奏斗", 5);
		List<String> parameter = Arrays.asList("000","kanato-momozaki@twk.co.jp","a", "xxx", "000");
		EmployeeBean eb = setmodel.setEmployeeBean(parameter);
		LoginInfo loginInfo = edao.selectCheckPass(eb);
		compar.ComparisonLoginInfo(ans, loginInfo);
	}
	
	@Test
	@DisplayName("selectCheckPassメソッドのテスト(認証失敗)")
	void test2() {
		List<String> parameter = Arrays.asList("000","kanato-momozaki@twk.co.jp","asd", "xxx", "000");
		EmployeeBean eb = setmodel.setEmployeeBean(parameter);
		LoginInfo loginInfo = edao.selectCheckPass(eb);
		assertNull(loginInfo);
	}

	@Test
	@DisplayName("selfUpdateInfoメソッドのテスト(更新成功)")
	void test3() {
		int ans = 1;
		LoginInfo loginInfo = setmodel.setLoginInfo(4, "桃﨑奏斗", 5);
		List<String> parameter = Arrays.asList("4","kanato-momozaki@twk.co.jp","a", "桃﨑奏斗", "5");
		EmployeeBean eb = setmodel.setEmployeeBean(parameter);
		int result = edao.selfUpdateInfo(eb, loginInfo);
		assertEquals(ans, result);
	}
	
	@Test
	@DisplayName("selfUpdateInfoメソッドのテスト(更新失敗)")
	void test4() {
		int ans = 0;
		LoginInfo loginInfo = setmodel.setLoginInfo(4, "桃﨑奏斗", 5);
		List<String> parameter = Arrays.asList("4","yuki-ishii@twk.co.jp","", "桃﨑奏斗", "5");
		EmployeeBean eb = setmodel.setEmployeeBean(parameter);
		int result = edao.selfUpdateInfo(eb, loginInfo);
		assertEquals(ans, result);
	}
	
	
	@Test
	@DisplayName("insertEmployeeCSVメソッドのテスト(追加成功)")
	void test5() throws SQLException {
		boolean ans = true;
		LoginInfo loginInfo = setmodel.setLoginInfo(4, "桃﨑奏斗", 5);
		List<List<String>> parameter = Arrays.asList(
				Arrays.asList("000","aaaaa@twk.co.jp","asd", "足利啓太", "1"),
				Arrays.asList("000","mmmmm@twk.co.jp","asd", "森一美", "1"),
				Arrays.asList("000","kkkkk@twk.co.jp","asd", "川口恵美", "1")
				);
		EmployeeDTO edto = setmodel.setEmployeeDTO(parameter);
		boolean result = edao.insertEmployee(edto, loginInfo);
		assertEquals(ans, result);
	}
	
	@Test
	@DisplayName("insertEmployeeCSVメソッドのテスト(追加失敗　重複)")
	void test6() throws SQLException {
		boolean ans = false;
		LoginInfo loginInfo = setmodel.setLoginInfo(4, "桃﨑奏斗", 5);
		List<List<String>> parameter = Arrays.asList(
				Arrays.asList("000","aaaaa@twk.co.jp","asd", "足利啓太", "1"),
				Arrays.asList("000","aaaaa@twk.co.jp","asd", "森一美", "1"),
				Arrays.asList("000","kkkkk@twk.co.jp","asd", "川口恵美", "1")
				);
		EmployeeDTO edto = setmodel.setEmployeeDTO(parameter);
		boolean result = edao.insertEmployee(edto, loginInfo);
		assertEquals(ans, result);
	}
	
	@Test
	//社員一覧取得
	@DisplayName("社員一覧取得")
	public void test7() {

		//LoginInfoの値　ログイン想定して値入れる
		int employeeID = 2; //社員番号
		String name = "稲坂黎"; //名前
		int permissionLevel = 5; //権限レベル
		//infoに格納
		LoginInfo info = new LoginInfo();
		info.setEmployeeID(employeeID);
		info.setName(name);
		info.setPermissionLevel(permissionLevel);
		//edtoの中にDAOファイルのselectAllメソッドを入れる
		EmployeeDAO dao = new EmployeeDAO();
		EmployeeDTO edto = dao.selectAll(info);
		//ebから名前を取りだして比較
		EmployeeBean eb = new EmployeeBean();
		eb = edto.get(0);
		assertEquals(1, eb.getEmployeeID());
		assertEquals("石井佑樹", eb.getName());
		assertEquals("yuki-ishii@twk.co.jp", eb.getMailaddress());
		assertEquals("twkadmin1", eb.getPassword());
		assertEquals(5, eb.getPermissionLevel());

	}

	@Test
	//社員追加（単体）
	@DisplayName("社員追加（単体）")
	public void test8() {
		EmployeeDAO dao = new EmployeeDAO();

		//insert文の引数の値の正しい情報をセット
		String name = "中土佐町";
		String mail = "uon@twk.co.jp";
		String password = "tw";
		int level = 2;

		//LoginInfoの値　ログイン想定して値入れる
		int employeeID = 2;//	社員番号
		String name2 = "稲坂黎";//	名前
		int permissionLevel = 5;//権限レベル
		//想定した値をinfoに格納
		LoginInfo info = new LoginInfo();
		info.setEmployeeID(employeeID);
		info.setName(name2);
		info.setPermissionLevel(permissionLevel);

		//iの中にDAOフィルのaddEmployeeメソッドを入れる
		int i = dao.addEmployee(name, mail, password, level, info);
		//最後iが1になれば実行が成功するから
		assertEquals(1, i);
	}
}
