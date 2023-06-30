package junitTest.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.SkillAppealBean;

class SkillAppealBeanTest {

	SkillAppealBean sab;

	@BeforeEach
	void setup() {
		sab = new SkillAppealBean();
	}
	
	// 	employeeID 	社員番号のgetter/setterテスト
	@Test
	@DisplayName("社員番号のgetter/setterテスト")
	void testGetSetemployeeID() {
		int ans = 1;
		sab.setEmployeeID(ans);
		assertEquals(ans, sab.getEmployeeID());
	}
	
	// 	skill_detail スキル詳細のgetter/setterテスト
	@Test
	@DisplayName("スキル詳細のgetter/setterテスト")
	void testGetSetskill_detail() {
		String ans = "java";
		sab.setskill_detail(ans);
		assertEquals(ans, sab.getskill_detail());
	}
    // 	skill_detail スキル詳細のgetter/setterテスト
	@Test
	@DisplayName("スキルレベルのgetter/setterテスト")
	void testGetSetskill_level() {
		String ans = "java";
		sab.setskill_level(ans);
		assertEquals(ans, sab.getskill_level());
	}
	
	// 	skill_change_send スキル承認状態のgetter/setterテスト
	@Test
	@DisplayName("スキル承認状態のgetter/setterテスト")
	void testGetSetskill_change_send() {
		int ans = 1;
		sab.setskill_change_send(ans);
		assertEquals(ans, sab.getskill_change_send());
	}
	
	@Test
	@DisplayName("送信日付のgetter/setterテスト")
	void testGetSetskill_send_date() {
		String ans = "2023/06/26 9:55:17.746";
		sab.setskill_send_date(ans);
		assertEquals(ans, sab.getskill_send_date());
	}
}
