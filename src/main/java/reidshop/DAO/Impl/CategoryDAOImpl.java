package reidshop.DAO.Impl;

import reidshop.Connection.ConnectDB;
import reidshop.DAO.ICategoryDAO;
import reidshop.Entity.Category;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl extends ConnectDB implements ICategoryDAO {
    @Override
    public void Insert(Category category)
    {
        String sql = "Insert into Category Values(?,?)";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,category.getName());
            ps.setDate(2, Date.valueOf(LocalDate.now()));
            ps.executeUpdate();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }


    @Override
    public void Update(Category category){
        String sql = "UPDATE  Category SET name=?, updatedAt=? where id = ?";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,category.getName());
            ps.setDate(2, Date.valueOf(LocalDate.now()));
            ps.setInt(3,category.getId());
            ps.executeUpdate();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public void Delete(int id){
        String sql = "Delete From Category where id=?";
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
    public List<Category> getAll(){
        String sql = "SELECT *from Category";
        List<Category> categories = new ArrayList<>();
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                java.util.Date createdAt =rs.getDate("createdAt");
                java.util.Date updateAt = rs.getDate("updatedAt");
                Category category = new Category(id,name,createdAt,updateAt);
                categories.add(category);
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return categories;
    }

    @Override
    public Category get(int id){
        String sql = "SELECT *from Category where id=?";
        Category category = new Category();
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                java.util.Date createdAt =rs.getDate("createdAt");
                java.util.Date updateAt = rs.getDate("updatedAt");
                category = new Category(id,name,createdAt,updateAt);
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return category;
    }
}
