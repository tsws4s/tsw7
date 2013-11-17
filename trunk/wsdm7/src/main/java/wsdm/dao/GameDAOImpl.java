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

import wsdm.domain.Game;

/**
 * DAO to manage Game entities.
 * 
 */
@Repository("GameDAO")
@Transactional
public class GameDAOImpl extends AbstractJpaDao<Game> implements GameDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Game.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_tsw
	 *
	 */
	@PersistenceContext(unitName = "mysql_tsw")
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
	 * JPQL Query - findGameByPrimaryKey
	 *
	 */
	@Transactional
	public Game findGameByPrimaryKey(Integer gameId) throws DataAccessException {

		return findGameByPrimaryKey(gameId, -1, -1);
	}

	/**
	 * JPQL Query - findGameByPrimaryKey
	 *
	 */

	@Transactional
	public Game findGameByPrimaryKey(Integer gameId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findGameByPrimaryKey", startResult, maxRows, gameId);
			return (wsdm.domain.Game) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAllGames
	 *
	 */
	@Transactional
	public Set<Game> findAllGames() throws DataAccessException {

		return findAllGames(-1, -1);
	}

	/**
	 * JPQL Query - findAllGames
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Game> findAllGames(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllGames", startResult, maxRows);
		return new LinkedHashSet<Game>(query.getResultList());
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
}
