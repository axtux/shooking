package be.ac.ulb.infof307.g10;

import be.ac.ulb.infof307.g10.models.*;
import be.ac.ulb.infof307.g10.db.Database;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Research Tests
 * @author Benjamin Nicodeme
 *
 */

public class TestResearch {

    @BeforeClass
    public static void setUp() throws Exception {
        new Product("#Research 6 Apples (Pink ladies)", 1, "unit").save();
        new Product("#Research 6 Apples (Jonagold)", 1, "unit").save();

        Shop s = Shop.create("#Research Delhaize", 0.0, 0.0);
        s.getStock().addProduct(Database.getProduct("#Research 6 Apples (Pink ladies)"), 100);
        s.getStock().addProduct(Database.getProduct("#Research 6 Apples (Jonagold)"), 20);

        s = Shop.create("#Research Carrefour", 0.0, 0.0);
        s.getStock().addProduct(Database.getProduct("#Research 6 Apples (Pink ladies)"), 10);

        s = Shop.create("#Research Colruyt", 0.0, 0.0);
        s.getStock().addProduct(Database.getProduct("#Research 6 Apples (Jonagold)"), 300);

    }


    @Test
    public void test_0001_GetStoresWithProducts() {
    	List<Product> products = Database.getAllProducts();
    	Shop.getWithProducts(products);
    }

    @Test
    public void test_0002_GetStoresWithProduct() {
    	Product p = Database.getProduct("#Research 6 Apples (Pink ladies)");
    	Shop.getWithProduct(p);
    }

    @AfterClass
    public static void clean(){
        Database.delete(Database.getShop("#Research Delhaize"));
        Database.delete(Database.getShop("#Research Carrefour"));
        Database.delete(Database.getShop("#Research Colruyt"));
        Database.delete(Database.getProduct("#Research 6 Apples (Pink ladies)"));
        Database.delete(Database.getProduct("#Research 6 Apples (Jonagold)"));
    }
}