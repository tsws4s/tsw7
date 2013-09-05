package tsw.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllResources", query = "select myResource from Resource myResource"),
		@NamedQuery(name = "findAllResources4tsw", query = "select myResource from Resource myResource where tswAcctfk = ?1"),
		@NamedQuery(name = "findResourceByActiveYn", query = "select myResource from Resource myResource where myResource.activeYn = ?1"),
		@NamedQuery(name = "findResourceByNotes", query = "select myResource from Resource myResource where myResource.notes = ?1"),
		@NamedQuery(name = "findResourceByNotesContaining", query = "select myResource from Resource myResource where myResource.notes like ?1"),
		@NamedQuery(name = "findResourceByPrimaryKey", query = "select myResource from Resource myResource where myResource.resourceId = ?1"),
		@NamedQuery(name = "findResourceByResourceId", query = "select myResource from Resource myResource where myResource.resourceId = ?1"),
		@NamedQuery(name = "findResourceByResourceName", query = "select myResource from Resource myResource where tswAcctfk = ?1 and myResource.resourceName = ?2"),
		@NamedQuery(name = "findResourceByResourceNameContaining", query = "select myResource from Resource myResource where myResource.resourceName like ?1"),
		@NamedQuery(name = "findResourceByResourceType", query = "select myResource from Resource myResource where myResource.resourceType = ?1"),
		@NamedQuery(name = "findResourceByResourceTypeContaining", query = "select myResource from Resource myResource where myResource.resourceType like ?1") })
@Table(catalog = "tsws4s_4", name = "Resource")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "tsw7/tsw/domain", name = "Resource")
@XmlRootElement(namespace = "tsw7/tsw/domain")
public class Resource implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "resourceID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer resourceId;
	/**
	 */

	@Column(name = "resourceName", length = 150)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String resourceName;
	/**
	 */

	@Column(name = "activeYN")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer activeYn;
	/**
	 */

	@Column(name = "notes", length = 250)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String notes;
	/**
	 */

	@Column(name = "resourceType", length = 45)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String resourceType;
	/**
	 */
	
	@Column(name = "email", length = 155)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String email;

	@Column(name = "phone", length = 25)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String phone;

	@Column(name = "address", length = 145)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String address;

	@Column(name = "city", length = 85)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String city;

	@Column(name = "state", length = 65)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String state;

	@Column(name = "zipcode", length = 15)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String zipcode;
	
	/**
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "priceFK", referencedColumnName = "priceId") })
	@XmlTransient
	Price price;
	
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "tswAcctFK", referencedColumnName = "tswAcctID") })
	@XmlTransient
	Tswacct tswacct;

	/**
	 */
	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	/**
	 */
	public Integer getResourceId() {
		return this.resourceId;
	}

	/**
	 */
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	/**
	 */
	public String getResourceName() {
		return this.resourceName;
	}

	/**
	 */
	public void setActiveYn(Integer activeYn) {
		this.activeYn = activeYn;
	}

	/**
	 */
	public Integer getActiveYn() {
		return this.activeYn;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	/**
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 */
	public String getNotes() {
		return this.notes;
	}

	/**
	 */
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	/**
	 */
	public String getResourceType() {
		return this.resourceType;
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
	public Resource() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Resource that) {
		setResourceId(that.getResourceId());
		setResourceName(that.getResourceName());
		setActiveYn(that.getActiveYn());
		setNotes(that.getNotes());
		setResourceType(that.getResourceType());
		setTswacct(that.getTswacct());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("resourceId=[").append(resourceId).append("] ");
		buffer.append("resourceName=[").append(resourceName).append("] ");
		buffer.append("activeYn=[").append(activeYn).append("] ");
		buffer.append("notes=[").append(notes).append("] ");
		buffer.append("resourceType=[").append(resourceType).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((resourceId == null) ? 0 : resourceId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Resource))
			return false;
		Resource equalCheck = (Resource) obj;
		if ((resourceId == null && equalCheck.resourceId != null) || (resourceId != null && equalCheck.resourceId == null))
			return false;
		if (resourceId != null && !resourceId.equals(equalCheck.resourceId))
			return false;
		return true;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
}
