package pers.mizulk.library.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import pers.mizulk.library.pojo.Follow;

import java.util.List;

@Mapper
public interface FollowMapper {
	List<Follow> selectFollow(Follow follow);

	@Insert("INSERT INTO follow(userId, authorId) " +
			"VALUES(#{userId}, #{author.id})")
	int insertFollow(Follow follow);

	int deleteFollows(Integer id, Integer userId, Integer authorId);

}
