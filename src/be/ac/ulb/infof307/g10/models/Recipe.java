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
	
	
	protected Recipe(){ // Needed by JPA
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
			throw new NullPointerException("one parameter is null");
		}
		if (name.trim().equals("")){
			throw new IllegalArgumentException("The name must not be empty");
		}
		if(servings<=0){
			throw new IllegalArgumentException("The servings must be > 0");
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
	
	public int getQuantity(Product ingredient) {
		return Math.round(ingredients.getOrDefault(ingredient, (float) 0));
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
	 * Replace the oldStep by newStep
	 * @param oldStep	Actual step to change
	 * @param newStep	New step
	 */
	public void setStep(String oldStep, String newStep) {
		int index = steps.indexOf(oldStep);
		setStep(index, newStep);
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
	public void moveStep(int indexInit , int indexFinal) throws IndexOutOfBoundsException{
		if (indexInit >= 0 && indexInit < steps.size() && indexFinal >= 0 && indexFinal < steps.size()) {
			String step = steps.remove(indexInit);
			steps.add(indexFinal, step);
		}
		else {
			throw new IndexOutOfBoundsException();
		}
	}
	
	/**
	 * Move up the index th step
	 * @param step	Initial step to move up
	 */
	public void moveUpStep(String step) throws IndexOutOfBoundsException {
		int index = steps.indexOf(step);
		moveStep(index, index-1);
	}
	
	/**
	 * Move down the index th step
	 * @param step	Initial step to move up
	 */
	public void moveDownStep(String step) throws IndexOutOfBoundsException {
		int index = steps.indexOf(step);
		moveStep(index, index+1);
	}
	
	/**
	 * Remove a step from the step list
	 * @param index	The index of the step
	 */
	public void removeStep(int index) throws IndexOutOfBoundsException {
		steps.remove(index);
	}
	
	public void removeStep(String step) {
		int index = steps.indexOf(step);
		removeStep(index);
	}
	
	/**
	 * Delete all steps
	 */
	public void clearSteps() {
		this.steps.clear();
	}
	
	/**
	 * Return true if the step is the first in the steps list
	 * @param step	The step to test
	 * @return	true is the step is the first (false otherwise)
	 */
	public boolean isFirst(String step) {
		int index = steps.indexOf(step);
		return index == 0;
	}
	
	/**
	 * Return true if the step is the last in the steps list
	 * @param step	The step to test
	 * @return	true is the step is the last (false otherwise)
	 */
	public boolean isLast(String step) {
		int index = steps.indexOf(step);
		return index == steps.size()-1;
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
	 * Modify the quantity of the selected product
	 * @param product	The product already in the ingredients list
	 * @param quantity	The new quantity of the product
	 */
	public void setIngredientQuantity(Product product, float quantity) {
		if (ingredients.containsKey(product)){
			ingredients.put(product, quantity);
		}
	}
	
	/**
	 * Remove the ingredient p if present
	 * @param p the ingredient to remove
	 */
	public void removeIngredient(Product p){
		ingredients.remove(p);
	}

	/**
	 * Get ingredients
	 * @return Map of each ingredients to its quantity
	 */
	public Map<Product,Float> getAllIngredients(){
		return new HashMap<Product,Float>(ingredients);
	}

	/**
	 * Delete all ingredients
	 */
	public void clearIngredients() {
		this.ingredients.clear();
	}

	public int getServings(){
		return this.servings;
	}

}
