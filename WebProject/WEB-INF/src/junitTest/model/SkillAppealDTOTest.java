package junitTest.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.SkillAppealBean;
import model.SkillAppealDTO;

class SkillAppealDTOTest {

	SkillAppealDTO sadto;
	
	@BeforeEach
	void setup() {
		sadto = new SkillAppealDTO();
	}
	
	@Test
	@DisplayName("スキルアピールDTOテスト１")
	void test1() {
		int id = 1;
		String skill_name = "田中角栄";
		String detail = "つよい";
		int status = 1;
		SkillAppealBean sab = setSkillAppealBean(id, skill_name, detail, status);
		sadto.addSkill(sab);
		
		assertEquals(sab, sadto.getSkill(0));
		assertEquals(1, sadto.size());
	
	}
	
		
	public SkillAppealBean setSkillAppealBean(int id,String skill_name,String detail,int status) {
		SkillAppealBean sab = new SkillAppealBean();
		sab.setEmployeeID(id);		
		sab.setskill_level(skill_name);
		sab.setskill_detail(detail);
		sab.setskill_change_send(status);
		return sab;
		//Bean作成時のテーブル定義書との相違と
	}

}
