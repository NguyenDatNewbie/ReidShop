/**
 * 
 */
package reidshop.DAO.Impl;

import java.util.List;

import reidshop.DAO.IProductDAO;
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
		Product pr = p.getProduct(1);
		pr.setName("Update");
		p.Update(pr);
		List<Product> pro = p.getSellingProduct();
		
	
		for (Product data :pro
		) {
			System.out.println(data.getId());
			System.out.println(data.getName());
		}
		System.out.println(pr.getId());
	}

}
