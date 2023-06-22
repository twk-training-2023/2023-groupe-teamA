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
	
	public void disconnect() {
	    try {
	      // ⑤DBを切断
	      if (conn != null)
	        conn.close();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }
	
	//未完成
	public CommentAdminDTO selectAllCommentAdmin(CommentAdminBean caBean) { //一覧表示
		Statement stmt = null;
		ResultSet rs = null;
		CommentAdminDTO cadto = new CommentAdminDTO();
		try {
		      connect(4);
		      stmt = conn.createStatement();
		      String sql = "select content_number,id,name,title,posted_date "//
		      		+ " from comment_admin";
		      rs = stmt.executeQuery(sql);
		      while (rs.next()) {
		          
		          //LoginInfo li = new LoginInfo();
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
	
	//未完成
	public CommentAdminDTO insertCommentAdmin(CommentAdminBean caBean) { //入力処理
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CommentAdminDTO cadto = new CommentAdminDTO();
		
		try {
		      connect(5);
		      String sql = "insert into emp.comment_admin (id,name,title,content,posted_date) "//コメント番号、社員番号、社員名、タイトル、コンテンツ、日にち
		      		+ "values ( ?, ?, ?, ?, current_timestamp ) ";
		      
		      //String sql = "insert into emp.comment_admin  "//コメント番号、社員番号、社員名、タイトル、コンテンツ、日にち
			      		//+ "values (nextval('comment_admin_content_number_seq'::regclass),?, ?, ?, ?, current_timestamp ) ";
		      
		          LoginInfo li = new LoginInfo();
		          pstmt = conn.prepareStatement(sql);
		          //pstmt.setInt(1,li.getEmployeeID());
		          //pstmt.setString(2,li.getName());
		              System.out.println("DAO1"+caBean.getTitle());
		          pstmt.setInt(1,3);
		          pstmt.setString(2,"javatestman");
		          pstmt.setString(3,caBean.getTitle());
		          pstmt.setString(4,caBean.getContent());
		              System.out.println(li.getName());
		              System.out.println("DAO2"+caBean.getTitle());
		          pstmt.executeUpdate();//sql実行 シーケンスへのアクセス拒否発生
		          System.out.println("w");
		          //cadto.add(caBean); //あってるか不明
		        
		   
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

