package wsdm.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import javax.persistence.Id;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@Table(catalog = "C324877_tsws4s", name = "Authorities")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wsdm4/wsdm/domain", name = "Authorities")
public class Authorities implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "authorityID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer authorityId;
	/**
	 */

	@Column(name = "authorityName", length = 85)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String authorityName;
	/**
	 */

	@Column(name = "id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String id;
	/**
	 */

	@Column(name = "username", length = 45)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String username;
	/**
	 */

	@Column(name = "authority", length = 45)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String authority;

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
	public void setId(String id) {
		this.id = id;
	}

	/**
	 */
	public String getId() {
		return this.id;
	}

	/**
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 */
	public void setAuthority(String authority) {
		this.authority = authority;
	}

	/**
	 */
	public String getAuthority() {
		return this.authority;
	}

	/**
	 */
	public Authorities() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Authorities that) {
		setAuthorityId(that.getAuthorityId());
		setAuthorityName(that.getAuthorityName());
		setId(that.getId());
		setUsername(that.getUsername());
		setAuthority(that.getAuthority());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("authorityId=[").append(authorityId).append("] ");
		buffer.append("authorityName=[").append(authorityName).append("] ");
		buffer.append("id=[").append(id).append("] ");
		buffer.append("username=[").append(username).append("] ");
		buffer.append("authority=[").append(authority).append("] ");

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
		if (!(obj instanceof Authorities))
			return false;
		Authorities equalCheck = (Authorities) obj;
		if ((authorityId == null && equalCheck.authorityId != null) || (authorityId != null && equalCheck.authorityId == null))
			return false;
		if (authorityId != null && !authorityId.equals(equalCheck.authorityId))
			return false;
		return true;
	}
}
