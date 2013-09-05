package pm7.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.math.BigDecimal;

import java.util.Calendar;
import java.util.LinkedHashSet;
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
		@NamedQuery(name = "findAllInvoices", query = "select myInvoice from Invoice myInvoice"),
		@NamedQuery(name = "findInvoiceByActiveYn", query = "select myInvoice from Invoice myInvoice where myInvoice.activeYn = ?1"),
		@NamedQuery(name = "findInvoiceByBalanceAmt", query = "select myInvoice from Invoice myInvoice where myInvoice.balanceAmt = ?1"),
		@NamedQuery(name = "findInvoiceByBilledHrs", query = "select myInvoice from Invoice myInvoice where myInvoice.billedHrs = ?1"),
		@NamedQuery(name = "findInvoiceByBilledRate", query = "select myInvoice from Invoice myInvoice where myInvoice.billedRate = ?1"),
		@NamedQuery(name = "findInvoiceByDiscountAmt", query = "select myInvoice from Invoice myInvoice where myInvoice.discountAmt = ?1"),
		@NamedQuery(name = "findInvoiceByExpensesAmt", query = "select myInvoice from Invoice myInvoice where myInvoice.expensesAmt = ?1"),
		@NamedQuery(name = "findInvoiceByInvoiceDate", query = "select myInvoice from Invoice myInvoice where myInvoice.invoiceDate = ?1"),
		@NamedQuery(name = "findInvoiceByInvoiceDesc", query = "select myInvoice from Invoice myInvoice where myInvoice.invoiceDesc = ?1"),
		@NamedQuery(name = "findInvoiceByInvoiceDescContaining", query = "select myInvoice from Invoice myInvoice where myInvoice.invoiceDesc like ?1"),
		@NamedQuery(name = "findInvoiceByInvoiceId", query = "select myInvoice from Invoice myInvoice where myInvoice.invoiceId = ?1"),
		@NamedQuery(name = "findInvoiceByInvoiceNumber", query = "select myInvoice from Invoice myInvoice where myInvoice.invoiceNumber = ?1"),
		@NamedQuery(name = "findInvoiceByItemsAmt", query = "select myInvoice from Invoice myInvoice where myInvoice.itemsAmt = ?1"),
		@NamedQuery(name = "findInvoiceByLogoFilename", query = "select myInvoice from Invoice myInvoice where myInvoice.logoFilename = ?1"),
		@NamedQuery(name = "findInvoiceByLogoFilenameContaining", query = "select myInvoice from Invoice myInvoice where myInvoice.logoFilename like ?1"),
		@NamedQuery(name = "findInvoiceByMessage", query = "select myInvoice from Invoice myInvoice where myInvoice.message = ?1"),
		@NamedQuery(name = "findInvoiceByMessageContaining", query = "select myInvoice from Invoice myInvoice where myInvoice.message like ?1"),
		@NamedQuery(name = "findInvoiceByPaidAmt", query = "select myInvoice from Invoice myInvoice where myInvoice.paidAmt = ?1"),
		@NamedQuery(name = "findInvoiceByPaymentSched", query = "select myInvoice from Invoice myInvoice where myInvoice.paymentSched = ?1"),
		@NamedQuery(name = "findInvoiceByPaymentSchedContaining", query = "select myInvoice from Invoice myInvoice where myInvoice.paymentSched like ?1"),
		@NamedQuery(name = "findInvoiceByPrimaryKey", query = "select myInvoice from Invoice myInvoice where myInvoice.invoiceId = ?1"),
		@NamedQuery(name = "findInvoiceByStatus", query = "select myInvoice from Invoice myInvoice where myInvoice.status = ?1"),
		@NamedQuery(name = "findInvoiceByStatusContaining", query = "select myInvoice from Invoice myInvoice where myInvoice.status like ?1"),
		@NamedQuery(name = "findInvoiceByTaxesAmt", query = "select myInvoice from Invoice myInvoice where myInvoice.taxesAmt = ?1"),
		@NamedQuery(name = "findInvoiceByTotalAmt", query = "select myInvoice from Invoice myInvoice where myInvoice.totalAmt = ?1") })
