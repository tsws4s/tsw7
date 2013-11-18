package wsdm.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.math.BigDecimal;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllPrices", query = "select myPrice from Price myPrice"),
		@NamedQuery(name = "findPriceByPrimaryKey", query = "select myPrice from Price myPrice where myPrice.priceId = ?1") })
@Table(catalog = "C324877_tsws4s", name = "Price")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wsdm4/wsdm/domain", name = "Price")
@XmlRootElement(namespace = "wsdm4/wsdm/domain")
public class Price implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "priceId", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer priceId;
	/**
	 */

	@Column(name = "price", scale = 2, precision = 32)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal priceField;
	/**
	 */

	@Column(name = "priceCategory", length = 45)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String priceCategory;
	/**
	 */

	@Column(name = "description", length = 235)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String description;
	/**
	 */

	@Column(name = "priceColor", length = 45)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String priceColor;

	public void setPriceId(Integer priceId) {
		this.priceId = priceId;
	}

	/**
	 */
	public Integer getPriceId() {
		return this.priceId;
	}

	/**
	 */
	public void setPriceField(BigDecimal priceField) {
		this.priceField = priceField;
	}

	/**
	 */
	public BigDecimal getPriceField() {
		return this.priceField;
	}

	/**
	 */
	public void setPriceCategory(String priceCategory) {
		this.priceCategory = priceCategory;
	}

	/**
	 */
	public String getPriceCategory() {
		return this.priceCategory;
	}

	/**
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 */
	public void setPriceColor(String priceColor) {
		this.priceColor = priceColor;
	}

	/**
	 */
	public String getPriceColor() {
		return this.priceColor;
	}
	public Price() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Price that) {
		setPriceId(that.getPriceId());
		setPriceField(that.getPriceField());
		setPriceCategory(that.getPriceCategory());
		setDescription(that.getDescription());
		setPriceColor(that.getPriceColor());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("priceId=[").append(priceId).append("] ");
		buffer.append("priceField=[").append(priceField).append("] ");
		buffer.append("priceCategory=[").append(priceCategory).append("] ");
		buffer.append("description=[").append(description).append("] ");
		buffer.append("priceColor=[").append(priceColor).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((priceId == null) ? 0 : priceId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Price))
			return false;
		Price equalCheck = (Price) obj;
		if ((priceId == null && equalCheck.priceId != null) || (priceId != null && equalCheck.priceId == null))
			return false;
		if (priceId != null && !priceId.equals(equalCheck.priceId))
			return false;
		return true;
	}
}
