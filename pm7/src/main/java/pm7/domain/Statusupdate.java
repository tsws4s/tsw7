package pm7.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.Calendar;
import java.util.LinkedHashSet;
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
		@NamedQuery(name = "findAllStatusupdates", query = "select myStatusupdate from Statusupdate myStatusupdate"),
		@NamedQuery(name = "findStatusupdateByEstHrsLeft", query = "select myStatusupdate from Statusupdate myStatusupdate where myStatusupdate.estHrsLeft = ?1"),
		@NamedQuery(name = "findStatusupdateByPrimaryKey", query = "select myStatusupdate from Statusupdate myStatusupdate where myStatusupdate.statusId = ?1"),
		@NamedQuery(name = "findStatusupdateByRiskGyr", query = "select myStatusupdate from Statusupdate myStatusupdate where myStatusupdate.riskGyr = ?1"),
		@NamedQuery(name = "findStatusupdateByRiskGyrContaining", query = "select myStatusupdate from Statusupdate myStatusupdate where myStatusupdate.riskGyr like ?1"),
		@NamedQuery(name = "findStatusupdateByStatusDate", query = "select myStatusupdate from Statusupdate myStatusupdate where myStatusupdate.statusDate = ?1"),
		@NamedQuery(name = "findStatusupdateByStatusDateAfter", query = "select myStatusupdate from Statusupdate myStatusupdate where myStatusupdate.statusDate > ?1"),
		@NamedQuery(name = "findStatusupdateByStatusDateBefore", query = "select myStatusupdate from Statusupdate myStatusupdate where myStatusupdate.statusDate < ?1"),
		@NamedQuery(name = "findStatusupdateByStatusId", query = "select myStatusupdate from Statusupdate myStatusupdate where myStatusupdate.statusId = ?1"),
		@NamedQuery(name = "findStatusupdateByStatusUpdateDesc", query = "select myStatusupdate from Statusupdate myStatusupdate where myStatusupdate.statusUpdateDesc = ?1"),
		@NamedQuery(name = "findStatusupdateByStatusUpdateDescContaining", query = "select myStatusupdate from Statusupdate myStatusupdate where myStatusupdate.statusUpdateDesc like ?1") })
@Table(catalog = "C324877_project_mgt", name = "StatusUpdate")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "pm7/pm7/domain", name = "Statusupdate")
@XmlRootElement(namespace = "pm7/pm7/domain")
public class Statusupdate implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "statusId", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer statusId;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "statusDate")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar statusDate;
	/**
	 */

	@Column(name = "statusUpdateDesc", length = 240)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String statusUpdateDesc;
	/**
	 */

	@Column(name = "estHrsLeft")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer estHrsLeft;
	/**
	 */

	@Column(name = "riskGYR", length = 20)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String riskGyr;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "FK_taskId", referencedColumnName = "taskId") })
	@XmlTransient
	Task task;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "FK_releaseId", referencedColumnName = "releaseId") })
	@XmlTransient
	Releaseplan releaseplan;
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
	@OneToMany(mappedBy = "statusupdate", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Attachment> attachments;

	/**
	 */
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	/**
	 */
	public Integer getStatusId() {
		return this.statusId;
	}

	/**
	 */
	public void setStatusDate(Calendar statusDate) {
		this.statusDate = statusDate;
	}

	/**
	 */
	public Calendar getStatusDate() {
		return this.statusDate;
	}

	/**
	 */
	public void setStatusUpdateDesc(String statusUpdateDesc) {
		this.statusUpdateDesc = statusUpdateDesc;
	}

	/**
	 */
	public String getStatusUpdateDesc() {
		return this.statusUpdateDesc;
	}

	/**
	 */
	public void setEstHrsLeft(Integer estHrsLeft) {
		this.estHrsLeft = estHrsLeft;
	}

	/**
	 */
	public Integer getEstHrsLeft() {
		return this.estHrsLeft;
	}

	/**
	 */
	public void setRiskGyr(String riskGyr) {
		this.riskGyr = riskGyr;
	}

	/**
	 */
	public String getRiskGyr() {
		return this.riskGyr;
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
	public void setReleaseplan(Releaseplan releaseplan) {
		this.releaseplan = releaseplan;
	}

	/**
	 */
	public Releaseplan getReleaseplan() {
		return releaseplan;
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
	public void setAttachments(Set<Attachment> attachments) {
		this.attachments = attachments;
	}

	/**
	 */
	public Set<Attachment> getAttachments() {
		if (attachments == null) {
			attachments = new java.util.LinkedHashSet<pm7.domain.Attachment>();
		}
		return attachments;
	}

	/**
	 */
	public Statusupdate() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Statusupdate that) {
		setStatusId(that.getStatusId());
		setStatusDate(that.getStatusDate());
		setStatusUpdateDesc(that.getStatusUpdateDesc());
		setEstHrsLeft(that.getEstHrsLeft());
		setRiskGyr(that.getRiskGyr());
		setTask(that.getTask());
		setReleaseplan(that.getReleaseplan());
		setTestcase(that.getTestcase());
		setPerson(that.getPerson());
		setAccount(that.getAccount());
		setDefect(that.getDefect());
		setRequirement(that.getRequirement());
		setProject(that.getProject());
		setAttachments(new java.util.LinkedHashSet<pm7.domain.Attachment>(that.getAttachments()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("statusId=[").append(statusId).append("] ");
		buffer.append("statusDate=[").append(statusDate).append("] ");
		buffer.append("statusUpdateDesc=[").append(statusUpdateDesc).append("] ");
		buffer.append("estHrsLeft=[").append(estHrsLeft).append("] ");
		buffer.append("riskGyr=[").append(riskGyr).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((statusId == null) ? 0 : statusId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Statusupdate))
			return false;
		Statusupdate equalCheck = (Statusupdate) obj;
		if ((statusId == null && equalCheck.statusId != null) || (statusId != null && equalCheck.statusId == null))
			return false;
		if (statusId != null && !statusId.equals(equalCheck.statusId))
			return false;
		return true;
	}
}
