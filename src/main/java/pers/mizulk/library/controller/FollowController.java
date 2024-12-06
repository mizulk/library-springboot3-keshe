package pers.mizulk.library.controller;

import org.springframework.web.bind.annotation.*;
import pers.mizulk.library.pojo.Follow;
import pers.mizulk.library.service.FollowService;
import pers.mizulk.library.util.Result;

import java.util.List;

@RestController
@RequestMapping("/follows")
public class FollowController {
	private final FollowService followService;

	public FollowController(FollowService followService) {
		this.followService = followService;
	}

	@GetMapping
	public Result<List<Follow>> getFollows(@RequestParam(required = false) Integer userId) {
		List<Follow> follows = followService.getFollows(userId);
		return Result.success(follows);
	}

	@DeleteMapping("/{id}")
	public Result<Follow> deleteFollow(@PathVariable Integer id) {
		if (followService.deleteFollow(id, null, null)) return Result.success();
		return Result.error(500);
	}

	@DeleteMapping
	public Result<Follow> deleteFollow(
			@RequestParam(required = false) Integer userId,
			@RequestParam(required = false) Integer authorId
	) {
		if (followService.deleteFollow(null, userId, authorId)) return Result.success();
		return Result.error(500);
	}

	@PostMapping
	public Result<Follow> addFollow(@RequestBody Follow follow) {
		if (followService.addFollow(follow)) return Result.success();
		return Result.error(500);
	}
}
