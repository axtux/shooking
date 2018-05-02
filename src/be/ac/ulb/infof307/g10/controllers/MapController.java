package be.ac.ulb.infof307.g10.controllers;

import com.lynden.gmapsfx.ClusteredGoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.GMapMouseEvent;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.ClusteredGoogleMap;
import com.lynden.gmapsfx.javascript.object.InfoWindow;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import com.lynden.gmapsfx.service.geocoding.GeocodingService;
import javafx.fxml.FXML;

import netscape.javascript.JSObject;

import java.net.URL;
import java.util.ResourceBundle;

public class MapController extends MainController implements MapComponentInitializedListener {

    @FXML
    ClusteredGoogleMapView mapView;
    @FXML
    ClusteredGoogleMap map;
    @FXML
    InfoWindow popup;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mapView.addMapInializedListener(this);
    }

    @Override
    public void mapInitialized() {
        // Set the initial properties of the map.
        MapOptions mapOptions = new MapOptions();
        LatLong latLong = new LatLong((double) 50.8504500, (double) 4.3487800);
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
        popup = new InfoWindow();

        // Add a marker to the map on right clic
        map.addMouseEventHandler(UIEventType.rightclick, (GMapMouseEvent event) -> {
            markerHandler(event);
        });

    }

    @FXML
    public void markerHandler(GMapMouseEvent event) {
        LatLong latLong = event.getLatLong();
        MarkerOptions markerOptions = new MarkerOptions();

        markerOptions.position(latLong).visible(Boolean.TRUE).title("My Marker");

        Marker marker = new Marker(markerOptions);// need to be save on the database
        map.addClusterableMarker(marker);

        // popup
        popup.setContent("Hello world");
        popup.open(map, marker);
        map.addUIEventHandler(marker, UIEventType.click, (JSObject obj) -> {
            popup.open(map, marker);
        });
    }


}
