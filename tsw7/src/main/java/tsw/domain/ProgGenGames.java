package tsw.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
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
		@NamedQuery(name = "findAllProggengamess", query = "select myProggengames from ProgGenGames myProggengames"),
		@NamedQuery(name = "findProggengamesByPrimaryKey", query = "select myProggengames from ProgGenGames myProggengames where myProggengames.progGenGamesId = ?1"),
		@NamedQuery(name = "findProggengamesByProgGenGamesId", query = "select myProggengames from ProgGenGames myProggengames where myProggengames.progGenGamesId = ?1"),
		@NamedQuery(name = "findProggengamesByProgramId", query = "select myProggengames from ProgGenGames myProggengames where myProggengames.programId = ?1"),
		@NamedQuery(name = "findProggengamesByProgramName", query = "select myProggengames from ProgGenGames myProggengames where myProggengames.programName = ?1"),
		@NamedQuery(name = "findProggengamesByProgramNameContaining", query = "select myProggengames from ProgGenGames myProggengames where myProggengames.programName like ?1"),
		@NamedQuery(name = "findProggengamesByStartDate", query = "select myProggengames from ProgGenGames myProggengames where myProggengames.startDate = ?1") })
@Table(catalog = "tsws4s_4", name = "ProgGenGames")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "tsw7/tsw/domain", name = "ProgGenGames")
@XmlRootElement(namespace = "tsw7/tsw/domain")
public class ProgGenGames implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "progGenGamesId", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer progGenGamesId;
	/**
	 */

	@Column(name = "programId")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer programId;
	/**
	 */

	@Column(name = "programName", length = 185)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String programName;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "startDate")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar startDate;

	/**
	 */
	@OneToMany(mappedBy = "proggengames", fetch = FetchType.EAGER)
	@XmlElement(name = "", namespace = "")
	Set<tsw.domain.GenGame> gengames;

	ArrayList<tsw.domain.GenGame> gengamesList;
	/**
	 */
	public void setProgGenGamesId(Integer progGenGamesId) {
		this.progGenGamesId = progGenGamesId;
	}

	/**
	 */
	public Integer getProgGenGamesId() {
		return this.progGenGamesId;
	}

	/**
	 */
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
	public void setGengamesList(ArrayList<GenGame> gengames) {
		this.gengamesList = gengames;
	}

	/**
	 */
	public Set<GenGame> getGengames() {
		if (gengames == null) {
			gengames = new HashSet<tsw.domain.GenGame>();
		}
		return gengames;
	}
	public void setGengames(Set<GenGame> gengames) {
		this.gengames = gengames;
	}

	/**
	 */
	public ArrayList<GenGame> getGengamesList() {
		if (gengamesList == null) {
			gengamesList = new ArrayList<tsw.domain.GenGame>();
		}
		return gengamesList;
	}
	/**
	 */
	public ProgGenGames() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(ProgGenGames that) {
		setProgGenGamesId(that.getProgGenGamesId());
		setProgramId(that.getProgramId());
		setProgramName(that.getProgramName());
		setStartDate(that.getStartDate());
		setGengamesList(new ArrayList<tsw.domain.GenGame>(that.getGengamesList()));
		setGengames(new HashSet<tsw.domain.GenGame>(that.getGengames()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("progGenGamesId=[").append(progGenGamesId).append("] ");
		buffer.append("programId=[").append(programId).append("] ");
		buffer.append("programName=[").append(programName).append("] ");
		buffer.append("startDate=[").append(startDate).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((progGenGamesId == null) ? 0 : progGenGamesId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof ProgGenGames))
			return false;
		ProgGenGames equalCheck = (ProgGenGames) obj;
		if ((progGenGamesId == null && equalCheck.progGenGamesId != null) || (progGenGamesId != null && equalCheck.progGenGamesId == null))
			return false;
		if (progGenGamesId != null && !progGenGamesId.equals(equalCheck.progGenGamesId))
			return false;
		return true;
	}
}
