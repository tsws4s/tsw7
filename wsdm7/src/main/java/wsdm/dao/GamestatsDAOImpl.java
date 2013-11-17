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

import wsdm.domain.Gamestats;

/**
 * DAO to manage Gamestats entities.
 * 
 */
@Repository("GamestatsDAO")
@Transactional
public class GamestatsDAOImpl extends AbstractJpaDao<Gamestats> implements
		GamestatsDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Gamestats.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_tsw
	 *
	 */
	@PersistenceContext(unitName = "mysql_tsw")
	private EntityManager entityManager;

	/**
	 * Instantiates a new GamestatsDAOImpl
	 *
	 */
	public GamestatsDAOImpl() {
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
	 * JPQL Query - findGamestatsByGameStatValue
	 *
	 */
	@Transactional
	public Set<Gamestats> findGamestatsByGameStatValue(Integer gameStatValue) throws DataAccessException {

		return findGamestatsByGameStatValue(gameStatValue, -1, -1);
	}

	/**
	 * JPQL Query - findGamestatsByGameStatValue
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Gamestats> findGamestatsByGameStatValue(Integer gameStatValue, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findGamestatsByGameStatValue", startResult, maxRows, gameStatValue);
		return new LinkedHashSet<Gamestats>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllGamestatss
	 *
	 */
	@Transactional
	public Set<Gamestats> findAllGamestatss() throws DataAccessException {

		return findAllGamestatss(-1, -1);
	}

	/**
	 * JPQL Query - findAllGamestatss
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Gamestats> findAllGamestatss(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllGamestatss", startResult, maxRows);
		return new LinkedHashSet<Gamestats>(query.getResultList());
	}

	/**
	 * JPQL Query - findGamestatsByGameStatTime
	 *
	 */
	@Transactional
	public Set<Gamestats> findGamestatsByGameStatTime(java.util.Calendar gameStatTime) throws DataAccessException {

		return findGamestatsByGameStatTime(gameStatTime, -1, -1);
	}

	/**
	 * JPQL Query - findGamestatsByGameStatTime
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Gamestats> findGamestatsByGameStatTime(java.util.Calendar gameStatTime, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findGamestatsByGameStatTime", startResult, maxRows, gameStatTime);
		return new LinkedHashSet<Gamestats>(query.getResultList());
	}

	/**
	 * JPQL Query - findGamestatsBySportStatTypeFk
	 *
	 */
	@Transactional
	public Set<Gamestats> findGamestatsBySportStatTypeFk(Integer sportStatTypeFk) throws DataAccessException {

		return findGamestatsBySportStatTypeFk(sportStatTypeFk, -1, -1);
	}

	/**
	 * JPQL Query - findGamestatsBySportStatTypeFk
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Gamestats> findGamestatsBySportStatTypeFk(Integer sportStatTypeFk, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findGamestatsBySportStatTypeFk", startResult, maxRows, sportStatTypeFk);
		return new LinkedHashSet<Gamestats>(query.getResultList());
	}

	/**
	 * JPQL Query - findGamestatsByGameStatsId
	 *
	 */
	@Transactional
	public Gamestats findGamestatsByGameStatsId(Integer gameStatsId) throws DataAccessException {

		return findGamestatsByGameStatsId(gameStatsId, -1, -1);
	}

	/**
	 * JPQL Query - findGamestatsByGameStatsId
	 *
	 */

	@Transactional
	public Gamestats findGamestatsByGameStatsId(Integer gameStatsId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findGamestatsByGameStatsId", startResult, maxRows, gameStatsId);
			return (wsdm.domain.Gamestats) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findGamestatsByPrimaryKey
	 *
	 */
	@Transactional
	public Gamestats findGamestatsByPrimaryKey(Integer gameStatsId) throws DataAccessException {

		return findGamestatsByPrimaryKey(gameStatsId, -1, -1);
	}

	/**
	 * JPQL Query - findGamestatsByPrimaryKey
	 *
	 */

	@Transactional
	public Gamestats findGamestatsByPrimaryKey(Integer gameStatsId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findGamestatsByPrimaryKey", startResult, maxRows, gameStatsId);
			return (wsdm.domain.Gamestats) query.getSingleResult();
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
	public boolean canBeMerged(Gamestats entity) {
		return true;
	}
}
