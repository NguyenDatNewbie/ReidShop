package reidshop.DAO;

import java.util.List;

import reidshop.Entity.Category;

public interface ICategoryDAO {

	void Insert(Category category);

	void Update(Category category);

	void Delete(int id);

	List<Category> getAll();

	Category get(int id);

}