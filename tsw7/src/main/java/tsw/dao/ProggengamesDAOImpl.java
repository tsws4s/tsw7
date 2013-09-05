package tsw.dao;

import tsw.domain.ProgGenGames;

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
 * DAO to manage ProgGenGames entities.
 * 
 */
@Repository("ProggengamesDAO")
@Transactional
public class ProggengamesDAOImpl extends AbstractJpaDao<ProgGenGames> implements
		ProggengamesDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { ProgGenGames.class }));

	/**
	 * EntityManager injected by Spring for persistence unit tsws4s_4
	 *
	 */
	@PersistenceContext(unitName = "tsws4s_4")
	private EntityManager entityManager;

	/**
	 * Instantiates a new ProggengamesDAOImpl
	 *
	 */
	public ProggengamesDAOImpl() {
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
	 * JPQL Query - findAllProggengamess
	 *
	 */
	@Transactional
	public Set<ProgGenGames> findAllProggengamess() throws DataAccessException {

		return findAllProggengamess(-1, -1);
	}

	/**
	 * JPQL Query - findAllProggengamess
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<ProgGenGames> findAllProggengamess(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllProggengamess", startResult, maxRows);
		return new LinkedHashSet<ProgGenGames>(query.getResultList());
	}

	/**
	 * JPQL Query - findProggengamesByPrimaryKey
	 *
	 */
	@Transactional
	public ProgGenGames findProggengamesByPrimaryKey(Integer progGenGamesId) throws DataAccessException {

		return findProggengamesByPrimaryKey(progGenGamesId, -1, -1);
	}

	/**
	 * JPQL Query - findProggengamesByPrimaryKey
	 *
	 */

	@Transactional
	public ProgGenGames findProggengamesByPrimaryKey(Integer progGenGamesId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findProggengamesByPrimaryKey", startResult, maxRows, progGenGamesId);
			return (tsw.domain.ProgGenGames) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findProggengamesByProgramName
	 *
	 */
	@Transactional
	public Set<ProgGenGames> findProggengamesByProgramName(String programName) throws DataAccessException {

		return findProggengamesByProgramName(programName, -1, -1);
	}

	/**
	 * JPQL Query - findProggengamesByProgramName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<ProgGenGames> findProggengamesByProgramName(String programName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProggengamesByProgramName", startResult, maxRows, programName);
		return new LinkedHashSet<ProgGenGames>(query.getResultList());
	}

	/**
	 * JPQL Query - findProggengamesByStartDate
	 *
	 */
	@Transactional
	public Set<ProgGenGames> findProggengamesByStartDate(java.util.Calendar startDate) throws DataAccessException {

		return findProggengamesByStartDate(startDate, -1, -1);
	}

	/**
	 * JPQL Query - findProggengamesByStartDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<ProgGenGames> findProggengamesByStartDate(java.util.Calendar startDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProggengamesByStartDate", startResult, maxRows, startDate);
		return new LinkedHashSet<ProgGenGames>(query.getResultList());
	}

	/**
	 * JPQL Query - findProggengamesByProgramId
	 *
	 */
	@Transactional
	public Set<ProgGenGames> findProggengamesByProgramId(Integer programId) throws DataAccessException {

		return findProggengamesByProgramId(programId, -1, -1);
	}

	/**
	 * JPQL Query - findProggengamesByProgramId
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<ProgGenGames> findProggengamesByProgramId(Integer programId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProggengamesByProgramId", startResult, maxRows, programId);
		return new LinkedHashSet<ProgGenGames>(query.getResultList());
	}

	/**
	 * JPQL Query - findProggengamesByProgramNameContaining
	 *
	 */
	@Transactional
	public Set<ProgGenGames> findProggengamesByProgramNameContaining(String programName) throws DataAccessException {

		return findProggengamesByProgramNameContaining(programName, -1, -1);
	}

	/**
	 * JPQL Query - findProggengamesByProgramNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<ProgGenGames> findProggengamesByProgramNameContaining(String programName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProggengamesByProgramNameContaining", startResult, maxRows, programName);
		return new LinkedHashSet<ProgGenGames>(query.getResultList());
	}

	/**
	 * JPQL Query - findProggengamesByProgGenGamesId
	 *
	 */
	@Transactional
	public ProgGenGames findProggengamesByProgGenGamesId(Integer progGenGamesId) throws DataAccessException {

		return findProggengamesByProgGenGamesId(progGenGamesId, -1, -1);
	}

	/**
	 * JPQL Query - findProggengamesByProgGenGamesId
	 *
	 */

	@Transactional
	public ProgGenGames findProggengamesByProgGenGamesId(Integer progGenGamesId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findProggengamesByProgGenGamesId", startResult, maxRows, progGenGamesId);
			return (tsw.domain.ProgGenGames) query.getSingleResult();
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
	public boolean canBeMerged(ProgGenGames entity) {
		return true;
	}
}
