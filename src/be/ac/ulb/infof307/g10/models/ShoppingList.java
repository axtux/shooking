package be.ac.ulb.infof307.g10.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Entity
@NamedQueries({
        @NamedQuery(name = "ShoppingList.findAll", query = "SELECT l FROM ShoppingList l")
})
public class ShoppingList implements Serializable {


	private static final long serialVersionUID = -0L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Integer amountTotal = 0;
    @ElementCollection(fetch = FetchType.EAGER)
    Map<Product,Integer> productsAndAssociatedQuantity ;//= new HashMap<>();



    // NEEDED BY JPA
    public ShoppingList(){
        productsAndAssociatedQuantity = new HashMap<>();
    }

    public void addProduct(Product p, int quantity){
        productsAndAssociatedQuantity.put(p, quantity);
        amountTotal += p.getPrice()*quantity;
    }

    @Override
    public String toString() {
        return "ShoppingList{" +
                "id=" + id +
                ", amountTotal=" + amountTotal +
                ", productsAndAssociatedQuantity=" + productsAndAssociatedQuantity +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAmountTotal() {
        return amountTotal;
    }

    public void setAmountTotal(Integer amountTotal) {
        this.amountTotal = amountTotal;
    }

    public Map<Product, Integer> getProductsAndAssociatedQuantity() {
        return productsAndAssociatedQuantity;
    }

    public void setAllProductsAndQuantity(Map<Product, Integer> productsAndAssociatedQuantity) {
        this.productsAndAssociatedQuantity = productsAndAssociatedQuantity;
    }
}
