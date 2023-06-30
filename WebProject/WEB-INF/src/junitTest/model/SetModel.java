package junitTest.model;

import java.util.List;

import model.CommentAdminBean;
import model.CommentAdminDTO;
import model.EmployeeBean;
import model.EmployeeDTO;
import model.LoginInfo;
import model.ProfileBean;
import model.ProfileDTO;
import model.SkillAppealBean;
import model.SkillAppealDTO;

public class SetModel {
	public LoginInfo setLoginInfo(int id, String name, int level) {
		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setEmployeeID(id);
		loginInfo.setName(name);
		loginInfo.setPermissionLevel(level);
		return loginInfo;
	}
	
	public ProfileDTO setProfileDTO(List<List<String>> parameter) {
		ProfileDTO pdto = new ProfileDTO();
		for (int i = 0; i < parameter.size(); i++) {
			ProfileBean pb = setProfileBean(parameter.get(i));
			pdto.add(pb);
		}
		return pdto;
	}
	
	public ProfileBean setProfileBean(List<String> parameter) {
		ProfileBean pb = new ProfileBean();
		pb.setEmployeeID(Integer.valueOf(parameter.get(0).toString()));
		pb.setMail(parameter.get(1).toString());
		pb.setPass(parameter.get(2).toString());
		pb.setName(parameter.get(3).toString());
		pb.setAppeal(parameter.get(4).toString());
		return pb;
	}

	public EmployeeDTO setEmployeeDTO(List<List<String>> parameter) {
		EmployeeDTO edto = new EmployeeDTO();
		for (int i = 0; i < parameter.size(); i++) {
			EmployeeBean eb = setEmployeeBean(parameter.get(i));
			edto.add(eb);
		}
		return edto;
	}
	
	public EmployeeBean setEmployeeBean(List<String> parameter) {
		EmployeeBean eb = new EmployeeBean();
		
		return eb;
	}
	
	public CommentAdminDTO setCommentAdminDTO(List<List<String>> parameter) {
		CommentAdminDTO cdto = new CommentAdminDTO();
		for (int i = 0; i < parameter.size(); i++) {
			CommentAdminBean cb = setCommentAdminBean(parameter.get(i));
			cdto.add(cb);
		}
		return cdto;
	}
	
	public CommentAdminBean setCommentAdminBean(List<String> parameter) {
		CommentAdminBean cb = new CommentAdminBean();
		
		return cb;
	}
	
	public SkillAppealDTO setSkillAppealDTO(List<List<String>> parameter) {
		SkillAppealDTO sdto = new SkillAppealDTO();
		for (int i = 0; i < parameter.size(); i++) {
			SkillAppealBean sb = setSkillAppealBean(parameter.get(i));
			sdto.addSkill(sb);
		}
		return sdto;
	}

	public SkillAppealBean setSkillAppealBean(List<String> parameter) {
		SkillAppealBean sb = new SkillAppealBean();
		
		return sb;
	}
}

