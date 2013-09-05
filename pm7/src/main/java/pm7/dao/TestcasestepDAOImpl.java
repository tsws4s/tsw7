package pm7.dao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.skyway.spring.util.dao.AbstractJpaDao;

import org.springframework.dao.DataAccessException;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import pm7.domain.Testcasestep;

/**
 * DAO to manage Testcasestep entities.
 * 
 */
@Repository("TestcasestepDAO")
@Transactional
public class TestcasestepDAOImpl extends AbstractJpaDao<Testcasestep> implements
		TestcasestepDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Testcasestep.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mySql_pm7
	 *
	 */
	@PersistenceContext(unitName = "mySql_pm7")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TestcasestepDAOImpl
	 *
	 */
	public TestcasestepDAOImpl() {
		super();
	}

	/**
	 * Get the entity manager that manages persistence unit 
	 *
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Returns the set of entity classes managed by this DAO.
	 *
	 */
	public Set<Class<?>> getTypes() {
		return dataTypes;
	}

	/**
	 * JPQL Query - findTestcasestepByActualResultContaining
	 *
	 */
	@Transactional
	public Set<Testcasestep> findTestcasestepByActualResultContaining(String actualResult) throws DataAccessException {

		return findTestcasestepByActualResultContaining(actualResult, -1, -1);
	}

	/**
	 * JPQL Query - findTestcasestepByActualResultContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Testcasestep> findTestcasestepByActualResultContaining(String actualResult, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTestcasestepByActualResultContaining", startResult, maxRows, actualResult);
		return new LinkedHashSet<Testcasestep>(query.getResultList());
	}

	/**
	 * JPQL Query - findTestcasestepByStepDescription
	 *
	 */
	@Transactional
	public Set<Testcasestep> findTestcasestepByStepDescription(String stepDescription) throws DataAccessException {

		return findTestcasestepByStepDescription(stepDescription, -1, -1);
	}

	/**
	 * JPQL Query - findTestcasestepByStepDescription
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Testcasestep> findTestcasestepByStepDescription(String stepDescription, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTestcasestepByStepDescription", startResult, maxRows, stepDescription);
		return new LinkedHashSet<Testcasestep>(query.getResultList());
	}

	/**
	 * JPQL Query - findTestcasestepByActualResult
	 *
	 */
	@Transactional
	public Set<Testcasestep> findTestcasestepByActualResult(String actualResult) throws DataAccessException {

		return findTestcasestepByActualResult(actualResult, -1, -1);
	}

	/**
	 * JPQL Query - findTestcasestepByActualResult
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Testcasestep> findTestcasestepByActualResult(String actualResult, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTestcasestepByActualResult", startResult, maxRows, actualResult);
		return new LinkedHashSet<Testcasestep>(query.getResultList());
	}

	/**
	 * JPQL Query - findTestcasestepByTestStepId
	 *
	 */
	@Transactional
	public Testcasestep findTestcasestepByTestStepId(Integer testStepId) throws DataAccessException {

		return findTestcasestepByTestStepId(testStepId, -1, -1);
	}

	/**
	 * JPQL Query - findTestcasestepByTestStepId
	 *
	 */

	@Transactional
	public Testcasestep findTestcasestepByTestStepId(Integer testStepId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTestcasestepByTestStepId", startResult, maxRows, testStepId);
			return (pm7.domain.Testcasestep) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTestcasestepByPrimaryKey
	 *
	 */
	@Transactional
	public Testcasestep findTestcasestepByPrimaryKey(Integer testStepId) throws DataAccessException {

		return findTestcasestepByPrimaryKey(testStepId, -1, -1);
	}

	/**
	 * JPQL Query - findTestcasestepByPrimaryKey
	 *
	 */

	@Transactional
	public Testcasestep findTestcasestepByPrimaryKey(Integer testStepId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTestcasestepByPrimaryKey", startResult, maxRows, testStepId);
			return (pm7.domain.Testcasestep) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTestcasestepByPassFail
	 *
	 */
	@Transactional
	public Set<Testcasestep> findTestcasestepByPassFail(String passFail) throws DataAccessException {

		return findTestcasestepByPassFail(passFail, -1, -1);
	}

	/**
	 * JPQL Query - findTestcasestepByPassFail
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Testcasestep> findTestcasestepByPassFail(String passFail, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTestcasestepByPassFail", startResult, maxRows, passFail);
		return new LinkedHashSet<Testcasestep>(query.getResultList());
	}

	/**
	 * JPQL Query - findTestcasestepByPassFailContaining
	 *
	 */
	@Transactional
	public Set<Testcasestep> findTestcasestepByPassFailContaining(String passFail) throws DataAccessException {

		return findTestcasestepByPassFailContaining(passFail, -1, -1);
	}

	/**
	 * JPQL Query - findTestcasestepByPassFailContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Testcasestep> findTestcasestepByPassFailContaining(String passFail, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTestcasestepByPassFailContaining", startResult, maxRows, passFail);
		return new LinkedHashSet<Testcasestep>(query.getResultList());
	}

	/**
	 * JPQL Query - findTestcasestepByTestCaseStepField
	 *
	 */
	@Transactional
	public Set<Testcasestep> findTestcasestepByTestCaseStepField(Integer testCaseStepField) throws DataAccessException {

		return findTestcasestepByTestCaseStepField(testCaseStepField, -1, -1);
	}

	/**
	 * JPQL Query - findTestcasestepByTestCaseStepField
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Testcasestep> findTestcasestepByTestCaseStepField(Integer testCaseStepField, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTestcasestepByTestCaseStepField", startResult, maxRows, testCaseStepField);
		return new LinkedHashSet<Testcasestep>(query.getResultList());
	}

	/**
	 * JPQL Query - findTestcasestepByExpectedResult
	 *
	 */
	@Transactional
	public Set<Testcasestep> findTestcasestepByExpectedResult(String expectedResult) throws DataAccessException {

		return findTestcasestepByExpectedResult(expectedResult, -1, -1);
	}

	/**
	 * JPQL Query - findTestcasestepByExpectedResult
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Testcasestep> findTestcasestepByExpectedResult(String expectedResult, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTestcasestepByExpectedResult", startResult, maxRows, expectedResult);
		return new LinkedHashSet<Testcasestep>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllTestcasesteps
	 *
	 */
	@Transactional
	public Set<Testcasestep> findAllTestcasesteps() throws DataAccessException {

		return findAllTestcasesteps(-1, -1);
	}

	/**
	 * JPQL Query - findAllTestcasesteps
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Testcasestep> findAllTestcasesteps(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllTestcasesteps", startResult, maxRows);
		return new LinkedHashSet<Testcasestep>(query.getResultList());
	}

	/**
	 * JPQL Query - findTestcasestepByExpectedResultContaining
	 *
	 */
	@Transactional
	public Set<Testcasestep> findTestcasestepByExpectedResultContaining(String expectedResult) throws DataAccessException {

		return findTestcasestepByExpectedResultContaining(expectedResult, -1, -1);
	}

	/**
	 * JPQL Query - findTestcasestepByExpectedResultContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Testcasestep> findTestcasestepByExpectedResultContaining(String expectedResult, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTestcasestepByExpectedResultContaining", startResult, maxRows, expectedResult);
		return new LinkedHashSet<Testcasestep>(query.getResultList());
	}

	/**
	 * JPQL Query - findTestcasestepByStepDescriptionContaining
	 *
	 */
	@Transactional
	public Set<Testcasestep> findTestcasestepByStepDescriptionContaining(String stepDescription) throws DataAccessException {

		return findTestcasestepByStepDescriptionContaining(stepDescription, -1, -1);
	}

	/**
	 * JPQL Query - findTestcasestepByStepDescriptionContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Testcasestep> findTestcasestepByStepDescriptionContaining(String stepDescription, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTestcasestepByStepDescriptionContaining", startResult, maxRows, stepDescription);
		return new LinkedHashSet<Testcasestep>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Testcasestep entity) {
		return true;
	}
	
	public Integer getMaxTestcasestepId() {
		Object obj = executeQuerySingleResult("select max(testStepId) from Testcasestep");
		return (Integer)obj;
	}
}
