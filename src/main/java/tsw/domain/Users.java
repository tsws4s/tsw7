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
		@NamedQuery(name = "findAllUserss4tsw", query = "select myUsers from Users myUsers where tswAcctFK = ?1"),
		@NamedQuery(name = "findUsersByActiveYn", query = "select myUsers from Users myUsers where myUsers.activeYn = ?1"),
		@NamedQuery(name = "findUsersByPassword", query = "select myUsers from Users myUsers where myUsers.password = ?1"),
		@NamedQuery(name = "findUsersByPasswordContaining", query = "select myUsers from Users myUsers where myUsers.password like ?1"),
		@NamedQuery(name = "findUsersByPrimaryKey", query = "select myUsers from Users myUsers where myUsers.userId = ?1"),
		@NamedQuery(name = "findUsersByUserId", query = "select myUsers from Users myUsers where myUsers.userId = ?1"),
		@NamedQuery(name = "findUsersByUsername", query = "select myUsers from Users myUsers where myUsers.username = ?1"),
		@NamedQuery(name = "findUsersByUsernameContaining", query = "select myUsers from Users myUsers where myUsers.username like ?1") })
@Table(catalog = "tsws4s_4", name = "Users")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "tsw7/tsw/domain", name = "Users")
public class Users implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "userID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer userId;
	/**
	 */

	@Column(name = "username", length = 145)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String username;
	/**
	 */

	@Column(name = "password", length = 85)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String password;
	/**
	 */

	@Column(name = "activeYN")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer activeYn;

	@Column(name = "adminYN")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer adminYn;

	@Column(name = "selectTheme", length = 45) 
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String selectTheme;
	
	@Column(name = "resultsPerPage")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer resultsPerPage;
	
	public String getSelectTheme() {
		return selectTheme;
	}

	public void setSelectTheme(String selectTheme) {
		this.selectTheme = selectTheme;
	}

	public Integer getResultsPerPage() {
		return resultsPerPage;
	}

	public void setResultsPerPage(Integer resultsPerPage) {
		this.resultsPerPage = resultsPerPage;
	}

	/**
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "customerFK", referencedColumnName = "customerID") })
	@XmlTransient
	Customer customer;
	/**
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "tswAcctFK", referencedColumnName = "tswAcctID") })
	@XmlTransient
	Tswacct tswacct;
	/**
	 */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(catalog = "tsws4s_4", name = "Users_Authorities", joinColumns = { @JoinColumn(name = "userID", referencedColumnName = "userID", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "authorityID", referencedColumnName = "authorityID", nullable = false, updatable = false) })
	@XmlElement(name = "", namespace = "")
	java.util.Set<tsw.domain.Authorities> authoritieses;

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
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 */
	public Customer getCustomer() {
		return customer;
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
	public void setAuthoritieses(Set<Authorities> authoritieses) {
		this.authoritieses = authoritieses;
	}

	/**
	 */
	public Set<Authorities> getAuthoritieses() {
		if (authoritieses == null) {
			authoritieses = new java.util.LinkedHashSet<tsw.domain.Authorities>();
		}
		return authoritieses;
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
		setActiveYn(that.getActiveYn());
		setCustomer(that.getCustomer());
		setTswacct(that.getTswacct());
		setAuthoritieses(new java.util.LinkedHashSet<tsw.domain.Authorities>(that.getAuthoritieses()));
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
		buffer.append("activeYn=[").append(activeYn).append("] ");

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
