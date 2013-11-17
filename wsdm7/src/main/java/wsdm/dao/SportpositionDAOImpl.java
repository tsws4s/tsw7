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

import wsdm.domain.Sportposition;

/**
 * DAO to manage Sportposition entities.
 * 
 */
@Repository("SportpositionDAO")
@Transactional
public class SportpositionDAOImpl extends AbstractJpaDao<Sportposition>
		implements SportpositionDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Sportposition.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_tsw
	 *
	 */
	@PersistenceContext(unitName = "mysql_tsw")
	private EntityManager entityManager;

	/**
	 * Instantiates a new SportpositionDAOImpl
	 *
	 */
	public SportpositionDAOImpl() {
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
	 * JPQL Query - findSportpositionByPrimaryKey
	 *
	 */
	@Transactional
	public Sportposition findSportpositionByPrimaryKey(Integer sportPositionId) throws DataAccessException {

		return findSportpositionByPrimaryKey(sportPositionId, -1, -1);
	}

	/**
	 * JPQL Query - findSportpositionByPrimaryKey
	 *
	 */

	@Transactional
	public Sportposition findSportpositionByPrimaryKey(Integer sportPositionId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findSportpositionByPrimaryKey", startResult, maxRows, sportPositionId);
			return (wsdm.domain.Sportposition) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findSportpositionByNumTeamPlayers
	 *
	 */
	@Transactional
	public Set<Sportposition> findSportpositionByNumTeamPlayers(Integer numTeamPlayers) throws DataAccessException {

		return findSportpositionByNumTeamPlayers(numTeamPlayers, -1, -1);
	}

	/**
	 * JPQL Query - findSportpositionByNumTeamPlayers
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Sportposition> findSportpositionByNumTeamPlayers(Integer numTeamPlayers, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSportpositionByNumTeamPlayers", startResult, maxRows, numTeamPlayers);
		return new LinkedHashSet<Sportposition>(query.getResultList());
	}

	/**
	 * JPQL Query - findSportpositionByNumGamePlayers
	 *
	 */
	@Transactional
	public Set<Sportposition> findSportpositionByNumGamePlayers(Integer numGamePlayers) throws DataAccessException {

		return findSportpositionByNumGamePlayers(numGamePlayers, -1, -1);
	}

	/**
	 * JPQL Query - findSportpositionByNumGamePlayers
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Sportposition> findSportpositionByNumGamePlayers(Integer numGamePlayers, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSportpositionByNumGamePlayers", startResult, maxRows, numGamePlayers);
		return new LinkedHashSet<Sportposition>(query.getResultList());
	}

	/**
	 * JPQL Query - findSportpositionBySportPositionId
	 *
	 */
	@Transactional
	public Sportposition findSportpositionBySportPositionId(Integer sportPositionId) throws DataAccessException {

		return findSportpositionBySportPositionId(sportPositionId, -1, -1);
	}

	/**
	 * JPQL Query - findSportpositionBySportPositionId
	 *
	 */

	@Transactional
	public Sportposition findSportpositionBySportPositionId(Integer sportPositionId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findSportpositionBySportPositionId", startResult, maxRows, sportPositionId);
			return (wsdm.domain.Sportposition) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findSportpositionBySportPositionNameContaining
	 *
	 */
	@Transactional
	public Set<Sportposition> findSportpositionBySportPositionNameContaining(String sportPositionName) throws DataAccessException {

		return findSportpositionBySportPositionNameContaining(sportPositionName, -1, -1);
	}

	/**
	 * JPQL Query - findSportpositionBySportPositionNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Sportposition> findSportpositionBySportPositionNameContaining(String sportPositionName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSportpositionBySportPositionNameContaining", startResult, maxRows, sportPositionName);
		return new LinkedHashSet<Sportposition>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllSportpositions
	 *
	 */
	@Transactional
	public Set<Sportposition> findAllSportpositions() throws DataAccessException {

		return findAllSportpositions(-1, -1);
	}

	/**
	 * JPQL Query - findAllSportpositions
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Sportposition> findAllSportpositions(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllSportpositions", startResult, maxRows);
		return new LinkedHashSet<Sportposition>(query.getResultList());
	}

	/**
	 * JPQL Query - findSportpositionBySportPositionName
	 *
	 */
	@Transactional
	public Set<Sportposition> findSportpositionBySportPositionName(String sportPositionName) throws DataAccessException {

		return findSportpositionBySportPositionName(sportPositionName, -1, -1);
	}

	/**
	 * JPQL Query - findSportpositionBySportPositionName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Sportposition> findSportpositionBySportPositionName(String sportPositionName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSportpositionBySportPositionName", startResult, maxRows, sportPositionName);
		return new LinkedHashSet<Sportposition>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Sportposition entity) {
		return true;
	}
}
