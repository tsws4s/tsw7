package wsdm.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import javax.persistence.Id;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@Table(catalog = "C324877_tsws4s", name = "TemplateDaily")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wsdm7/wsdm/domain", name = "Templatedaily")
public class Templatedaily implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "dailyTemplateId", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer dailyTemplateId;
	/**
	 */

	@Column(name = "templateName", length = 85)
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

	@Column(name = "numTimeSlots")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer numTimeSlots;

	/**
	 */
	public void setDailyTemplateId(Integer dailyTemplateId) {
		this.dailyTemplateId = dailyTemplateId;
	}

	/**
	 */
	public Integer getDailyTemplateId() {
		return this.dailyTemplateId;
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
	public void setNumTimeSlots(Integer numTimeSlots) {
		this.numTimeSlots = numTimeSlots;
	}

	/**
	 */
	public Integer getNumTimeSlots() {
		return this.numTimeSlots;
	}

	/**
	 */
	public Templatedaily() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Templatedaily that) {
		setDailyTemplateId(that.getDailyTemplateId());
		setTemplateName(that.getTemplateName());
		setDescription(that.getDescription());
		setNumTimeSlots(that.getNumTimeSlots());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("dailyTemplateId=[").append(dailyTemplateId).append("] ");
		buffer.append("templateName=[").append(templateName).append("] ");
		buffer.append("description=[").append(description).append("] ");
		buffer.append("numTimeSlots=[").append(numTimeSlots).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((dailyTemplateId == null) ? 0 : dailyTemplateId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Templatedaily))
			return false;
		Templatedaily equalCheck = (Templatedaily) obj;
		if ((dailyTemplateId == null && equalCheck.dailyTemplateId != null) || (dailyTemplateId != null && equalCheck.dailyTemplateId == null))
			return false;
		if (dailyTemplateId != null && !dailyTemplateId.equals(equalCheck.dailyTemplateId))
			return false;
		return true;
	}
}
