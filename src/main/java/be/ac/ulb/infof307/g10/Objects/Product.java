package be.ac.ulb.infof307.g10.Objects;


import javax.persistence.*;
import java.io.Serializable;

@Entity
//@Table(name="T_PRODUCTS")
@NamedQueries({
		@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
})
public class Product implements Serializable {

    private static final long serialVersionUID = -0L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
//	@Column(name = "PRODUCT_ID")
	private Integer productId;

//	@Basic(optional = true)
//	@Column(name = "PRODUC_DESC")
	private String productDesc;

//	@Basic(optional = true)
//	@Column(name = "CALORIES")
	private Integer calories;

//	@Basic(optional = true)
//	@Column(name = "SUGAR")
	private Integer sugar;

//	@Basic(optional = true)
//	@Column(name = "PROTEINS")
	private Integer proteins;

//	@Basic(optional = true)
//	@Column(name = "FAT")
	private Integer fat;

	// DO NOT DELETE ; NEEDED BY JPA !!!!!!!!!!!!
	public Product(){
	}

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
