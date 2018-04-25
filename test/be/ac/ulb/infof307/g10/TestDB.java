package be.ac.ulb.infof307.g10;

import be.ac.ulb.infof307.g10.db.Data;
import be.ac.ulb.infof307.g10.db.DatabaseFacade;
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
        DatabaseFacade.emptyDB();
    }

    @Test
    public void test_0008_isDBempty(){
        Assert.assertTrue(DatabaseFacade.isDBEmpty());
    }

    @Test
    public void test_0009_fillDB(){
        Data.fillDB();
    }


    @Test
    public void test_0010_InsertUser() {
        DatabaseFacade.insert(new User("#DB lala", "#DB lala", null));
    }

    @Test(expected = RollbackException.class)
    public void test_0011_InsertUser_uniqueConstraintExecptionExpected() {
        DatabaseFacade.insert(new User("#DB lala", "#DB lala", null));
    }

    @Test
    public void test_0020_GetUser(){
        Assert.assertNotEquals(null, DatabaseFacade.getUser("#DB lala"));
    }


    @Test(expected = NoResultException.class)
    public void test_0050_GetUser_noResultExceptionExpected(){
        Assert.assertNotEquals(null, DatabaseFacade.getUser("fzvsvsfvsfvsf"));
    }


    @Test
    public void test_0060_CreateProduct(){
        DatabaseFacade.insert(new Product("#DB 6 Apples", "Pink ladies",100, 200, 300, 400, 300));
        DatabaseFacade.insert(new Product("#DB 6 Apples", "Jonagold",100, 200, 300, 400, 320));
    }

    @Test(expected = RollbackException.class)
    public void test_0060_CreateProduct_uniqueConstraintExecptionExpected(){
        DatabaseFacade.insert(new Product("#DB 6 Apples", "Pink ladies",100, 200, 300, 400, 300));
        DatabaseFacade.insert(new Product("#DB 6 Apples", "Jonagold",100, 200, 300, 400, 320));
    }

    @Test
    public void test_0070_GetProduct(){
        DatabaseFacade.getProductFromNameAndDesc("#DB 6 Apples", "Pink ladies");
    }


    @Test
    public void test_0072_GetProducts(){
        DatabaseFacade.getProducts("#DB 6 Apples");
    }


    @Test
    public void test_0080_CreateShop(){
        Shop s = new Shop("#DB Delhaize", 0.0, 0.0);
        s.addProduct(DatabaseFacade.getProductFromNameAndDesc("#DB 6 Apples", "Pink ladies"), 10);
        s.addProduct(DatabaseFacade.getProductFromNameAndDesc("#DB 6 Apples", "Jonagold"), 10);
        DatabaseFacade.insert(s);
    }

    @Test
    public void test_0090_GetShop(){
        DatabaseFacade.getShop("#DB Delhaize");
    }

    @Test
    public void test_0091_updateShopStock(){
        Shop shop = DatabaseFacade.getShop("#DB Delhaize");

        Arrays.asList(shop.getStock());
        Product p = DatabaseFacade.getProductFromNameAndDesc("#DB 6 Apples", "Jonagold");
        int quantity = shop.getStock().get(DatabaseFacade.getProductFromNameAndDesc("#DB 6 Apples", "Jonagold"));

        shop.updateStock(p, quantity -3 );
        DatabaseFacade.update(shop);

        ////////////////////////

        Shop shopCheck = DatabaseFacade.getShop("#DB Delhaize");
        Product pCheck = DatabaseFacade.getProductFromNameAndDesc("#DB 6 Apples", "Jonagold");

        //shopCheck.getQuantity(pCheck);;
    }



    @Test
    public void test_0110_CreateList(){
        ShoppingList l = new ShoppingList();
        l.addProduct(DatabaseFacade.getProductFromNameAndDesc("#DB 6 Apples", "Pink ladies"), 1);
        l.addProduct(DatabaseFacade.getProductFromNameAndDesc("#DB 6 Apples", "Jonagold"), 2);
        DatabaseFacade.insert(l);
        DatabaseFacade.getUser("#DB lala").setShoppingList(l);
    }

//    @Test
//    public void test_0989_DeleteList(){
//        DatabaseFacade.deleteList(DatabaseFacade.getUser("#DB lala").getShoppingList());
//    }

    @Test
    public void test_0990_DeleteUser(){
        DatabaseFacade.delete((DatabaseFacade.getUser("#DB lala")));
    }

    @Test(expected = NoResultException.class)
    public void test_0991_DeleteUser_noResultExceptionExpected(){
        DatabaseFacade.delete((DatabaseFacade.getUser("#DB lala")));
    }


    @Test
    public void test_0994_DeleteProduct(){
        DatabaseFacade.delete(DatabaseFacade.getProductFromNameAndDesc("#DB 6 Apples", "Pink ladies"));
        DatabaseFacade.delete(DatabaseFacade.getProductFromNameAndDesc("#DB 6 Apples", "Jonagold"));
    }


    @Test
    public void test_0998_DeleteShop(){
        DatabaseFacade.delete(DatabaseFacade.getShop("#DB Delhaize"));
    }

    @Test
    public void test_1000_CreateRecipe() {
    	Recipe r = new Recipe("#test new recette", 1);
    	DatabaseFacade.insert(r);
    	
    }
    
    @Test
    public void test_1001_ModifyRecipe() {
    	Recipe r = new Recipe("#test modify recipe", 1);
    	DatabaseFacade.insert(r);
    	r.setName("#test new name");
    	r.addStep("#test step 1");
    	DatabaseFacade.update(r);
    	assertNotNull(DatabaseFacade.getRecipe("#test new name"));
    }
    
    @Test(expected = NoResultException.class)
    public void test_1002_DeleteRecipe() {
    	DatabaseFacade.insert(new Recipe("#test Delete Recipe", 1));
    	Recipe r = DatabaseFacade.getRecipe("#test Delete Recipe");
    	DatabaseFacade.delete(r);
    	DatabaseFacade.getRecipe("#test Delete Recipe"); // throw an exception
    }




}
