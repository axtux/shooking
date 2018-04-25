package be.ac.ulb.infof307.g10;

import be.ac.ulb.infof307.g10.db.Data;
import be.ac.ulb.infof307.g10.db.Database;
import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.Recipe;
import be.ac.ulb.infof307.g10.models.Shop;
import be.ac.ulb.infof307.g10.models.ShoppingList;
import be.ac.ulb.infof307.g10.models.User;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.persistence.NoResultException;
import javax.persistence.RollbackException;

import static org.junit.Assert.*;

import java.util.Arrays;

/**
 * The tests have to be executed in a certain order, so they are sorted by name and executed by name ascending
 * Some tests of this class do not have asserts beacause an exception make the test fail when it has to
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestDB {

    @BeforeClass
    public static void createDB (){
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


    @Test
    public void test_0010_InsertUser() {
        Database.insert(new User("#DB lala", "#DB lala", null));
    }

    @Test(expected = RollbackException.class)
    public void test_0011_InsertUser_uniqueConstraintExecptionExpected() {
        Database.insert(new User("#DB lala", "#DB lala", null));
    }

    @Test
    public void test_0020_GetUser(){
        Assert.assertNotEquals(null, Database.getUser("#DB lala"));
    }


    @Test(expected = NoResultException.class)
    public void test_0050_GetUser_noResultExceptionExpected(){
        Assert.assertNotEquals(null, Database.getUser("fzvsvsfvsfvsf"));
    }


    @Test
    public void test_0060_CreateProduct(){
        Database.insert(new Product("#DB 6 Apples", "Pink ladies",100, 200, 300, 400, 300));
        Database.insert(new Product("#DB 6 Apples", "Jonagold",100, 200, 300, 400, 320));
    }

    @Test(expected = RollbackException.class)
    public void test_0060_CreateProduct_uniqueConstraintExecptionExpected(){
        Database.insert(new Product("#DB 6 Apples", "Pink ladies",100, 200, 300, 400, 300));
        Database.insert(new Product("#DB 6 Apples", "Jonagold",100, 200, 300, 400, 320));
    }

    @Test
    public void test_0070_GetProduct(){
        Database.getProductFromNameAndDesc("#DB 6 Apples", "Pink ladies");
    }


    @Test
    public void test_0072_GetProducts(){
        Database.getProducts("#DB 6 Apples");
    }


    @Test
    public void test_0080_CreateShop(){
        Shop s = new Shop("#DB Delhaize", 0.0, 0.0);
        s.addProduct(Database.getProductFromNameAndDesc("#DB 6 Apples", "Pink ladies"), 10);
        s.addProduct(Database.getProductFromNameAndDesc("#DB 6 Apples", "Jonagold"), 10);
        Database.insert(s);
    }

    @Test
    public void test_0090_GetShop(){
        Database.getShop("#DB Delhaize");
    }

    @Test
    public void test_0091_updateShopStock(){
        Shop shop = Database.getShop("#DB Delhaize");

        Arrays.asList(shop.getStock());
        Product p = Database.getProductFromNameAndDesc("#DB 6 Apples", "Jonagold");
        int quantity = shop.getStock().get(Database.getProductFromNameAndDesc("#DB 6 Apples", "Jonagold"));

        shop.updateStock(p, quantity -3 );
        Database.update(shop);

        ////////////////////////

        Shop shopCheck = Database.getShop("#DB Delhaize");
        Product pCheck = Database.getProductFromNameAndDesc("#DB 6 Apples", "Jonagold");

        //shopCheck.getQuantity(pCheck);;
    }



    @Test
    public void test_0110_CreateList(){
        ShoppingList l = new ShoppingList();
        l.addProduct(Database.getProductFromNameAndDesc("#DB 6 Apples", "Pink ladies"), 1);
        l.addProduct(Database.getProductFromNameAndDesc("#DB 6 Apples", "Jonagold"), 2);
        Database.insert(l);
        Database.getUser("#DB lala").setShoppingList(l);
    }

//    @Test
//    public void test_0989_DeleteList(){
//        DatabaseFacade.deleteList(DatabaseFacade.getUser("#DB lala").getShoppingList());
//    }

    @Test
    public void test_0990_DeleteUser(){
        Database.delete((Database.getUser("#DB lala")));
    }

    @Test(expected = NoResultException.class)
    public void test_0991_DeleteUser_noResultExceptionExpected(){
        Database.delete((Database.getUser("#DB lala")));
    }


    @Test
    public void test_0994_DeleteProduct(){
        Database.delete(Database.getProductFromNameAndDesc("#DB 6 Apples", "Pink ladies"));
        Database.delete(Database.getProductFromNameAndDesc("#DB 6 Apples", "Jonagold"));
    }


    @Test
    public void test_0998_DeleteShop(){
        Database.delete(Database.getShop("#DB Delhaize"));
    }

    @Test
    public void test_1000_CreateRecipe() {
    	Recipe r = new Recipe("#test new recette", 1);
    	Database.insert(r);
    	
    }
    
    @Test
    public void test_1001_ModifyRecipe() {
    	Recipe r = new Recipe("#test modify recipe", 1);
    	Database.insert(r);
    	r.setName("#test new name");
    	r.addStep("#test step 1");
    	Database.update(r);
    	assertNotNull(Database.getRecipe("#test new name"));
    }
    
    @Test(expected = NoResultException.class)
    public void test_1002_DeleteRecipe() {
    	Database.insert(new Recipe("#test Delete Recipe", 1));
    	Recipe r = Database.getRecipe("#test Delete Recipe");
    	Database.delete(r);
    	Database.getRecipe("#test Delete Recipe"); // throw an exception
    }




}
