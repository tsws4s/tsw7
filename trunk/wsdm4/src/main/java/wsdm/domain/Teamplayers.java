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
		@NamedQuery(name = "findAllTeamplayerss", query = "select myTeamplayers from Teamplayers myTeamplayers"),
		@NamedQuery(name = "findTeamplayersByActiveYn", query = "select myTeamplayers from Teamplayers myTeamplayers where myTeamplayers.activeYn = ?1"),
		@NamedQuery(name = "findTeamplayersByPrimaryKey", query = "select myTeamplayers from Teamplayers myTeamplayers where myTeamplayers.teamPlayersId = ?1"),
		@NamedQuery(name = "findTeamplayersBySignedWaiverYn", query = "select myTeamplayers from Teamplayers myTeamplayers where myTeamplayers.signedWaiverYn = ?1"),
		@NamedQuery(name = "findTeamplayersBySportPositionFk", query = "select myTeamplayers from Teamplayers myTeamplayers where myTeamplayers.sportPositionFk = ?1"),
		@NamedQuery(name = "findTeamplayersByTeamPlayersId", query = "select myTeamplayers from Teamplayers myTeamplayers where myTeamplayers.teamPlayersId = ?1") })
@Table(catalog = "C324877_tsws4s", name = "TeamPlayers")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wsdm4/wsdm/domain", name = "Teamplayers")
@XmlRootElement(namespace = "wsdm4/wsdm/domain")
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
	public void setTeamPlayersId(Integer teamPlayersId) {
		this.teamPlayersId = teamPlayersId;
	}
	
	@Column(name = "teamFK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer teamFK;
	/**
	 */
	
	@Column(name = "customerFK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer customerFK;
	/**
	 */
	
	@Column(name = "programFK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer programFK;
	/**
	 */
	
	@Column(name = "levelFK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer levelFK;
	/**
	 */
	
	@Column(name = "sportPositionFK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer sportPositionFK;
	/**
	 */
	
	@Column(name = "tswAcctFK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer tswAcctFK;
	/**
	 */
	

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
	
	

	public Integer getTeamFK() {
		return teamFK;
	}

	public void setTeamFK(Integer teamFK) {
		this.teamFK = teamFK;
	}

	public Integer getCustomerFK() {
		return customerFK;
	}

	public void setCustomerFK(Integer customerFK) {
		this.customerFK = customerFK;
	}

	public Integer getProgramFK() {
		return programFK;
	}

	public void setProgramFK(Integer programFK) {
		this.programFK = programFK;
	}

	public Integer getLevelFK() {
		return levelFK;
	}

	public void setLevelFK(Integer levelFK) {
		this.levelFK = levelFK;
	}

	public Integer getSportPositionFK() {
		return sportPositionFK;
	}

	public void setSportPositionFK(Integer sportPositionFK) {
		this.sportPositionFK = sportPositionFK;
	}

	public Integer getTswAcctFK() {
		return tswAcctFK;
	}

	public void setTswAcctFK(Integer tswAcctFK) {
		this.tswAcctFK = tswAcctFK;
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
