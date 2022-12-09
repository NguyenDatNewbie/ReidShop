package reidshop.DAO.Impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import reidshop.Connection.ConnectDB;
import reidshop.DAO.IProductDAO;
import reidshop.Entity.CartItem;
import reidshop.Entity.Product;

public class ProductDAOImpl extends ConnectDB implements IProductDAO {

	@Override
	public void Insert(Product product) {
		String sql = "INSERT INTO product " + " VALUES (?,?,?,?,?,?,?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, product.getName());
			ps.setString(2, product.getDescription());
			ps.setBigDecimal(3, product.getPrice());
			ps.setInt(4, product.getPromotion());
			ps.setInt(5, product.getQuantity());
			ps.setInt(6, 0);
			ps.setInt(7, product.getCategory_id());
			ps.setDate(8, Date.valueOf(java.time.LocalDate.now()));
			ps.setDate(9, null);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void Update(Product product) {
		String sql = "Update product SET name=?, description=?, price=?, promotion=?, quantity=?, sold=?, category_id=?, updatedAt=? where id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, product.getName());
			ps.setString(2, product.getDescription());
			ps.setBigDecimal(3, product.getPrice());
			ps.setInt(4, product.getPromotion());
			ps.setInt(5, product.getQuantity());
			ps.setInt(6, product.getSold());
			ps.setInt(7, product.getCategory_id());
			ps.setDate(8, Date.valueOf(java.time.LocalDate.now()));
			ps.setInt(9, product.getId());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void Delete(int id) {
		String sql = "DELETE FROM product WHERE id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Product> getAll(int storeId) {
		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT * FROM product where storeId=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, storeId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				BigDecimal price = rs.getBigDecimal("price");
				int promotion = rs.getInt("promotion");
				;
				int quantity = rs.getInt("quantity");
				;
				int sold = rs.getInt("sold");
				;
				int category_id = rs.getInt("category_id");
				;
				Product p = new Product(id, name, description, price, promotion, quantity, sold, category_id);
				products.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public Product getProduct(int id) {
		Product product = new Product();
		String sql = "Select * from Product where id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				BigDecimal price = rs.getBigDecimal("price");
				int promotion = rs.getInt("promotion");
				;
				int quantity = rs.getInt("quantity");
				;
				int sold = rs.getInt("sold");
				;
				int category_id = rs.getInt("category_id");
				;
				product = new Product(id, name, description, price, promotion, quantity, sold, category_id);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public List<Product> getSellingProduct(int storeId) {
		List<Product> products = new ArrayList<Product>();
		String sql = "Select *from Product where storeId = ? Order by sold DESC";
		try {

			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, storeId);
			ResultSet rs = ps.executeQuery();
			int count = 0;
			while (rs.next()) {
				if (count == 10)
					break;
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				BigDecimal price = rs.getBigDecimal("price");
				int promotion = rs.getInt("promotion");
				;
				int quantity = rs.getInt("quantity");
				;
				int sold = rs.getInt("sold");
				;
				int category_id = rs.getInt("category_id");
				;
				Product p = new Product(id, name, description, price, promotion, quantity, sold, category_id);
				products.add(p);
				count++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public List<Product> getPopularProducts() {
		List<Product> products = new ArrayList<Product>();
		String sql = "Select TOP 9 *from Product Order by createdAt DESC, sold DESC";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int count = 0;
			while (rs.next()) {
				if (count == 3)
					break;
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				BigDecimal price = rs.getBigDecimal("price");
				int promotion = rs.getInt("promotion");
				;
				int quantity = rs.getInt("quantity");
				;
				int sold = rs.getInt("sold");
				;
				int category_id = rs.getInt("category_id");
				;
				Product p = new Product(id, name, description, price, promotion, quantity, sold, category_id);
				products.add(p);
				count++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public List<Product> getProductByCategory(int store, int category_id) {
		List<Product> products = new ArrayList<Product>();
		String sql = "Select *from Product where category_id = ? and storeId=? Order by sold DESC";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, category_id);
			ps.setInt(2, store);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				BigDecimal price = rs.getBigDecimal("price");
				int promotion = rs.getInt("promotion");
				int quantity = rs.getInt("quantity");
				int sold = rs.getInt("sold");

				Product p = new Product(id, name, description, price, promotion, quantity, sold, category_id);
				products.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	public List<Product> getTop9(int storeId, int option) {
		List<Product> products = new ArrayList<Product>();
		String sql = "Select TOP 9 *from Product where storeId=?";
		if (option == 2)
			sql = "Select TOP 9 *from Product where storeId=? Order By sold DESC";
		if (option == 3)
			sql = "Select TOP 9 *from Product where storeId=? Order By price DESC";
		if (option == 4)
			sql = "Select TOP 9 *from Product where storeId=? Order By price ";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, storeId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				BigDecimal price = rs.getBigDecimal("price");
				int promotion = rs.getInt("promotion");
				int quantity = rs.getInt("quantity");
				int sold = rs.getInt("sold");
				int category_id = rs.getInt("category_id");
				Product p = new Product(id, name, description, price, promotion, quantity, sold, category_id);
				products.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	public List<Product> getTop9Next(int storeId, int amount, int option) {
		List<Product> products = new ArrayList<Product>();
		String sql = "Select * From Product where storeId = ? Order By id OffSet ? Rows Fetch Next 9 Rows Only";
		if (option == 2)
			sql = "Select *from Product where storeId=? Order By sold DESC, id OffSet ? Rows Fetch Next 9 Rows Only";
		if (option == 3)
			sql = "Select * From Product where storeId = ? Order By price DESC, id OffSet ? Rows Fetch Next 9 Rows Only";
		if (option == 4)
			sql = "Select * From Product where storeId = ? Order By price, id OffSet ? Rows Fetch Next 9 Rows Only";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, storeId);
			ps.setInt(2, amount);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				BigDecimal price = rs.getBigDecimal("price");
				int promotion = rs.getInt("promotion");
				int quantity = rs.getInt("quantity");
				int sold = rs.getInt("sold");
				int category_id = rs.getInt("category_id");
				Product p = new Product(id, name, description, price, promotion, quantity, sold, category_id);
				products.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	public List<Product> getTop9ByCategory(int storeId, int category, int option) {
		List<Product> products = new ArrayList<Product>();
		String sql = "Select TOP 9 *from Product where storeId=? and category_id=? ";
		if (option == 2)
			sql = "Select TOP 9 *from Product where storeId=? and category_id=? Order By sold DESC";
		if (option == 3)
			sql = "Select TOP 9 *from Product where storeId=? and category_id=? Order By price DESC";
		if (option == 4)
			sql = "Select TOP 9 *from Product where storeId=? and category_id=? Order By price";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, storeId);
			ps.setInt(2, category);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				BigDecimal price = rs.getBigDecimal("price");
				int promotion = rs.getInt("promotion");
				int quantity = rs.getInt("quantity");
				int sold = rs.getInt("sold");
				int category_id = rs.getInt("category_id");
				Product p = new Product(id, name, description, price, promotion, quantity, sold, category_id);
				products.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	public List<Product> getTop9NextByCategory(int storeId, int amount, int category, int option) {
		List<Product> products = new ArrayList<Product>();

		String sql = "Select * From Product where storeId = ? and category_id =? Order By id OffSet ? Rows Fetch Next 9 Rows Only";
		if (option == 2)
			sql = "Select  *from Product where storeId=? and category_id=? Order By sold DESC, id OffSet ? Rows Fetch Next 9 Rows Only";
		if (option == 2)
			sql = "Select * From Product where storeId = ? and category_id =? Order By price DESC, id  OffSet ? Rows Fetch Next 9 Rows Only";
		if (option == 3)
			sql = "Select * From Product where storeId = ? and category_id =? Order By price, id  OffSet ? Rows Fetch Next 9 Rows Only";

		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, storeId);
			ps.setInt(2, category);
			ps.setInt(3, amount);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				BigDecimal price = rs.getBigDecimal("price");
				int promotion = rs.getInt("promotion");
				int quantity = rs.getInt("quantity");
				int sold = rs.getInt("sold");
				int category_id = rs.getInt("category_id");
				Product p = new Product(id, name, description, price, promotion, quantity, sold, category_id);
				products.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public Product getProductByCartItem(CartItem cart) {
		Product product = new Product();
		String sql = "Select * from Product where id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cart.getProductId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				BigDecimal price = rs.getBigDecimal("price");
				int promotion = rs.getInt("promotion");
				;
				int quantity = rs.getInt("quantity");
				;
				int sold = rs.getInt("sold");
				;
				int category_id = rs.getInt("category_id");
				;
				product = new Product(id, name, description, price, promotion, quantity, sold, category_id);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	public BigDecimal TotalPrice_Promotion_count(Product product, int count) {
		return product.getPrice().multiply(BigDecimal.valueOf(count))
				.subtract(product.getPrice().multiply(BigDecimal.valueOf(product.getPromotion() / 100.0)));
	}

	public BigDecimal TotalPrice_Promotion_count(Integer productId, int count) {
		IProductDAO productDAO = new ProductDAOImpl();

		Product product = productDAO.getProduct(productId);
		return product.getPrice().multiply(BigDecimal.valueOf(count))
				.subtract(product.getPrice().multiply(BigDecimal.valueOf(product.getPromotion() / 100.0)));
	}
}
