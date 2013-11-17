package wsdm.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.Set;

import javax.persistence.Id;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@Table(catalog = "C324877_tsws4s", name = "TswAcctSport")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wsdm7/wsdm/domain", name = "Tswacctsport")
public class Tswacctsport implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "tswAcctSportId", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer tswAcctSportId;
	/**
	 */

	@Column(name = "sportFK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer sportFk;
	/**
	 */

	@Column(name = "numPrograms")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer numPrograms;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "tswAcctFK", referencedColumnName = "tswAcctID") })
	@XmlTransient
	Tswacct tswacct;

	/**
	 */
	public void setTswAcctSportId(Integer tswAcctSportId) {
		this.tswAcctSportId = tswAcctSportId;
	}

	/**
	 */
	public Integer getTswAcctSportId() {
		return this.tswAcctSportId;
	}

	/**
	 */
	public void setSportFk(Integer sportFk) {
		this.sportFk = sportFk;
	}

	/**
	 */
	public Integer getSportFk() {
		return this.sportFk;
	}

	/**
	 */
	public void setNumPrograms(Integer numPrograms) {
		this.numPrograms = numPrograms;
	}

	/**
	 */
	public Integer getNumPrograms() {
		return this.numPrograms;
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
	public Tswacctsport() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Tswacctsport that) {
		setTswAcctSportId(that.getTswAcctSportId());
		setSportFk(that.getSportFk());
		setNumPrograms(that.getNumPrograms());
		setTswacct(that.getTswacct());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("tswAcctSportId=[").append(tswAcctSportId).append("] ");
		buffer.append("sportFk=[").append(sportFk).append("] ");
		buffer.append("numPrograms=[").append(numPrograms).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((tswAcctSportId == null) ? 0 : tswAcctSportId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Tswacctsport))
			return false;
		Tswacctsport equalCheck = (Tswacctsport) obj;
		if ((tswAcctSportId == null && equalCheck.tswAcctSportId != null) || (tswAcctSportId != null && equalCheck.tswAcctSportId == null))
			return false;
		if (tswAcctSportId != null && !tswAcctSportId.equals(equalCheck.tswAcctSportId))
			return false;
		return true;
	}
}
