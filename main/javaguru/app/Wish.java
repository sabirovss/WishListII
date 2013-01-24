package javaguru.app;

public class Wish {

	private Integer WID;
	private String myWish;
	private String price;
	
	private String shop;

	public Wish(){
	}

	public Integer getWID() {
		return WID;
	}

	public void setWID(Integer wID) {
		WID = wID;
	}

	public String getMyWish() {
		return myWish;
	}

	public void setMyWish(String myWish) {
		this.myWish = myWish;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getShop() {
		return shop;
	}

	public void setShop(String shop) {
		this.shop = shop;
	}
}
