package tsw.domain;

import java.io.Serializable;

import java.lang.StringBuilder;
import java.math.BigDecimal;

import java.util.Calendar;
import java.util.Set;

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
		@NamedQuery(name = "findAllTswaccts", query = "select myTswacct from Tswacct myTswacct"),
		@NamedQuery(name = "findTswacctByAcctName", query = "select myTswacct from Tswacct myTswacct where myTswacct.acctName = ?1"),
		@NamedQuery(name = "findTswacctByAcctNameContaining", query = "select myTswacct from Tswacct myTswacct where myTswacct.acctName like ?1"),
		@NamedQuery(name = "findTswacctByActiveYn", query = "select myTswacct from Tswacct myTswacct where myTswacct.activeYn = ?1"),
		@NamedQuery(name = "findTswacctByAmtPaid", query = "select myTswacct from Tswacct myTswacct where myTswacct.amtPaid = ?1"),
		@NamedQuery(name = "findTswacctByEstablishDate", query = "select myTswacct from Tswacct myTswacct where myTswacct.establishDate = ?1"),
		@NamedQuery(name = "findTswacctByEstablishDateAfter", query = "select myTswacct from Tswacct myTswacct where myTswacct.establishDate > ?1"),
		@NamedQuery(name = "findTswacctByEstablishDateBefore", query = "select myTswacct from Tswacct myTswacct where myTswacct.establishDate < ?1"),
		@NamedQuery(name = "findTswacctByExpireDate", query = "select myTswacct from Tswacct myTswacct where myTswacct.expireDate = ?1"),
		@NamedQuery(name = "findTswacctByExpireDateAfter", query = "select myTswacct from Tswacct myTswacct where myTswacct.expireDate > ?1"),
		@NamedQuery(name = "findTswacctByExpireDateBefore", query = "select myTswacct from Tswacct myTswacct where myTswacct.expireDate < ?1"),
		@NamedQuery(name = "findTswacctByPrimaryKey", query = "select myTswacct from Tswacct myTswacct where myTswacct.tswAcctId = ?1"),
		@NamedQuery(name = "findTswacctBySubscrType", query = "select myTswacct from Tswacct myTswacct where myTswacct.subscrType = ?1"),
		@NamedQuery(name = "findTswacctBySubscrTypeContaining", query = "select myTswacct from Tswacct myTswacct where myTswacct.subscrType like ?1"),
		@NamedQuery(name = "findTswacctByTswAcctId", query = "select myTswacct from Tswacct myTswacct where myTswacct.tswAcctId = ?1") })
