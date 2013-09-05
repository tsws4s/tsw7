package tsw.domain;

import java.io.Serializable;

import java.lang.StringBuilder;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllTeamplayerss", query = "select myTeamplayers from Teamplayers myTeamplayers"),
		@NamedQuery(name = "findAllTeamplayerss4tsw", query = "select myTeamplayers from Teamplayers myTeamplayers where tswAcctFk = ?1"),
		@NamedQuery(name = "findTeamplayersByActiveYn", query = "select myTeamplayers from Teamplayers myTeamplayers where myTeamplayers.activeYn = ?1"),
		@NamedQuery(name = "findTeamplayersByAmtPaid", query = "select myTeamplayers from Teamplayers myTeamplayers where myTeamplayers.amtPaid = ?1"),
		@NamedQuery(name = "findTeamplayersByGroup2", query = "select myTeamplayers from Teamplayers myTeamplayers where myTeamplayers.group2 = ?1"),
		@NamedQuery(name = "findTeamplayersByGroup2Containing", query = "select myTeamplayers from Teamplayers myTeamplayers where myTeamplayers.group2 like ?1"),
		@NamedQuery(name = "findTeamplayersByNotes", query = "select myTeamplayers from Teamplayers myTeamplayers where myTeamplayers.notes = ?1"),
		@NamedQuery(name = "findTeamplayersByNotesContaining", query = "select myTeamplayers from Teamplayers myTeamplayers where myTeamplayers.notes like ?1"),
		@NamedQuery(name = "findTeamplayersByPrimaryKey", query = "select myTeamplayers from Teamplayers myTeamplayers where myTeamplayers.teamPlayersId = ?1"),
		@NamedQuery(name = "findTeamplayersBySignedWaiverYn", query = "select myTeamplayers from Teamplayers myTeamplayers where myTeamplayers.signedWaiverYn = ?1"),
		@NamedQuery(name = "findTeamplayersByTeamPlayersId", query = "select myTeamplayers from Teamplayers myTeamplayers where myTeamplayers.teamPlayersId = ?1") })
@Table(catalog = "tsws4s_4", name = "TeamPlayers")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "tsw7/tsw/domain", name = "Teamplayers")
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
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "sportPositionFK", referencedColumnName = "sportPositionId") })
	@XmlTransient
	Sportposition sportPosition;

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
	java.util.Set<tsw.domain.Gamestats> gamestatses;
	
	@Transient
	@XmlTransient
	Integer selected_id4;
	
	public Integer getSelected_id4() {
		return selected_id4;
	}

	public void setSelected_id4(Integer selected_id4) {
		this.selected_id4 = selected_id4;
	}

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
		if(this.amtPaid==null){
			MathContext mc = new MathContext(8);
			BigDecimal amtPaid = new BigDecimal("0.00",mc);
			return amtPaid;
		}
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
	public void setSportPosition(Sportposition sportPosition) {
		this.sportPosition = sportPosition;
	}

	/**
	 */
	public Sportposition getSportPosition() {
		return this.sportPosition;
	}

	/**
	 */
	public void setOtherAmtPaid(BigDecimal otherAmtPaid) {
		this.otherAmtPaid = otherAmtPaid;
	}

	/**
	 */
	public BigDecimal getOtherAmtPaid() {
		if(this.otherAmtPaid==null){
			MathContext mc = new MathContext(8);
			BigDecimal otherAmtPaid = new BigDecimal("0.00",mc);
			return otherAmtPaid;
		}
		return this.otherAmtPaid;
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
			gamestatses = new java.util.LinkedHashSet<tsw.domain.Gamestats>();
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
		setCustomer(that.getCustomer());
		setLevel(that.getLevel());
		setProgram(that.getProgram());
		setTswacct(that.getTswacct());
		setTeam(that.getTeam());
		setCaptain(that.getCaptain());
		setSportPosition(that.getSportPosition());
		setOtherAmtPaid(that.getOtherAmtPaid());
		setGamestatses(new java.util.LinkedHashSet<tsw.domain.Gamestats>(that.getGamestatses()));
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
