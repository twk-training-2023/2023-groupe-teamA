package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CommentAdminDAO {
	private static final String DRIVE = "org.postgresql.Driver";
	
	AdminConstList acl = new AdminConstList();
	GeneralConstList gcl = new GeneralConstList();
	private final String ADURL = acl.getUrl();
	private final String ADUSER = acl.getUser();
	private final String ADPASS = acl.getPass();
	private final String GEURL = gcl.getUrl();
	private final String GEUSER = gcl.getUser();
	private final String GEPASS = gcl.getPass(); 

	private Connection conn = null;


	//DB接続メソッド
	public void connect(int permissionLevel) {
		try {
			Class.forName(DRIVE);
			if (permissionLevel > 3) {
				conn = DriverManager.getConnection(ADURL, ADUSER, ADPASS);
			}else{
				conn = DriverManager.getConnection(GEURL, GEUSER, GEPASS);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	//DB切断メソッド
	public void disconnect() {
	    try {
	      if (conn != null)
	        conn.close();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }
	
	//管理者向け連絡一覧表示メソッド
	public CommentAdminDTO selectAllCommentAdmin(CommentAdminBean caBean) { 
		Statement stmt = null;
		ResultSet rs = null;
		CommentAdminDTO cadto = new CommentAdminDTO();
		try {
		      connect(4);
		      stmt = conn.createStatement();
		      String sql = "select content_number,id,name,title,posted_date "
		      		+ " from comment_admin";
		      rs = stmt.executeQuery(sql);
		      while (rs.next()) {
		          caBean.setCommentNumber(rs.getInt(1));
		          caBean.setEmployeeID(rs.getInt(2));
		          caBean.setName(rs.getString(3));
		          caBean.setTitle(rs.getString(4));
		          caBean.setChangeDay(rs.getString(5));
		      
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
	
	//管理者向け連絡入力処理メソッド
	public CommentAdminDTO insertCommentAdmin(CommentAdminBean caBean, LoginInfo loginInfo) { //入力処理
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CommentAdminDTO cadto = new CommentAdminDTO();
		
		try {
		      connect(5);
		      String sql = "insert into emp.comment_admin (id,name,title,content,posted_date) "//コメント番号、社員番号、社員名、タイトル、コンテンツ、日にち
		      		+ "values ( ?, ?, ?, ?, current_timestamp ) ";
		      
		          pstmt = conn.prepareStatement(sql);
		          pstmt.setInt(1,loginInfo.getEmployeeID());
		          pstmt.setString(2,loginInfo.getName());
		          pstmt.setString(3,caBean.getTitle());
		          pstmt.setString(4,caBean.getContent());
		          pstmt.executeUpdate();//sql実行
		          //戻り値で判定未実装
		        
		   
		}catch (Exception e) {
		      e.printStackTrace();
	    } finally {
	      try {
	        if (rs != null)
	          rs.close();
	        if (pstmt != null)
	          pstmt.close();
	      } catch (Exception e) {
	        e.printStackTrace();
	      }
	    }
	    disconnect();
	    return cadto;
	}
	
	//未完成
	public CommentAdminDTO selectDetailCommentAdmin(CommentAdminBean caBean) { //詳細表示
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CommentAdminDTO cadto = new CommentAdminDTO();

		try {
		      connect(4);
		      String sql = "select id,name,title,content,posted_date from emp.admin_comment "
		      		+ " where content_number = ? ";
		          
		          pstmt = conn.prepareStatement(sql);
		          pstmt.setInt(1,caBean.getCommentNumber());
		          
		          pstmt.executeQuery(sql);
		          
		          cadto.add(caBean); 
		        
		   
		}catch (Exception e) {
		      e.printStackTrace();
	    } finally {
	      try {
	        if (rs != null)
	          rs.close();
	        if (pstmt != null)
	          pstmt.close();
	      } catch (Exception e) {
	        e.printStackTrace();
	      }
	    }
	    disconnect();
	    return cadto;
	}
	
}

