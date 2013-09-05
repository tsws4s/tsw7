package tsw.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.xml.bind.annotation.*;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllfcEvents", query = "select myfcEvent from fcEvent myfcEvent"),
		@NamedQuery(name = "findAllfcEvents4tsw", query = "select myfcEvent from fcEvent myfcEvent where tswAcctFk = ?1"),
		@NamedQuery(name = "findAllfcEvents4tswResource", query = "select myfcEvent from fcEvent myfcEvent where tswAcctFk = ?1 and resourceFk = ?2"),
		@NamedQuery(name = "findfcEventByDateAfterBefore", query = "select myfcEvent from fcEvent myfcEvent where (myfcEvent.resourceFk = ?1) and (myfcEvent.start > ?2) and (myfcEvent.start < ?3)"),
		@NamedQuery(name = "findfcEventByAllDay", query = "select myfcEvent from fcEvent myfcEvent where myfcEvent.allDay = ?1"),
		@NamedQuery(name = "findfcEventByClassName", query = "select myfcEvent from fcEvent myfcEvent where myfcEvent.className = ?1"),
		@NamedQuery(name = "findfcEventByClassNameContaining", query = "select myfcEvent from fcEvent myfcEvent where myfcEvent.className like ?1"),
		@NamedQuery(name = "findfcEventByColor", query = "select myfcEvent from fcEvent myfcEvent where myfcEvent.color = ?1"),
		@NamedQuery(name = "findfcEventByColorContaining", query = "select myfcEvent from fcEvent myfcEvent where myfcEvent.color like ?1"),
		@NamedQuery(name = "findfcEventByEditable", query = "select myfcEvent from fcEvent myfcEvent where myfcEvent.editable = ?1"),
		@NamedQuery(name = "findfcEventByEnd", query = "select myfcEvent from fcEvent myfcEvent where myfcEvent.end = ?1"),
		@NamedQuery(name = "findfcEventById", query = "select myfcEvent from fcEvent myfcEvent where myfcEvent.id = ?1"),
		@NamedQuery(name = "findfcEventByPrimaryKey", query = "select myfcEvent from fcEvent myfcEvent where myfcEvent.id = ?1"),
		@NamedQuery(name = "findfcEventByStart", query = "select myfcEvent from fcEvent myfcEvent where myfcEvent.start = ?1"),
		@NamedQuery(name = "findfcEventByTitle", query = "select myfcEvent from fcEvent myfcEvent where myfcEvent.title = ?1"),
		@NamedQuery(name = "findfcEventByTitleContaining", query = "select myfcEvent from fcEvent myfcEvent where myfcEvent.title like ?1"),
		@NamedQuery(name = "findfcEventByUrl", query = "select myfcEvent from fcEvent myfcEvent where myfcEvent.url = ?1"),
		@NamedQuery(name = "findfcEventByUrlContaining", query = "select myfcEvent from fcEvent myfcEvent where myfcEvent.url like ?1") })
@Table(catalog = "tsws4s_4", name = "fcEvent")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "tsw7/tsw/domain", name = "fcEvent")

public class fcEvent implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer id;
	/**
	 */

	@Column(name = "title", length = 145, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String title;
	/**
	 */

	@Column(name = "allDay")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean allDay;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "eventDate")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar eventDate;

	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar start;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar end;
	/**
	 */

	@Column(name = "url", length = 245)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String url;
	/**
	 */

	@Column(name = "className", length = 145)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String className;
	/**
	 */

	/**
	@Column(name = "editable")
	@Basic(fetch = FetchType.EAGER)
	 */	
	@XmlElement
	Boolean editable;
	/**
	 */

	@Column(name = "color", length = 45)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String color;
	/**
	 */
	@Column(name = "tswAcctFk")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer tswAcctFk;

	@Column(name = "resourceFk", length = 45)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer resourceFk;
	/**
	 */
		 
	/**
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}
	
	public Integer getTswAcctFk() {
		return tswAcctFk;
	}

	public void setTswAcctFk(Integer tswAcctFk) {
		this.tswAcctFk = tswAcctFk;
	}
	
	/**
	 */	
	public Integer getResourceFk() {
		return resourceFk;
	}

	public void setResourceFk(Integer resourceFk) {
		this.resourceFk = resourceFk;
	}

	/**
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 */
	public String getTitle() {
		return this.title;
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
	public Calendar getEventDate() {
		return eventDate;
	}

	public void setEventDate(Calendar eventDate) {
		this.eventDate = eventDate;
	}
	
	/**
	 */
	public void setStart(Calendar start) {
		this.start = start;
	}

	public Calendar getStartOrig() {
		return this.start;
	}	/**
	 */
	public String getStart() {
		DateFormat formatter1 = new SimpleDateFormat("M-dd-yyyy");
		String input1 = formatter1.format(this.eventDate.getTime());
		DateFormat formatter2 = new SimpleDateFormat("hh:mm:ss a");
		String input2 = formatter2.format(this.start.getTime());
		DateFormat formatter3 = new SimpleDateFormat("M-dd-yyyy hh:mm:ss a");
		Date date = this.eventDate.getTime();
		try{
			date = formatter3.parse(input1+" "+input2);
		} catch (Exception e){
			e.printStackTrace();
		}
		DateTimeFormatter fmt = ISODateTimeFormat.dateTime();
		DateTime dt = new DateTime(date);
		return fmt.print(dt);
	}

	/**
	 */
	public void setEnd(Calendar end) {
		this.end = end;
	}

	/**
	 */
	public Calendar getEndOrig() {
		return this.end;
	}
	public String getEnd() {
		DateFormat formatter1 = new SimpleDateFormat("M-dd-yyyy");
		String input1 = formatter1.format(this.eventDate.getTime());
		DateFormat formatter2 = new SimpleDateFormat("hh:mm:ss a");
		String input2 = formatter2.format(this.end.getTime());
		DateFormat formatter3 = new SimpleDateFormat("M-dd-yyyy hh:mm:ss a");
		Date date = this.eventDate.getTime();
		try{
			date = formatter3.parse(input1+" "+input2);
		} catch (Exception e){
			e.printStackTrace();
		}
		DateTimeFormatter fmt = ISODateTimeFormat.dateTime();
		DateTime dt = new DateTime(date);
		return fmt.print(dt);
	}

	/**
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 */
	public String getClassName() {
		return this.className;
	}

	/**
	 */
	public void setEditable(Boolean editable) {
		this.editable = editable;
	}

	/**
	 */
	public Boolean getEditable() {
		return this.editable;
	}

	/**
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 */
	public String getColor() {
		return this.color;
	}

	/**
	 */
	public fcEvent() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(fcEvent that) {
		setId(that.getId());
		setTitle(that.getTitle());
		setAllDay(that.getAllDay());
		setStart(that.getStartOrig());
		setEnd(that.getEndOrig());
		setUrl(that.getUrl());
		setClassName(that.getClassName());
		setEditable(that.getEditable());
		setColor(that.getColor());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("title=[").append(title).append("] ");
		buffer.append("allDay=[").append(allDay).append("] ");
		buffer.append("start=[").append(start).append("] ");
		buffer.append("end=[").append(end).append("] ");
		buffer.append("url=[").append(url).append("] ");
		buffer.append("className=[").append(className).append("] ");
		buffer.append("editable=[").append(editable).append("] ");
		buffer.append("color=[").append(color).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((id == null) ? 0 : id.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof fcEvent))
			return false;
		fcEvent equalCheck = (fcEvent) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
