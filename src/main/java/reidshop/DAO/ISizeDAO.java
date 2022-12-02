package reidshop.DAO;

import java.util.List;

import reidshop.Entity.Size;

public interface ISizeDAO {

	void Insert(Size size);

	void Update(Size size);

	void Delete(int size, int product_id);

	List<Size> getSizeByProductId(int product_id);

	List<Size> getSizeBySize(int size);

}