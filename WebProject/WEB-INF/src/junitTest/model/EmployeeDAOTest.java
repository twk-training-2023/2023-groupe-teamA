package junitTest.model;

import static org.junit.Assert.*;

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
}
