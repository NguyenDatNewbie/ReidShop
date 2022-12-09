package reidshop.DAO;

import java.math.BigDecimal;
import java.util.List;

import reidshop.Entity.CartItem;
import reidshop.Entity.Product;

public interface IProductDAO {

	void Insert(Product product);

	void Update(Product product);

	void Delete(int id);

	List<Product> getAll(int storeId);

	Product getProduct(int id);

	List<Product> getSellingProduct(int storeId);

	List<Product> getPopularProducts();

	List<Product> getProductByCategory(int store, int category_id);

	List<Product> getTop9(int storeId, int option);

	List<Product> getTop9Next(int storeId, int amount, int option);

	List<Product> getTop9ByCategory(int storeId, int category, int option);

	List<Product> getTop9NextByCategory(int storeId, int amount, int category, int option);

	Product getProductByCartItem(CartItem cart);

	BigDecimal TotalPrice_Promotion_count(Product product, int count);

	BigDecimal TotalPrice_Promotion_count(Integer productId, int count);
}