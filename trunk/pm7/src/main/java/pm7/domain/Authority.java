package pm7.domain;

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
		@NamedQuery(name = "findAllAuthoritys", query = "select myAuthority from Authority myAuthority"),
		@NamedQuery(name = "findAuthorityByAuthorityId", query = "select myAuthority from Authority myAuthority where myAuthority.authorityId = ?1"),
		@NamedQuery(name = "findAuthorityByAuthorityName", query = "select myAuthority from Authority myAuthority where myAuthority.authorityName = ?1"),
		@NamedQuery(name = "findAuthorityByAuthorityNameContaining", query = "select myAuthority from Authority myAuthority where myAuthority.authorityName like ?1"),
		@NamedQuery(name = "findAuthorityByPrimaryKey", query = "select myAuthority from Authority myAuthority where myAuthority.authorityId = ?1") })
@Table(catalog = "C324877_project_mgt", name = "Authority")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "pm7/pm7/domain", name = "Authority")
public class Authority implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "authorityId", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer authorityId;
	/**
	 */

	@Column(name = "authorityName", length = 45, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String authorityName;

	/**
	 */
	public void setAuthorityId(Integer authorityId) {
		this.authorityId = authorityId;
	}

	/**
	 */
	public Integer getAuthorityId() {
		return this.authorityId;
	}

	/**
	 */
	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}

	/**
	 */
	public String getAuthorityName() {
		return this.authorityName;
	}

	/**
	 */
	public Authority() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Authority that) {
		setAuthorityId(that.getAuthorityId());
		setAuthorityName(that.getAuthorityName());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("authorityId=[").append(authorityId).append("] ");
		buffer.append("authorityName=[").append(authorityName).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((authorityId == null) ? 0 : authorityId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Authority))
			return false;
		Authority equalCheck = (Authority) obj;
		if ((authorityId == null && equalCheck.authorityId != null) || (authorityId != null && equalCheck.authorityId == null))
			return false;
		if (authorityId != null && !authorityId.equals(equalCheck.authorityId))
			return false;
		return true;
	}
}
