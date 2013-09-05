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
		@NamedQuery(name = "findAllAuthoritiess", query = "select myAuthorities from Authorities myAuthorities"),
		@NamedQuery(name = "findAuthoritiesByAuthorityId", query = "select myAuthorities from Authorities myAuthorities where myAuthorities.authorityId = ?1"),
		@NamedQuery(name = "findAuthoritiesByAuthorityName", query = "select myAuthorities from Authorities myAuthorities where myAuthorities.authorityName = ?1"),
		@NamedQuery(name = "findAuthoritiesByAuthorityNameContaining", query = "select myAuthorities from Authorities myAuthorities where myAuthorities.authorityName like ?1"),
		@NamedQuery(name = "findAuthoritiesByPrimaryKey", query = "select myAuthorities from Authorities myAuthorities where myAuthorities.authorityId = ?1") })
@Table(catalog = "tsws4s_4", name = "Authorities")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "tsw7/tsw/domain", name = "Authorities")
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

	@Column(name = "id", length = 255)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String id;

	@Column(name = "username", length = 45)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String username;

	@Column(name = "authority", length = 45)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String authority;
	
	/**
	 */
	@ManyToMany(mappedBy = "authoritieses", fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<tsw.domain.Users> userses;

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	/**
	 */
	public void setUserses(Set<Users> userses) {
		this.userses = userses;
	}

	/**
	 */
	public Set<Users> getUserses() {
		if (userses == null) {
			userses = new java.util.LinkedHashSet<tsw.domain.Users>();
		}
		return userses;
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
		setUserses(new java.util.LinkedHashSet<tsw.domain.Users>(that.getUserses()));
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
