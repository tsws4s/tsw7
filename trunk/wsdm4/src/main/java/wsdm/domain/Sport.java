package wsdm.domain;

import java.io.Serializable;

import java.lang.StringBuilder;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllSports", query = "select mySport from Sport mySport"),
		@NamedQuery(name = "findSportByActiveYn", query = "select mySport from Sport mySport where mySport.activeYn = ?1"),
		@NamedQuery(name = "findSportByPrimaryKey", query = "select mySport from Sport mySport where mySport.sportId = ?1"),
		@NamedQuery(name = "findSportBySportId", query = "select mySport from Sport mySport where mySport.sportId = ?1"),
		@NamedQuery(name = "findSportBySportName", query = "select mySport from Sport mySport where mySport.sportName = ?1") })
@Table(catalog = "C324877_tsws4s", name = "Sport")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wsdm4/wsdm/domain", name = "Sport")
@XmlRootElement(namespace = "wsdm4/wsdm/domain")
public class Sport implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "sportId", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer sportId;
	/**
	 */

	@Column(name = "sportName", length = 85)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String sportName;
	/**
	 */

	@Column(name = "wikiUrl", length = 245)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String wikiUrl;
	/**
	 */

	@Column(name = "activeYN")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer activeYn;
	/**
	 */

	@Column(name = "numGamePlayers")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer numGamePlayers;
	/**
	 */

	@Column(name = "numTeamRoster")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer numTeamRoster;
	/**
	 */

	@Column(name = "normalSeason", length = 145)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String normalSeason;

	/**
	 */
	public void setSportId(Integer sportId) {
		this.sportId = sportId;
	}

	/**
	 */
	public Integer getSportId() {
		return this.sportId;
	}

	/**
	 */
	public void setSportName(String sportName) {
		this.sportName = sportName;
	}

	/**
	 */
	public String getSportName() {
		return this.sportName;
	}

	/**
	 */
	public void setWikiUrl(String wikiUrl) {
		this.wikiUrl = wikiUrl;
	}

	/**
	 */
	public String getWikiUrl() {
		return this.wikiUrl;
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
	public void setNumGamePlayers(Integer numGamePlayers) {
		this.numGamePlayers = numGamePlayers;
	}

	/**
	 */
	public Integer getNumGamePlayers() {
		return this.numGamePlayers;
	}

	/**
	 */
	public void setNumTeamRoster(Integer numTeamRoster) {
		this.numTeamRoster = numTeamRoster;
	}

	/**
	 */
	public Integer getNumTeamRoster() {
		return this.numTeamRoster;
	}

	/**
	 */
	public void setNormalSeason(String normalSeason) {
		this.normalSeason = normalSeason;
	}

	/**
	 */
	public String getNormalSeason() {
		return this.normalSeason;
	}
	/**
	 */
	public Sport() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Sport that) {
		setSportId(that.getSportId());
		setSportName(that.getSportName());
		setWikiUrl(that.getWikiUrl());
		setActiveYn(that.getActiveYn());
		setNumGamePlayers(that.getNumGamePlayers());
		setNumTeamRoster(that.getNumTeamRoster());
		setNormalSeason(that.getNormalSeason());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("sportId=[").append(sportId).append("] ");
		buffer.append("sportName=[").append(sportName).append("] ");
		buffer.append("wikiUrl=[").append(wikiUrl).append("] ");
		buffer.append("activeYn=[").append(activeYn).append("] ");
		buffer.append("numGamePlayers=[").append(numGamePlayers).append("] ");
		buffer.append("numTeamRoster=[").append(numTeamRoster).append("] ");
		buffer.append("normalSeason=[").append(normalSeason).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((sportId == null) ? 0 : sportId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Sport))
			return false;
		Sport equalCheck = (Sport) obj;
		if ((sportId == null && equalCheck.sportId != null) || (sportId != null && equalCheck.sportId == null))
			return false;
		if (sportId != null && !sportId.equals(equalCheck.sportId))
			return false;
		return true;
	}
}
