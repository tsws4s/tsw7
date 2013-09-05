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
		@NamedQuery(name = "findAllPersons", query = "select myPerson from Person myPerson"),
		@NamedQuery(name = "findPersonByActiveYn", query = "select myPerson from Person myPerson where myPerson.activeYn = ?1"),
		@NamedQuery(name = "findPersonByAddress", query = "select myPerson from Person myPerson where myPerson.address = ?1"),
		@NamedQuery(name = "findPersonByAddressContaining", query = "select myPerson from Person myPerson where myPerson.address like ?1"),
		@NamedQuery(name = "findPersonByCity", query = "select myPerson from Person myPerson where myPerson.city = ?1"),
		@NamedQuery(name = "findPersonByCityContaining", query = "select myPerson from Person myPerson where myPerson.city like ?1"),
		@NamedQuery(name = "findPersonByDefaultProjectRole", query = "select myPerson from Person myPerson where myPerson.defaultProjectRole = ?1"),
		@NamedQuery(name = "findPersonByDefaultProjectRoleContaining", query = "select myPerson from Person myPerson where myPerson.defaultProjectRole like ?1"),
		@NamedQuery(name = "findPersonByEmail", query = "select myPerson from Person myPerson where myPerson.email = ?1"),
		@NamedQuery(name = "findPersonByEmailContaining", query = "select myPerson from Person myPerson where myPerson.email like ?1"),
		@NamedQuery(name = "findPersonByFirstname", query = "select myPerson from Person myPerson where myPerson.firstname = ?1"),
		@NamedQuery(name = "findPersonByFirstnameContaining", query = "select myPerson from Person myPerson where myPerson.firstname like ?1"),
		@NamedQuery(name = "findPersonByLastname", query = "select myPerson from Person myPerson where myPerson.lastname = ?1"),
		@NamedQuery(name = "findPersonByLastnameContaining", query = "select myPerson from Person myPerson where myPerson.lastname like ?1"),
		@NamedQuery(name = "findPersonByPersonId", query = "select myPerson from Person myPerson where myPerson.personId = ?1"),
		@NamedQuery(name = "findPersonByPhone", query = "select myPerson from Person myPerson where myPerson.phone = ?1"),
		@NamedQuery(name = "findPersonByPhoneContaining", query = "select myPerson from Person myPerson where myPerson.phone like ?1"),
		@NamedQuery(name = "findPersonByPrimaryKey", query = "select myPerson from Person myPerson where myPerson.personId = ?1"),
		@NamedQuery(name = "findPersonByState", query = "select myPerson from Person myPerson where myPerson.state = ?1"),
		@NamedQuery(name = "findPersonByStateContaining", query = "select myPerson from Person myPerson where myPerson.state like ?1"),
		@NamedQuery(name = "findPersonByZip", query = "select myPerson from Person myPerson where myPerson.zip = ?1"),
		@NamedQuery(name = "findPersonByZipContaining", query = "select myPerson from Person myPerson where myPerson.zip like ?1") })
