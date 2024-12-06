package pers.mizulk.library.service;

import pers.mizulk.library.pojo.Comment;

import java.util.List;

public interface CommentService {
	List<Comment> getComments(Integer userId, Integer bookId);

	boolean addComment(Comment comment);

	boolean updateComment(Comment comment);

	boolean deleteComments(List<Integer> id);
}
