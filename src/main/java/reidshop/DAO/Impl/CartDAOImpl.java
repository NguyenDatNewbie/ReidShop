package reidshop.DAO.Impl;

import reidshop.Connection.ConnectDB;
import reidshop.DAO.ICartDAO;
import reidshop.Entity.Cart;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CartDAOImpl extends ConnectDB implements ICartDAO {
    @Override
    public void Insert(Cart cart) {
        String sql = "Insert into Cart Values(?,?,?)";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,cart.getUsername());
            ps.setInt(2,cart.getStoreId());
            ps.setByte(3, (byte) 0);
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public void Update(Cart cart) {
        String sql = "UPDATE  Cart SET username=?, storeId=?, complete=? where id = ?";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,cart.getUsername());
            ps.setInt(2,cart.getStoreId());
            ps.setByte(3, cart.getComplete());
            ps.setInt(4, cart.getId());
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void Delete(int id) {
        String sql = "Delete From Cart where id=?";
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
    public List<Cart> getAll() {
        String sql = "SELECT *from Cart";
        List<Cart> carts = new ArrayList<>();
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String username= rs.getString("getUsername");
                int storeId = rs.getInt("storeId");
                byte complete = rs.getByte("complete");
                Cart cart = new Cart(id, username,storeId,complete);
                carts.add(cart);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return carts;
    }

    @Override
    public Cart get(int id) {
        String sql = "SELECT *from Cart where id=?";
        Cart cart = new Cart();
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

            	 String username= rs.getString("getUsername");
                 int storeId = rs.getInt("storeId");
                 byte complete = rs.getByte("complete");
                cart = new Cart(id, username,storeId,complete);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cart;
    }
    
    @Override
    public Cart getByUserName(String username) {
        String sql = "SELECT *from Cart where username=? and complete=0";
        Cart cart = new Cart();
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int storeId = rs.getInt("storeId");
                byte complete = rs.getByte("complete");
                cart = new Cart(id, username,storeId,complete);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cart;
    }
    
   
}