@Table(catalog = "tsws4s_4", name = "TswAcct")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "tsw7/tsw/domain", name = "Tswacct")
@XmlRootElement(namespace = "tsw7/tsw/domain")
public class Tswacct implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "tswAcctID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer tswAcctId;
	/**
	 */

	@Column(name = "acctName", length = 155)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String acctName;
	/**
	 */

	@Column(name = "subscrType", length = 155)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String subscrType;
	/**
	 */

	@Column(name = "amtPaid", scale = 2, precision = 32)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal amtPaid;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "establishDate")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar establishDate;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "expireDate")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar expireDate;
	/**
	 */

	@Column(name = "activeYN")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer activeYn;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "acctAdminFK", referencedColumnName = "customerID") })
	@XmlTransient
	Customer customer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "salesRepFk", referencedColumnName = "customerID") })
	@XmlTransient
	Customer customerBySalesRepFk;
	
	@Column(name = "amtDiscount", scale = 2, precision = 32)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal amtDiscount;

	/**
	 */
	@OneToMany(mappedBy = "tswacct", fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<tsw.domain.Game> games;
	/**
	 */
	@OneToMany(mappedBy = "tswacct", fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<tsw.domain.Team> teams;
	/**
	 */
	@OneToMany(mappedBy = "tswacct", fetch = FetchType.EAGER)
	@XmlElement(name = "", namespace = "")
	java.util.Set<tsw.domain.Resource> resources;
	/**
	 */
	@OneToMany(mappedBy = "tswacct", fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<tsw.domain.Participant> participants;
	/**
	 */
	@OneToMany(mappedBy = "tswacct", fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<tsw.domain.Customer> customers;
	/**
	 */
	@OneToMany(mappedBy = "tswacct", fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<tsw.domain.Program> programs;
	/**
	 */
	@OneToMany(mappedBy = "tswacct", fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<tsw.domain.Level> levels;
	/**
	 */
	@OneToMany(mappedBy = "tswacct", fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<tsw.domain.Users> userses;
	/**
	 */
	@OneToMany(mappedBy = "tswacct", fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<tsw.domain.Teamplayers> teamplayerses;
	
	/**
	 */
	public Tswacct() {
	}
	
	/**
	 */
	public void setTswAcctId(Integer tswAcctId) {
		this.tswAcctId = tswAcctId;
	}

	/**
	 */
	public Integer getTswAcctId() {
		return this.tswAcctId;
	}

	/**
	 */
	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}

	/**
	 */
	public String getAcctName() {
		return this.acctName;
	}

	/**
	 */
	public void setSubscrType(String subscrType) {
		this.subscrType = subscrType;
	}

	/**
	 */
	public String getSubscrType() {
		return this.subscrType;
	}

	/**
	 */
	public void setAmtPaid(BigDecimal amtPaid) {
		this.amtPaid = amtPaid;
	}

	/**
	 */
	public BigDecimal getAmtPaid() {
		return this.amtPaid;
	}

	/**
	 */
	public void setEstablishDate(Calendar establishDate) {
		this.establishDate = establishDate;
	}

	/**
	 */
	public Calendar getEstablishDate() {
		return this.establishDate;
	}

	/**
	 */
	public void setExpireDate(Calendar expireDate) {
		this.expireDate = expireDate;
	}

	/**
	 */
	public Calendar getExpireDate() {
		return this.expireDate;
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
	public void setTeams(Set<Team> teams) {
		this.teams = teams;
	}

	/**
	 */
	public Set<Team> getTeams() {
		if (teams == null) {
			teams = new java.util.LinkedHashSet<tsw.domain.Team>();
		}
		return teams;
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
			resources = new java.util.LinkedHashSet<tsw.domain.Resource>();
		}
		return resources;
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
	public void setLevels(Set<Level> levels) {
		this.levels = levels;
	}

	/**
	 */
	public Set<Level> getLevels() {
		if (levels == null) {
			levels = new java.util.LinkedHashSet<tsw.domain.Level>();
		}
		return levels;
	}

	/**
	 */
	public void setUserses(Set<Users> userses) {
		this.userses = userses;
	}

	/**
	 */
	public Set<Users> getUserses() {
		if (userses == null) {
			userses = new java.util.LinkedHashSet<tsw.domain.Users>();
		}
		return userses;
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

	public Customer getCustomerBySalesRepFk() {
		return customerBySalesRepFk;
	}

	public void setCustomerBySalesRepFk(Customer customerBySalesRepFk) {
		this.customerBySalesRepFk = customerBySalesRepFk;
	}

	public BigDecimal getAmtDiscount() {
		return amtDiscount;
	}

	public void setAmtDiscount(BigDecimal amtDiscount) {
		this.amtDiscount = amtDiscount;
	}
	
	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Tswacct that) {
		setTswAcctId(that.getTswAcctId());
		setAcctName(that.getAcctName());
		setSubscrType(that.getSubscrType());
		setAmtPaid(that.getAmtPaid());
		setEstablishDate(that.getEstablishDate());
		setExpireDate(that.getExpireDate());
		setActiveYn(that.getActiveYn());
		setCustomer(that.getCustomer());
		setGames(new java.util.LinkedHashSet<tsw.domain.Game>(that.getGames()));
		setTeams(new java.util.LinkedHashSet<tsw.domain.Team>(that.getTeams()));
		setResources(new java.util.LinkedHashSet<tsw.domain.Resource>(that.getResources()));
		setParticipants(new java.util.LinkedHashSet<tsw.domain.Participant>(that.getParticipants()));
		setCustomers(new java.util.LinkedHashSet<tsw.domain.Customer>(that.getCustomers()));
		setPrograms(new java.util.LinkedHashSet<tsw.domain.Program>(that.getPrograms()));
		setLevels(new java.util.LinkedHashSet<tsw.domain.Level>(that.getLevels()));
		setUserses(new java.util.LinkedHashSet<tsw.domain.Users>(that.getUserses()));
		setTeamplayerses(new java.util.LinkedHashSet<tsw.domain.Teamplayers>(that.getTeamplayerses()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("tswAcctId=[").append(tswAcctId).append("] ");
		buffer.append("acctName=[").append(acctName).append("] ");
		buffer.append("subscrType=[").append(subscrType).append("] ");
		buffer.append("amtPaid=[").append(amtPaid).append("] ");
		buffer.append("establishDate=[").append(establishDate).append("] ");
		buffer.append("expireDate=[").append(expireDate).append("] ");
		buffer.append("activeYn=[").append(activeYn).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((tswAcctId == null) ? 0 : tswAcctId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Tswacct))
			return false;
		Tswacct equalCheck = (Tswacct) obj;
		if ((tswAcctId == null && equalCheck.tswAcctId != null) || (tswAcctId != null && equalCheck.tswAcctId == null))
			return false;
		if (tswAcctId != null && !tswAcctId.equals(equalCheck.tswAcctId))
			return false;
		return true;
	}

	public Integer getDefaultResourceId() {
		
		// DO Auto-generated method stub
		if(getResources().isEmpty()){
			return new Integer(1);
		}
		return getResources().iterator().next().getResourceId();	
	}


}
