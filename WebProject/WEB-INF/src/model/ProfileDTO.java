package model;

import java.io.Serializable;
import java.util.ArrayList;

public class ProfileDTO implements Serializable {
	private ArrayList<ProfileBean> list;

	public ProfileDTO() {
		list = new ArrayList<ProfileBean>();
	}

	public void add(ProfileBean Probn) {
		list.add(Probn);
	}
	
	public ProfileBean get(int i) {
		return list.get(i);
	}
	
	public int size() {
		return list.size();
	}
	
}
