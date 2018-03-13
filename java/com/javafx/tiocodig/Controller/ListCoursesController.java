package com.javafx.tiocodig.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ListCoursesController {

	    @FXML
    private AnchorPane plus;

    // text field
    @FXML
    private TextField textProduit;

    @FXML
    private TextField textQuantite;
    // Buttons 
    @FXML
    private Button moin;

    @FXML
    private Button BtnAjouter;

    @FXML
    private Button BtnNouveau;

    @FXML
    private Button BtnSupprimer;

    @FXML
    private Button BtnModifier;

    
  //Tables
  	@FXML
      private TableView<?> TableListCourse;

      @FXML
      private TableColumn<?, ?> ColumProduit;

      @FXML
      private TableColumn<?, ?> ColumQuantite;
      private int positionProduitDansList;
      
    //Methode
      @FXML
      void ajouter(ActionEvent event) {
    	  
    	  
      }

      @FXML
      void modifier(ActionEvent event) {

      }

      @FXML
      void Nouveau(ActionEvent event) {
    	  textProduit.setText("");
    	  textQuantite.setText("");
    	  BtnModifier.setDisable(true);
    	  BtnSupprimer.setDisable(true);
    	  BtnAjouter.setDisable(false);
    	  
      }

      @FXML
      void Supprimir(ActionEvent event) {

      }
  
}
