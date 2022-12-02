package reidshop.Entity;

import java.util.Date;

public class Delivery {

	int id;
	String name;
	String phone;
	int status;
	Date createdAt;
	Date updateAt;
	
	public Delivery() {
		// TODO Auto-generated constructor stub
		super();
	}

	public Delivery(int id, String name, String phone, int status, Date createdAt, Date updateAt) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.status = status;
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
