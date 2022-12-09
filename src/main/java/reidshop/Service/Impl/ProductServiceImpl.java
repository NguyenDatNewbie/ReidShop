package reidshop.Service.Impl;

import reidshop.DAO.IDeliveryDAO;
import reidshop.DAO.Impl.DeliveryDAOImpl;
import reidshop.Entity.Delivery;
import reidshop.Entity.Product;

import java.math.BigDecimal;

public class ProductServiceImpl {

	public ProductServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public BigDecimal TotalPrice_Promotion_count(Product product, int count, int deliId){
		IDeliveryDAO iDeliveryDAO = new DeliveryDAOImpl();

		if(deliId==0)
			return BigDecimal.valueOf(0);
		Delivery deli = iDeliveryDAO.get(deliId);
		return product.getPrice().multiply(BigDecimal.valueOf(count)).subtract
						(product.getPrice().multiply(BigDecimal.valueOf(product.getPromotion()/100.0)))
				.add(deli.getPrice());
	}

}
