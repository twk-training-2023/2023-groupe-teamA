package junitTest.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.CommentAdminBean;


class CommentAdminBeanTest {
	
	CommentAdminBean caBean ;

	@BeforeEach
	void setup() {
		caBean = new CommentAdminBean();
	}
	
	
	@Test
	@DisplayName("社員番号のgetter/setterテスト")
	void testGetEmployeeID() {
		int ans = 5;
		caBean.setEmployeeID(ans);
		assertEquals(ans, caBean.getEmployeeID());
	}
	
	@Test
	@DisplayName("管理者向け連絡内容の更新日時のgetter/setterテスト")
	void testChangeDay() {
		String ans = "2023-06-28 13:00:00.000000";
		caBean.setChangeDay(ans);
		assertEquals(ans, caBean.getChangeDay());
	}
	
	@Test
	@DisplayName("管理者向け連絡の内容のgetter/setterテスト")
	void testGetContent() {
		String ans = "本文テスト";
		caBean.setContent(ans);
		assertEquals(ans, caBean.getContent());
	}
	
	@Test
	@DisplayName("管理者向け連絡内容の投稿者名のgetter/setterテスト")
	void testName() {
		String ans = "渡辺颯汰";
		caBean.setName(ans);
		assertEquals(ans, caBean.getName());
	}
	
	@Test
	@DisplayName("管理者向け連絡内容の件名のgetter/setterテスト")
	void testTitle() {
		String ans = "件名テスト";
		caBean.setTitle(ans);
		assertEquals(ans, caBean.getTitle());
	}

	@Test
	@DisplayName("管理者向け連絡内容の連絡番号のgetter/setterテスト")
	void testCommentNumber() {
		int ans = 20;
		caBean.setCommentNumber(ans);
		assertEquals(ans, caBean.getCommentNumber());
	}
}
