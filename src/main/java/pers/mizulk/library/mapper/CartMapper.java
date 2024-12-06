package pers.mizulk.library.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import pers.mizulk.library.pojo.Cart;

import java.util.List;

@Mapper
public interface CartMapper {

	int deleteCartById(List<Integer> ids);

	@Insert("INSERT INTO carts(userId, bookId, count, createTime, updateTime) " +
			"VALUES(#{userId}, #{book.id}, #{count}, NOW(), NOW())")
	int insertCart(Cart cart);

	int updateCart(Cart cart);

	List<Cart> selectCarts(Cart cart);
}
