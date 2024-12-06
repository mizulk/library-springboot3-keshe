package pers.mizulk.library.service.impl;

import org.springframework.stereotype.Service;
import pers.mizulk.library.mapper.LikeMapper;
import pers.mizulk.library.pojo.Like;
import pers.mizulk.library.service.LikeService;

import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {

	private final LikeMapper likeMapper;

	public LikeServiceImpl(LikeMapper likeMapper) {
		this.likeMapper = likeMapper;
	}

	@Override
	public List<Like> getLikes(Integer userId, Integer bookId) {
		Like like = new Like();
		like.setUserId(userId);
		like.setBookId(bookId);
		return likeMapper.selectLike(like);
	}

	@Override
	public Like getLikesById(Integer id) {
		Like like = new Like();
		like.setId(id);
		List<Like> likes = likeMapper.selectLike(like);
		if (likes.isEmpty()) return null;
		return likes.getFirst();
	}

	@Override
	public boolean addLike(Like like) {
		return likeMapper.insertLike(like) > 0;
	}

	@Override
	public boolean deleteLike(Integer id) {
		return likeMapper.deleteLikeById(id) > 0;
	}

}
