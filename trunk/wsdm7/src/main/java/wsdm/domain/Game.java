package wsdm.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

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
		@NamedQuery(name = "findAllGames", query = "select myGame from Game myGame"),
		@NamedQuery(name = "findGameByPrimaryKey", query = "select myGame from Game myGame where myGame.gameId = ?1") })
@Table(catalog = "C324877_tsws4s", name = "Game")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wsdm7/wsdm/domain", name = "Game")
@XmlRootElement(namespace = "wsdm7/wsdm/domain")
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

	@Column(name = "activeYN")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer activeYn;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "visitorTeamFK", referencedColumnName = "teamID") })
	@XmlTransient
	Team teamByVisitorTeamFk;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "homeTeamFK", referencedColumnName = "teamID") })
	@XmlTransient
	Team teamByHomeTeamFk;
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
	@OneToMany(mappedBy = "game", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<wsdm.domain.Event> events;
	/**
	 */
	@OneToMany(mappedBy = "game", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<wsdm.domain.Gamestats> gamestatses;

	/**
	 */
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

	/**
	 */
	public void setTeamByVisitorTeamFk(Team teamByVisitorTeamFk) {
		this.teamByVisitorTeamFk = teamByVisitorTeamFk;
	}

	/**
	 */
	public Team getTeamByVisitorTeamFk() {
		return teamByVisitorTeamFk;
	}

	/**
	 */
	public void setTeamByHomeTeamFk(Team teamByHomeTeamFk) {
		this.teamByHomeTeamFk = teamByHomeTeamFk;
	}

	/**
	 */
	public Team getTeamByHomeTeamFk() {
		return teamByHomeTeamFk;
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
		setTeamByVisitorTeamFk(that.getTeamByVisitorTeamFk());
		setTeamByHomeTeamFk(that.getTeamByHomeTeamFk());
		setProgram(that.getProgram());
		setTswacct(that.getTswacct());
		setEvents(new java.util.LinkedHashSet<wsdm.domain.Event>(that.getEvents()));
		setGamestatses(new java.util.LinkedHashSet<wsdm.domain.Gamestats>(that.getGamestatses()));
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
