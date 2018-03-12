package be.ac.ulb.infof307.g10;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class IntCreateAcount {
	
	private int positionX;
	private int positionY;

	
	public boolean testSamePwd(String pwd1, String pwd2) {
		return (pwd1.equals(pwd2));
	}
	
	public IntCreateAcount() {
		
		Stage secondStage = new Stage();
		Group root = new Group();
		
		
		//champs pour rentrer info
		
		secondStage.setTitle("Create account page");
		//Centrage horizontal des champs de texte et boutons
        HBox hbox = new HBox(50);
        hbox.setAlignment(Pos.CENTER);

        //Création du champ "Login"
        TextField textFieldLog = new TextField();
        textFieldLog.setPromptText("Login");
        
        //Création du champ "Password"
        PasswordField pwdField = new PasswordField();
        pwdField.setPromptText("Password");
        
        //Création du champ "Password"
        PasswordField pwdField2 = new PasswordField();
        pwdField2.setPromptText("Re enter the password");
        
      //Welcome label
        Label titleLabel = new Label("Create your Account");
        titleLabel.setFont(new Font("Arial", 30));
        
      //Création du bouton "OK"
        Button btnOk = new Button();
        btnOk.setText("Submit");
        btnOk.setDefaultButton(true);
        btnOk.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	//Récupération du champ "Login"
                String log = textFieldLog.getText();
              //Récupération du champ "Password"
                String pwd = pwdField.getText();
                System.out.println(pwd);
                String pwd2 = pwdField2.getText();
                System.out.println(pwd2);
            }
        });
        
        
        //Centrage des deux boutons
        HBox hbox2 = new HBox(50,btnOk);
        //Centrage vertical des champs de texte et boutons
        VBox vbox = new VBox(titleLabel, textFieldLog,pwdField,pwdField2,hbox2);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        hbox.getChildren().addAll(vbox);
		
        Scene scene = new Scene(hbox,800,600,Color.WHITE);
		secondStage.setScene(scene);
		
		
		secondStage.show();
		
		
		
	}
	
}
