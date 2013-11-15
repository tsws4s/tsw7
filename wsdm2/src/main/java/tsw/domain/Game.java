package tsw.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllGames", query = "select myGame from Game myGame"),
		@NamedQuery(name = "findAllGames4tsw", query = "select myGame from Game myGame where tswAcctFk = ?1"),
		@NamedQuery(name = "findGameByActiveYn", query = "select myGame from Game myGame where myGame.activeYn = ?1"),
		@NamedQuery(name = "findGameByGameDate", query = "select myGame from Game myGame where myGame.gameDate = ?1"),
		@NamedQuery(name = "findGameByGameDateAfter", query = "select myGame from Game myGame where myGame.gameDate > ?1"),
		@NamedQuery(name = "findGameByGameDateBefore", query = "select myGame from Game myGame where myGame.gameDate < ?1"),
		@NamedQuery(name = "findGameByGameId", query = "select myGame from Game myGame where myGame.gameId = ?1"),
		@NamedQuery(name = "findGameByHomeScore", query = "select myGame from Game myGame where myGame.homeScore = ?1"),
		@NamedQuery(name = "findGameByPrimaryKey", query = "select myGame from Game myGame where myGame.gameId = ?1"),
		@NamedQuery(name = "findGameByVisitorScore", query = "select myGame from Game myGame where myGame.visitorScore = ?1") })
@Table(catalog = "tsws4s_4", name = "Game")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "tsw7/tsw/domain", name = "Game")
@XmlRootElement(namespace = "tsw7/tsw/domain")
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
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "startTime")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar startTime;

	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "endTime")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar endTime;

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

	@Column(name = "activeYN")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer activeYn;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "refereeFK", referencedColumnName = "customerID") })
	@XmlTransient
	Customer customer;
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
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "resourceFK", referencedColumnName = "resourceID") })
	@XmlTransient
	Resource resource;

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
	java.util.Set<tsw.domain.Gamestats> gamestatses;
	
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
	
	public Calendar getStartTime() {
		return startTime;
	}

	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

	public Calendar getEndTime() {
		return endTime;
	}

	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
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
	
	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
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
		setActiveYn(that.getActiveYn());
		setCustomer(that.getCustomer());
		setTeamByVisitorTeamFk(that.getTeamByVisitorTeamFk());
		setTeamByHomeTeamFk(that.getTeamByHomeTeamFk());
		setProgram(that.getProgram());
		setTswacct(that.getTswacct());
		setGamestatses(new java.util.LinkedHashSet<tsw.domain.Gamestats>(that.getGamestatses()));
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
