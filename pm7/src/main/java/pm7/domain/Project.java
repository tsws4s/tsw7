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
		@NamedQuery(name = "findAllProjects", query = "select myProject from Project myProject"),
		@NamedQuery(name = "findProjectByActiveYn", query = "select myProject from Project myProject where myProject.activeYn = ?1"),
		@NamedQuery(name = "findProjectByActualHrs", query = "select myProject from Project myProject where myProject.actualHrs = ?1"),
		@NamedQuery(name = "findProjectByCompleteDate", query = "select myProject from Project myProject where myProject.completeDate = ?1"),
		@NamedQuery(name = "findProjectByDueDate", query = "select myProject from Project myProject where myProject.dueDate = ?1"),
		@NamedQuery(name = "findProjectByEstimateHrs", query = "select myProject from Project myProject where myProject.estimateHrs = ?1"),
		@NamedQuery(name = "findProjectByHrRate", query = "select myProject from Project myProject where myProject.hrRate = ?1"),
		@NamedQuery(name = "findProjectByPrimaryKey", query = "select myProject from Project myProject where myProject.projectId = ?1"),
		@NamedQuery(name = "findProjectByProjectDesc", query = "select myProject from Project myProject where myProject.projectDesc = ?1"),
		@NamedQuery(name = "findProjectByProjectDescContaining", query = "select myProject from Project myProject where myProject.projectDesc like ?1"),
		@NamedQuery(name = "findProjectByProjectId", query = "select myProject from Project myProject where myProject.projectId = ?1"),
		@NamedQuery(name = "findProjectByProjectName", query = "select myProject from Project myProject where myProject.projectName = ?1"),
		@NamedQuery(name = "findProjectByProjectNameContaining", query = "select myProject from Project myProject where myProject.projectName like ?1"),
		@NamedQuery(name = "findProjectByProjectType", query = "select myProject from Project myProject where myProject.projectType = ?1"),
		@NamedQuery(name = "findProjectByProjectTypeContaining", query = "select myProject from Project myProject where myProject.projectType like ?1"),
		@NamedQuery(name = "findProjectByStartDate", query = "select myProject from Project myProject where myProject.startDate = ?1") })
