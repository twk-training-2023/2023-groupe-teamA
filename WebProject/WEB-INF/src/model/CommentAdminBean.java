package model;

import java.io.Serializable;

public class CommentAdminBean implements Serializable {
	public int employeeID;
	public String content;
	public String changeDay;
	public String name;
	public String title;
	public int commentNumber;
	
	public CommentAdminBean() {}
	public CommentAdminBean(int commentNumber,int employeeID,String name,String title,String changeDay ) {
		this.commentNumber=commentNumber;
		this.employeeID=employeeID;
		this.name=name;
		this.title=title;
		this.changeDay=changeDay;
		
	}
	

	public void setEmployeeID(Integer employeeID){
		this.employeeID = employeeID;
	}
	
	public int getEmployeeID(){
		return employeeID;
	}
	
	
	public void setContent(String content){
		this.content = content;
	}
	
	public String getContent(){
		return content;
	}
	
	public void setChangeDay(String changeDay){
		this.changeDay = changeDay;
	}
	
	public String getChangeDay(){
		return changeDay;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public String getTitle(){
		return title;
	}
	
	public void setCommentNumber(int commentNumber){
		this.commentNumber = commentNumber;
	}
	
	public int getCommentNumber() {
		return commentNumber;
	}
	
}
