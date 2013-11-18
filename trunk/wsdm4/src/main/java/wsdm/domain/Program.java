package wsdm.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.math.BigDecimal;

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
		@NamedQuery(name = "findAllPrograms", query = "select myProgram from Program myProgram"),
		@NamedQuery(name = "findProgramByActiveYn", query = "select myProgram from Program myProgram where myProgram.activeYn = ?1"),
		@NamedQuery(name = "findProgramByLeagueYn", query = "select myProgram from Program myProgram where myProgram.leagueYn = ?1"),
		@NamedQuery(name = "findProgramByLevelFk", query = "select myProgram from Program myProgram where myProgram.levelFk = ?1"),
		@NamedQuery(name = "findProgramByPrimaryKey", query = "select myProgram from Program myProgram where myProgram.programId = ?1"),
		@NamedQuery(name = "findProgramByProgramId", query = "select myProgram from Program myProgram where myProgram.programId = ?1"),
		@NamedQuery(name = "findProgramByProgramName", query = "select myProgram from Program myProgram where myProgram.programName = ?1"),
		@NamedQuery(name = "findProgramByPublishYn", query = "select myProgram from Program myProgram where myProgram.publishYn = ?1"),
		@NamedQuery(name = "findProgramByStartDate", query = "select myProgram from Program myProgram where myProgram.startDate = ?1") })
@Table(catalog = "C324877_tsws4s", name = "Program")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wsdm4/wsdm/domain", name = "Program")
@XmlRootElement(namespace = "wsdm4/wsdm/domain")
public class Program implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "programID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer programId;
	/**
	 */

	@Column(name = "programName", length = 155)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String programName;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "startDate")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar startDate;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "endDate")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar endDate;
	/**
	 */

	@Column(name = "levelFK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer levelFk;
	/**
	 */

	@Column(name = "activeYN")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer activeYn;
	/**
	 */

	@Column(name = "publishYN")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer publishYn;
	/**
	 */

	@Column(name = "totalPaid", scale = 2, precision = 32)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal totalPaid;
	/**
	 */

	@Column(name = "totalParticipants")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer totalParticipants;
	/**
	 */

	@Column(name = "gamesPerTeam")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer gamesPerTeam;
	/**
	 */

	@Column(name = "leagueYN")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer leagueYn;
	public void setProgramId(Integer programId) {
		this.programId = programId;
	}

	/**
	 */
	public Integer getProgramId() {
		return this.programId;
	}

	/**
	 */
	public void setProgramName(String programName) {
		this.programName = programName;
	}

	/**
	 */
	public String getProgramName() {
		return this.programName;
	}

	/**
	 */
	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	/**
	 */
	public Calendar getStartDate() {
		return this.startDate;
	}

	/**
	 */
	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	/**
	 */
	public Calendar getEndDate() {
		return this.endDate;
	}

	/**
	 */
	public void setLevelFk(Integer levelFk) {
		this.levelFk = levelFk;
	}

	/**
	 */
	public Integer getLevelFk() {
		return this.levelFk;
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
	public void setPublishYn(Integer publishYn) {
		this.publishYn = publishYn;
	}

	/**
	 */
	public Integer getPublishYn() {
		return this.publishYn;
	}

	/**
	 */
	public void setTotalPaid(BigDecimal totalPaid) {
		this.totalPaid = totalPaid;
	}

	/**
	 */
	public BigDecimal getTotalPaid() {
		return this.totalPaid;
	}

	/**
	 */
	public void setTotalParticipants(Integer totalParticipants) {
		this.totalParticipants = totalParticipants;
	}

	/**
	 */
	public Integer getTotalParticipants() {
		return this.totalParticipants;
	}

	/**
	 */
	public void setGamesPerTeam(Integer gamesPerTeam) {
		this.gamesPerTeam = gamesPerTeam;
	}

	/**
	 */
	public Integer getGamesPerTeam() {
		return this.gamesPerTeam;
	}

	/**
	 */
	public void setLeagueYn(Integer leagueYn) {
		this.leagueYn = leagueYn;
	}

	/**
	 */
	public Integer getLeagueYn() {
		return this.leagueYn;
	}
	/**
	 */
	public Program() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Program that) {
		setProgramId(that.getProgramId());
		setProgramName(that.getProgramName());
		setStartDate(that.getStartDate());
		setEndDate(that.getEndDate());
		setLevelFk(that.getLevelFk());
		setActiveYn(that.getActiveYn());
		setPublishYn(that.getPublishYn());
		setTotalPaid(that.getTotalPaid());
		setTotalParticipants(that.getTotalParticipants());
		setGamesPerTeam(that.getGamesPerTeam());
		setLeagueYn(that.getLeagueYn());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("programId=[").append(programId).append("] ");
		buffer.append("programName=[").append(programName).append("] ");
		buffer.append("startDate=[").append(startDate).append("] ");
		buffer.append("endDate=[").append(endDate).append("] ");
		buffer.append("levelFk=[").append(levelFk).append("] ");
		buffer.append("activeYn=[").append(activeYn).append("] ");
		buffer.append("publishYn=[").append(publishYn).append("] ");
		buffer.append("totalPaid=[").append(totalPaid).append("] ");
		buffer.append("totalParticipants=[").append(totalParticipants).append("] ");
		buffer.append("gamesPerTeam=[").append(gamesPerTeam).append("] ");
		buffer.append("leagueYn=[").append(leagueYn).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((programId == null) ? 0 : programId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Program))
			return false;
		Program equalCheck = (Program) obj;
		if ((programId == null && equalCheck.programId != null) || (programId != null && equalCheck.programId == null))
			return false;
		if (programId != null && !programId.equals(equalCheck.programId))
			return false;
		return true;
	}
}
