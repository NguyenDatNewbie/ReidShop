package reidshop.DAO;

import java.util.List;

import reidshop.Entity.Product;

public interface IProductDAO {
	void Insert(Product product);

	void Update(Product product);

	void Delete(int id);

	List<Product> getAll();

	Product getProduct(int id);

	List<Product> getSellingProduct();

	List<Product> getPopularProducts();

	List<Product> getProductByCategory(int category_id);
}
