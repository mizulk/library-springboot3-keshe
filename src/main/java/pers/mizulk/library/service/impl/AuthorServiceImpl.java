package pers.mizulk.library.service.impl;

import org.springframework.stereotype.Service;
import pers.mizulk.library.mapper.AuthorMapper;
import pers.mizulk.library.pojo.Author;
import pers.mizulk.library.service.AuthorService;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

	private final AuthorMapper authorMapper;

	public AuthorServiceImpl(AuthorMapper authorMapper) {
		this.authorMapper = authorMapper;
	}

	@Override
	public List<Author> getAuthors(Integer limit, String keyword, List<Integer> ids) {
		return authorMapper.selectAuthor(ids, keyword, limit);
	}
	@Override
	public Author getAuthorById(Integer id) {
		return authorMapper.selectAuthorById(id);
	}
}
