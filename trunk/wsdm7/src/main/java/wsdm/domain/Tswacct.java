package wsdm.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.math.BigDecimal;

import java.util.Calendar;
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
		@NamedQuery(name = "findAllTswaccts", query = "select myTswacct from Tswacct myTswacct"),
		@NamedQuery(name = "findTswacctByPrimaryKey", query = "select myTswacct from Tswacct myTswacct where myTswacct.tswAcctId = ?1") })
@Table(catalog = "C324877_tsws4s", name = "TswAcct")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wsdm7/wsdm/domain", name = "Tswacct")
@XmlRootElement(namespace = "wsdm7/wsdm/domain")
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
	/**
	 */
	@OneToMany(mappedBy = "tswacct", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<wsdm.domain.Game> games;
	/**
	 */
	@OneToMany(mappedBy = "tswacct", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<wsdm.domain.Team> teams;
	/**
	 */
	@OneToMany(mappedBy = "tswacct", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<wsdm.domain.Resource> resources;
	/**
	 */
	@OneToMany(mappedBy = "tswacct", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<wsdm.domain.Price> prices;
	/**
	 */
	@OneToMany(mappedBy = "tswacct", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<wsdm.domain.Participant> participants;
	/**
	 */
	@OneToMany(mappedBy = "tswacct", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<wsdm.domain.Customer> customers;
	/**
	 */
	@OneToMany(mappedBy = "tswacct", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<wsdm.domain.Program> programs;
	/**
	 */
	@OneToMany(mappedBy = "tswacct", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<wsdm.domain.Level> levels;
	/**
	 */
	@OneToMany(mappedBy = "tswacct", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<wsdm.domain.Event> events;
	/**
	 */
	@OneToMany(mappedBy = "tswacct", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<wsdm.domain.Tswacctsport> tswacctsports;
	/**
	 */
	@OneToMany(mappedBy = "tswacct", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<wsdm.domain.Teamplayers> teamplayerses;

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
			games = new java.util.LinkedHashSet<wsdm.domain.Game>();
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
			teams = new java.util.LinkedHashSet<wsdm.domain.Team>();
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
			resources = new java.util.LinkedHashSet<wsdm.domain.Resource>();
		}
		return resources;
	}

	/**
	 */
	public void setPrices(Set<Price> prices) {
		this.prices = prices;
	}

	/**
	 */
	public Set<Price> getPrices() {
		if (prices == null) {
			prices = new java.util.LinkedHashSet<wsdm.domain.Price>();
		}
		return prices;
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
	public void setLevels(Set<Level> levels) {
		this.levels = levels;
	}

	/**
	 */
	public Set<Level> getLevels() {
		if (levels == null) {
			levels = new java.util.LinkedHashSet<wsdm.domain.Level>();
		}
		return levels;
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
	public void setTswacctsports(Set<Tswacctsport> tswacctsports) {
		this.tswacctsports = tswacctsports;
	}

	/**
	 */
	public Set<Tswacctsport> getTswacctsports() {
		if (tswacctsports == null) {
			tswacctsports = new java.util.LinkedHashSet<wsdm.domain.Tswacctsport>();
		}
		return tswacctsports;
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
	public Tswacct() {
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
		setGames(new java.util.LinkedHashSet<wsdm.domain.Game>(that.getGames()));
		setTeams(new java.util.LinkedHashSet<wsdm.domain.Team>(that.getTeams()));
		setResources(new java.util.LinkedHashSet<wsdm.domain.Resource>(that.getResources()));
		setPrices(new java.util.LinkedHashSet<wsdm.domain.Price>(that.getPrices()));
		setParticipants(new java.util.LinkedHashSet<wsdm.domain.Participant>(that.getParticipants()));
		setCustomers(new java.util.LinkedHashSet<wsdm.domain.Customer>(that.getCustomers()));
		setPrograms(new java.util.LinkedHashSet<wsdm.domain.Program>(that.getPrograms()));
		setLevels(new java.util.LinkedHashSet<wsdm.domain.Level>(that.getLevels()));
		setEvents(new java.util.LinkedHashSet<wsdm.domain.Event>(that.getEvents()));
		setTswacctsports(new java.util.LinkedHashSet<wsdm.domain.Tswacctsport>(that.getTswacctsports()));
		setTeamplayerses(new java.util.LinkedHashSet<wsdm.domain.Teamplayers>(that.getTeamplayerses()));
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
}
