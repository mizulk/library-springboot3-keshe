package pers.mizulk.library.service;

import pers.mizulk.library.pojo.Follow;

import java.util.List;

public interface FollowService {
	boolean addFollow(Follow follow);

	boolean deleteFollow(Integer id, Integer userId, Integer authorId);

	List<Follow> getFollows(Integer userId);
}
