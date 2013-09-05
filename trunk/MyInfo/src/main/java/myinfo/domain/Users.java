package myinfo.domain;

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
		@NamedQuery(name = "findAllUserss", query = "select myUsers from Users myUsers"),
		@NamedQuery(name = "findUsersByActive", query = "select myUsers from Users myUsers where myUsers.active = ?1"),
		@NamedQuery(name = "findUsersByEmail", query = "select myUsers from Users myUsers where myUsers.email = ?1"),
		@NamedQuery(name = "findUsersByEmailContaining", query = "select myUsers from Users myUsers where myUsers.email like ?1"),
		@NamedQuery(name = "findUsersById", query = "select myUsers from Users myUsers where myUsers.id = ?1"),
		@NamedQuery(name = "findUsersByIp", query = "select myUsers from Users myUsers where myUsers.ip = ?1"),
		@NamedQuery(name = "findUsersByIpContaining", query = "select myUsers from Users myUsers where myUsers.ip like ?1"),
		@NamedQuery(name = "findUsersByPassword", query = "select myUsers from Users myUsers where myUsers.password = ?1"),
		@NamedQuery(name = "findUsersByPasswordContaining", query = "select myUsers from Users myUsers where myUsers.password like ?1"),
		@NamedQuery(name = "findUsersByPrimaryKey", query = "select myUsers from Users myUsers where myUsers.id = ?1") })
@Table(catalog = "C324877_mystuff", name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "MyInfo/myinfo/domain", name = "Users")
public class Users implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer id;
	/**
	 */

	@Column(name = "email", length = 50)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String email;
	/**
	 */

	@Column(name = "password", length = 50)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String password;
	/**
	 */

	@Column(name = "ip", length = 20)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String ip;
	/**
	 */

	@Column(name = "active")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer active;

	/**
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 */
	public String getIp() {
		return this.ip;
	}

	/**
	 */
	public void setActive(Integer active) {
		this.active = active;
	}

	/**
	 */
	public Integer getActive() {
		return this.active;
	}

	/**
	 */
	public Users() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Users that) {
		setId(that.getId());
		setEmail(that.getEmail());
		setPassword(that.getPassword());
		setIp(that.getIp());
		setActive(that.getActive());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("email=[").append(email).append("] ");
		buffer.append("password=[").append(password).append("] ");
		buffer.append("ip=[").append(ip).append("] ");
		buffer.append("active=[").append(active).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((id == null) ? 0 : id.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Users))
			return false;
		Users equalCheck = (Users) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
