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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestDB {

    @BeforeClass
    public static void createDB(){

    }


    @Test
    public void test_0010_InsertUser() throws SQLiteException {

        DatabaseFacade.insertUser(new User("lala", "lala", null));
    }

    @Test(expected = RollbackException.class)
    public void test_0011_InsertUser_uniqueConstraintExecptionExpected() throws SQLiteException {
        DatabaseFacade.insertUser(new User("lala", "lala", null));
    }

    @Test
    public void test_0020_GetUser(){
        Assert.assertNotEquals(null, DatabaseFacade.getUser("lala"));
    }




//    @Test(expected = NoResultException.class)
//    public void test_0050_GetUser_noResultExceptionExpected(){
//        Assert.assertNotEquals(null, DatabaseFacade.getUser("lala"));
//    }


    @Test
    public void test_0060_CreateProduct(){
        DatabaseFacade.insertProduct(new Product("6 Apples", "Pink ladies",100.0, 200.0, 300.0, 400.0, 3.0));
        DatabaseFacade.insertProduct(new Product("6 Apples", "Jonagold",100.0, 200.0, 300.0, 400.0, 3.2));
    }

    @Test
    public void test_0070_GetProduct(){
        DatabaseFacade.getProduct("6 Apples", "Pink ladies");
    }


    @Test
    public void test_0072_GetProducts(){
        System.out.println(DatabaseFacade.getProducts("6 Apples"));
    }


    @Test
    public void test_0080_CreateShop(){
        Shop s = new Shop("Delhaize");
        s.addProduct(DatabaseFacade.getProduct("6 Apples", "Pink ladies"), 10);
        s.addProduct(DatabaseFacade.getProduct("6 Apples", "Jonagold"), 10);
        DatabaseFacade.insertShop(s);
    }

    @Test
    public void test_0090_GetShop(){
        Shop s = DatabaseFacade.getShop("Delhaize");
//        System.out.println(Arrays.asList(s.getStock()));

    }



    @Test
    public void test_0110_CreateList(){
        List l = new List();
        l.addProduct(DatabaseFacade.getProduct("6 Apples", "Pink ladies"), 1);
        l.addProduct(DatabaseFacade.getProduct("6 Apples", "Jonagold"), 2);
        DatabaseFacade.insertList(l);
        DatabaseFacade.getUser("lala").setList(l);
    }

//    @Test
//    public void test_0120_DeleteList(){
//        DatabaseFacade.deleteList(DatabaseFacade.getUser("lala").getList());
//    }

    @Test
    public void test_0990_DeleteUser(){
        DatabaseFacade.deleteUser((DatabaseFacade.getUser("lala")));
    }

    @Test(expected = NoResultException.class)
    public void test_0991_DeleteUser_noResultExceptionExpected(){
        DatabaseFacade.deleteUser((DatabaseFacade.getUser("lala")));
    }


    @Test
    public void test_0994_DeleteProduct(){
        DatabaseFacade.deleteProduct(DatabaseFacade.getProduct("6 Apples", "Pink ladies"));
        DatabaseFacade.deleteProduct(DatabaseFacade.getProduct("6 Apples", "Jonagold"));
    }


    @Test
    public void test_0998_DeleteShop(){
        DatabaseFacade.deleteShop(DatabaseFacade.getShop("Delhaize"));
    }





}
