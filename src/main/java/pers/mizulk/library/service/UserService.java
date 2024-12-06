package pers.mizulk.library.service;

import org.springframework.web.multipart.MultipartFile;
import pers.mizulk.library.pojo.User;

import java.util.List;

public interface UserService {

	User login(Integer id, String password);

	List<User> getUsers(String keyword, Integer limit);

	User getUserById(Integer id);

	boolean updateUser(User user);

	User registerUser(User user);

}
