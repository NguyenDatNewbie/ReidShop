package reidshop.DAO.Impl;


import reidshop.Connection.ConnectDB;
import reidshop.DAO.IOrderDAO;

import reidshop.Entity.Orders;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl extends ConnectDB implements IOrderDAO {
	@Override
	public void Insert(Orders orders) {
		String sql = "Insert into Orders Values(?,?,?,?,?,?,?,?,?)";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,orders.getUsername());
            ps.setInt(2,orders.getStoreId());
            ps.setInt(3,orders.getDeliveryId());
			ps.setString(4, orders.getAddress());
			ps.setString(5, orders.getPhone());
            ps.setInt(6,orders.getStatus());
			ps.setBigDecimal(7, orders.getTotal_price());
			ps.setDate(8, Date.valueOf(LocalDate.now())); // createdAt
			ps.setDate(9, null); // createdAt
			ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}


	@Override
	public void Update(Orders orders) {
		String sql = "UPDATE  Orders SET userId=?, storeId=?, deliveryId=?, address=?, phone=?,status=?,total_price=?, updatedAt=? where id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,orders.getUsername());
            ps.setInt(2,orders.getStoreId());
            ps.setInt(3,orders.getDeliveryId());
            ps.setString(4, orders.getAddress());
            ps.setString(5, orders.getPhone());
            ps.setInt(6,orders.getStatus());
            ps.setBigDecimal(7, orders.getTotal_price());
            ps.setDate(8, Date.valueOf(LocalDate.now())); // createdAt
            ps.setInt(9,orders.getId());
			ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void Delete(int id) {
		String sql = "Delete From Orders where id=?";
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
	public List<Orders> getAll() {
		String sql = "SELECT *from Orders";
		List<Orders> orders = new ArrayList<>();
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
                String username= rs.getString("username");
                int storeId = rs.getInt("storeId");
                int deliveryId = rs.getInt("deliveryId");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
                int status = rs.getInt("status");
                BigDecimal total_price =rs.getBigDecimal("total_price");
				java.util.Date createdAt = rs.getDate("createdAt");
				java.util.Date updateAt = rs.getDate("updatedAt");
				Orders order = new Orders(id, username,storeId,deliveryId, address, phone,status,total_price, createdAt, updateAt);
				orders.add(order);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return orders;
	}

	@Override
	public Orders get(int id) {
		String sql = "SELECT *from Orders where id=?";
        Orders order = new Orders();
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String username= rs.getString("username");
                int storeId = rs.getInt("storeId");
                int deliveryId = rs.getInt("deliveryId");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                int status = rs.getInt("status");
                BigDecimal total_price =rs.getBigDecimal("total_price");
                java.util.Date createdAt = rs.getDate("createdAt");
                java.util.Date updateAt = rs.getDate("updatedAt");
                order = new Orders(id, username,storeId,deliveryId, address, phone,status,total_price, createdAt, updateAt);
            }
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return order;
	}

	public Integer getId(String username) {
		String sql = "SELECT *from Orders where username=?";
		Integer id = null;
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getInt("id");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return id;
	}
}
