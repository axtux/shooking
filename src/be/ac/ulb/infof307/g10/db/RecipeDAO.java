package be.ac.ulb.infof307.g10.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import javax.persistence.NoResultException;

import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.Recipe;

public class RecipeDAO extends AbstractDAO {

	public static Recipe createRecipe(String name){
		return createRecipe(name, 1);
	}
	
	public static Recipe createRecipe(String name, int servings) {
		return createRecipe(name, servings, new HashMap<>());
	}
	
	public static Recipe createRecipe(String name, int servings, Map<Product, Float> ingredients) {
		return createRecipe(name, servings, ingredients, new ArrayList<>());
	}
	
	public static Recipe createRecipe(String name, int servings, Map<Product, Float> ingredients, List<String> steps) {
		Recipe r = new Recipe(name, servings, ingredients, steps);
		r.addObserver(SaverObserver.getInstance());
		return r;
	}

	public static Recipe getRecipe(String name) throws NoResultException {
		return GenericDatabase.getOne(Recipe.class, "SELECT b FROM Recipe b WHERE b.name LIKE ?1", name);
	}

	public static List<Recipe> getAllRecipes() {
		return GenericDatabase.getAll(Recipe.class);
	}
	
}
