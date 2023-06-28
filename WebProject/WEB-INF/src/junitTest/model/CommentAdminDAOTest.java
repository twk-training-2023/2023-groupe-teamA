package junitTest.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.CommentAdminBean;
import model.CommentAdminDAO;
import model.CommentAdminDTO;
import model.LoginInfo;

class CommentAdminDAOTest {
	
	CommentAdminDAO caDAO ;
	
	
	@BeforeEach
	void setup() {
		caDAO = new CommentAdminDAO();

	}
	

	@Test
	@DisplayName("管理者向け連絡一覧取得処理のテスト(select)")
	void testselectAllCommentAdmin() {
		CommentAdminDTO caDTO =caDAO.selectAllCommentAdmin();
		
		int ans = 28;
		//CommentAdminBean caBean = new CommentAdminBean();
		caDAO.selectAllCommentAdmin();
		assertEquals(ans, caDTO.size());
	}
	
	@Test
	@DisplayName("管理者向け連絡入力処理のテスト(insert)")
	void testsinsertCommentAdmin() {
		CommentAdminBean caBean =new CommentAdminBean();
		LoginInfo li = new LoginInfo();
		li.setName("なまえ");
		li.setEmployeeID(1);
		caBean.setContent("本文");
		caBean.setTitle("タイトル");
		CommentAdminDTO caDTO = caDAO.insertCommentAdmin(caBean,li);
		
		int ans = 1;
		assertEquals(ans,caDTO);
	}

}
