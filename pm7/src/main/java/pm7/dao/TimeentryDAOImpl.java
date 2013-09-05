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

import pm7.domain.Timeentry;

/**
 * DAO to manage Timeentry entities.
 * 
 */
@Repository("TimeentryDAO")
@Transactional
public class TimeentryDAOImpl extends AbstractJpaDao<Timeentry> implements
		TimeentryDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Timeentry.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mySql_pm7
	 *
	 */
	@PersistenceContext(unitName = "mySql_pm7")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TimeentryDAOImpl
	 *
	 */
	public TimeentryDAOImpl() {
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
	 * JPQL Query - findTimeentryByDescriptionContaining
	 *
	 */
	@Transactional
	public Set<Timeentry> findTimeentryByDescriptionContaining(String description) throws DataAccessException {

		return findTimeentryByDescriptionContaining(description, -1, -1);
	}

	/**
	 * JPQL Query - findTimeentryByDescriptionContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Timeentry> findTimeentryByDescriptionContaining(String description, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTimeentryByDescriptionContaining", startResult, maxRows, description);
		return new LinkedHashSet<Timeentry>(query.getResultList());
	}

	/**
	 * JPQL Query - findTimeentryByDescription
	 *
	 */
	@Transactional
	public Set<Timeentry> findTimeentryByDescription(String description) throws DataAccessException {

		return findTimeentryByDescription(description, -1, -1);
	}

	/**
	 * JPQL Query - findTimeentryByDescription
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Timeentry> findTimeentryByDescription(String description, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTimeentryByDescription", startResult, maxRows, description);
		return new LinkedHashSet<Timeentry>(query.getResultList());
	}

	/**
	 * JPQL Query - findTimeentryByPrimaryKey
	 *
	 */
	@Transactional
	public Timeentry findTimeentryByPrimaryKey(Integer timeEntryId) throws DataAccessException {

		return findTimeentryByPrimaryKey(timeEntryId, -1, -1);
	}

	/**
	 * JPQL Query - findTimeentryByPrimaryKey
	 *
	 */

	@Transactional
	public Timeentry findTimeentryByPrimaryKey(Integer timeEntryId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTimeentryByPrimaryKey", startResult, maxRows, timeEntryId);
			return (pm7.domain.Timeentry) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTimeentryByTimeHrs
	 *
	 */
	@Transactional
	public Set<Timeentry> findTimeentryByTimeHrs(Integer timeHrs) throws DataAccessException {

		return findTimeentryByTimeHrs(timeHrs, -1, -1);
	}

	/**
	 * JPQL Query - findTimeentryByTimeHrs
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Timeentry> findTimeentryByTimeHrs(Integer timeHrs, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTimeentryByTimeHrs", startResult, maxRows, timeHrs);
		return new LinkedHashSet<Timeentry>(query.getResultList());
	}

	/**
	 * JPQL Query - findTimeentryByDate
	 *
	 */
	@Transactional
	public Set<Timeentry> findTimeentryByDate(java.util.Calendar date) throws DataAccessException {

		return findTimeentryByDate(date, -1, -1);
	}

	/**
	 * JPQL Query - findTimeentryByDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Timeentry> findTimeentryByDate(java.util.Calendar date, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTimeentryByDate", startResult, maxRows, date);
		return new LinkedHashSet<Timeentry>(query.getResultList());
	}

	/**
	 * JPQL Query - findTimeentryByRateAmt
	 *
	 */
	@Transactional
	public Set<Timeentry> findTimeentryByRateAmt(java.math.BigDecimal rateAmt) throws DataAccessException {

		return findTimeentryByRateAmt(rateAmt, -1, -1);
	}

	/**
	 * JPQL Query - findTimeentryByRateAmt
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Timeentry> findTimeentryByRateAmt(java.math.BigDecimal rateAmt, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTimeentryByRateAmt", startResult, maxRows, rateAmt);
		return new LinkedHashSet<Timeentry>(query.getResultList());
	}

	/**
	 * JPQL Query - findTimeentryByTimeEntryId
	 *
	 */
	@Transactional
	public Timeentry findTimeentryByTimeEntryId(Integer timeEntryId) throws DataAccessException {

		return findTimeentryByTimeEntryId(timeEntryId, -1, -1);
	}

	/**
	 * JPQL Query - findTimeentryByTimeEntryId
	 *
	 */

	@Transactional
	public Timeentry findTimeentryByTimeEntryId(Integer timeEntryId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTimeentryByTimeEntryId", startResult, maxRows, timeEntryId);
			return (pm7.domain.Timeentry) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAllTimeentrys
	 *
	 */
	@Transactional
	public Set<Timeentry> findAllTimeentrys() throws DataAccessException {

		return findAllTimeentrys(-1, -1);
	}

	/**
	 * JPQL Query - findAllTimeentrys
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Timeentry> findAllTimeentrys(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllTimeentrys", startResult, maxRows);
		return new LinkedHashSet<Timeentry>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Timeentry entity) {
		return true;
	}
	
	public Integer getMaxTimeentryId() {
		Object obj = executeQuerySingleResult("select max(timeEntryId) from Timeentry");
		if(obj!=null){
			return (Integer)obj;
		}
		return 0;
	}
}
