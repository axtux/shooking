package be.ac.ulb.infof307.g10.Objects;


import javax.persistence.*;
import java.io.Serializable;

@Entity
//@Table(name="T_SHOPS")
public class Shop implements Serializable {

	private static final long serialVersionUID = -0L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	private Integer shopId;

	@Basic(optional = true)
	public String shopDesc;

	// NEEDED BY JPA
	public Shop(){
	}

	public Shop(String shopDesc) {
		this.shopDesc = shopDesc;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public String getShopDesc() {
		return shopDesc;
	}

	public void setShopDesc(String shopDesc) {
		this.shopDesc = shopDesc;
	}
}
