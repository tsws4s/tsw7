package wsdm.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.Id;

import org.skyway.spring.util.databinding.TypeConversionUtils;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@Table(catalog = "C324877_tsws4s", name = "GameStats")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wsdm7/wsdm/domain", name = "Gamestats")
public class Gamestats implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "gameStatsId", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer gameStatsId;
	/**
	 */

	@Column(name = "sportStatTypeFK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer sportStatTypeFk;
	/**
	 */

	@Column(name = "gameStatValue")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer gameStatValue;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gameStatTime")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar gameStatTime;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "gameFK", referencedColumnName = "gameID") })
	@XmlTransient
	Game game;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "teamplayerFK", referencedColumnName = "teamPlayersID") })
	@XmlTransient
	Teamplayers teamplayers;

	/**
	 */
	public void setGameStatsId(Integer gameStatsId) {
		this.gameStatsId = gameStatsId;
	}

	/**
	 */
	public Integer getGameStatsId() {
		return this.gameStatsId;
	}

	/**
	 */
	public void setSportStatTypeFk(Integer sportStatTypeFk) {
		this.sportStatTypeFk = sportStatTypeFk;
	}

	/**
	 */
	public Integer getSportStatTypeFk() {
		return this.sportStatTypeFk;
	}

	/**
	 */
	public void setGameStatValue(Integer gameStatValue) {
		this.gameStatValue = gameStatValue;
	}

	/**
	 */
	public Integer getGameStatValue() {
		return this.gameStatValue;
	}

	/**
	 */
	public void setGameStatTime(Calendar gameStatTime) {
		TypeConversionUtils.clearDateFields(gameStatTime);
		this.gameStatTime = gameStatTime;
	}

	/**
	 */
	public Calendar getGameStatTime() {
		return this.gameStatTime;
	}

	/**
	 */
	public void setGame(Game game) {
		this.game = game;
	}

	/**
	 */
	public Game getGame() {
		return game;
	}

	/**
	 */
	public void setTeamplayers(Teamplayers teamplayers) {
		this.teamplayers = teamplayers;
	}

	/**
	 */
	public Teamplayers getTeamplayers() {
		return teamplayers;
	}

	/**
	 */
	public Gamestats() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Gamestats that) {
		setGameStatsId(that.getGameStatsId());
		setSportStatTypeFk(that.getSportStatTypeFk());
		setGameStatValue(that.getGameStatValue());
		setGameStatTime(that.getGameStatTime());
		setGame(that.getGame());
		setTeamplayers(that.getTeamplayers());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("gameStatsId=[").append(gameStatsId).append("] ");
		buffer.append("sportStatTypeFk=[").append(sportStatTypeFk).append("] ");
		buffer.append("gameStatValue=[").append(gameStatValue).append("] ");
		buffer.append("gameStatTime=[").append(gameStatTime).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((gameStatsId == null) ? 0 : gameStatsId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Gamestats))
			return false;
		Gamestats equalCheck = (Gamestats) obj;
		if ((gameStatsId == null && equalCheck.gameStatsId != null) || (gameStatsId != null && equalCheck.gameStatsId == null))
			return false;
		if (gameStatsId != null && !gameStatsId.equals(equalCheck.gameStatsId))
			return false;
		return true;
	}
}
