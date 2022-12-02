package reidshop.Entity;

import java.math.BigDecimal;
import java.util.Date;

public class OrderItem {

	int id;
	int orderId;
	int productId;
	int count;
	BigDecimal price;
	Date createdAt;
	Date updatedAt;
	
	
	public OrderItem() {
		// TODO Auto-generated constructor stub
	}
	public OrderItem(int id, int orderId, int productId, int count, BigDecimal price, Date createdAt,
					 Date updatedAt) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.productId = productId;
		this.count = count;
		this.price = price;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
}
