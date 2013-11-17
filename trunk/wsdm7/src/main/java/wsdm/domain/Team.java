package wsdm.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.math.BigDecimal;

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
		@NamedQuery(name = "findAllTeams", query = "select myTeam from Team myTeam"),
		@NamedQuery(name = "findTeamByActiveYn", query = "select myTeam from Team myTeam where myTeam.activeYn = ?1"),
		@NamedQuery(name = "findTeamByAmtPaid", query = "select myTeam from Team myTeam where myTeam.amtPaid = ?1"),
		@NamedQuery(name = "findTeamByColor", query = "select myTeam from Team myTeam where myTeam.color = ?1"),
		@NamedQuery(name = "findTeamByColorContaining", query = "select myTeam from Team myTeam where myTeam.color like ?1"),
		@NamedQuery(name = "findTeamByGroup3", query = "select myTeam from Team myTeam where myTeam.group3 = ?1"),
		@NamedQuery(name = "findTeamByGroup3Containing", query = "select myTeam from Team myTeam where myTeam.group3 like ?1"),
		@NamedQuery(name = "findTeamByLosses", query = "select myTeam from Team myTeam where myTeam.losses = ?1"),
		@NamedQuery(name = "findTeamByNotes", query = "select myTeam from Team myTeam where myTeam.notes = ?1"),
		@NamedQuery(name = "findTeamByNotesContaining", query = "select myTeam from Team myTeam where myTeam.notes like ?1"),
		@NamedQuery(name = "findTeamByPrimaryKey", query = "select myTeam from Team myTeam where myTeam.teamId = ?1"),
		@NamedQuery(name = "findTeamByPublishYn", query = "select myTeam from Team myTeam where myTeam.publishYn = ?1"),
		@NamedQuery(name = "findTeamByTeamId", query = "select myTeam from Team myTeam where myTeam.teamId = ?1"),
		@NamedQuery(name = "findTeamByTeamName", query = "select myTeam from Team myTeam where myTeam.teamName = ?1"),
		@NamedQuery(name = "findTeamByTeamNameContaining", query = "select myTeam from Team myTeam where myTeam.teamName like ?1"),
		@NamedQuery(name = "findTeamByTies", query = "select myTeam from Team myTeam where myTeam.ties = ?1"),
		@NamedQuery(name = "findTeamByWins", query = "select myTeam from Team myTeam where myTeam.wins = ?1") })
