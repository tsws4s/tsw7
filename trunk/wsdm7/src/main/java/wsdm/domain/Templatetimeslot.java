package wsdm.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.Calendar;

import javax.persistence.Id;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@Table(catalog = "C324877_tsws4s", name = "TemplateTimeSlot")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wsdm7/wsdm/domain", name = "Templatetimeslot")
public class Templatetimeslot implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "timeSlotId", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer timeSlotId;
	/**
	 */

	@Column(name = "slotNum")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer slotNum;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "startTime")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar startTime;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "endTime")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar endTime;
	/**
	 */

	@Column(name = "priceFK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer priceFk;
	/**
	 */

	@Column(name = "dailyTemplateFK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer dailyTemplateFk;

	/**
	 */
	public void setTimeSlotId(Integer timeSlotId) {
		this.timeSlotId = timeSlotId;
	}

	/**
	 */
	public Integer getTimeSlotId() {
		return this.timeSlotId;
	}

	/**
	 */
	public void setSlotNum(Integer slotNum) {
		this.slotNum = slotNum;
	}

	/**
	 */
	public Integer getSlotNum() {
		return this.slotNum;
	}

	/**
	 */
	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

	/**
	 */
	public Calendar getStartTime() {
		return this.startTime;
	}

	/**
	 */
	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}

	/**
	 */
	public Calendar getEndTime() {
		return this.endTime;
	}

	/**
	 */
	public void setPriceFk(Integer priceFk) {
		this.priceFk = priceFk;
	}

	/**
	 */
	public Integer getPriceFk() {
		return this.priceFk;
	}

	/**
	 */
	public void setDailyTemplateFk(Integer dailyTemplateFk) {
		this.dailyTemplateFk = dailyTemplateFk;
	}

	/**
	 */
	public Integer getDailyTemplateFk() {
		return this.dailyTemplateFk;
	}

	/**
	 */
	public Templatetimeslot() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Templatetimeslot that) {
		setTimeSlotId(that.getTimeSlotId());
		setSlotNum(that.getSlotNum());
		setStartTime(that.getStartTime());
		setEndTime(that.getEndTime());
		setPriceFk(that.getPriceFk());
		setDailyTemplateFk(that.getDailyTemplateFk());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("timeSlotId=[").append(timeSlotId).append("] ");
		buffer.append("slotNum=[").append(slotNum).append("] ");
		buffer.append("startTime=[").append(startTime).append("] ");
		buffer.append("endTime=[").append(endTime).append("] ");
		buffer.append("priceFk=[").append(priceFk).append("] ");
		buffer.append("dailyTemplateFk=[").append(dailyTemplateFk).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((timeSlotId == null) ? 0 : timeSlotId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Templatetimeslot))
			return false;
		Templatetimeslot equalCheck = (Templatetimeslot) obj;
		if ((timeSlotId == null && equalCheck.timeSlotId != null) || (timeSlotId != null && equalCheck.timeSlotId == null))
			return false;
		if (timeSlotId != null && !timeSlotId.equals(equalCheck.timeSlotId))
			return false;
		return true;
	}
}
