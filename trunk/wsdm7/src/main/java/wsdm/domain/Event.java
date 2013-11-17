package wsdm.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.Calendar;
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
		@NamedQuery(name = "findAllEvents", query = "select myEvent from Event myEvent"),
		@NamedQuery(name = "findEventByAllDay", query = "select myEvent from Event myEvent where myEvent.allDay = ?1"),
		@NamedQuery(name = "findEventByDescription", query = "select myEvent from Event myEvent where myEvent.description = ?1"),
		@NamedQuery(name = "findEventByDescriptionContaining", query = "select myEvent from Event myEvent where myEvent.description like ?1"),
		@NamedQuery(name = "findEventByEndTime", query = "select myEvent from Event myEvent where myEvent.endTime = ?1"),
		@NamedQuery(name = "findEventByEventColor", query = "select myEvent from Event myEvent where myEvent.eventColor = ?1"),
		@NamedQuery(name = "findEventByEventColorContaining", query = "select myEvent from Event myEvent where myEvent.eventColor like ?1"),
		@NamedQuery(name = "findEventByEventId", query = "select myEvent from Event myEvent where myEvent.eventId = ?1"),
		@NamedQuery(name = "findEventByEventName", query = "select myEvent from Event myEvent where myEvent.eventName = ?1"),
		@NamedQuery(name = "findEventByEventNameContaining", query = "select myEvent from Event myEvent where myEvent.eventName like ?1"),
		@NamedQuery(name = "findEventByEventType", query = "select myEvent from Event myEvent where myEvent.eventType = ?1"),
		@NamedQuery(name = "findEventByEventTypeContaining", query = "select myEvent from Event myEvent where myEvent.eventType like ?1"),
		@NamedQuery(name = "findEventByEventUrl", query = "select myEvent from Event myEvent where myEvent.eventUrl = ?1"),
		@NamedQuery(name = "findEventByEventUrlContaining", query = "select myEvent from Event myEvent where myEvent.eventUrl like ?1"),
		@NamedQuery(name = "findEventByPrimaryKey", query = "select myEvent from Event myEvent where myEvent.eventId = ?1"),
		@NamedQuery(name = "findEventByStartTime", query = "select myEvent from Event myEvent where myEvent.startTime = ?1") })
@Table(catalog = "C324877_tsws4s", name = "Event")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wsdm7/wsdm/domain", name = "Event")
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
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "customerFk", referencedColumnName = "customerID") })
	@XmlTransient
	Customer customer;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "gameFk", referencedColumnName = "gameID") })
	@XmlTransient
	Game game;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "resourceFk", referencedColumnName = "resourceID") })
	@XmlTransient
	Resource resource;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "priceFk", referencedColumnName = "priceId") })
	@XmlTransient
	Price price;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "programFk", referencedColumnName = "programID") })
	@XmlTransient
	Program program;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "tswAcctFk", referencedColumnName = "tswAcctID") })
	@XmlTransient
	Tswacct tswacct;

	/**
	 */
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

	/**
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 */
	public void setGame(Game game) {
		this.game = game;
	}

	/**
	 */
	public Game getGame() {
		return game;
	}

	/**
	 */
	public void setResource(Resource resource) {
		this.resource = resource;
	}

	/**
	 */
	public Resource getResource() {
		return resource;
	}

	/**
	 */
	public void setPrice(Price price) {
		this.price = price;
	}

	/**
	 */
	public Price getPrice() {
		return price;
	}

	/**
	 */
	public void setProgram(Program program) {
		this.program = program;
	}

	/**
	 */
	public Program getProgram() {
		return program;
	}

	/**
	 */
	public void setTswacct(Tswacct tswacct) {
		this.tswacct = tswacct;
	}

	/**
	 */
	public Tswacct getTswacct() {
		return tswacct;
	}

	/**
	 */
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
		setCustomer(that.getCustomer());
		setGame(that.getGame());
		setResource(that.getResource());
		setPrice(that.getPrice());
		setProgram(that.getProgram());
		setTswacct(that.getTswacct());
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
