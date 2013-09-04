package tsw.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllProgramresources", query = "select myProgramresource from Programresource myProgramresource"),
		@NamedQuery(name = "findProgramresourceByPrimaryKey", query = "select myProgramresource from Programresource myProgramresource where myProgramresource.programResourceId = ?1"),
		@NamedQuery(name = "findProgramresourceByProgramResourceId", query = "select myProgramresource from Programresource myProgramresource where myProgramresource.programResourceId = ?1") })
@Table(catalog = "tsws4s_4", name = "ProgramResource")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "tsw7/tsw/domain", name = "Programresource")
public class Programresource implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "programResourceId", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer programResourceId;
	/**
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "resourceFk", referencedColumnName = "resourceID") })
	@XmlTransient
	Resource resource;
	/**
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "resourcePriceFk", referencedColumnName = "priceID") })
	@XmlTransient
	Price resourcePrice;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "programFK", referencedColumnName = "programID") })
	@XmlTransient
	Program program;

	/**
	 */
	public void setProgramResourceId(Integer programResourceId) {
		this.programResourceId = programResourceId;
	}

	/**
	 */
	public Integer getProgramResourceId() {
		return this.programResourceId;
	}

	/**
	 */
	public void setResource(Resource resource) {
		this.resource = resource;
	}

	/**
	 */
	public Resource getResource() {
		return this.resource;
	}

	/**
	 */
	public void setResourcePrice(Price resourcePrice) {
		this.resourcePrice = resourcePrice;
	}

	/**
	 */
	public Price getResourcePrice() {
		return this.resourcePrice;
	}

	/**
	 */
	public void setProgram(Program program) {
		this.program = program;
	}

	/**
	 */
	public Program getProgram() {
		return program;
	}

	/**
	 */
	public Programresource() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Programresource that) {
		setProgramResourceId(that.getProgramResourceId());
		setResource(that.getResource());
		setResourcePrice(that.getResourcePrice());
		setProgram(that.getProgram());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("programResourceId=[").append(programResourceId).append("] ");
		buffer.append("resource=[").append(resource).append("] ");
		buffer.append("resourcePrice=[").append(resourcePrice).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((programResourceId == null) ? 0 : programResourceId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Programresource))
			return false;
		Programresource equalCheck = (Programresource) obj;
		if ((programResourceId == null && equalCheck.programResourceId != null) || (programResourceId != null && equalCheck.programResourceId == null))
			return false;
		if (programResourceId != null && !programResourceId.equals(equalCheck.programResourceId))
			return false;
		return true;
	}
}
