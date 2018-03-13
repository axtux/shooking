package ListCourses;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class ListCourses {
    
    
	public SimpleStringProperty product = new SimpleStringProperty();
    public SimpleStringProperty quantite = new SimpleStringProperty();
    
   
    
    
    
    public String getNombre(){
        return product.get();
    }
    
    public String getApellido(){
        return quantite.get();
    }
    
    
    
}