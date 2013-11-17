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

import wsdm.domain.Proggengames;

/**
 * DAO to manage Proggengames entities.
 * 
 */
@Repository("ProggengamesDAO")
@Transactional
public class ProggengamesDAOImpl extends AbstractJpaDao<Proggengames> implements
		ProggengamesDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Proggengames.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_tsw
	 *
	 */
	@PersistenceContext(unitName = "mysql_tsw")
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
	 * JPQL Query - findProggengamesByProgGenGamesId
	 *
	 */
	@Transactional
	public Proggengames findProggengamesByProgGenGamesId(Integer progGenGamesId) throws DataAccessException {

		return findProggengamesByProgGenGamesId(progGenGamesId, -1, -1);
	}

	/**
	 * JPQL Query - findProggengamesByProgGenGamesId
	 *
	 */

	@Transactional
	public Proggengames findProggengamesByProgGenGamesId(Integer progGenGamesId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findProggengamesByProgGenGamesId", startResult, maxRows, progGenGamesId);
			return (wsdm.domain.Proggengames) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findProggengamesByProgramId
	 *
	 */
	@Transactional
	public Set<Proggengames> findProggengamesByProgramId(Integer programId) throws DataAccessException {

		return findProggengamesByProgramId(programId, -1, -1);
	}

	/**
	 * JPQL Query - findProggengamesByProgramId
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Proggengames> findProggengamesByProgramId(Integer programId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProggengamesByProgramId", startResult, maxRows, programId);
		return new LinkedHashSet<Proggengames>(query.getResultList());
	}

	/**
	 * JPQL Query - findProggengamesByPrimaryKey
	 *
	 */
	@Transactional
	public Proggengames findProggengamesByPrimaryKey(Integer progGenGamesId) throws DataAccessException {

		return findProggengamesByPrimaryKey(progGenGamesId, -1, -1);
	}

	/**
	 * JPQL Query - findProggengamesByPrimaryKey
	 *
	 */

	@Transactional
	public Proggengames findProggengamesByPrimaryKey(Integer progGenGamesId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findProggengamesByPrimaryKey", startResult, maxRows, progGenGamesId);
			return (wsdm.domain.Proggengames) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findProggengamesByStartDate
	 *
	 */
	@Transactional
	public Set<Proggengames> findProggengamesByStartDate(java.util.Calendar startDate) throws DataAccessException {

		return findProggengamesByStartDate(startDate, -1, -1);
	}

	/**
	 * JPQL Query - findProggengamesByStartDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Proggengames> findProggengamesByStartDate(java.util.Calendar startDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProggengamesByStartDate", startResult, maxRows, startDate);
		return new LinkedHashSet<Proggengames>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllProggengamess
	 *
	 */
	@Transactional
	public Set<Proggengames> findAllProggengamess() throws DataAccessException {

		return findAllProggengamess(-1, -1);
	}

	/**
	 * JPQL Query - findAllProggengamess
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Proggengames> findAllProggengamess(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllProggengamess", startResult, maxRows);
		return new LinkedHashSet<Proggengames>(query.getResultList());
	}

	/**
	 * JPQL Query - findProggengamesByProgramName
	 *
	 */
	@Transactional
	public Set<Proggengames> findProggengamesByProgramName(String programName) throws DataAccessException {

		return findProggengamesByProgramName(programName, -1, -1);
	}

	/**
	 * JPQL Query - findProggengamesByProgramName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Proggengames> findProggengamesByProgramName(String programName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProggengamesByProgramName", startResult, maxRows, programName);
		return new LinkedHashSet<Proggengames>(query.getResultList());
	}

	/**
	 * JPQL Query - findProggengamesByProgramNameContaining
	 *
	 */
	@Transactional
	public Set<Proggengames> findProggengamesByProgramNameContaining(String programName) throws DataAccessException {

		return findProggengamesByProgramNameContaining(programName, -1, -1);
	}

	/**
	 * JPQL Query - findProggengamesByProgramNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Proggengames> findProggengamesByProgramNameContaining(String programName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProggengamesByProgramNameContaining", startResult, maxRows, programName);
		return new LinkedHashSet<Proggengames>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Proggengames entity) {
		return true;
	}
}
