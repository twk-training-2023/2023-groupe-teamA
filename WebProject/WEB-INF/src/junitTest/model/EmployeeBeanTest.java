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
	void testGetSetname() {
		String ans = "kanato-momozaki@twk.co.jp";
		eb.setName(ans);
		assertEquals(ans, eb.getName());
	}
	
	// 	password パスワードのgetter/setterテスト
	@Test
	@DisplayName("社員番号のgetter/setterテスト")
	void testGetSetpermissionLevel() {
		int ans = 5;
		eb.setPermissionLevel(ans);
		assertEquals(ans, eb.getPermissionLevel());
	}
}
