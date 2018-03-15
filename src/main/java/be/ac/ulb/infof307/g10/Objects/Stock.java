package be.ac.ulb.infof307.g10.Objects;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
//@Table(name="T_STOCKS")
public class Stock implements Serializable {

	private static final long serialVersionUID = -0L;

	@Id
	@GeneratedValue
	private Long id;

	@Basic(optional = false)
//    @Column(name="SHOP_ID")
	@OneToMany
	private java.util.List<Shop> shop;

	@Basic(optional = false)
	@OneToMany
    private java.util.List<Product> product;

//    @Column(name="QUANTITY")
    private Integer quantity;

	// DO NOT DELETE ; NEEDED BY JPA !!!!!!!!!!!!
	public Stock(){
	}


	public Stock(List<Shop> shop, List<Product> product, Integer quantity) {
		this.shop = shop;
		this.product = product;
		this.quantity = quantity;
	}


	public List<Shop> getShop() {
		return shop;
	}

	public void setShop(List<Shop> shop) {
		this.shop = shop;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
