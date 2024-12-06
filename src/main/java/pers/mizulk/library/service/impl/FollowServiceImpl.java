package pers.mizulk.library.service.impl;

import org.springframework.stereotype.Service;
import pers.mizulk.library.mapper.FollowMapper;
import pers.mizulk.library.pojo.Author;
import pers.mizulk.library.pojo.Follow;
import pers.mizulk.library.service.FollowService;

import java.util.List;

@Service
public class FollowServiceImpl implements FollowService {

	private final FollowMapper followMapper;

	public FollowServiceImpl(FollowMapper followMapper) {
		this.followMapper = followMapper;
	}

	@Override
	public boolean addFollow(Follow follow) {
		return followMapper.insertFollow(follow) > 0;
	}

	@Override
	public boolean deleteFollow(Integer id, Integer userId, Integer authorId) {
		return followMapper.deleteFollows(id, userId, authorId) > 0;
	}

	@Override
	public List<Follow> getFollows(Integer userId) {
		Follow follow = new Follow();
		follow.setUserId(userId);
		return followMapper.selectFollow(follow);
	}
}
