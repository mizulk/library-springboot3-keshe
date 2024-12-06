package pers.mizulk.library.controller;

import org.springframework.web.bind.annotation.*;
import pers.mizulk.library.pojo.User;
import pers.mizulk.library.service.UserService;
import pers.mizulk.library.util.JwtUtil;
import pers.mizulk.library.util.Result;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public Result<List<User>> getUsers(@RequestParam(required = false) String keyword) {
		return Result.success(userService.getUsers(keyword, null));
	}

	@GetMapping("/{id}")
	public Result<User> getUser(@PathVariable Integer id) {
		return Result.success(userService.getUserById(id));
	}

	@PostMapping("/login")
	public Result<String> login(@RequestBody User user) {
		User login = userService.login(user.getId(), user.getPassword());
		if (login == null) return Result.error(400, "账号或密码错误");
		Map<String, Object> map = new HashMap<>();
		map.put("id", login.getId());
		map.put("name", URLEncoder.encode(login.getName(), StandardCharsets.UTF_8));
		map.put("sign", URLEncoder.encode(login.getSign(), StandardCharsets.UTF_8));
		map.put("img", login.getImg());
		String jwt = JwtUtil.createJwt(2 * JwtUtil.HOUR, map);
//		String jwt = JwtUtil.createJwt(2 * JwtUtil.MINUTE, map);
		return Result.success(jwt);
	}

	@PostMapping("/register")
	public Result<User> register(@RequestBody User user) {
		User user1 = userService.registerUser(user);
		if (user1 != null) return Result.success(user1);
		return Result.error(500);
	}

	@PutMapping
	public Result<User> updateUser(@RequestBody User user) {
		if (userService.updateUser(user)) return Result.success();
		return Result.error(500);
	}


}
