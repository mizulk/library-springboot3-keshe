package pers.mizulk.library.service;

import pers.mizulk.library.pojo.Cart;

import java.util.List;

public interface CartService {

	List<Cart> getCarts(Integer userId);

	boolean addCart(Cart cart);

	boolean updateCart(Cart cart);

	boolean deleteCarts(List<Integer> cartIds);
}
