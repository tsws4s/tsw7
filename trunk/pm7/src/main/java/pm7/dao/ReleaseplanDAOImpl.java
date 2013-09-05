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

import pm7.domain.Releaseplan;

/**
 * DAO to manage Releaseplan entities.
 * 
 */
@Repository("ReleaseplanDAO")
@Transactional
public class ReleaseplanDAOImpl extends AbstractJpaDao<Releaseplan> implements
		ReleaseplanDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Releaseplan.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mySql_pm7
	 *
	 */
	@PersistenceContext(unitName = "mySql_pm7")
	private EntityManager entityManager;

	/**
	 * Instantiates a new ReleaseplanDAOImpl
	 *
	 */
	public ReleaseplanDAOImpl() {
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
	 * JPQL Query - findReleaseplanByReleaseCode
	 *
	 */
	@Transactional
	public Set<Releaseplan> findReleaseplanByReleaseCode(String releaseCode) throws DataAccessException {

		return findReleaseplanByReleaseCode(releaseCode, -1, -1);
	}

	/**
	 * JPQL Query - findReleaseplanByReleaseCode
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Releaseplan> findReleaseplanByReleaseCode(String releaseCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findReleaseplanByReleaseCode", startResult, maxRows, releaseCode);
		return new LinkedHashSet<Releaseplan>(query.getResultList());
	}

	/**
	 * JPQL Query - findReleaseplanByReleaseDateBefore
	 *
	 */
	@Transactional
	public Set<Releaseplan> findReleaseplanByReleaseDateBefore(java.util.Calendar releaseDate) throws DataAccessException {

		return findReleaseplanByReleaseDateBefore(releaseDate, -1, -1);
	}

	/**
	 * JPQL Query - findReleaseplanByReleaseDateBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Releaseplan> findReleaseplanByReleaseDateBefore(java.util.Calendar releaseDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findReleaseplanByReleaseDateBefore", startResult, maxRows, releaseDate);
		return new LinkedHashSet<Releaseplan>(query.getResultList());
	}

	/**
	 * JPQL Query - findReleaseplanByReleaseDateAfter
	 *
	 */
	@Transactional
	public Set<Releaseplan> findReleaseplanByReleaseDateAfter(java.util.Calendar releaseDate) throws DataAccessException {

		return findReleaseplanByReleaseDateAfter(releaseDate, -1, -1);
	}

	/**
	 * JPQL Query - findReleaseplanByReleaseDateAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Releaseplan> findReleaseplanByReleaseDateAfter(java.util.Calendar releaseDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findReleaseplanByReleaseDateAfter", startResult, maxRows, releaseDate);
		return new LinkedHashSet<Releaseplan>(query.getResultList());
	}

	/**
	 * JPQL Query - findReleaseplanByReleaseDescriptionContaining
	 *
	 */
	@Transactional
	public Set<Releaseplan> findReleaseplanByReleaseDescriptionContaining(String releaseDescription) throws DataAccessException {

		return findReleaseplanByReleaseDescriptionContaining(releaseDescription, -1, -1);
	}

	/**
	 * JPQL Query - findReleaseplanByReleaseDescriptionContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Releaseplan> findReleaseplanByReleaseDescriptionContaining(String releaseDescription, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findReleaseplanByReleaseDescriptionContaining", startResult, maxRows, releaseDescription);
		return new LinkedHashSet<Releaseplan>(query.getResultList());
	}

	/**
	 * JPQL Query - findReleaseplanByReleaseDescription
	 *
	 */
	@Transactional
	public Set<Releaseplan> findReleaseplanByReleaseDescription(String releaseDescription) throws DataAccessException {

		return findReleaseplanByReleaseDescription(releaseDescription, -1, -1);
	}

	/**
	 * JPQL Query - findReleaseplanByReleaseDescription
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Releaseplan> findReleaseplanByReleaseDescription(String releaseDescription, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findReleaseplanByReleaseDescription", startResult, maxRows, releaseDescription);
		return new LinkedHashSet<Releaseplan>(query.getResultList());
	}

	/**
	 * JPQL Query - findReleaseplanByReleaseId
	 *
	 */
	@Transactional
	public Releaseplan findReleaseplanByReleaseId(Integer releaseId) throws DataAccessException {

		return findReleaseplanByReleaseId(releaseId, -1, -1);
	}

	/**
	 * JPQL Query - findReleaseplanByReleaseId
	 *
	 */

	@Transactional
	public Releaseplan findReleaseplanByReleaseId(Integer releaseId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findReleaseplanByReleaseId", startResult, maxRows, releaseId);
			return (pm7.domain.Releaseplan) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findReleaseplanByPrimaryKey
	 *
	 */
	@Transactional
	public Releaseplan findReleaseplanByPrimaryKey(Integer releaseId) throws DataAccessException {

		return findReleaseplanByPrimaryKey(releaseId, -1, -1);
	}

	/**
	 * JPQL Query - findReleaseplanByPrimaryKey
	 *
	 */

	@Transactional
	public Releaseplan findReleaseplanByPrimaryKey(Integer releaseId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findReleaseplanByPrimaryKey", startResult, maxRows, releaseId);
			return (pm7.domain.Releaseplan) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findReleaseplanByReleaseDate
	 *
	 */
	@Transactional
	public Set<Releaseplan> findReleaseplanByReleaseDate(java.util.Calendar releaseDate) throws DataAccessException {

		return findReleaseplanByReleaseDate(releaseDate, -1, -1);
	}

	/**
	 * JPQL Query - findReleaseplanByReleaseDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Releaseplan> findReleaseplanByReleaseDate(java.util.Calendar releaseDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findReleaseplanByReleaseDate", startResult, maxRows, releaseDate);
		return new LinkedHashSet<Releaseplan>(query.getResultList());
	}

	/**
	 * JPQL Query - findReleaseplanByReleaseName
	 *
	 */
	@Transactional
	public Set<Releaseplan> findReleaseplanByReleaseName(String releaseName) throws DataAccessException {

		return findReleaseplanByReleaseName(releaseName, -1, -1);
	}

	/**
	 * JPQL Query - findReleaseplanByReleaseName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Releaseplan> findReleaseplanByReleaseName(String releaseName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findReleaseplanByReleaseName", startResult, maxRows, releaseName);
		return new LinkedHashSet<Releaseplan>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllReleaseplans
	 *
	 */
	@Transactional
	public Set<Releaseplan> findAllReleaseplans() throws DataAccessException {

		return findAllReleaseplans(-1, -1);
	}

	/**
	 * JPQL Query - findAllReleaseplans
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Releaseplan> findAllReleaseplans(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllReleaseplans", startResult, maxRows);
		return new LinkedHashSet<Releaseplan>(query.getResultList());
	}

	/**
	 * JPQL Query - findReleaseplanByReleaseNameContaining
	 *
	 */
	@Transactional
	public Set<Releaseplan> findReleaseplanByReleaseNameContaining(String releaseName) throws DataAccessException {

		return findReleaseplanByReleaseNameContaining(releaseName, -1, -1);
	}

	/**
	 * JPQL Query - findReleaseplanByReleaseNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Releaseplan> findReleaseplanByReleaseNameContaining(String releaseName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findReleaseplanByReleaseNameContaining", startResult, maxRows, releaseName);
		return new LinkedHashSet<Releaseplan>(query.getResultList());
	}

	/**
	 * JPQL Query - findReleaseplanByReleaseCodeContaining
	 *
	 */
	@Transactional
	public Set<Releaseplan> findReleaseplanByReleaseCodeContaining(String releaseCode) throws DataAccessException {

		return findReleaseplanByReleaseCodeContaining(releaseCode, -1, -1);
	}

	/**
	 * JPQL Query - findReleaseplanByReleaseCodeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Releaseplan> findReleaseplanByReleaseCodeContaining(String releaseCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findReleaseplanByReleaseCodeContaining", startResult, maxRows, releaseCode);
		return new LinkedHashSet<Releaseplan>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Releaseplan entity) {
		return true;
	}
	
	public Integer getMaxReleaseplanId() {
		Object obj = executeQuerySingleResult("select max(releaseId) from Releaseplan");
		if(obj!=null){
			return (Integer)obj;
		}
		return 0;
	}
}
