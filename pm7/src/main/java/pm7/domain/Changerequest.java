package pm7.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

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
		@NamedQuery(name = "findAllChangerequests", query = "select myChangerequest from Changerequest myChangerequest"),
		@NamedQuery(name = "findChangerequestByChangeCode", query = "select myChangerequest from Changerequest myChangerequest where myChangerequest.changeCode = ?1"),
		@NamedQuery(name = "findChangerequestByChangeCodeContaining", query = "select myChangerequest from Changerequest myChangerequest where myChangerequest.changeCode like ?1"),
		@NamedQuery(name = "findChangerequestByChangeDescription", query = "select myChangerequest from Changerequest myChangerequest where myChangerequest.changeDescription = ?1"),
		@NamedQuery(name = "findChangerequestByChangeDescriptionContaining", query = "select myChangerequest from Changerequest myChangerequest where myChangerequest.changeDescription like ?1"),
		@NamedQuery(name = "findChangerequestByChangeId", query = "select myChangerequest from Changerequest myChangerequest where myChangerequest.changeId = ?1"),
		@NamedQuery(name = "findChangerequestByChangeName", query = "select myChangerequest from Changerequest myChangerequest where myChangerequest.changeName = ?1"),
		@NamedQuery(name = "findChangerequestByChangeNameContaining", query = "select myChangerequest from Changerequest myChangerequest where myChangerequest.changeName like ?1"),
		@NamedQuery(name = "findChangerequestByChangePriority", query = "select myChangerequest from Changerequest myChangerequest where myChangerequest.changePriority = ?1"),
		@NamedQuery(name = "findChangerequestByChangePriorityContaining", query = "select myChangerequest from Changerequest myChangerequest where myChangerequest.changePriority like ?1"),
		@NamedQuery(name = "findChangerequestByPrimaryKey", query = "select myChangerequest from Changerequest myChangerequest where myChangerequest.changeId = ?1"),
		@NamedQuery(name = "findChangerequestByStatus", query = "select myChangerequest from Changerequest myChangerequest where myChangerequest.status = ?1"),
		@NamedQuery(name = "findChangerequestByStatusContaining", query = "select myChangerequest from Changerequest myChangerequest where myChangerequest.status like ?1") })
@Table(catalog = "C324877_project_mgt", name = "ChangeRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "pm7/pm7/domain", name = "Changerequest")
@XmlRootElement(namespace = "pm7/pm7/domain")
public class Changerequest implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "changeId", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer changeId;
	/**
	 */

	@Column(name = "status", length = 20)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String status;
	/**
	 */

	@Column(name = "changePriority", length = 20)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String changePriority;
	/**
	 */

	@Column(name = "changeCode", length = 10)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String changeCode;
	/**
	 */

	@Column(name = "changeName", length = 150)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String changeName;
	/**
	 */

	@Column(name = "changeDescription", length = 240)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String changeDescription;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "FK_releaseId", referencedColumnName = "releaseId") })
	@XmlTransient
	Releaseplan releaseplan;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "FK_accountId", referencedColumnName = "accountId") })
	@XmlTransient
	Account account;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "FK_featureId", referencedColumnName = "featureId") })
	@XmlTransient
	Feature feature;
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
	@OneToMany(mappedBy = "changerequest", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Testcase> testcases;
	/**
	 */
	@OneToMany(mappedBy = "changerequest", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Defect> defects;
	/**
	 */
	@OneToMany(mappedBy = "changerequest", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Task> tasks;
	/**
	 */
	@OneToMany(mappedBy = "changerequest", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Attachment> attachments;

	/**
	 */
	public void setChangeId(Integer changeId) {
		this.changeId = changeId;
	}

	/**
	 */
	public Integer getChangeId() {
		return this.changeId;
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
	public void setChangePriority(String changePriority) {
		this.changePriority = changePriority;
	}

	/**
	 */
	public String getChangePriority() {
		return this.changePriority;
	}

	/**
	 */
	public void setChangeCode(String changeCode) {
		this.changeCode = changeCode;
	}

	/**
	 */
	public String getChangeCode() {
		return this.changeCode;
	}

	/**
	 */
	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	/**
	 */
	public String getChangeName() {
		return this.changeName;
	}

	/**
	 */
	public void setChangeDescription(String changeDescription) {
		this.changeDescription = changeDescription;
	}

	/**
	 */
	public String getChangeDescription() {
		return this.changeDescription;
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
	public void setFeature(Feature feature) {
		this.feature = feature;
	}

	/**
	 */
	public Feature getFeature() {
		return feature;
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
	public void setTestcases(Set<Testcase> testcases) {
		this.testcases = testcases;
	}

	/**
	 */
	public Set<Testcase> getTestcases() {
		if (testcases == null) {
			testcases = new java.util.LinkedHashSet<pm7.domain.Testcase>();
		}
		return testcases;
	}

	/**
	 */
	public void setDefects(Set<Defect> defects) {
		this.defects = defects;
	}

	/**
	 */
	public Set<Defect> getDefects() {
		if (defects == null) {
			defects = new java.util.LinkedHashSet<pm7.domain.Defect>();
		}
		return defects;
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
	public Changerequest() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Changerequest that) {
		setChangeId(that.getChangeId());
		setStatus(that.getStatus());
		setChangePriority(that.getChangePriority());
		setChangeCode(that.getChangeCode());
		setChangeName(that.getChangeName());
		setChangeDescription(that.getChangeDescription());
		setReleaseplan(that.getReleaseplan());
		setAccount(that.getAccount());
		setFeature(that.getFeature());
		setRequirement(that.getRequirement());
		setProject(that.getProject());
		setTestcases(new java.util.LinkedHashSet<pm7.domain.Testcase>(that.getTestcases()));
		setDefects(new java.util.LinkedHashSet<pm7.domain.Defect>(that.getDefects()));
		setTasks(new java.util.LinkedHashSet<pm7.domain.Task>(that.getTasks()));
		setAttachments(new java.util.LinkedHashSet<pm7.domain.Attachment>(that.getAttachments()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("changeId=[").append(changeId).append("] ");
		buffer.append("status=[").append(status).append("] ");
		buffer.append("changePriority=[").append(changePriority).append("] ");
		buffer.append("changeCode=[").append(changeCode).append("] ");
		buffer.append("changeName=[").append(changeName).append("] ");
		buffer.append("changeDescription=[").append(changeDescription).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((changeId == null) ? 0 : changeId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Changerequest))
			return false;
		Changerequest equalCheck = (Changerequest) obj;
		if ((changeId == null && equalCheck.changeId != null) || (changeId != null && equalCheck.changeId == null))
			return false;
		if (changeId != null && !changeId.equals(equalCheck.changeId))
			return false;
		return true;
	}
}
