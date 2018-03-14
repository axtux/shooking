package be.ac.ulb.infof307.g10.Objects;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="T_SHOPS")
public class Shop implements Serializable {

	private static final long serialVersionUID = -0L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SHOP_ID")
	private Integer shopId;

	@Basic(optional = true)
	@Column(name = "SHOP_DESC")
	public String shopDesc;

	// DO NOT DELETE ; NEEDED BY JPA !!!!!!!!!!!!
	public Shop(){
	}

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
