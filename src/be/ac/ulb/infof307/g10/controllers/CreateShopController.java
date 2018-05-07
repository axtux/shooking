package be.ac.ulb.infof307.g10.controllers;

import com.lynden.gmapsfx.javascript.object.LatLong;

import be.ac.ulb.infof307.g10.Main;
import be.ac.ulb.infof307.g10.models.Shop;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Controller for the CreateShop view
 */
public class CreateShopController {

    @FXML
    private TextField name;

    @FXML
    private TextField monday; //these are the schedules corresponding to each day
    @FXML
    private TextField tuesday;
    @FXML
    private TextField wedsnday;
    @FXML
    private TextField thursday;
    @FXML
    private TextField friday;
    @FXML
    private TextField saturday;
    @FXML
    private TextField sunday;
    private TextField[] schedule;
    
    public static LatLong sposition;
    private LatLong position;

    public CreateShopController() {
    	this.position = sposition;
    	if(position == null) {
    		throw new NullPointerException("position must not be null");
    	}
    }

    public void initialize() {
    	schedule = new TextField[]{monday, tuesday, wedsnday, thursday, friday, saturday, sunday};
    }
    /**
     * Construct the schedule of the shop
     */
    private String[] createSchedule(){
    	String[] defaultSchedule = Shop.defaultSchedule();
    	for(int i=0;i<7;i++){
    		//The user does not have to know all the schedule
    		if(!schedule[i].getText().isEmpty()){
    			defaultSchedule[i]=schedule[i].getText();
    		}
    	}
    	return defaultSchedule;
    }

    /**
     * Creation of the Shop in the database
     */
    @FXML
    void create() {
    	Shop.create(name.getText(), position.getLatitude(), position.getLongitude(),createSchedule());
		Main.getInstance().closeDialog();
		//TODO create an error label in the view and print an error message when the store already exists
    }

}

