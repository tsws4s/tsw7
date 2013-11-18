package wsdm.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.Calendar;
import javax.persistence.Id;
import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@Table(catalog = "C324877_tsws4s", name = "ProgGenGames")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wsdm4/wsdm/domain", name = "Proggengames")
@XmlRootElement(namespace = "wsdm4/wsdm/domain")
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
