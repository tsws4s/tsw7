package wsdm.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.Calendar;
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
		@NamedQuery(name = "findAllProggengamess", query = "select myProggengames from Proggengames myProggengames"),
		@NamedQuery(name = "findProggengamesByPrimaryKey", query = "select myProggengames from Proggengames myProggengames where myProggengames.progGenGamesId = ?1"),
		@NamedQuery(name = "findProggengamesByProgGenGamesId", query = "select myProggengames from Proggengames myProggengames where myProggengames.progGenGamesId = ?1"),
		@NamedQuery(name = "findProggengamesByProgramId", query = "select myProggengames from Proggengames myProggengames where myProggengames.programId = ?1"),
		@NamedQuery(name = "findProggengamesByProgramName", query = "select myProggengames from Proggengames myProggengames where myProggengames.programName = ?1"),
		@NamedQuery(name = "findProggengamesByProgramNameContaining", query = "select myProggengames from Proggengames myProggengames where myProggengames.programName like ?1"),
		@NamedQuery(name = "findProggengamesByStartDate", query = "select myProggengames from Proggengames myProggengames where myProggengames.startDate = ?1") })
@Table(catalog = "C324877_tsws4s", name = "ProgGenGames")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wsdm7/wsdm/domain", name = "Proggengames")
@XmlRootElement(namespace = "wsdm7/wsdm/domain")
public class Proggengames implements Serializable {
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
	@OneToMany(mappedBy = "proggengames", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<wsdm.domain.Gengame> gengames;

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
	public void setGengames(Set<Gengame> gengames) {
		this.gengames = gengames;
	}

	/**
	 */
	public Set<Gengame> getGengames() {
		if (gengames == null) {
			gengames = new java.util.LinkedHashSet<wsdm.domain.Gengame>();
		}
		return gengames;
	}

	/**
	 */
	public Proggengames() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Proggengames that) {
		setProgGenGamesId(that.getProgGenGamesId());
		setProgramId(that.getProgramId());
		setProgramName(that.getProgramName());
		setStartDate(that.getStartDate());
		setGengames(new java.util.LinkedHashSet<wsdm.domain.Gengame>(that.getGengames()));
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
		if (!(obj instanceof Proggengames))
			return false;
		Proggengames equalCheck = (Proggengames) obj;
		if ((progGenGamesId == null && equalCheck.progGenGamesId != null) || (progGenGamesId != null && equalCheck.progGenGamesId == null))
			return false;
		if (progGenGamesId != null && !progGenGamesId.equals(equalCheck.progGenGamesId))
			return false;
		return true;
	}
}
