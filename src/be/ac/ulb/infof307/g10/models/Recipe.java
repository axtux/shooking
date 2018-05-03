package be.ac.ulb.infof307.g10.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Entity
public class Recipe extends ModelObject {
	
	private static final long serialVersionUID = -0L;

	/**
	 * Name of the recipe
	 */
	private String name;
	
	/**
	 * Number of people for the recipe
	 */
	private int servings;
	
	/**
	 * Mapping between products and quantities of it
	 */
	@ElementCollection(fetch = FetchType.EAGER)
	private Map<Product,Float> ingredients ;
	
	/**
	 * List of different steps of the recipe
	 */
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> steps;
	
	@SuppressWarnings("unused") // NEEDED BY JPA
	private Recipe(){
		this("");
	}
	
	/**
	 * Constructor for a new Recipe
	 * @param name	Name of the Recipe
	 */
	public Recipe(String name) {
		this(name, 1);
	}
	
	/**
	 * Constructor for a new Recipe
	 * @param name	Name of the Recipe
	 * @param servings Number of people for the recipe
	 */
	public Recipe(String name, int servings){
		this(name, servings, new HashMap<>());
	}
	
	/**
	 * Constructor for a new Recipe
	 * @param name	Name of the Recipe
	 * @param servings Number of people for the recipe
	 * @param ingredients	HashMap of the ingredient (Product, Quantity)
	 */
	public Recipe(String name, int servings, Map<Product, Float> ingredients){
		this(name, servings, ingredients, new ArrayList<>());
	}
	
	/**
	 * Constructor for a new Recipe
	 * @param name	Name of the Recipe
	 * @param servings Number of people for the recipe
	 * @param ingredients	HashMap of the ingredient (Product, Quantity)
	 * @param steps		ArrayList of String represent the steps for the Recipe
	 */
	public Recipe(String name, int servings, Map<Product, Float> ingredients, ArrayList<String> steps) {
		if (name == null || ingredients == null || steps == null) {
			throw new NullPointerException();
		}
		this.setName(name);
		this.servings = servings;
		this.ingredients = ingredients;
		this.steps = steps;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Get ingredients
	 * @return Map of each ingredients to its quantity
	 */
	public Map<Product,Float> getAllIngredients(){
		return new HashMap<Product,Float>(ingredients);
	}
	
	/**
	 * Get steps
	 * @return List of steps
	 */
	public List<String> getAllSteps(){
		return new ArrayList<String>(steps);
	}
	
	/**
	 * Getter for a particular step
	 * @param index index of the step
	 * @return The i th step
	 */
	public String getStep(int index) throws IndexOutOfBoundsException{
		return steps.get(index);
	}
	
	/**
	 * Replace the i th step by s
	 * @param index	index of the step
	 * @param s	the new i th step
	 */
	public void setStep(int index, String s) throws IndexOutOfBoundsException {
		steps.set(index, s);
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
		String step = steps.remove(indexInit);
		steps.add(indexFinal, step);
	}
	
	/**
	 * Remove a step from the step list
	 * @param index	The index of the step
	 */
	public void removeStep(int index) throws IndexOutOfBoundsException {
		steps.remove(index);
	}
	
	/**
	 * Delete all steps
	 */
	public void clearSteps() {
		steps = new ArrayList<>();
	}
	
	/**
	 * Add an ingredient in the ingredients list.
	 * If the product is already present, the older quantity is erased by the new one
	 * @param product The new product
	 * @param quantity The quantity of the product needed in the recipe
	 */
	public void addIngredient(Product product , float quantity){
		float before = ingredients.getOrDefault(product, (float) 0);
		ingredients.put(product, before+quantity);
	}
	
	/**
	 * Remove the ingredient p if present
	 * @param p the ingredient to remove
	 */
	public void removeIngredient(Product p){
		ingredients.remove(p);
	}

	/**
	 * Delete all ingredients
	 */
	public void clearIngredients() {
		this.ingredients = new HashMap<>();
	}

	public int getServings(){
		return this.servings;
	}
	
	public void setServings(int servings){
		for(Product p: ingredients.keySet()) {
			ingredients.put(p, ingredients.get(p)*servings/this.servings);
		}
		this.servings = servings;
	}

}
