package pers.mizulk.library.controller;

import org.springframework.web.bind.annotation.*;
import pers.mizulk.library.pojo.Collection;
import pers.mizulk.library.service.CollectionService;
import pers.mizulk.library.util.Result;

import java.util.List;

@RestController
@RequestMapping("/collections")
public class CollectionController {

	private final CollectionService collectionService;

	public CollectionController(CollectionService collectionService) {
		this.collectionService = collectionService;
	}

	@GetMapping
	public Result<List<Collection>> getCollections(
			@RequestParam(required = false) Integer userId,
			@RequestParam(required = false) Integer bookId
	) {
		List<Collection> collections = collectionService.getCollections(userId, bookId);
		return Result.success(collections);
	}

	@PostMapping
	public Result<Collection> addCollection(@RequestBody Collection collection) {
		if (collectionService.addCollection(collection)) return Result.success();
		return Result.error(500);
	}

	@DeleteMapping("/{ids}")
	public Result<Collection> deleteCollection(@PathVariable List<Integer> ids) {
		if (collectionService.deleteCollections(ids)) return Result.success();
		return Result.error(500);
	}
}
