package pers.mizulk.library.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import pers.mizulk.library.pojo.User;

import java.util.List;

@Mapper
public interface UserMapper {
	List<User> selectUser(User user);

	@Insert("INSERT INTO users(name, password) " +
			"VALUES(#{name}, #{password})")
	int insertUser(User user);

	int updateUser(User user);

	User selectRegisterUser();
}
