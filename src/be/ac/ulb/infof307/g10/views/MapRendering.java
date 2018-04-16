package be.ac.ulb.infof307.g10.views;

import be.ac.ulb.infof307.g10.Main;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.GMapMouseEvent;
import com.lynden.gmapsfx.javascript.event.MouseEventHandler;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class MapRendering implements MapComponentInitializedListener {

GoogleMapView mapView;
GoogleMap map;

public MapRendering(Stage stage){
    //creation of the map
    mapView = new GoogleMapView();
    mapView.addMapInializedListener(this);

    //creation button logout

    Button btnLogout = new Button();
    btnLogout.setText("Logout");
    btnLogout.setDefaultButton(true);
    btnLogout.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent event) {
            Main.getInstance().goToLogin();
        }
    });

    //organisation of the view
    BorderPane bpane = new BorderPane();
    bpane.setCenter(mapView);
    bpane.setRight(btnLogout);

    Scene scene = new Scene(bpane);
    stage.setTitle("Maps");
    stage.setScene(scene);
    stage.show();
}

   public void markerHandler(GMapMouseEvent event){
        LatLong latLong = event.getLatLong();
        MarkerOptions markerOptions = new MarkerOptions();
    
        markerOptions.position( latLong )
                .visible(Boolean.TRUE)
                .title("My Marker");

    Marker marker = new Marker( markerOptions );//need to be save on the data base
    map.addMarker(marker); //To change body of generated methods, choose Tools | Templates.
   }

@Override
public void mapInitialized() {
    //Set the initial properties of the map.
    MapOptions mapOptions = new MapOptions();
    LatLong latLong = new LatLong((double)50.8504500, (double)4.3487800);
    mapOptions.center(latLong)
            .mapType(MapTypeIdEnum.ROADMAP)
            .overviewMapControl(false)
            .panControl(false)
            .rotateControl(false)
            .scaleControl(false)
            .streetViewControl(false)
            .zoomControl(false)
            .zoom(12);
    
   map = mapView.createMap(mapOptions);
    
   map.addMouseEventHandler(UIEventType.click, (GMapMouseEvent event) -> {
       markerHandler(event);
});
            
        }


    };
    
   

    //Add a marker to the map


