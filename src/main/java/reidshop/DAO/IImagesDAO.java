package reidshop.DAO;

import java.util.List;

import reidshop.Entity.Images;

public interface IImagesDAO {

	Images getByProductId(int productId);
	
	List<Images> getAllByProductId(int productId);
	
	List<Images> getAllDescByProductId(int productId);
}