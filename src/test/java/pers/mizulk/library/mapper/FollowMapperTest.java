package pers.mizulk.library.mapper;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import pers.mizulk.library.pojo.Author;
import pers.mizulk.library.pojo.Follow;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@MybatisTest()
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FollowMapperTest {

	@Resource
	private FollowMapper followMapper;

	@Test
	public void testSelectFollowByUserId() {
		Follow follow = new Follow();
		follow.setUserId(1);
		List<Follow> follows = followMapper.selectFollow(follow);
		assertNotEquals(0, follows.size());
		assertEquals(1, follows.getFirst().getUserId());
	}

	@Test
	public void testInsertFollow() {
		Follow follow = new Follow();
		follow.setUserId(1);
		Author author = new Author();
		author.setId(17);
		follow.setAuthor(author);
		int effectedRows = followMapper.insertFollow(follow);
		assertEquals(1, effectedRows);
	}

	@Test
	public void testDeleteFollowByUserIdAndAuthorId() {
		int effectedRows = followMapper.deleteFollows(null, 1, 1);
		assertEquals(1, effectedRows);
	}

	@Test
	public void testDeleteFollowById() {
		int effectedRows = followMapper.deleteFollows(2, null, null);
		assertEquals(1, effectedRows);
	}
}
