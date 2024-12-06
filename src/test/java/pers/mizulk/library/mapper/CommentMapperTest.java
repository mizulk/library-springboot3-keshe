package pers.mizulk.library.mapper;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import pers.mizulk.library.pojo.Comment;
import pers.mizulk.library.pojo.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CommentMapperTest {

	@Resource
	private CommentMapper commentMapper;

	@Test
	public void testSelectCommentByUserId() {
		Comment comment = new Comment();
		User user = new User();
		user.setId(1);
		comment.setUser(user);
		List<Comment> comments = commentMapper.selectComment(comment);
		assertNotEquals(0, comments.size());
	}

	@Test
	public void testSelectCommentByBookId() {
		Comment comment = new Comment();
		comment.setBookId(1);
		List<Comment> comments = commentMapper.selectComment(comment);
		assertNotEquals(0, comments.size());
	}

	@Test
	public void testAddComment() {
		Comment comment = new Comment();
		User user = new User();
		user.setId(1);
		comment.setUser(user);
		comment.setBookId(1);
		comment.setContent("杨华杰拉了");
		int effectedRows = commentMapper.insertComment(comment);
		assertEquals(1, effectedRows);
	}

	@Test
	public void testUpdateComment() {
		Comment comment = new Comment();
		comment.setId(1);
		comment.setLike(100);
		int effectedRows = commentMapper.updateComment(comment);

		Comment selectComment = new Comment();
		selectComment.setId(1);
		List<Comment> comments = commentMapper.selectComment(selectComment);

		assertEquals(1, effectedRows);
		assertEquals(1, comments.size());
		assertEquals(100, comments.getFirst().getLike());
	}

	@Test
	public void testDeleteComment() {
		int effectRows = commentMapper.deleteComments(List.of(1));
		assertEquals(1, effectRows);
	}
}
