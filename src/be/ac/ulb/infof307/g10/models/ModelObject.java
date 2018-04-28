package be.ac.ulb.infof307.g10.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.EqualsExclude;
import org.apache.commons.lang3.builder.ToStringBuilder;

import be.ac.ulb.infof307.g10.db.Database;

@Entity
@MappedSuperclass
public class ModelObject implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@EqualsExclude
	public Long id;

	public Long getId() {
		return id;
	}

	public void save() {
		Database.update(this);
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public boolean Equals(Object o) {
		return EqualsBuilder.reflectionEquals(this, o);
	}

}
