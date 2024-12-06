package pers.mizulk.library.service;

import pers.mizulk.library.pojo.Author;

import java.util.List;

public interface AuthorService {

	List<Author> getAuthors(Integer limit, String keyword, List<Integer> ids);

	Author getAuthorById(Integer id);

}
