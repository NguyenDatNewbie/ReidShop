package reidshop.Entity;

public class Cart {

	int id;
	int userId;
	int storeId;
	byte complete;
	
	InfoUser user;
	Store store;
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(int id, int userId, int storeId, byte complete) {
		super();
		this.id = id;
		this.userId = userId;
		this.storeId = storeId;
		this.complete = complete;
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

	public byte getComplete() {
		return complete;
	}

	public void setComplete(byte complete) {
		this.complete = complete;
	}

	public InfoUser getUser() {
		return user;
	}

	public void setUser(InfoUser user) {
		this.user = user;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}
	
	
}
