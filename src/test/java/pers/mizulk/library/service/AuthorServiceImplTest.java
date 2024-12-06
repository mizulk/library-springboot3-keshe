package pers.mizulk.library.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pers.mizulk.library.mapper.AuthorMapper;
import pers.mizulk.library.pojo.Author;
import pers.mizulk.library.service.impl.AuthorServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith({SpringExtension.class})
class AuthorServiceImplTest {

	@Mock
	private AuthorMapper authorMapper;

	@InjectMocks
	private AuthorServiceImpl authorService;

	@Test
	void getAuthors() {
		when(authorMapper.selectAuthor(List.of(1), null, null))
				.thenReturn(List.of(new Author()));
		List<Author> authors = authorService.getAuthors(null, null, List.of(1));

		assertEquals(1, authors.size());
	}

	@Test
	void getAuthorById() {
	}
}