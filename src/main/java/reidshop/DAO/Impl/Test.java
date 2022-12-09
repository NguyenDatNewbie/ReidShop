/**
 * 
 */
package reidshop.DAO.Impl;

import java.util.List;

import reidshop.DAO.ICartDAO;
import reidshop.DAO.ICartItemDAO;
import reidshop.DAO.IDeliveryDAO;
import reidshop.DAO.IImagesDAO;
import reidshop.DAO.IInfoUserDAO;
import reidshop.DAO.IOrderDAO;
import reidshop.DAO.IProductDAO;
import reidshop.Entity.Cart;
import reidshop.Entity.CartItem;
import reidshop.Entity.Delivery;
import reidshop.Entity.Images;
import reidshop.Entity.InfoUser;
import reidshop.Entity.Product;
import reidshop.Service.Impl.PayServiceImpl;

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
	
//		IInfoUserDAO infoUserDAO = new InfoUserDAOImpl();
//		InfoUser infoUser = new InfoUser(0,"Nguyen Huu Dat","nguyenhuudat@gmail.com","0942541256","23123123","https://e7.pngegg.com/pngimages/647/460/png-clipart-computer-icons-open-person-family-icon-black-silhouette-black.png");
//		try {infoUserDAO.Insert(infoUser);}
//		catch(Exception ex){
//			ex.printStackTrace();
//		}
//		ICartDAO cartDAO = new CartDAOImpl();
//		IImagesDAO ImagesDAO = new ImagesDAOImpl();
//		IProductDAO productDAO = new ProductDAOImpl();
//		ICartItemDAO cartItemDAO = new CartItemDAO();
//		Cart cart = cartDAO.getByUserName("nhd@gmail.com");
//		List<CartItem> listCart = cartItemDAO.getCartByCartId(cart.getId());
//
//		for(CartItem item: listCart) {
//			System.out.println(item.getProductId());
//			System.out.println(productDAO.getProduct(item.getProductId()));
//		}
		
//		IOrderDAO i = new OrderDAOImpl();
//		System.out.println(i.getId("nhd@gmail.com"));
//		PayServiceImpl payService = new PayServiceImpl();
//		payService.Handle("nhd@gmail.com","ln","032",1,1);
		IDeliveryDAO deliveryDAO = new DeliveryDAOImpl();
		Delivery delivery = deliveryDAO.get(1);
		System.out.println(delivery.getName());
//		List<Images> img = i.getByProductId(2);
	
//		for (Product p :pro
//		) {
////			System.out.println(data.getProduct_id());
////			System.out.println(data.getImg());
//		}
		
	}

}
