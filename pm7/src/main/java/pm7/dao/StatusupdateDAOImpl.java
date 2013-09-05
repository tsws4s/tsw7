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

import pm7.domain.Statusupdate;

/**
 * DAO to manage Statusupdate entities.
 * 
 */
@Repository("StatusupdateDAO")
@Transactional
public class StatusupdateDAOImpl extends AbstractJpaDao<Statusupdate> implements
		StatusupdateDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Statusupdate.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mySql_pm7
	 *
	 */
	@PersistenceContext(unitName = "mySql_pm7")
	private EntityManager entityManager;

	/**
	 * Instantiates a new StatusupdateDAOImpl
	 *
	 */
	public StatusupdateDAOImpl() {
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
	 * JPQL Query - findStatusupdateByEstHrsLeft
	 *
	 */
	@Transactional
	public Set<Statusupdate> findStatusupdateByEstHrsLeft(Integer estHrsLeft) throws DataAccessException {

		return findStatusupdateByEstHrsLeft(estHrsLeft, -1, -1);
	}

	/**
	 * JPQL Query - findStatusupdateByEstHrsLeft
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Statusupdate> findStatusupdateByEstHrsLeft(Integer estHrsLeft, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStatusupdateByEstHrsLeft", startResult, maxRows, estHrsLeft);
		return new LinkedHashSet<Statusupdate>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllStatusupdates
	 *
	 */
	@Transactional
	public Set<Statusupdate> findAllStatusupdates() throws DataAccessException {

		return findAllStatusupdates(-1, -1);
	}

	/**
	 * JPQL Query - findAllStatusupdates
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Statusupdate> findAllStatusupdates(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllStatusupdates", startResult, maxRows);
		return new LinkedHashSet<Statusupdate>(query.getResultList());
	}

	/**
	 * JPQL Query - findStatusupdateByPrimaryKey
	 *
	 */
	@Transactional
	public Statusupdate findStatusupdateByPrimaryKey(Integer statusId) throws DataAccessException {

		return findStatusupdateByPrimaryKey(statusId, -1, -1);
	}

	/**
	 * JPQL Query - findStatusupdateByPrimaryKey
	 *
	 */

	@Transactional
	public Statusupdate findStatusupdateByPrimaryKey(Integer statusId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findStatusupdateByPrimaryKey", startResult, maxRows, statusId);
			return (pm7.domain.Statusupdate) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findStatusupdateByRiskGyrContaining
	 *
	 */
	@Transactional
	public Set<Statusupdate> findStatusupdateByRiskGyrContaining(String riskGyr) throws DataAccessException {

		return findStatusupdateByRiskGyrContaining(riskGyr, -1, -1);
	}

	/**
	 * JPQL Query - findStatusupdateByRiskGyrContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Statusupdate> findStatusupdateByRiskGyrContaining(String riskGyr, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStatusupdateByRiskGyrContaining", startResult, maxRows, riskGyr);
		return new LinkedHashSet<Statusupdate>(query.getResultList());
	}

	/**
	 * JPQL Query - findStatusupdateByRiskGyr
	 *
	 */
	@Transactional
	public Set<Statusupdate> findStatusupdateByRiskGyr(String riskGyr) throws DataAccessException {

		return findStatusupdateByRiskGyr(riskGyr, -1, -1);
	}

	/**
	 * JPQL Query - findStatusupdateByRiskGyr
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Statusupdate> findStatusupdateByRiskGyr(String riskGyr, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStatusupdateByRiskGyr", startResult, maxRows, riskGyr);
		return new LinkedHashSet<Statusupdate>(query.getResultList());
	}

	/**
	 * JPQL Query - findStatusupdateByStatusDateBefore
	 *
	 */
	@Transactional
	public Set<Statusupdate> findStatusupdateByStatusDateBefore(java.util.Calendar statusDate) throws DataAccessException {

		return findStatusupdateByStatusDateBefore(statusDate, -1, -1);
	}

	/**
	 * JPQL Query - findStatusupdateByStatusDateBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Statusupdate> findStatusupdateByStatusDateBefore(java.util.Calendar statusDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStatusupdateByStatusDateBefore", startResult, maxRows, statusDate);
		return new LinkedHashSet<Statusupdate>(query.getResultList());
	}

	/**
	 * JPQL Query - findStatusupdateByStatusUpdateDescContaining
	 *
	 */
	@Transactional
	public Set<Statusupdate> findStatusupdateByStatusUpdateDescContaining(String statusUpdateDesc) throws DataAccessException {

		return findStatusupdateByStatusUpdateDescContaining(statusUpdateDesc, -1, -1);
	}

	/**
	 * JPQL Query - findStatusupdateByStatusUpdateDescContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Statusupdate> findStatusupdateByStatusUpdateDescContaining(String statusUpdateDesc, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStatusupdateByStatusUpdateDescContaining", startResult, maxRows, statusUpdateDesc);
		return new LinkedHashSet<Statusupdate>(query.getResultList());
	}

	/**
	 * JPQL Query - findStatusupdateByStatusDateAfter
	 *
	 */
	@Transactional
	public Set<Statusupdate> findStatusupdateByStatusDateAfter(java.util.Calendar statusDate) throws DataAccessException {

		return findStatusupdateByStatusDateAfter(statusDate, -1, -1);
	}

	/**
	 * JPQL Query - findStatusupdateByStatusDateAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Statusupdate> findStatusupdateByStatusDateAfter(java.util.Calendar statusDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStatusupdateByStatusDateAfter", startResult, maxRows, statusDate);
		return new LinkedHashSet<Statusupdate>(query.getResultList());
	}

	/**
	 * JPQL Query - findStatusupdateByStatusUpdateDesc
	 *
	 */
	@Transactional
	public Set<Statusupdate> findStatusupdateByStatusUpdateDesc(String statusUpdateDesc) throws DataAccessException {

		return findStatusupdateByStatusUpdateDesc(statusUpdateDesc, -1, -1);
	}

	/**
	 * JPQL Query - findStatusupdateByStatusUpdateDesc
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Statusupdate> findStatusupdateByStatusUpdateDesc(String statusUpdateDesc, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStatusupdateByStatusUpdateDesc", startResult, maxRows, statusUpdateDesc);
		return new LinkedHashSet<Statusupdate>(query.getResultList());
	}

	/**
	 * JPQL Query - findStatusupdateByStatusId
	 *
	 */
	@Transactional
	public Statusupdate findStatusupdateByStatusId(Integer statusId) throws DataAccessException {

		return findStatusupdateByStatusId(statusId, -1, -1);
	}

	/**
	 * JPQL Query - findStatusupdateByStatusId
	 *
	 */

	@Transactional
	public Statusupdate findStatusupdateByStatusId(Integer statusId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findStatusupdateByStatusId", startResult, maxRows, statusId);
			return (pm7.domain.Statusupdate) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findStatusupdateByStatusDate
	 *
	 */
	@Transactional
	public Set<Statusupdate> findStatusupdateByStatusDate(java.util.Calendar statusDate) throws DataAccessException {

		return findStatusupdateByStatusDate(statusDate, -1, -1);
	}

	/**
	 * JPQL Query - findStatusupdateByStatusDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Statusupdate> findStatusupdateByStatusDate(java.util.Calendar statusDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStatusupdateByStatusDate", startResult, maxRows, statusDate);
		return new LinkedHashSet<Statusupdate>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Statusupdate entity) {
		return true;
	}
	
	public Integer getMaxStatusupdateId() {
		Object obj = executeQuerySingleResult("select max(statusId) from Statusupdate");
		return (Integer)obj;
	}
}
