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

import tsw.domain.Authorities;
import tsw.web.UsersController;

/**
 * DAO to manage Authorities entities.
 * 
 */
@Repository("AuthoritiesDAO")
@Transactional
public class AuthoritiesDAOImpl extends AbstractJpaDao<Authorities> implements
		AuthoritiesDAO {
	
	int defaultMaxRows = UsersController.getDefaultMaxRows();

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Authorities.class }));

	/**
	 * EntityManager injected by Spring for persistence unit tsws4s_4
	 *
	 */
	@PersistenceContext(unitName = "tsws4s_4")
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
	 * JPQL Query - findAuthoritiesByAuthorityNameContaining
	 *
	 */
	@Transactional
	public Set<Authorities> findAuthoritiesByAuthorityNameContaining(String authorityName) throws DataAccessException {

		return findAuthoritiesByAuthorityNameContaining(authorityName, -1, defaultMaxRows);
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
	 * JPQL Query - findAuthoritiesByAuthorityId
	 *
	 */
	@Transactional
	public Authorities findAuthoritiesByAuthorityId(Integer authorityId) throws DataAccessException {

		return findAuthoritiesByAuthorityId(authorityId, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findAuthoritiesByAuthorityId
	 *
	 */

	@Transactional
	public Authorities findAuthoritiesByAuthorityId(Integer authorityId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAuthoritiesByAuthorityId", startResult, maxRows, authorityId);
			return (tsw.domain.Authorities) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAuthoritiesByPrimaryKey
	 *
	 */
	@Transactional
	public Authorities findAuthoritiesByPrimaryKey(Integer authorityId) throws DataAccessException {

		return findAuthoritiesByPrimaryKey(authorityId, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findAuthoritiesByPrimaryKey
	 *
	 */

	@Transactional
	public Authorities findAuthoritiesByPrimaryKey(Integer authorityId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAuthoritiesByPrimaryKey", startResult, maxRows, authorityId);
			return (tsw.domain.Authorities) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAuthoritiesByAuthorityName
	 *
	 */
	@Transactional
	public Set<Authorities> findAuthoritiesByAuthorityName(String authorityName) throws DataAccessException {

		return findAuthoritiesByAuthorityName(authorityName, -1, defaultMaxRows);
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
	 * JPQL Query - findAllAuthoritiess
	 *
	 */
	@Transactional
	public Set<Authorities> findAllAuthoritiess() throws DataAccessException {

		return findAllAuthoritiess(-1, defaultMaxRows);
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
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Authorities entity) {
		return true;
	}
	
	@Override
	public Integer getMaxAuthorityID() {
		Object obj = executeQuerySingleResult("select max(authorityId) from Authorities");
		return (Integer)obj;
	}
}
