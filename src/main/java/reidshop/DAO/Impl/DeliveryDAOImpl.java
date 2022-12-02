package reidshop.DAO.Impl;

import reidshop.Connection.ConnectDB;
import reidshop.DAO.IDeliveryDAO;
import reidshop.Entity.Delivery;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DeliveryDAOImpl extends ConnectDB implements IDeliveryDAO {
    @Override
    public void Insert(Delivery delivery)
    {
        String sql = "Insert into Delivery Values(?,?,?,?)";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,delivery.getName());
            ps.setString(2,delivery.getPhone());
            ps.setInt(3,delivery.getStatus());
            ps.setDate(4, Date.valueOf(LocalDate.now()));
            ps.executeUpdate();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }


    @Override
    public void Update(Delivery delivery){
        String sql = "UPDATE  Delivery SET name=?, phone=?,status=?, updatedAt=? where id = ?";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,delivery.getName());
            ps.setString(2,delivery.getPhone());
            ps.setInt(3,delivery.getStatus());
            ps.setDate(4, Date.valueOf(LocalDate.now()));
            ps.setInt(5,delivery.getId());
            ps.executeUpdate();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public void Delete(int id){
        String sql = "Delete From Delivery where id=?";
        try	{
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public List<Delivery> getAll(){
        String sql = "SELECT *from Delivery";
        List<Delivery> deliveries = new ArrayList<>();
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String phone= rs.getString("phone");
                int status= rs.getInt("status");
                java.util.Date createdAt =rs.getDate("createdAt");
                java.util.Date updateAt = rs.getDate("updatedAt");
                Delivery delivery = new Delivery(id,name,phone,status,createdAt,updateAt);
                deliveries.add(delivery);
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return deliveries;
    }

    @Override
    public Delivery get(int id){
        String sql = "SELECT *from Delivery where id=?";
        Delivery delivery = new Delivery();
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                String phone= rs.getString("phone");
                int status= rs.getInt("status");
                java.util.Date createdAt =rs.getDate("createdAt");
                java.util.Date updateAt = rs.getDate("updatedAt");
                delivery = new Delivery(id,name,phone,status,createdAt,updateAt);
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return delivery;
    }
}
