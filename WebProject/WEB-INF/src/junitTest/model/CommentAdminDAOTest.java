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
	@DisplayName("permissionLevelが3以下の場合")
	void testpermissionLevel() {
		caDAO.connect(1);
		caDAO.disconnect();
	}
	
	
	
	@Test
	@DisplayName("管理者向け連絡一覧取得処理のテスト(select)")
	void testselectAllCommentAdmin() {
		CommentAdminDTO caDTO =caDAO.selectAllCommentAdmin();
		
		caDTO = caDAO.selectAllCommentAdmin();

			//最初の行のデータ比較
			CommentAdminBean ansb = caDTO.get(0);
			assertEquals(ansb.getEmployeeID(), 5);
			assertEquals(ansb.getContent(), "本文ワン");
			assertEquals(ansb.getChangeDay(),"2023-06-22 14:57:32.083448");
			assertEquals(ansb.getName(), "渡辺颯汰");
			assertEquals(ansb.getTitle() ,"テスト１");
			assertEquals(ansb.getCommentNumber() ,19);
			//assertEquals(31,caDTO.size()); 行数で判断したいが、インサートテストで毎回増えていく
			//最後も検証
			
			//最終行のデータ比較
			int i = (caDTO.size() - 1);
			CommentAdminBean ansb2 = caDTO.get(i);
			assertEquals(ansb2.getEmployeeID(), 1);
			assertEquals(ansb2.getContent(), "本文");
			assertEquals(ansb2.getName(), "なまえ");
			assertEquals(ansb2.getTitle() ,"タイトル");
	}
	
	//実行時insertでDBエラー発生　カバレッジは100%
	@Test
	@DisplayName("管理者向け連絡入力処理のテスト(insert)")
	void testsinsertCommentAdmin()  {
		int ans = 1;
		CommentAdminBean caBean =new CommentAdminBean();
		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setPermissionLevel(5);
		loginInfo.setName("なまえ");
		loginInfo.setEmployeeID(1);
		
		int result = caDAO.insertCommentAdmin(caBean,loginInfo);
		
		assertEquals(ans,result);
	}

}
