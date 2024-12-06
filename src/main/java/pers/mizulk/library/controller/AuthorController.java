package pers.mizulk.library.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.mizulk.library.pojo.Author;
import pers.mizulk.library.service.AuthorService;
import pers.mizulk.library.util.Result;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
	private final AuthorService authorService;

	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}

	@GetMapping
	public Result<List<Author>> getAuthors(
			@RequestParam(required = false) Integer limit,
			@RequestParam(required = false) String keyword,
			@RequestParam(required = false) List<Integer> ids
	) {
		List<Author> authors = authorService.getAuthors(limit, keyword, ids);
		return Result.success(authors);
	}

	@GetMapping("/{id}")
	public Result<Author> getAuthorById(@PathVariable Integer id) {
		Author author = authorService.getAuthorById(id);
		if (author == null) return Result.error(404, "没有找到该作者");
		return Result.success(author);
	}

}
