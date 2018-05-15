package be.ac.ulb.infof307.g10.models;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.EqualsExclude;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.HashCodeExclude;
import org.apache.commons.lang3.builder.ToStringBuilder;

import be.ac.ulb.infof307.g10.models.database.GenericDatabase;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ModelObject extends Observable implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@EqualsExclude
	@HashCodeExclude
	public Long id;

	/**
	 * Needed by JPA
	 */
	protected ModelObject() {
	}

	public Long getId() {
		return id;
	}

	public void save() {
		GenericDatabase.save(this);
	}

	public void delete() {
		GenericDatabase.delete(this);
	}
	
	/**
	 * Shortcut to notify Observers
	 */
	public void changed() {
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Overriding addObserver to save Observed object in DB during the creation
	 */
	@Override
	public void addObserver(Observer o){
		super.addObserver(o);
		this.changed();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public boolean equals(Object o) {
		return EqualsBuilder.reflectionEquals(this, o);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

}
