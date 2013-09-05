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
		@NamedQuery(name = "findAllRequirements", query = "select myRequirement from Requirement myRequirement"),
		@NamedQuery(name = "findRequirementByPrimaryKey", query = "select myRequirement from Requirement myRequirement where myRequirement.reqmtId = ?1"),
		@NamedQuery(name = "findRequirementByReqmtCode", query = "select myRequirement from Requirement myRequirement where myRequirement.reqmtCode = ?1"),
		@NamedQuery(name = "findRequirementByReqmtCodeContaining", query = "select myRequirement from Requirement myRequirement where myRequirement.reqmtCode like ?1"),
		@NamedQuery(name = "findRequirementByReqmtId", query = "select myRequirement from Requirement myRequirement where myRequirement.reqmtId = ?1"),
		@NamedQuery(name = "findRequirementByReqmtName", query = "select myRequirement from Requirement myRequirement where myRequirement.reqmtName = ?1"),
		@NamedQuery(name = "findRequirementByReqmtNameContaining", query = "select myRequirement from Requirement myRequirement where myRequirement.reqmtName like ?1"),
		@NamedQuery(name = "findRequirementByReqmtPriority", query = "select myRequirement from Requirement myRequirement where myRequirement.reqmtPriority = ?1"),
		@NamedQuery(name = "findRequirementByReqmtPriorityContaining", query = "select myRequirement from Requirement myRequirement where myRequirement.reqmtPriority like ?1"),
		@NamedQuery(name = "findRequirementByReqmtStoryDescription", query = "select myRequirement from Requirement myRequirement where myRequirement.reqmtStoryDescription = ?1"),
		@NamedQuery(name = "findRequirementByReqmtStoryDescriptionContaining", query = "select myRequirement from Requirement myRequirement where myRequirement.reqmtStoryDescription like ?1"),
		@NamedQuery(name = "findRequirementByStatus", query = "select myRequirement from Requirement myRequirement where myRequirement.status = ?1"),
		@NamedQuery(name = "findRequirementByStatusContaining", query = "select myRequirement from Requirement myRequirement where myRequirement.status like ?1") })
@Table(catalog = "C324877_project_mgt", name = "Requirement")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "pm7/pm7/domain", name = "Requirement")
@XmlRootElement(namespace = "pm7/pm7/domain")
public class Requirement implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "reqmtId", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer reqmtId;
	/**
	 */

	@Column(name = "status", length = 20)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String status;
	/**
	 */

	@Column(name = "reqmtPriority", length = 20)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String reqmtPriority;
	/**
	 */

	@Column(name = "reqmtCode", length = 10)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String reqmtCode;
	/**
	 */

	@Column(name = "reqmtName", length = 150)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String reqmtName;
	/**
	 */

	@Column(name = "reqmtStoryDescription", length = 240)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String reqmtStoryDescription;

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
	@JoinColumns({ @JoinColumn(name = "FK_projectId", referencedColumnName = "projectId") })
	@XmlTransient
	Project project;
	/**
	 */
	@OneToMany(mappedBy = "requirement", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Task> tasks;
	/**
	 */
	@OneToMany(mappedBy = "requirement", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Changerequest> changerequests;
	/**
	 */
	@OneToMany(mappedBy = "requirement", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Defect> defects;
	/**
	 */
	@OneToMany(mappedBy = "requirement", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Attachment> attachments;
	/**
	 */
	@OneToMany(mappedBy = "requirement", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Testcase> testcases;
	/**
	 */
	@OneToMany(mappedBy = "requirement", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Statusupdate> statusupdates;

	/**
	 */
	public void setReqmtId(Integer reqmtId) {
		this.reqmtId = reqmtId;
	}

	/**
	 */
	public Integer getReqmtId() {
		return this.reqmtId;
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
	public void setReqmtPriority(String reqmtPriority) {
		this.reqmtPriority = reqmtPriority;
	}

	/**
	 */
	public String getReqmtPriority() {
		return this.reqmtPriority;
	}

	/**
	 */
	public void setReqmtCode(String reqmtCode) {
		this.reqmtCode = reqmtCode;
	}

	/**
	 */
	public String getReqmtCode() {
		return this.reqmtCode;
	}

	/**
	 */
	public void setReqmtName(String reqmtName) {
		this.reqmtName = reqmtName;
	}

	/**
	 */
	public String getReqmtName() {
		return this.reqmtName;
	}

	/**
	 */
	public void setReqmtStoryDescription(String reqmtStoryDescription) {
		this.reqmtStoryDescription = reqmtStoryDescription;
	}

	/**
	 */
	public String getReqmtStoryDescription() {
		return this.reqmtStoryDescription;
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
	public void setChangerequests(Set<Changerequest> changerequests) {
		this.changerequests = changerequests;
	}

	/**
	 */
	public Set<Changerequest> getChangerequests() {
		if (changerequests == null) {
			changerequests = new java.util.LinkedHashSet<pm7.domain.Changerequest>();
		}
		return changerequests;
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
	public Requirement() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Requirement that) {
		setReqmtId(that.getReqmtId());
		setStatus(that.getStatus());
		setReqmtPriority(that.getReqmtPriority());
		setReqmtCode(that.getReqmtCode());
		setReqmtName(that.getReqmtName());
		setReqmtStoryDescription(that.getReqmtStoryDescription());
		setReleaseplan(that.getReleaseplan());
		setAccount(that.getAccount());
		setFeature(that.getFeature());
		setProject(that.getProject());
		setTasks(new java.util.LinkedHashSet<pm7.domain.Task>(that.getTasks()));
		setChangerequests(new java.util.LinkedHashSet<pm7.domain.Changerequest>(that.getChangerequests()));
		setDefects(new java.util.LinkedHashSet<pm7.domain.Defect>(that.getDefects()));
		setAttachments(new java.util.LinkedHashSet<pm7.domain.Attachment>(that.getAttachments()));
		setTestcases(new java.util.LinkedHashSet<pm7.domain.Testcase>(that.getTestcases()));
		setStatusupdates(new java.util.LinkedHashSet<pm7.domain.Statusupdate>(that.getStatusupdates()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("reqmtId=[").append(reqmtId).append("] ");
		buffer.append("status=[").append(status).append("] ");
		buffer.append("reqmtPriority=[").append(reqmtPriority).append("] ");
		buffer.append("reqmtCode=[").append(reqmtCode).append("] ");
		buffer.append("reqmtName=[").append(reqmtName).append("] ");
		buffer.append("reqmtStoryDescription=[").append(reqmtStoryDescription).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((reqmtId == null) ? 0 : reqmtId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Requirement))
			return false;
		Requirement equalCheck = (Requirement) obj;
		if ((reqmtId == null && equalCheck.reqmtId != null) || (reqmtId != null && equalCheck.reqmtId == null))
			return false;
		if (reqmtId != null && !reqmtId.equals(equalCheck.reqmtId))
			return false;
		return true;
	}
}
