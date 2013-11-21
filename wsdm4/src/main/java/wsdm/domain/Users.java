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
		@NamedQuery(name = "findAllUserss", query = "select myUsers from Users myUsers"),
		@NamedQuery(name = "findUsersByActiveYn", query = "select myUsers from Users myUsers where myUsers.activeYn = ?1"),
		@NamedQuery(name = "findUsersByAdminYn", query = "select myUsers from Users myUsers where myUsers.adminYn = ?1"),
		@NamedQuery(name = "findUsersByCustomerFk", query = "select myUsers from Users myUsers where myUsers.customerFk = ?1"),
		@NamedQuery(name = "findUsersByPrimaryKey", query = "select myUsers from Users myUsers where myUsers.userId = ?1"),
		@NamedQuery(name = "findUsersByTswAcctFk", query = "select myUsers from Users myUsers where myUsers.tswAcctFk = ?1"),
		@NamedQuery(name = "findUsersByUserId", query = "select myUsers from Users myUsers where myUsers.userId = ?1"),
		@NamedQuery(name = "findUsersByUsername", query = "select myUsers from Users myUsers where myUsers.username = ?1") })
@Table(catalog = "C324877_tsws4s", name = "Users")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wsdm4/wsdm/wsdm.domain", name = "Users")
public class Users implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "userID")
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer userId;
	/**
	 */

	@Column(name = "username", length = 155)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String username;
	/**
	 */

	@Column(name = "password", length = 75)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String password;
	/**
	 */

	@Column(name = "selectTheme", length = 85)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String selectTheme;
	/**
	 */

	@Column(name = "activeYN")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer activeYn;
	/**
	 */

	@Column(name = "tswAcctFK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer tswAcctFk;
	/**
	 */

	@Column(name = "adminYN")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer adminYn;
	/**
	 */

	@Column(name = "resultsPerPage")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer resultsPerPage;
	/**
	 */

	@Column(name = "customerFK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer customerFk;

	/**
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 */
	public Integer getUserId() {
		return this.userId;
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
	public void setSelectTheme(String selectTheme) {
		this.selectTheme = selectTheme;
	}

	/**
	 */
	public String getSelectTheme() {
		return this.selectTheme;
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
	public void setTswAcctFk(Integer tswAcctFk) {
		this.tswAcctFk = tswAcctFk;
	}

	/**
	 */
	public Integer getTswAcctFk() {
		return this.tswAcctFk;
	}

	/**
	 */
	public void setAdminYn(Integer adminYn) {
		this.adminYn = adminYn;
	}

	/**
	 */
	public Integer getAdminYn() {
		return this.adminYn;
	}

	/**
	 */
	public void setResultsPerPage(Integer resultsPerPage) {
		this.resultsPerPage = resultsPerPage;
	}

	/**
	 */
	public Integer getResultsPerPage() {
		return this.resultsPerPage;
	}

	/**
	 */
	public void setCustomerFk(Integer customerFk) {
		this.customerFk = customerFk;
	}

	/**
	 */
	public Integer getCustomerFk() {
		return this.customerFk;
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
		setUserId(that.getUserId());
		setUsername(that.getUsername());
		setPassword(that.getPassword());
		setSelectTheme(that.getSelectTheme());
		setActiveYn(that.getActiveYn());
		setTswAcctFk(that.getTswAcctFk());
		setAdminYn(that.getAdminYn());
		setResultsPerPage(that.getResultsPerPage());
		setCustomerFk(that.getCustomerFk());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("userId=[").append(userId).append("] ");
		buffer.append("username=[").append(username).append("] ");
		buffer.append("password=[").append(password).append("] ");
		buffer.append("selectTheme=[").append(selectTheme).append("] ");
		buffer.append("activeYn=[").append(activeYn).append("] ");
		buffer.append("tswAcctFk=[").append(tswAcctFk).append("] ");
		buffer.append("adminYn=[").append(adminYn).append("] ");
		buffer.append("resultsPerPage=[").append(resultsPerPage).append("] ");
		buffer.append("customerFk=[").append(customerFk).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((userId == null) ? 0 : userId.hashCode()));
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
		if ((userId == null && equalCheck.userId != null) || (userId != null && equalCheck.userId == null))
			return false;
		if (userId != null && !userId.equals(equalCheck.userId))
			return false;
		return true;
	}
}
