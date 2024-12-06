package pers.mizulk.library.service.impl;

import org.springframework.stereotype.Service;
import pers.mizulk.library.mapper.CartMapper;
import pers.mizulk.library.pojo.Cart;
import pers.mizulk.library.service.CartService;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

	private final CartMapper cartMapper;

	public CartServiceImpl(CartMapper cartMapper) {
		this.cartMapper = cartMapper;
	}


	@Override
	public List<Cart> getCarts(Integer userId) {
		Cart cart = new Cart();
		cart.setUserId(userId);
		return cartMapper.selectCarts(cart);
	}

	@Override
	public boolean addCart(Cart cart) {
		return cartMapper.insertCart(cart) > 0;
	}

	@Override
	public boolean updateCart(Cart cart) {
		return cartMapper.updateCart(cart) > 0;
	}


	@Override
	public boolean deleteCarts(List<Integer> cartIds) {
		return cartMapper.deleteCartById(cartIds) > 0;
	}

}
