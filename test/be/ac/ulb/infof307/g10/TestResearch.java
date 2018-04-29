package be.ac.ulb.infof307.g10;

import be.ac.ulb.infof307.g10.models.Research;
import be.ac.ulb.infof307.g10.models.*;
import be.ac.ulb.infof307.g10.db.Database;
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
        Database.insert(new Product("#Research 6 Apples (Pink ladies)", "",100));
        Database.insert(new Product("#Research 6 Apples (Jonagold)", "",100));

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
        Research r = new Research();
        r.getStoreWithProducts(Database.getAllProducts());
    }

    @Test
    public void test_0002_GetStoresWithProduct() {
        Research r = new Research();
        r.getStoreWithProduct(Database.getProduct("#Research 6 Apples (Pink ladies)"));
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