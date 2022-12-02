package reidshop.Entity;

import java.math.BigDecimal;
import java.util.Date;

public class Orders {
	int id;
	int userId;
	int storeId;
	int deliveryId;
	String address;
	String phone;
	int status;
	BigDecimal total_price;
	Date createdAt ;
	Date updatedAt;
	

	
	public Orders() {
		// TODO Auto-generated constructor stub
	}

	public Orders(int id, int userId, int storeId, int deliveryId, String address, String phone, int status,
			BigDecimal total_price, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.userId = userId;
		this.storeId = storeId;
		this.deliveryId = deliveryId;
		this.address = address;
		this.phone = phone;
		this.status = status;
		this.total_price = total_price;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public BigDecimal getTotal_price() {
		return total_price;
	}

	public void setTotal_price(BigDecimal total_price) {
		this.total_price = total_price;
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