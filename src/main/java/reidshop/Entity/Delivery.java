package reidshop.Entity;

import java.math.BigDecimal;
import java.util.Date;

public class Delivery {

	int id;
	String name;

	BigDecimal price;
	
	Date createdAt;
	Date updateAt;
	
	public Delivery() {
		// TODO Auto-generated constructor stub
		super();
	}

	public Delivery(int id, String name, BigDecimal price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Delivery(int id, String name, BigDecimal price, Date createdAt, Date updateAt) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.createdAt = createdAt;
		this.updateAt = updateAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	
}
