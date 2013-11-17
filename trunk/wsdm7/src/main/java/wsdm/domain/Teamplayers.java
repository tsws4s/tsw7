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
		@NamedQuery(name = "findAllTeamplayerss", query = "select myTeamplayers from Teamplayers myTeamplayers"),
		@NamedQuery(name = "findTeamplayersByPrimaryKey", query = "select myTeamplayers from Teamplayers myTeamplayers where myTeamplayers.teamPlayersId = ?1") })
@Table(catalog = "C324877_tsws4s", name = "TeamPlayers")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wsdm7/wsdm/domain", name = "Teamplayers")
@XmlRootElement(namespace = "wsdm7/wsdm/domain")
public class Teamplayers implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "teamPlayersID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer teamPlayersId;
	/**
	 */

	@Column(name = "amtPaid", scale = 2, precision = 32)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal amtPaid;
	/**
	 */

	@Column(name = "notes", length = 250)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String notes;
	/**
	 */

	@Column(name = "group2", length = 20)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String group2;
	/**
	 */

	@Column(name = "signedWaiverYN")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer signedWaiverYn;
	/**
	 */

	@Column(name = "activeYN")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer activeYn;
	/**
	 */

	@Column(name = "captain")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer captain;
	/**
	 */

	@Column(name = "sportPositionFK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer sportPositionFk;
	/**
	 */

	@Column(name = "otherAmtPaid", scale = 2, precision = 32)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal otherAmtPaid;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "customerFK", referencedColumnName = "customerID") })
	@XmlTransient
	Customer customer;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "levelFK", referencedColumnName = "levelID") })
	@XmlTransient
	Level level;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "programFK", referencedColumnName = "programID") })
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
	@JoinColumns({ @JoinColumn(name = "teamFK", referencedColumnName = "teamID") })
	@XmlTransient
	Team team;
	/**
	 */
	@OneToMany(mappedBy = "teamplayers", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<wsdm.domain.Gamestats> gamestatses;

	/**
	 */
	public void setTeamPlayersId(Integer teamPlayersId) {
		this.teamPlayersId = teamPlayersId;
	}

	/**
	 */
	public Integer getTeamPlayersId() {
		return this.teamPlayersId;
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
	public void setGroup2(String group2) {
		this.group2 = group2;
	}

	/**
	 */
	public String getGroup2() {
		return this.group2;
	}

	/**
	 */
	public void setSignedWaiverYn(Integer signedWaiverYn) {
		this.signedWaiverYn = signedWaiverYn;
	}

	/**
	 */
	public Integer getSignedWaiverYn() {
		return this.signedWaiverYn;
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
	public void setCaptain(Integer captain) {
		this.captain = captain;
	}

	/**
	 */
	public Integer getCaptain() {
		return this.captain;
	}

	/**
	 */
	public void setSportPositionFk(Integer sportPositionFk) {
		this.sportPositionFk = sportPositionFk;
	}

	/**
	 */
	public Integer getSportPositionFk() {
		return this.sportPositionFk;
	}

	/**
	 */
	public void setOtherAmtPaid(BigDecimal otherAmtPaid) {
		this.otherAmtPaid = otherAmtPaid;
	}

	/**
	 */
	public BigDecimal getOtherAmtPaid() {
		return this.otherAmtPaid;
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
	public void setTeam(Team team) {
		this.team = team;
	}

	/**
	 */
	public Team getTeam() {
		return team;
	}

	/**
	 */
	public void setGamestatses(Set<Gamestats> gamestatses) {
		this.gamestatses = gamestatses;
	}

	/**
	 */
	public Set<Gamestats> getGamestatses() {
		if (gamestatses == null) {
			gamestatses = new java.util.LinkedHashSet<wsdm.domain.Gamestats>();
		}
		return gamestatses;
	}

	/**
	 */
	public Teamplayers() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Teamplayers that) {
		setTeamPlayersId(that.getTeamPlayersId());
		setAmtPaid(that.getAmtPaid());
		setNotes(that.getNotes());
		setGroup2(that.getGroup2());
		setSignedWaiverYn(that.getSignedWaiverYn());
		setActiveYn(that.getActiveYn());
		setCaptain(that.getCaptain());
		setSportPositionFk(that.getSportPositionFk());
		setOtherAmtPaid(that.getOtherAmtPaid());
		setCustomer(that.getCustomer());
		setLevel(that.getLevel());
		setProgram(that.getProgram());
		setTswacct(that.getTswacct());
		setTeam(that.getTeam());
		setGamestatses(new java.util.LinkedHashSet<wsdm.domain.Gamestats>(that.getGamestatses()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("teamPlayersId=[").append(teamPlayersId).append("] ");
		buffer.append("amtPaid=[").append(amtPaid).append("] ");
		buffer.append("notes=[").append(notes).append("] ");
		buffer.append("group2=[").append(group2).append("] ");
		buffer.append("signedWaiverYn=[").append(signedWaiverYn).append("] ");
		buffer.append("activeYn=[").append(activeYn).append("] ");
		buffer.append("captain=[").append(captain).append("] ");
		buffer.append("sportPositionFk=[").append(sportPositionFk).append("] ");
		buffer.append("otherAmtPaid=[").append(otherAmtPaid).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((teamPlayersId == null) ? 0 : teamPlayersId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Teamplayers))
			return false;
		Teamplayers equalCheck = (Teamplayers) obj;
		if ((teamPlayersId == null && equalCheck.teamPlayersId != null) || (teamPlayersId != null && equalCheck.teamPlayersId == null))
			return false;
		if (teamPlayersId != null && !teamPlayersId.equals(equalCheck.teamPlayersId))
			return false;
		return true;
	}
}
