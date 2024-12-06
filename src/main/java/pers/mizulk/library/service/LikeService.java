package pers.mizulk.library.service;

import pers.mizulk.library.pojo.Like;

import java.util.List;

public interface LikeService {

	List<Like> getLikes(Integer userId, Integer bookId);

	Like getLikesById(Integer id);

	boolean addLike(Like like);

	boolean deleteLike(Integer id);
}
