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
            ps.setInt(1,cart.getUserId());
            ps.setInt(2,cart.getStoreId());
            ps.setByte(3, (byte) 0);
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public void Update(Cart cart) {
        String sql = "UPDATE  Cart SET userId=?, storeId=?, complete=? where id = ?";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,cart.getUserId());
            ps.setInt(2,cart.getStoreId());
            ps.setByte(3, cart.getComplete());
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
                int userId= rs.getInt("userId");
                int storeId = rs.getInt("storeId");
                byte complete = rs.getByte("complete");
                Cart cart = new Cart(id, userId,storeId,complete);
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

                int userId= rs.getInt("userId");
                int storeId = rs.getInt("storeId");
                byte complete = rs.getByte("complete");
                cart = new Cart(id, userId,storeId,complete);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cart;
    }
}
