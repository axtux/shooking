package be.ac.ulb.infof307.g10.db;

import static org.junit.Assert.*;

import org.junit.Test;

import be.ac.ulb.infof307.g10.models.exceptions.NonExistingException;

public class TestRecipeDAO {

	@Test
	public void test_001_createRecipe() {
		Recipe r = RecipeDAO.createRecipe("#test createRecipe", 12);
		assertNotNull(r);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test_002_createRecipeException() {
		Recipe r = RecipeDAO.createRecipe("", -1);
		assertNull(r);
	}
	
	@Test(expected=NullPointerException.class)
	public void test_003_createRecipeException() {
		Recipe r = RecipeDAO.createRecipe("#test createRecipeException", 12, null, null);
		assertNull(r);
	}
	
	public static void createRecipe() {
		RecipeDAO.createRecipe("#test testingRecipe", 12);
	}
	
	@Test
	public void test_004_getRecipe() {
		Recipe r = RecipeDAO.getRecipe("#test testingRecipe");
		assertNotNull(r);
	}
	
	@Test(expected=NonExistingException.class)
	public void test_005_getRecipeException() {
		Recipe r = RecipeDAO.getRecipe("#test badRecipeName");
		assertNull(r);
	}
}
