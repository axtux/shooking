package be.ac.ulb.infof307.g10.models.dao;

import java.util.List;

import javax.persistence.NoResultException;

import be.ac.ulb.infof307.g10.models.Recipe;
import be.ac.ulb.infof307.g10.models.database.Database;
import be.ac.ulb.infof307.g10.models.database.AutoSaver;
import be.ac.ulb.infof307.g10.models.exceptions.ExistingException;
import be.ac.ulb.infof307.g10.models.exceptions.NonExistingException;

/**
 * Data access object for {@link Recipe}
 */
final public class RecipeDAO {

	/**
	 * Avoid object creation
	 */
	private RecipeDAO() {
	}

	/**
	 * Create a recipe in the database
	 * @param name the name of the recipe
	 * @param servings the serving number
	 * @return the created recipe
	 */
	public static Recipe create(String name, int servings) {
		try {
			getByName(name);
			throw new ExistingException("A recipe with same name already exists");
		} catch (NonExistingException e) {
			Recipe r = new Recipe(name, servings);
			AutoSaver.autosave(r);
			return r;
		}
	}

	/**
	 * Research a recipe with a certain name inside the database.
	 * @param name the name of the recipe
	 * @return The recipe if a recipe with that name does exist. A NoResultException if not
	 */
	public static Recipe getByName(String name) throws NonExistingException {
		try{
			Recipe r = Database.getOne(Recipe.class, "SELECT b FROM Recipe b WHERE b.name LIKE ?1", name);
			AutoSaver.autosave(r);
			return r;
		} catch (NoResultException e) {
			throw new NonExistingException(e);
		}
	}
	/**
	 * Return all the existing recipes
	 * @return a list containing all the existing recipes
	 */
	public static List<Recipe> getAll() {
		List<Recipe> lr = Database.getAll(Recipe.class);
		for (Recipe r : lr){
			AutoSaver.autosave(r);
		}
		return lr;
	}
	
}
