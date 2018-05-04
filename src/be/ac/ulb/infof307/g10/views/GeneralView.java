package be.ac.ulb.infof307.g10.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
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
        stage.setTitle("Shooking (shopping and cooking)"); //title of the window
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This function is used to load the corresponding Parent class of the fxml representing a view
     * @param name The String name of the fxml file located in the ressource package
     *             You should not put the .fxml extension, only the name
     * @return A Parent node corresponding to the root node of the view
     */
    private Parent loadFXML(String name) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("/FXML/"+name+".fxml"));
            return root;

        } catch (IOException e) { // never happens as resource in packed with application
            e.printStackTrace();
        }
        return null;//should never return this
    }

    /**
     * This method is used to disable the buttons not wanted in the general menu (see Menu fxml)
     * It really depends of the structure of the menu, if the menu view is modified, this function may not work anymore
     * @param btns A list of String representing the id of the buttons we want to disable
     */
    public void disableButtons(List<String> btns ) {
        
        HBox menuBar = (HBox) menu.getChildren().get(0); //the hbox with buttons (it seems in the view like a menubar) is the first children

        for (Node btn : menuBar.getChildren()) { //we check the corresponding buttons in the hbox
            if(btns.contains(btn.getId()))
                btn.setDisable(true);//disable the button
        }

    }
    
}
