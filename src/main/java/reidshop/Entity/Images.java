package reidshop.Entity;

public class Images {
	int image_id ;
    String img;
    int product_id;
    public Images() {}
	public Images(int image_id, String img, int product_id) {
		super();
		this.image_id = image_id;
		this.img = img;
		this.product_id = product_id;
	}
	public int getImage_id() {
		return image_id;
	}
	public void setImage_id(int image_id) {
		this.image_id = image_id;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
    
}
