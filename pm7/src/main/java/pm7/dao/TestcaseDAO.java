package pm7.dao;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import pm7.domain.Testcase;

/**
 * DAO to manage Testcase entities.
 * 
 */
public interface TestcaseDAO extends JpaDao<Testcase> {

	/**
	 * JPQL Query - findTestcaseByTestDescription
	 *
	 */
	public Set<Testcase> findTestcaseByTestDescription(String testDescription) throws DataAccessException;

	/**
	 * JPQL Query - findTestcaseByTestDescription
	 *
	 */
	public Set<Testcase> findTestcaseByTestDescription(String testDescription, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTestcaseByTestDescriptionContaining
	 *
	 */
	public Set<Testcase> findTestcaseByTestDescriptionContaining(String testDescription_1) throws DataAccessException;

	/**
	 * JPQL Query - findTestcaseByTestDescriptionContaining
	 *
	 */
	public Set<Testcase> findTestcaseByTestDescriptionContaining(String testDescription_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTestcaseByTestName
	 *
	 */
	public Set<Testcase> findTestcaseByTestName(String testName) throws DataAccessException;

	/**
	 * JPQL Query - findTestcaseByTestName
	 *
	 */
	public Set<Testcase> findTestcaseByTestName(String testName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTestcaseByTestCaseCodeContaining
	 *
	 */
	public Set<Testcase> findTestcaseByTestCaseCodeContaining(String testCaseCode) throws DataAccessException;

	/**
	 * JPQL Query - findTestcaseByTestCaseCodeContaining
	 *
	 */
	public Set<Testcase> findTestcaseByTestCaseCodeContaining(String testCaseCode, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTestcaseByPassFailContaining
	 *
	 */
	public Set<Testcase> findTestcaseByPassFailContaining(String passFail) throws DataAccessException;

	/**
	 * JPQL Query - findTestcaseByPassFailContaining
	 *
	 */
	public Set<Testcase> findTestcaseByPassFailContaining(String passFail, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllTestcases
	 *
	 */
	public Set<Testcase> findAllTestcases() throws DataAccessException;

	/**
	 * JPQL Query - findAllTestcases
	 *
	 */
	public Set<Testcase> findAllTestcases(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTestcaseByPrimaryKey
	 *
	 */
	public Testcase findTestcaseByPrimaryKey(Integer testId) throws DataAccessException;

	/**
	 * JPQL Query - findTestcaseByPrimaryKey
	 *
	 */
	public Testcase findTestcaseByPrimaryKey(Integer testId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTestcaseByTestSetup
	 *
	 */
	public Set<Testcase> findTestcaseByTestSetup(String testSetup) throws DataAccessException;

	/**
	 * JPQL Query - findTestcaseByTestSetup
	 *
	 */
	public Set<Testcase> findTestcaseByTestSetup(String testSetup, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTestcaseByTestCaseCode
	 *
	 */
	public Set<Testcase> findTestcaseByTestCaseCode(String testCaseCode_1) throws DataAccessException;

	/**
	 * JPQL Query - findTestcaseByTestCaseCode
	 *
	 */
	public Set<Testcase> findTestcaseByTestCaseCode(String testCaseCode_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTestcaseByTestSetupContaining
	 *
	 */
	public Set<Testcase> findTestcaseByTestSetupContaining(String testSetup_1) throws DataAccessException;

	/**
	 * JPQL Query - findTestcaseByTestSetupContaining
	 *
	 */
	public Set<Testcase> findTestcaseByTestSetupContaining(String testSetup_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTestcaseByTestNameContaining
	 *
	 */
	public Set<Testcase> findTestcaseByTestNameContaining(String testName_1) throws DataAccessException;

	/**
	 * JPQL Query - findTestcaseByTestNameContaining
	 *
	 */
	public Set<Testcase> findTestcaseByTestNameContaining(String testName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTestcaseByTestId
	 *
	 */
	public Testcase findTestcaseByTestId(Integer testId_1) throws DataAccessException;

	/**
	 * JPQL Query - findTestcaseByTestId
	 *
	 */
	public Testcase findTestcaseByTestId(Integer testId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTestcaseByPassFail
	 *
	 */
	public Set<Testcase> findTestcaseByPassFail(String passFail_1) throws DataAccessException;

	/**
	 * JPQL Query - findTestcaseByPassFail
	 *
	 */
	public Set<Testcase> findTestcaseByPassFail(String passFail_1, int startResult, int maxRows) throws DataAccessException;

	public Integer getMaxTestcaseId();
}