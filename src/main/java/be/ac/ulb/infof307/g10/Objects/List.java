package be.ac.ulb.infof307.g10.Objects;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Entity
@NamedQueries({
        @NamedQuery(name = "List.findAll", query = "SELECT l FROM List l")
})
public class List implements Serializable {

	private static final long serialVersionUID = -0L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Double amountTotal = 0.0;

    @ElementCollection(fetch = FetchType.EAGER)
    Map<Product,Integer> products_x_quantity = new HashMap<>();



    // NEEDED BY JPA
    public List(){
        products_x_quantity = new HashMap<Product, Integer>();
    }

    public void addProduct(Product p, int quantity){
        products_x_quantity.put(p, quantity);
        amountTotal += p.getPrice()*quantity;
    }

    @Override
    public String toString() {
        return "List{" +
                "id=" + id +
                ", amountTotal=" + amountTotal +
                ", products_x_quantity=" + products_x_quantity +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmountTotal() {
        return amountTotal;
    }

    public void setAmountTotal(Double amountTotal) {
        this.amountTotal = amountTotal;
    }

    public Map<Product, Integer> getProducts_x_quantity() {
        return products_x_quantity;
    }

    public void setProducts_x_quantity(Map<Product, Integer> products_x_quantity) {
        this.products_x_quantity = products_x_quantity;
    }
}
