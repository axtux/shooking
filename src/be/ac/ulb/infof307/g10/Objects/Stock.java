package be.ac.ulb.infof307.g10.Objects;


public class Stock {
	
	private Integer shopId;
	private Integer productId;
	private Integer quantity;
	
	public Stock(Integer ShopId, Integer ProductId){
		shopId = ShopId;
		productId = ProductId;
	}
	
	public Integer getQuantity(){
		return quantity;
	}

	public void setShopId(Integer ShopId){
		shopId = ShopId;
	}
	
	public void setProductId(Integer ProductId){
		productId = ProductId;
	}
	
	public void setQuantity(Integer Quantity){
		quantity = Quantity;
	}
}
