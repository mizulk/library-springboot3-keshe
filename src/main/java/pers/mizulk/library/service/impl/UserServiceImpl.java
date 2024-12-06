package pers.mizulk.library.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pers.mizulk.library.mapper.UserMapper;
import pers.mizulk.library.pojo.User;
import pers.mizulk.library.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	private final UserMapper userMapper;

	public UserServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public User login(Integer id, String password) {
		User user = new User();
		user.setId(id);
		user.setPassword(password);
		List<User> users = userMapper.selectUser(user);
		if (users.isEmpty()) return null;
		return users.getFirst();
	}

	@Override
	public List<User> getUsers(String keyword, Integer limit) {
		User user = new User();
		user.setName(keyword);
		return userMapper.selectUser(user);
	}

	@Override
	public User getUserById(Integer id) {
		User user = new User();
		user.setId(id);
		List<User> users = userMapper.selectUser(user);
		if (users.isEmpty()) return null;
		return users.getFirst();
	}

	@Override
	public boolean updateUser(User user) {
		return userMapper.updateUser(user) > 0;
	}

	@Override
	public User registerUser(User user) {
		if (userMapper.insertUser(user) < 0) return null;
		return userMapper.selectRegisterUser();
	}
}
