/**
 * Login Page
 */
package be.ac.ulb.infof307.g10;


import be.ac.ulb.infof307.g10.Exception.IncorrectPasswordException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**
 * Login Page
 * @author Pierre
 *
 */
public class LoginPage extends Application {

	/**
	 * Launch of the user interface for the login page
	 */
	public static void main(String[] args) {
		Application.launch(LoginPage.class,args);
	}
	
	@Override
	public void start(Stage primaryStage){
		primaryStage.setTitle("Login Page");
		//Horizontal centering
        HBox hbox = new HBox(50);
        hbox.setAlignment(Pos.CENTER);

        //"Login" text field
        TextField textFieldLog = new TextField();
        textFieldLog.setPromptText("Login");
        
        //"Password" protected text field
        PasswordField pwdField = new PasswordField();
        pwdField.setPromptText("Password");

        //Create label to show if user enter a incorrect Password
        Label badPassLabel = new Label("");
        badPassLabel.setFont(new Font("Arial", 15));
        
        //"Ok" button
        Button btnOk = new Button();
        btnOk.setText("OK");
        btnOk.setDefaultButton(true);
        btnOk.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	//Capture of the "login" field
                String log = textFieldLog.getText();
                //Capture of the "password" field
                String pwd = pwdField.getText();
                System.out.println(pwd);
                try{
                	Connector conn = new Connector();
                	Session user = conn.openSession(log, pwd);
                	badPassLabel.setText("");
                	// Run the app

                    Button logout = new Button("Log out");
                    logout.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            primaryStage.hide();
                        }
                    });

                    Button research = new Button("Research");
                    research.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            ResearchPage rp = new ResearchPage();
                            rp.start(primaryStage);

                        }
                    });


                    VBox v = new VBox(logout, research);
                    Scene sceneApp = new Scene(v, 400, 400);
                    primaryStage.setScene(sceneApp);
                    primaryStage.setResizable(false);
                    primaryStage.show();
                }
                catch(IncorrectPasswordException e){
                	System.out.println("Bad Password");
                	badPassLabel.setText("Incorrect Password !");
                }
            }
        });

        // "Create User" button
        Button btnCreate = new Button();
        btnCreate.setText("Create User");
        btnCreate.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                ConditionUtil condiUtil = new ConditionUtil();
                primaryStage.close();
            }
        });

        //Welcome label
        Label titleLabel = new Label("Welcome !");
        titleLabel.setFont(new Font("Arial", 30));
        
        //Buttons centering
        HBox hbox2 = new HBox(50,btnOk,btnCreate);
        //vetical centering
        VBox vbox = new VBox(titleLabel, textFieldLog,pwdField, badPassLabel, hbox2);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        hbox.getChildren().addAll(vbox);
        
        //Page creation
        Scene scene = new Scene(hbox, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

}
