package pers.mizulk.library.mapper;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import pers.mizulk.library.pojo.Author;
import pers.mizulk.library.pojo.Book;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookMapperTest {

	@Resource
	private BookMapper bookMapper;

	@Test
	public void testSelectBookByIds() {
		List<Book> books = bookMapper.selectBooks(null, List.of(1, 2, 3), null);
		assertEquals(3, books.size());
	}

	@Test
	public void testSelectBooksByType() {
		Book book = new Book();
		book.setType("文学类");
		List<Book> books = bookMapper.selectBooks(book, null, null);
		assertNotEquals(0, books.size());
	}

	@Test
	public void testSelectBooksByName() {
		Book book = new Book();
		book.setName("杨华杰自传");
		List<Book> books = bookMapper.selectBooks(book, null, null);
		assertNotEquals(0, books.size());
		assertEquals(book.getName(), books.getFirst().getName());
	}

	@Test
	public void testSelectBooksByAuthorName() {
		Book book = new Book();
		Author author = new Author();
		author.setName("杨华杰");
		book.setAuthor(author);
		List<Book> books = bookMapper.selectBooks(book, null, null);
		assertNotEquals(0, books.size());
		assertEquals(author.getName(), books.getFirst().getAuthor().getName());
	}

	@Test
	public void testSelectBooksLimit() {
		List<Book> books = bookMapper.selectBooks(null, null, 6);
		assertEquals(6, books.size());
	}

	@Test
	public void testSelectBookById() {
		Book book = bookMapper.selectBookById(1);
		assertNotNull(book);
		assertEquals(1, book.getId());
	}

	@Test
	public void testUpdateBook() {
		Book book = new Book();
		book.setId(13);
		book.setName("骆驼杰子");
		int effectRow = bookMapper.updateBook(book);
		Book updatedBook = bookMapper.selectBookById(13);
		assertEquals(1, effectRow);
		assertEquals(13, updatedBook.getId());
		assertEquals(book.getName(), updatedBook.getName());
	}
}
