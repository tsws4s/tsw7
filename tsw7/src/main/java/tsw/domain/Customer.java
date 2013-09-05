package tsw.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
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
		@NamedQuery(name = "findAllCustomers4tsw", query = "select myCustomer from Customer myCustomer where tswAcctFK = ?1"),
		@NamedQuery(name = "findCustomerByAddress", query = "select myCustomer from Customer myCustomer where myCustomer.address = ?1"),
		@NamedQuery(name = "findCustomerByAddressContaining", query = "select myCustomer from Customer myCustomer where myCustomer.address like ?1"),
		@NamedQuery(name = "findCustomerByCity", query = "select myCustomer from Customer myCustomer where myCustomer.city = ?1"),
		@NamedQuery(name = "findCustomerByCityContaining", query = "select myCustomer from Customer myCustomer where myCustomer.city like ?1"),
		@NamedQuery(name = "findCustomerByCustomerId", query = "select myCustomer from Customer myCustomer where myCustomer.customerId = ?1"),
		@NamedQuery(name = "findCustomerByEmail", query = "select myCustomer from Customer myCustomer where myCustomer.email = ?1"),
		@NamedQuery(name = "findCustomerByEmailAddr", query = "select myCustomer from Customer myCustomer where myCustomer.email = ?1"),
		@NamedQuery(name = "findCustomerByEmailContaining", query = "select myCustomer from Customer myCustomer where myCustomer.email like ?1"),
		@NamedQuery(name = "findCustomerByFirstname", query = "select myCustomer from Customer myCustomer where myCustomer.firstname = ?1"),
		@NamedQuery(name = "findCustomerByName", query = "select myCustomer from Customer myCustomer where tswAcctfk = ?1 and myCustomer.firstname = ?2 and myCustomer.lastname = ?3"),
		@NamedQuery(name = "findCustomerByFirstnameContaining", query = "select myCustomer from Customer myCustomer where (myCustomer.firstname like ?1)"),
		@NamedQuery(name = "findCustomerByFirstnameContaining4tsw", query = "select myCustomer from Customer myCustomer where (myCustomer.firstname like ?1) and (tswAcctFK = ?2)"),
		@NamedQuery(name = "findCustomerByLastname", query = "select myCustomer from Customer myCustomer where myCustomer.lastname = ?1"),
		@NamedQuery(name = "findCustomerByLastnameContaining", query = "select myCustomer from Customer myCustomer where (myCustomer.lastname like ?1)"),
		@NamedQuery(name = "findCustomerByLastnameContaining4tsw", query = "select myCustomer from Customer myCustomer where (myCustomer.lastname like ?1) and (tswAcctFK = ?2)"),
		@NamedQuery(name = "findCustomerByPhone", query = "select myCustomer from Customer myCustomer where myCustomer.phone = ?1"),
		@NamedQuery(name = "findCustomerByPhoneContaining", query = "select myCustomer from Customer myCustomer where myCustomer.phone like ?1"),
		@NamedQuery(name = "findCustomerByPrimaryKey", query = "select myCustomer from Customer myCustomer where myCustomer.customerId = ?1"),
		@NamedQuery(name = "findCustomerByState", query = "select myCustomer from Customer myCustomer where myCustomer.state = ?1"),
		@NamedQuery(name = "findCustomerByStateContaining", query = "select myCustomer from Customer myCustomer where myCustomer.state like ?1"),
		@NamedQuery(name = "findCustomerByYearBorn", query = "select myCustomer from Customer myCustomer where myCustomer.yearBorn = ?1"),
		@NamedQuery(name = "findCustomerByZipcode", query = "select myCustomer from Customer myCustomer where myCustomer.zipcode = ?1"),
		@NamedQuery(name = "findCustomerByZipcodeContaining", query = "select myCustomer from Customer myCustomer where myCustomer.zipcode like ?1") })
