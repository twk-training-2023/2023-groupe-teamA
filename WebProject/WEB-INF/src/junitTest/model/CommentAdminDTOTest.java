package junitTest.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.CommentAdminBean;
import model.CommentAdminDTO;

class CommentAdminDTOTest {

	CommentAdminDTO caDTO ;

	@BeforeEach
	void setup() {
		caDTO = new CommentAdminDTO();
	}

	@Test
	@DisplayName("管理者向け連絡が1つの時のテスト")
	void test1() {
		int EmployeeID = 1;
		String content = "連絡件名";
		String changeDay = "2023/06/28";
		String name = "山田太郎";
		String title ="タイトルテスト";
		int commentNumber = 5;
		CommentAdminBean caBean = new CommentAdminBean();
		caBean.setEmployeeID(EmployeeID);
		caBean.setContent(content);
		caBean.setChangeDay(changeDay);
		caBean.setName(name);
		caBean.setTitle(title);
		caBean.setCommentNumber(commentNumber);
		
		
		//CommentAdminBean caBean = setCommentAdminBean(EmployeeID, content, changeDay, name, title,commentNumber);
		
		caDTO.add(caBean);
		
		assertEquals(caBean, caDTO.get(0));
		assertEquals(1, caDTO.size());
	}
	
	@Test
	@DisplayName("管理者向け連絡が複数の時のテスト")
	void test2() {
		int EmployeeID = 1;
		String content = "連絡件名";
		String changeDay = "2023/06/28";
		String name = "山田太郎";
		String title ="タイトルテスト";
		int commentNumber = 5;
		
		CommentAdminBean caBean = new CommentAdminBean();
		caBean.setEmployeeID(EmployeeID);
		caBean.setContent(content);
		caBean.setChangeDay(changeDay);
		caBean.setName(name);
		caBean.setTitle(title);
		caBean.setCommentNumber(commentNumber);
		
		 EmployeeID = 2;
		 content = "連絡件名2";
		 changeDay = "2023/06/29";
		 name = "山田太郎２";
		 title ="タイトルテスト2";
		 commentNumber = 5;
		 
		 CommentAdminBean caBean2 = new CommentAdminBean();
		 
		 caBean.setEmployeeID(EmployeeID);
			caBean2.setContent(content);
			caBean2.setChangeDay(changeDay);
			caBean2.setName(name);
			caBean2.setTitle(title);
			caBean2.setCommentNumber(commentNumber); 
		
		
		caDTO.add(caBean);
		caDTO.add(caBean2);
		assertEquals(caBean, caDTO.get(0));
		assertEquals(caBean2, caDTO.get(1));
		assertEquals(2, caDTO.size());
	}
	
}
