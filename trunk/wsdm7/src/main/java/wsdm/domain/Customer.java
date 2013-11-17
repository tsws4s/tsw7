package wsdm.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

// import java.util.LinkedHashSet;
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
		@NamedQuery(name = "findAllCustomers", query = "select myCustomer from Customer myCustomer"),
		@NamedQuery(name = "findCustomerByActiveYn", query = "select myCustomer from Customer myCustomer where myCustomer.activeYn = ?1"),
		@NamedQuery(name = "findCustomerByAddrSameAsFamily", query = "select myCustomer from Customer myCustomer where myCustomer.addrSameAsFamily = ?1"),
		@NamedQuery(name = "findCustomerByAddress", query = "select myCustomer from Customer myCustomer where myCustomer.address = ?1"),
		@NamedQuery(name = "findCustomerByAddressContaining", query = "select myCustomer from Customer myCustomer where myCustomer.address like ?1"),
		@NamedQuery(name = "findCustomerByAdminYn", query = "select myCustomer from Customer myCustomer where myCustomer.adminYn = ?1"),
		@NamedQuery(name = "findCustomerByCity", query = "select myCustomer from Customer myCustomer where myCustomer.city = ?1"),
		@NamedQuery(name = "findCustomerByCityContaining", query = "select myCustomer from Customer myCustomer where myCustomer.city like ?1"),
		@NamedQuery(name = "findCustomerByCustomerId", query = "select myCustomer from Customer myCustomer where myCustomer.customerId = ?1"),
		@NamedQuery(name = "findCustomerByEmail", query = "select myCustomer from Customer myCustomer where myCustomer.email = ?1"),
		@NamedQuery(name = "findCustomerByEmailContaining", query = "select myCustomer from Customer myCustomer where myCustomer.email like ?1"),
		@NamedQuery(name = "findCustomerByFirstname", query = "select myCustomer from Customer myCustomer where myCustomer.firstname = ?1"),
		@NamedQuery(name = "findCustomerByFirstnameContaining", query = "select myCustomer from Customer myCustomer where myCustomer.firstname like ?1"),
		@NamedQuery(name = "findCustomerByLastname", query = "select myCustomer from Customer myCustomer where myCustomer.lastname = ?1"),
		@NamedQuery(name = "findCustomerByLastnameContaining", query = "select myCustomer from Customer myCustomer where myCustomer.lastname like ?1"),
		@NamedQuery(name = "findCustomerByPassword", query = "select myCustomer from Customer myCustomer where myCustomer.password = ?1"),
		@NamedQuery(name = "findCustomerByPasswordContaining", query = "select myCustomer from Customer myCustomer where myCustomer.password like ?1"),
		@NamedQuery(name = "findCustomerByPhone", query = "select myCustomer from Customer myCustomer where myCustomer.phone = ?1"),
		@NamedQuery(name = "findCustomerByPhoneContaining", query = "select myCustomer from Customer myCustomer where myCustomer.phone like ?1"),
		@NamedQuery(name = "findCustomerByPrimaryKey", query = "select myCustomer from Customer myCustomer where myCustomer.customerId = ?1"),
		@NamedQuery(name = "findCustomerBySelectTheme", query = "select myCustomer from Customer myCustomer where myCustomer.selectTheme = ?1"),
		@NamedQuery(name = "findCustomerBySelectThemeContaining", query = "select myCustomer from Customer myCustomer where myCustomer.selectTheme like ?1"),
		@NamedQuery(name = "findCustomerByState", query = "select myCustomer from Customer myCustomer where myCustomer.state = ?1"),
		@NamedQuery(name = "findCustomerByStateContaining", query = "select myCustomer from Customer myCustomer where myCustomer.state like ?1"),
		@NamedQuery(name = "findCustomerByYearBorn", query = "select myCustomer from Customer myCustomer where myCustomer.yearBorn = ?1"),
		@NamedQuery(name = "findCustomerByZipcode", query = "select myCustomer from Customer myCustomer where myCustomer.zipcode = ?1"),
		@NamedQuery(name = "findCustomerByZipcodeContaining", query = "select myCustomer from Customer myCustomer where myCustomer.zipcode like ?1") })
