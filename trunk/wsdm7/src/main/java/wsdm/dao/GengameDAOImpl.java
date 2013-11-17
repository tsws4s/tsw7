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

import wsdm.domain.Gengame;

/**
 * DAO to manage Gengame entities.
 * 
 */
@Repository("GengameDAO")
@Transactional
public class GengameDAOImpl extends AbstractJpaDao<Gengame> implements
		GengameDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Gengame.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_tsw
	 *
	 */
	@PersistenceContext(unitName = "mysql_tsw")
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
	 * JPQL Query - findGengameByPrimaryKey
	 *
	 */
	@Transactional
	public Gengame findGengameByPrimaryKey(Integer genGameId) throws DataAccessException {

		return findGengameByPrimaryKey(genGameId, -1, -1);
	}

	/**
	 * JPQL Query - findGengameByPrimaryKey
	 *
	 */

	@Transactional
	public Gengame findGengameByPrimaryKey(Integer genGameId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findGengameByPrimaryKey", startResult, maxRows, genGameId);
			return (wsdm.domain.Gengame) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findGengameByGameNum
	 *
	 */
	@Transactional
	public Set<Gengame> findGengameByGameNum(Integer gameNum) throws DataAccessException {

		return findGengameByGameNum(gameNum, -1, -1);
	}

	/**
	 * JPQL Query - findGengameByGameNum
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Gengame> findGengameByGameNum(Integer gameNum, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findGengameByGameNum", startResult, maxRows, gameNum);
		return new LinkedHashSet<Gengame>(query.getResultList());
	}

	/**
	 * JPQL Query - findGengameByGameDateTime
	 *
	 */
	@Transactional
	public Set<Gengame> findGengameByGameDateTime(java.util.Calendar gameDateTime) throws DataAccessException {

		return findGengameByGameDateTime(gameDateTime, -1, -1);
	}

	/**
	 * JPQL Query - findGengameByGameDateTime
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Gengame> findGengameByGameDateTime(java.util.Calendar gameDateTime, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findGengameByGameDateTime", startResult, maxRows, gameDateTime);
		return new LinkedHashSet<Gengame>(query.getResultList());
	}

	/**
	 * JPQL Query - findGengameByVisitorTeamName
	 *
	 */
	@Transactional
	public Set<Gengame> findGengameByVisitorTeamName(String visitorTeamName) throws DataAccessException {

		return findGengameByVisitorTeamName(visitorTeamName, -1, -1);
	}

	/**
	 * JPQL Query - findGengameByVisitorTeamName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Gengame> findGengameByVisitorTeamName(String visitorTeamName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findGengameByVisitorTeamName", startResult, maxRows, visitorTeamName);
		return new LinkedHashSet<Gengame>(query.getResultList());
	}

	/**
	 * JPQL Query - findGengameByHomeTeamNameContaining
	 *
	 */
	@Transactional
	public Set<Gengame> findGengameByHomeTeamNameContaining(String homeTeamName) throws DataAccessException {

		return findGengameByHomeTeamNameContaining(homeTeamName, -1, -1);
	}

	/**
	 * JPQL Query - findGengameByHomeTeamNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Gengame> findGengameByHomeTeamNameContaining(String homeTeamName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findGengameByHomeTeamNameContaining", startResult, maxRows, homeTeamName);
		return new LinkedHashSet<Gengame>(query.getResultList());
	}

	/**
	 * JPQL Query - findGengameByHomeTeamId
	 *
	 */
	@Transactional
	public Set<Gengame> findGengameByHomeTeamId(Integer homeTeamId) throws DataAccessException {

		return findGengameByHomeTeamId(homeTeamId, -1, -1);
	}

	/**
	 * JPQL Query - findGengameByHomeTeamId
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Gengame> findGengameByHomeTeamId(Integer homeTeamId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findGengameByHomeTeamId", startResult, maxRows, homeTeamId);
		return new LinkedHashSet<Gengame>(query.getResultList());
	}

	/**
	 * JPQL Query - findGengameByVisitorTeamId
	 *
	 */
	@Transactional
	public Set<Gengame> findGengameByVisitorTeamId(Integer visitorTeamId) throws DataAccessException {

		return findGengameByVisitorTeamId(visitorTeamId, -1, -1);
	}

	/**
	 * JPQL Query - findGengameByVisitorTeamId
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Gengame> findGengameByVisitorTeamId(Integer visitorTeamId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findGengameByVisitorTeamId", startResult, maxRows, visitorTeamId);
		return new LinkedHashSet<Gengame>(query.getResultList());
	}

	/**
	 * JPQL Query - findGengameByResourceId
	 *
	 */
	@Transactional
	public Set<Gengame> findGengameByResourceId(Integer resourceId) throws DataAccessException {

		return findGengameByResourceId(resourceId, -1, -1);
	}

	/**
	 * JPQL Query - findGengameByResourceId
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Gengame> findGengameByResourceId(Integer resourceId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findGengameByResourceId", startResult, maxRows, resourceId);
		return new LinkedHashSet<Gengame>(query.getResultList());
	}

	/**
	 * JPQL Query - findGengameByHomeTeamName
	 *
	 */
	@Transactional
	public Set<Gengame> findGengameByHomeTeamName(String homeTeamName) throws DataAccessException {

		return findGengameByHomeTeamName(homeTeamName, -1, -1);
	}

	/**
	 * JPQL Query - findGengameByHomeTeamName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Gengame> findGengameByHomeTeamName(String homeTeamName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findGengameByHomeTeamName", startResult, maxRows, homeTeamName);
		return new LinkedHashSet<Gengame>(query.getResultList());
	}

	/**
	 * JPQL Query - findGengameByVisitorTeamNameContaining
	 *
	 */
	@Transactional
	public Set<Gengame> findGengameByVisitorTeamNameContaining(String visitorTeamName) throws DataAccessException {

		return findGengameByVisitorTeamNameContaining(visitorTeamName, -1, -1);
	}

	/**
	 * JPQL Query - findGengameByVisitorTeamNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Gengame> findGengameByVisitorTeamNameContaining(String visitorTeamName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findGengameByVisitorTeamNameContaining", startResult, maxRows, visitorTeamName);
		return new LinkedHashSet<Gengame>(query.getResultList());
	}

	/**
	 * JPQL Query - findGengameByGenGameId
	 *
	 */
	@Transactional
	public Gengame findGengameByGenGameId(Integer genGameId) throws DataAccessException {

		return findGengameByGenGameId(genGameId, -1, -1);
	}

	/**
	 * JPQL Query - findGengameByGenGameId
	 *
	 */

	@Transactional
	public Gengame findGengameByGenGameId(Integer genGameId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findGengameByGenGameId", startResult, maxRows, genGameId);
			return (wsdm.domain.Gengame) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findGengameByResourceName
	 *
	 */
	@Transactional
	public Set<Gengame> findGengameByResourceName(String resourceName) throws DataAccessException {

		return findGengameByResourceName(resourceName, -1, -1);
	}

	/**
	 * JPQL Query - findGengameByResourceName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Gengame> findGengameByResourceName(String resourceName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findGengameByResourceName", startResult, maxRows, resourceName);
		return new LinkedHashSet<Gengame>(query.getResultList());
	}

	/**
	 * JPQL Query - findGengameByResourceNameContaining
	 *
	 */
	@Transactional
	public Set<Gengame> findGengameByResourceNameContaining(String resourceName) throws DataAccessException {

		return findGengameByResourceNameContaining(resourceName, -1, -1);
	}

	/**
	 * JPQL Query - findGengameByResourceNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Gengame> findGengameByResourceNameContaining(String resourceName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findGengameByResourceNameContaining", startResult, maxRows, resourceName);
		return new LinkedHashSet<Gengame>(query.getResultList());
	}

	/**
	 * JPQL Query - findGengameByRefereeName
	 *
	 */
	@Transactional
	public Set<Gengame> findGengameByRefereeName(String refereeName) throws DataAccessException {

		return findGengameByRefereeName(refereeName, -1, -1);
	}

	/**
	 * JPQL Query - findGengameByRefereeName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Gengame> findGengameByRefereeName(String refereeName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findGengameByRefereeName", startResult, maxRows, refereeName);
		return new LinkedHashSet<Gengame>(query.getResultList());
	}

	/**
	 * JPQL Query - findGengameByRefereeId
	 *
	 */
	@Transactional
	public Set<Gengame> findGengameByRefereeId(Integer refereeId) throws DataAccessException {

		return findGengameByRefereeId(refereeId, -1, -1);
	}

	/**
	 * JPQL Query - findGengameByRefereeId
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Gengame> findGengameByRefereeId(Integer refereeId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findGengameByRefereeId", startResult, maxRows, refereeId);
		return new LinkedHashSet<Gengame>(query.getResultList());
	}

	/**
	 * JPQL Query - findGengameByRefereeNameContaining
	 *
	 */
	@Transactional
	public Set<Gengame> findGengameByRefereeNameContaining(String refereeName) throws DataAccessException {

		return findGengameByRefereeNameContaining(refereeName, -1, -1);
	}

	/**
	 * JPQL Query - findGengameByRefereeNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Gengame> findGengameByRefereeNameContaining(String refereeName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findGengameByRefereeNameContaining", startResult, maxRows, refereeName);
		return new LinkedHashSet<Gengame>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllGengames
	 *
	 */
	@Transactional
	public Set<Gengame> findAllGengames() throws DataAccessException {

		return findAllGengames(-1, -1);
	}

	/**
	 * JPQL Query - findAllGengames
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Gengame> findAllGengames(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllGengames", startResult, maxRows);
		return new LinkedHashSet<Gengame>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Gengame entity) {
		return true;
	}
}
