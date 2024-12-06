package pers.mizulk.library.mapper;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import pers.mizulk.library.pojo.Like;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LikeMapperTest {

	@Resource
	private LikeMapper likeMapper;

	@Test
	public void testSelectLikeByUserId() {
		Like like = new Like();
		like.setUserId(1);
		List<Like> likes = likeMapper.selectLike(like);
		assertEquals(1, likes.getFirst().getUserId());
	}

	@Test
	public void testSelectLikeByUserIdAndBookId() {
		Like like = new Like();
		like.setUserId(2);
		like.setBookId(1);
		List<Like> likes = likeMapper.selectLike(like);
		assertEquals(2, likes.getFirst().getUserId());
		assertEquals(1, likes.getFirst().getBookId());
	}

	@Test
	public void testInsertLike() {
		Like like = new Like();
		like.setUserId(1);
		like.setBookId(60);
		int effectedRows = likeMapper.insertLike(like);
		assertEquals(1, effectedRows);
	}

	@Test
	public void testDeleteLike() {
		int effectedRows = likeMapper.deleteLikeById(1);
		assertEquals(1, effectedRows);
	}
}
