package reidshop.DAO.Impl;

import reidshop.Connection.ConnectDB;
import reidshop.DAO.ICartItemDAO;
import reidshop.DAO.IProductDAO;
import reidshop.Entity.Cart;
import reidshop.Entity.CartItem;
import reidshop.Entity.Product;

import java.math.BigDecimal;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class CartItemDAO extends ConnectDB implements ICartItemDAO {
    @Override
    public void Insert(CartItem cartItem) {
        String sql = "Insert into CartItem Values(?,?,?,?)";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,cartItem.getCartId());
            ps.setInt(2,cartItem.getProductId());
            ps.setInt(3,cartItem.getCount());
            ps.setInt(4,cartItem.getSize());
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void UpdateQuantity(int id,int quantity) {
    	 String sql = "UPDATE CartItem SET count=? where id = ?";
         try {
             Connection conn = super.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setInt(1,quantity);
             ps.setInt(2,id);
             ps.executeUpdate();
         } catch (Exception ex) {
             ex.printStackTrace();
         }
    }
    @Override
    public void Update(CartItem cartItem) {
        String sql = "UPDATE  CartItem SET cartId=?, productId=?, count=? where id = ?";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,cartItem.getCartId());
            ps.setInt(2,cartItem.getProductId());
            ps.setInt(3,cartItem.getCount());
            ps.setInt(4,cartItem.getId());
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void Delete(int id) {
        String sql = "Delete From CartItem where id=?";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<CartItem> getAll() {
        String sql = "SELECT *from CartItem";
        List<CartItem> cartItems = new ArrayList<>();
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                int id =rs.getInt("id");
                int cartId =rs.getInt("cartId");
                int productId=rs.getInt("productId");
                int count=rs.getInt("count");
                int size=rs.getInt("size");
                CartItem cartItem = new CartItem(id,cartId,productId,count,size);
                cartItems.add(cartItem);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cartItems;
    }

    @Override
    public List<CartItem> getCartByCartId(int cartId) {
        String sql = "SELECT *from CartItem where cartId=?";
        List<CartItem> cartItems = new ArrayList<>();
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,cartId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id =rs.getInt("id");
                int productId=rs.getInt("productId");
                int count=rs.getInt("count");
                int size=rs.getInt("size");
                CartItem cartItem = new CartItem(id,cartId,productId,count,size);
                cartItems.add(cartItem);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cartItems;
    }
    @Override
    public CartItem get(int id) {
        String sql = "SELECT *from CartItem where id=?";
        CartItem cartItem = new CartItem();
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int cartId =rs.getInt("cartId");
                int productId=rs.getInt("productId");
                int count=rs.getInt("count");
                int size=rs.getInt("size");
                cartItem = new CartItem(id,cartId,productId,count,size);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cartItem;
    }
    
    @Override
    public CartItem CheckExist(int productId, int cartId,int size) {
        String sql = "SELECT *from CartItem where productId=? and cartId=? and size=?";
        CartItem cartItem = null;
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, productId);
            ps.setInt(2, cartId);
            ps.setInt(3, size);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	int id = rs.getInt("id");
                int count=rs.getInt("count")+1;
                cartItem = new CartItem(id,cartId,productId,count,size);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cartItem;
    }
    
    @Override
    public BigDecimal TotalPrice(Cart cart) {
        String sql = "SELECT *from CartItem where cartId=?";
        BigDecimal total = BigDecimal.valueOf(0);
        IProductDAO productDAO = new ProductDAOImpl();
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cart.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int productId=rs.getInt("productId");
                int count=rs.getInt("count");
 
                Product product = productDAO.getProduct(productId);
    			BigDecimal discount = productDAO.TotalPrice_Promotion_count(product, 1);
                total = total.add(BigDecimal.valueOf(count).multiply(discount));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return total;
    }
}
