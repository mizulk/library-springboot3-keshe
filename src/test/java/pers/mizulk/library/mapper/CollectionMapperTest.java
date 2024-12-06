package pers.mizulk.library.mapper;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import pers.mizulk.library.pojo.Book;
import pers.mizulk.library.pojo.Collection;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CollectionMapperTest {
	@Resource
	private CollectionMapper collectionMapper;

	@Test
	public void testSelectCollectionByUserId() {
		Collection collection = new Collection();
		collection.setUserId(1);
		List<Collection> collections = collectionMapper.selectCollection(collection);
		assertNotEquals(0, collections.size());
	}

	@Test
	public void testSelectCollectionByUserIdAndBookId() {
		Collection collection = new Collection();
		collection.setUserId(1);
		Book book = new Book();
		book.setId(1);
		collection.setBook(book);
		List<Collection> collections = collectionMapper.selectCollection(collection);
		assertEquals(1, collections.size());
		assertEquals(book.getId(), collections.getFirst().getBook().getId());
	}

	@Test
	public void testInsertCollection() {
		Collection collection = new Collection();
		collection.setUserId(1);
		Book book = new Book();
		book.setId(60);
		collection.setBook(book);
		int effectedRows = collectionMapper.insertCollection(collection);
		assertEquals(1, effectedRows);
	}

	@Test
	public void testUpdateCollection() {
		Collection collection = new Collection();
		collection.setId(1);
		Book book = new Book();
		book.setId(60);
		collection.setBook(book);
		int effectedRows = collectionMapper.updateCollection(collection);
		assertEquals(1, effectedRows);
	}

	@Test
	public void testDeleteCollection() {
		int effectedRows = collectionMapper.deleteCollections(List.of(1));
		assertEquals(1, effectedRows);
	}
}
