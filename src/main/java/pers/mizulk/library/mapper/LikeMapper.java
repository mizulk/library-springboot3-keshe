package pers.mizulk.library.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import pers.mizulk.library.pojo.Like;

import java.util.List;

@Mapper
public interface LikeMapper {
	List<Like> selectLike(Like like);

	@Insert("INSERT INTO likes(userId, bookId) " +
			"VALUES(#{userId}, #{bookId})")
	int insertLike(Like like);

	@Delete("DELETE FROM likes WHERE id = #{id}")
	int deleteLikeById(Integer id);

}