@Table(catalog = "tsws4s_4", name = "Customer")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "tsw7/tsw/domain", name = "Customer")
@XmlRootElement(namespace = "tsw7/tsw/domain")
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
	
	@Column(name = "salesRepCode", length = 25)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String salesRepCode;

	@Column(name = "salesDiscount")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer salesDiscount;
	
	@Column(name = "salesCommission")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer salesCommission;
	
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
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<tsw.domain.Participant> participants;
	/**
	 */
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<tsw.domain.Program> programs;
	/**
	 */
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<tsw.domain.Customer> customers;
	/**
	 */
	@OneToMany(mappedBy = "customerByManagerCustFk", fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<tsw.domain.Team> teamsForManagerCustFk;
	/**
	 */
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<tsw.domain.Tswacct> tswaccts;
	/**
	 */
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<tsw.domain.Teamplayers> teamplayerses;
	/**
	 */
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<tsw.domain.Game> games;

	/**
	 */
	@OneToMany(mappedBy = "customerByManagerCustFk", fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<tsw.domain.Team> teamsForCoachCustFk;
	/**
	 */
	
	@Column(name = "password", length = 85)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String password;

	@Column(name = "activeYN")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer activeYn;

	@Column(name = "adminYN")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer adminYn;

	@Column(name = "selectTheme", length = 45) 
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String selectTheme;

	/**
	 */
	public Customer() {
	}

	/**
	 */
	public Integer getCustomerId() {
		return this.customerId;
	}

	/**
	 */
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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
	public void setParticipants(Set<Participant> participants) {
		this.participants = participants;
	}

	/**
	 */
	public Set<Participant> getParticipants() {
		if (participants == null) {
			participants = new java.util.LinkedHashSet<tsw.domain.Participant>();
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
			programs = new java.util.LinkedHashSet<tsw.domain.Program>();
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
			customers = new java.util.LinkedHashSet<tsw.domain.Customer>();
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
			teamsForManagerCustFk = new java.util.LinkedHashSet<tsw.domain.Team>();
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
			tswaccts = new java.util.LinkedHashSet<tsw.domain.Tswacct>();
		}
		return tswaccts;
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
			teamplayerses = new java.util.LinkedHashSet<tsw.domain.Teamplayers>();
		}
		return teamplayerses;
	}

	/**
	 */
	public void setGames(Set<Game> games) {
		this.games = games;
	}

	/**
	 */
	public Set<Game> getGames() {
		if (games == null) {
			games = new java.util.LinkedHashSet<tsw.domain.Game>();
		}
		return games;
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
			teamsForCoachCustFk = new java.util.LinkedHashSet<tsw.domain.Team>();
		}
		return teamsForCoachCustFk;
	}
	
	public Integer getAddrSameAsFamily() {
		return addrSameAsFamily;
	}

	public void setAddrSameAsFamily(Integer addrSameAsFamily) {
		this.addrSameAsFamily = addrSameAsFamily;
	}
	
	public String getSelectTheme() {
		return selectTheme;
	}
	
	public void setSelectTheme(String selectTheme) {
		this.selectTheme = selectTheme;
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
	public void setAdminYn(Integer adminYn) {
		this.adminYn = adminYn;
	}
	/**
	 */
	public Integer getAdminYn() {
		return this.adminYn;
	}
	
	public String getSalesRepCode() {
		return salesRepCode;
	}

	public void setSalesRepCode(String salesRepCode) {
		this.salesRepCode = salesRepCode;
	}

	public Integer getSalesDiscount() {
		return salesDiscount;
	}

	public void setSalesDiscount(Integer salesDiscount) {
		this.salesDiscount = salesDiscount;
	}

	public Integer getSalesCommission() {
		return salesCommission;
	}

	public void setSalesCommission(Integer salesCommission) {
		this.salesCommission = salesCommission;
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
		setCustomer(that.getCustomer());
		setTswacct(that.getTswacct());
		setParticipants(new java.util.LinkedHashSet<tsw.domain.Participant>(that.getParticipants()));
		setPrograms(new java.util.LinkedHashSet<tsw.domain.Program>(that.getPrograms()));
		setCustomers(new java.util.LinkedHashSet<tsw.domain.Customer>(that.getCustomers()));
		setTeamsForManagerCustFk(new java.util.LinkedHashSet<tsw.domain.Team>(that.getTeamsForManagerCustFk()));
		setTswaccts(new java.util.LinkedHashSet<tsw.domain.Tswacct>(that.getTswaccts()));
		setTeamplayerses(new java.util.LinkedHashSet<tsw.domain.Teamplayers>(that.getTeamplayerses()));
		setGames(new java.util.LinkedHashSet<tsw.domain.Game>(that.getGames()));
		setTeamsForCoachCustFk(new java.util.LinkedHashSet<tsw.domain.Team>(that.getTeamsForCoachCustFk()));
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
