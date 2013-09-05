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
		@NamedQuery(name = "findAllBudgets", query = "select myBudget from Budget myBudget"),
		@NamedQuery(name = "findBudgetByActiveYn", query = "select myBudget from Budget myBudget where myBudget.activeYn = ?1"),
		@NamedQuery(name = "findBudgetByBudgetId", query = "select myBudget from Budget myBudget where myBudget.budgetId = ?1"),
		@NamedQuery(name = "findBudgetByName", query = "select myBudget from Budget myBudget where myBudget.name = ?1"),
		@NamedQuery(name = "findBudgetByNameContaining", query = "select myBudget from Budget myBudget where myBudget.name like ?1"),
		@NamedQuery(name = "findBudgetByPrimaryKey", query = "select myBudget from Budget myBudget where myBudget.budgetId = ?1"),
		@NamedQuery(name = "findBudgetByUserFk", query = "select myBudget from Budget myBudget where myBudget.userFk = ?1"),
		@NamedQuery(name = "findBudgetByYear", query = "select myBudget from Budget myBudget where myBudget.year = ?1") })
@Table(catalog = "C324877_mystuff", name = "budget")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "MyInfo/myinfo/domain", name = "Budget")
public class Budget implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "budget_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer budgetId;
	/**
	 */

	@Column(name = "name", length = 150)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String name;
	/**
	 */

	@Column(name = "year")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer year;
	/**
	 */

	@Column(name = "active_yn")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer activeYn;
	/**
	 */

	@Column(name = "user_fk")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer userFk;

	/**
	 */
	public void setBudgetId(Integer budgetId) {
		this.budgetId = budgetId;
	}

	/**
	 */
	public Integer getBudgetId() {
		return this.budgetId;
	}

	/**
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 */
	public String getName() {
		return this.name;
	}

	/**
	 */
	public void setYear(Integer year) {
		this.year = year;
	}

	/**
	 */
	public Integer getYear() {
		return this.year;
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
	public void setUserFk(Integer userFk) {
		this.userFk = userFk;
	}

	/**
	 */
	public Integer getUserFk() {
		return this.userFk;
	}

	/**
	 */
	public Budget() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Budget that) {
		setBudgetId(that.getBudgetId());
		setName(that.getName());
		setYear(that.getYear());
		setActiveYn(that.getActiveYn());
		setUserFk(that.getUserFk());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("budgetId=[").append(budgetId).append("] ");
		buffer.append("name=[").append(name).append("] ");
		buffer.append("year=[").append(year).append("] ");
		buffer.append("activeYn=[").append(activeYn).append("] ");
		buffer.append("userFk=[").append(userFk).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((budgetId == null) ? 0 : budgetId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Budget))
			return false;
		Budget equalCheck = (Budget) obj;
		if ((budgetId == null && equalCheck.budgetId != null) || (budgetId != null && equalCheck.budgetId == null))
			return false;
		if (budgetId != null && !budgetId.equals(equalCheck.budgetId))
			return false;
		return true;
	}
}
