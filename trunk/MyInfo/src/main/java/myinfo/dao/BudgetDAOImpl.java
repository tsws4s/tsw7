package myinfo.dao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import myinfo.domain.Budget;

import org.skyway.spring.util.dao.AbstractJpaDao;

import org.springframework.dao.DataAccessException;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

/**
 * DAO to manage Budget entities.
 * 
 */
@Repository("BudgetDAO")
@Transactional
public class BudgetDAOImpl extends AbstractJpaDao<Budget> implements BudgetDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Budget.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mySQL_myInfo
	 *
	 */
	@PersistenceContext(unitName = "mySQL_myInfo")
	private EntityManager entityManager;

	/**
	 * Instantiates a new BudgetDAOImpl
	 *
	 */
	public BudgetDAOImpl() {
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
	 * JPQL Query - findBudgetByYear
	 *
	 */
	@Transactional
	public Set<Budget> findBudgetByYear(Integer year) throws DataAccessException {

		return findBudgetByYear(year, -1, -1);
	}

	/**
	 * JPQL Query - findBudgetByYear
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Budget> findBudgetByYear(Integer year, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findBudgetByYear", startResult, maxRows, year);
		return new LinkedHashSet<Budget>(query.getResultList());
	}

	/**
	 * JPQL Query - findBudgetByBudgetId
	 *
	 */
	@Transactional
	public Budget findBudgetByBudgetId(Integer budgetId) throws DataAccessException {

		return findBudgetByBudgetId(budgetId, -1, -1);
	}

	/**
	 * JPQL Query - findBudgetByBudgetId
	 *
	 */

	@Transactional
	public Budget findBudgetByBudgetId(Integer budgetId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findBudgetByBudgetId", startResult, maxRows, budgetId);
			return (myinfo.domain.Budget) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findBudgetByUserFk
	 *
	 */
	@Transactional
	public Set<Budget> findBudgetByUserFk(Integer userFk) throws DataAccessException {

		return findBudgetByUserFk(userFk, -1, -1);
	}

	/**
	 * JPQL Query - findBudgetByUserFk
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Budget> findBudgetByUserFk(Integer userFk, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findBudgetByUserFk", startResult, maxRows, userFk);
		return new LinkedHashSet<Budget>(query.getResultList());
	}

	/**
	 * JPQL Query - findBudgetByName
	 *
	 */
	@Transactional
	public Set<Budget> findBudgetByName(String name) throws DataAccessException {

		return findBudgetByName(name, -1, -1);
	}

	/**
	 * JPQL Query - findBudgetByName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Budget> findBudgetByName(String name, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findBudgetByName", startResult, maxRows, name);
		return new LinkedHashSet<Budget>(query.getResultList());
	}

	/**
	 * JPQL Query - findBudgetByActiveYn
	 *
	 */
	@Transactional
	public Set<Budget> findBudgetByActiveYn(Integer activeYn) throws DataAccessException {

		return findBudgetByActiveYn(activeYn, -1, -1);
	}

	/**
	 * JPQL Query - findBudgetByActiveYn
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Budget> findBudgetByActiveYn(Integer activeYn, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findBudgetByActiveYn", startResult, maxRows, activeYn);
		return new LinkedHashSet<Budget>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllBudgets
	 *
	 */
	@Transactional
	public Set<Budget> findAllBudgets() throws DataAccessException {

		return findAllBudgets(-1, -1);
	}

	/**
	 * JPQL Query - findAllBudgets
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Budget> findAllBudgets(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllBudgets", startResult, maxRows);
		return new LinkedHashSet<Budget>(query.getResultList());
	}

	/**
	 * JPQL Query - findBudgetByNameContaining
	 *
	 */
	@Transactional
	public Set<Budget> findBudgetByNameContaining(String name) throws DataAccessException {

		return findBudgetByNameContaining(name, -1, -1);
	}

	/**
	 * JPQL Query - findBudgetByNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Budget> findBudgetByNameContaining(String name, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findBudgetByNameContaining", startResult, maxRows, name);
		return new LinkedHashSet<Budget>(query.getResultList());
	}

	/**
	 * JPQL Query - findBudgetByPrimaryKey
	 *
	 */
	@Transactional
	public Budget findBudgetByPrimaryKey(Integer budgetId) throws DataAccessException {

		return findBudgetByPrimaryKey(budgetId, -1, -1);
	}

	/**
	 * JPQL Query - findBudgetByPrimaryKey
	 *
	 */

	@Transactional
	public Budget findBudgetByPrimaryKey(Integer budgetId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findBudgetByPrimaryKey", startResult, maxRows, budgetId);
			return (myinfo.domain.Budget) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Budget entity) {
		return true;
	}
}
