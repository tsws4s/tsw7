package wsdm.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.math.BigDecimal;

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
		@NamedQuery(name = "findAllTeams", query = "select myTeam from Team myTeam"),
		@NamedQuery(name = "findTeamByActiveYn", query = "select myTeam from Team myTeam where myTeam.activeYn = ?1"),
		@NamedQuery(name = "findTeamByPrimaryKey", query = "select myTeam from Team myTeam where myTeam.teamId = ?1"),
		@NamedQuery(name = "findTeamByPublishYn", query = "select myTeam from Team myTeam where myTeam.publishYn = ?1"),
		@NamedQuery(name = "findTeamByTeamId", query = "select myTeam from Team myTeam where myTeam.teamId = ?1"),
		@NamedQuery(name = "findTeamByTeamName", query = "select myTeam from Team myTeam where myTeam.teamName = ?1") })
@Table(catalog = "C324877_tsws4s", name = "Team")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wsdm4/wsdm/domain", name = "Team")
@XmlRootElement(namespace = "wsdm4/wsdm/domain")
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
	
	@Column(name = "levelFK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer levelFK;
	/**
	 */
	
	@Column(name = "programFK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer programFK;
	/**
	 */
	
	@Column(name = "coachCustFK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer coachCustFK;
	/**
	 */
	
	@Column(name = "managerCustFK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer managerCustFK;
	/**
	 */
	
	@Column(name = "tswAcctFK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer tswAcctFK;
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
	
	
	public Team() {
	}

	public Integer getLevelFK() {
		return levelFK;
	}

	public void setLevelFK(Integer levelFK) {
		this.levelFK = levelFK;
	}

	public Integer getProgramFK() {
		return programFK;
	}

	public void setProgramFK(Integer programFK) {
		this.programFK = programFK;
	}

	public Integer getCoachCustFK() {
		return coachCustFK;
	}

	public void setCoachCustFK(Integer coachCustFK) {
		this.coachCustFK = coachCustFK;
	}

	public Integer getManagerCustFK() {
		return managerCustFK;
	}

	public void setManagerCustFK(Integer managerCustFK) {
		this.managerCustFK = managerCustFK;
	}

	public Integer getTswAcctFK() {
		return tswAcctFK;
	}

	public void setTswAcctFK(Integer tswAcctFK) {
		this.tswAcctFK = tswAcctFK;
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
