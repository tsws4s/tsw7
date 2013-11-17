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

import wsdm.domain.Program;

/**
 * DAO to manage Program entities.
 * 
 */
@Repository("ProgramDAO")
@Transactional
public class ProgramDAOImpl extends AbstractJpaDao<Program> implements
		ProgramDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Program.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_tsw
	 *
	 */
	@PersistenceContext(unitName = "mysql_tsw")
	private EntityManager entityManager;

	/**
	 * Instantiates a new ProgramDAOImpl
	 *
	 */
	public ProgramDAOImpl() {
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
	 * JPQL Query - findProgramByPrimaryKey
	 *
	 */
	@Transactional
	public Program findProgramByPrimaryKey(Integer programId) throws DataAccessException {

		return findProgramByPrimaryKey(programId, -1, -1);
	}

	/**
	 * JPQL Query - findProgramByPrimaryKey
	 *
	 */

	@Transactional
	public Program findProgramByPrimaryKey(Integer programId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findProgramByPrimaryKey", startResult, maxRows, programId);
			return (wsdm.domain.Program) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findProgramByEndDateAfter
	 *
	 */
	@Transactional
	public Set<Program> findProgramByEndDateAfter(java.util.Calendar endDate) throws DataAccessException {

		return findProgramByEndDateAfter(endDate, -1, -1);
	}

	/**
	 * JPQL Query - findProgramByEndDateAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Program> findProgramByEndDateAfter(java.util.Calendar endDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProgramByEndDateAfter", startResult, maxRows, endDate);
		return new LinkedHashSet<Program>(query.getResultList());
	}

	/**
	 * JPQL Query - findProgramByTotalParticipants
	 *
	 */
	@Transactional
	public Set<Program> findProgramByTotalParticipants(Integer totalParticipants) throws DataAccessException {

		return findProgramByTotalParticipants(totalParticipants, -1, -1);
	}

	/**
	 * JPQL Query - findProgramByTotalParticipants
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Program> findProgramByTotalParticipants(Integer totalParticipants, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProgramByTotalParticipants", startResult, maxRows, totalParticipants);
		return new LinkedHashSet<Program>(query.getResultList());
	}

	/**
	 * JPQL Query - findProgramByGamesPerTeam
	 *
	 */
	@Transactional
	public Set<Program> findProgramByGamesPerTeam(Integer gamesPerTeam) throws DataAccessException {

		return findProgramByGamesPerTeam(gamesPerTeam, -1, -1);
	}

	/**
	 * JPQL Query - findProgramByGamesPerTeam
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Program> findProgramByGamesPerTeam(Integer gamesPerTeam, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProgramByGamesPerTeam", startResult, maxRows, gamesPerTeam);
		return new LinkedHashSet<Program>(query.getResultList());
	}

	/**
	 * JPQL Query - findProgramByActiveYn
	 *
	 */
	@Transactional
	public Set<Program> findProgramByActiveYn(Integer activeYn) throws DataAccessException {

		return findProgramByActiveYn(activeYn, -1, -1);
	}

	/**
	 * JPQL Query - findProgramByActiveYn
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Program> findProgramByActiveYn(Integer activeYn, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProgramByActiveYn", startResult, maxRows, activeYn);
		return new LinkedHashSet<Program>(query.getResultList());
	}

	/**
	 * JPQL Query - findProgramByProgramName
	 *
	 */
	@Transactional
	public Set<Program> findProgramByProgramName(String programName) throws DataAccessException {

		return findProgramByProgramName(programName, -1, -1);
	}

	/**
	 * JPQL Query - findProgramByProgramName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Program> findProgramByProgramName(String programName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProgramByProgramName", startResult, maxRows, programName);
		return new LinkedHashSet<Program>(query.getResultList());
	}

	/**
	 * JPQL Query - findProgramByEndDate
	 *
	 */
	@Transactional
	public Set<Program> findProgramByEndDate(java.util.Calendar endDate) throws DataAccessException {

		return findProgramByEndDate(endDate, -1, -1);
	}

	/**
	 * JPQL Query - findProgramByEndDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Program> findProgramByEndDate(java.util.Calendar endDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProgramByEndDate", startResult, maxRows, endDate);
		return new LinkedHashSet<Program>(query.getResultList());
	}

	/**
	 * JPQL Query - findProgramByLevelFk
	 *
	 */
	@Transactional
	public Set<Program> findProgramByLevelFk(Integer levelFk) throws DataAccessException {

		return findProgramByLevelFk(levelFk, -1, -1);
	}

	/**
	 * JPQL Query - findProgramByLevelFk
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Program> findProgramByLevelFk(Integer levelFk, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProgramByLevelFk", startResult, maxRows, levelFk);
		return new LinkedHashSet<Program>(query.getResultList());
	}

	/**
	 * JPQL Query - findProgramByStartDateAfter
	 *
	 */
	@Transactional
	public Set<Program> findProgramByStartDateAfter(java.util.Calendar startDate) throws DataAccessException {

		return findProgramByStartDateAfter(startDate, -1, -1);
	}

	/**
	 * JPQL Query - findProgramByStartDateAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Program> findProgramByStartDateAfter(java.util.Calendar startDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProgramByStartDateAfter", startResult, maxRows, startDate);
		return new LinkedHashSet<Program>(query.getResultList());
	}

	/**
	 * JPQL Query - findProgramByPublishYn
	 *
	 */
	@Transactional
	public Set<Program> findProgramByPublishYn(Integer publishYn) throws DataAccessException {

		return findProgramByPublishYn(publishYn, -1, -1);
	}

	/**
	 * JPQL Query - findProgramByPublishYn
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Program> findProgramByPublishYn(Integer publishYn, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProgramByPublishYn", startResult, maxRows, publishYn);
		return new LinkedHashSet<Program>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllPrograms
	 *
	 */
	@Transactional
	public Set<Program> findAllPrograms() throws DataAccessException {

		return findAllPrograms(-1, -1);
	}

	/**
	 * JPQL Query - findAllPrograms
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Program> findAllPrograms(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllPrograms", startResult, maxRows);
		return new LinkedHashSet<Program>(query.getResultList());
	}

	/**
	 * JPQL Query - findProgramByStartDateBefore
	 *
	 */
	@Transactional
	public Set<Program> findProgramByStartDateBefore(java.util.Calendar startDate) throws DataAccessException {

		return findProgramByStartDateBefore(startDate, -1, -1);
	}

	/**
	 * JPQL Query - findProgramByStartDateBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Program> findProgramByStartDateBefore(java.util.Calendar startDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProgramByStartDateBefore", startResult, maxRows, startDate);
		return new LinkedHashSet<Program>(query.getResultList());
	}

	/**
	 * JPQL Query - findProgramByTotalPaid
	 *
	 */
	@Transactional
	public Set<Program> findProgramByTotalPaid(java.math.BigDecimal totalPaid) throws DataAccessException {

		return findProgramByTotalPaid(totalPaid, -1, -1);
	}

	/**
	 * JPQL Query - findProgramByTotalPaid
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Program> findProgramByTotalPaid(java.math.BigDecimal totalPaid, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProgramByTotalPaid", startResult, maxRows, totalPaid);
		return new LinkedHashSet<Program>(query.getResultList());
	}

	/**
	 * JPQL Query - findProgramByStartDate
	 *
	 */
	@Transactional
	public Set<Program> findProgramByStartDate(java.util.Calendar startDate) throws DataAccessException {

		return findProgramByStartDate(startDate, -1, -1);
	}

	/**
	 * JPQL Query - findProgramByStartDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Program> findProgramByStartDate(java.util.Calendar startDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProgramByStartDate", startResult, maxRows, startDate);
		return new LinkedHashSet<Program>(query.getResultList());
	}

	/**
	 * JPQL Query - findProgramByEndDateBefore
	 *
	 */
	@Transactional
	public Set<Program> findProgramByEndDateBefore(java.util.Calendar endDate) throws DataAccessException {

		return findProgramByEndDateBefore(endDate, -1, -1);
	}

	/**
	 * JPQL Query - findProgramByEndDateBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Program> findProgramByEndDateBefore(java.util.Calendar endDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProgramByEndDateBefore", startResult, maxRows, endDate);
		return new LinkedHashSet<Program>(query.getResultList());
	}

	/**
	 * JPQL Query - findProgramByLeagueYn
	 *
	 */
	@Transactional
	public Set<Program> findProgramByLeagueYn(Integer leagueYn) throws DataAccessException {

		return findProgramByLeagueYn(leagueYn, -1, -1);
	}

	/**
	 * JPQL Query - findProgramByLeagueYn
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Program> findProgramByLeagueYn(Integer leagueYn, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProgramByLeagueYn", startResult, maxRows, leagueYn);
		return new LinkedHashSet<Program>(query.getResultList());
	}

	/**
	 * JPQL Query - findProgramByProgramNameContaining
	 *
	 */
	@Transactional
	public Set<Program> findProgramByProgramNameContaining(String programName) throws DataAccessException {

		return findProgramByProgramNameContaining(programName, -1, -1);
	}

	/**
	 * JPQL Query - findProgramByProgramNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Program> findProgramByProgramNameContaining(String programName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProgramByProgramNameContaining", startResult, maxRows, programName);
		return new LinkedHashSet<Program>(query.getResultList());
	}

	/**
	 * JPQL Query - findProgramByProgramId
	 *
	 */
	@Transactional
	public Program findProgramByProgramId(Integer programId) throws DataAccessException {

		return findProgramByProgramId(programId, -1, -1);
	}

	/**
	 * JPQL Query - findProgramByProgramId
	 *
	 */

	@Transactional
	public Program findProgramByProgramId(Integer programId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findProgramByProgramId", startResult, maxRows, programId);
			return (wsdm.domain.Program) query.getSingleResult();
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
	public boolean canBeMerged(Program entity) {
		return true;
	}
}
