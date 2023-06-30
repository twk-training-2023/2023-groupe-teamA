package model;

import java.util.ArrayList;
import java.util.List;

public class SkillAppealDTO {
	private List<SkillAppealBean> skillList;

    public SkillAppealDTO() {
        skillList = new ArrayList<SkillAppealBean>();
    }

    public void addSkill(SkillAppealBean sab) {
    	skillList.add(sab);
    }

    public SkillAppealBean getSkill(int i) {
        return skillList.get(i);
    }

//    public List<SkillAppealBean> getAllSkill() {
//        return skillList;
//    }

    public int size() {
        return skillList.size();
    }

}
