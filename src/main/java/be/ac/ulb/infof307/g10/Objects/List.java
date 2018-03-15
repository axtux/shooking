package be.ac.ulb.infof307.g10.Objects;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="T_LISTS")
public class List implements Serializable {

	private static final long serialVersionUID = -0L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Basic(optional = false)
	@Column(name = "USER_ID")
	private Integer userId;

	@Basic(optional = false)
	@Column(name = "LIST_ID")
	private Integer listId;

	@Basic(optional = false)
	@Column(name = "PRODUCT_ID")
	private Integer productId;

	@Basic(optional = true)
	@Column(name = "AMOUNT")
	private Integer amount;


	// DO NOT DELETE ; NEEDED BY JPA !!!!!!!!!!!!
	public List(){
	}
	
	public List(Integer UserId, Integer ListId, Integer ProductId){
		userId = UserId;
		listId = ListId;
		productId = ProductId;
	}
	
	public Integer getAmount(){
		return amount;
	}

	public void setAmount(Integer Amount){
		amount = Amount;
	}
}
