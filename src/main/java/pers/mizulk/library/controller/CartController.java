package pers.mizulk.library.controller;

import org.springframework.web.bind.annotation.*;
import pers.mizulk.library.pojo.Cart;
import pers.mizulk.library.service.CartService;
import pers.mizulk.library.util.Result;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {

	private final CartService cartService;

	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	@GetMapping
	public Result<List<Cart>> getCarts(@RequestParam(required = false) Integer userId) {
		List<Cart> carts = cartService.getCarts(userId);
		return Result.success(carts);
	}

	@PostMapping
	public Result<Cart> addCart(@RequestBody Cart cart) {
		if (cartService.addCart(cart)) return Result.success();
		return Result.error(500);
	}

	@PutMapping
	public Result<Cart> updateCart(@RequestBody Cart cart) {
		if (cartService.updateCart(cart)) return Result.success();
		return Result.error(500);
	}

	@DeleteMapping("/{ids}")
	public Result<Cart> deleteCart(@PathVariable List<Integer> ids) {
		if (cartService.deleteCarts(ids)) return Result.success();
		return Result.error(500);
	}

}
