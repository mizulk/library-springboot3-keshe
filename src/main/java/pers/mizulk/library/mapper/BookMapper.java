package pers.mizulk.library.mapper;

import org.apache.ibatis.annotations.Mapper;
import pers.mizulk.library.pojo.Book;

import java.util.List;

@Mapper
public interface BookMapper {

	List<Book> selectBooks(Book book, List<Integer> ids, Integer limit);

	Book selectBookById(Integer id);

	int updateBook(Book book);
}
