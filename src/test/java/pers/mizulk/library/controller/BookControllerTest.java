package pers.mizulk.library.controller;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import pers.mizulk.library.pojo.Book;
import pers.mizulk.library.service.BookService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
class BookControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookService bookService;

	@Test
	void getBooks() {

	}

	@Test
	void getBookById() throws Exception {
		Book book = new Book();
		book.setId(1);

		BDDMockito.given(bookService.getBookById(1))
				.willReturn(book);

		MvcResult mvcResult = mockMvc.perform(get("/books/1"))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	void updateBookById() {
	}
}