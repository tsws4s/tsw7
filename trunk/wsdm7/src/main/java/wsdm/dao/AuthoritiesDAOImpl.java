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

import wsdm.domain.Authorities;

/**
 * DAO to manage Authorities entities.
 * 
 */
@Repository("AuthoritiesDAO")
@Transactional
public class AuthoritiesDAOImpl extends AbstractJpaDao<Authorities> implements
		AuthoritiesDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Authorities.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_tsw
	 *
	 */
	@PersistenceContext(unitName = "mysql_tsw")
	private EntityManager entityManager;

	/**
	 * Instantiates a new AuthoritiesDAOImpl
	 *
	 */
	public AuthoritiesDAOImpl() {
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
	 * JPQL Query - findAuthoritiesByAuthorityContaining
	 *
	 */
	@Transactional
	public Set<Authorities> findAuthoritiesByAuthorityContaining(String authority) throws DataAccessException {

		return findAuthoritiesByAuthorityContaining(authority, -1, -1);
	}

	/**
	 * JPQL Query - findAuthoritiesByAuthorityContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Authorities> findAuthoritiesByAuthorityContaining(String authority, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAuthoritiesByAuthorityContaining", startResult, maxRows, authority);
		return new LinkedHashSet<Authorities>(query.getResultList());
	}

	/**
	 * JPQL Query - findAuthoritiesByPrimaryKey
	 *
	 */
	@Transactional
	public Authorities findAuthoritiesByPrimaryKey(Integer authorityId) throws DataAccessException {

		return findAuthoritiesByPrimaryKey(authorityId, -1, -1);
	}

	/**
	 * JPQL Query - findAuthoritiesByPrimaryKey
	 *
	 */

	@Transactional
	public Authorities findAuthoritiesByPrimaryKey(Integer authorityId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAuthoritiesByPrimaryKey", startResult, maxRows, authorityId);
			return (wsdm.domain.Authorities) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAuthoritiesByUsernameContaining
	 *
	 */
	@Transactional
	public Set<Authorities> findAuthoritiesByUsernameContaining(String username) throws DataAccessException {

		return findAuthoritiesByUsernameContaining(username, -1, -1);
	}

	/**
	 * JPQL Query - findAuthoritiesByUsernameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Authorities> findAuthoritiesByUsernameContaining(String username, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAuthoritiesByUsernameContaining", startResult, maxRows, username);
		return new LinkedHashSet<Authorities>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllAuthoritiess
	 *
	 */
	@Transactional
	public Set<Authorities> findAllAuthoritiess() throws DataAccessException {

		return findAllAuthoritiess(-1, -1);
	}

	/**
	 * JPQL Query - findAllAuthoritiess
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Authorities> findAllAuthoritiess(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllAuthoritiess", startResult, maxRows);
		return new LinkedHashSet<Authorities>(query.getResultList());
	}

	/**
	 * JPQL Query - findAuthoritiesByUsername
	 *
	 */
	@Transactional
	public Set<Authorities> findAuthoritiesByUsername(String username) throws DataAccessException {

		return findAuthoritiesByUsername(username, -1, -1);
	}

	/**
	 * JPQL Query - findAuthoritiesByUsername
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Authorities> findAuthoritiesByUsername(String username, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAuthoritiesByUsername", startResult, maxRows, username);
		return new LinkedHashSet<Authorities>(query.getResultList());
	}

	/**
	 * JPQL Query - findAuthoritiesByAuthorityName
	 *
	 */
	@Transactional
	public Set<Authorities> findAuthoritiesByAuthorityName(String authorityName) throws DataAccessException {

		return findAuthoritiesByAuthorityName(authorityName, -1, -1);
	}

	/**
	 * JPQL Query - findAuthoritiesByAuthorityName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Authorities> findAuthoritiesByAuthorityName(String authorityName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAuthoritiesByAuthorityName", startResult, maxRows, authorityName);
		return new LinkedHashSet<Authorities>(query.getResultList());
	}

	/**
	 * JPQL Query - findAuthoritiesById
	 *
	 */
	@Transactional
	public Set<Authorities> findAuthoritiesById(String id) throws DataAccessException {

		return findAuthoritiesById(id, -1, -1);
	}

	/**
	 * JPQL Query - findAuthoritiesById
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Authorities> findAuthoritiesById(String id, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAuthoritiesById", startResult, maxRows, id);
		return new LinkedHashSet<Authorities>(query.getResultList());
	}

	/**
	 * JPQL Query - findAuthoritiesByAuthorityId
	 *
	 */
	@Transactional
	public Authorities findAuthoritiesByAuthorityId(Integer authorityId) throws DataAccessException {

		return findAuthoritiesByAuthorityId(authorityId, -1, -1);
	}

	/**
	 * JPQL Query - findAuthoritiesByAuthorityId
	 *
	 */

	@Transactional
	public Authorities findAuthoritiesByAuthorityId(Integer authorityId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAuthoritiesByAuthorityId", startResult, maxRows, authorityId);
			return (wsdm.domain.Authorities) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAuthoritiesByAuthority
	 *
	 */
	@Transactional
	public Set<Authorities> findAuthoritiesByAuthority(String authority) throws DataAccessException {

		return findAuthoritiesByAuthority(authority, -1, -1);
	}

	/**
	 * JPQL Query - findAuthoritiesByAuthority
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Authorities> findAuthoritiesByAuthority(String authority, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAuthoritiesByAuthority", startResult, maxRows, authority);
		return new LinkedHashSet<Authorities>(query.getResultList());
	}

	/**
	 * JPQL Query - findAuthoritiesByAuthorityNameContaining
	 *
	 */
	@Transactional
	public Set<Authorities> findAuthoritiesByAuthorityNameContaining(String authorityName) throws DataAccessException {

		return findAuthoritiesByAuthorityNameContaining(authorityName, -1, -1);
	}

	/**
	 * JPQL Query - findAuthoritiesByAuthorityNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Authorities> findAuthoritiesByAuthorityNameContaining(String authorityName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAuthoritiesByAuthorityNameContaining", startResult, maxRows, authorityName);
		return new LinkedHashSet<Authorities>(query.getResultList());
	}

	/**
	 * JPQL Query - findAuthoritiesByIdContaining
	 *
	 */
	@Transactional
	public Set<Authorities> findAuthoritiesByIdContaining(String id) throws DataAccessException {

		return findAuthoritiesByIdContaining(id, -1, -1);
	}

	/**
	 * JPQL Query - findAuthoritiesByIdContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Authorities> findAuthoritiesByIdContaining(String id, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAuthoritiesByIdContaining", startResult, maxRows, id);
		return new LinkedHashSet<Authorities>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Authorities entity) {
		return true;
	}
}
