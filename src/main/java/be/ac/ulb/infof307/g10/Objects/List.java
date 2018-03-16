package be.ac.ulb.infof307.g10.Objects;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Entity
//@Table(name="T_LISTS")
public class List implements Serializable {

	private static final long serialVersionUID = -0L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Basic(optional = false)
	@OneToOne
	private User user;

	@Basic(optional = false)
	private Integer listId;

	@OneToMany
	private java.util.List<Product> productList;

	@Basic(optional = true)
	private Integer amount;

	//TODO - test me
    @ElementCollection
    Map<Product,Integer> quantity = new HashMap<>();



    // DO NOT DELETE ; NEEDED BY JPA !!!!!!!!!!!!
    public List(){
    }

    public List(User user, Integer listId, java.util.List<Product> productList, Integer amount, Map<Product, Integer> quantity) {
        this.user = user;
        this.listId = listId;
        this.productList = productList;
        this.amount = amount;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getListId() {
        return listId;
    }

    public void setListId(Integer listId) {
        this.listId = listId;
    }

    public java.util.List<Product> getProductList() {
        return productList;
    }

    public void setProductList(java.util.List<Product> productList) {
        this.productList = productList;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Map<Product, Integer> getQuantity() {
        return quantity;
    }

    public void setQuantity(Map<Product, Integer> quantity) {
        this.quantity = quantity;
    }
}
