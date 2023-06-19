package model;

import java.util.ArrayList;
import java.util.List;

public class SkillAppealDTO {
	private List<SkillAppealBean> skillList;

    public SkillAppealDTO() {
        skillList = new ArrayList<SkillAppealBean>();
    }

    public void addSkill(SkillAppealBean poke) {
    	skillList.add(poke);
    }

    public SkillAppealBean getSkill(int i) {
        return skillList.get(i);
    }

    public List<SkillAppealBean> getAllSkill() {
        return skillList;
    }

    public int size() {
        return skillList.size();
    }

}