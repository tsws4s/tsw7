package pm7.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

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
		@NamedQuery(name = "findAllClients", query = "select myClient from Client myClient"),
		@NamedQuery(name = "findClientByActiveYn", query = "select myClient from Client myClient where myClient.activeYn = ?1"),
		@NamedQuery(name = "findClientByAddress", query = "select myClient from Client myClient where myClient.address = ?1"),
		@NamedQuery(name = "findClientByAddressContaining", query = "select myClient from Client myClient where myClient.address like ?1"),
		@NamedQuery(name = "findClientByCity", query = "select myClient from Client myClient where myClient.city = ?1"),
		@NamedQuery(name = "findClientByCityContaining", query = "select myClient from Client myClient where myClient.city like ?1"),
		@NamedQuery(name = "findClientByClientId", query = "select myClient from Client myClient where myClient.clientId = ?1"),
		@NamedQuery(name = "findClientByClientName", query = "select myClient from Client myClient where myClient.clientName = ?1"),
		@NamedQuery(name = "findClientByClientNameContaining", query = "select myClient from Client myClient where myClient.clientName like ?1"),
		@NamedQuery(name = "findClientByEmail", query = "select myClient from Client myClient where myClient.email = ?1"),
		@NamedQuery(name = "findClientByEmailContaining", query = "select myClient from Client myClient where myClient.email like ?1"),
		@NamedQuery(name = "findClientByLogoFilename", query = "select myClient from Client myClient where myClient.logoFilename = ?1"),
		@NamedQuery(name = "findClientByLogoFilenameContaining", query = "select myClient from Client myClient where myClient.logoFilename like ?1"),
		@NamedQuery(name = "findClientByPhone", query = "select myClient from Client myClient where myClient.phone = ?1"),
		@NamedQuery(name = "findClientByPhoneContaining", query = "select myClient from Client myClient where myClient.phone like ?1"),
		@NamedQuery(name = "findClientByPrimaryKey", query = "select myClient from Client myClient where myClient.clientId = ?1"),
		@NamedQuery(name = "findClientByState", query = "select myClient from Client myClient where myClient.state = ?1"),
		@NamedQuery(name = "findClientByStateContaining", query = "select myClient from Client myClient where myClient.state like ?1"),
		@NamedQuery(name = "findClientByWebsite", query = "select myClient from Client myClient where myClient.website = ?1"),
		@NamedQuery(name = "findClientByWebsiteContaining", query = "select myClient from Client myClient where myClient.website like ?1"),
		@NamedQuery(name = "findClientByZip", query = "select myClient from Client myClient where myClient.zip = ?1"),
		@NamedQuery(name = "findClientByZipContaining", query = "select myClient from Client myClient where myClient.zip like ?1") })
@Table(catalog = "C324877_project_mgt", name = "Client")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "pm7/pm7/domain", name = "Client")
@XmlRootElement(namespace = "pm7/pm7/domain")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "clientId", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer clientId;
	/**
	 */

	@Column(name = "clientName", length = 45)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String clientName;
	/**
	 */

	@Column(name = "phone", length = 25)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String phone;
	/**
	 */

	@Column(name = "email", length = 145)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String email;
	/**
	 */

	@Column(name = "website", length = 145)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String website;
	/**
	 */

	@Column(name = "address", length = 85)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String address;
	/**
	 */

	@Column(name = "city", length = 45)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String city;
	/**
	 */

	@Column(name = "state", length = 45)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String state;
	/**
	 */

	@Column(name = "zip", length = 25)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String zip;
	/**
	 */

	@Column(name = "logoFilename", length = 245)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String logoFilename;
	/**
	 */

	@Column(name = "activeYN")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer activeYn;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "FK_contactPersonId", referencedColumnName = "personId") })
	@XmlTransient
	Person person;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "FK_accountId", referencedColumnName = "accountId") })
	@XmlTransient
	Account account;
	/**
	 */
	@OneToMany(mappedBy = "client", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Invoice> invoices;
	/**
	 */
	@OneToMany(mappedBy = "client", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Project> projects;
	/**
	 */
	@OneToMany(mappedBy = "client", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Person> persons;

	/**
	 */
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	/**
	 */
	public Integer getClientId() {
		return this.clientId;
	}

	/**
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	/**
	 */
	public String getClientName() {
		return this.clientName;
	}

	/**
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 */
	public String getPhone() {
		return this.phone;
	}

	/**
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 */
	public String getWebsite() {
		return this.website;
	}

	/**
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 */
	public String getCity() {
		return this.city;
	}

	/**
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 */
	public String getState() {
		return this.state;
	}

	/**
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 */
	public String getZip() {
		return this.zip;
	}

	/**
	 */
	public void setLogoFilename(String logoFilename) {
		this.logoFilename = logoFilename;
	}

	/**
	 */
	public String getLogoFilename() {
		return this.logoFilename;
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

	/**
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

	/**
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 */
	public void setInvoices(Set<Invoice> invoices) {
		this.invoices = invoices;
	}

	/**
	 */
	public Set<Invoice> getInvoices() {
		if (invoices == null) {
			invoices = new java.util.LinkedHashSet<pm7.domain.Invoice>();
		}
		return invoices;
	}

	/**
	 */
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	/**
	 */
	public Set<Project> getProjects() {
		if (projects == null) {
			projects = new java.util.LinkedHashSet<pm7.domain.Project>();
		}
		return projects;
	}

	/**
	 */
	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}

	/**
	 */
	public Set<Person> getPersons() {
		if (persons == null) {
			persons = new java.util.LinkedHashSet<pm7.domain.Person>();
		}
		return persons;
	}

	/**
	 */
	public Client() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Client that) {
		setClientId(that.getClientId());
		setClientName(that.getClientName());
		setPhone(that.getPhone());
		setEmail(that.getEmail());
		setWebsite(that.getWebsite());
		setAddress(that.getAddress());
		setCity(that.getCity());
		setState(that.getState());
		setZip(that.getZip());
		setLogoFilename(that.getLogoFilename());
		setActiveYn(that.getActiveYn());
		setPerson(that.getPerson());
		setAccount(that.getAccount());
		setInvoices(new java.util.LinkedHashSet<pm7.domain.Invoice>(that.getInvoices()));
		setProjects(new java.util.LinkedHashSet<pm7.domain.Project>(that.getProjects()));
		setPersons(new java.util.LinkedHashSet<pm7.domain.Person>(that.getPersons()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("clientId=[").append(clientId).append("] ");
		buffer.append("clientName=[").append(clientName).append("] ");
		buffer.append("phone=[").append(phone).append("] ");
		buffer.append("email=[").append(email).append("] ");
		buffer.append("website=[").append(website).append("] ");
		buffer.append("address=[").append(address).append("] ");
		buffer.append("city=[").append(city).append("] ");
		buffer.append("state=[").append(state).append("] ");
		buffer.append("zip=[").append(zip).append("] ");
		buffer.append("logoFilename=[").append(logoFilename).append("] ");
		buffer.append("activeYn=[").append(activeYn).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((clientId == null) ? 0 : clientId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Client))
			return false;
		Client equalCheck = (Client) obj;
		if ((clientId == null && equalCheck.clientId != null) || (clientId != null && equalCheck.clientId == null))
			return false;
		if (clientId != null && !clientId.equals(equalCheck.clientId))
			return false;
		return true;
	}
}
