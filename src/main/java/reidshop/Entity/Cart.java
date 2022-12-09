package reidshop.Entity;

public class Cart {

	int id;
	String username;
	int storeId;
	byte complete;
	
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}


	public Cart(int id, String username, int storeId, byte complete) {
		super();
		this.id = id;
		this.username = username;
		this.storeId = storeId;
		this.complete = complete;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public int getStoreId() {
		return storeId;
	}


	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}


	public byte getComplete() {
		return complete;
	}


	public void setComplete(byte complete) {
		this.complete = complete;
	}

	
	
	
}
