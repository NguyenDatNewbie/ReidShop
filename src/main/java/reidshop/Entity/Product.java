package reidshop.Entity;

import java.math.BigDecimal;
import java.util.Date;

public class Product {

	int id;
	String name;
	String description;
	BigDecimal price;
	int promotion;
	int quantity;
	int sold;
	int category_id;
	Date createdAt;
	Date updateAt;
	Category category;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int id, String name, String description, BigDecimal price, int promotion, int quantity, int sold,
			int category_id) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.promotion = promotion;
		this.quantity = quantity;
		this.sold = sold;
		this.category_id = category_id;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getPromotion() {
		return promotion;
	}

	public void setPromotion(int promotion) {
		this.promotion = promotion;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getSold() {
		return sold;
	}
	public void setSold(int sold) {
		this.sold = sold;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
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
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	public BigDecimal Tich ( int a, BigDecimal b ) {
		return BigDecimal.valueOf( a ).multiply( b );
	}
}
