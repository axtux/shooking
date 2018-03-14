package be.ac.ulb.infof307.g10.Objects;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="T_STOCKS")
public class Stock implements Serializable {

	private static final long serialVersionUID = -0L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Basic(optional = false)
    @Column(name="SHOP_ID")
	private Integer shopId;

//	@Basic(optional = true)
    @Column(name="PRODUCT_ID")
    private Integer productId;

//	@Basic(optional = true)
    @Column(name="QUANTITY")
    private Integer quantity;

	// DO NOT DELETE ; NEEDED BY JPA !!!!!!!!!!!!
	public Stock(){
	}
	
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
