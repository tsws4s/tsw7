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
		@NamedQuery(name = "findAllBudgetAccounts", query = "select myBudgetAccount from BudgetAccount myBudgetAccount"),
		@NamedQuery(name = "findBudgetAccountByAccount", query = "select myBudgetAccount from BudgetAccount myBudgetAccount where myBudgetAccount.account = ?1"),
		@NamedQuery(name = "findBudgetAccountByAccountContaining", query = "select myBudgetAccount from BudgetAccount myBudgetAccount where myBudgetAccount.account like ?1"),
		@NamedQuery(name = "findBudgetAccountByActiveYn", query = "select myBudgetAccount from BudgetAccount myBudgetAccount where myBudgetAccount.activeYn = ?1"),
		@NamedQuery(name = "findBudgetAccountByApr", query = "select myBudgetAccount from BudgetAccount myBudgetAccount where myBudgetAccount.apr = ?1"),
		@NamedQuery(name = "findBudgetAccountByAug", query = "select myBudgetAccount from BudgetAccount myBudgetAccount where myBudgetAccount.aug = ?1"),
		@NamedQuery(name = "findBudgetAccountByBudId", query = "select myBudgetAccount from BudgetAccount myBudgetAccount where myBudgetAccount.budId = ?1"),
		@NamedQuery(name = "findBudgetAccountByBudgetFk", query = "select myBudgetAccount from BudgetAccount myBudgetAccount where myBudgetAccount.budgetFk = ?1"),
		@NamedQuery(name = "findBudgetAccountByDec", query = "select myBudgetAccount from BudgetAccount myBudgetAccount where myBudgetAccount.dec = ?1"),
		@NamedQuery(name = "findBudgetAccountByFeb", query = "select myBudgetAccount from BudgetAccount myBudgetAccount where myBudgetAccount.feb = ?1"),
		@NamedQuery(name = "findBudgetAccountByIncExp", query = "select myBudgetAccount from BudgetAccount myBudgetAccount where myBudgetAccount.incExp = ?1"),
		@NamedQuery(name = "findBudgetAccountByIncExpContaining", query = "select myBudgetAccount from BudgetAccount myBudgetAccount where myBudgetAccount.incExp like ?1"),
		@NamedQuery(name = "findBudgetAccountByJan", query = "select myBudgetAccount from BudgetAccount myBudgetAccount where myBudgetAccount.jan = ?1"),
		@NamedQuery(name = "findBudgetAccountByJul", query = "select myBudgetAccount from BudgetAccount myBudgetAccount where myBudgetAccount.jul = ?1"),
		@NamedQuery(name = "findBudgetAccountByJun", query = "select myBudgetAccount from BudgetAccount myBudgetAccount where myBudgetAccount.jun = ?1"),
		@NamedQuery(name = "findBudgetAccountByMar", query = "select myBudgetAccount from BudgetAccount myBudgetAccount where myBudgetAccount.mar = ?1"),
		@NamedQuery(name = "findBudgetAccountByMay", query = "select myBudgetAccount from BudgetAccount myBudgetAccount where myBudgetAccount.may = ?1"),
		@NamedQuery(name = "findBudgetAccountByNov", query = "select myBudgetAccount from BudgetAccount myBudgetAccount where myBudgetAccount.nov = ?1"),
		@NamedQuery(name = "findBudgetAccountByOct", query = "select myBudgetAccount from BudgetAccount myBudgetAccount where myBudgetAccount.oct = ?1"),
		@NamedQuery(name = "findBudgetAccountByPrimaryKey", query = "select myBudgetAccount from BudgetAccount myBudgetAccount where myBudgetAccount.budId = ?1"),
		@NamedQuery(name = "findBudgetAccountBySep", query = "select myBudgetAccount from BudgetAccount myBudgetAccount where myBudgetAccount.sep = ?1"),
		@NamedQuery(name = "findBudgetAccountByTotal", query = "select myBudgetAccount from BudgetAccount myBudgetAccount where myBudgetAccount.total = ?1"),
		@NamedQuery(name = "findBudgetAccountByUserFk", query = "select myBudgetAccount from BudgetAccount myBudgetAccount where myBudgetAccount.userFk = ?1") })
