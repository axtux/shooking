package be.ac.ulb.infof307.g10.views;

import be.ac.ulb.infof307.g10.Main;
import be.ac.ulb.infof307.g10.models.User;
import be.ac.ulb.infof307.g10.models.exceptions.ExistingException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
/**
 * 
 * User creation interface
 *
 */
public class IntCreateAcount {
	
	private int positionX;
	private int positionY;

	
	public boolean testSamePwd(String pwd1, String pwd2) {
		return (pwd1.equals(pwd2));
	}
	
	public IntCreateAcount(Stage stage) {
		Group root = new Group();
		
		
		//fields to enter the information
		
		stage.setTitle("Create account page");
		//put the text and buttons on the horizontal center
        HBox hbox = new HBox(50);
        hbox.setAlignment(Pos.CENTER);

        //login field created
        TextField textFieldLog = new TextField();
        textFieldLog.setPromptText("Login");
        
        //password field created
        PasswordField pwdField = new PasswordField();
        pwdField.setPromptText("Password");

        //password field created
        PasswordField pwdField2 = new PasswordField();
        pwdField2.setPromptText("Re enter the password");

        //Welcome label
        Label titleLabel = new Label("Create your Account");
        titleLabel.setFont(new Font("Arial", 30));
        
        //Create label to show if user enter an user name that is already in DB
        // or the user enter two different password
        Label errorLabel = new Label("");
        errorLabel.setFont(new Font("Arial", 15));

        //ok button created
        Button btnOk = new Button();
        btnOk.setText("Submit");
        btnOk.setDefaultButton(true);
        btnOk.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	//field login recovered
                String log = textFieldLog.getText();
                //password field recovered
                String pwd = pwdField.getText();
                System.out.println(pwd);
                String pwd2 = pwdField2.getText();
                System.out.println(pwd2);
                if (pwd.equals(pwd2)) {
	                try{
	                	User user = User.signup(log, pwd);
	                	errorLabel.setText("");
	                }
	                catch(ExistingException e){
	                	System.out.println("User Already exist");
	                	errorLabel.setText("This user name is already chosen");
	                }
                } else {
                	errorLabel.setText("The two Password are not the same");
                }
            }
        });

        //creation button logout

        Button btnLogout = new Button();
        btnLogout.setText("Login page");
        btnLogout.setDefaultButton(true);
        btnLogout.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Main.getInstance().goToLogin();
            }
        });
        
        
        //the two buttons are in the center
        HBox hbox2 = new HBox(50,btnOk);
        //text and buttons in the vertical center
        VBox vbox = new VBox(titleLabel, textFieldLog,pwdField,pwdField2,errorLabel, hbox2);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        hbox.getChildren().addAll(vbox);

        BorderPane bpane = new BorderPane();
        bpane.setCenter(hbox);
        bpane.setRight(btnLogout);

        Scene scene = new Scene(bpane,800,600,Color.WHITE);
        stage.setScene(scene);
		
		
        stage.show();
		
		
		
	}
	
}
