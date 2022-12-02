package reidshop.Entity;

import java.util.Date;

public class Store {
	int id;
	String name;
	String address;
	Date createdAt;
	Date updateAt;
	
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public Store(int id, String name, String address, Date createdAt, Date updateAt) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.createdAt = createdAt;
		this.updateAt = updateAt;
	}

	public Store() {
		// TODO Auto-generated constructor stub
	}

}
