package reidshop.DAO.Impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import reidshop.Connection.ConnectDB;
import reidshop.DAO.IImagesDAO;
import reidshop.Entity.Images;

public class ImagesDAOImpl extends ConnectDB implements IImagesDAO {
	@Override
    public Images getByProductId(int productId){
    	
    	String sql = "Select TOP 1 *from Images where product_id = ?";
    	Images image = new Images();
		try {

			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,productId);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int image_id = rs.getInt("image_id");
				String img= rs.getString("img");
				image = new Images(image_id,img,productId);
			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return image;
    }
    
	@Override
    public List<Images> getAllByProductId(int productId){
        List<Images> imgs = new ArrayList<>();
    	String sql = "Select *from Images where product_id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,productId);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int image_id = rs.getInt("image_id");
				String img= rs.getString("img");
				Images image = new Images(image_id,img,productId);
				imgs.add(image);
			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return imgs;
    }
	
	@Override
    public List<Images> getAllDescByProductId(int productId){
        List<Images> imgs = new ArrayList<>();
    	String sql = "Select *from Images where product_id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,productId);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int image_id = rs.getInt("image_id");
				String img= rs.getString("img");
				Images image = new Images(image_id,img,productId);
				imgs.add(image);
			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return imgs;
    }
}