@Table(catalog = "C324877_project_mgt", name = "Person")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "pm7/pm7/domain", name = "Person")
@XmlRootElement(namespace = "pm7/pm7/domain")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "personId", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer personId;
	/**
	 */

	@Column(name = "firstname", length = 45)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String firstname;
	/**
	 */

	@Column(name = "lastname", length = 145)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String lastname;
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

	@Column(name = "defaultProjectRole", length = 45)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String defaultProjectRole;
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

	@Column(name = "activeYN")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer activeYn;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "FK_accountId", referencedColumnName = "accountId") })
	@XmlTransient
	Account account;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "FK_currentClientId", referencedColumnName = "clientId") })
	@XmlTransient
	Client client;
	/**
	 */
	@OneToMany(mappedBy = "person", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Statusupdate> statusupdates;
	/**
	 */
	@OneToMany(mappedBy = "person", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Account> accounts;
	/**
	 */
	@OneToMany(mappedBy = "person", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Projectteam> projectteams;
	/**
	 */
	@OneToMany(mappedBy = "person", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Attachment> attachments;
	/**
	 */
	@OneToMany(mappedBy = "person", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Task> tasks;
	/**
	 */
	@OneToMany(mappedBy = "person", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Client> clients;
	/**
	 */
	@OneToMany(mappedBy = "personByFkContactPersonId", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Project> projectsForFkContactPersonId;
	/**
	 */
	@OneToMany(mappedBy = "person", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Timeentry> timeentries;
	/**
	 */
	@OneToMany(mappedBy = "personByFkContactPersonId", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Project> projectsForFkProjMgrId;

	/**
	 */
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	/**
	 */
	public Integer getPersonId() {
		return this.personId;
	}

	/**
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 */
	public String getFirstname() {
		return this.firstname;
	}

	/**
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 */
	public String getLastname() {
		return this.lastname;
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
	public void setDefaultProjectRole(String defaultProjectRole) {
		this.defaultProjectRole = defaultProjectRole;
	}

	/**
	 */
	public String getDefaultProjectRole() {
		return this.defaultProjectRole;
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
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 */
	public Client getClient() {
		return client;
	}

	/**
	 */
	public void setStatusupdates(Set<Statusupdate> statusupdates) {
		this.statusupdates = statusupdates;
	}

	/**
	 */
	public Set<Statusupdate> getStatusupdates() {
		if (statusupdates == null) {
			statusupdates = new java.util.LinkedHashSet<pm7.domain.Statusupdate>();
		}
		return statusupdates;
	}

	/**
	 */
	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	/**
	 */
	public Set<Account> getAccounts() {
		if (accounts == null) {
			accounts = new java.util.LinkedHashSet<pm7.domain.Account>();
		}
		return accounts;
	}

	/**
	 */
	public void setProjectteams(Set<Projectteam> projectteams) {
		this.projectteams = projectteams;
	}

	/**
	 */
	public Set<Projectteam> getProjectteams() {
		if (projectteams == null) {
			projectteams = new java.util.LinkedHashSet<pm7.domain.Projectteam>();
		}
		return projectteams;
	}

	/**
	 */
	public void setAttachments(Set<Attachment> attachments) {
		this.attachments = attachments;
	}

	/**
	 */
	public Set<Attachment> getAttachments() {
		if (attachments == null) {
			attachments = new java.util.LinkedHashSet<pm7.domain.Attachment>();
		}
		return attachments;
	}

	/**
	 */
	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	/**
	 */
	public Set<Task> getTasks() {
		if (tasks == null) {
			tasks = new java.util.LinkedHashSet<pm7.domain.Task>();
		}
		return tasks;
	}

	/**
	 */
	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	/**
	 */
	public Set<Client> getClients() {
		if (clients == null) {
			clients = new java.util.LinkedHashSet<pm7.domain.Client>();
		}
		return clients;
	}

	/**
	 */
	public void setProjectsForFkContactPersonId(Set<Project> projectsForFkContactPersonId) {
		this.projectsForFkContactPersonId = projectsForFkContactPersonId;
	}

	/**
	 */
	public Set<Project> getProjectsForFkContactPersonId() {
		if (projectsForFkContactPersonId == null) {
			projectsForFkContactPersonId = new java.util.LinkedHashSet<pm7.domain.Project>();
		}
		return projectsForFkContactPersonId;
	}

	/**
	 */
	public void setTimeentries(Set<Timeentry> timeentries) {
		this.timeentries = timeentries;
	}

	/**
	 */
	public Set<Timeentry> getTimeentries() {
		if (timeentries == null) {
			timeentries = new java.util.LinkedHashSet<pm7.domain.Timeentry>();
		}
		return timeentries;
	}

	/**
	 */
	public void setProjectsForFkProjMgrId(Set<Project> projectsForFkProjMgrId) {
		this.projectsForFkProjMgrId = projectsForFkProjMgrId;
	}

	/**
	 */
	public Set<Project> getProjectsForFkProjMgrId() {
		if (projectsForFkProjMgrId == null) {
			projectsForFkProjMgrId = new java.util.LinkedHashSet<pm7.domain.Project>();
		}
		return projectsForFkProjMgrId;
	}

	/**
	 */
	public Person() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Person that) {
		setPersonId(that.getPersonId());
		setFirstname(that.getFirstname());
		setLastname(that.getLastname());
		setPhone(that.getPhone());
		setEmail(that.getEmail());
		setDefaultProjectRole(that.getDefaultProjectRole());
		setAddress(that.getAddress());
		setCity(that.getCity());
		setState(that.getState());
		setZip(that.getZip());
		setActiveYn(that.getActiveYn());
		setAccount(that.getAccount());
		setClient(that.getClient());
		setStatusupdates(new java.util.LinkedHashSet<pm7.domain.Statusupdate>(that.getStatusupdates()));
		setAccounts(new java.util.LinkedHashSet<pm7.domain.Account>(that.getAccounts()));
		setProjectteams(new java.util.LinkedHashSet<pm7.domain.Projectteam>(that.getProjectteams()));
		setAttachments(new java.util.LinkedHashSet<pm7.domain.Attachment>(that.getAttachments()));
		setTasks(new java.util.LinkedHashSet<pm7.domain.Task>(that.getTasks()));
		setClients(new java.util.LinkedHashSet<pm7.domain.Client>(that.getClients()));
		setProjectsForFkContactPersonId(new java.util.LinkedHashSet<pm7.domain.Project>(that.getProjectsForFkContactPersonId()));
		setTimeentries(new java.util.LinkedHashSet<pm7.domain.Timeentry>(that.getTimeentries()));
		setProjectsForFkProjMgrId(new java.util.LinkedHashSet<pm7.domain.Project>(that.getProjectsForFkProjMgrId()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("personId=[").append(personId).append("] ");
		buffer.append("firstname=[").append(firstname).append("] ");
		buffer.append("lastname=[").append(lastname).append("] ");
		buffer.append("phone=[").append(phone).append("] ");
		buffer.append("email=[").append(email).append("] ");
		buffer.append("defaultProjectRole=[").append(defaultProjectRole).append("] ");
		buffer.append("address=[").append(address).append("] ");
		buffer.append("city=[").append(city).append("] ");
		buffer.append("state=[").append(state).append("] ");
		buffer.append("zip=[").append(zip).append("] ");
		buffer.append("activeYn=[").append(activeYn).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((personId == null) ? 0 : personId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Person))
			return false;
		Person equalCheck = (Person) obj;
		if ((personId == null && equalCheck.personId != null) || (personId != null && equalCheck.personId == null))
			return false;
		if (personId != null && !personId.equals(equalCheck.personId))
			return false;
		return true;
	}
}
