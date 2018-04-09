package be.ac.ulb.infof307.g10.models;


import be.ac.ulb.infof307.g10.db.DatabaseFacade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Entity
@NamedQueries({
        @NamedQuery(name = "Shop.findAll", query = "SELECT s FROM Shop s")
})
public class Shop implements Serializable {

	private static final long serialVersionUID = -0L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	private Integer id;

    @Column(unique = true)
	public String name;

	@ElementCollection(fetch = FetchType.EAGER)
	Map<Product,Integer> stock = new HashMap<>();

	// NEEDED BY JPA
	public Shop(){
	}

    public Shop(String name) {
        this.name = name;
        stock = new HashMap<Product, Integer>();
    }

    public Shop(String name, Map<Product, Integer> stock) {
        this.name = name;
        this.stock = stock;
    }

    public void addProduct(Product p, int quantity){
	    stock.put(p, quantity);
    }

    public void updateStock(Product p , int q){
        stock.put(p, q);
    }

    public int getQuantity(Product p){
	    return stock.get(p);
    }


    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stock=" + stock +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Product, Integer> getStock() {
        return stock;
    }

    public void setStock(Map<Product, Integer> stock) {
        this.stock = stock;
    }


}
