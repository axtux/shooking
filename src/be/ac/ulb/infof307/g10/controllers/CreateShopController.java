package be.ac.ulb.infof307.g10.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.lynden.gmapsfx.javascript.object.LatLong;

import be.ac.ulb.infof307.g10.Main;
import be.ac.ulb.infof307.g10.models.Shop;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
/**
 * Controller for the CreateShop view
 */
public class CreateShopController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField name;

    @FXML
    private TextField monday;

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

    @FXML
    private Button creation;
    
    /**
     * Construct an array with the schedule text fields
     * @return an array with the 7 schedule text fields
     */
    private TextField[] getTextFields(){
    	TextField[] textFields = new TextField[7];
    	textFields[0]= monday;
    	textFields[1]= tuesday;
    	textFields[2]= wedsnday;
    	textFields[3]= thursday;
    	textFields[4]= friday;
    	textFields[5]= saturday;
    	textFields[6]= sunday;
    	return textFields;
    }
    
    /**
     * Construct the schedule of the shop
     */
    private String[] createSchedule(){	
    	TextField[] textFields=getTextFields();
    	String[] schedule = Shop.defaultSchedule();
    	for(int i=0;i<7;i++){
    		//The user does not have to know all the schedule
    		if(!textFields[i].getText().equals("")){
    			schedule[i]=textFields[i].getText();
    		}
    	}
    	return schedule;
    }

    /**
     * Creation of the Shop in the database
     * @param event the click on the button
     */
    @FXML
    void create(ActionEvent event) {
    	LatLong latLong = MapController.latLong;
    	Shop.create(name.getText(),latLong.getLatitude(), latLong.getLongitude(),createSchedule());
		Main.getInstance().closeDialog();
    }

}

