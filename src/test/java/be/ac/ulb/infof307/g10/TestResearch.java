package be.ac.ulb.infof307.g10;

import be.ac.ulb.infof307.g10.models.Research;
import be.ac.ulb.infof307.g10.models.*;
import be.ac.ulb.infof307.g10.db.DatabaseFacade;
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

        DatabaseFacade.insert(new Product("#Research 6 Apples", "Pink ladies",100, 200, 300, 400, 300));
        DatabaseFacade.insert(new Product("#Research 6 Apples", "Jonagold",100, 200, 300, 400, 320));

        Shop s = new Shop("#Research Delhaize");
        s.addProduct(DatabaseFacade.getProduct("#Research 6 Apples", "Pink ladies"), 100);
        s.addProduct(DatabaseFacade.getProduct("#Research 6 Apples", "Jonagold"), 20);
        DatabaseFacade.insert(s);

        s = new Shop("#Research Carrefour");
        s.addProduct(DatabaseFacade.getProduct("#Research 6 Apples", "Pink ladies"), 10);
        DatabaseFacade.insert(s);

        s = new Shop("#Research Colruyt");
        s.addProduct(DatabaseFacade.getProduct("#Research 6 Apples", "Jonagold"), 300);
        DatabaseFacade.insert(s);

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
        DatabaseFacade.delete(DatabaseFacade.getShop("#Research Delhaize"));
        DatabaseFacade.delete(DatabaseFacade.getShop("#Research Carrefour"));
        DatabaseFacade.delete(DatabaseFacade.getShop("#Research Colruyt"));
        DatabaseFacade.delete(DatabaseFacade.getProduct("#Research 6 Apples", "Pink ladies"));
        DatabaseFacade.delete(DatabaseFacade.getProduct("#Research 6 Apples", "Jonagold"));
    }
}