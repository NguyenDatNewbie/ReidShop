package reidshop.DAO.Impl;

import reidshop.Connection.ConnectDB;
import reidshop.DAO.IStoreDAO;
import reidshop.Entity.Store;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StoreDAOImpl extends ConnectDB implements IStoreDAO {

    @Override
    public void Insert(Store store)
    {
        String sql = "Insert into Store Values(?,?,?)";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,store.getName());
            ps.setString(2,store.getAddress());
            ps.setDate(3,Date.valueOf(LocalDate.now()));
            ps.executeUpdate();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }


    @Override
    public void Update(Store store){
        String sql = "UPDATE  Store SET name=?, address=?, updatedAt=? where id = ?";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,store.getName());
            ps.setString(2,store.getAddress());
            ps.setDate(3, Date.valueOf(LocalDate.now())); // updateAt
            ps.setInt(4,store.getId());
            ps.executeUpdate();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public void Delete(int id){
        String sql = "Delete From Store where id=?";
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
    public List<Store> getAll(){
        String sql = "SELECT *from Store";
        List<Store> stores = new ArrayList<>();
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address= rs.getString("address");
                java.util.Date createdAt =rs.getDate("createdAt");
                java.util.Date updateAt = rs.getDate("updatedAt");
                Store store = new Store(id,name,address,createdAt,updateAt);
                stores.add(store);
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return stores;
    }

    @Override
    public Store get(int id){
        String sql = "SELECT *from Store  where id=?";
        Store store = new Store();
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                String address= rs.getString("address");
                java.util.Date createdAt =rs.getDate("createdAt");
                java.util.Date updateAt = rs.getDate("updatedAt");
               store = new Store(id,name,address,createdAt,updateAt);
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return store;
    }
}
