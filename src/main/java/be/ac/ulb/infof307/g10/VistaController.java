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
 * Source:https://www.youtube.com/watch?v=OT_qBWKiRfY 
 */
public class VistaController implements Initializable {

    // Declaramos los botones
    @FXML private Button aniadirBT;
    @FXML private Button modificarBT;
    @FXML private Button eliminarBT;
    @FXML private Button nuevoBT;
    @FXML private Button allezMagasinBT;
    
    // Declaramos los textfileds
    // Nous déclarons lestextfileds
    @FXML private TextField produitTF;
    @FXML private TextField quantiteTF;
    
    // Declaramos la tabla y las columnas
    // Déclare la table et les colonnes
    @FXML private TableView<ListCourses> tableproduits;
    @FXML private TableColumn produitCL;
    @FXML private TableColumn quantiteCL;
    
    ObservableList<ListCourses> produits;
    
    private int PositionProduitTable;

    /**
     * Metodo que realiza las acciones tras pulsar el boton "Nuevo"
     * Méthode qui effectue les actions après avoir appuyé sur le bouton "Nouveau"
     * @param event
     */
    @FXML private void nuevo(ActionEvent event) {
        produitTF.setText("");
        quantiteTF.setText("");
        
        modificarBT.setDisable(true);
        eliminarBT.setDisable(true);
        aniadirBT.setDisable(false);
    }

    /**
     * Metodo que realiza las acciones tras pulsar el boton "AÃ±adir"
     * Méthode qui effectue les actions après avoir cliqué sur le bouton "Ajouter"
     * @param event
     */
    @FXML private void aniadir(ActionEvent event) {
    	System.out.println("adding "+produitTF.getText()+quantiteTF.getText());
    }

    /**
     * Metodo que realiza las acciones tras pulsar el boton "Modificar"
     * Méthode qui effectue les actions après avoir appuyé sur le bouton "Modifier"
     * @param event
     */
    @FXML private void modificar(ActionEvent event) {
    	System.out.println("changing "+produitTF.getText()+quantiteTF.getText());
        ListCourses listCourses = new ListCourses();
        produits.set(PositionProduitTable, listCourses);
    }

    /**
     * Metodo que realiza las acciones tras pulsar el boton "Eliminar"
     * 
     * Méthode qui effectue les actions après avoir appuyé sur le bouton "Supprimer"
     * @param event
     */
    @FXML private void eliminar(ActionEvent event) {
    	produits.remove(PositionProduitTable);
    }
    
    @FXML
    void allezMagasin(ActionEvent event) {
    	
    	System.out.println("Bienvenue \n" );
    }
    /**
     * Listener de la tabla productos
     * écouteur de la table des produits
     */
    private final ListChangeListener<ListCourses> selecteurTable =
            new ListChangeListener<ListCourses>() {
                public void onChanged(ListChangeListener.Change<? extends ListCourses> c) {
                    ponerPersonaSeleccionada();
                }
            };

    /**
     * PARA SELECCIONAR UNA CELDA DE LA TABLA "tablaproductos"
     * POUR SÉLECTIONNER UNE CELLULE DE LA TABLE "produits de table"
     */
    public ListCourses getTablaProductoSeleccionado() {
        if (tableproduits != null) {
            List<ListCourses> tabla = tableproduits.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final ListCourses competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }

    /**
     * Metodo para poner en los textFields la tupla que selccionemos
     * Méthode pour mettre dans textFields le tuple que nous sélectionnons
     */
    private void ponerPersonaSeleccionada() {
        final ListCourses listCourses = getTablaProductoSeleccionado();
        PositionProduitTable = produits.indexOf(listCourses);

        if (listCourses != null) {

            // Pongo los textFields con los datos correspondientes
        	// Je mets les textFields avec les données correspondantes
            produitTF.setText("testProduct");
            quantiteTF.setText("testQuantity");
           
            // Pongo los botones en su estado correspondiente
           // Je mets les boutons dans leur état correspondant
            modificarBT.setDisable(false);
            eliminarBT.setDisable(false);
            aniadirBT.setDisable(true);

        }
    }

    /**
     * MÃ©todo para inicializar la tabla
     * Méthode d'initialisation de la table
     */
    private void inicializarTablaPersonas() {
    	produitCL.setCellValueFactory(new PropertyValueFactory<ListCourses, String>("nombre"));
    	quantiteCL.setCellValueFactory(new PropertyValueFactory<ListCourses, String>("apellido"));
        
        produits = FXCollections.observableArrayList();
        tableproduits.setItems(produits);
    }

    public void initialize(URL url, ResourceBundle rb) {

        // Inicializamos la tabla
    	// Initialise la table
        this.inicializarTablaPersonas();

        // Ponemos estos dos botones para que no se puedan seleccionar
     // Nous mettons ces deux boutons pour qu'ils ne puissent pas être sélectionnés
        modificarBT.setDisable(true);
        eliminarBT.setDisable(true);

        // Seleccionar las tuplas de la tabla de las productos
     // Sélectionnez les tuples de la table des produits
        final ObservableList<ListCourses> tablaProductoSel = tableproduits.getSelectionModel().getSelectedItems();
        tablaProductoSel.addListener(selecteurTable);

        // Inicializamos la tabla con algunos datos aleatorios
        // Initialise la table avec quelques données aléatoires
        for (int i = 0; i < 20; i++) {
            ListCourses p1 = new ListCourses();
            produits.add(p1);
        }
    }
}
