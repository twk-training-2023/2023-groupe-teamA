package model;

import java.util.ArrayList;

public class EmployeeDTO {
	private ArrayList<EmployeeBean> list;

	public EmployeeDTO() {
		list = new ArrayList<EmployeeBean>();
	}

	public void add(EmployeeBean eb) {
		list.add(eb);
	}

	public EmployeeBean get(int i) {
		return list.get(i);
	}

	public int size() {
		return list.size();
	}
}
