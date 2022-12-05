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
import reidshop.Entity.Product;

public class ProductDAOImpl extends ConnectDB implements IProductDAO {
	
	@Override
	public void Insert(Product product){
		String sql = "INSERT INTO product "
				+ " VALUES (?,?,?,?,?,?,?,?,?)";
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
		ps.setDate(9,null);
		ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	@Override
	public void Update(Product product){
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
	public List<Product> getAll(int storeId){
		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT * FROM product where storeId=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,storeId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name= rs.getString("name");
				String description = rs.getString("description");
				BigDecimal price = rs.getBigDecimal("price");
				int promotion = rs.getInt("promotion");;
				int quantity = rs.getInt("quantity");;
				int sold = rs.getInt("sold");;
				int category_id = rs.getInt("category_id");;
				Product p = new Product(id,name,description,price,promotion,quantity,sold,
						category_id);
				products.add(p);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return products;
	}
	
	@Override
	public Product getProduct(int id)
	{
		Product product = new Product();
		String sql = "Select * from Product where id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getInt("id");
				String name= rs.getString("name");
				String description = rs.getString("description");
				BigDecimal price = rs.getBigDecimal("price");
				int promotion = rs.getInt("promotion");;
				int quantity = rs.getInt("quantity");;
				int sold = rs.getInt("sold");;
				int category_id = rs.getInt("category_id");;
				product = new Product(id,name,description,price,promotion,quantity,sold,
						category_id);
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return product;
	}
	
	@Override
	public List<Product> getSellingProduct(int storeId){
		List<Product> products = new ArrayList<Product>();
		String sql = "Select *from Product where storeId = ? Order by sold DESC";
		try {
			
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,storeId);
			ResultSet rs = ps.executeQuery();
			int count =0;
			while (rs.next()) {
				if(count==10)
					break;
				int id = rs.getInt("id");
				String name= rs.getString("name");
				String description = rs.getString("description");
				BigDecimal price = rs.getBigDecimal("price");
				int promotion = rs.getInt("promotion");;
				int quantity = rs.getInt("quantity");;
				int sold = rs.getInt("sold");;
				int category_id = rs.getInt("category_id");;
				Product p = new Product(id,name,description,price,promotion,quantity,sold,
						category_id);
				products.add(p);
				count++;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return products;
	}
	
	@Override
	public List<Product> getPopularProducts(){
		List<Product> products = new ArrayList<Product>();
		String sql = "Select *from Product Order by createdAt DESC, sold DESC";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int count =0;
			while (rs.next()) {
				if(count==3)
					break;
				int id = rs.getInt("id");
				String name= rs.getString("name");
				String description = rs.getString("description");
				BigDecimal price = rs.getBigDecimal("price");
				int promotion = rs.getInt("promotion");;
				int quantity = rs.getInt("quantity");;
				int sold = rs.getInt("sold");;
				int category_id = rs.getInt("category_id");;
				Product p = new Product(id,name,description,price,promotion,quantity,sold,
						category_id);
				products.add(p);
				count++;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return products;
	}
	
	@Override
	public List<Product>  getProductByCategory(int category_id){
		List<Product> products = new ArrayList<Product>();
		String sql = "Select *from Product where category_id = ? Order by sold DESC";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,category_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name= rs.getString("name");
				String description = rs.getString("description");
				BigDecimal price = rs.getBigDecimal("price");
				int promotion = rs.getInt("promotion");
				int quantity = rs.getInt("quantity");
				int sold = rs.getInt("sold");
				
				Product p = new Product(id,name,description,price,promotion,quantity,sold,
						category_id);
				products.add(p);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return products;
	}
	
	public List<Product> getTop9(int storeId){
		List<Product> products = new ArrayList<Product>();
		String sql = "Select TOP 9 *from Product where storeId=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,storeId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name= rs.getString("name");
				String description = rs.getString("description");
				BigDecimal price = rs.getBigDecimal("price");
				int promotion = rs.getInt("promotion");
				int quantity = rs.getInt("quantity");
				int sold = rs.getInt("sold");
				int category_id = rs.getInt("category_id");
				Product p = new Product(id,name,description,price,promotion,quantity,sold,
						category_id);
				products.add(p);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return products;
	}
	
	public List<Product> getTop9Next(int storeId,int amount){
		List<Product> products = new ArrayList<Product>();
		String sql = "Select * From Product where storeId = ? Order By id OffSet ? Rows Fetch Next 9 Rows Only";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,storeId);
			ps.setInt(2,amount);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name= rs.getString("name");
				String description = rs.getString("description");
				BigDecimal price = rs.getBigDecimal("price");
				int promotion = rs.getInt("promotion");
				int quantity = rs.getInt("quantity");
				int sold = rs.getInt("sold");
				int category_id = rs.getInt("category_id");
				Product p = new Product(id,name,description,price,promotion,quantity,sold,
						category_id);
				products.add(p);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return products;
	}
}
