package reidshop.DAO;

import java.util.List;

import reidshop.Entity.OrderItem;

public interface IOrderItemDAO {

	void Insert(OrderItem orderItem);

	void Update(OrderItem orderItem);

	void Delete(int id);

	List<OrderItem> getAll();

	OrderItem get(int id);

}