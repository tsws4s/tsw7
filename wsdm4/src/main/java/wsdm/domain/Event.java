package wsdm.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

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
		@NamedQuery(name = "findAllEvents", query = "select myEvent from Event myEvent"),
		@NamedQuery(name = "findEventByEventId", query = "select myEvent from Event myEvent where myEvent.eventId = ?1"),
		@NamedQuery(name = "findEventByEventName", query = "select myEvent from Event myEvent where myEvent.eventName = ?1"),
		@NamedQuery(name = "findEventByEventType", query = "select myEvent from Event myEvent where myEvent.eventType = ?1"),
		@NamedQuery(name = "findEventByPrimaryKey", query = "select myEvent from Event myEvent where myEvent.eventId = ?1") })
@Table(catalog = "C324877_tsws4s", name = "Event")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wsdm4/wsdm/domain", name = "Event")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "eventId", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer eventId;
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

	@Column(name = "eventName", length = 85)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String eventName;
	/**
	 */

	@Column(name = "description", length = 235)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String description;
	/**
	 */

	@Column(name = "eventType", length = 25)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String eventType;
	/**
	 */

	@Column(name = "eventUrl", length = 245)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String eventUrl;
	/**
	 */

	@Column(name = "eventColor", length = 45)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String eventColor;
	/**
	 */

	@Column(name = "allDay")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean allDay;

	/**
	 */

	@Column(name = "resourceFk")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer resourceFK;
	
	/**
	 */

	@Column(name = "priceFk")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer priceFK;
	
	/**
	 */

	@Column(name = "programFk")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer programFK;
	
	/**
	 */

	@Column(name = "gameFk")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer gameFK;
	
	/**
	 */

	@Column(name = "customerFk")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer customerFK;
	
	/**
	 */

	@Column(name = "tswAcctFk")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer tswAcctFK;

	
	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	/**
	 */
	public Integer getEventId() {
		return this.eventId;
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
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 */
	public String getEventName() {
		return this.eventName;
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
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	/**
	 */
	public String getEventType() {
		return this.eventType;
	}

	/**
	 */
	public void setEventUrl(String eventUrl) {
		this.eventUrl = eventUrl;
	}

	/**
	 */
	public String getEventUrl() {
		return this.eventUrl;
	}

	/**
	 */
	public void setEventColor(String eventColor) {
		this.eventColor = eventColor;
	}

	/**
	 */
	public String getEventColor() {
		return this.eventColor;
	}

	/**
	 */
	public void setAllDay(Boolean allDay) {
		this.allDay = allDay;
	}

	/**
	 */
	public Boolean getAllDay() {
		return this.allDay;
	}

	public Integer getResourceFK() {
		return resourceFK;
	}

	public void setResourceFK(Integer resourceFK) {
		this.resourceFK = resourceFK;
	}

	public Integer getPriceFK() {
		return priceFK;
	}

	public void setPriceFK(Integer priceFK) {
		this.priceFK = priceFK;
	}

	public Integer getProgramFK() {
		return programFK;
	}

	public void setProgramFK(Integer programFK) {
		this.programFK = programFK;
	}

	public Integer getGameFK() {
		return gameFK;
	}

	public void setGameFK(Integer gameFK) {
		this.gameFK = gameFK;
	}

	public Integer getCustomerFK() {
		return customerFK;
	}

	public void setCustomerFK(Integer customerFK) {
		this.customerFK = customerFK;
	}

	public Integer getTswAcctFK() {
		return tswAcctFK;
	}

	public void setTswAcctFK(Integer tswAcctFK) {
		this.tswAcctFK = tswAcctFK;
	}

	public Event() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Event that) {
		setEventId(that.getEventId());
		setStartTime(that.getStartTime());
		setEndTime(that.getEndTime());
		setEventName(that.getEventName());
		setDescription(that.getDescription());
		setEventType(that.getEventType());
		setEventUrl(that.getEventUrl());
		setEventColor(that.getEventColor());
		setAllDay(that.getAllDay());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("eventId=[").append(eventId).append("] ");
		buffer.append("startTime=[").append(startTime).append("] ");
		buffer.append("endTime=[").append(endTime).append("] ");
		buffer.append("eventName=[").append(eventName).append("] ");
		buffer.append("description=[").append(description).append("] ");
		buffer.append("eventType=[").append(eventType).append("] ");
		buffer.append("eventUrl=[").append(eventUrl).append("] ");
		buffer.append("eventColor=[").append(eventColor).append("] ");
		buffer.append("allDay=[").append(allDay).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((eventId == null) ? 0 : eventId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Event))
			return false;
		Event equalCheck = (Event) obj;
		if ((eventId == null && equalCheck.eventId != null) || (eventId != null && equalCheck.eventId == null))
			return false;
		if (eventId != null && !eventId.equals(equalCheck.eventId))
			return false;
		return true;
	}
}
