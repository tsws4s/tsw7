package pm7.dao;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import pm7.domain.Testcasestep;

/**
 * DAO to manage Testcasestep entities.
 * 
 */
public interface TestcasestepDAO extends JpaDao<Testcasestep> {

	/**
	 * JPQL Query - findTestcasestepByActualResultContaining
	 *
	 */
	public Set<Testcasestep> findTestcasestepByActualResultContaining(String actualResult) throws DataAccessException;

	/**
	 * JPQL Query - findTestcasestepByActualResultContaining
	 *
	 */
	public Set<Testcasestep> findTestcasestepByActualResultContaining(String actualResult, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTestcasestepByStepDescription
	 *
	 */
	public Set<Testcasestep> findTestcasestepByStepDescription(String stepDescription) throws DataAccessException;

	/**
	 * JPQL Query - findTestcasestepByStepDescription
	 *
	 */
	public Set<Testcasestep> findTestcasestepByStepDescription(String stepDescription, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTestcasestepByActualResult
	 *
	 */
	public Set<Testcasestep> findTestcasestepByActualResult(String actualResult_1) throws DataAccessException;

	/**
	 * JPQL Query - findTestcasestepByActualResult
	 *
	 */
	public Set<Testcasestep> findTestcasestepByActualResult(String actualResult_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTestcasestepByTestStepId
	 *
	 */
	public Testcasestep findTestcasestepByTestStepId(Integer testStepId) throws DataAccessException;

	/**
	 * JPQL Query - findTestcasestepByTestStepId
	 *
	 */
	public Testcasestep findTestcasestepByTestStepId(Integer testStepId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTestcasestepByPrimaryKey
	 *
	 */
	public Testcasestep findTestcasestepByPrimaryKey(Integer testStepId_1) throws DataAccessException;

	/**
	 * JPQL Query - findTestcasestepByPrimaryKey
	 *
	 */
	public Testcasestep findTestcasestepByPrimaryKey(Integer testStepId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTestcasestepByPassFail
	 *
	 */
	public Set<Testcasestep> findTestcasestepByPassFail(String passFail) throws DataAccessException;

	/**
	 * JPQL Query - findTestcasestepByPassFail
	 *
	 */
	public Set<Testcasestep> findTestcasestepByPassFail(String passFail, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTestcasestepByPassFailContaining
	 *
	 */
	public Set<Testcasestep> findTestcasestepByPassFailContaining(String passFail_1) throws DataAccessException;

	/**
	 * JPQL Query - findTestcasestepByPassFailContaining
	 *
	 */
	public Set<Testcasestep> findTestcasestepByPassFailContaining(String passFail_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTestcasestepByTestCaseStepField
	 *
	 */
	public Set<Testcasestep> findTestcasestepByTestCaseStepField(Integer testCaseStepField) throws DataAccessException;

	/**
	 * JPQL Query - findTestcasestepByTestCaseStepField
	 *
	 */
	public Set<Testcasestep> findTestcasestepByTestCaseStepField(Integer testCaseStepField, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTestcasestepByExpectedResult
	 *
	 */
	public Set<Testcasestep> findTestcasestepByExpectedResult(String expectedResult) throws DataAccessException;

	/**
	 * JPQL Query - findTestcasestepByExpectedResult
	 *
	 */
	public Set<Testcasestep> findTestcasestepByExpectedResult(String expectedResult, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllTestcasesteps
	 *
	 */
	public Set<Testcasestep> findAllTestcasesteps() throws DataAccessException;

	/**
	 * JPQL Query - findAllTestcasesteps
	 *
	 */
	public Set<Testcasestep> findAllTestcasesteps(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTestcasestepByExpectedResultContaining
	 *
	 */
	public Set<Testcasestep> findTestcasestepByExpectedResultContaining(String expectedResult_1) throws DataAccessException;

	/**
	 * JPQL Query - findTestcasestepByExpectedResultContaining
	 *
	 */
	public Set<Testcasestep> findTestcasestepByExpectedResultContaining(String expectedResult_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTestcasestepByStepDescriptionContaining
	 *
	 */
	public Set<Testcasestep> findTestcasestepByStepDescriptionContaining(String stepDescription_1) throws DataAccessException;

	/**
	 * JPQL Query - findTestcasestepByStepDescriptionContaining
	 *
	 */
	public Set<Testcasestep> findTestcasestepByStepDescriptionContaining(String stepDescription_1, int startResult, int maxRows) throws DataAccessException;

	public Integer getMaxTestcasestepId();
}