package wsdm.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.Calendar;

import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllTemplatecalendardates", query = "select myTemplatecalendardate from Templatecalendardate myTemplatecalendardate"),
		@NamedQuery(name = "findTemplatecalendardateByCalDateId", query = "select myTemplatecalendardate from Templatecalendardate myTemplatecalendardate where myTemplatecalendardate.calDateId = ?1"),
		@NamedQuery(name = "findTemplatecalendardateByDailyTemplateFk", query = "select myTemplatecalendardate from Templatecalendardate myTemplatecalendardate where myTemplatecalendardate.dailyTemplateFk = ?1"),
		@NamedQuery(name = "findTemplatecalendardateByDate", query = "select myTemplatecalendardate from Templatecalendardate myTemplatecalendardate where myTemplatecalendardate.date = ?1"),
		@NamedQuery(name = "findTemplatecalendardateByDateAfter", query = "select myTemplatecalendardate from Templatecalendardate myTemplatecalendardate where myTemplatecalendardate.date > ?1"),
		@NamedQuery(name = "findTemplatecalendardateByDateBefore", query = "select myTemplatecalendardate from Templatecalendardate myTemplatecalendardate where myTemplatecalendardate.date < ?1"),
		@NamedQuery(name = "findTemplatecalendardateByPrimaryKey", query = "select myTemplatecalendardate from Templatecalendardate myTemplatecalendardate where myTemplatecalendardate.calDateId = ?1"),
		@NamedQuery(name = "findTemplatecalendardateByResourceFk", query = "select myTemplatecalendardate from Templatecalendardate myTemplatecalendardate where myTemplatecalendardate.resourceFk = ?1") })
@Table(catalog = "C324877_tsws4s", name = "TemplateCalendarDate")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wsdm7/wsdm/domain", name = "Templatecalendardate")
public class Templatecalendardate implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "calDateId", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer calDateId;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar date;
	/**
	 */

	@Column(name = "resourceFK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer resourceFk;
	/**
	 */

	@Column(name = "dailyTemplateFK")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer dailyTemplateFk;

	/**
	 */
	public void setCalDateId(Integer calDateId) {
		this.calDateId = calDateId;
	}

	/**
	 */
	public Integer getCalDateId() {
		return this.calDateId;
	}

	/**
	 */
	public void setDate(Calendar date) {
		this.date = date;
	}

	/**
	 */
	public Calendar getDate() {
		return this.date;
	}

	/**
	 */
	public void setResourceFk(Integer resourceFk) {
		this.resourceFk = resourceFk;
	}

	/**
	 */
	public Integer getResourceFk() {
		return this.resourceFk;
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
	public Templatecalendardate() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Templatecalendardate that) {
		setCalDateId(that.getCalDateId());
		setDate(that.getDate());
		setResourceFk(that.getResourceFk());
		setDailyTemplateFk(that.getDailyTemplateFk());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("calDateId=[").append(calDateId).append("] ");
		buffer.append("date=[").append(date).append("] ");
		buffer.append("resourceFk=[").append(resourceFk).append("] ");
		buffer.append("dailyTemplateFk=[").append(dailyTemplateFk).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((calDateId == null) ? 0 : calDateId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Templatecalendardate))
			return false;
		Templatecalendardate equalCheck = (Templatecalendardate) obj;
		if ((calDateId == null && equalCheck.calDateId != null) || (calDateId != null && equalCheck.calDateId == null))
			return false;
		if (calDateId != null && !calDateId.equals(equalCheck.calDateId))
			return false;
		return true;
	}
}
