package pers.mizulk.library.service.impl;

import org.springframework.stereotype.Service;
import pers.mizulk.library.mapper.CollectionMapper;
import pers.mizulk.library.pojo.Book;
import pers.mizulk.library.pojo.Collection;
import pers.mizulk.library.service.CollectionService;

import java.util.List;

@Service
public class CollectionServiceImpl implements CollectionService {

	private final CollectionMapper collectionMapper;

	public CollectionServiceImpl(CollectionMapper collectionMapper) {
		this.collectionMapper = collectionMapper;
	}

	@Override
	public List<Collection> getCollections(Integer userId, Integer bookId) {
		Collection collection = new Collection();
		collection.setUserId(userId);
		Book book = new Book();
		book.setId(bookId);
		collection.setBook(book);
		return collectionMapper.selectCollection(collection);
	}

	@Override
	public boolean addCollection(Collection collection) {
		return collectionMapper.insertCollection(collection) > 0;
	}

	@Override
	public boolean deleteCollections(List<Integer> id) {
		return collectionMapper.deleteCollections(id) > 0;
	}

}
