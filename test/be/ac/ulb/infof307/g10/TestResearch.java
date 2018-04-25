package be.ac.ulb.infof307.g10;

import be.ac.ulb.infof307.g10.models.Research;
import be.ac.ulb.infof307.g10.models.*;
import be.ac.ulb.infof307.g10.db.Database;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;

/**
 * Research Tests
 * @author Benjamin Nicodeme
 *
 */

public class TestResearch {

    private static ArrayList <Object> l;
    private static Object p;

    @BeforeClass
    public static void setUp() throws Exception {
        l = new ArrayList<>();
        p = new Object();

        Database.insert(new Product("#Research 6 Apples", "Pink ladies",100, 200, 300, 400, 300));
        Database.insert(new Product("#Research 6 Apples", "Jonagold",100, 200, 300, 400, 320));

        Shop s = new Shop("#Research Delhaize", 0.0, 0.0);
        s.addProduct(Database.getProductFromNameAndDesc("#Research 6 Apples", "Pink ladies"), 100);
        s.addProduct(Database.getProductFromNameAndDesc("#Research 6 Apples", "Jonagold"), 20);
        Database.insert(s);

        s = new Shop("#Research Carrefour", 0.0, 0.0);
        s.addProduct(Database.getProductFromNameAndDesc("#Research 6 Apples", "Pink ladies"), 10);
        Database.insert(s);

        s = new Shop("#Research Colruyt", 0.0, 0.0);
        s.addProduct(Database.getProductFromNameAndDesc("#Research 6 Apples", "Jonagold"), 300);
        Database.insert(s);

    }


    @Test
    public void test_0001_GetStoresWithProducts() {
        Research r = new Research();
        r.getStoreWithProducts(Database.getProducts("#Research 6 Apples"));
    }

    @Test
    public void test_0002_GetStoresWithProduct() {
        Research r = new Research();
        r.getStoreWithProduct(Database.getProductFromNameAndDesc("#Research 6 Apples", "Pink ladies"));
    }

    @AfterClass
    public static void clean(){
        Database.delete(Database.getShop("#Research Delhaize"));
        Database.delete(Database.getShop("#Research Carrefour"));
        Database.delete(Database.getShop("#Research Colruyt"));
        Database.delete(Database.getProductFromNameAndDesc("#Research 6 Apples", "Pink ladies"));
        Database.delete(Database.getProductFromNameAndDesc("#Research 6 Apples", "Jonagold"));
    }
}