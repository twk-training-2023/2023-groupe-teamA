package junitTest.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.CommentAdminDTO;

class CommentAdminDTOTest {

	CommentAdminDTO caDTO ;

	@BeforeEach
	void setup() {
		caDTO = new CommentAdminDTO();
	}

	@Test
	@DisplayName("")
	void testCommentAdminDTO() {
	}
}
