package reidshop.DAO;

import java.util.List;

import reidshop.Entity.Orders;

public interface IOrderDAO {

	void Insert(Orders orders);

	void Update(Orders orders);

	void Delete(int id);

	List<Orders> getAll();

	Orders get(int id);

	Integer getId(String username);

}