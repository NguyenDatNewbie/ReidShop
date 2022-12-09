package reidshop.DAO;

import java.math.BigDecimal;
import java.util.List;

import reidshop.Entity.Cart;
import reidshop.Entity.CartItem;

public interface ICartItemDAO {

	void Insert(CartItem cartItem);

	void Update(CartItem cartItem);
	
	void UpdateQuantity(int id,int quantity);

	void Delete(int id);

	List<CartItem> getAll();

	CartItem get(int id);

	List<CartItem> getCartByCartId(int cartId);

	BigDecimal TotalPrice(Cart cart);
	
	CartItem CheckExist(int productId, int cartId,int size);
	
	
}