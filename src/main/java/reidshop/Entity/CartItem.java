package reidshop.Entity;

public class CartItem {
	
	int id;
	int cartId;
	int productId;
	int count;
	
	Cart cart;
	Product product;
	public CartItem() {
		// TODO Auto-generated constructor stub
	}
	public CartItem(int id, int cartId, int productId, int count) {
		super();
		this.id = id;
		this.cartId = cartId;
		this.productId = productId;
		this.count = count;
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
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

}
