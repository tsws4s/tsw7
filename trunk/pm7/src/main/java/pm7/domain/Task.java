package pm7.domain;

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
		@NamedQuery(name = "findAllTasks", query = "select myTask from Task myTask"),
		@NamedQuery(name = "findTaskByActualHrs", query = "select myTask from Task myTask where myTask.actualHrs = ?1"),
		@NamedQuery(name = "findTaskByCompleteDate", query = "select myTask from Task myTask where myTask.completeDate = ?1"),
		@NamedQuery(name = "findTaskByCompleteDateAfter", query = "select myTask from Task myTask where myTask.completeDate > ?1"),
		@NamedQuery(name = "findTaskByCompleteDateBefore", query = "select myTask from Task myTask where myTask.completeDate < ?1"),
		@NamedQuery(name = "findTaskByEstimateHrs", query = "select myTask from Task myTask where myTask.estimateHrs = ?1"),
		@NamedQuery(name = "findTaskByPercentComplete", query = "select myTask from Task myTask where myTask.percentComplete = ?1"),
		@NamedQuery(name = "findTaskByPrimaryKey", query = "select myTask from Task myTask where myTask.taskId = ?1"),
		@NamedQuery(name = "findTaskByStartDate", query = "select myTask from Task myTask where myTask.startDate = ?1"),
		@NamedQuery(name = "findTaskByStatus", query = "select myTask from Task myTask where myTask.status = ?1"),
		@NamedQuery(name = "findTaskByStatusContaining", query = "select myTask from Task myTask where myTask.status like ?1"),
		@NamedQuery(name = "findTaskByTargetDate", query = "select myTask from Task myTask where myTask.targetDate = ?1"),
		@NamedQuery(name = "findTaskByTargetDateAfter", query = "select myTask from Task myTask where myTask.targetDate > ?1"),
		@NamedQuery(name = "findTaskByTargetDateBefore", query = "select myTask from Task myTask where myTask.targetDate < ?1"),
		@NamedQuery(name = "findTaskByTaskDescription", query = "select myTask from Task myTask where myTask.taskDescription = ?1"),
		@NamedQuery(name = "findTaskByTaskDescriptionContaining", query = "select myTask from Task myTask where myTask.taskDescription like ?1"),
		@NamedQuery(name = "findTaskByTaskId", query = "select myTask from Task myTask where myTask.taskId = ?1"),
		@NamedQuery(name = "findTaskByTaskName", query = "select myTask from Task myTask where myTask.taskName = ?1"),
		@NamedQuery(name = "findTaskByTaskNameContaining", query = "select myTask from Task myTask where myTask.taskName like ?1"),
		@NamedQuery(name = "findTaskByTaskType", query = "select myTask from Task myTask where myTask.taskType = ?1"),
		@NamedQuery(name = "findTaskByTaskTypeContaining", query = "select myTask from Task myTask where myTask.taskType like ?1") })