@Table(catalog = "C324877_tsws4s", name = "Customer")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wsdm7/wsdm/domain", name = "Customer")
@XmlRootElement(namespace = "wsdm7/wsdm/domain")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "customerID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer customerId;
	/**
	 */

	@Column(name = "email", length = 155)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String email;
	/**
	 */

	@Column(name = "firstname", length = 55)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String firstname;
	/**
	 */

	@Column(name = "lastname", length = 85)
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

	@Column(name = "yearBorn")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer yearBorn;
	/**
	 */

	@Column(name = "address", length = 145)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String address;
	/**
	 */

	@Column(name = "city", length = 85)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String city;
	/**
	 */

	@Column(name = "state", length = 65)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String state;
	/**
	 */

	@Column(name = "zipcode", length = 15)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String zipcode;
	/**
	 */

	@Column(name = "addrSameAsFamily")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer addrSameAsFamily;
	/**
	 */

	@Column(name = "activeYN")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer activeYn;
	/**
	 */

	@Column(name = "password", length = 75)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String password;
	/**
	 */

	@Column(name = "selectTheme", length = 85)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String selectTheme;
	/**
	 */

	@Column(name = "adminYN")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer adminYn;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "parentFK", referencedColumnName = "customerID") })
	@XmlTransient
	Customer customer;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "tswAcctFK", referencedColumnName = "tswAcctID") })
	@XmlTransient
	Tswacct tswacct;
	/**
	 */
	@OneToMany(mappedBy = "customer", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<wsdm.domain.Teamplayers> teamplayerses;
	/**
	 */
	@OneToMany(mappedBy = "customer", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<wsdm.domain.Participant> participants;
	/**
	 */
	@OneToMany(mappedBy = "customer", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<wsdm.domain.Program> programs;
	/**
	 */
	@OneToMany(mappedBy = "customer", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<wsdm.domain.Customer> customers;
	/**
	 */
	@OneToMany(mappedBy = "customerByManagerCustFk", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<wsdm.domain.Team> teamsForManagerCustFk;
	/**
	 */
	@OneToMany(mappedBy = "customer", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<wsdm.domain.Tswacct> tswaccts;
	/**
	 */
	@OneToMany(mappedBy = "customerByManagerCustFk", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<wsdm.domain.Team> teamsForCoachCustFk;
	/**
	 */
	@OneToMany(mappedBy = "customer", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<wsdm.domain.Event> events;

	/**
	 */
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	/**
	 */
	public Integer getCustomerId() {
		return this.customerId;
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
	public void setYearBorn(Integer yearBorn) {
		this.yearBorn = yearBorn;
	}

	/**
	 */
	public Integer getYearBorn() {
		return this.yearBorn;
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
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 */
	public String getZipcode() {
		return this.zipcode;
	}

	/**
	 */
	public void setAddrSameAsFamily(Integer addrSameAsFamily) {
		this.addrSameAsFamily = addrSameAsFamily;
	}

	/**
	 */
	public Integer getAddrSameAsFamily() {
		return this.addrSameAsFamily;
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
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 */
	public void setSelectTheme(String selectTheme) {
		this.selectTheme = selectTheme;
	}

	/**
	 */
	public String getSelectTheme() {
		return this.selectTheme;
	}

	/**
	 */
	public void setAdminYn(Integer adminYn) {
		this.adminYn = adminYn;
	}

	/**
	 */
	public Integer getAdminYn() {
		return this.adminYn;
	}

	/**
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 */
	public Customer getCustomer() {
		return customer;
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
	public void setTeamplayerses(Set<Teamplayers> teamplayerses) {
		this.teamplayerses = teamplayerses;
	}

	/**
	 */
	public Set<Teamplayers> getTeamplayerses() {
		if (teamplayerses == null) {
			teamplayerses = new java.util.LinkedHashSet<wsdm.domain.Teamplayers>();
		}
		return teamplayerses;
	}

	/**
	 */
	public void setParticipants(Set<Participant> participants) {
		this.participants = participants;
	}

	/**
	 */
	public Set<Participant> getParticipants() {
		if (participants == null) {
			participants = new java.util.LinkedHashSet<wsdm.domain.Participant>();
		}
		return participants;
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
	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	/**
	 */
	public Set<Customer> getCustomers() {
		if (customers == null) {
			customers = new java.util.LinkedHashSet<wsdm.domain.Customer>();
		}
		return customers;
	}

	/**
	 */
	public void setTeamsForManagerCustFk(Set<Team> teamsForManagerCustFk) {
		this.teamsForManagerCustFk = teamsForManagerCustFk;
	}

	/**
	 */
	public Set<Team> getTeamsForManagerCustFk() {
		if (teamsForManagerCustFk == null) {
			teamsForManagerCustFk = new java.util.LinkedHashSet<wsdm.domain.Team>();
		}
		return teamsForManagerCustFk;
	}

	/**
	 */
	public void setTswaccts(Set<Tswacct> tswaccts) {
		this.tswaccts = tswaccts;
	}

	/**
	 */
	public Set<Tswacct> getTswaccts() {
		if (tswaccts == null) {
			tswaccts = new java.util.LinkedHashSet<wsdm.domain.Tswacct>();
		}
		return tswaccts;
	}

	/**
	 */
	public void setTeamsForCoachCustFk(Set<Team> teamsForCoachCustFk) {
		this.teamsForCoachCustFk = teamsForCoachCustFk;
	}

	/**
	 */
	public Set<Team> getTeamsForCoachCustFk() {
		if (teamsForCoachCustFk == null) {
			teamsForCoachCustFk = new java.util.LinkedHashSet<wsdm.domain.Team>();
		}
		return teamsForCoachCustFk;
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
	public Customer() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Customer that) {
		setCustomerId(that.getCustomerId());
		setEmail(that.getEmail());
		setFirstname(that.getFirstname());
		setLastname(that.getLastname());
		setPhone(that.getPhone());
		setYearBorn(that.getYearBorn());
		setAddress(that.getAddress());
		setCity(that.getCity());
		setState(that.getState());
		setZipcode(that.getZipcode());
		setAddrSameAsFamily(that.getAddrSameAsFamily());
		setActiveYn(that.getActiveYn());
		setPassword(that.getPassword());
		setSelectTheme(that.getSelectTheme());
		setAdminYn(that.getAdminYn());
		setCustomer(that.getCustomer());
		setTswacct(that.getTswacct());
		setTeamplayerses(new java.util.LinkedHashSet<wsdm.domain.Teamplayers>(that.getTeamplayerses()));
		setParticipants(new java.util.LinkedHashSet<wsdm.domain.Participant>(that.getParticipants()));
		setPrograms(new java.util.LinkedHashSet<wsdm.domain.Program>(that.getPrograms()));
		setCustomers(new java.util.LinkedHashSet<wsdm.domain.Customer>(that.getCustomers()));
		setTeamsForManagerCustFk(new java.util.LinkedHashSet<wsdm.domain.Team>(that.getTeamsForManagerCustFk()));
		setTswaccts(new java.util.LinkedHashSet<wsdm.domain.Tswacct>(that.getTswaccts()));
		setTeamsForCoachCustFk(new java.util.LinkedHashSet<wsdm.domain.Team>(that.getTeamsForCoachCustFk()));
		setEvents(new java.util.LinkedHashSet<wsdm.domain.Event>(that.getEvents()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("customerId=[").append(customerId).append("] ");
		buffer.append("email=[").append(email).append("] ");
		buffer.append("firstname=[").append(firstname).append("] ");
		buffer.append("lastname=[").append(lastname).append("] ");
		buffer.append("phone=[").append(phone).append("] ");
		buffer.append("yearBorn=[").append(yearBorn).append("] ");
		buffer.append("address=[").append(address).append("] ");
		buffer.append("city=[").append(city).append("] ");
		buffer.append("state=[").append(state).append("] ");
		buffer.append("zipcode=[").append(zipcode).append("] ");
		buffer.append("addrSameAsFamily=[").append(addrSameAsFamily).append("] ");
		buffer.append("activeYn=[").append(activeYn).append("] ");
		buffer.append("password=[").append(password).append("] ");
		buffer.append("selectTheme=[").append(selectTheme).append("] ");
		buffer.append("adminYn=[").append(adminYn).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((customerId == null) ? 0 : customerId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Customer))
			return false;
		Customer equalCheck = (Customer) obj;
		if ((customerId == null && equalCheck.customerId != null) || (customerId != null && equalCheck.customerId == null))
			return false;
		if (customerId != null && !customerId.equals(equalCheck.customerId))
			return false;
		return true;
	}
}
