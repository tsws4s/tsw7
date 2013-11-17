package wsdm.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

// import java.util.Set;

import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllSportpositions", query = "select mySportposition from Sportposition mySportposition"),
		@NamedQuery(name = "findSportpositionByNumGamePlayers", query = "select mySportposition from Sportposition mySportposition where mySportposition.numGamePlayers = ?1"),
		@NamedQuery(name = "findSportpositionByNumTeamPlayers", query = "select mySportposition from Sportposition mySportposition where mySportposition.numTeamPlayers = ?1"),
		@NamedQuery(name = "findSportpositionByPrimaryKey", query = "select mySportposition from Sportposition mySportposition where mySportposition.sportPositionId = ?1"),
		@NamedQuery(name = "findSportpositionBySportPositionId", query = "select mySportposition from Sportposition mySportposition where mySportposition.sportPositionId = ?1"),
		@NamedQuery(name = "findSportpositionBySportPositionName", query = "select mySportposition from Sportposition mySportposition where mySportposition.sportPositionName = ?1"),
		@NamedQuery(name = "findSportpositionBySportPositionNameContaining", query = "select mySportposition from Sportposition mySportposition where mySportposition.sportPositionName like ?1") })
@Table(catalog = "C324877_tsws4s", name = "SportPosition")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wsdm7/wsdm/domain", name = "Sportposition")
public class Sportposition implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "sportPositionId", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer sportPositionId;
	/**
	 */

	@Column(name = "sportPositionName", length = 145)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String sportPositionName;
	/**
	 */

	@Column(name = "numGamePlayers")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer numGamePlayers;
	/**
	 */

	@Column(name = "numTeamPlayers")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer numTeamPlayers;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "sportFK", referencedColumnName = "sportId") })
	@XmlTransient
	Sport sport;

	/**
	 */
	public void setSportPositionId(Integer sportPositionId) {
		this.sportPositionId = sportPositionId;
	}

	/**
	 */
	public Integer getSportPositionId() {
		return this.sportPositionId;
	}

	/**
	 */
	public void setSportPositionName(String sportPositionName) {
		this.sportPositionName = sportPositionName;
	}

	/**
	 */
	public String getSportPositionName() {
		return this.sportPositionName;
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
	public void setNumTeamPlayers(Integer numTeamPlayers) {
		this.numTeamPlayers = numTeamPlayers;
	}

	/**
	 */
	public Integer getNumTeamPlayers() {
		return this.numTeamPlayers;
	}

	/**
	 */
	public void setSport(Sport sport) {
		this.sport = sport;
	}

	/**
	 */
	public Sport getSport() {
		return sport;
	}

	/**
	 */
	public Sportposition() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Sportposition that) {
		setSportPositionId(that.getSportPositionId());
		setSportPositionName(that.getSportPositionName());
		setNumGamePlayers(that.getNumGamePlayers());
		setNumTeamPlayers(that.getNumTeamPlayers());
		setSport(that.getSport());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("sportPositionId=[").append(sportPositionId).append("] ");
		buffer.append("sportPositionName=[").append(sportPositionName).append("] ");
		buffer.append("numGamePlayers=[").append(numGamePlayers).append("] ");
		buffer.append("numTeamPlayers=[").append(numTeamPlayers).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((sportPositionId == null) ? 0 : sportPositionId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Sportposition))
			return false;
		Sportposition equalCheck = (Sportposition) obj;
		if ((sportPositionId == null && equalCheck.sportPositionId != null) || (sportPositionId != null && equalCheck.sportPositionId == null))
			return false;
		if (sportPositionId != null && !sportPositionId.equals(equalCheck.sportPositionId))
			return false;
		return true;
	}
}
