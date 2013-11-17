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
		@NamedQuery(name = "findAllTemplatemonthlys", query = "select myTemplatemonthly from Templatemonthly myTemplatemonthly"),
		@NamedQuery(name = "findTemplatemonthlyByDescription", query = "select myTemplatemonthly from Templatemonthly myTemplatemonthly where myTemplatemonthly.description = ?1"),
		@NamedQuery(name = "findTemplatemonthlyByDescriptionContaining", query = "select myTemplatemonthly from Templatemonthly myTemplatemonthly where myTemplatemonthly.description like ?1"),
		@NamedQuery(name = "findTemplatemonthlyByMonthlyTemplateId", query = "select myTemplatemonthly from Templatemonthly myTemplatemonthly where myTemplatemonthly.monthlyTemplateId = ?1"),
		@NamedQuery(name = "findTemplatemonthlyByPrimaryKey", query = "select myTemplatemonthly from Templatemonthly myTemplatemonthly where myTemplatemonthly.monthlyTemplateId = ?1"),
		@NamedQuery(name = "findTemplatemonthlyByTemplateName", query = "select myTemplatemonthly from Templatemonthly myTemplatemonthly where myTemplatemonthly.templateName = ?1"),
		@NamedQuery(name = "findTemplatemonthlyByTemplateNameContaining", query = "select myTemplatemonthly from Templatemonthly myTemplatemonthly where myTemplatemonthly.templateName like ?1"),
		@NamedQuery(name = "findTemplatemonthlyByWeek1fk", query = "select myTemplatemonthly from Templatemonthly myTemplatemonthly where myTemplatemonthly.week1fk = ?1"),
		@NamedQuery(name = "findTemplatemonthlyByWeek2fk", query = "select myTemplatemonthly from Templatemonthly myTemplatemonthly where myTemplatemonthly.week2fk = ?1"),
		@NamedQuery(name = "findTemplatemonthlyByWeek3fk", query = "select myTemplatemonthly from Templatemonthly myTemplatemonthly where myTemplatemonthly.week3fk = ?1"),
		@NamedQuery(name = "findTemplatemonthlyByWeek4fk", query = "select myTemplatemonthly from Templatemonthly myTemplatemonthly where myTemplatemonthly.week4fk = ?1"),
		@NamedQuery(name = "findTemplatemonthlyByWeek5fk", query = "select myTemplatemonthly from Templatemonthly myTemplatemonthly where myTemplatemonthly.week5fk = ?1") })
@Table(catalog = "C324877_tsws4s", name = "TemplateMonthly")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wsdm7/wsdm/domain", name = "Templatemonthly")
public class Templatemonthly implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "monthlyTemplateId", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer monthlyTemplateId;
	/**
	 */

	@Column(name = "templateName", length = 45)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String templateName;
	/**
	 */

	@Column(name = "description", length = 235)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String description;
	/**
	 */

	@Column(name = "week1FK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer week1fk;
	/**
	 */

	@Column(name = "week2FK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer week2fk;
	/**
	 */

	@Column(name = "week3FK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer week3fk;
	/**
	 */

	@Column(name = "week4FK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer week4fk;
	/**
	 */

	@Column(name = "week5FK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer week5fk;

	/**
	 */
	public void setMonthlyTemplateId(Integer monthlyTemplateId) {
		this.monthlyTemplateId = monthlyTemplateId;
	}

	/**
	 */
	public Integer getMonthlyTemplateId() {
		return this.monthlyTemplateId;
	}

	/**
	 */
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	/**
	 */
	public String getTemplateName() {
		return this.templateName;
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
	public void setWeek1fk(Integer week1fk) {
		this.week1fk = week1fk;
	}

	/**
	 */
	public Integer getWeek1fk() {
		return this.week1fk;
	}

	/**
	 */
	public void setWeek2fk(Integer week2fk) {
		this.week2fk = week2fk;
	}

	/**
	 */
	public Integer getWeek2fk() {
		return this.week2fk;
	}

	/**
	 */
	public void setWeek3fk(Integer week3fk) {
		this.week3fk = week3fk;
	}

	/**
	 */
	public Integer getWeek3fk() {
		return this.week3fk;
	}

	/**
	 */
	public void setWeek4fk(Integer week4fk) {
		this.week4fk = week4fk;
	}

	/**
	 */
	public Integer getWeek4fk() {
		return this.week4fk;
	}

	/**
	 */
	public void setWeek5fk(Integer week5fk) {
		this.week5fk = week5fk;
	}

	/**
	 */
	public Integer getWeek5fk() {
		return this.week5fk;
	}

	/**
	 */
	public Templatemonthly() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Templatemonthly that) {
		setMonthlyTemplateId(that.getMonthlyTemplateId());
		setTemplateName(that.getTemplateName());
		setDescription(that.getDescription());
		setWeek1fk(that.getWeek1fk());
		setWeek2fk(that.getWeek2fk());
		setWeek3fk(that.getWeek3fk());
		setWeek4fk(that.getWeek4fk());
		setWeek5fk(that.getWeek5fk());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("monthlyTemplateId=[").append(monthlyTemplateId).append("] ");
		buffer.append("templateName=[").append(templateName).append("] ");
		buffer.append("description=[").append(description).append("] ");
		buffer.append("week1fk=[").append(week1fk).append("] ");
		buffer.append("week2fk=[").append(week2fk).append("] ");
		buffer.append("week3fk=[").append(week3fk).append("] ");
		buffer.append("week4fk=[").append(week4fk).append("] ");
		buffer.append("week5fk=[").append(week5fk).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((monthlyTemplateId == null) ? 0 : monthlyTemplateId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Templatemonthly))
			return false;
		Templatemonthly equalCheck = (Templatemonthly) obj;
		if ((monthlyTemplateId == null && equalCheck.monthlyTemplateId != null) || (monthlyTemplateId != null && equalCheck.monthlyTemplateId == null))
			return false;
		if (monthlyTemplateId != null && !monthlyTemplateId.equals(equalCheck.monthlyTemplateId))
			return false;
		return true;
	}
}
