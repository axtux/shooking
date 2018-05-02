package be.ac.ulb.infof307.g10;

import be.ac.ulb.infof307.g10.db.Data;
import be.ac.ulb.infof307.g10.db.Database;
import be.ac.ulb.infof307.g10.db.DatabaseTest;
import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.Recipe;
import be.ac.ulb.infof307.g10.models.Shop;
import be.ac.ulb.infof307.g10.models.ShoppingList;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.persistence.NoResultException;

import static org.junit.Assert.*;

import java.util.Arrays;

/**
 * The tests have to be executed in a certain order, so they are sorted by name and executed by name ascending
 * Some tests of this class do not have asserts because an exception make the test fail when it has to
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestDB {

    @BeforeClass
    public static void createDB (){
        DatabaseTest.beforeClass();
        Database.empty();
    }

    @Test
    public void test_0008_isDBempty(){
        Assert.assertTrue(Database.isEmpty());
    }

    @Test
    public void test_0009_fillDB(){
        Data.fillDB();
    }

    @Test(expected = NoResultException.class)
    public void test_0050_GetUser_noResultExceptionExpected(){
        Assert.assertNotEquals(null, Database.getUser("fzvsvsfvsfvsf"));
    }


    @Test
    public void test_0060_CreateProduct(){
    	new Product("#DB 6 Apples", 6, "unit").save();
    	new Product("#DB 7 Apples", 6, "unit").save();
    }

    @Test
    public void test_0070_GetProduct(){
        Database.getProduct("#DB 6 Apples");
    }


    @Test
    public void test_0072_GetProducts(){
        Database.getAllProducts();
    }


    @Test
    public void test_0080_CreateShop(){
        Shop s = Shop.create("#DB Delhaize", 0.0, 0.0);
        s.getStock().addProduct(Database.getProduct("#DB 6 Apples"), 10);
        s.save();
    }

    @Test
    public void test_0090_GetShop(){
        Database.getShop("#DB Delhaize");
    }

    @Test
    public void test_0091_updateShopStock(){
        Shop shop = Database.getShop("#DB Delhaize");

        Arrays.asList(shop.getStock());
        Product p = Database.getProduct("#DB 6 Apples");
        int quantity = shop.getStock().getQuantity(p);

        shop.getStock().setProduct(p, quantity -3 );
        shop.save();

        ////////////////////////

        Database.getShop("#DB Delhaize");
        Database.getProduct("#DB 6 Apples");

        //shopCheck.getQuantity(pCheck);;
    }


    @Test
    public void test_0110_CreateList(){
        ShoppingList l = new ShoppingList();
        l.addProduct(Database.getProduct("#DB 6 Apples"), 1);
        l.addProduct(Database.getProduct("#DB 6 Apples"), 2);
        l.save();
    }

    @Test(expected = NoResultException.class)
    public void test_0991_DeleteUser_noResultExceptionExpected(){
        Database.delete((Database.getUser("#DB lala")));
    }

    @Test
    public void test_0994_DeleteProduct(){
    	Database.delete(Database.getProduct("#DB 7 Apples"));
    }


    @Test
    public void test_0998_DeleteShop(){
        Database.delete(Database.getShop("#DB Delhaize"));
    }

    @Test
    public void test_1000_CreateRecipe() {
    	Recipe r = new Recipe("#test new recette", 1);
    	r.save();
    }
    
    @Test
    public void test_1001_ModifyRecipe() {
    	Recipe r = new Recipe("#test modify recipe", 1);
    	r.save();
    	r.setName("#test new name");
    	r.addStep("#test step 1");
    	r.save();
    	assertNotNull(Database.getRecipe("#test new name"));
    }
    
    @Test(expected = NoResultException.class)
    public void test_1002_DeleteRecipe() {
    	new Recipe("#test Delete Recipe", 1).save();
    	Recipe r = Database.getRecipe("#test Delete Recipe");
    	Database.delete(r);
    	Database.getRecipe("#test Delete Recipe"); // throw an exception
    }




}
