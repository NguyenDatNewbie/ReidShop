package reidshop.DAO;

import java.util.List;

import reidshop.Entity.Delivery;

public interface IDeliveryDAO {

	void Insert(Delivery delivery);

	void Update(Delivery delivery);

	void Delete(int id);

	List<Delivery> getAll();

	Delivery get(int id);

}