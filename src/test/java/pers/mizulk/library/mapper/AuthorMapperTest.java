package pers.mizulk.library.mapper;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import pers.mizulk.library.pojo.Author;

import java.util.List;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AuthorMapperTest {

	@Resource
	private AuthorMapper authorMapper;

	@Test
	void testSearchByIds() {
		List<Author> authors = authorMapper.selectAuthor(List.of(1, 2, 3), null, null);
		Assertions.assertEquals(3, authors.size());
	}

	@Test
	void testSearchByName() {
		List<Author> authors = authorMapper.selectAuthor(null, "老", null);
		Assertions.assertEquals(1, authors.size());
		Assertions.assertEquals("老舍", authors.getFirst().getName());
	}

	@Test
	void testLimit() {
		List<Author> authors = authorMapper.selectAuthor(null, null, 6);
		Assertions.assertEquals(6, authors.size());
	}

	@Test
	void testSelectById() {
		Author author = authorMapper.selectAuthorById(1);
		Assertions.assertNotNull(author);
		Assertions.assertEquals("老舍", author.getName());
	}
}
