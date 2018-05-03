package be.ac.ulb.infof307.g10.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.lynden.gmapsfx.javascript.object.LatLong;

import be.ac.ulb.infof307.g10.Main;
import be.ac.ulb.infof307.g10.models.Shop;
import be.ac.ulb.infof307.g10.models.Stock;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
/**
 * Controller for the CreateShop view
 * @author pierre
 *
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
     * Construct the schedule array containing the opening hours
     * @return the schedule array containing the opening hours
     */
    private String[] makeSchedule(){
    	String[] schedule = new String[7];
    	TextField[] textFields=getTextFields();
    	for(int i=0;i<7;i++){
    		//The user does not have to know all the schedule
    		if(textFields[i].getText().equals("")){
    			schedule[i]="Unknown";
    			System.out.println(schedule[i]);
    		}
    		else{
    			schedule[i]=textFields[i].getText();
    		}
    	}
    	return schedule;
    }

    /**
     * Creation of the Shop in the database
     * @param event the clic on the button
     */
    @FXML
    void create(ActionEvent event) {
    	LatLong latLong = MapController.latLong;
    	Shop shop = new Shop(name.getText(),latLong.getLatitude(), latLong.getLongitude(),makeSchedule(), new Stock());
    	shop.save();
		Main.getInstance().closeDialog();
    }

}

