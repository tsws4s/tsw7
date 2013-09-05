package tsw.dao;

import tsw.domain.GenGame;

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

/**
 * DAO to manage GenGame entities.
 * 
 */
@Repository("GengameDAO")
@Transactional
public class GengameDAOImpl extends AbstractJpaDao<GenGame> implements
		GengameDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { GenGame.class }));

	/**
	 * EntityManager injected by Spring for persistence unit tsws4s_4
	 *
	 */
	@PersistenceContext(unitName = "tsws4s_4")
	private EntityManager entityManager;

	/**
	 * Instantiates a new GengameDAOImpl
	 *
	 */
	public GengameDAOImpl() {
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
	 * JPQL Query - findGengameByVisitorTeamId
	 *
	 */
	@Transactional
	public Set<GenGame> findGengameByVisitorTeamId(Integer visitorTeamId) throws DataAccessException {

		return findGengameByVisitorTeamId(visitorTeamId, -1, -1);
	}

	/**
	 * JPQL Query - findGengameByVisitorTeamId
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<GenGame> findGengameByVisitorTeamId(Integer visitorTeamId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findGengameByVisitorTeamId", startResult, maxRows, visitorTeamId);
		return new LinkedHashSet<GenGame>(query.getResultList());
	}

	/**
	 * JPQL Query - findGengameByResourceNameContaining
	 *
	 */
	@Transactional
	public Set<GenGame> findGengameByResourceNameContaining(String resourceName) throws DataAccessException {

		return findGengameByResourceNameContaining(resourceName, -1, -1);
	}

	/**
	 * JPQL Query - findGengameByResourceNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<GenGame> findGengameByResourceNameContaining(String resourceName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findGengameByResourceNameContaining", startResult, maxRows, resourceName);
		return new LinkedHashSet<GenGame>(query.getResultList());
	}

	/**
	 * JPQL Query - findGengameByPrimaryKey
	 *
	 */
	@Transactional
	public GenGame findGengameByPrimaryKey(Integer genGameId) throws DataAccessException {

		return findGengameByPrimaryKey(genGameId, -1, -1);
	}

	/**
	 * JPQL Query - findGengameByPrimaryKey
	 *
	 */

	@Transactional
	public GenGame findGengameByPrimaryKey(Integer genGameId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findGengameByPrimaryKey", startResult, maxRows, genGameId);
			return (tsw.domain.GenGame) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findGengameByGenGameId
	 *
	 */
	@Transactional
	public GenGame findGengameByGenGameId(Integer genGameId) throws DataAccessException {

		return findGengameByGenGameId(genGameId, -1, -1);
	}

	/**
	 * JPQL Query - findGengameByGenGameId
	 *
	 */

	@Transactional
	public GenGame findGengameByGenGameId(Integer genGameId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findGengameByGenGameId", startResult, maxRows, genGameId);
			return (tsw.domain.GenGame) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findGengameByHomeTeamName
	 *
	 */
	@Transactional
	public Set<GenGame> findGengameByHomeTeamName(String homeTeamName) throws DataAccessException {

		return findGengameByHomeTeamName(homeTeamName, -1, -1);
	}

	/**
	 * JPQL Query - findGengameByHomeTeamName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<GenGame> findGengameByHomeTeamName(String homeTeamName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findGengameByHomeTeamName", startResult, maxRows, homeTeamName);
		return new LinkedHashSet<GenGame>(query.getResultList());
	}

	/**
	 * JPQL Query - findGengameByGameDateTime
	 *
	 */
	@Transactional
	public Set<GenGame> findGengameByGameDateTime(java.util.Calendar gameDateTime) throws DataAccessException {

		return findGengameByGameDateTime(gameDateTime, -1, -1);
	}

	/**
	 * JPQL Query - findGengameByGameDateTime
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<GenGame> findGengameByGameDateTime(java.util.Calendar gameDateTime, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findGengameByGameDateTime", startResult, maxRows, gameDateTime);
		return new LinkedHashSet<GenGame>(query.getResultList());
	}

	/**
	 * JPQL Query - findGengameByVisitorTeamName
	 *
	 */
	@Transactional
	public Set<GenGame> findGengameByVisitorTeamName(String visitorTeamName) throws DataAccessException {

		return findGengameByVisitorTeamName(visitorTeamName, -1, -1);
	}

	/**
	 * JPQL Query - findGengameByVisitorTeamName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<GenGame> findGengameByVisitorTeamName(String visitorTeamName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findGengameByVisitorTeamName", startResult, maxRows, visitorTeamName);
		return new LinkedHashSet<GenGame>(query.getResultList());
	}

	/**
	 * JPQL Query - findGengameByHomeTeamNameContaining
	 *
	 */
	@Transactional
	public Set<GenGame> findGengameByHomeTeamNameContaining(String homeTeamName) throws DataAccessException {

		return findGengameByHomeTeamNameContaining(homeTeamName, -1, -1);
	}

	/**
	 * JPQL Query - findGengameByHomeTeamNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<GenGame> findGengameByHomeTeamNameContaining(String homeTeamName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findGengameByHomeTeamNameContaining", startResult, maxRows, homeTeamName);
		return new LinkedHashSet<GenGame>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllGengames
	 *
	 */
	@Transactional
	public Set<GenGame> findAllGengames() throws DataAccessException {

		return findAllGengames(-1, -1);
	}

	/**
	 * JPQL Query - findAllGengames
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<GenGame> findAllGengames(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllGengames", startResult, maxRows);
		return new LinkedHashSet<GenGame>(query.getResultList());
	}

	/**
	 * JPQL Query - findGengameByHomeTeamId
	 *
	 */
	@Transactional
	public Set<GenGame> findGengameByHomeTeamId(Integer homeTeamId) throws DataAccessException {

		return findGengameByHomeTeamId(homeTeamId, -1, -1);
	}

	/**
	 * JPQL Query - findGengameByHomeTeamId
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<GenGame> findGengameByHomeTeamId(Integer homeTeamId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findGengameByHomeTeamId", startResult, maxRows, homeTeamId);
		return new LinkedHashSet<GenGame>(query.getResultList());
	}

	/**
	 * JPQL Query - findGengameByGameNum
	 *
	 */
	@Transactional
	public Set<GenGame> findGengameByGameNum(Integer gameNum) throws DataAccessException {

		return findGengameByGameNum(gameNum, -1, -1);
	}

	/**
	 * JPQL Query - findGengameByGameNum
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<GenGame> findGengameByGameNum(Integer gameNum, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findGengameByGameNum", startResult, maxRows, gameNum);
		return new LinkedHashSet<GenGame>(query.getResultList());
	}

	/**
	 * JPQL Query - findGengameByResourceId
	 *
	 */
	@Transactional
	public Set<GenGame> findGengameByResourceId(Integer resourceId) throws DataAccessException {

		return findGengameByResourceId(resourceId, -1, -1);
	}

	/**
	 * JPQL Query - findGengameByResourceId
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<GenGame> findGengameByResourceId(Integer resourceId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findGengameByResourceId", startResult, maxRows, resourceId);
		return new LinkedHashSet<GenGame>(query.getResultList());
	}

	/**
	 * JPQL Query - findGengameByRefereeNameContaining
	 *
	 */
	@Transactional
	public Set<GenGame> findGengameByRefereeNameContaining(String refereeName) throws DataAccessException {

		return findGengameByRefereeNameContaining(refereeName, -1, -1);
	}

	/**
	 * JPQL Query - findGengameByRefereeNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<GenGame> findGengameByRefereeNameContaining(String refereeName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findGengameByRefereeNameContaining", startResult, maxRows, refereeName);
		return new LinkedHashSet<GenGame>(query.getResultList());
	}

	/**
	 * JPQL Query - findGengameByRefereeName
	 *
	 */
	@Transactional
	public Set<GenGame> findGengameByRefereeName(String refereeName) throws DataAccessException {

		return findGengameByRefereeName(refereeName, -1, -1);
	}

	/**
	 * JPQL Query - findGengameByRefereeName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<GenGame> findGengameByRefereeName(String refereeName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findGengameByRefereeName", startResult, maxRows, refereeName);
		return new LinkedHashSet<GenGame>(query.getResultList());
	}

	/**
	 * JPQL Query - findGengameByResourceName
	 *
	 */
	@Transactional
	public Set<GenGame> findGengameByResourceName(String resourceName) throws DataAccessException {

		return findGengameByResourceName(resourceName, -1, -1);
	}

	/**
	 * JPQL Query - findGengameByResourceName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<GenGame> findGengameByResourceName(String resourceName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findGengameByResourceName", startResult, maxRows, resourceName);
		return new LinkedHashSet<GenGame>(query.getResultList());
	}

	/**
	 * JPQL Query - findGengameByVisitorTeamNameContaining
	 *
	 */
	@Transactional
	public Set<GenGame> findGengameByVisitorTeamNameContaining(String visitorTeamName) throws DataAccessException {

		return findGengameByVisitorTeamNameContaining(visitorTeamName, -1, -1);
	}

	/**
	 * JPQL Query - findGengameByVisitorTeamNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<GenGame> findGengameByVisitorTeamNameContaining(String visitorTeamName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findGengameByVisitorTeamNameContaining", startResult, maxRows, visitorTeamName);
		return new LinkedHashSet<GenGame>(query.getResultList());
	}

	/**
	 * JPQL Query - findGengameByRefereeId
	 *
	 */
	@Transactional
	public Set<GenGame> findGengameByRefereeId(Integer refereeId) throws DataAccessException {

		return findGengameByRefereeId(refereeId, -1, -1);
	}

	/**
	 * JPQL Query - findGengameByRefereeId
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<GenGame> findGengameByRefereeId(Integer refereeId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findGengameByRefereeId", startResult, maxRows, refereeId);
		return new LinkedHashSet<GenGame>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(GenGame entity) {
		return true;
	}
}
