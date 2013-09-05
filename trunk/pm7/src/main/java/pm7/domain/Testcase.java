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
		@NamedQuery(name = "findAllTestcases", query = "select myTestcase from Testcase myTestcase"),
		@NamedQuery(name = "findTestcaseByPassFail", query = "select myTestcase from Testcase myTestcase where myTestcase.passFail = ?1"),
		@NamedQuery(name = "findTestcaseByPassFailContaining", query = "select myTestcase from Testcase myTestcase where myTestcase.passFail like ?1"),
		@NamedQuery(name = "findTestcaseByPrimaryKey", query = "select myTestcase from Testcase myTestcase where myTestcase.testId = ?1"),
		@NamedQuery(name = "findTestcaseByTestCaseCode", query = "select myTestcase from Testcase myTestcase where myTestcase.testCaseCode = ?1"),
		@NamedQuery(name = "findTestcaseByTestCaseCodeContaining", query = "select myTestcase from Testcase myTestcase where myTestcase.testCaseCode like ?1"),
		@NamedQuery(name = "findTestcaseByTestDescription", query = "select myTestcase from Testcase myTestcase where myTestcase.testDescription = ?1"),
		@NamedQuery(name = "findTestcaseByTestDescriptionContaining", query = "select myTestcase from Testcase myTestcase where myTestcase.testDescription like ?1"),
		@NamedQuery(name = "findTestcaseByTestId", query = "select myTestcase from Testcase myTestcase where myTestcase.testId = ?1"),
		@NamedQuery(name = "findTestcaseByTestName", query = "select myTestcase from Testcase myTestcase where myTestcase.testName = ?1"),
		@NamedQuery(name = "findTestcaseByTestNameContaining", query = "select myTestcase from Testcase myTestcase where myTestcase.testName like ?1"),
		@NamedQuery(name = "findTestcaseByTestSetup", query = "select myTestcase from Testcase myTestcase where myTestcase.testSetup = ?1"),
		@NamedQuery(name = "findTestcaseByTestSetupContaining", query = "select myTestcase from Testcase myTestcase where myTestcase.testSetup like ?1") })
@Table(catalog = "C324877_project_mgt", name = "TestCase")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "pm7/pm7/domain", name = "Testcase")
@XmlRootElement(namespace = "pm7/pm7/domain")
public class Testcase implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "testId", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer testId;
	/**
	 */

	@Column(name = "passFail", length = 20)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String passFail;
	/**
	 */

	@Column(name = "testCaseCode", length = 20)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String testCaseCode;
	/**
	 */

	@Column(name = "testName", length = 150)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String testName;
	/**
	 */

	@Column(name = "testDescription", length = 240)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String testDescription;
	/**
	 */

	@Column(name = "testSetup", length = 240)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String testSetup;

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
	@OneToMany(mappedBy = "testcase", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Testcasestep> testcasesteps;
	/**
	 */
	@OneToMany(mappedBy = "testcase", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Defect> defects;
	/**
	 */
	@OneToMany(mappedBy = "testcase", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Statusupdate> statusupdates;
	/**
	 */
	@OneToMany(mappedBy = "testcase", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Task> tasks;
	/**
	 */
	@OneToMany(mappedBy = "testcase", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<pm7.domain.Attachment> attachments;

	/**
	 */
	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	/**
	 */
	public Integer getTestId() {
		return this.testId;
	}

	/**
	 */
	public void setPassFail(String passFail) {
		this.passFail = passFail;
	}

	/**
	 */
	public String getPassFail() {
		return this.passFail;
	}

	/**
	 */
	public void setTestCaseCode(String testCaseCode) {
		this.testCaseCode = testCaseCode;
	}

	/**
	 */
	public String getTestCaseCode() {
		return this.testCaseCode;
	}

	/**
	 */
	public void setTestName(String testName) {
		this.testName = testName;
	}

	/**
	 */
	public String getTestName() {
		return this.testName;
	}

	/**
	 */
	public void setTestDescription(String testDescription) {
		this.testDescription = testDescription;
	}

	/**
	 */
	public String getTestDescription() {
		return this.testDescription;
	}

	/**
	 */
	public void setTestSetup(String testSetup) {
		this.testSetup = testSetup;
	}

	/**
	 */
	public String getTestSetup() {
		return this.testSetup;
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
	public Testcase() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Testcase that) {
		setTestId(that.getTestId());
		setPassFail(that.getPassFail());
		setTestCaseCode(that.getTestCaseCode());
		setTestName(that.getTestName());
		setTestDescription(that.getTestDescription());
		setTestSetup(that.getTestSetup());
		setAccount(that.getAccount());
		setChangerequest(that.getChangerequest());
		setRequirement(that.getRequirement());
		setProject(that.getProject());
		setTestcasesteps(new java.util.LinkedHashSet<pm7.domain.Testcasestep>(that.getTestcasesteps()));
		setDefects(new java.util.LinkedHashSet<pm7.domain.Defect>(that.getDefects()));
		setStatusupdates(new java.util.LinkedHashSet<pm7.domain.Statusupdate>(that.getStatusupdates()));
		setTasks(new java.util.LinkedHashSet<pm7.domain.Task>(that.getTasks()));
		setAttachments(new java.util.LinkedHashSet<pm7.domain.Attachment>(that.getAttachments()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("testId=[").append(testId).append("] ");
		buffer.append("passFail=[").append(passFail).append("] ");
		buffer.append("testCaseCode=[").append(testCaseCode).append("] ");
		buffer.append("testName=[").append(testName).append("] ");
		buffer.append("testDescription=[").append(testDescription).append("] ");
		buffer.append("testSetup=[").append(testSetup).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((testId == null) ? 0 : testId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Testcase))
			return false;
		Testcase equalCheck = (Testcase) obj;
		if ((testId == null && equalCheck.testId != null) || (testId != null && equalCheck.testId == null))
			return false;
		if (testId != null && !testId.equals(equalCheck.testId))
			return false;
		return true;
	}
}
