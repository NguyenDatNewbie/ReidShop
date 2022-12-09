package reidshop.DAO.Impl;


import reidshop.Connection.ConnectDB;
import reidshop.DAO.IOrderItemDAO;
import reidshop.Entity.OrderItem;


import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderItemDAOImpl extends ConnectDB implements IOrderItemDAO {
	@Override
	public void Insert(OrderItem orderItem) {
		String sql = "Insert into OrderItem Values(?,?,?,?,?,?,?)";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,orderItem.getOrderId());
			ps.setInt(2,orderItem.getProductId());
			ps.setInt(3,orderItem.getCount());
			ps.setInt(4,orderItem.getSize());
			ps.setBigDecimal(5, orderItem.getPrice());
			ps.setDate(6, Date.valueOf(LocalDate.now())); // createdAt
			ps.setDate(7, null); // createdAt
			ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}


	@Override
	public void Update(OrderItem orderItem) {
		String sql = "UPDATE  OrderItem SET orderId=?, productId=?, count=?, price=?, updatedAt=? where id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,orderItem.getOrderId());
			ps.setInt(2,orderItem.getProductId());
			ps.setInt(3,orderItem.getCount());
			ps.setBigDecimal(4, orderItem.getPrice());
			ps.setDate(5, Date.valueOf(LocalDate.now())); //
			ps.setInt(6,orderItem.getId());
			ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void Delete(int id) {
		String sql = "Delete From OrderItem where id=?";
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
	public List<OrderItem> getAll() {
		String sql = "SELECT *from OrderItem";
		List<OrderItem> orderItems = new ArrayList<>();
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id =rs.getInt("id");
				int orderId =rs.getInt("orderId");
				int productId=rs.getInt("productId");
				int count=rs.getInt("count");
                int size=rs.getInt("size");
				BigDecimal price=rs.getBigDecimal("price");
				java.util.Date createdAt = rs.getDate("createdAt");
				java.util.Date updateAt = rs.getDate("updatedAt");
				OrderItem orderItem = new OrderItem(id,orderId,productId,count,size,price, createdAt, updateAt);
				orderItems.add(orderItem);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return orderItems;
	}

	@Override
	public OrderItem get(int id) {
		String sql = "SELECT *from OrderItem where id=?";
		OrderItem orderItem = new OrderItem();
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int orderId =rs.getInt("orderId");
				int productId=rs.getInt("productId");
				int count=rs.getInt("count");
                int size=rs.getInt("size");
				BigDecimal price=rs.getBigDecimal("price");
				java.util.Date createdAt = rs.getDate("createdAt");
				java.util.Date updateAt = rs.getDate("updatedAt");
				orderItem = new OrderItem(id,orderId,productId,count,size,price, createdAt, updateAt);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return orderItem;
	}
}
