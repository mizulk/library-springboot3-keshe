package pers.mizulk.library.service.impl;

import org.springframework.stereotype.Service;
import pers.mizulk.library.mapper.CommentMapper;
import pers.mizulk.library.pojo.Comment;
import pers.mizulk.library.pojo.User;
import pers.mizulk.library.service.CommentService;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

	private final CommentMapper commentMapper;

	public CommentServiceImpl(CommentMapper commentMapper) {
		this.commentMapper = commentMapper;
	}

	@Override
	public List<Comment> getComments(Integer userId, Integer bookId) {
		Comment comment = new Comment();
		comment.setBookId(bookId);
		User user = new User();
		user.setId(userId);
		comment.setUser(user);
		return commentMapper.selectComment(comment);
	}

	@Override
	public boolean addComment(Comment comment) {
		return commentMapper.insertComment(comment) > 0;
	}

	@Override
	public boolean updateComment(Comment comment) {
		return commentMapper.updateComment(comment) > 0;
	}

	@Override
	public boolean deleteComments(List<Integer> ids) {
		return commentMapper.deleteComments(ids) > 0;
	}
}
