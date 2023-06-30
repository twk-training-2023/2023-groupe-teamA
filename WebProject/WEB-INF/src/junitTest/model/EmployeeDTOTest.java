package junitTest.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.EmployeeBean;
import model.EmployeeDTO;


class EmployeeDTOTest {

	EmployeeDTO edto;

	@BeforeEach
	void setup() {
		edto = new EmployeeDTO();
	}
	
	@Test
	@DisplayName("社員情報が1つの時のテスト")
	void test1() {
		int id = 1;
		String mail = "xxxx@twk.co.jp";
		String pass = "twkadmin";
		String name = "山田太郎";
		int level = 5;
		EmployeeBean anseb = setEmployeeBean(id, mail, pass, name, level);
		
		edto.add(anseb);
		
		assertEquals(anseb, edto.get(0));
		assertEquals(1, edto.size());
	}

	@Test
	@DisplayName("社員情報が複数の時のテスト")
	void test2() {
		int id = 1;
		String mail = "xxxx123@twk.co.jp";
		String pass = "twkadmin";
		String name = "山田太郎";
		int level = 5;
		EmployeeBean ans1eb = setEmployeeBean(id, mail, pass, name, level);
		id = 1;
		mail = "xxxx456@twk.co.jp";
		pass = "twkadmin";
		name = "鈴木浩人";
		level = 5;
		EmployeeBean ans2eb = setEmployeeBean(id, mail, pass, name, level);
		
		edto.add(ans1eb);
		edto.add(ans2eb);
		assertEquals(ans1eb, edto.get(0));
		assertEquals(ans2eb, edto.get(1));
		assertEquals(2, edto.size());
	}
	

	public EmployeeBean setEmployeeBean(int id,String mail,String pass,String name,int level) {
		EmployeeBean eb = new EmployeeBean();
		eb.setEmployeeID(id);
		eb.setMailaddress(mail);
		eb.setPassword(pass);
		eb.setName(name);
		eb.setPermissionLevel(level);
		return eb;
	}
	

}
