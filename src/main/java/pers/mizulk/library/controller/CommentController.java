package pers.mizulk.library.controller;

import org.springframework.web.bind.annotation.*;
import pers.mizulk.library.pojo.Cart;
import pers.mizulk.library.pojo.Comment;
import pers.mizulk.library.service.CommentService;
import pers.mizulk.library.util.Result;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
	private final CommentService commentService;

	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}

	@GetMapping
	public Result<List<Comment>> getComments(
			@RequestParam(required = false) Integer userId,
			@RequestParam(required = false) Integer bookId
	) {
		List<Comment> comments = commentService.getComments(userId, bookId);
		return Result.success(comments);
	}

	@PostMapping
	public Result<Comment> addComment(@RequestBody Comment comment) {
		if (commentService.addComment(comment)) return Result.success();
		return Result.error(500);
	}

	@PutMapping
	public Result<Cart> updateComment(@RequestBody Comment comment) {
		if (commentService.updateComment(comment)) return Result.success();
		return Result.error(500);
	}

	@DeleteMapping("/{ids}")
	public Result<Cart> deleteComment(@PathVariable List<Integer> ids) {
		if (commentService.deleteComments(ids)) return Result.success();
		return Result.error(500);
	}
}
