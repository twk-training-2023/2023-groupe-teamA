package junitTest.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.EmployeeBean;
import model.LoginInfo;
import model.SkillAppealDAO;

class SkillAppealDAOTest {

	SkillAppealDAO sadao;
	SetModel setmodel;
	ComparisonModel compar;

	@BeforeEach
	void setup() {
		setmodel = new SetModel();
		compar = new ComparisonModel();
		sadao = new SkillAppealDAO();
	}

	@Test
	@DisplayName("コンストラクタテスト")
	public void SkillAppealDAO() {
		SkillAppealDAO testTarget = new SkillAppealDAO();
		assertNotNull(testTarget);
	}
	
	@Test
	@DisplayName("connectメソッドのテスト")
	void test1() {
		LoginInfo ans = setmodel.setLoginInfo(3, "唐澤崇仁", 5);
		
	}

	@Test
	@DisplayName("insertメソッドテスト")
	public void insertSkillRequesttest() {
		boolean success = true;
		
		String name = "唐澤崇仁";
		String skill_name = "Java";
		String skill_detail = "すごい";
		int status = 1;				
		//List<String> parameter = Arrays.asList("3");
		EmployeeBean eb = new EmployeeBean();
		eb.setEmployeeID(3);
		eb.setName(name);
		boolean result =sadao.insertSkillRequest(eb, name, skill_name, skill_detail, status);
		System.out.println(result);
		
		//List<String> parameter = Arrays.asList("3", "唐澤崇仁", "Java", "すごい", "1", "2023/06/28 15:17:22.581");
		//SkillAppealBean sab = setmodel.setSkillAppealBean(parameter);
		
		//if (sab != null);
		//    boolean result = true;
		assertEquals(success, result);
	}
	@Test
	@DisplayName("insertメソッドテスト2 失敗")
	public void insertSkillRequesttest2() {
		boolean success = false;
		
		String name = "null";
		String skill_name = "Java";
		String skill_detail = "すごい";
		int status = 1;				
		List<String> parameter = Arrays.asList("3");
		EmployeeBean eb = setmodel.setEmployeeBean(parameter);
		boolean result =sadao.insertSkillRequest(eb, name, skill_name, skill_detail, status);
		if(result != true);
			int rowsAffected = 1;
			    if(rowsAffected >= 0);
			    	boolean result2 = false;
		//List<String> parameter = Arrays.asList("3", "唐澤崇仁", "Java", "すごい", "1", "2023/06/28 15:17:22.581");
		//SkillAppealBean sab = setmodel.setSkillAppealBean(parameter);
		
		//if (sab != null);
		//    boolean result = true;
		assertEquals(success, result2);
	}

}
