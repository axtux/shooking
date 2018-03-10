/**
 * Page de login
 */
package be.ac.ulb.infof307.g10;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.geometry.Pos;



/**
 * Page de login
 * @author Pierre
 *
 */
public class LoginPage extends Application {

	/**
	 * Lancement de l'interface graphique
	 * @param args
	 */
	public static void main(String[] args) {
		Application.launch(LoginPage.class,args);
	}
	
	@Override
	public void start(Stage primaryStage){
		primaryStage.setTitle("Login Page");
		//Centrage horizontal des champs de texte et boutons
        HBox hbox = new HBox(50);
        hbox.setAlignment(Pos.CENTER);

        //Création du champ "Login"
        TextField textFieldLog = new TextField();
        textFieldLog.setPromptText("Login");
        
        //Création du champ "Password"
        PasswordField pwdField = new PasswordField();
        pwdField.setPromptText("Password");
        
        //Création du bouton "OK"
        Button btnOk = new Button();
        btnOk.setText("OK");
        btnOk.setDefaultButton(true);
        btnOk.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	//Récupération du champ "Login"
                String log = textFieldLog.getText();
              //Récupération du champ "Password"
                String pwd = pwdField.getText();
                System.out.println(pwd);
            }
        });
        
      //Création du bouton "Create User"
        Button btnCreate = new Button();
        btnCreate.setText("Create User");
        btnCreate.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.out.println("User creation");
            }
        });

        //Welcome label
        Label titleLabel = new Label("Welcome !");
        titleLabel.setFont(new Font("Arial", 30));
        
        //Centrage des deux boutons
        HBox hbox2 = new HBox(50,btnOk,btnCreate);
        //Centrage vertical des champs de texte et boutons
        VBox vbox = new VBox(titleLabel, textFieldLog,pwdField,hbox2);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        hbox.getChildren().addAll(vbox);
        
        //Création de la page principale
        Scene scene = new Scene(hbox, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

}
