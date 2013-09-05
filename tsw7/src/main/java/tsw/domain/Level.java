package tsw.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

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
		@NamedQuery(name = "findAllLevels", query = "select myLevel from Level myLevel"),
		@NamedQuery(name = "findAllLevels4tsw", query = "select myLevel from Level myLevel where tswAcctFk = ?1"),
		@NamedQuery(name = "findLevelByActiveYn", query = "select myLevel from Level myLevel where myLevel.activeYn = ?1"),
		@NamedQuery(name = "findLevelByAgeHigh", query = "select myLevel from Level myLevel where myLevel.ageHigh = ?1"),
		@NamedQuery(name = "findLevelByAgeLow", query = "select myLevel from Level myLevel where myLevel.ageLow = ?1"),
		@NamedQuery(name = "findLevelByLevelCode", query = "select myLevel from Level myLevel where myLevel.levelCode = ?1"),
		@NamedQuery(name = "findLevelByLevelCodeContaining", query = "select myLevel from Level myLevel where myLevel.levelCode like ?1"),
		@NamedQuery(name = "findLevelByLevelId", query = "select myLevel from Level myLevel where myLevel.levelId = ?1"),
		@NamedQuery(name = "findLevelByLevelName", query = "select myLevel from Level myLevel where myLevel.levelName = ?1"),
		@NamedQuery(name = "findLevelByLevelNameContaining", query = "select myLevel from Level myLevel where myLevel.levelName like ?1"),
		@NamedQuery(name = "findLevelByPrimaryKey", query = "select myLevel from Level myLevel where myLevel.levelId = ?1") })
@Table(catalog = "tsws4s_4", name = "Level")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "tsw7/tsw/domain", name = "Level")
@XmlRootElement(namespace = "tsw7/tsw/domain")
public class Level implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "levelID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer levelId;
	/**
	 */

	@Column(name = "levelName", length = 75, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String levelName;
	/**
	 */

	@Column(name = "levelCode", length = 15, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String levelCode;
	/**
	 */

	@Column(name = "ageLow")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer ageLow;
	/**
	 */

	@Column(name = "ageHigh")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer ageHigh;
	/**
	 */

	@Column(name = "activeYN")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer activeYn;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "tswAcctFK", referencedColumnName = "tswAcctID") })
	@XmlTransient
	Tswacct tswacct;
	/**
	 */
	@OneToMany(mappedBy = "level", fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<tsw.domain.Teamplayers> teamplayerses;
	/**
	 */
	@OneToMany(mappedBy = "level", fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<tsw.domain.Program> programs;
	/**
	 */
	@OneToMany(mappedBy = "level", fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<tsw.domain.Team> teams;

	/**
	 */
	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

	/**
	 */
	public Integer getLevelId() {
		return this.levelId;
	}

	/**
	 */
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	/**
	 */
	public String getLevelName() {
		return this.levelName;
	}

	/**
	 */
	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}

	/**
	 */
	public String getLevelCode() {
		return this.levelCode;
	}

	/**
	 */
	public void setAgeLow(Integer ageLow) {
		this.ageLow = ageLow;
	}

	/**
	 */
	public Integer getAgeLow() {
		return this.ageLow;
	}

	/**
	 */
	public void setAgeHigh(Integer ageHigh) {
		this.ageHigh = ageHigh;
	}

	/**
	 */
	public Integer getAgeHigh() {
		return this.ageHigh;
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
	public void setTeamplayerses(Set<Teamplayers> teamplayerses) {
		this.teamplayerses = teamplayerses;
	}

	/**
	 */
	public Set<Teamplayers> getTeamplayerses() {
		if (teamplayerses == null) {
			teamplayerses = new java.util.LinkedHashSet<tsw.domain.Teamplayers>();
		}
		return teamplayerses;
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
			programs = new java.util.LinkedHashSet<tsw.domain.Program>();
		}
		return programs;
	}

	/**
	 */
	public void setTeams(Set<Team> teams) {
		this.teams = teams;
	}

	/**
	 */
	public Set<Team> getTeams() {
		if (teams == null) {
			teams = new java.util.LinkedHashSet<tsw.domain.Team>();
		}
		return teams;
	}

	/**
	 */
	public Level() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Level that) {
		setLevelId(that.getLevelId());
		setLevelName(that.getLevelName());
		setLevelCode(that.getLevelCode());
		setAgeLow(that.getAgeLow());
		setAgeHigh(that.getAgeHigh());
		setActiveYn(that.getActiveYn());
		setTswacct(that.getTswacct());
		setTeamplayerses(new java.util.LinkedHashSet<tsw.domain.Teamplayers>(that.getTeamplayerses()));
		setPrograms(new java.util.LinkedHashSet<tsw.domain.Program>(that.getPrograms()));
		setTeams(new java.util.LinkedHashSet<tsw.domain.Team>(that.getTeams()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("levelId=[").append(levelId).append("] ");
		buffer.append("levelName=[").append(levelName).append("] ");
		buffer.append("levelCode=[").append(levelCode).append("] ");
		buffer.append("ageLow=[").append(ageLow).append("] ");
		buffer.append("ageHigh=[").append(ageHigh).append("] ");
		buffer.append("activeYn=[").append(activeYn).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((levelId == null) ? 0 : levelId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Level))
			return false;
		Level equalCheck = (Level) obj;
		if ((levelId == null && equalCheck.levelId != null) || (levelId != null && equalCheck.levelId == null))
			return false;
		if (levelId != null && !levelId.equals(equalCheck.levelId))
			return false;
		return true;
	}
}
