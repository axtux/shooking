package be.ac.ulb.infof307.g10.Objects;


public class Shop {
	private Integer shopId;
	private String shopDesc;
	public Shop(Integer Id){
		shopId = Id;
	}
	
	public String getShopDesc(){
		return shopDesc;
	}

	public void setShopId(Integer Id){
		shopId = Id;
	}
	
	public void setShopDesc(String Desc){
		shopDesc = Desc;
	}
}
