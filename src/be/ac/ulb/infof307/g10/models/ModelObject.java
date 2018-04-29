package be.ac.ulb.infof307.g10.models;

import java.io.Serializable;

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

import be.ac.ulb.infof307.g10.db.Database;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ModelObject implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@EqualsExclude
	@HashCodeExclude
	public Long id;

	public Long getId() {
		return id;
	}

	public void save() {
		Database.save(this);
	}

	public void delete() {
		Database.delete(this);
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public boolean Equals(Object o) {
		return EqualsBuilder.reflectionEquals(this, o);
	}

	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

}
