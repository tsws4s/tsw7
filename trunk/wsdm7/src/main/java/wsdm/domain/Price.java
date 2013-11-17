package wsdm.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.math.BigDecimal;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllPrices", query = "select myPrice from Price myPrice"),
		@NamedQuery(name = "findPriceByPrimaryKey", query = "select myPrice from Price myPrice where myPrice.priceId = ?1") })
@Table(catalog = "C324877_tsws4s", name = "Price")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wsdm7/wsdm/domain", name = "Price")
@XmlRootElement(namespace = "wsdm7/wsdm/domain")
public class Price implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "priceId", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer priceId;
	/**
	 */

	@Column(name = "price", scale = 2, precision = 32)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal priceField;
	/**
	 */

	@Column(name = "priceCategory", length = 45)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String priceCategory;
	/**
	 */

	@Column(name = "description", length = 235)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String description;
	/**
	 */

	@Column(name = "priceColor", length = 45)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String priceColor;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "tswAcctFK", referencedColumnName = "tswAcctID") })
	@XmlTransient
	Tswacct tswacct;
	/**
	 */
	@OneToMany(mappedBy = "price", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<wsdm.domain.Event> events;
	/**
	 */
	@OneToMany(mappedBy = "price", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<wsdm.domain.Program> programs;
	/**
	 */
	@OneToMany(mappedBy = "price", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<wsdm.domain.Resource> resources;

	/**
	 */
	public void setPriceId(Integer priceId) {
		this.priceId = priceId;
	}

	/**
	 */
	public Integer getPriceId() {
		return this.priceId;
	}

	/**
	 */
	public void setPriceField(BigDecimal priceField) {
		this.priceField = priceField;
	}

	/**
	 */
	public BigDecimal getPriceField() {
		return this.priceField;
	}

	/**
	 */
	public void setPriceCategory(String priceCategory) {
		this.priceCategory = priceCategory;
	}

	/**
	 */
	public String getPriceCategory() {
		return this.priceCategory;
	}

	/**
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 */
	public void setPriceColor(String priceColor) {
		this.priceColor = priceColor;
	}

	/**
	 */
	public String getPriceColor() {
		return this.priceColor;
	}

	/**
	 */
	public void setTswacct(Tswacct tswacct) {
		this.tswacct = tswacct;
	}

	/**
	 */
	public Tswacct getTswacct() {
		return tswacct;
	}

	/**
	 */
	public void setEvents(Set<Event> events) {
		this.events = events;
	}

	/**
	 */
	public Set<Event> getEvents() {
		if (events == null) {
			events = new java.util.LinkedHashSet<wsdm.domain.Event>();
		}
		return events;
	}

	/**
	 */
	public void setPrograms(Set<Program> programs) {
		this.programs = programs;
	}

	/**
	 */
	public Set<Program> getPrograms() {
		if (programs == null) {
			programs = new java.util.LinkedHashSet<wsdm.domain.Program>();
		}
		return programs;
	}

	/**
	 */
	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}

	/**
	 */
	public Set<Resource> getResources() {
		if (resources == null) {
			resources = new java.util.LinkedHashSet<wsdm.domain.Resource>();
		}
		return resources;
	}

	/**
	 */
	public Price() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Price that) {
		setPriceId(that.getPriceId());
		setPriceField(that.getPriceField());
		setPriceCategory(that.getPriceCategory());
		setDescription(that.getDescription());
		setPriceColor(that.getPriceColor());
		setTswacct(that.getTswacct());
		setEvents(new java.util.LinkedHashSet<wsdm.domain.Event>(that.getEvents()));
		setPrograms(new java.util.LinkedHashSet<wsdm.domain.Program>(that.getPrograms()));
		setResources(new java.util.LinkedHashSet<wsdm.domain.Resource>(that.getResources()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("priceId=[").append(priceId).append("] ");
		buffer.append("priceField=[").append(priceField).append("] ");
		buffer.append("priceCategory=[").append(priceCategory).append("] ");
		buffer.append("description=[").append(description).append("] ");
		buffer.append("priceColor=[").append(priceColor).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((priceId == null) ? 0 : priceId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Price))
			return false;
		Price equalCheck = (Price) obj;
		if ((priceId == null && equalCheck.priceId != null) || (priceId != null && equalCheck.priceId == null))
			return false;
		if (priceId != null && !priceId.equals(equalCheck.priceId))
			return false;
		return true;
	}
}
