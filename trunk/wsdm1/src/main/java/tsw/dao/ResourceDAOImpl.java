package tsw.dao;

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

import tsw.domain.Resource;
import tsw.domain.Tswacct;
import tsw.service.UsersController;

/**
 * DAO to manage Resource entities.
 * 
 */
@Repository("ResourceDAO")
@Transactional
public class ResourceDAOImpl extends AbstractJpaDao<Resource> implements
		ResourceDAO {
	
	int defaultMaxRows = UsersController.getDefaultMaxRows();

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Resource.class }));

	/**
	 * EntityManager injected by Spring for persistence unit tsws4s_4
	 *
	 */
	@PersistenceContext(unitName = "tsws4s_4")
	private EntityManager entityManager;

	/**
	 * Instantiates a new ResourceDAOImpl
	 *
	 */
	public ResourceDAOImpl() {
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
	 * JPQL Query - findResourceByResourceType
	 *
	 */
	@Transactional
	public Set<Resource> findResourceByResourceType(String resourceType) throws DataAccessException {

		return findResourceByResourceType(resourceType, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findResourceByResourceType
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Resource> findResourceByResourceType(String resourceType, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findResourceByResourceType", startResult, maxRows, resourceType);
		return new LinkedHashSet<Resource>(query.getResultList());
	}

	/**
	 * JPQL Query - findResourceByPrimaryKey
	 *
	 */
	@Transactional
	public Resource findResourceByPrimaryKey(Integer resourceId) throws DataAccessException {

		return findResourceByPrimaryKey(resourceId, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findResourceByPrimaryKey
	 *
	 */

	@Transactional
	public Resource findResourceByPrimaryKey(Integer resourceId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findResourceByPrimaryKey", startResult, maxRows, resourceId);
			return (tsw.domain.Resource) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findResourceByResourceTypeContaining
	 *
	 */
	@Transactional
	public Set<Resource> findResourceByResourceTypeContaining(String resourceType) throws DataAccessException {

		return findResourceByResourceTypeContaining(resourceType, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findResourceByResourceTypeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Resource> findResourceByResourceTypeContaining(String resourceType, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findResourceByResourceTypeContaining", startResult, maxRows, resourceType);
		return new LinkedHashSet<Resource>(query.getResultList());
	}

	/**
	 * JPQL Query - findResourceByResourceNameContaining
	 *
	 */
	@Transactional
	public Set<Resource> findResourceByResourceNameContaining(String resourceName) throws DataAccessException {

		return findResourceByResourceNameContaining(resourceName, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findResourceByResourceNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Resource> findResourceByResourceNameContaining(String resourceName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findResourceByResourceNameContaining", startResult, maxRows, resourceName);
		return new LinkedHashSet<Resource>(query.getResultList());
	}

	/**
	 * JPQL Query - findResourceByNotes
	 *
	 */
	@Transactional
	public Set<Resource> findResourceByNotes(String notes) throws DataAccessException {

		return findResourceByNotes(notes, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findResourceByNotes
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Resource> findResourceByNotes(String notes, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findResourceByNotes", startResult, maxRows, notes);
		return new LinkedHashSet<Resource>(query.getResultList());
	}

	/**
	 * JPQL Query - findResourceByResourceId
	 *
	 */
	@Transactional
	public Resource findResourceByResourceId(Integer resourceId) throws DataAccessException {

		return findResourceByResourceId(resourceId, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findResourceByResourceId
	 *
	 */

	@Transactional
	public Resource findResourceByResourceId(Integer resourceId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findResourceByResourceId", startResult, maxRows, resourceId);
			return (tsw.domain.Resource) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAllResources
	 *
	 */
	@Transactional
	public Set<Resource> findAllResources4tsw(Integer tswId) throws DataAccessException {

		return findAllResources4tsw(tswId, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findAllResources
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Resource> findAllResources4tsw(Integer tswId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllResources4tsw", startResult, maxRows, tswId);
		if(startResult>0){
			query.setFirstResult(startResult);
		}
		query.setMaxResults(maxRows);
		return new LinkedHashSet<Resource>(query.getResultList());
	}

	/**
	 * JPQL Query - findResourceByNotesContaining
	 *
	 */
	@Transactional
	public Set<Resource> findResourceByNotesContaining(String notes) throws DataAccessException {

		return findResourceByNotesContaining(notes, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findResourceByNotesContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Resource> findResourceByNotesContaining(String notes, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findResourceByNotesContaining", startResult, maxRows, notes);
		return new LinkedHashSet<Resource>(query.getResultList());
	}

	/**
	 * JPQL Query - findResourceByResourceName
	 *
	 */
	@Transactional
	public Resource findResourceByResourceName(Tswacct tswacct, String resourceName) throws DataAccessException {

		return findResourceByResourceName(tswacct, resourceName, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findResourceByResourceName
	 *
	 */

	@Transactional
	public Resource findResourceByResourceName(Tswacct tswacct, String resourceName, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findResourceByResourceName", startResult, maxRows, tswacct, resourceName);
			return (tsw.domain.Resource) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}
	
	/**
	 * JPQL Query - findResourceByActiveYn
	 *
	 */
	@Transactional
	public Set<Resource> findResourceByActiveYn(Integer activeYn) throws DataAccessException {

		return findResourceByActiveYn(activeYn, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findResourceByActiveYn
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Resource> findResourceByActiveYn(Integer activeYn, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findResourceByActiveYn", startResult, maxRows, activeYn);
		return new LinkedHashSet<Resource>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Resource entity) {
		return true;
	}
	@Override
	public Integer getMaxResourceID() {
		Object obj = executeQuerySingleResult("select max(resourceId) from Resource");
		return (Integer)obj;
	}
}
