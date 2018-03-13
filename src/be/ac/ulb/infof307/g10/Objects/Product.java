package be.ac.ulb.infof307.g10.Objects;


public class Product {
	private Integer productId;
	private String productDesc;
	private Integer calories;
	private Integer sugar;
	private Integer proteins;
	private Integer fat;
	
	public Product(Integer Id){
		productId = Id;
	}
	
	// get	
	public String getProductDesc(){
		return productDesc;
	}
	
	public Integer getProductCalories(){
		return calories;
	}
	
	public Integer getProductSugar(){
		return sugar;
	}
	
	public Integer getProductProteins(){
		return proteins;
	}	
	
	public Integer getProductFat(){
		return fat;
	}

	// set
	public void setProductId(Integer Id){
		productId = Id;
	}
	
	public void setProductDesc(String Desc){
		productDesc = Desc;
	}
	
	public void setProductCalories(Integer Calories){
		calories = Calories;
	}
	
	public void setProductProteins(Integer Proteins){
		proteins = Proteins;
	}
	
	public void setProductSugar(Integer Sugar){
		sugar = Sugar;
	}

	public void setProductFat(Integer Fat){
		fat = Fat;
	}
}
