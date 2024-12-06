package pers.mizulk.library.mapper;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import pers.mizulk.library.pojo.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserMapperTest {

	@Resource
	private UserMapper userMapper;

	@Test
	public void testSelectUser() {
		User user = new User();
		user.setId(1);
		user.setPassword("123456");
		List<User> users = userMapper.selectUser(user);
		assertEquals(users.size(), 1);
		assertEquals(users.getFirst().getPassword(), "123456");
	}

	@Test
	public void testSelectUserByName() {
		User user = new User();
		user.setName("杨");
		List<User> users = userMapper.selectUser(user);
		assertNotEquals(0, users.size());
	}

	@Test
	public void testInsertUser() {
		User user = new User();
		user.setPassword("123456");
		user.setName("xu");
		int effectedRows = userMapper.insertUser(user);
		assertEquals(1, effectedRows);
	}


	@Test
	public void testUpdateUser() {
		User user = new User();
		user.setId(1);
		user.setName("杨华杰");
		int effectedRows = userMapper.updateUser(user);
		assertEquals(1, effectedRows);
	}

	@Test
	public void testRegisterUser() {
		User user = new User();
		user.setPassword("123456");
		user.setName("许");
		int effectedRows = userMapper.insertUser(user);
		assertEquals(1, effectedRows);
		User registerUser = userMapper.selectRegisterUser();
		assertNotNull(registerUser);
		assertNotEquals(0, registerUser.getId());
		assertEquals(registerUser.getName(), user.getName());
	}
}
