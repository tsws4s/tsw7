package pm7.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

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
		@NamedQuery(name = "findAllDefects", query = "select myDefect from Defect myDefect"),
		@NamedQuery(name = "findDefectByDefectDescriptin", query = "select myDefect from Defect myDefect where myDefect.defectDescriptin = ?1"),
		@NamedQuery(name = "findDefectByDefectDescriptinContaining", query = "select myDefect from Defect myDefect where myDefect.defectDescriptin like ?1"),
		@NamedQuery(name = "findDefectByDefectId", query = "select myDefect from Defect myDefect where myDefect.defectId = ?1"),
		@NamedQuery(name = "findDefectByDefectName", query = "select myDefect from Defect myDefect where myDefect.defectName = ?1"),
		@NamedQuery(name = "findDefectByDefectNameContaining", query = "select myDefect from Defect myDefect where myDefect.defectName like ?1"),
		@NamedQuery(name = "findDefectByDefectPriority", query = "select myDefect from Defect myDefect where myDefect.defectPriority = ?1"),
		@NamedQuery(name = "findDefectByDefectPriorityContaining", query = "select myDefect from Defect myDefect where myDefect.defectPriority like ?1"),
		@NamedQuery(name = "findDefectByPrimaryKey", query = "select myDefect from Defect myDefect where myDefect.defectId = ?1"),
		@NamedQuery(name = "findDefectByStatus", query = "select myDefect from Defect myDefect where myDefect.status = ?1"),
		@NamedQuery(name = "findDefectByStatusContaining", query = "select myDefect from Defect myDefect where myDefect.status like ?1") })
@Table(catalog = "C324877_project_mgt", name = "Defect")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "pm7/pm7/domain", name = "Defect")
@XmlRootElement(namespace = "pm7/pm7/domain")
public class Defect implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "defectId", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer defectId;
	/**
	 */

	@Column(name = "status", length = 20)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String status;
	/**
	 */

	@Column(name = "defectPriority", length = 20)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String defectPriority;
	/**
	 */

	@Column(name = "defectName", length = 150)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String defectName;
	/**
	 */

	@Column(name = "defectDescriptin", length = 240)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String defectDescriptin;

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
	@OneToMany(mappedBy = "defect", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Attachment> attachments;
	/**
	 */
	@OneToMany(mappedBy = "defect", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Statusupdate> statusupdates;
	/**
	 */
	@OneToMany(mappedBy = "defect", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Task> tasks;

	/**
	 */
	public void setDefectId(Integer defectId) {
		this.defectId = defectId;
	}

	/**
	 */
	public Integer getDefectId() {
		return this.defectId;
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
	public void setDefectPriority(String defectPriority) {
		this.defectPriority = defectPriority;
	}

	/**
	 */
	public String getDefectPriority() {
		return this.defectPriority;
	}

	/**
	 */
	public void setDefectName(String defectName) {
		this.defectName = defectName;
	}

	/**
	 */
	public String getDefectName() {
		return this.defectName;
	}

	/**
	 */
	public void setDefectDescriptin(String defectDescriptin) {
		this.defectDescriptin = defectDescriptin;
	}

	/**
	 */
	public String getDefectDescriptin() {
		return this.defectDescriptin;
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
	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	/**
	 */
	public Set<Task> getTasks() {
		if (tasks == null) {
			tasks = new java.util.LinkedHashSet<pm7.domain.Task>();
		}
		return tasks;
	}

	/**
	 */
	public Defect() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Defect that) {
		setDefectId(that.getDefectId());
		setStatus(that.getStatus());
		setDefectPriority(that.getDefectPriority());
		setDefectName(that.getDefectName());
		setDefectDescriptin(that.getDefectDescriptin());
		setReleaseplan(that.getReleaseplan());
		setTestcase(that.getTestcase());
		setAccount(that.getAccount());
		setChangerequest(that.getChangerequest());
		setRequirement(that.getRequirement());
		setProject(that.getProject());
		setAttachments(new java.util.LinkedHashSet<pm7.domain.Attachment>(that.getAttachments()));
		setStatusupdates(new java.util.LinkedHashSet<pm7.domain.Statusupdate>(that.getStatusupdates()));
		setTasks(new java.util.LinkedHashSet<pm7.domain.Task>(that.getTasks()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("defectId=[").append(defectId).append("] ");
		buffer.append("status=[").append(status).append("] ");
		buffer.append("defectPriority=[").append(defectPriority).append("] ");
		buffer.append("defectName=[").append(defectName).append("] ");
		buffer.append("defectDescriptin=[").append(defectDescriptin).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((defectId == null) ? 0 : defectId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Defect))
			return false;
		Defect equalCheck = (Defect) obj;
		if ((defectId == null && equalCheck.defectId != null) || (defectId != null && equalCheck.defectId == null))
			return false;
		if (defectId != null && !defectId.equals(equalCheck.defectId))
			return false;
		return true;
	}
}