@Table(catalog = "C324877_project_mgt", name = "Invoice")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "pm7/pm7/domain", name = "Invoice")
@XmlRootElement(namespace = "pm7/pm7/domain")
public class Invoice implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "invoiceId", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer invoiceId;
	/**
	 */

	@Column(name = "invoiceNumber")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer invoiceNumber;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "invoiceDate")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar invoiceDate;
	/**
	 */

	@Column(name = "invoiceDesc", length = 245)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String invoiceDesc;
	/**
	 */

	@Column(name = "status", length = 45)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String status;
	/**
	 */

	@Column(name = "paymentSched", length = 45)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String paymentSched;
	/**
	 */

	@Column(name = "billedRate", scale = 2, precision = 32)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal billedRate;
	/**
	 */

	@Column(name = "discountAmt", scale = 2, precision = 32)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal discountAmt;
	/**
	 */

	@Column(name = "taxesAmt", scale = 2, precision = 32)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal taxesAmt;
	/**
	 */

	@Column(name = "totalAmt", scale = 2, precision = 32)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal totalAmt;
	/**
	 */

	@Column(name = "paidAmt", scale = 2, precision = 32)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal paidAmt;
	/**
	 */

	@Column(name = "balanceAmt", scale = 2, precision = 32)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal balanceAmt;
	/**
	 */

	@Column(name = "message", length = 245)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String message;
	/**
	 */

	@Column(name = "billedHrs")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer billedHrs;
	/**
	 */

	@Column(name = "expensesAmt", scale = 2, precision = 32)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal expensesAmt;
	/**
	 */

	@Column(name = "itemsAmt", scale = 2, precision = 32)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal itemsAmt;
	/**
	 */

	@Column(name = "logoFilename", length = 245)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String logoFilename;
	/**
	 */

	@Column(name = "activeYN")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer activeYn;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "FK_accountId", referencedColumnName = "accountId") })
	@XmlTransient
	Account account;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "FK_clientId", referencedColumnName = "clientId") })
	@XmlTransient
	Client client;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "FK_projectId", referencedColumnName = "projectId") })
	@XmlTransient
	Project project;
	/**
	 */
	@OneToMany(mappedBy = "invoice", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Invoiceitem> invoiceitems;

	/**
	 */
	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}

	/**
	 */
	public Integer getInvoiceId() {
		return this.invoiceId;
	}

	/**
	 */
	public void setInvoiceNumber(Integer invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	/**
	 */
	public Integer getInvoiceNumber() {
		return this.invoiceNumber;
	}

	/**
	 */
	public void setInvoiceDate(Calendar invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	/**
	 */
	public Calendar getInvoiceDate() {
		return this.invoiceDate;
	}

	/**
	 */
	public void setInvoiceDesc(String invoiceDesc) {
		this.invoiceDesc = invoiceDesc;
	}

	/**
	 */
	public String getInvoiceDesc() {
		return this.invoiceDesc;
	}

	/**
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 */
	public void setPaymentSched(String paymentSched) {
		this.paymentSched = paymentSched;
	}

	/**
	 */
	public String getPaymentSched() {
		return this.paymentSched;
	}

	/**
	 */
	public void setBilledRate(BigDecimal billedRate) {
		this.billedRate = billedRate;
	}

	/**
	 */
	public BigDecimal getBilledRate() {
		return this.billedRate;
	}

	/**
	 */
	public void setDiscountAmt(BigDecimal discountAmt) {
		this.discountAmt = discountAmt;
	}

	/**
	 */
	public BigDecimal getDiscountAmt() {
		return this.discountAmt;
	}

	/**
	 */
	public void setTaxesAmt(BigDecimal taxesAmt) {
		this.taxesAmt = taxesAmt;
	}

	/**
	 */
	public BigDecimal getTaxesAmt() {
		return this.taxesAmt;
	}

	/**
	 */
	public void setTotalAmt(BigDecimal totalAmt) {
		this.totalAmt = totalAmt;
	}

	/**
	 */
	public BigDecimal getTotalAmt() {
		return this.totalAmt;
	}

	/**
	 */
	public void setPaidAmt(BigDecimal paidAmt) {
		this.paidAmt = paidAmt;
	}

	/**
	 */
	public BigDecimal getPaidAmt() {
		return this.paidAmt;
	}

	/**
	 */
	public void setBalanceAmt(BigDecimal balanceAmt) {
		this.balanceAmt = balanceAmt;
	}

	/**
	 */
	public BigDecimal getBalanceAmt() {
		return this.balanceAmt;
	}

	/**
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 */
	public void setBilledHrs(Integer billedHrs) {
		this.billedHrs = billedHrs;
	}

	/**
	 */
	public Integer getBilledHrs() {
		return this.billedHrs;
	}

	/**
	 */
	public void setExpensesAmt(BigDecimal expensesAmt) {
		this.expensesAmt = expensesAmt;
	}

	/**
	 */
	public BigDecimal getExpensesAmt() {
		return this.expensesAmt;
	}

	/**
	 */
	public void setItemsAmt(BigDecimal itemsAmt) {
		this.itemsAmt = itemsAmt;
	}

	/**
	 */
	public BigDecimal getItemsAmt() {
		return this.itemsAmt;
	}

	/**
	 */
	public void setLogoFilename(String logoFilename) {
		this.logoFilename = logoFilename;
	}

	/**
	 */
	public String getLogoFilename() {
		return this.logoFilename;
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
	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 */
	public Client getClient() {
		return client;
	}

	/**
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	/**
	 */
	public Project getProject() {
		return project;
	}

	/**
	 */
	public void setInvoiceitems(Set<Invoiceitem> invoiceitems) {
		this.invoiceitems = invoiceitems;
	}

	/**
	 */
	public Set<Invoiceitem> getInvoiceitems() {
		if (invoiceitems == null) {
			invoiceitems = new java.util.LinkedHashSet<pm7.domain.Invoiceitem>();
		}
		return invoiceitems;
	}

	/**
	 */
	public Invoice() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Invoice that) {
		setInvoiceId(that.getInvoiceId());
		setInvoiceNumber(that.getInvoiceNumber());
		setInvoiceDate(that.getInvoiceDate());
		setInvoiceDesc(that.getInvoiceDesc());
		setStatus(that.getStatus());
		setPaymentSched(that.getPaymentSched());
		setBilledRate(that.getBilledRate());
		setDiscountAmt(that.getDiscountAmt());
		setTaxesAmt(that.getTaxesAmt());
		setTotalAmt(that.getTotalAmt());
		setPaidAmt(that.getPaidAmt());
		setBalanceAmt(that.getBalanceAmt());
		setMessage(that.getMessage());
		setBilledHrs(that.getBilledHrs());
		setExpensesAmt(that.getExpensesAmt());
		setItemsAmt(that.getItemsAmt());
		setLogoFilename(that.getLogoFilename());
		setActiveYn(that.getActiveYn());
		setAccount(that.getAccount());
		setClient(that.getClient());
		setProject(that.getProject());
		setInvoiceitems(new java.util.LinkedHashSet<pm7.domain.Invoiceitem>(that.getInvoiceitems()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("invoiceId=[").append(invoiceId).append("] ");
		buffer.append("invoiceNumber=[").append(invoiceNumber).append("] ");
		buffer.append("invoiceDate=[").append(invoiceDate).append("] ");
		buffer.append("invoiceDesc=[").append(invoiceDesc).append("] ");
		buffer.append("status=[").append(status).append("] ");
		buffer.append("paymentSched=[").append(paymentSched).append("] ");
		buffer.append("billedRate=[").append(billedRate).append("] ");
		buffer.append("discountAmt=[").append(discountAmt).append("] ");
		buffer.append("taxesAmt=[").append(taxesAmt).append("] ");
		buffer.append("totalAmt=[").append(totalAmt).append("] ");
		buffer.append("paidAmt=[").append(paidAmt).append("] ");
		buffer.append("balanceAmt=[").append(balanceAmt).append("] ");
		buffer.append("message=[").append(message).append("] ");
		buffer.append("billedHrs=[").append(billedHrs).append("] ");
		buffer.append("expensesAmt=[").append(expensesAmt).append("] ");
		buffer.append("itemsAmt=[").append(itemsAmt).append("] ");
		buffer.append("logoFilename=[").append(logoFilename).append("] ");
		buffer.append("activeYn=[").append(activeYn).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((invoiceId == null) ? 0 : invoiceId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Invoice))
			return false;
		Invoice equalCheck = (Invoice) obj;
		if ((invoiceId == null && equalCheck.invoiceId != null) || (invoiceId != null && equalCheck.invoiceId == null))
			return false;
		if (invoiceId != null && !invoiceId.equals(equalCheck.invoiceId))
			return false;
		return true;
	}
}
