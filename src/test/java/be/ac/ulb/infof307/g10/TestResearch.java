package be.ac.ulb.infof307.g10;

import be.ac.ulb.infof307.g10.Objects.Product;
import be.ac.ulb.infof307.g10.Objects.Shop;
import be.ac.ulb.infof307.g10.Objects.User;
import be.ac.ulb.infof307.g10.Research;
import be.ac.ulb.infof307.g10.db.DatabaseFacade;
import junit.framework.TestCase;
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

//        DatabaseFacade.insertUser(new User("researchTestUser", "researchTestUser", null));

        DatabaseFacade.insertProduct(new Product("#Research 6 Apples", "Pink ladies",100.0, 200.0, 300.0, 400.0, 3.0));
        DatabaseFacade.insertProduct(new Product("#Research 6 Apples", "Jonagold",100.0, 200.0, 300.0, 400.0, 3.2));

        Shop s = new Shop("#Research Delhaize");
        s.addProduct(DatabaseFacade.getProduct("#Research 6 Apples", "Pink ladies"), 100);
        s.addProduct(DatabaseFacade.getProduct("#Research 6 Apples", "Jonagold"), 20);
        DatabaseFacade.insertShop(s);

        s = new Shop("#Research Carrefour");
        s.addProduct(DatabaseFacade.getProduct("#Research 6 Apples", "Pink ladies"), 10);
        DatabaseFacade.insertShop(s);

        s = new Shop("#Research Colruyt");
        s.addProduct(DatabaseFacade.getProduct("#Research 6 Apples", "Jonagold"), 300);
        DatabaseFacade.insertShop(s);

    }


    @Test
    public void testGetStoresWithProducts() {
        Research r = new Research();
        r.getStoreWithProducts(DatabaseFacade.getProducts("#Research 6 Apples"));
//        r.getStoreWithProducts(l);
    }

    @Test
    public void testGetStoresWithProduct() {
        Research r = new Research();
        r.getStoreWithProduct(DatabaseFacade.getProduct("#Research 6 Apples", "Pink ladies"));
    }

    @AfterClass
    public static void clean(){
        DatabaseFacade.deleteShop(DatabaseFacade.getShop("#Research Delhaize"));
        DatabaseFacade.deleteShop(DatabaseFacade.getShop("#Research Carrefour"));
        DatabaseFacade.deleteShop(DatabaseFacade.getShop("#Research Colruyt"));
        DatabaseFacade.deleteProduct(DatabaseFacade.getProduct("#Research 6 Apples", "Pink ladies"));
        DatabaseFacade.deleteProduct(DatabaseFacade.getProduct("#Research 6 Apples", "Jonagold"));
    }
}