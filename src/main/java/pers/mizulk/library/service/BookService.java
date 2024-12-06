package pers.mizulk.library.service;

import pers.mizulk.library.pojo.Book;

import java.util.List;

public interface BookService {
	Book getBookById(Integer id);

	List<Book> getBooks(Integer limit, String type, String author, String keyword, List<Integer> ids);

	boolean updateBook(Book book);
}
