package model;

import java.io.Serializable;
import java.util.ArrayList;

public class CommentAdminDTO implements Serializable {
	private ArrayList<CommentAdminBean> list;

	public CommentAdminDTO() {
		list = new ArrayList<CommentAdminBean>();
	}

	public void add(CommentAdminBean CmntAdmnBean) {
		list.add(CmntAdmnBean);
	}
	
	public CommentAdminBean get(int i) {
		return list.get(i);
	}
	
	public int size() {
		return list.size();
	}
	
}
