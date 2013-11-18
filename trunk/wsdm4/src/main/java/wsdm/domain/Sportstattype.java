package wsdm.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllSportstattypes", query = "select mySportstattype from Sportstattype mySportstattype"),
		@NamedQuery(name = "findSportstattypeByPrimaryKey", query = "select mySportstattype from Sportstattype mySportstattype where mySportstattype.sportStatTypeId = ?1") })
@Table(catalog = "C324877_tsws4s", name = "SportStatType")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wsdm4/wsdm/domain", name = "Sportstattype")
public class Sportstattype implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "sportStatTypeId", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer sportStatTypeId;
	/**
	 */

	@Column(name = "sportStatTypeName", length = 145)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String sportStatTypeName;

	/**
	 */
	public void setSportStatTypeId(Integer sportStatTypeId) {
		this.sportStatTypeId = sportStatTypeId;
	}

	/**
	 */
	public Integer getSportStatTypeId() {
		return this.sportStatTypeId;
	}

	/**
	 */
	public void setSportStatTypeName(String sportStatTypeName) {
		this.sportStatTypeName = sportStatTypeName;
	}

	/**
	 */
	public String getSportStatTypeName() {
		return this.sportStatTypeName;
	}

	/**
	 */
	public Sportstattype() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Sportstattype that) {
		setSportStatTypeId(that.getSportStatTypeId());
		setSportStatTypeName(that.getSportStatTypeName());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("sportStatTypeId=[").append(sportStatTypeId).append("] ");
		buffer.append("sportStatTypeName=[").append(sportStatTypeName).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((sportStatTypeId == null) ? 0 : sportStatTypeId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Sportstattype))
			return false;
		Sportstattype equalCheck = (Sportstattype) obj;
		if ((sportStatTypeId == null && equalCheck.sportStatTypeId != null) || (sportStatTypeId != null && equalCheck.sportStatTypeId == null))
			return false;
		if (sportStatTypeId != null && !sportStatTypeId.equals(equalCheck.sportStatTypeId))
			return false;
		return true;
	}
}
