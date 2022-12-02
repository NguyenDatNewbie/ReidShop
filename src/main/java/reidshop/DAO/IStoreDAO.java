package reidshop.DAO;

import java.util.List;

import reidshop.Entity.Store;

public interface IStoreDAO {

	void Insert(Store store);

	void Update(Store store);

	void Delete(int id);

	List<Store> getAll();

	Store get(int id);

}