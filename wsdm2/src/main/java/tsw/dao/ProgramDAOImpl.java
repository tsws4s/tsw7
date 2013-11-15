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

import tsw.domain.Program;
import tsw.domain.Tswacct;
import tsw.web.UsersController;

/**
 * DAO to manage Program entities.
 * 
 */
@Repository("ProgramDAO")
@Transactional
public class ProgramDAOImpl extends AbstractJpaDao<Program> implements
		ProgramDAO {
	
	int defaultMaxRows = UsersController.getDefaultMaxRows();

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Program.class }));

	/**
	 * EntityManager injected by Spring for persistence unit tsws4s_4
	 *
	 */
	@PersistenceContext(unitName = "tsws4s_4")
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
	 * JPQL Query - findProgramByStartDate
	 *
	 */
	@Transactional
	public Set<Program> findProgramByStartDate(java.util.Calendar startDate) throws DataAccessException {

		return findProgramByStartDate(startDate, -1, defaultMaxRows);
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
	 * JPQL Query - findProgramByEndDateAfter
	 *
	 */
	@Transactional
	public Set<Program> findProgramByEndDateAfter(java.util.Calendar endDate) throws DataAccessException {

		return findProgramByEndDateAfter(endDate, -1, defaultMaxRows);
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
	 * JPQL Query - findProgramByGamesPerTeam
	 *
	 */
	@Transactional
	public Set<Program> findProgramByGamesPerTeam(Integer gamesPerTeam) throws DataAccessException {

		return findProgramByGamesPerTeam(gamesPerTeam, -1, defaultMaxRows);
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
	 * JPQL Query - findProgramByPrimaryKey
	 *
	 */
	@Transactional
	public Program findProgramByPrimaryKey(Integer programId) throws DataAccessException {

		return findProgramByPrimaryKey(programId, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findProgramByPrimaryKey
	 *
	 */

	@Transactional
	public Program findProgramByPrimaryKey(Integer programId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findProgramByPrimaryKey", startResult, maxRows, programId);
			return (tsw.domain.Program) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findProgramByEndDate
	 *
	 */
	@Transactional
	public Set<Program> findProgramByEndDate(java.util.Calendar endDate) throws DataAccessException {

		return findProgramByEndDate(endDate, -1, defaultMaxRows);
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
	 * JPQL Query - findProgramByStartDateAfter
	 *
	 */
	@Transactional
	public Set<Program> findProgramByStartDateAfter(java.util.Calendar startDate) throws DataAccessException {

		return findProgramByStartDateAfter(startDate, -1, defaultMaxRows);
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
	 * JPQL Query - findAllPrograms
	 *
	 */
	@Transactional
	public Set<Program> findAllPrograms4tsw(Integer tswId) throws DataAccessException {

		return findAllPrograms4tsw(tswId, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findAllPrograms
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Program> findAllPrograms4tsw(Integer tswId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllPrograms4tsw", startResult, maxRows, tswId);
		if(startResult>0){
			query.setFirstResult(startResult);
		}
		query.setMaxResults(maxRows);
		return new LinkedHashSet<Program>(query.getResultList());
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Program> findAnyPrograms4tsw(Integer tswId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAnyPrograms4tsw", startResult, maxRows, tswId);
		if(startResult>0){
			query.setFirstResult(startResult);
		}
		query.setMaxResults(maxRows);
		return new LinkedHashSet<Program>(query.getResultList());
	}
	
	/**
	 * JPQL Query - findAllLeagues
	 *
	 */
	@Transactional
	public Set<Program> findAllLeagues4tsw(Integer tswId) throws DataAccessException {

		return findAllLeagues4tsw(tswId, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findAllLeagues
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Program> findAllLeagues4tsw(Integer tswId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllLeagues4tsw", startResult, maxRows, tswId);
		if(startResult>0){
			query.setFirstResult(startResult);
		}
		query.setMaxResults(maxRows);
		return new LinkedHashSet<Program>(query.getResultList());
	}	
	
	
	/**
	 * JPQL Query - findProgramByStartDateBefore
	 *
	 */
	@Transactional
	public Set<Program> findProgramByStartDateBefore(java.util.Calendar startDate) throws DataAccessException {

		return findProgramByStartDateBefore(startDate, -1, defaultMaxRows);
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
	 * JPQL Query - findProgramByTotalParticipants
	 *
	 */
	@Transactional
	public Set<Program> findProgramByTotalParticipants(Integer totalParticipants) throws DataAccessException {

		return findProgramByTotalParticipants(totalParticipants, -1, defaultMaxRows);
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
	 * JPQL Query - findProgramByProgramName
	 *
	 */
	@Transactional
	public Program findProgramByProgramName(Tswacct tswacct, String programName) throws DataAccessException {

		return findProgramByProgramName(tswacct, programName, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findProgramByProgramName
	 *
	 */

	@Transactional
	public Program findProgramByProgramName(Tswacct tswacct, String programName, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findProgramByProgramName", startResult, maxRows, tswacct, programName);
			return (tsw.domain.Program) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}		
	}

	/**
	 * JPQL Query - findProgramByLeagueYn
	 *
	 */
	@Transactional
	public Set<Program> findProgramByLeagueYn(Integer leagueYn) throws DataAccessException {

		return findProgramByLeagueYn(leagueYn, -1, defaultMaxRows);
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
	 * JPQL Query - findProgramByProgramId
	 *
	 */
	@Transactional
	public Program findProgramByProgramId(Integer programId) throws DataAccessException {

		return findProgramByProgramId(programId, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findProgramByProgramId
	 *
	 */

	@Transactional
	public Program findProgramByProgramId(Integer programId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findProgramByProgramId", startResult, maxRows, programId);
			return (tsw.domain.Program) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findProgramByTotalPaid
	 *
	 */
	@Transactional
	public Set<Program> findProgramByTotalPaid(Integer totalPaid) throws DataAccessException {

		return findProgramByTotalPaid(totalPaid, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findProgramByTotalPaid
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Program> findProgramByTotalPaid(Integer totalPaid, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProgramByTotalPaid", startResult, maxRows, totalPaid);
		return new LinkedHashSet<Program>(query.getResultList());
	}

	/**
	 * JPQL Query - findProgramByPublishYn
	 *
	 */
	@Transactional
	public Set<Program> findProgramByPublishYn(Integer publishYn) throws DataAccessException {

		return findProgramByPublishYn(publishYn, -1, defaultMaxRows);
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
	 * JPQL Query - findProgramByPrice
	 *
	 */
	@Transactional
	public Set<Program> findProgramByPrice(Integer price) throws DataAccessException {

		return findProgramByPrice(price, -1, defaultMaxRows);
	}

	/**
	 * JPQL Query - findProgramByPrice
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Program> findProgramByPrice(Integer price, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProgramByPrice", startResult, maxRows, price);
		return new LinkedHashSet<Program>(query.getResultList());
	}

	/**
	 * JPQL Query - findProgramByEndDateBefore
	 *
	 */
	@Transactional
	public Set<Program> findProgramByEndDateBefore(java.util.Calendar endDate) throws DataAccessException {

		return findProgramByEndDateBefore(endDate, -1, defaultMaxRows);
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
	 * JPQL Query - findProgramByProgramNameContaining
	 *
	 */
	@Transactional
	public Set<Program> findProgramByProgramNameContaining(String programName) throws DataAccessException {

		return findProgramByProgramNameContaining(programName, -1, defaultMaxRows);
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
	 * JPQL Query - findProgramByActiveYn
	 *
	 */
	@Transactional
	public Set<Program> findProgramByActiveYn(Integer activeYn) throws DataAccessException {

		return findProgramByActiveYn(activeYn, -1, defaultMaxRows);
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
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Program entity) {
		return true;
	}
	@Override
	public Integer getMaxProgramID() {
		Object obj = executeQuerySingleResult("select max(programId) from Program");
		return (Integer)obj;
	}
}
