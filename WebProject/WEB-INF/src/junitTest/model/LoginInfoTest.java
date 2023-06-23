package junitTest.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.LoginInfo;

class LoginInfoTest {

	LoginInfo loginInfo;

	@BeforeEach
	void setup() {
		loginInfo = new LoginInfo();
	}
	
	// 	employeeID 	社員番号のgetter/setterテスト
	@Test
	@DisplayName("社員番号のgetter/setterテスト")
	void testGetSetemployeeID() {
		int ans = 1;
		loginInfo.setEmployeeID(ans);
		assertEquals(ans, loginInfo.getEmployeeID());
	}
	
	// 	name 名前のgetter/setterテスト
	@Test
	@DisplayName("社員番号のgetter/setterテスト")
	void testGetSetname() {
		String ans = "桃﨑";
		loginInfo.setName(ans);
		assertEquals(ans, loginInfo.getName());
	}
	
	// 	permissionLevel 権限レベルのgetter/setterテスト
	@Test
	@DisplayName("社員番号のgetter/setterテスト")
	void testGetSetpermissionLevel() {
		int ans = 5;
		loginInfo.setPermissionLevel(ans);
		assertEquals(ans, loginInfo.getPermissionLevel());
	}
}
