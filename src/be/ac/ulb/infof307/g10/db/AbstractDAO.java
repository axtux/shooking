package be.ac.ulb.infof307.g10.db;

import java.util.Observer;

import be.ac.ulb.infof307.g10.models.ModelObject;

public abstract class AbstractDAO implements Observer {

	public static void save(ModelObject obj) {
		Database.save(obj);
	}
	
	/**
	 * Save the object when observed object has changed
	 * @param obj	The observed object
	 */
	public void update(ModelObject obj) {
		save(obj);
	}
}
