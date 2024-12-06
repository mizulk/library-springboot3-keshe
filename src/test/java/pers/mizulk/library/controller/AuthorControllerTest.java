package pers.mizulk.library.controller;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import pers.mizulk.library.pojo.Author;
import pers.mizulk.library.service.AuthorService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthorController.class)
class AuthorControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AuthorService authorService;

	@Test
	public void getAuthorsByLimit() throws Exception {
		int limit = 2;
		List<Author> authors = new ArrayList<>();
		Author author = new Author();
		author.setId(1);
		author.setName("老舍");
		authors.add(author);
		Author author2 = new Author();
		author2.setId(2);
		author2.setName("鲁迅");
		BDDMockito.given(authorService.getAuthors(limit, null, null))
				.willReturn(authors);
		mockMvc.perform(get("/authors?limit=" + limit))
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void getAuthorsByKeyword() {

	}

	@Test
	public void getAuthorsByIds() {

	}

	@Test
	public void getAuthorById() {
	}
}