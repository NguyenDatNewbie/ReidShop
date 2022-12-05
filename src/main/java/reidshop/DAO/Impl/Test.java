/**
 * 
 */
package reidshop.DAO.Impl;

import java.util.List;

import reidshop.DAO.IImagesDAO;
import reidshop.DAO.IProductDAO;
import reidshop.Entity.Images;
import reidshop.Entity.Product;

/**
 * @author Administrator
 *
 */
public class Test {

	/**
	 * 
	 */
	public Test() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IProductDAO p = new ProductDAOImpl();
		IImagesDAO i = new ImagesDAOImpl();
		List<Product> pro = p.getSellingProduct(1);
//		List<Images> img = i.getByProductId(2);
	
//		for (Product p :pro
//		) {
////			System.out.println(data.getProduct_id());
////			System.out.println(data.getImg());
//		}
		
	}

}
