package pers.mizulk.library.mapper;

import org.apache.ibatis.annotations.Mapper;
import pers.mizulk.library.pojo.Author;

import java.util.List;


@Mapper
public interface AuthorMapper {
	List<Author> selectAuthor(List<Integer> ids, String name, Integer limit);

	Author selectAuthorById(Integer id);
}
