package be.ac.ulb.infof307.g10.Objects;

import javax.persistence.*;
import java.io.Serializable;

@Entity
//@Table(name="T_LISTS")
public class List implements Serializable {

	private static final long serialVersionUID = -0L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Basic(optional = false)
//	@JoinColumn(name = "T_USERS")
	@OneToMany
	private java.util.List<User> user;

	@Basic(optional = false)
//	@Column(name = "LIST_ID")
	private Integer listId;

//	@JoinColumn(name = "T_PRODUCTS")
	@OneToMany
	private java.util.List<Product> productList;

	@Basic(optional = true)
//	@Column(name = "AMOUNT")
	private Integer amount;


	// DO NOT DELETE ; NEEDED BY JPA !!!!!!!!!!!!
	public List(){
	}

	public List(Integer listId, java.util.List<Product> productList, Integer amount) {
		this.listId = listId;
		this.productList = productList;
		this.amount = amount;
	}


	public Integer getAmount(){
		return amount;
	}

	public void setAmount(Integer Amount){
		amount = Amount;
	}
}
