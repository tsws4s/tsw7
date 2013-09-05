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

import pm7.domain.Testcase;

/**
 * DAO to manage Testcase entities.
 * 
 */
@Repository("TestcaseDAO")
@Transactional
public class TestcaseDAOImpl extends AbstractJpaDao<Testcase> implements
		TestcaseDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Testcase.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mySql_pm7
	 *
	 */
	@PersistenceContext(unitName = "mySql_pm7")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TestcaseDAOImpl
	 *
	 */
	public TestcaseDAOImpl() {
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
	 * JPQL Query - findTestcaseByTestDescription
	 *
	 */
	@Transactional
	public Set<Testcase> findTestcaseByTestDescription(String testDescription) throws DataAccessException {

		return findTestcaseByTestDescription(testDescription, -1, -1);
	}

	/**
	 * JPQL Query - findTestcaseByTestDescription
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Testcase> findTestcaseByTestDescription(String testDescription, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTestcaseByTestDescription", startResult, maxRows, testDescription);
		return new LinkedHashSet<Testcase>(query.getResultList());
	}

	/**
	 * JPQL Query - findTestcaseByTestDescriptionContaining
	 *
	 */
	@Transactional
	public Set<Testcase> findTestcaseByTestDescriptionContaining(String testDescription) throws DataAccessException {

		return findTestcaseByTestDescriptionContaining(testDescription, -1, -1);
	}

	/**
	 * JPQL Query - findTestcaseByTestDescriptionContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Testcase> findTestcaseByTestDescriptionContaining(String testDescription, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTestcaseByTestDescriptionContaining", startResult, maxRows, testDescription);
		return new LinkedHashSet<Testcase>(query.getResultList());
	}

	/**
	 * JPQL Query - findTestcaseByTestName
	 *
	 */
	@Transactional
	public Set<Testcase> findTestcaseByTestName(String testName) throws DataAccessException {

		return findTestcaseByTestName(testName, -1, -1);
	}

	/**
	 * JPQL Query - findTestcaseByTestName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Testcase> findTestcaseByTestName(String testName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTestcaseByTestName", startResult, maxRows, testName);
		return new LinkedHashSet<Testcase>(query.getResultList());
	}

	/**
	 * JPQL Query - findTestcaseByTestCaseCodeContaining
	 *
	 */
	@Transactional
	public Set<Testcase> findTestcaseByTestCaseCodeContaining(String testCaseCode) throws DataAccessException {

		return findTestcaseByTestCaseCodeContaining(testCaseCode, -1, -1);
	}

	/**
	 * JPQL Query - findTestcaseByTestCaseCodeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Testcase> findTestcaseByTestCaseCodeContaining(String testCaseCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTestcaseByTestCaseCodeContaining", startResult, maxRows, testCaseCode);
		return new LinkedHashSet<Testcase>(query.getResultList());
	}

	/**
	 * JPQL Query - findTestcaseByPassFailContaining
	 *
	 */
	@Transactional
	public Set<Testcase> findTestcaseByPassFailContaining(String passFail) throws DataAccessException {

		return findTestcaseByPassFailContaining(passFail, -1, -1);
	}

	/**
	 * JPQL Query - findTestcaseByPassFailContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Testcase> findTestcaseByPassFailContaining(String passFail, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTestcaseByPassFailContaining", startResult, maxRows, passFail);
		return new LinkedHashSet<Testcase>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllTestcases
	 *
	 */
	@Transactional
	public Set<Testcase> findAllTestcases() throws DataAccessException {

		return findAllTestcases(-1, -1);
	}

	/**
	 * JPQL Query - findAllTestcases
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Testcase> findAllTestcases(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllTestcases", startResult, maxRows);
		return new LinkedHashSet<Testcase>(query.getResultList());
	}

	/**
	 * JPQL Query - findTestcaseByPrimaryKey
	 *
	 */
	@Transactional
	public Testcase findTestcaseByPrimaryKey(Integer testId) throws DataAccessException {

		return findTestcaseByPrimaryKey(testId, -1, -1);
	}

	/**
	 * JPQL Query - findTestcaseByPrimaryKey
	 *
	 */

	@Transactional
	public Testcase findTestcaseByPrimaryKey(Integer testId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTestcaseByPrimaryKey", startResult, maxRows, testId);
			return (pm7.domain.Testcase) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTestcaseByTestSetup
	 *
	 */
	@Transactional
	public Set<Testcase> findTestcaseByTestSetup(String testSetup) throws DataAccessException {

		return findTestcaseByTestSetup(testSetup, -1, -1);
	}

	/**
	 * JPQL Query - findTestcaseByTestSetup
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Testcase> findTestcaseByTestSetup(String testSetup, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTestcaseByTestSetup", startResult, maxRows, testSetup);
		return new LinkedHashSet<Testcase>(query.getResultList());
	}

	/**
	 * JPQL Query - findTestcaseByTestCaseCode
	 *
	 */
	@Transactional
	public Set<Testcase> findTestcaseByTestCaseCode(String testCaseCode) throws DataAccessException {

		return findTestcaseByTestCaseCode(testCaseCode, -1, -1);
	}

	/**
	 * JPQL Query - findTestcaseByTestCaseCode
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Testcase> findTestcaseByTestCaseCode(String testCaseCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTestcaseByTestCaseCode", startResult, maxRows, testCaseCode);
		return new LinkedHashSet<Testcase>(query.getResultList());
	}

	/**
	 * JPQL Query - findTestcaseByTestSetupContaining
	 *
	 */
	@Transactional
	public Set<Testcase> findTestcaseByTestSetupContaining(String testSetup) throws DataAccessException {

		return findTestcaseByTestSetupContaining(testSetup, -1, -1);
	}

	/**
	 * JPQL Query - findTestcaseByTestSetupContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Testcase> findTestcaseByTestSetupContaining(String testSetup, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTestcaseByTestSetupContaining", startResult, maxRows, testSetup);
		return new LinkedHashSet<Testcase>(query.getResultList());
	}

	/**
	 * JPQL Query - findTestcaseByTestNameContaining
	 *
	 */
	@Transactional
	public Set<Testcase> findTestcaseByTestNameContaining(String testName) throws DataAccessException {

		return findTestcaseByTestNameContaining(testName, -1, -1);
	}

	/**
	 * JPQL Query - findTestcaseByTestNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Testcase> findTestcaseByTestNameContaining(String testName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTestcaseByTestNameContaining", startResult, maxRows, testName);
		return new LinkedHashSet<Testcase>(query.getResultList());
	}

	/**
	 * JPQL Query - findTestcaseByTestId
	 *
	 */
	@Transactional
	public Testcase findTestcaseByTestId(Integer testId) throws DataAccessException {

		return findTestcaseByTestId(testId, -1, -1);
	}

	/**
	 * JPQL Query - findTestcaseByTestId
	 *
	 */

	@Transactional
	public Testcase findTestcaseByTestId(Integer testId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTestcaseByTestId", startResult, maxRows, testId);
			return (pm7.domain.Testcase) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTestcaseByPassFail
	 *
	 */
	@Transactional
	public Set<Testcase> findTestcaseByPassFail(String passFail) throws DataAccessException {

		return findTestcaseByPassFail(passFail, -1, -1);
	}

	/**
	 * JPQL Query - findTestcaseByPassFail
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Testcase> findTestcaseByPassFail(String passFail, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTestcaseByPassFail", startResult, maxRows, passFail);
		return new LinkedHashSet<Testcase>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Testcase entity) {
		return true;
	}
	
	public Integer getMaxTestcaseId() {
		Object obj = executeQuerySingleResult("select max(testId) from Testcase");
		return (Integer)obj;
	}
}
