package be.ac.ulb.infof307.g10.models.database;

import java.util.Observable;
import java.util.Observer;

import be.ac.ulb.infof307.g10.models.ModelObject;

public class SaverObserver implements Observer {

	private static SaverObserver instance;
	
	private SaverObserver() {
	}
	
	public static SaverObserver getInstance(){
		if (instance == null){
			instance = new SaverObserver();
		}
		return instance;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		Database.save((ModelObject) o);
	}
}