@Table(catalog = "C324877_project_mgt", name = "Project")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "pm7/pm7/domain", name = "Project")
@XmlRootElement(namespace = "pm7/pm7/domain")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "projectId", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer projectId;
	/**
	 */

	@Column(name = "projectName", length = 45)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String projectName;
	/**
	 */

	@Column(name = "projectDesc", length = 245)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String projectDesc;
	/**
	 */

	@Column(name = "projectType", length = 45)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String projectType;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "startDate")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar startDate;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dueDate")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar dueDate;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "completeDate")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar completeDate;
	/**
	 */

	@Column(name = "estimateHrs")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer estimateHrs;
	
	@Column(name = "percentComplete")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer percentComplete;

	/**
	 */

	@Column(name = "actualHrs")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer actualHrs;
	/**
	 */

	@Column(name = "hrRate", scale = 2, precision = 32)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal hrRate;
	/**
	 */

	@Column(name = "activeYN")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer activeYn;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "FK_contactPersonId", referencedColumnName = "personId") })
	@XmlTransient
	Person personByFkContactPersonId;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "FK_accountId", referencedColumnName = "accountId") })
	@XmlTransient
	Account account;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "FK_clientId", referencedColumnName = "clientId") })
	@XmlTransient
	Client client;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "FK_projMgrId", referencedColumnName = "personId") })
	@XmlTransient
	Person personByFkProjMgrId;
	/**
	 */
	@OneToMany(mappedBy = "project", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Timeentry> timeentries;
	/**
	 */
	@OneToMany(mappedBy = "project", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Testcasestep> testcasesteps;
	/**
	 */
	@OneToMany(mappedBy = "project", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Attachment> attachments;
	/**
	 */
	@OneToMany(mappedBy = "project", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Projectteam> projectteams;
	/**
	 */
	@OneToMany(mappedBy = "project", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Projecttemplate> projecttemplates;
	/**
	 */
	@OneToMany(mappedBy = "project", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Requirement> requirements;
	/**
	 */
	@OneToMany(mappedBy = "project", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Releaseplan> releaseplans;
	/**
	 */
	@OneToMany(mappedBy = "project", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Invoiceitem> invoiceitems;
	/**
	 */
	@OneToMany(mappedBy = "project", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Statusupdate> statusupdates;
	/**
	 */
	@OneToMany(mappedBy = "project", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Testcase> testcases;
	/**
	 */
	@OneToMany(mappedBy = "project", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Invoice> invoices;
	/**
	 */
	@OneToMany(mappedBy = "project", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Feature> features;
	/**
	 */
	@OneToMany(mappedBy = "project", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Defect> defects;
	/**
	 */
	@OneToMany(mappedBy = "project", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Task> tasks;
	/**
	 */
	@OneToMany(mappedBy = "project", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Changerequest> changerequests;

	/**
	 */
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	/**
	 */
	public Integer getProjectId() {
		return this.projectId;
	}

	/**
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 */
	public String getProjectName() {
		return this.projectName;
	}

	/**
	 */
	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	/**
	 */
	public String getProjectDesc() {
		return this.projectDesc;
	}

	/**
	 */
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	/**
	 */
	public String getProjectType() {
		return this.projectType;
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
	public void setDueDate(Calendar dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 */
	public Calendar getDueDate() {
		return this.dueDate;
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
	
	public Integer getPercentComplete() {
		return percentComplete;
	}

	public void setPercentComplete(Integer percentComplete) {
		this.percentComplete = percentComplete;
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
	public void setHrRate(BigDecimal hrRate) {
		this.hrRate = hrRate;
	}

	/**
	 */
	public BigDecimal getHrRate() {
		return this.hrRate;
	}

	/**
	 */
	public void setActiveYn(Integer activeYn) {
		this.activeYn = activeYn;
	}

	/**
	 */
	public Integer getActiveYn() {
		return this.activeYn;
	}

	/**
	 */
	public void setPersonByFkContactPersonId(Person personByFkContactPersonId) {
		this.personByFkContactPersonId = personByFkContactPersonId;
	}

	/**
	 */
	public Person getPersonByFkContactPersonId() {
		return personByFkContactPersonId;
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
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 */
	public Client getClient() {
		return client;
	}

	/**
	 */
	public void setPersonByFkProjMgrId(Person personByFkProjMgrId) {
		this.personByFkProjMgrId = personByFkProjMgrId;
	}

	/**
	 */
	public Person getPersonByFkProjMgrId() {
		return personByFkProjMgrId;
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
	public void setTestcasesteps(Set<Testcasestep> testcasesteps) {
		this.testcasesteps = testcasesteps;
	}

	/**
	 */
	public Set<Testcasestep> getTestcasesteps() {
		if (testcasesteps == null) {
			testcasesteps = new java.util.LinkedHashSet<pm7.domain.Testcasestep>();
		}
		return testcasesteps;
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
	public void setProjectteams(Set<Projectteam> projectteams) {
		this.projectteams = projectteams;
	}

	/**
	 */
	public Set<Projectteam> getProjectteams() {
		if (projectteams == null) {
			projectteams = new java.util.LinkedHashSet<pm7.domain.Projectteam>();
		}
		return projectteams;
	}

	/**
	 */
	public void setProjecttemplates(Set<Projecttemplate> projecttemplates) {
		this.projecttemplates = projecttemplates;
	}

	/**
	 */
	public Set<Projecttemplate> getProjecttemplates() {
		if (projecttemplates == null) {
			projecttemplates = new java.util.LinkedHashSet<pm7.domain.Projecttemplate>();
		}
		return projecttemplates;
	}

	/**
	 */
	public void setRequirements(Set<Requirement> requirements) {
		this.requirements = requirements;
	}

	/**
	 */
	public Set<Requirement> getRequirements() {
		if (requirements == null) {
			requirements = new java.util.LinkedHashSet<pm7.domain.Requirement>();
		}
		return requirements;
	}

	/**
	 */
	public void setReleaseplans(Set<Releaseplan> releaseplans) {
		this.releaseplans = releaseplans;
	}

	/**
	 */
	public Set<Releaseplan> getReleaseplans() {
		if (releaseplans == null) {
			releaseplans = new java.util.LinkedHashSet<pm7.domain.Releaseplan>();
		}
		return releaseplans;
	}

	/**
	 */
	public void setInvoiceitems(Set<Invoiceitem> invoiceitems) {
		this.invoiceitems = invoiceitems;
	}

	/**
	 */
	public Set<Invoiceitem> getInvoiceitems() {
		if (invoiceitems == null) {
			invoiceitems = new java.util.LinkedHashSet<pm7.domain.Invoiceitem>();
		}
		return invoiceitems;
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
	public void setInvoices(Set<Invoice> invoices) {
		this.invoices = invoices;
	}

	/**
	 */
	public Set<Invoice> getInvoices() {
		if (invoices == null) {
			invoices = new java.util.LinkedHashSet<pm7.domain.Invoice>();
		}
		return invoices;
	}

	/**
	 */
	public void setFeatures(Set<Feature> features) {
		this.features = features;
	}

	/**
	 */
	public Set<Feature> getFeatures() {
		if (features == null) {
			features = new java.util.LinkedHashSet<pm7.domain.Feature>();
		}
		return features;
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
	public Project() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Project that) {
		setProjectId(that.getProjectId());
		setProjectName(that.getProjectName());
		setProjectDesc(that.getProjectDesc());
		setProjectType(that.getProjectType());
		setStartDate(that.getStartDate());
		setDueDate(that.getDueDate());
		setCompleteDate(that.getCompleteDate());
		setEstimateHrs(that.getEstimateHrs());
		setActualHrs(that.getActualHrs());
		setHrRate(that.getHrRate());
		setActiveYn(that.getActiveYn());
		setPersonByFkContactPersonId(that.getPersonByFkContactPersonId());
		setAccount(that.getAccount());
		setClient(that.getClient());
		setPersonByFkProjMgrId(that.getPersonByFkProjMgrId());
		setTimeentries(new java.util.LinkedHashSet<pm7.domain.Timeentry>(that.getTimeentries()));
		setTestcasesteps(new java.util.LinkedHashSet<pm7.domain.Testcasestep>(that.getTestcasesteps()));
		setAttachments(new java.util.LinkedHashSet<pm7.domain.Attachment>(that.getAttachments()));
		setProjectteams(new java.util.LinkedHashSet<pm7.domain.Projectteam>(that.getProjectteams()));
		setProjecttemplates(new java.util.LinkedHashSet<pm7.domain.Projecttemplate>(that.getProjecttemplates()));
		setRequirements(new java.util.LinkedHashSet<pm7.domain.Requirement>(that.getRequirements()));
		setReleaseplans(new java.util.LinkedHashSet<pm7.domain.Releaseplan>(that.getReleaseplans()));
		setInvoiceitems(new java.util.LinkedHashSet<pm7.domain.Invoiceitem>(that.getInvoiceitems()));
		setStatusupdates(new java.util.LinkedHashSet<pm7.domain.Statusupdate>(that.getStatusupdates()));
		setTestcases(new java.util.LinkedHashSet<pm7.domain.Testcase>(that.getTestcases()));
		setInvoices(new java.util.LinkedHashSet<pm7.domain.Invoice>(that.getInvoices()));
		setFeatures(new java.util.LinkedHashSet<pm7.domain.Feature>(that.getFeatures()));
		setDefects(new java.util.LinkedHashSet<pm7.domain.Defect>(that.getDefects()));
		setTasks(new java.util.LinkedHashSet<pm7.domain.Task>(that.getTasks()));
		setChangerequests(new java.util.LinkedHashSet<pm7.domain.Changerequest>(that.getChangerequests()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("projectId=[").append(projectId).append("] ");
		buffer.append("projectName=[").append(projectName).append("] ");
		buffer.append("projectDesc=[").append(projectDesc).append("] ");
		buffer.append("projectType=[").append(projectType).append("] ");
		buffer.append("startDate=[").append(startDate).append("] ");
		buffer.append("dueDate=[").append(dueDate).append("] ");
		buffer.append("completeDate=[").append(completeDate).append("] ");
		buffer.append("estimateHrs=[").append(estimateHrs).append("] ");
		buffer.append("actualHrs=[").append(actualHrs).append("] ");
		buffer.append("hrRate=[").append(hrRate).append("] ");
		buffer.append("activeYn=[").append(activeYn).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((projectId == null) ? 0 : projectId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Project))
			return false;
		Project equalCheck = (Project) obj;
		if ((projectId == null && equalCheck.projectId != null) || (projectId != null && equalCheck.projectId == null))
			return false;
		if (projectId != null && !projectId.equals(equalCheck.projectId))
			return false;
		return true;
	}
}
