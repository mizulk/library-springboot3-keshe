package pers.mizulk.library.service.impl;

import org.springframework.stereotype.Service;
import pers.mizulk.library.mapper.BookMapper;
import pers.mizulk.library.pojo.Author;
import pers.mizulk.library.pojo.Book;
import pers.mizulk.library.service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

	private final BookMapper bookMapper;

	public BookServiceImpl(BookMapper bookMapper) {
		this.bookMapper = bookMapper;
	}

	@Override
	public Book getBookById(Integer id) {
		return bookMapper.selectBookById(id);
	}

	@Override
	public List<Book> getBooks(Integer limit, String type, String author, String keyword, List<Integer> ids) {
		Book book = new Book();
		book.setType(type);
		Author authorObj = new Author();
		authorObj.setName(author);
		book.setAuthor(authorObj);
		book.setName(keyword);
		return bookMapper.selectBooks(book, ids, limit);
	}


	@Override
	public boolean updateBook(Book book) {
		return bookMapper.updateBook(book) > 0;
	}
}
