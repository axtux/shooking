package be.ac.ulb.infof307.g10.models.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.NoResultException;

import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.Recipe;
import be.ac.ulb.infof307.g10.models.database.Database;
import be.ac.ulb.infof307.g10.models.database.SaverObserver;
import be.ac.ulb.infof307.g10.models.exceptions.ExistingException;
import be.ac.ulb.infof307.g10.models.exceptions.NonExistingException;

public class RecipeDAO {

	public static Recipe createRecipe(String name){
		return createRecipe(name, 1);
	}
	
	public static Recipe createRecipe(String name, int servings) {
		return createRecipe(name, servings, new HashMap<>());
	}
	
	public static Recipe createRecipe(String name, int servings, Map<Product, Float> ingredients) {
		return createRecipe(name, servings, ingredients, new ArrayList<>());
	}
	
	public static Recipe createRecipe(String name, int servings, Map<Product, Float> ingredients, List<String> steps) throws ExistingException {
		try {
			getRecipe(name);
			throw new ExistingException();
		} catch (NonExistingException e) {
			Recipe r = new Recipe(name, servings, ingredients, steps);
			r.addObserver(SaverObserver.getInstance());
			return r;
		}
	}

	public static Recipe getRecipe(String name) throws NonExistingException {
		try{
			Recipe r = Database.getOne(Recipe.class, "SELECT b FROM Recipe b WHERE b.name LIKE ?1", name);
			r.addObserver(SaverObserver.getInstance());
			return r;
		} catch (NoResultException e) {
			throw new NonExistingException(e);
		}
	}

	public static List<Recipe> getAllRecipes() throws NonExistingException {
		List<Recipe> lr = Database.getAll(Recipe.class);
		for (Recipe r : lr){
			r.addObserver(SaverObserver.getInstance());
		}
		return lr;
	}
	
}
