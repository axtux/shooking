package be.ac.ulb.infof307.g10.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
        @NamedQuery(name = "Recipe.findAll", query = "SELECT l FROM Recipe l")
})
public class Recipe implements Serializable {
	
	private static final long serialVersionUID = -0L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	/**
	 * Mapping between products and quantities of it
	 */
	private Map<Product,Float> ingredients ;
	
	/**
	 * List of different steps of the recipe
	 */
	private ArrayList<String> steps;
	
	/**
	 * Constructor needed by JPA
	 */
	public Recipe(){
		ingredients=new HashMap<>();
		steps=new ArrayList<>();
	}
	
	/**
	 * Return a copy of the ingredients and quantities map
	 * @return a deep copy of the ingredients and quantities map
	 */
	public HashMap<Product,Float> getAllIngredients(){
		//copying of the map
		HashMap<Product,Float> copy = new HashMap<>();
		for (Map.Entry<Product, Float> entry : ingredients.entrySet())
	    {
	       copy.put(entry.getKey().clone(), entry.getValue());
	    }
	    return copy;
	}

	
	/**
	 * Return all the steps
	 * @return An ArrayList containing all the steps
	 */
	public ArrayList<String> getAllSteps(){
		return (ArrayList<String>)steps.clone();
	}
	
	/**
	 * Getter for a particular step
	 * @param index index of the step
	 * @return The i th step
	 */
	public String getStep(int index) throws IndexOutOfBoundsException{
		try{
			return steps.get(index);
		}
		catch(IndexOutOfBoundsException e){
			throw e; //tmp
		}
	}
	
	/**
	 * Replace the i th step by s
	 * @param index	index of the step
	 * @param s	the new i th step
	 */
	public void modifyStep(int index, String s) throws IndexOutOfBoundsException {
		if (steps.size() < index){
			steps.set(index, s);
		}
		else{
			throw new IndexOutOfBoundsException();
		}
	}
	
	/**
	 * Add a step at the end of the recipe
	 * @param step the new last step
	 */
	public void addStep(String step){
		steps.add(step);
	}
	
	/**
	 *Takes the indexInit th step and move it to the indexFinal th place .
	 *All the concerned steps are swaped to the left or the right if necessary 
	 * @param indexInit The initial index of the step to move
	 * @param indexFinal The new index of the step to move
	 */
	public void moveStep(int indexInit , int indexFinal)throws IndexOutOfBoundsException{
		try {
			String step = steps.remove(indexInit);
			steps.add(indexFinal, step);
		} catch (IndexOutOfBoundsException e) {
			throw e;
		}
	}
	
	/**
	 * Remove a step from the step list
	 * @param index	The index of the step
	 */
	public void removeStep(int index) throws IndexOutOfBoundsException {
		if (steps.size() > index){
			steps.remove(index);
		}
		else {
			throw new IndexOutOfBoundsException();
		}
	}
	/**
	 * Add an ingredient in the ingredients list.
	 * If the product is already present, the older quantity is erased by the new one
	 * @param product The new product
	 * @param quantity The quantity of the product needed in the recipe
	 */
	public void addIngredient(Product product , float quantity){
		ingredients.put(product, quantity);
	}
	
	/**
	 * Remove the ingredient p if present
	 * @param p the ingredient to remove
	 */
	public void removeIngredient(Product p){
		ingredients.remove(p);
	}
	
	
	
}
