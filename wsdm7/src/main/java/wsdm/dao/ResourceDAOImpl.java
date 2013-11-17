package wsdm.dao;

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

import wsdm.domain.Resource;

/**
 * DAO to manage Resource entities.
 * 
 */
@Repository("ResourceDAO")
@Transactional
public class ResourceDAOImpl extends AbstractJpaDao<Resource> implements
		ResourceDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Resource.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_tsw
	 *
	 */
	@PersistenceContext(unitName = "mysql_tsw")
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
	 * JPQL Query - findResourceByPrimaryKey
	 *
	 */
	@Transactional
	public Resource findResourceByPrimaryKey(Integer resourceId) throws DataAccessException {

		return findResourceByPrimaryKey(resourceId, -1, -1);
	}

	/**
	 * JPQL Query - findResourceByPrimaryKey
	 *
	 */

	@Transactional
	public Resource findResourceByPrimaryKey(Integer resourceId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findResourceByPrimaryKey", startResult, maxRows, resourceId);
			return (wsdm.domain.Resource) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAllResources
	 *
	 */
	@Transactional
	public Set<Resource> findAllResources() throws DataAccessException {

		return findAllResources(-1, -1);
	}

	/**
	 * JPQL Query - findAllResources
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Resource> findAllResources(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllResources", startResult, maxRows);
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
}
