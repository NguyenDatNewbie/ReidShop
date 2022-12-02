package reidshop.DAO;

import java.util.List;

import reidshop.Entity.Cart;

public interface ICartDAO {

	void Insert(Cart cart);

	void Update(Cart cart);

	void Delete(int id);

	List<Cart> getAll();

	Cart get(int id);

}