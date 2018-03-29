package be.ac.ulb.infof307.g10;

import be.ac.ulb.infof307.g10.db.DatabaseFacade;
import be.ac.ulb.infof307.g10.models.User;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestDB {

    @BeforeClass
    public static void createDB(){

    }


    @Test
    public void testInsertUser(){
        Assert.assertNotEquals(null, DatabaseFacade.insertUser(new User("lala", "lala", null)));
    }

    @Test
    public void testGetUser(){
        Assert.assertNotEquals(null, DatabaseFacade.getUser("lala"));
    }

    @Test
    public void testDeleteUser(){
        Assert.assertNotEquals(null,  DatabaseFacade.deleteUser((DatabaseFacade.getUser("lala"))));
    }


}
