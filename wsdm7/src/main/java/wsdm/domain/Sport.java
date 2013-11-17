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
		@NamedQuery(name = "findAllSports", query = "select mySport from Sport mySport"),
		@NamedQuery(name = "findSportByActiveYn", query = "select mySport from Sport mySport where mySport.activeYn = ?1"),
		@NamedQuery(name = "findSportByNormalSeason", query = "select mySport from Sport mySport where mySport.normalSeason = ?1"),
		@NamedQuery(name = "findSportByNormalSeasonContaining", query = "select mySport from Sport mySport where mySport.normalSeason like ?1"),
		@NamedQuery(name = "findSportByNumGamePlayers", query = "select mySport from Sport mySport where mySport.numGamePlayers = ?1"),
		@NamedQuery(name = "findSportByNumTeamRoster", query = "select mySport from Sport mySport where mySport.numTeamRoster = ?1"),
		@NamedQuery(name = "findSportByPrimaryKey", query = "select mySport from Sport mySport where mySport.sportId = ?1"),
		@NamedQuery(name = "findSportBySportId", query = "select mySport from Sport mySport where mySport.sportId = ?1"),
		@NamedQuery(name = "findSportBySportName", query = "select mySport from Sport mySport where mySport.sportName = ?1"),
		@NamedQuery(name = "findSportBySportNameContaining", query = "select mySport from Sport mySport where mySport.sportName like ?1"),
		@NamedQuery(name = "findSportByWikiUrl", query = "select mySport from Sport mySport where mySport.wikiUrl = ?1"),
		@NamedQuery(name = "findSportByWikiUrlContaining", query = "select mySport from Sport mySport where mySport.wikiUrl like ?1") })
@Table(catalog = "C324877_tsws4s", name = "Sport")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wsdm7/wsdm/domain", name = "Sport")
@XmlRootElement(namespace = "wsdm7/wsdm/domain")
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
	@OneToMany(mappedBy = "sport", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<wsdm.domain.Sportstattype> sportstattypes;
	/**
	 */
	@OneToMany(mappedBy = "sport", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<wsdm.domain.Sportposition> sportpositions;
	/**
	 */
	@OneToMany(mappedBy = "sport", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<wsdm.domain.Program> programs;

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
	public void setSportstattypes(Set<Sportstattype> sportstattypes) {
		this.sportstattypes = sportstattypes;
	}

	/**
	 */
	public Set<Sportstattype> getSportstattypes() {
		if (sportstattypes == null) {
			sportstattypes = new java.util.LinkedHashSet<wsdm.domain.Sportstattype>();
		}
		return sportstattypes;
	}

	/**
	 */
	public void setSportpositions(Set<Sportposition> sportpositions) {
		this.sportpositions = sportpositions;
	}

	/**
	 */
	public Set<Sportposition> getSportpositions() {
		if (sportpositions == null) {
			sportpositions = new java.util.LinkedHashSet<wsdm.domain.Sportposition>();
		}
		return sportpositions;
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
		setSportstattypes(new java.util.LinkedHashSet<wsdm.domain.Sportstattype>(that.getSportstattypes()));
		setSportpositions(new java.util.LinkedHashSet<wsdm.domain.Sportposition>(that.getSportpositions()));
		setPrograms(new java.util.LinkedHashSet<wsdm.domain.Program>(that.getPrograms()));
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
