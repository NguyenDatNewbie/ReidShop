package reidshop.DAO;

import java.util.List;

import reidshop.Entity.Product;

public interface IProductDAO {

	void Insert(Product product);

	void Update(Product product);

	void Delete(int id);

	List<Product> getAll(int storeId);

	Product getProduct(int id);

	List<Product> getSellingProduct(int storeId);

	List<Product> getPopularProducts();

	List<Product> getProductByCategory(int category_id);

	List<Product> getTop9(int storeId);

	List<Product> getTop9Next(int storeId, int amount);

}