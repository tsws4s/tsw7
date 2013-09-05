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
		@NamedQuery(name = "findAllTestcasesteps", query = "select myTestcasestep from Testcasestep myTestcasestep"),
		@NamedQuery(name = "findTestcasestepByActualResult", query = "select myTestcasestep from Testcasestep myTestcasestep where myTestcasestep.actualResult = ?1"),
		@NamedQuery(name = "findTestcasestepByActualResultContaining", query = "select myTestcasestep from Testcasestep myTestcasestep where myTestcasestep.actualResult like ?1"),
		@NamedQuery(name = "findTestcasestepByExpectedResult", query = "select myTestcasestep from Testcasestep myTestcasestep where myTestcasestep.expectedResult = ?1"),
		@NamedQuery(name = "findTestcasestepByExpectedResultContaining", query = "select myTestcasestep from Testcasestep myTestcasestep where myTestcasestep.expectedResult like ?1"),
		@NamedQuery(name = "findTestcasestepByPassFail", query = "select myTestcasestep from Testcasestep myTestcasestep where myTestcasestep.passFail = ?1"),
		@NamedQuery(name = "findTestcasestepByPassFailContaining", query = "select myTestcasestep from Testcasestep myTestcasestep where myTestcasestep.passFail like ?1"),
		@NamedQuery(name = "findTestcasestepByPrimaryKey", query = "select myTestcasestep from Testcasestep myTestcasestep where myTestcasestep.testStepId = ?1"),
		@NamedQuery(name = "findTestcasestepByStepDescription", query = "select myTestcasestep from Testcasestep myTestcasestep where myTestcasestep.stepDescription = ?1"),
		@NamedQuery(name = "findTestcasestepByStepDescriptionContaining", query = "select myTestcasestep from Testcasestep myTestcasestep where myTestcasestep.stepDescription like ?1"),
		@NamedQuery(name = "findTestcasestepByTestCaseStepField", query = "select myTestcasestep from Testcasestep myTestcasestep where myTestcasestep.testCaseStepField = ?1"),
		@NamedQuery(name = "findTestcasestepByTestStepId", query = "select myTestcasestep from Testcasestep myTestcasestep where myTestcasestep.testStepId = ?1") })
@Table(catalog = "C324877_project_mgt", name = "TestCaseStep")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "pm7/pm7/domain", name = "Testcasestep")
public class Testcasestep implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "testStepId", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer testStepId;
	/**
	 */

	@Column(name = "passFail", length = 20)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String passFail;
	/**
	 */

	@Column(name = "testCaseStep")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer testCaseStepField;
	/**
	 */

	@Column(name = "stepDescription", length = 240)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String stepDescription;
	/**
	 */

	@Column(name = "expectedResult", length = 240)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String expectedResult;
	/**
	 */

	@Column(name = "actualResult", length = 240)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String actualResult;

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
	@JoinColumns({ @JoinColumn(name = "FK_projectId", referencedColumnName = "projectId") })
	@XmlTransient
	Project project;

	/**
	 */
	public void setTestStepId(Integer testStepId) {
		this.testStepId = testStepId;
	}

	/**
	 */
	public Integer getTestStepId() {
		return this.testStepId;
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
	public void setTestCaseStepField(Integer testCaseStepField) {
		this.testCaseStepField = testCaseStepField;
	}

	/**
	 */
	public Integer getTestCaseStepField() {
		return this.testCaseStepField;
	}

	/**
	 */
	public void setStepDescription(String stepDescription) {
		this.stepDescription = stepDescription;
	}

	/**
	 */
	public String getStepDescription() {
		return this.stepDescription;
	}

	/**
	 */
	public void setExpectedResult(String expectedResult) {
		this.expectedResult = expectedResult;
	}

	/**
	 */
	public String getExpectedResult() {
		return this.expectedResult;
	}

	/**
	 */
	public void setActualResult(String actualResult) {
		this.actualResult = actualResult;
	}

	/**
	 */
	public String getActualResult() {
		return this.actualResult;
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
	public Testcasestep() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Testcasestep that) {
		setTestStepId(that.getTestStepId());
		setPassFail(that.getPassFail());
		setTestCaseStepField(that.getTestCaseStepField());
		setStepDescription(that.getStepDescription());
		setExpectedResult(that.getExpectedResult());
		setActualResult(that.getActualResult());
		setTestcase(that.getTestcase());
		setAccount(that.getAccount());
		setProject(that.getProject());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("testStepId=[").append(testStepId).append("] ");
		buffer.append("passFail=[").append(passFail).append("] ");
		buffer.append("testCaseStepField=[").append(testCaseStepField).append("] ");
		buffer.append("stepDescription=[").append(stepDescription).append("] ");
		buffer.append("expectedResult=[").append(expectedResult).append("] ");
		buffer.append("actualResult=[").append(actualResult).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((testStepId == null) ? 0 : testStepId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Testcasestep))
			return false;
		Testcasestep equalCheck = (Testcasestep) obj;
		if ((testStepId == null && equalCheck.testStepId != null) || (testStepId != null && equalCheck.testStepId == null))
			return false;
		if (testStepId != null && !testStepId.equals(equalCheck.testStepId))
			return false;
		return true;
	}
}
