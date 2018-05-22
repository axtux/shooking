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

	public static Recipe create(String name, int servings) {
		try {
			getByName(name);
			throw new ExistingException();
		} catch (NonExistingException e) {
			Recipe r = new Recipe(name, servings);
			AutoSaver.autosave(r);
			return r;
		}
	}

	public static Recipe getByName(String name) throws NonExistingException {
		try{
			Recipe r = Database.getOne(Recipe.class, "SELECT b FROM Recipe b WHERE b.name LIKE ?1", name);
			AutoSaver.autosave(r);
			return r;
		} catch (NoResultException e) {
			throw new NonExistingException(e);
		}
	}

	public static List<Recipe> getAll() {
		List<Recipe> lr = Database.getAll(Recipe.class);
		for (Recipe r : lr){
			AutoSaver.autosave(r);
		}
		return lr;
	}
	
}
