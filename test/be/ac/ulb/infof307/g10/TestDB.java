package be.ac.ulb.infof307.g10;

import be.ac.ulb.infof307.g10.models.*;
import be.ac.ulb.infof307.g10.db.DatabaseFacade;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.sqlite.SQLiteException;

import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import java.util.Arrays;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestDB {

    @BeforeClass
    public static void createDB (){
        DatabaseFacade.empyDB();
    }
    

    @Test
    public void test_0009_fillDB(){
        DatabaseFacade.fillDB();
    }


    @Test
    public void test_0010_InsertUser() {
        DatabaseFacade.insert(new User("#DB lala", "#DB lala", null));
    }

    @Test(expected = RollbackException.class)
    public void test_0011_InsertUser_uniqueConstraintExecptionExpected() throws SQLiteException {
        DatabaseFacade.insert(new User("#DB lala", "#DB lala", null));
    }

    @Test
    public void test_0020_GetUser(){
        Assert.assertNotEquals(null, DatabaseFacade.getUserFromUsername("#DB lala"));
    }



    @Test(expected = NoResultException.class)
    public void test_0050_GetUser_noResultExceptionExpected(){
        Assert.assertNotEquals(null, DatabaseFacade.getUserFromUsername("fzvsvsfvsfvsf"));
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
        System.out.println(DatabaseFacade.getAllProducts("#DB 6 Apples"));
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
        DatabaseFacade.getShopFromName("#DB Delhaize");


    }

    @Test
    public void test_0091_updateShopStock(){
        Shop shop = DatabaseFacade.getShopFromName("#DB Delhaize");

        System.out.println(Arrays.asList(shop.getStock()));
        Product p = DatabaseFacade.getProductFromNameAndDesc("#DB 6 Apples", "Jonagold");
        int quantity = shop.getStock().get(DatabaseFacade.getProductFromNameAndDesc("#DB 6 Apples", "Jonagold"));

        shop.updateStock(p, quantity -3 );
        DatabaseFacade.update(shop);

        ////////////////////////

        Shop shopCheck = DatabaseFacade.getShopFromName("#DB Delhaize");
        Product pCheck = DatabaseFacade.getProductFromNameAndDesc("#DB 6 Apples", "Jonagold");

        System.out.println(shopCheck.getQuantity(pCheck));
        System.out.println(shopCheck);
    }



    @Test
    public void test_0110_CreateList(){
        ShoppingList l = new ShoppingList();
        l.addProduct(DatabaseFacade.getProductFromNameAndDesc("#DB 6 Apples", "Pink ladies"), 1);
        l.addProduct(DatabaseFacade.getProductFromNameAndDesc("#DB 6 Apples", "Jonagold"), 2);
        DatabaseFacade.insert(l);
        DatabaseFacade.getUserFromUsername("#DB lala").setShoppingList(l);
    }

//    @Test
//    public void test_0989_DeleteList(){
//        DatabaseFacade.deleteList(DatabaseFacade.getUserFromUsername("#DB lala").getShoppingList());
//    }

    @Test
    public void test_0990_DeleteUser(){
        DatabaseFacade.delete((DatabaseFacade.getUserFromUsername("#DB lala")));
    }

    @Test(expected = NoResultException.class)
    public void test_0991_DeleteUser_noResultExceptionExpected(){
        DatabaseFacade.delete((DatabaseFacade.getUserFromUsername("#DB lala")));
    }


    @Test
    public void test_0994_DeleteProduct(){
        DatabaseFacade.delete(DatabaseFacade.getProductFromNameAndDesc("#DB 6 Apples", "Pink ladies"));
        DatabaseFacade.delete(DatabaseFacade.getProductFromNameAndDesc("#DB 6 Apples", "Jonagold"));
    }


    @Test
    public void test_0998_DeleteShop(){
        DatabaseFacade.delete(DatabaseFacade.getShopFromName("#DB Delhaize"));
    }





}
