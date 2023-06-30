package junitTest.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.EmployeeBean;

class EmployeeBeanTest {

	EmployeeBean eb;

	@BeforeEach
	void setup() {
		eb = new EmployeeBean();
	}
	
	// 	employeeID 	社員番号のgetter/setterテスト
	@Test
	@DisplayName("社員番号のgetter/setterテスト")
	void testGetSetemployeeID() {
		int ans = 1;
		eb.setEmployeeID(ans);
		assertEquals(ans, eb.getEmployeeID());
	}
	
	// 	mailaddress メールアドレスのgetter/setterテスト
	@Test
	@DisplayName("メールアドレスのgetter/setterテスト")
	void testGetSetMailaddress() {
		String ans = "kanato-momozaki@twk.co.jp";
		eb.setMailaddress(ans);
		assertEquals(ans, eb.getMailaddress());
	}
	
	// 	password パスワードのgetter/setterテスト
	@Test
	@DisplayName("パスワードのgetter/setterテスト")
	void testGetSetPassword() {
		String ans = "twkadmin";
		eb.setPassword(ans);
		assertEquals(ans, eb.getPassword());
	}
	
	// 	name 名前のgetter/setterテスト
	@Test
	@DisplayName("名前のgetter/setterテスト")
	void testGetSetName() {
		String ans = "桃﨑";
		eb.setName(ans);
		assertEquals(ans, eb.getName());
	}
	
	// 	permissionLevel 権限レベルのgetter/setterテスト
	@Test
	@DisplayName("権限レベルのgetter/setterテスト")
	void testGetSetPermissionLevel() {
		int ans = 5;
		eb.setPermissionLevel(ans);
		assertEquals(ans, eb.getPermissionLevel());
	}
}
