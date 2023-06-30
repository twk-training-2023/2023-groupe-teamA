package junitTest.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import model.EmployeeBean;
import model.EmployeeDAO;
import model.EmployeeDTO;
import model.LoginInfo;

public class EmployeeDAOTest {

	@Test
	//社員一覧取得
	public void test1() {

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
	public void test2() {
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
