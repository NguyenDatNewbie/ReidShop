package reidshop.DAO.Impl;

import reidshop.Connection.ConnectDB;
import reidshop.DAO.IInfoUserDAO;

import reidshop.Entity.InfoUser;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InfoUserDAOImpl extends ConnectDB implements IInfoUserDAO {
    @Override
    public void Insert(InfoUser info)
    {
        String sql = "Insert into InfoUser Values(?,?,?,?,?,?)";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,info.getName());
            ps.setString(2,info.getEmail());
            ps.setString(3,info.getPhone());
            ps.setString(4,info.getAddress());
            ps.setString(5,info.getAvatar());
            ps.setDate(6, Date.valueOf(LocalDate.now())); // createdAt
            ps.executeUpdate();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    // Chỉ dc đổi password hoặc quyền
    @Override
    public void Update(InfoUser info){
        String sql = "UPDATE  InfoUser SET name=?, email=?, phone=?, address=?, avatar=?, updatedAt=? where id = ?";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,info.getName());
            ps.setString(2,info.getEmail());
            ps.setString(3,info.getPhone());
            ps.setString(4,info.getAddress());
            ps.setString(5,info.getAvatar());
            ps.setDate(6, Date.valueOf(LocalDate.now())); // updateAt
            ps.setInt(7,info.getId());
            ps.executeUpdate();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public void Delete(int id){
        String sql = "Delete From InfoUser where id=?";
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
    public List<InfoUser> getAll(){
        String sql = "SELECT *from InfoUser";
        List<InfoUser> infos = new ArrayList<>();
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone =rs.getString("phone");
                String address= rs.getString("address");
                String avatar =rs.getString("avatar");
                java.util.Date createdAt =rs.getDate("createdAt");
                java.util.Date updateAt = rs.getDate("updatedAt");
                InfoUser info = new InfoUser(id,name,email,phone,address,avatar,createdAt,updateAt);
                infos.add(info);
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return infos;
    }

    @Override
    public InfoUser getInfoUser(int id){
        String sql = "SELECT *from InfoUser where id=?";
        InfoUser info = new InfoUser();
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone =rs.getString("phone");
                String address= rs.getString("address");
                String avatar =rs.getString("avatar");
                java.util.Date createdAt =rs.getDate("createdAt");
                java.util.Date updateAt = rs.getDate("updatedAt");
                info = new InfoUser(id,name,email,phone,address,avatar,createdAt,updateAt);
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return info;
    }
}
