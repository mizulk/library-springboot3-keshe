package pers.mizulk.library.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.mizulk.library.pojo.Book;
import pers.mizulk.library.service.BookService;
import pers.mizulk.library.util.Result;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping
	public Result<List<Book>> getBooks(
			@RequestParam(required = false) Integer limit,
			@RequestParam(required = false) String type,
			@RequestParam(required = false) String author,
			@RequestParam(required = false) String keyword,
			@RequestParam(required = false) List<Integer> ids
	) {
		return Result.success(bookService.getBooks(limit, type, author, keyword, ids));
	}

	@GetMapping("/{id}")
	public Result<Book> getBookById(@PathVariable Integer id) {
		Book book = bookService.getBookById(id);
		return Result.success(book);
	}

	@PutMapping
	public Result<Book> updateBookById(@RequestBody Book book) {
		if (bookService.updateBook(book)) return Result.success();
		return Result.error(500);
	}

}
