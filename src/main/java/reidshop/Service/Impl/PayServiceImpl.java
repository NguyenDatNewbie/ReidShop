package reidshop.Service.Impl;

import reidshop.DAO.*;
import reidshop.DAO.Impl.*;
import reidshop.Entity.*;

import java.math.BigDecimal;
import java.util.List;

public class PayServiceImpl {
    public  BigDecimal TotalPrice_Promotion_count(Product product, int count){

        return product.getPrice().multiply(BigDecimal.valueOf(count)).subtract
                (product.getPrice().multiply(BigDecimal.valueOf(product.getPromotion()/100.0)));
    }

    public  BigDecimal TotalPrice_Promotion_count(Integer productId, int count){
        IProductDAO productDAO = new ProductDAOImpl();
        
        Product product = productDAO.getProduct(productId);
        return product.getPrice().multiply(BigDecimal.valueOf(count)).subtract
                (product.getPrice().multiply(BigDecimal.valueOf(product.getPromotion()/100.0)));
    }
    
	public void Handle(String username,String address, String phone, Integer storeId,Integer deliveryId){
        ICartDAO iCartDAO = new CartDAOImpl();
        ICartItemDAO iCartItemDAO = new CartItemDAO();
        IOrderDAO iOrderDAO = new OrderDAOImpl();
        IOrderItemDAO iOrderItemDAO = new OrderItemDAOImpl();
        IDeliveryDAO iDeliveryDAO = new DeliveryDAOImpl();
        IProductDAO iProductDAO = new ProductDAOImpl();
        Delivery delivery = iDeliveryDAO.get(deliveryId);

        Cart cart = iCartDAO.getByUserName(username);
        BigDecimal total_price = iCartItemDAO.TotalPrice(cart).add(delivery.getPrice());
        Orders orders = new Orders(0,username,storeId,deliveryId,address,phone,0,total_price);
       
        List<CartItem> listCartItem = iCartItemDAO.getCartByCartId(cart.getId());
        System.out.println(listCartItem.size());
        if(listCartItem.size()!=0)
        {
        	 iOrderDAO.Insert(orders);
        	 for (CartItem cartItem: listCartItem){
                 Integer orderId = iOrderDAO.getId(username);
                 OrderItem orderItem = new OrderItem(0,orderId,cartItem.getProductId(),cartItem.getCount(),
                         cartItem.getSize(),TotalPrice_Promotion_count(cartItem.getProductId(),cartItem.getCount()),null,null);
                 iOrderItemDAO.Insert(orderItem);
                 Product product = iProductDAO.getProduct(cartItem.getProductId());
                 product.setSold(cartItem.getCount());
                 iProductDAO.Update(product);
             }
             cart.setComplete((byte)1);
             iCartDAO.Update(cart);
             cart.setComplete((byte)0);
             iCartDAO.Insert(cart);
        }
        
    }
}
