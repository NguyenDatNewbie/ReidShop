package reidshop.Entity;

public class CartItem {
	
	int id;
	int cartId;
	int productId;
	int count;
	int size;

	public CartItem() {
		// TODO Auto-generated constructor stub
	}

	public CartItem(int id, int cartId, int productId, int count, int size) {
		super();
		this.id = id;
		this.cartId = cartId;
		this.productId = productId;
		this.count = count;
		this.size = size;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}


}
