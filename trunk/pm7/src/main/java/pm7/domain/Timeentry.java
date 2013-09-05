package pm7.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.math.BigDecimal;

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
		@NamedQuery(name = "findAllTimeentrys", query = "select myTimeentry from Timeentry myTimeentry"),
		@NamedQuery(name = "findTimeentryByDate", query = "select myTimeentry from Timeentry myTimeentry where myTimeentry.date = ?1"),
		@NamedQuery(name = "findTimeentryByDescription", query = "select myTimeentry from Timeentry myTimeentry where myTimeentry.description = ?1"),
		@NamedQuery(name = "findTimeentryByDescriptionContaining", query = "select myTimeentry from Timeentry myTimeentry where myTimeentry.description like ?1"),
		@NamedQuery(name = "findTimeentryByPrimaryKey", query = "select myTimeentry from Timeentry myTimeentry where myTimeentry.timeEntryId = ?1"),
		@NamedQuery(name = "findTimeentryByRateAmt", query = "select myTimeentry from Timeentry myTimeentry where myTimeentry.rateAmt = ?1"),
		@NamedQuery(name = "findTimeentryByTimeEntryId", query = "select myTimeentry from Timeentry myTimeentry where myTimeentry.timeEntryId = ?1"),
		@NamedQuery(name = "findTimeentryByTimeHrs", query = "select myTimeentry from Timeentry myTimeentry where myTimeentry.timeHrs = ?1") })
@Table(catalog = "C324877_project_mgt", name = "TimeEntry")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "pm7/pm7/domain", name = "Timeentry")
public class Timeentry implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "timeEntryId", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer timeEntryId;
	/**
	 */

	@Column(name = "timeHrs")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer timeHrs;
	/**
	 */

	@Column(name = "rateAmt", scale = 2, precision = 32)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal rateAmt;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar date;
	/**
	 */

	@Column(name = "description", length = 245)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String description;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "FK_taskId", referencedColumnName = "taskId") })
	@XmlTransient
	Task task;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "FK_personId", referencedColumnName = "personId") })
	@XmlTransient
	Person person;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "FK_accountId", referencedColumnName = "accountId") })
	@XmlTransient
	Account account;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "FK_projectId", referencedColumnName = "projectId") })
	@XmlTransient
	Project project;

	/**
	 */
	public void setTimeEntryId(Integer timeEntryId) {
		this.timeEntryId = timeEntryId;
	}

	/**
	 */
	public Integer getTimeEntryId() {
		return this.timeEntryId;
	}

	/**
	 */
	public void setTimeHrs(Integer timeHrs) {
		this.timeHrs = timeHrs;
	}

	/**
	 */
	public Integer getTimeHrs() {
		return this.timeHrs;
	}

	/**
	 */
	public void setRateAmt(BigDecimal rateAmt) {
		this.rateAmt = rateAmt;
	}

	/**
	 */
	public BigDecimal getRateAmt() {
		return this.rateAmt;
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
	public void setTask(Task task) {
		this.task = task;
	}

	/**
	 */
	public Task getTask() {
		return task;
	}

	/**
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

	/**
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	/**
	 */
	public Project getProject() {
		return project;
	}

	/**
	 */
	public Timeentry() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Timeentry that) {
		setTimeEntryId(that.getTimeEntryId());
		setTimeHrs(that.getTimeHrs());
		setRateAmt(that.getRateAmt());
		setDate(that.getDate());
		setDescription(that.getDescription());
		setTask(that.getTask());
		setPerson(that.getPerson());
		setAccount(that.getAccount());
		setProject(that.getProject());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("timeEntryId=[").append(timeEntryId).append("] ");
		buffer.append("timeHrs=[").append(timeHrs).append("] ");
		buffer.append("rateAmt=[").append(rateAmt).append("] ");
		buffer.append("date=[").append(date).append("] ");
		buffer.append("description=[").append(description).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((timeEntryId == null) ? 0 : timeEntryId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Timeentry))
			return false;
		Timeentry equalCheck = (Timeentry) obj;
		if ((timeEntryId == null && equalCheck.timeEntryId != null) || (timeEntryId != null && equalCheck.timeEntryId == null))
			return false;
		if (timeEntryId != null && !timeEntryId.equals(equalCheck.timeEntryId))
			return false;
		return true;
	}
}
