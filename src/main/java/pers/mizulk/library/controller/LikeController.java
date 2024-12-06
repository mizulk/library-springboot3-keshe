package pers.mizulk.library.controller;

import org.springframework.web.bind.annotation.*;
import pers.mizulk.library.pojo.Like;
import pers.mizulk.library.service.LikeService;
import pers.mizulk.library.util.Result;

import java.util.List;

@RestController
@RequestMapping("/likes")
public class LikeController {
	private final LikeService likeService;

	public LikeController(LikeService likeService) {
		this.likeService = likeService;
	}

	@GetMapping
	public Result<List<Like>> getLikes(
			@RequestParam(required = false) Integer userId,
			@RequestParam(required = false) Integer bookId
	) {
		List<Like> likes = likeService.getLikes(userId, bookId);
		return Result.success(likes);
	}

	@GetMapping("/{id}")
	public Result<Like> getLike(@PathVariable Integer id) {
		Like like = likeService.getLikesById(id);
		if (like == null) return Result.error(500);
		return Result.success(like);
	}

	@PostMapping
	public Result<Like> addLike(@RequestBody Like like) {
		if (likeService.addLike(like)) return Result.success();
		return Result.error(500);
	}

	@DeleteMapping("/{id}")
	public Result<Like> deleteLike(@PathVariable Integer id) {
		if (likeService.deleteLike(id)) return Result.success();
		return Result.error(500);
	}

}
