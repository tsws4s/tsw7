package wsdm.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.Calendar;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllGames", query = "select myGame from Game myGame"),
		@NamedQuery(name = "findGameByActiveYn", query = "select myGame from Game myGame where myGame.activeYn = ?1"),
		@NamedQuery(name = "findGameByGameDate", query = "select myGame from Game myGame where myGame.gameDate = ?1"),
		@NamedQuery(name = "findGameByGameId", query = "select myGame from Game myGame where myGame.gameId = ?1"),
		@NamedQuery(name = "findGameByPrimaryKey", query = "select myGame from Game myGame where myGame.gameId = ?1"),
		@NamedQuery(name = "findGameByRefereeFk", query = "select myGame from Game myGame where myGame.refereeFk = ?1") })
@Table(catalog = "C324877_tsws4s", name = "Game")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wsdm4/wsdm/domain", name = "Game")
@XmlRootElement(namespace = "wsdm4/wsdm/domain")
public class Game implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "gameID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer gameId;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "gameDate")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar gameDate;
	/**
	 */

	@Column(name = "homeScore")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer homeScore;
	/**
	 */

	@Column(name = "visitorScore")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer visitorScore;
	/**
	 */

	@Column(name = "refereeFK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer refereeFk;
	/**
	 */

	@Column(name = "homeTeamFK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer homeTeamFK;
	/**
	 */

	@Column(name = "visitorTeamFK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer visitorTeamFK;
	/**
	 */

	@Column(name = "programFK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer programFK;
	
	/**
	 */

	@Column(name = "tswAcctFK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer tswAcctFK;


	@Column(name = "activeYN")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer activeYn;
	
	
	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	/**
	 */
	public Integer getGameId() {
		return this.gameId;
	}

	/**
	 */
	public void setGameDate(Calendar gameDate) {
		this.gameDate = gameDate;
	}

	/**
	 */
	public Calendar getGameDate() {
		return this.gameDate;
	}

	/**
	 */
	public void setHomeScore(Integer homeScore) {
		this.homeScore = homeScore;
	}

	/**
	 */
	public Integer getHomeScore() {
		return this.homeScore;
	}

	/**
	 */
	public void setVisitorScore(Integer visitorScore) {
		this.visitorScore = visitorScore;
	}

	/**
	 */
	public Integer getVisitorScore() {
		return this.visitorScore;
	}

	/**
	 */
	public void setRefereeFk(Integer refereeFk) {
		this.refereeFk = refereeFk;
	}

	/**
	 */
	public Integer getRefereeFk() {
		return this.refereeFk;
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
	
	public Integer getHomeTeamFK() {
		return homeTeamFK;
	}

	public void setHomeTeamFK(Integer homeTeamFK) {
		this.homeTeamFK = homeTeamFK;
	}

	public Integer getVisitorTeamFK() {
		return visitorTeamFK;
	}

	public void setVisitorTeamFK(Integer visitorTeamFK) {
		this.visitorTeamFK = visitorTeamFK;
	}

	public Integer getProgramFK() {
		return programFK;
	}

	public void setProgramFK(Integer programFK) {
		this.programFK = programFK;
	}

	public Integer getTswAcctFK() {
		return tswAcctFK;
	}

	public void setTswAcctFK(Integer tswAcctFK) {
		this.tswAcctFK = tswAcctFK;
	}

	/**
	 */
	public Game() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Game that) {
		setGameId(that.getGameId());
		setGameDate(that.getGameDate());
		setHomeScore(that.getHomeScore());
		setVisitorScore(that.getVisitorScore());
		setRefereeFk(that.getRefereeFk());
		setActiveYn(that.getActiveYn());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("gameId=[").append(gameId).append("] ");
		buffer.append("gameDate=[").append(gameDate).append("] ");
		buffer.append("homeScore=[").append(homeScore).append("] ");
		buffer.append("visitorScore=[").append(visitorScore).append("] ");
		buffer.append("refereeFk=[").append(refereeFk).append("] ");
		buffer.append("activeYn=[").append(activeYn).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((gameId == null) ? 0 : gameId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Game))
			return false;
		Game equalCheck = (Game) obj;
		if ((gameId == null && equalCheck.gameId != null) || (gameId != null && equalCheck.gameId == null))
			return false;
		if (gameId != null && !gameId.equals(equalCheck.gameId))
			return false;
		return true;
	}
}
