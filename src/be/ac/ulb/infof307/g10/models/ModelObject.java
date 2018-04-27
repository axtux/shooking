package be.ac.ulb.infof307.g10.models;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

import be.ac.ulb.infof307.g10.db.Database;

public class ModelObject implements Serializable {

	private static final long serialVersionUID = 1L;

	public void save() {
		Database.update(this);
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