@Table(catalog = "C324877_tsws4s", name = "Team")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wsdm7/wsdm/domain", name = "Team")
@XmlRootElement(namespace = "wsdm7/wsdm/domain")
public class Team implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "teamID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer teamId;
	/**
	 */

	@Column(name = "teamName", length = 75, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String teamName;
	/**
	 */

	@Column(name = "amtPaid", scale = 2, precision = 32)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal amtPaid;
	/**
	 */

	@Column(name = "wins")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer wins;
	/**
	 */

	@Column(name = "losses")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer losses;
	/**
	 */

	@Column(name = "ties")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer ties;
	/**
	 */

	@Column(name = "group3", length = 40)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String group3;
	/**
	 */

	@Column(name = "color", length = 45)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String color;
	/**
	 */

	@Column(name = "publishYN")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer publishYn;
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
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "managerCustFK", referencedColumnName = "customerID") })
	@XmlTransient
	Customer customerByManagerCustFk;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "levelFK", referencedColumnName = "levelID") })
	@XmlTransient
	Level level;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "programFK", referencedColumnName = "programID", nullable = false) })
	@XmlTransient
	Program program;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "tswAcctFK", referencedColumnName = "tswAcctID") })
	@XmlTransient
	Tswacct tswacct;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "coachCustFK", referencedColumnName = "customerID") })
	@XmlTransient
	Customer customerByCoachCustFk;
	/**
	 */
	@OneToMany(mappedBy = "teamByVisitorTeamFk", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<wsdm.domain.Game> gamesForVisitorTeamFk;
	/**
	 */
	@OneToMany(mappedBy = "team", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<wsdm.domain.Teamplayers> teamplayerses;
	/**
	 */
	@OneToMany(mappedBy = "teamByVisitorTeamFk", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<wsdm.domain.Game> gamesForHomeTeamFk;

	/**
	 */
	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	/**
	 */
	public Integer getTeamId() {
		return this.teamId;
	}

	/**
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	/**
	 */
	public String getTeamName() {
		return this.teamName;
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
	public void setWins(Integer wins) {
		this.wins = wins;
	}

	/**
	 */
	public Integer getWins() {
		return this.wins;
	}

	/**
	 */
	public void setLosses(Integer losses) {
		this.losses = losses;
	}

	/**
	 */
	public Integer getLosses() {
		return this.losses;
	}

	/**
	 */
	public void setTies(Integer ties) {
		this.ties = ties;
	}

	/**
	 */
	public Integer getTies() {
		return this.ties;
	}

	/**
	 */
	public void setGroup3(String group3) {
		this.group3 = group3;
	}

	/**
	 */
	public String getGroup3() {
		return this.group3;
	}

	/**
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 */
	public String getColor() {
		return this.color;
	}

	/**
	 */
	public void setPublishYn(Integer publishYn) {
		this.publishYn = publishYn;
	}

	/**
	 */
	public Integer getPublishYn() {
		return this.publishYn;
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
	public void setCustomerByManagerCustFk(Customer customerByManagerCustFk) {
		this.customerByManagerCustFk = customerByManagerCustFk;
	}

	/**
	 */
	public Customer getCustomerByManagerCustFk() {
		return customerByManagerCustFk;
	}

	/**
	 */
	public void setLevel(Level level) {
		this.level = level;
	}

	/**
	 */
	public Level getLevel() {
		return level;
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
	public void setCustomerByCoachCustFk(Customer customerByCoachCustFk) {
		this.customerByCoachCustFk = customerByCoachCustFk;
	}

	/**
	 */
	public Customer getCustomerByCoachCustFk() {
		return customerByCoachCustFk;
	}

	/**
	 */
	public void setGamesForVisitorTeamFk(Set<Game> gamesForVisitorTeamFk) {
		this.gamesForVisitorTeamFk = gamesForVisitorTeamFk;
	}

	/**
	 */
	public Set<Game> getGamesForVisitorTeamFk() {
		if (gamesForVisitorTeamFk == null) {
			gamesForVisitorTeamFk = new java.util.LinkedHashSet<wsdm.domain.Game>();
		}
		return gamesForVisitorTeamFk;
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
	public void setGamesForHomeTeamFk(Set<Game> gamesForHomeTeamFk) {
		this.gamesForHomeTeamFk = gamesForHomeTeamFk;
	}

	/**
	 */
	public Set<Game> getGamesForHomeTeamFk() {
		if (gamesForHomeTeamFk == null) {
			gamesForHomeTeamFk = new java.util.LinkedHashSet<wsdm.domain.Game>();
		}
		return gamesForHomeTeamFk;
	}

	/**
	 */
	public Team() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Team that) {
		setTeamId(that.getTeamId());
		setTeamName(that.getTeamName());
		setAmtPaid(that.getAmtPaid());
		setWins(that.getWins());
		setLosses(that.getLosses());
		setTies(that.getTies());
		setGroup3(that.getGroup3());
		setColor(that.getColor());
		setPublishYn(that.getPublishYn());
		setActiveYn(that.getActiveYn());
		setNotes(that.getNotes());
		setCustomerByManagerCustFk(that.getCustomerByManagerCustFk());
		setLevel(that.getLevel());
		setProgram(that.getProgram());
		setTswacct(that.getTswacct());
		setCustomerByCoachCustFk(that.getCustomerByCoachCustFk());
		setGamesForVisitorTeamFk(new java.util.LinkedHashSet<wsdm.domain.Game>(that.getGamesForVisitorTeamFk()));
		setTeamplayerses(new java.util.LinkedHashSet<wsdm.domain.Teamplayers>(that.getTeamplayerses()));
		setGamesForHomeTeamFk(new java.util.LinkedHashSet<wsdm.domain.Game>(that.getGamesForHomeTeamFk()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("teamId=[").append(teamId).append("] ");
		buffer.append("teamName=[").append(teamName).append("] ");
		buffer.append("amtPaid=[").append(amtPaid).append("] ");
		buffer.append("wins=[").append(wins).append("] ");
		buffer.append("losses=[").append(losses).append("] ");
		buffer.append("ties=[").append(ties).append("] ");
		buffer.append("group3=[").append(group3).append("] ");
		buffer.append("color=[").append(color).append("] ");
		buffer.append("publishYn=[").append(publishYn).append("] ");
		buffer.append("activeYn=[").append(activeYn).append("] ");
		buffer.append("notes=[").append(notes).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((teamId == null) ? 0 : teamId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Team))
			return false;
		Team equalCheck = (Team) obj;
		if ((teamId == null && equalCheck.teamId != null) || (teamId != null && equalCheck.teamId == null))
			return false;
		if (teamId != null && !teamId.equals(equalCheck.teamId))
			return false;
		return true;
	}
}
