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

import pm7.domain.Authority;

/**
 * DAO to manage Authority entities.
 * 
 */
@Repository("AuthorityDAO")
@Transactional
public class AuthorityDAOImpl extends AbstractJpaDao<Authority> implements
		AuthorityDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Authority.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mySql_pm7
	 *
	 */
	@PersistenceContext(unitName = "mySql_pm7")
	private EntityManager entityManager;

	/**
	 * Instantiates a new AuthorityDAOImpl
	 *
	 */
	public AuthorityDAOImpl() {
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
	 * JPQL Query - findAuthorityByAuthorityName
	 *
	 */
	@Transactional
	public Set<Authority> findAuthorityByAuthorityName(String authorityName) throws DataAccessException {

		return findAuthorityByAuthorityName(authorityName, -1, -1);
	}

	/**
	 * JPQL Query - findAuthorityByAuthorityName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Authority> findAuthorityByAuthorityName(String authorityName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAuthorityByAuthorityName", startResult, maxRows, authorityName);
		return new LinkedHashSet<Authority>(query.getResultList());
	}

	/**
	 * JPQL Query - findAuthorityByAuthorityId
	 *
	 */
	@Transactional
	public Authority findAuthorityByAuthorityId(Integer authorityId) throws DataAccessException {

		return findAuthorityByAuthorityId(authorityId, -1, -1);
	}

	/**
	 * JPQL Query - findAuthorityByAuthorityId
	 *
	 */

	@Transactional
	public Authority findAuthorityByAuthorityId(Integer authorityId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAuthorityByAuthorityId", startResult, maxRows, authorityId);
			return (pm7.domain.Authority) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAuthorityByPrimaryKey
	 *
	 */
	@Transactional
	public Authority findAuthorityByPrimaryKey(Integer authorityId) throws DataAccessException {

		return findAuthorityByPrimaryKey(authorityId, -1, -1);
	}

	/**
	 * JPQL Query - findAuthorityByPrimaryKey
	 *
	 */

	@Transactional
	public Authority findAuthorityByPrimaryKey(Integer authorityId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAuthorityByPrimaryKey", startResult, maxRows, authorityId);
			return (pm7.domain.Authority) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAllAuthoritys
	 *
	 */
	@Transactional
	public Set<Authority> findAllAuthoritys() throws DataAccessException {

		return findAllAuthoritys(-1, -1);
	}

	/**
	 * JPQL Query - findAllAuthoritys
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Authority> findAllAuthoritys(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllAuthoritys", startResult, maxRows);
		return new LinkedHashSet<Authority>(query.getResultList());
	}

	/**
	 * JPQL Query - findAuthorityByAuthorityNameContaining
	 *
	 */
	@Transactional
	public Set<Authority> findAuthorityByAuthorityNameContaining(String authorityName) throws DataAccessException {

		return findAuthorityByAuthorityNameContaining(authorityName, -1, -1);
	}

	/**
	 * JPQL Query - findAuthorityByAuthorityNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Authority> findAuthorityByAuthorityNameContaining(String authorityName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAuthorityByAuthorityNameContaining", startResult, maxRows, authorityName);
		return new LinkedHashSet<Authority>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Authority entity) {
		return true;
	}
	
	public Integer getMaxAuthorityId() {
		Object obj = executeQuerySingleResult("select max(authorityId) from Authority");
		return (Integer)obj;
	}
}
