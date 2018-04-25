package be.ac.ulb.infof307.g10.models;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PRODUCT",
//        uniqueConstraints={ @UniqueConstraint(columnNames = {"NAME", "DESCRIPTION"})
        indexes = {@Index(name = "I_UNIQUE_NAME_X_DESCRIPTION",  columnList="NAME,DESCRIPTION", unique = true),
})
@NamedQueries({
		@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
})
public class Product implements Serializable {

    private static final long serialVersionUID = -0L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	private Integer id;

	@Column(name = "NAME")
	private String name; // example : apple

    @Column(name = "DESCRIPTION")
	private String description; // example pink ladies

	private Integer calories;

	private Integer sugar;

	private Integer proteins;

	private Integer fat;

	private Integer price;


	// NEEDED BY JPA
	public Product(){
	}
	
	public Product(Product p) {
		this(p.name, p.description, p.calories, p.sugar, p.proteins, p.fat, p.price);
	}

    public Product(String name, String description, Integer calories, Integer sugar, Integer proteins, Integer fat, Integer price) {
        this.name = name;
        this.description = description;
        this.calories = calories;
        this.sugar = sugar;
        this.proteins = proteins;
        this.fat = fat;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                ", sugar=" + sugar +
                ", proteins=" + proteins +
                ", fat=" + fat +
                ", price=" + price +
                '}';
    }
/**
 * Clone method for copying the maps using Products objects (e.g. Recipe.java)
 */
    public Product clone() {
    	return new Product(this);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Integer getSugar() {
        return sugar;
    }

    public void setSugar(Integer sugar) {
        this.sugar = sugar;
    }

    public Integer getProteins() {
        return proteins;
    }

    public void setProteins(Integer proteins) {
        this.proteins = proteins;
    }

    public Integer getFat() {
        return fat;
    }

    public void setFat(Integer fat) {
        this.fat = fat;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
