package wsdm.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@Table(catalog = "C324877_tsws4s", name = "GenGame")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wsdm4/wsdm/domain", name = "Gengame")
public class Gengame implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "genGameId", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer genGameId;
	/**
	 */

	@Column(name = "gameNum")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer gameNum;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gameDateTime")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar gameDateTime;
	/**
	 */

	@Column(name = "homeTeamId")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer homeTeamId;
	/**
	 */

	@Column(name = "homeTeamName", length = 85)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String homeTeamName;
	/**
	 */

	@Column(name = "visitorTeamId")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer visitorTeamId;
	/**
	 */

	@Column(name = "visitorTeamName", length = 85)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String visitorTeamName;
	/**
	 */

	@Column(name = "resourceId")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer resourceId;
	/**
	 */

	@Column(name = "resourceName", length = 145)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String resourceName;
	/**
	 */

	@Column(name = "refereeId")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer refereeId;
	/**
	 */

	@Column(name = "refereeName", length = 185)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String refereeName;
	
	@Column(name = "progGenGameFK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer progGenGameFK;
	/**
	 */
	
	public void setGenGameId(Integer genGameId) {
		this.genGameId = genGameId;
	}

	/**
	 */
	public Integer getGenGameId() {
		return this.genGameId;
	}

	/**
	 */
	public void setGameNum(Integer gameNum) {
		this.gameNum = gameNum;
	}

	/**
	 */
	public Integer getGameNum() {
		return this.gameNum;
	}

	/**
	 */
	public void setGameDateTime(Calendar gameDateTime) {
		this.gameDateTime = gameDateTime;
	}

	/**
	 */
	public Calendar getGameDateTime() {
		return this.gameDateTime;
	}

	/**
	 */
	public void setHomeTeamId(Integer homeTeamId) {
		this.homeTeamId = homeTeamId;
	}

	/**
	 */
	public Integer getHomeTeamId() {
		return this.homeTeamId;
	}

	/**
	 */
	public void setHomeTeamName(String homeTeamName) {
		this.homeTeamName = homeTeamName;
	}

	/**
	 */
	public String getHomeTeamName() {
		return this.homeTeamName;
	}

	/**
	 */
	public void setVisitorTeamId(Integer visitorTeamId) {
		this.visitorTeamId = visitorTeamId;
	}

	/**
	 */
	public Integer getVisitorTeamId() {
		return this.visitorTeamId;
	}

	/**
	 */
	public void setVisitorTeamName(String visitorTeamName) {
		this.visitorTeamName = visitorTeamName;
	}

	/**
	 */
	public String getVisitorTeamName() {
		return this.visitorTeamName;
	}

	/**
	 */
	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	/**
	 */
	public Integer getResourceId() {
		return this.resourceId;
	}

	/**
	 */
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	/**
	 */
	public String getResourceName() {
		return this.resourceName;
	}

	/**
	 */
	public void setRefereeId(Integer refereeId) {
		this.refereeId = refereeId;
	}

	/**
	 */
	public Integer getRefereeId() {
		return this.refereeId;
	}

	/**
	 */
	public void setRefereeName(String refereeName) {
		this.refereeName = refereeName;
	}

	/**
	 */
	public String getRefereeName() {
		return this.refereeName;
	}

	public Integer getProgGenGameFK() {
		return progGenGameFK;
	}

	public void setProgGenGameFK(Integer progGenGameFK) {
		this.progGenGameFK = progGenGameFK;
	}

	/**
	 */
	public Gengame() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Gengame that) {
		setGenGameId(that.getGenGameId());
		setGameNum(that.getGameNum());
		setGameDateTime(that.getGameDateTime());
		setHomeTeamId(that.getHomeTeamId());
		setHomeTeamName(that.getHomeTeamName());
		setVisitorTeamId(that.getVisitorTeamId());
		setVisitorTeamName(that.getVisitorTeamName());
		setResourceId(that.getResourceId());
		setResourceName(that.getResourceName());
		setRefereeId(that.getRefereeId());
		setRefereeName(that.getRefereeName());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("genGameId=[").append(genGameId).append("] ");
		buffer.append("gameNum=[").append(gameNum).append("] ");
		buffer.append("gameDateTime=[").append(gameDateTime).append("] ");
		buffer.append("homeTeamId=[").append(homeTeamId).append("] ");
		buffer.append("homeTeamName=[").append(homeTeamName).append("] ");
		buffer.append("visitorTeamId=[").append(visitorTeamId).append("] ");
		buffer.append("visitorTeamName=[").append(visitorTeamName).append("] ");
		buffer.append("resourceId=[").append(resourceId).append("] ");
		buffer.append("resourceName=[").append(resourceName).append("] ");
		buffer.append("refereeId=[").append(refereeId).append("] ");
		buffer.append("refereeName=[").append(refereeName).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((genGameId == null) ? 0 : genGameId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Gengame))
			return false;
		Gengame equalCheck = (Gengame) obj;
		if ((genGameId == null && equalCheck.genGameId != null) || (genGameId != null && equalCheck.genGameId == null))
			return false;
		if (genGameId != null && !genGameId.equals(equalCheck.genGameId))
			return false;
		return true;
	}
}
