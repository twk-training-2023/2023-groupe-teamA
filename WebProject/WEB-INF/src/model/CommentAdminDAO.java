package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CommentAdminDAO {
	private final String URL = null;
	  private final String USER = null;
	  private final String PASS = null;
	  private Connection conn = null;
	
	
	
	public void connect() {
		try {
		      // ①DBに接続
		      conn = DriverManager.getConnection(URL, USER, PASS);
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
	}
	
	public void disconnect() {
	    try {
	      // ⑤DBを切断
	      if (conn != null)
	        conn.close();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }
	
	
	public CommentAdminDTO selectAllCommentAdmin() {
		Statement stmt = null;
		ResultSet rs = null;
		CommentAdminDTO cadto = new CommentAdminDTO();
		try {
		      connect();
		      stmt = conn.createStatement();
		      String sql = "select employee_number,comment_admin_change_day,comment_title,comment_number"
		      		+ " from comment_admin where comment_admin_check = false";
		      rs = stmt.executeQuery(sql);
		      while (rs.next()) {
		          CommentAdminBean caBean = new CommentAdminBean();
		          caBean.setEmployeeID(rs.getInt("employeeID"));
		          caBean.setChangeDay(rs.getString("ChangeDay"));
		          caBean.setTitle(rs.getString("titile"));
		          caBean.setCommentNumber(rs.getInt("commentNumber"));
		      
		          cadto.add(caBean); 
		        }
		   
		}catch (Exception e) {
		      e.printStackTrace();
	    } finally {
	      try {
	        if (rs != null)
	          rs.close();
	        if (stmt != null)
	          stmt.close();
	      } catch (Exception e) {
	        e.printStackTrace();
	      }
	    }
	    disconnect();
	    return cadto;
	  }
	
	public CommentAdminDTO insertCommentAdmin() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CommentAdminDTO cadto = new CommentAdminDTO();
		
		
	}
	
	
	
	
}
