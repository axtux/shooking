package be.ac.ulb.infof307.g10.models.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import be.ac.ulb.infof307.g10.models.Recipe;
import be.ac.ulb.infof307.g10.models.dao.RecipeDAO;
import be.ac.ulb.infof307.g10.models.database.AbstractTestDatabase;
import be.ac.ulb.infof307.g10.models.database.Database;
import be.ac.ulb.infof307.g10.models.exceptions.ExistingException;
import be.ac.ulb.infof307.g10.models.exceptions.NonExistingException;

public class TestRecipeDAO extends AbstractTestDatabase {

	public static void createTestingRecipe() {
		RecipeDAO.create("#test testingRecipe", 12);
	}
	
	@Test
	public void createRecipe() {
		Recipe r = RecipeDAO.create("#test createRecipe", 12);
		assertNotNull(r);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void createRecipeIllegalArgumentExceptionException() {
		Recipe r = RecipeDAO.create("", -1);
		assertNull(r);
	}
	
	@Test(expected=ExistingException.class)
	public void createRecipeExistingException() {
		createTestingRecipe();
		Recipe r = RecipeDAO.create("#test testingRecipe", 12);
		assertNull(r);
	}
	
	@Test
	public void getRecipe() {
		createTestingRecipe();
		Recipe r = RecipeDAO.getByName("#test testingRecipe");
		assertNotNull(r);
	}
	
	@Test(expected=NonExistingException.class)
	public void getRecipeException() {
		Recipe r = RecipeDAO.getByName("#test badRecipeName");
		assertNull(r);
	}
	
	@Test
	public void autoSaveRecipe() {
		createTestingRecipe();
		Recipe r = RecipeDAO.getByName("#test testingRecipe");
		r.setName("#test newName");
		Database.close();
		r = RecipeDAO.getByName("#test newName"); // No exception
	}
}
