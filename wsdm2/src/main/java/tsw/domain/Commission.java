package tsw.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


	@Entity
	@NamedQueries({
	@NamedQuery(name = "findAllCommissions", query = "select myCommission from Commission myCommission"),
	@NamedQuery(name = "findAllCommissions4tsw", query = "select myCommission from Commission myCommission where tswAcctFk = ?1"),
	@NamedQuery(name = "findCommissionByDate", query = "select myCommission from Commission myCommission where (salesDate = ?1)"),
	@NamedQuery(name = "findCommissionsBySalesRepId", query = "select myCommission from Commission myCommission where (salesRepId = ?1)"),
	@NamedQuery(name = "findCommissionByPrimaryKey", query = "select myCommission from Commission myCommission where myCommission.commissionId = ?1") })
	
	@Table(catalog = "tsws4s_4", name = "Commission")
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(namespace = "tsw7/tsw/domain", name = "Commission")
	@XmlRootElement(namespace = "tsw7/tsw/domain")
	public class Commission implements Serializable {

		private static final long serialVersionUID = 1L;

		/**
		 */

		@Column(name = "commissionId", nullable = false)
		@Basic(fetch = FetchType.EAGER)
		@Id
		@XmlElement
		Integer commissionId;
		
		@Temporal(TemporalType.DATE)
		@Column(name = "salesDate")
		@Basic(fetch = FetchType.EAGER)
		@XmlElement
		Calendar salesDate;
		
		@Temporal(TemporalType.DATE)
		@Column(name = "commissionDate")
		@Basic(fetch = FetchType.EAGER)
		@XmlElement
		Calendar commissionDate;
	
		@Column(name = "commissionAmount", scale = 2, precision = 32)
		@Basic(fetch = FetchType.EAGER)
		@XmlElement
		BigDecimal commissionAmount;
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumns({ @JoinColumn(name = "salesRepFk", referencedColumnName = "customerID") })
		@XmlTransient
		Customer customer;
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumns({ @JoinColumn(name = "tswAcctFk", referencedColumnName = "tswAcctID") })
		@XmlTransient
		Tswacct tswacct;
	
		@Column(name = "paidYN")
		@Basic(fetch = FetchType.EAGER)
		@XmlElement
		Integer paidYN;
	
		public Commission() {

		}	
		
		public Integer getCommissionId() {
			return commissionId;
		}

		public void setCommissionId(Integer commissionId) {
			this.commissionId = commissionId;
		}

		public Calendar getSalesDate() {
			return salesDate;
		}

		public void setSalesDate(Calendar salesDate) {
			this.salesDate = salesDate;
		}

		public Calendar getCommissionDate() {
			return commissionDate;
		}

		public void setCommissionDate(Calendar commissionDate) {
			this.commissionDate = commissionDate;
		}

		public BigDecimal getCommissionAmount() {
			return commissionAmount;
		}

		public void setCommissionAmount(BigDecimal commissionAmount) {
			this.commissionAmount = commissionAmount;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		public Tswacct getTswacct() {
			return tswacct;
		}

		public void setTswacct(Tswacct tswacct) {
			this.tswacct = tswacct;
		}

		public Integer getPaidYN() {
			return paidYN;
		}

		public void setPaidYN(Integer paidYN) {
			this.paidYN = paidYN;
		}
		
}
