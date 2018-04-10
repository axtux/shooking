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

    private String mondayTime;
    private String tuesdayTime;
    private String wednesdayTime;
    private String thursdayTime;
    private String fridayTime;
    private String saturdayTime;
    private String sundayTime;
    
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
        this.mondayTime = "CLOSED";
        this.tuesdayTime = "CLOSED";
        this.wednesdayTime = "CLOSED";
        this.thursdayTime = "CLOSED";
        this.fridayTime = "CLOSED";
        this.saturdayTime = "CLOSED";
        this.sundayTime = "CLOSED";
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Shop(String name, Map<Product, Integer> stock, double latitude, double longitude) {
        this.name = name;
        this.stock = stock;
        this.mondayTime = "CLOSED";
        this.tuesdayTime = "CLOSED";
        this.wednesdayTime = "CLOSED";
        this.thursdayTime = "CLOSED";
        this.fridayTime = "CLOSED";
        this.saturdayTime = "CLOSED";
        this.sundayTime = "CLOSED";
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

    public String getMondayTime() {
    	return this.mondayTime;
    }
    
    public String getTuesdayTime() {
    	return this.tuesdayTime;
    }
    
    public String getWednesdayTime() {
    	return this.wednesdayTime;
    }
    
    public String getThursdayTime() {
    	return this.thursdayTime;
    }
    
    public String getFridayTime() {
    	return this.fridayTime;
    }
    
    public String getSaturdayTime() {
    	return this.saturdayTime;
    }
    
    public String getSundayTime() {
    	return this.sundayTime;
    }
    
    public void setSchedule(String monday, String tuesday, String wednesday, String thursday, String friday, String saturday, String sunday){
        this.mondayTime = monday;
        this.tuesdayTime = tuesday;
        this.wednesdayTime = wednesday;
        this.thursdayTime = thursday;
        this.fridayTime = friday;
        this.saturdayTime = saturday;
        this.sundayTime = sunday;
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
