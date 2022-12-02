package reidshop.DAO.Impl;

import reidshop.Connection.ConnectDB;
import reidshop.DAO.ICartItemDAO;
import reidshop.Entity.CartItem;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class CartItemDAO extends ConnectDB implements ICartItemDAO {
    @Override
    public void Insert(CartItem cartItem) {
        String sql = "Insert into CartItem Values(?,?,?)";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,cartItem.getCartId());
            ps.setInt(2,cartItem.getProductId());
            ps.setInt(3,cartItem.getCount());
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

                CartItem cartItem = new CartItem(id,cartId,productId,count);
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

                cartItem = new CartItem(id,cartId,productId,count);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cartItem;
    }
}
