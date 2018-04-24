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

        Shop s = new Shop("#Research Delhaize", 0.0, 0.0);
        s.addProduct(DatabaseFacade.getProductFromNameAndDesc("#Research 6 Apples", "Pink ladies"), 100);
        s.addProduct(DatabaseFacade.getProductFromNameAndDesc("#Research 6 Apples", "Jonagold"), 20);
        DatabaseFacade.insert(s);

        s = new Shop("#Research Carrefour", 0.0, 0.0);
        s.addProduct(DatabaseFacade.getProductFromNameAndDesc("#Research 6 Apples", "Pink ladies"), 10);
        DatabaseFacade.insert(s);

        s = new Shop("#Research Colruyt", 0.0, 0.0);
        s.addProduct(DatabaseFacade.getProductFromNameAndDesc("#Research 6 Apples", "Jonagold"), 300);
        DatabaseFacade.insert(s);

    }


    @Test
    public void testGetStoresWithProducts() {
        Research r = new Research();
        r.getStoreWithProducts(DatabaseFacade.getAllProducts("#Research 6 Apples"));
//        r.getStoreWithProducts(l);
    }

    @Test
    public void testGetStoresWithProduct() {
        Research r = new Research();
        r.getStoreWithProduct(DatabaseFacade.getProductFromNameAndDesc("#Research 6 Apples", "Pink ladies"));
    }

    @AfterClass
    public static void clean(){
        DatabaseFacade.delete(DatabaseFacade.getShopFromName("#Research Delhaize"));
        DatabaseFacade.delete(DatabaseFacade.getShopFromName("#Research Carrefour"));
        DatabaseFacade.delete(DatabaseFacade.getShopFromName("#Research Colruyt"));
        DatabaseFacade.delete(DatabaseFacade.getProductFromNameAndDesc("#Research 6 Apples", "Pink ladies"));
        DatabaseFacade.delete(DatabaseFacade.getProductFromNameAndDesc("#Research 6 Apples", "Jonagold"));
    }
}