@Table(catalog = "C324877_mystuff", name = "budget_account")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "MyInfo/myinfo/domain", name = "BudgetAccount")
public class BudgetAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "bud_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer budId;
	/**
	 */

	@Column(name = "account", length = 150)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String account;
	/**
	 */

	@Column(name = "inc_exp", length = 5)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String incExp;
	/**
	 */

	@Column(name = "budget_fk")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer budgetFk;
	/**
	 */

	@Column(name = "jan")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer jan;
	/**
	 */

	@Column(name = "feb")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer feb;
	/**
	 */

	@Column(name = "mar")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer mar;
	/**
	 */

	@Column(name = "apr")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer apr;
	/**
	 */

	@Column(name = "may")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer may;
	/**
	 */

	@Column(name = "jun")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer jun;
	/**
	 */

	@Column(name = "jul")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer jul;
	/**
	 */

	@Column(name = "aug")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer aug;
	/**
	 */

	@Column(name = "sep")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer sep;
	/**
	 */

	@Column(name = "oct")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer oct;
	/**
	 */

	@Column(name = "nov")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer nov;
	/**
	 */

	@Column(name = "dec")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer dec;
	/**
	 */

	@Column(name = "total")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer total;
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
	public void setBudId(Integer budId) {
		this.budId = budId;
	}

	/**
	 */
	public Integer getBudId() {
		return this.budId;
	}

	/**
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 */
	public String getAccount() {
		return this.account;
	}

	/**
	 */
	public void setIncExp(String incExp) {
		this.incExp = incExp;
	}

	/**
	 */
	public String getIncExp() {
		return this.incExp;
	}

	/**
	 */
	public void setBudgetFk(Integer budgetFk) {
		this.budgetFk = budgetFk;
	}

	/**
	 */
	public Integer getBudgetFk() {
		return this.budgetFk;
	}

	/**
	 */
	public void setJan(Integer jan) {
		this.jan = jan;
	}

	/**
	 */
	public Integer getJan() {
		return this.jan;
	}

	/**
	 */
	public void setFeb(Integer feb) {
		this.feb = feb;
	}

	/**
	 */
	public Integer getFeb() {
		return this.feb;
	}

	/**
	 */
	public void setMar(Integer mar) {
		this.mar = mar;
	}

	/**
	 */
	public Integer getMar() {
		return this.mar;
	}

	/**
	 */
	public void setApr(Integer apr) {
		this.apr = apr;
	}

	/**
	 */
	public Integer getApr() {
		return this.apr;
	}

	/**
	 */
	public void setMay(Integer may) {
		this.may = may;
	}

	/**
	 */
	public Integer getMay() {
		return this.may;
	}

	/**
	 */
	public void setJun(Integer jun) {
		this.jun = jun;
	}

	/**
	 */
	public Integer getJun() {
		return this.jun;
	}

	/**
	 */
	public void setJul(Integer jul) {
		this.jul = jul;
	}

	/**
	 */
	public Integer getJul() {
		return this.jul;
	}

	/**
	 */
	public void setAug(Integer aug) {
		this.aug = aug;
	}

	/**
	 */
	public Integer getAug() {
		return this.aug;
	}

	/**
	 */
	public void setSep(Integer sep) {
		this.sep = sep;
	}

	/**
	 */
	public Integer getSep() {
		return this.sep;
	}

	/**
	 */
	public void setOct(Integer oct) {
		this.oct = oct;
	}

	/**
	 */
	public Integer getOct() {
		return this.oct;
	}

	/**
	 */
	public void setNov(Integer nov) {
		this.nov = nov;
	}

	/**
	 */
	public Integer getNov() {
		return this.nov;
	}

	/**
	 */
	public void setDec(Integer dec) {
		this.dec = dec;
	}

	/**
	 */
	public Integer getDec() {
		return this.dec;
	}

	/**
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}

	/**
	 */
	public Integer getTotal() {
		return this.total;
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
	public BudgetAccount() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(BudgetAccount that) {
		setBudId(that.getBudId());
		setAccount(that.getAccount());
		setIncExp(that.getIncExp());
		setBudgetFk(that.getBudgetFk());
		setJan(that.getJan());
		setFeb(that.getFeb());
		setMar(that.getMar());
		setApr(that.getApr());
		setMay(that.getMay());
		setJun(that.getJun());
		setJul(that.getJul());
		setAug(that.getAug());
		setSep(that.getSep());
		setOct(that.getOct());
		setNov(that.getNov());
		setDec(that.getDec());
		setTotal(that.getTotal());
		setActiveYn(that.getActiveYn());
		setUserFk(that.getUserFk());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("budId=[").append(budId).append("] ");
		buffer.append("account=[").append(account).append("] ");
		buffer.append("incExp=[").append(incExp).append("] ");
		buffer.append("budgetFk=[").append(budgetFk).append("] ");
		buffer.append("jan=[").append(jan).append("] ");
		buffer.append("feb=[").append(feb).append("] ");
		buffer.append("mar=[").append(mar).append("] ");
		buffer.append("apr=[").append(apr).append("] ");
		buffer.append("may=[").append(may).append("] ");
		buffer.append("jun=[").append(jun).append("] ");
		buffer.append("jul=[").append(jul).append("] ");
		buffer.append("aug=[").append(aug).append("] ");
		buffer.append("sep=[").append(sep).append("] ");
		buffer.append("oct=[").append(oct).append("] ");
		buffer.append("nov=[").append(nov).append("] ");
		buffer.append("dec=[").append(dec).append("] ");
		buffer.append("total=[").append(total).append("] ");
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
		result = (int) (prime * result + ((budId == null) ? 0 : budId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof BudgetAccount))
			return false;
		BudgetAccount equalCheck = (BudgetAccount) obj;
		if ((budId == null && equalCheck.budId != null) || (budId != null && equalCheck.budId == null))
			return false;
		if (budId != null && !budId.equals(equalCheck.budId))
			return false;
		return true;
	}
}
