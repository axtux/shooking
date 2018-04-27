package be.ac.ulb.infof307.g10.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * This class is used to create different views with the same template (border plane with a menu)
 * It is useful to permit a uniformity of the different pages of the application
 * The menu used has a defined structure in the file Menu.fxml (resources package)
 * If it is modified, some method used here should not work anymore. They have to be modified in this case
 */
public class GeneralView extends Parent {

    private Stage stage;
    protected AnchorPane centerPage;
    protected AnchorPane menu;

    public GeneralView(Stage stage, String centerPage, String menu){

        this.stage=stage;
        this.centerPage= (AnchorPane) loadFXML(centerPage);
        this.menu=(AnchorPane) loadFXML(menu);

        BorderPane borderPane= new BorderPane();
        borderPane.setCenter(this.centerPage);
        borderPane.setTop(this.menu);

        //creation of the scene and configuration
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
        update();
    }

    /**
     * This function is used to load the corresponding Parent class of the fxml representing a view
     * @param name The String name of the fxml file located in the ressource package
     *             You should not put the .fxml extension, only the name
     * @return a Parent node corresponding to the root node of the view
     */
    private Parent loadFXML(String name) {
        try {

            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(name+".fxml"));
            return root;

        } catch (IOException e) { // never happens as resource in packed with application
            e.printStackTrace();
        }
        return null;
    }

    private void update() {
        stage.centerOnScreen();
    }

    /**
     * This method is used to disable the buttons not wanted in the general menu (see Menu fxml)
     * It really depends of the structure of the menu, if the menu view is modified, this function may not work anymore
     * @param btns a list of String representing the id of the buttons we want to disable
     */
    public void disableButtons(List<String> btns ) {

        VBox vbox = (VBox) menu.getChildren().get(0);
        HBox menubar = (HBox) vbox.getChildren().get(0); //the hbox with buttons (it seems in the view like a menubar) is the first children

        for (Node btn : menubar.getChildren()) { //we check the corresponding buttons in the hbox
            if(btns.contains(btn.getId()))
                btn.setDisable(true);
        }

    }

    /**
     * This method is to change the title of the menu (see fxml)
     * It really depends of the structure of the menu, if the menu view is modified, this function may not work anymore
     * @param t String representing the new title of the page
     */
    public void setTitle(String t) {

        VBox vbox = (VBox) menu.getChildren().get(0);
        HBox hboxLabel = (HBox) vbox.getChildren().get(1); //the hbox containing the title label is the second children

        Label title = (Label) hboxLabel.getChildren().get(0); //the title label
        title.setText(t);
    }
}
