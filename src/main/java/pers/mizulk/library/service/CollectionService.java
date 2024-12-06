package pers.mizulk.library.service;

import pers.mizulk.library.pojo.Collection;

import java.util.List;

public interface CollectionService {

	List<Collection> getCollections(Integer userId, Integer bookId);

	boolean addCollection(Collection collection);

	boolean deleteCollections(List<Integer> id);
}
