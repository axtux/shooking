package be.ac.ulb.infof307.g10;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Oscar
 * 
 */
public class VistaController implements Initializable {

    // Declare the buttons
    @FXML private Button addBT;
    @FXML private Button editBT;
    @FXML private Button removeBT;
    @FXML private Button newBT;
    @FXML private Button goStoreBT;
    @FXML private Button plusBT;
    @FXML private Button  lessBT;
    // Declare the textfileds
    
    @FXML private TextField productTF;
    @FXML private TextField amountTF;
    
    // Declare the table and columns
    
    @FXML private TableView<ListCourses> tableProducts;
    @FXML private TableColumn productCL;
    @FXML private TableColumn amountCL;
    
    ObservableList<ListCourses> products;
    
    private int ProductTablePosition;

    /**
     * Method that performs the actions after pressing the "New" button
     * 
     * @param event
     */
    @FXML private void createNewProduct(ActionEvent event) {
    	productTF.setText("");
    	amountTF.setText("");
        
        editBT.setDisable(true);
        removeBT.setDisable(true);
        addBT.setDisable(false);
    }

    /**
     * Method that performs the actions after pressing the "Add" button
     *
     * @param event
     */
    @FXML private void addProduct(ActionEvent event) {
    	System.out.println("adding "+productTF.getText()+amountTF.getText());
    }

    /**
     * Method that performs the actions after pressing the "Edit" button
     * 
     * @param event
     */
    @FXML private void editProduct(ActionEvent event) {
    	System.out.println("changing "+productTF.getText()+amountTF.getText());
        ListCourses listCourses = new ListCourses();
        products.set(ProductTablePosition, listCourses);
    }

    /**
     *Method that performs the actions after pressing the "Remove" button
     * @param event
     */
    @FXML private void removeProduct(ActionEvent event) {
    	products.remove(ProductTablePosition);
    }
    /**
     *Method that performs the actions after pressing the "Go to Store" button
     * @param event
     */
    @FXML
    void goToStore(ActionEvent event) {
    	
    	System.out.println("Welcome \n" );
    }

    /**
     * Method that performs the actions after pressing the "+" button
     */
    
    @FXML
    void buttonPlus(ActionEvent event) {

    }
    /**
     * Method that performs the actions after pressing the "-" button
     */
    @FXML
    void buttonLess(ActionEvent event) {

    }
    
    /**
     * Listener of the table products  
     */
    
    
    private final ListChangeListener<ListCourses> selecteurTable =
            new ListChangeListener<ListCourses>() {
                public void onChanged(ListChangeListener.Change<? extends ListCourses> c) {
                	putSelectedProduct();
                }
            };

    /**
     * 
     * Select a cell of the table products
     */
    public ListCourses getTablaProductoSeleccionado() {
        if (tableProducts != null) {
            List<ListCourses> tabla = tableProducts.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final ListCourses competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }

    /**
     * Method to put in textFields the tuple that we select
     */
    private void putSelectedProduct() {
        final ListCourses listCourses = getTablaProductoSeleccionado();
        ProductTablePosition = products.indexOf(listCourses);

        if (listCourses != null) {

            // Put the textFields with the corresponding data
        	productTF.setText("testProduct");
        	amountTF.setText("testQuantity");
           
            // Put the buttons in their corresponding state
           
            editBT.setDisable(false);
            removeBT.setDisable(false);
            addBT.setDisable(true);

        }
    }

    /**
     * Method to initialize the table
     * 
     */
    private void initializeTablaproducts() {
    	productCL.setCellValueFactory(new PropertyValueFactory<ListCourses, String>("Product"));
    	amountCL.setCellValueFactory(new PropertyValueFactory<ListCourses, String>("Amount"));
        
    	products = FXCollections.observableArrayList();
        tableProducts.setItems(products);
    }

    public void initialize(URL url, ResourceBundle rb) {

        // initialize the table
    	
        this.initializeTablaproducts();

     // Put these two buttons so they can not be selected
    
        editBT.setDisable(true);
        removeBT.setDisable(true);

       // Select tuples from the product table
     
        final ObservableList<ListCourses> tablaProductoSel = tableProducts.getSelectionModel().getSelectedItems();
        tablaProductoSel.addListener(selecteurTable);

     // Initialize the table with some random data
       
        for (int i = 0; i < 20; i++) {
            ListCourses p1 = new ListCourses();
            products.add(p1);
        }
    }
}
