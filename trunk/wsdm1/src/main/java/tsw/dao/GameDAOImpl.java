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

import tsw.domain.Game;
import tsw.service.UsersController;

/**
 * DAO to manage Game entities.
 * 
 */
@Repository("GameDAO")
@Transactional
public class GameDAOImpl extends AbstractJpaDao<Game> implements GameDAO {
	
	int defaultMaxRows = UsersController.getDefaultMaxRows();

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Game.class }));

	/**
	 * EntityManager injected by Spring for persistence unit tsws4s_4
	 *
	 */
	@PersistenceContext(unitName = "tsws4s_4")
	private EntityManager entityManager;

	/**
	 * Instantiates a new GameDAOImpl
	 *
	 */
	public GameDAOImpl() {
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
	 * JPQL Query - findGameByGameDateAfter
	 *
	 */
	@Transactional
	public Set<Game> findGameByGameDateAfter(java.util.Calendar gameDate) throws DataAccessException {

		return findGameByGameDateAfter(gameDate, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findGameByGameDateAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Game> findGameByGameDateAfter(java.util.Calendar gameDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findGameByGameDateAfter", startResult, maxRows, gameDate);
		return new LinkedHashSet<Game>(query.getResultList());
	}

	/**
	 * JPQL Query - findGameByActiveYn
	 *
	 */
	@Transactional
	public Set<Game> findGameByActiveYn(Integer activeYn) throws DataAccessException {

		return findGameByActiveYn(activeYn, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findGameByActiveYn
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Game> findGameByActiveYn(Integer activeYn, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findGameByActiveYn", startResult, maxRows, activeYn);
		return new LinkedHashSet<Game>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllGames
	 *
	 */
	@Transactional
	public Set<Game> findAllGames4tsw(Integer tswId) throws DataAccessException {

		return findAllGames4tsw(tswId, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findAllGames
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Game> findAllGames4tsw(Integer tswId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllGames4tsw", startResult, maxRows, tswId);
		query.setMaxResults(maxRows);
		return new LinkedHashSet<Game>(query.getResultList());
	}

	/**
	 * JPQL Query - findGameByVisitorScore
	 *
	 */
	@Transactional
	public Set<Game> findGameByVisitorScore(Integer visitorScore) throws DataAccessException {

		return findGameByVisitorScore(visitorScore, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findGameByVisitorScore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Game> findGameByVisitorScore(Integer visitorScore, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findGameByVisitorScore", startResult, maxRows, visitorScore);
		return new LinkedHashSet<Game>(query.getResultList());
	}

	/**
	 * JPQL Query - findGameByGameDate
	 *
	 */
	@Transactional
	public Set<Game> findGameByGameDate(java.util.Calendar gameDate) throws DataAccessException {

		return findGameByGameDate(gameDate, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findGameByGameDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Game> findGameByGameDate(java.util.Calendar gameDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findGameByGameDate", startResult, maxRows, gameDate);
		return new LinkedHashSet<Game>(query.getResultList());
	}

	/**
	 * JPQL Query - findGameByHomeScore
	 *
	 */
	@Transactional
	public Set<Game> findGameByHomeScore(Integer homeScore) throws DataAccessException {

		return findGameByHomeScore(homeScore, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findGameByHomeScore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Game> findGameByHomeScore(Integer homeScore, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findGameByHomeScore", startResult, maxRows, homeScore);
		return new LinkedHashSet<Game>(query.getResultList());
	}

	/**
	 * JPQL Query - findGameByGameDateBefore
	 *
	 */
	@Transactional
	public Set<Game> findGameByGameDateBefore(java.util.Calendar gameDate) throws DataAccessException {

		return findGameByGameDateBefore(gameDate, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findGameByGameDateBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Game> findGameByGameDateBefore(java.util.Calendar gameDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findGameByGameDateBefore", startResult, maxRows, gameDate);
		return new LinkedHashSet<Game>(query.getResultList());
	}

	/**
	 * JPQL Query - findGameByGameId
	 *
	 */
	@Transactional
	public Game findGameByGameId(Integer gameId) throws DataAccessException {

		return findGameByGameId(gameId, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findGameByGameId
	 *
	 */

	@Transactional
	public Game findGameByGameId(Integer gameId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findGameByGameId", startResult, maxRows, gameId);
			return (tsw.domain.Game) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findGameByPrimaryKey
	 *
	 */
	@Transactional
	public Game findGameByPrimaryKey(Integer gameId) throws DataAccessException {

		return findGameByPrimaryKey(gameId, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findGameByPrimaryKey
	 *
	 */

	@Transactional
	public Game findGameByPrimaryKey(Integer gameId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findGameByPrimaryKey", startResult, maxRows, gameId);
			return (tsw.domain.Game) query.getSingleResult();
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
	public boolean canBeMerged(Game entity) {
		return true;
	}

	@Override
	public Integer getMaxGameID() {
		Object obj = executeQuerySingleResult("select max(gameId) from Game");
		return (Integer)obj;
	}

}
