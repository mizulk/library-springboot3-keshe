package pers.mizulk.library.mapper;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import pers.mizulk.library.pojo.Book;
import pers.mizulk.library.pojo.Cart;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CartMapperTest {

	@Resource
	private CartMapper cartMapper;

	@Test
	public void testSelectCartByUserId() {
		Cart cart = new Cart();
		cart.setUserId(1);
		List<Cart> carts = cartMapper.selectCarts(cart);
		assertNotNull(carts);
		assertEquals(1, carts.getFirst().getUserId());
	}

	@Test
	public void testSelectCartById() {
		Cart cart = new Cart();
		cart.setId(1);
		List<Cart> carts = cartMapper.selectCarts(cart);
		assertNotNull(carts);
		assertEquals(1, carts.getFirst().getId());
	}

	@Test
	public void testInsertCart() {
		Cart insertCart = new Cart();
		insertCart.setUserId(1);
		Book book = new Book();
		book.setId(1);
		insertCart.setBook(book);
		insertCart.setCount(2);
		int effectedRows = cartMapper.insertCart(insertCart);
		List<Cart> resultCarts = cartMapper.selectCarts(insertCart);
		assertEquals(1, effectedRows);
		assertEquals(1, resultCarts.getFirst().getUserId());
		assertEquals(1, resultCarts.getFirst().getBook().getId());
	}

	@Test
	public void testUpdateCart() {
		Cart updateCart = new Cart();
		updateCart.setId(1);
		updateCart.setCount(10);
		int effectedRows = cartMapper.updateCart(updateCart);

		Cart selectCart = new Cart();
		selectCart.setId(1);
		List<Cart> resultCarts = cartMapper.selectCarts(selectCart);
		assertEquals(1, effectedRows);
		assertEquals(1, resultCarts.size());
		assertEquals(10, resultCarts.getFirst().getCount());
	}

	@Test
	public void testDeleteCart() {
		int effectedRows = cartMapper.deleteCartById(List.of(1, 8));
		assertEquals(1, effectedRows);
	}

}
