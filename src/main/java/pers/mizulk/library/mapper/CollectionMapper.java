package pers.mizulk.library.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import pers.mizulk.library.pojo.Collection;

import java.util.List;

@Mapper
public interface CollectionMapper {
	List<Collection> selectCollection(Collection collection);

	int deleteCollections(List<Integer> ids);

	@Insert("INSERT INTO collections(userId, bookId) VALUES(#{userId}, #{book.id})")
	int insertCollection(Collection collection);

	int updateCollection(Collection collection);
}
