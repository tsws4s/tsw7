package pm7.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.math.BigDecimal;

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
		@NamedQuery(name = "findAllInvoiceitems", query = "select myInvoiceitem from Invoiceitem myInvoiceitem"),
		@NamedQuery(name = "findInvoiceitemByInvoiceItemDesc", query = "select myInvoiceitem from Invoiceitem myInvoiceitem where myInvoiceitem.invoiceItemDesc = ?1"),
		@NamedQuery(name = "findInvoiceitemByInvoiceItemDescContaining", query = "select myInvoiceitem from Invoiceitem myInvoiceitem where myInvoiceitem.invoiceItemDesc like ?1"),
		@NamedQuery(name = "findInvoiceitemByInvoiceItemId", query = "select myInvoiceitem from Invoiceitem myInvoiceitem where myInvoiceitem.invoiceItemId = ?1"),
		@NamedQuery(name = "findInvoiceitemByItemAmt", query = "select myInvoiceitem from Invoiceitem myInvoiceitem where myInvoiceitem.itemAmt = ?1"),
		@NamedQuery(name = "findInvoiceitemByPrimaryKey", query = "select myInvoiceitem from Invoiceitem myInvoiceitem where myInvoiceitem.invoiceItemId = ?1"),
		@NamedQuery(name = "findInvoiceitemByProjectExpenseYn", query = "select myInvoiceitem from Invoiceitem myInvoiceitem where myInvoiceitem.projectExpenseYn = ?1") })
@Table(catalog = "C324877_project_mgt", name = "InvoiceItem")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "pm7/pm7/domain", name = "Invoiceitem")
public class Invoiceitem implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "invoiceItemId", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer invoiceItemId;
	/**
	 */

	@Column(name = "invoiceItemDesc", length = 245)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String invoiceItemDesc;
	/**
	 */

	@Column(name = "itemAmt", scale = 2, precision = 32)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal itemAmt;
	/**
	 */

	@Column(name = "projectExpenseYN")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer projectExpenseYn;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "FK_accountId", referencedColumnName = "accountId") })
	@XmlTransient
	Account account;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "FK_invoiceId", referencedColumnName = "invoiceId") })
	@XmlTransient
	Invoice invoice;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "FK_projectId", referencedColumnName = "projectId") })
	@XmlTransient
	Project project;

	/**
	 */
	public void setInvoiceItemId(Integer invoiceItemId) {
		this.invoiceItemId = invoiceItemId;
	}

	/**
	 */
	public Integer getInvoiceItemId() {
		return this.invoiceItemId;
	}

	/**
	 */
	public void setInvoiceItemDesc(String invoiceItemDesc) {
		this.invoiceItemDesc = invoiceItemDesc;
	}

	/**
	 */
	public String getInvoiceItemDesc() {
		return this.invoiceItemDesc;
	}

	/**
	 */
	public void setItemAmt(BigDecimal itemAmt) {
		this.itemAmt = itemAmt;
	}

	/**
	 */
	public BigDecimal getItemAmt() {
		return this.itemAmt;
	}

	/**
	 */
	public void setProjectExpenseYn(Integer projectExpenseYn) {
		this.projectExpenseYn = projectExpenseYn;
	}

	/**
	 */
	public Integer getProjectExpenseYn() {
		return this.projectExpenseYn;
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
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	/**
	 */
	public Invoice getInvoice() {
		return invoice;
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
	public Invoiceitem() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Invoiceitem that) {
		setInvoiceItemId(that.getInvoiceItemId());
		setInvoiceItemDesc(that.getInvoiceItemDesc());
		setItemAmt(that.getItemAmt());
		setProjectExpenseYn(that.getProjectExpenseYn());
		setAccount(that.getAccount());
		setInvoice(that.getInvoice());
		setProject(that.getProject());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("invoiceItemId=[").append(invoiceItemId).append("] ");
		buffer.append("invoiceItemDesc=[").append(invoiceItemDesc).append("] ");
		buffer.append("itemAmt=[").append(itemAmt).append("] ");
		buffer.append("projectExpenseYn=[").append(projectExpenseYn).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((invoiceItemId == null) ? 0 : invoiceItemId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Invoiceitem))
			return false;
		Invoiceitem equalCheck = (Invoiceitem) obj;
		if ((invoiceItemId == null && equalCheck.invoiceItemId != null) || (invoiceItemId != null && equalCheck.invoiceItemId == null))
			return false;
		if (invoiceItemId != null && !invoiceItemId.equals(equalCheck.invoiceItemId))
			return false;
		return true;
	}
}
