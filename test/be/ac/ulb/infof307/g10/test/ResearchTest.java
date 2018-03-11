package be.ac.ulb.infof307.g10.test;

import be.ac.ulb.infof307.g10.Research;
import junit.framework.TestCase;

import java.util.*;

/**
 * Research Tests
 * @author Benjamin Nicodeme
 *
 */

public class ResearchTest extends TestCase {

    private ArrayList <Object> l;
    private Object p;
    public void setUp() throws Exception {
        super.setUp();
        l = new ArrayList<>();
        p = new Object();
    }

    public void tearDown() throws Exception {
    }

    public void testGetStoreWithProducts() {
        Research r = new Research();
        r.getStoreWithProducts(l);
    }

    public void testGetStoreWithProduct() {
        Research r = new Research();
        r.getStoreWithProduct(p);
    }
}