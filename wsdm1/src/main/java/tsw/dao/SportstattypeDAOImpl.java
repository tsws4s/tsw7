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

import tsw.domain.Sportstattype;

/**
 * DAO to manage Sportstattype entities.
 * 
 */
@Repository("SportstattypeDAO")
@Transactional
public class SportstattypeDAOImpl extends AbstractJpaDao<Sportstattype>
		implements SportstattypeDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Sportstattype.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_tsw
	 *
	 */
	@PersistenceContext(unitName = "tsws4s_4")
	private EntityManager entityManager;

	/**
	 * Instantiates a new SportstattypeDAOImpl
	 *
	 */
	public SportstattypeDAOImpl() {
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
	 * JPQL Query - findSportstattypeBySportStatTypeId
	 *
	 */
	@Transactional
	public Sportstattype findSportstattypeBySportStatTypeId(Integer sportStatTypeId) throws DataAccessException {

		return findSportstattypeBySportStatTypeId(sportStatTypeId, -1, -1);
	}

	/**
	 * JPQL Query - findSportstattypeBySportStatTypeId
	 *
	 */

	@Transactional
	public Sportstattype findSportstattypeBySportStatTypeId(Integer sportStatTypeId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findSportstattypeBySportStatTypeId", startResult, maxRows, sportStatTypeId);
			return (tsw.domain.Sportstattype) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findSportstattypeBySportStatTypeName
	 *
	 */
	@Transactional
	public Set<Sportstattype> findSportstattypeBySportStatTypeName(String sportStatTypeName) throws DataAccessException {

		return findSportstattypeBySportStatTypeName(sportStatTypeName, -1, -1);
	}

	/**
	 * JPQL Query - findSportstattypeBySportStatTypeName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Sportstattype> findSportstattypeBySportStatTypeName(String sportStatTypeName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSportstattypeBySportStatTypeName", startResult, maxRows, sportStatTypeName);
		return new LinkedHashSet<Sportstattype>(query.getResultList());
	}

	/**
	 * JPQL Query - findSportstattypeBySportStatTypeNameContaining
	 *
	 */
	@Transactional
	public Set<Sportstattype> findSportstattypeBySportStatTypeNameContaining(String sportStatTypeName) throws DataAccessException {

		return findSportstattypeBySportStatTypeNameContaining(sportStatTypeName, -1, -1);
	}

	/**
	 * JPQL Query - findSportstattypeBySportStatTypeNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Sportstattype> findSportstattypeBySportStatTypeNameContaining(String sportStatTypeName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSportstattypeBySportStatTypeNameContaining", startResult, maxRows, sportStatTypeName);
		return new LinkedHashSet<Sportstattype>(query.getResultList());
	}

	/**
	 * JPQL Query - findSportstattypeByPrimaryKey
	 *
	 */
	@Transactional
	public Sportstattype findSportstattypeByPrimaryKey(Integer sportStatTypeId) throws DataAccessException {

		return findSportstattypeByPrimaryKey(sportStatTypeId, -1, -1);
	}

	/**
	 * JPQL Query - findSportstattypeByPrimaryKey
	 *
	 */

	@Transactional
	public Sportstattype findSportstattypeByPrimaryKey(Integer sportStatTypeId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findSportstattypeByPrimaryKey", startResult, maxRows, sportStatTypeId);
			return (tsw.domain.Sportstattype) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAllSportstattypes
	 *
	 */
	@Transactional
	public Set<Sportstattype> findAllSportstattypes() throws DataAccessException {

		return findAllSportstattypes(-1, -1);
	}

	/**
	 * JPQL Query - findAllSportstattypes
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Sportstattype> findAllSportstattypes(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllSportstattypes", startResult, maxRows);
		return new LinkedHashSet<Sportstattype>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Sportstattype entity) {
		return true;
	}
}
