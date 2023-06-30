package junitTest.model;

import static org.junit.jupiter.api.Assertions.*;

import model.ProfileBean;
import model.ProfileDTO;
import model.SkillAppealBean;
import model.SkillAppealDTO;

public class ComparisonModel {
//	public void ComparisonEmployeeDTO(EmployeeDTO ansdto, EmployeeDTO edto) {
//		for (int i = 0; i < ansdto.size(); i++) {
//			EmployeeBean ansb = ansdto.get(i);
//			EmployeeBean eb = edto.get(i);
//			assertEquals(ansb.getEmployeeID(), eb.getEmployeeID());
//			assertEquals(ansb.getMailaddress(), eb.getMailaddress());
//			assertEquals(ansb.getName(), eb.getName());
//			assertEquals(ansb.getPassword(), eb.getPassword());
//			assertEquals(ansb.getPermissionLevel(), eb.getPermissionLevel());
//		}
//	}

	public void ComparisonProfileDTO(ProfileDTO ansdto, ProfileDTO pdto) {
		for (int i = 0; i < ansdto.size(); i++) {
			ProfileBean ansb = ansdto.get(i);
			ProfileBean pb = pdto.get(i);
			assertEquals(ansb.getEmployeeID(), pb.getEmployeeID());
			assertEquals(ansb.getMail(), pb.getMail());
			assertEquals(ansb.getPass(), pb.getPass());
			assertEquals(ansb.getName(), pb.getName());
			assertEquals(ansb.getAppeal(), pb.getAppeal());
		}
	}

//	public void ComparisonCommentAdminDTO(CommentAdminDTO ansdto, CommentAdminDTO cdto) {
//		for (int i = 0; i < ansdto.size(); i++) {
//			CommentAdminBean ansb = ansdto.get(i);
//			CommentAdminBean cb = cdto.get(i);
//			assertEquals(ansb.getEmployeeID(), cb.getEmployeeID());
//			assertEquals(ansb.getContent(), cb.getContent());
//			assertEquals(ansb.getChangeDay(), cb.getChangeDay());
//			assertEquals(ansb.getName(), cb.getName());
//			assertEquals(ansb.getTitle(), cb.getTitle());
//			assertEquals(ansb.getCommentNumber(), cb.getCommentNumber());
//		}
//	}
//	
	public void ComparisonSkillAppealDTO(SkillAppealDTO ansdto, SkillAppealDTO sdto) {
		for (int i = 0; i < ansdto.size(); i++) {
			SkillAppealBean ansb = ansdto.getSkill(i);
			SkillAppealBean sb = sdto.getSkill(i);
			assertEquals(ansb.getEmployeeID(), sb.getEmployeeID());
			assertEquals(ansb.getskill_level(), sb.getskill_level());
			assertEquals(ansb.getskill_detail(), sb.getskill_detail());
			assertEquals(ansb.getskill_change_send(), sb.getskill_change_send());
			assertEquals(ansb.getskill_send_date(), sb.getskill_send_date());
		}
	}
}
