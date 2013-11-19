package wsdm.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.math.BigDecimal;

import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllTswaccts", query = "select myTswacct from Tswacct myTswacct"),
		@NamedQuery(name = "findTswacctByActiveYn", query = "select myTswacct from Tswacct myTswacct where myTswacct.activeYn = ?1"),
		@NamedQuery(name = "findTswacctByExpireDate", query = "select myTswacct from Tswacct myTswacct where myTswacct.expireDate = ?1"),
		@NamedQuery(name = "findTswacctByPrimaryKey", query = "select myTswacct from Tswacct myTswacct where myTswacct.tswAcctId = ?1"),
		@NamedQuery(name = "findTswacctBySubscrType", query = "select myTswacct from Tswacct myTswacct where myTswacct.subscrType = ?1"),
		@NamedQuery(name = "findTswacctByTswAcctId", query = "select myTswacct from Tswacct myTswacct where myTswacct.tswAcctId = ?1") })
@Table(catalog = "C324877_tsws4s", name = "TswAcct")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wsdm4/wsdm/domain", name = "Tswacct")
@XmlRootElement(namespace = "wsdm4/wsdm/domain")
public class Tswacct implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "tswAcctID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer tswAcctId;
	/**
	 */

	@Column(name = "acctName", length = 155)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String acctName;
	/**
	 */

	@Column(name = "subscrType", length = 155)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String subscrType;
	/**
	 */

	@Column(name = "amtPaid", scale = 2, precision = 32)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal amtPaid;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "establishDate")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar establishDate;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "expireDate")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar expireDate;
	/**
	 */

	@Column(name = "activeYN")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer activeYn;
	
	@Column(name = "acctAdminFK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer acctAdminFK;

	/**
	 */
	public void setTswAcctId(Integer tswAcctId) {
		this.tswAcctId = tswAcctId;
	}

	/**
	 */
	public Integer getTswAcctId() {
		return this.tswAcctId;
	}

	/**
	 */
	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}

	/**
	 */
	public String getAcctName() {
		return this.acctName;
	}

	/**
	 */
	public void setSubscrType(String subscrType) {
		this.subscrType = subscrType;
	}

	/**
	 */
	public String getSubscrType() {
		return this.subscrType;
	}

	/**
	 */
	public void setAmtPaid(BigDecimal amtPaid) {
		this.amtPaid = amtPaid;
	}

	/**
	 */
	public BigDecimal getAmtPaid() {
		return this.amtPaid;
	}

	/**
	 */
	public void setEstablishDate(Calendar establishDate) {
		this.establishDate = establishDate;
	}

	/**
	 */
	public Calendar getEstablishDate() {
		return this.establishDate;
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
	public void setActiveYn(Integer activeYn) {
		this.activeYn = activeYn;
	}

	/**
	 */
	public Integer getActiveYn() {
		return this.activeYn;
	}

	
	public Integer getAcctAdminFK() {
		return acctAdminFK;
	}

	public void setAcctAdminFK(Integer acctAdminFK) {
		this.acctAdminFK = acctAdminFK;
	}

	/**
	 */
	public Tswacct() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Tswacct that) {
		setTswAcctId(that.getTswAcctId());
		setAcctName(that.getAcctName());
		setSubscrType(that.getSubscrType());
		setAmtPaid(that.getAmtPaid());
		setEstablishDate(that.getEstablishDate());
		setExpireDate(that.getExpireDate());
		setActiveYn(that.getActiveYn());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("tswAcctId=[").append(tswAcctId).append("] ");
		buffer.append("acctName=[").append(acctName).append("] ");
		buffer.append("subscrType=[").append(subscrType).append("] ");
		buffer.append("amtPaid=[").append(amtPaid).append("] ");
		buffer.append("establishDate=[").append(establishDate).append("] ");
		buffer.append("expireDate=[").append(expireDate).append("] ");
		buffer.append("activeYn=[").append(activeYn).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((tswAcctId == null) ? 0 : tswAcctId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Tswacct))
			return false;
		Tswacct equalCheck = (Tswacct) obj;
		if ((tswAcctId == null && equalCheck.tswAcctId != null) || (tswAcctId != null && equalCheck.tswAcctId == null))
			return false;
		if (tswAcctId != null && !tswAcctId.equals(equalCheck.tswAcctId))
			return false;
		return true;
	}
}
