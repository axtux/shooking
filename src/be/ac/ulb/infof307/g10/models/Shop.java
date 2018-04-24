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
    
    private String[] schedule;
    
    private double latitude;
    private double longitude;
    	// TODO
    	// maybe change to GMapsFX.LatLong object when import in project
    
	@ElementCollection(fetch = FetchType.EAGER)
	Map<Product,Integer> stock = new HashMap<>();

	// NEEDED BY JPA
	public Shop(){
	}

    public Shop(String name, double latitude, double longitude) {
        this.name = name;
        this.stock = new HashMap<Product, Integer>();
        this.schedule = new String[7];
        this.schedule[0] = "CLOSED";
        this.schedule[1] = "CLOSED";
        this.schedule[2] = "CLOSED";
        this.schedule[3] = "CLOSED";
        this.schedule[4] = "CLOSED";
        this.schedule[5] = "CLOSED";
        this.schedule[6] = "CLOSED";
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Shop(String name, Map<Product, Integer> stock, double latitude, double longitude) {
        this.name = name;
        this.stock = stock;
        this.schedule = new String[7];
        this.schedule[0] = "CLOSED";
        this.schedule[1] = "CLOSED";
        this.schedule[2] = "CLOSED";
        this.schedule[3] = "CLOSED";
        this.schedule[4] = "CLOSED";
        this.schedule[5] = "CLOSED";
        this.schedule[6] = "CLOSED";
        this.latitude = latitude;
        this.longitude = longitude;
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

    /**
     * Return the opening time, in String format, of the chosen day.
     * 0 for Monday to 6 for Sunday.
     * Return an empty String if the number of the day was incorrect.
     * Throw an IndexOutOfBoundsException if the day number is incorrect.
     * 
     * @param day	The day represent with an Integer (0 to 6 for Monday to Sunday)
     * @return		The opening time in String format, or an empty String
     */
    public String getSchedule(int day) throws IndexOutOfBoundsException {
    	if (0 <= day && day < this.schedule.length){
    		return this.schedule[day];
    	}
    	throw new IndexOutOfBoundsException();
    }
    
    /**
     * Change the opening time of the day number "day".
     * 0 for Monday to 6 for Sunday.
     * Throw an IndexOutOfBoundsException if the day number is incorrect.
     * 
     * @param day			The day represent with an Integer (0 to 6 for Monday to Sunday)
     * @param newSchedule	The new opening time for this day
     */
    public void setSchedule(int day, String newSchedule) throws IndexOutOfBoundsException {
        if (0 <= day && day < this.schedule.length){
        	this.schedule[day] = newSchedule;
        } else {
        	throw new IndexOutOfBoundsException();
        }
    }
    
    public double getLatitude() {
    	return this.latitude;
    }
    
    public double getLongitude() {
    	return this.longitude;
    }
    
    public void setPosition(double latitude, double longitude) {
    	this.latitude = latitude;
    	this.longitude = longitude;
    }

}
