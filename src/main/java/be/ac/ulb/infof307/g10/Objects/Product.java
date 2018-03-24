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
	private Integer productId;

	private String productDesc;

	private Integer calories;

	private Integer sugar;

	private Integer proteins;

	private Integer fat;


	// NEEDED BY JPA
	public Product(){
	}

	public Product(String productDesc, Integer calories, Integer sugar, Integer proteins, Integer fat) {
		this.productDesc = productDesc;
		this.calories = calories;
		this.sugar = sugar;
		this.proteins = proteins;
		this.fat = fat;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public Integer getCalories() {
		return calories;
	}

	public void setCalories(Integer calories) {
		this.calories = calories;
	}

	public Integer getSugar() {
		return sugar;
	}

	public void setSugar(Integer sugar) {
		this.sugar = sugar;
	}

	public Integer getProteins() {
		return proteins;
	}

	public void setProteins(Integer proteins) {
		this.proteins = proteins;
	}

	public Integer getFat() {
		return fat;
	}

	public void setFat(Integer fat) {
		this.fat = fat;
	}
}
