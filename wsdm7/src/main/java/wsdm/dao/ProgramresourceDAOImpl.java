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

import wsdm.domain.Programresource;

/**
 * DAO to manage Programresource entities.
 * 
 */
@Repository("ProgramresourceDAO")
@Transactional
public class ProgramresourceDAOImpl extends AbstractJpaDao<Programresource>
		implements ProgramresourceDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Programresource.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_tsw
	 *
	 */
	@PersistenceContext(unitName = "mysql_tsw")
	private EntityManager entityManager;

	/**
	 * Instantiates a new ProgramresourceDAOImpl
	 *
	 */
	public ProgramresourceDAOImpl() {
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
	 * JPQL Query - findProgramresourceByResourcePriceFk
	 *
	 */
	@Transactional
	public Set<Programresource> findProgramresourceByResourcePriceFk(Integer resourcePriceFk) throws DataAccessException {

		return findProgramresourceByResourcePriceFk(resourcePriceFk, -1, -1);
	}

	/**
	 * JPQL Query - findProgramresourceByResourcePriceFk
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Programresource> findProgramresourceByResourcePriceFk(Integer resourcePriceFk, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProgramresourceByResourcePriceFk", startResult, maxRows, resourcePriceFk);
		return new LinkedHashSet<Programresource>(query.getResultList());
	}

	/**
	 * JPQL Query - findProgramresourceByPrimaryKey
	 *
	 */
	@Transactional
	public Programresource findProgramresourceByPrimaryKey(Integer programResourceId) throws DataAccessException {

		return findProgramresourceByPrimaryKey(programResourceId, -1, -1);
	}

	/**
	 * JPQL Query - findProgramresourceByPrimaryKey
	 *
	 */

	@Transactional
	public Programresource findProgramresourceByPrimaryKey(Integer programResourceId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findProgramresourceByPrimaryKey", startResult, maxRows, programResourceId);
			return (wsdm.domain.Programresource) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findProgramresourceByResourceFk
	 *
	 */
	@Transactional
	public Set<Programresource> findProgramresourceByResourceFk(Integer resourceFk) throws DataAccessException {

		return findProgramresourceByResourceFk(resourceFk, -1, -1);
	}

	/**
	 * JPQL Query - findProgramresourceByResourceFk
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Programresource> findProgramresourceByResourceFk(Integer resourceFk, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProgramresourceByResourceFk", startResult, maxRows, resourceFk);
		return new LinkedHashSet<Programresource>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllProgramresources
	 *
	 */
	@Transactional
	public Set<Programresource> findAllProgramresources() throws DataAccessException {

		return findAllProgramresources(-1, -1);
	}

	/**
	 * JPQL Query - findAllProgramresources
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Programresource> findAllProgramresources(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllProgramresources", startResult, maxRows);
		return new LinkedHashSet<Programresource>(query.getResultList());
	}

	/**
	 * JPQL Query - findProgramresourceByProgramResourceId
	 *
	 */
	@Transactional
	public Programresource findProgramresourceByProgramResourceId(Integer programResourceId) throws DataAccessException {

		return findProgramresourceByProgramResourceId(programResourceId, -1, -1);
	}

	/**
	 * JPQL Query - findProgramresourceByProgramResourceId
	 *
	 */

	@Transactional
	public Programresource findProgramresourceByProgramResourceId(Integer programResourceId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findProgramresourceByProgramResourceId", startResult, maxRows, programResourceId);
			return (wsdm.domain.Programresource) query.getSingleResult();
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
	public boolean canBeMerged(Programresource entity) {
		return true;
	}
}
