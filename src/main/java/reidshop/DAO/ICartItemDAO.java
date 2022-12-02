package reidshop.DAO;

import java.util.List;

import reidshop.Entity.CartItem;

public interface ICartItemDAO {

	void Insert(CartItem cartItem);

	void Update(CartItem cartItem);

	void Delete(int id);

	List<CartItem> getAll();

	CartItem get(int id);

}