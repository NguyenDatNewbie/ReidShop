package reidshop.DAO.Impl;

import reidshop.Connection.ConnectDB;
import reidshop.DAO.ISizeDAO;

import reidshop.Entity.Size;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SizeDAOImpl extends ConnectDB implements ISizeDAO {
    @Override
    public void Insert(Size size)
    {
        String sql = "Insert into Size Values(?,?)";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,size.getSize());
            ps.setInt(2,size.getProduct_id());
            ps.executeUpdate();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }


    @Override
    public void Update(Size size){
        String sql = "UPDATE  Size SET size=?, product_id=? where size=? and product_id=?";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,size.getSize());
            ps.setInt(2,size.getProduct_id());
            ps.setInt(3,size.getSize());
            ps.setInt(4,size.getProduct_id());
            ps.executeUpdate();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public void Delete(int size,int product_id){
        String sql = "Delete From Size where id=? and product_id=?";
        try	{
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,size);
            ps.setInt(2,product_id);
            ps.executeUpdate();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public List<Size> getSizeByProductId(int product_id){
        String sql = "SELECT *from Size where product_id=?";
        List<Size> sizes = new ArrayList<>();
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,product_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int size = rs.getInt("size");
                Size data = new Size(size,product_id);
                sizes.add(data);
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return sizes;
    }

    @Override
    public List<Size> getSizeBySize(int size){
        String sql = "SELECT *from Size where size=?";
        List<Size> sizes = new ArrayList<>();
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,size);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int product_id = rs.getInt("product_id");
                Size data = new Size(size,product_id);
                sizes.add(data);
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return sizes;
    }
}