@Table(catalog = "C324877_project_mgt", name = "Task")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "pm7/pm7/domain", name = "Task")
@XmlRootElement(namespace = "pm7/pm7/domain")
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "taskId", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer taskId;
	/**
	 */

	@Column(name = "status", length = 20)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String status;
	/**
	 */

	@Column(name = "taskName", length = 150)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String taskName;
	/**
	 */

	@Column(name = "taskDescription", length = 240)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String taskDescription;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "startDate")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar startDate;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "targetDate")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar targetDate;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "completeDate")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar completeDate;
	/**
	 */

	@Column(name = "percentComplete")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer percentComplete;
	/**
	 */

	@Column(name = "estimateHrs")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer estimateHrs;
	/**
	 */

	@Column(name = "actualHrs")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer actualHrs;
	/**
	 */

	@Column(name = "taskType", length = 45)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String taskType;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "FK_testId", referencedColumnName = "testId") })
	@XmlTransient
	Testcase testcase;
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
	@JoinColumns({ @JoinColumn(name = "FK_changeId", referencedColumnName = "changeId") })
	@XmlTransient
	Changerequest changerequest;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "FK_defectId", referencedColumnName = "defectId") })
	@XmlTransient
	Defect defect;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "FK_reqmtId", referencedColumnName = "reqmtId") })
	@XmlTransient
	Requirement requirement;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "FK_projectId", referencedColumnName = "projectId") })
	@XmlTransient
	Project project;
	/**
	 */
	@OneToMany(mappedBy = "task", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Timeentry> timeentries;
	/**
	 */
	@OneToMany(mappedBy = "task", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Statusupdate> statusupdates;

	/**
	 */
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	/**
	 */
	public Integer getTaskId() {
		return this.taskId;
	}

	/**
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 */
	public String getTaskName() {
		return this.taskName;
	}

	/**
	 */
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	/**
	 */
	public String getTaskDescription() {
		return this.taskDescription;
	}

	/**
	 */
	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	/**
	 */
	public Calendar getStartDate() {
		return this.startDate;
	}

	/**
	 */
	public void setTargetDate(Calendar targetDate) {
		this.targetDate = targetDate;
	}

	/**
	 */
	public Calendar getTargetDate() {
		return this.targetDate;
	}

	/**
	 */
	public void setCompleteDate(Calendar completeDate) {
		this.completeDate = completeDate;
	}

	/**
	 */
	public Calendar getCompleteDate() {
		return this.completeDate;
	}

	/**
	 */
	public void setPercentComplete(Integer percentComplete) {
		this.percentComplete = percentComplete;
	}

	/**
	 */
	public Integer getPercentComplete() {
		return this.percentComplete;
	}

	/**
	 */
	public void setEstimateHrs(Integer estimateHrs) {
		this.estimateHrs = estimateHrs;
	}

	/**
	 */
	public Integer getEstimateHrs() {
		return this.estimateHrs;
	}

	/**
	 */
	public void setActualHrs(Integer actualHrs) {
		this.actualHrs = actualHrs;
	}

	/**
	 */
	public Integer getActualHrs() {
		return this.actualHrs;
	}

	/**
	 */
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	/**
	 */
	public String getTaskType() {
		return this.taskType;
	}

	/**
	 */
	public void setTestcase(Testcase testcase) {
		this.testcase = testcase;
	}

	/**
	 */
	public Testcase getTestcase() {
		return testcase;
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
	public void setChangerequest(Changerequest changerequest) {
		this.changerequest = changerequest;
	}

	/**
	 */
	public Changerequest getChangerequest() {
		return changerequest;
	}

	/**
	 */
	public void setDefect(Defect defect) {
		this.defect = defect;
	}

	/**
	 */
	public Defect getDefect() {
		return defect;
	}

	/**
	 */
	public void setRequirement(Requirement requirement) {
		this.requirement = requirement;
	}

	/**
	 */
	public Requirement getRequirement() {
		return requirement;
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
	public void setTimeentries(Set<Timeentry> timeentries) {
		this.timeentries = timeentries;
	}

	/**
	 */
	public Set<Timeentry> getTimeentries() {
		if (timeentries == null) {
			timeentries = new java.util.LinkedHashSet<pm7.domain.Timeentry>();
		}
		return timeentries;
	}

	/**
	 */
	public void setStatusupdates(Set<Statusupdate> statusupdates) {
		this.statusupdates = statusupdates;
	}

	/**
	 */
	public Set<Statusupdate> getStatusupdates() {
		if (statusupdates == null) {
			statusupdates = new java.util.LinkedHashSet<pm7.domain.Statusupdate>();
		}
		return statusupdates;
	}

	/**
	 */
	public Task() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Task that) {
		setTaskId(that.getTaskId());
		setStatus(that.getStatus());
		setTaskName(that.getTaskName());
		setTaskDescription(that.getTaskDescription());
		setStartDate(that.getStartDate());
		setTargetDate(that.getTargetDate());
		setCompleteDate(that.getCompleteDate());
		setPercentComplete(that.getPercentComplete());
		setEstimateHrs(that.getEstimateHrs());
		setActualHrs(that.getActualHrs());
		setTaskType(that.getTaskType());
		setTestcase(that.getTestcase());
		setPerson(that.getPerson());
		setAccount(that.getAccount());
		setChangerequest(that.getChangerequest());
		setDefect(that.getDefect());
		setRequirement(that.getRequirement());
		setProject(that.getProject());
		setTimeentries(new java.util.LinkedHashSet<pm7.domain.Timeentry>(that.getTimeentries()));
		setStatusupdates(new java.util.LinkedHashSet<pm7.domain.Statusupdate>(that.getStatusupdates()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("taskId=[").append(taskId).append("] ");
		buffer.append("status=[").append(status).append("] ");
		buffer.append("taskName=[").append(taskName).append("] ");
		buffer.append("taskDescription=[").append(taskDescription).append("] ");
		buffer.append("startDate=[").append(startDate).append("] ");
		buffer.append("targetDate=[").append(targetDate).append("] ");
		buffer.append("completeDate=[").append(completeDate).append("] ");
		buffer.append("percentComplete=[").append(percentComplete).append("] ");
		buffer.append("estimateHrs=[").append(estimateHrs).append("] ");
		buffer.append("actualHrs=[").append(actualHrs).append("] ");
		buffer.append("taskType=[").append(taskType).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((taskId == null) ? 0 : taskId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Task))
			return false;
		Task equalCheck = (Task) obj;
		if ((taskId == null && equalCheck.taskId != null) || (taskId != null && equalCheck.taskId == null))
			return false;
		if (taskId != null && !taskId.equals(equalCheck.taskId))
			return false;
		return true;
	}
}
