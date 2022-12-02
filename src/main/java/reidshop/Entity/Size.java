package reidshop.Entity;

public class Size {
	int size;
	int product_id;

	
	public Size() {
		// TODO Auto-generated constructor stub
		super();
	}

	public Size(int size, int product_id) {
		super();
		this.size = size;
		this.product_id = product_id;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}



}
