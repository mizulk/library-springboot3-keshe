package pers.mizulk.library.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import pers.mizulk.library.pojo.Comment;

import java.util.List;

@Mapper
public interface CommentMapper {
	List<Comment> selectComment(Comment comment);

	@Insert("INSERT INTO comments(bookId, userId, content, createTime, updateTime) " +
			"VALUES (#{bookId}, #{user.id}, #{content}, NOW(), NOW())")
	int insertComment(Comment comment);

	int updateComment(Comment comment);

	int deleteComments(List<Integer> ids);
}
