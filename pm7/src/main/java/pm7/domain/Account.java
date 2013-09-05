package pm7.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.Calendar;

import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAccountByAccountId", query = "select myAccount from Account myAccount where myAccount.accountId = ?1"),
		@NamedQuery(name = "findAccountByAccountName", query = "select myAccount from Account myAccount where myAccount.accountName = ?1"),
		@NamedQuery(name = "findAccountByAccountNameContaining", query = "select myAccount from Account myAccount where myAccount.accountName like ?1"),
		@NamedQuery(name = "findAccountByExpireDate", query = "select myAccount from Account myAccount where myAccount.expireDate = ?1"),
		@NamedQuery(name = "findAccountByExpireDateAfter", query = "select myAccount from Account myAccount where myAccount.expireDate > ?1"),
		@NamedQuery(name = "findAccountByExpireDateBefore", query = "select myAccount from Account myAccount where myAccount.expireDate < ?1"),
		@NamedQuery(name = "findAccountByPrimaryKey", query = "select myAccount from Account myAccount where myAccount.accountId = ?1"),
		@NamedQuery(name = "findAllAccounts", query = "select myAccount from Account myAccount") })
@Table(catalog = "C324877_project_mgt", name = "Account")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "pm7/pm7/domain", name = "Account")
@XmlRootElement(namespace = "pm7/pm7/domain")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "accountId", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer accountId;
	/**
	 */

	@Column(name = "accountName", length = 145)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String accountName;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "expireDate")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar expireDate;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "FK_adminId", referencedColumnName = "personId") })
	@XmlTransient
	Person person;

	/**
	 */
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	/**
	 */
	public Integer getAccountId() {
		return this.accountId;
	}

	/**
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	/**
	 */
	public String getAccountName() {
		return this.accountName;
	}

	/**
	 */
	public void setExpireDate(Calendar expireDate) {
		this.expireDate = expireDate;
	}

	/**
	 */
	public Calendar getExpireDate() {
		return this.expireDate;
	}

	/**
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

	/**
	 */
	public Person getPerson() {
		return person;
	}
	/**
	 */
	public Account() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Account that) {
		setAccountId(that.getAccountId());
		setAccountName(that.getAccountName());
		setExpireDate(that.getExpireDate());
		setPerson(that.getPerson());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("accountId=[").append(accountId).append("] ");
		buffer.append("accountName=[").append(accountName).append("] ");
		buffer.append("expireDate=[").append(expireDate).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((accountId == null) ? 0 : accountId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Account))
			return false;
		Account equalCheck = (Account) obj;
		if ((accountId == null && equalCheck.accountId != null) || (accountId != null && equalCheck.accountId == null))
			return false;
		if (accountId != null && !accountId.equals(equalCheck.accountId))
			return false;
		return true;
	}
}
