package tsw.dao;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import tsw.domain.Program;
import tsw.domain.Tswacct;

/**
 * DAO to manage Program entities.
 * 
 */
public interface ProgramDAO extends JpaDao<Program> {

	/**
	 * JPQL Query - findProgramByStartDate
	 *
	 */
	public Set<Program> findProgramByStartDate(java.util.Calendar startDate) throws DataAccessException;

	/**
	 * JPQL Query - findProgramByStartDate
	 *
	 */
	public Set<Program> findProgramByStartDate(Calendar startDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProgramByEndDateAfter
	 *
	 */
	public Set<Program> findProgramByEndDateAfter(java.util.Calendar endDate) throws DataAccessException;

	/**
	 * JPQL Query - findProgramByEndDateAfter
	 *
	 */
	public Set<Program> findProgramByEndDateAfter(Calendar endDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProgramByGamesPerTeam
	 *
	 */
	public Set<Program> findProgramByGamesPerTeam(Integer gamesPerTeam) throws DataAccessException;

	/**
	 * JPQL Query - findProgramByGamesPerTeam
	 *
	 */
	public Set<Program> findProgramByGamesPerTeam(Integer gamesPerTeam, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProgramByPrimaryKey
	 *
	 */
	public Program findProgramByPrimaryKey(Integer programId) throws DataAccessException;

	/**
	 * JPQL Query - findProgramByPrimaryKey
	 *
	 */
	public Program findProgramByPrimaryKey(Integer programId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProgramByEndDate
	 *
	 */
	public Set<Program> findProgramByEndDate(java.util.Calendar endDate_1) throws DataAccessException;

	/**
	 * JPQL Query - findProgramByEndDate
	 *
	 */
	public Set<Program> findProgramByEndDate(Calendar endDate_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProgramByStartDateAfter
	 *
	 */
	public Set<Program> findProgramByStartDateAfter(java.util.Calendar startDate_1) throws DataAccessException;

	/**
	 * JPQL Query - findProgramByStartDateAfter
	 *
	 */
	public Set<Program> findProgramByStartDateAfter(Calendar startDate_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllPrograms
	 *
	 */
	public Set<Program> findAllPrograms4tsw(Integer tswId) throws DataAccessException;

	/**
	 * JPQL Query - findAllPrograms
	 *
	 */
	public Set<Program> findAllPrograms4tsw(Integer tswId, int startResult, int maxRows) throws DataAccessException;
	public Set<Program> findAnyPrograms4tsw(Integer tswId, int startResult, int maxRows) throws DataAccessException;
	
	
	/**
	 * JPQL Query - findAllLeagues
	 *
	 */
	public Set<Program> findAllLeagues4tsw(Integer tswId) throws DataAccessException;

	/**
	 * JPQL Query - findAllLeagues
	 *
	 */
	public Set<Program> findAllLeagues4tsw(Integer tswId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProgramByStartDateBefore
	 *
	 */
	public Set<Program> findProgramByStartDateBefore(java.util.Calendar startDate_2) throws DataAccessException;

	/**
	 * JPQL Query - findProgramByStartDateBefore
	 *
	 */
	public Set<Program> findProgramByStartDateBefore(Calendar startDate_2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProgramByTotalParticipants
	 *
	 */
	public Set<Program> findProgramByTotalParticipants(Integer totalParticipants) throws DataAccessException;

	/**
	 * JPQL Query - findProgramByTotalParticipants
	 *
	 */
	public Set<Program> findProgramByTotalParticipants(Integer totalParticipants, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProgramByProgramName
	 *
	 */
	public Program findProgramByProgramName(Tswacct tswacct, String programName) throws DataAccessException;

	/**
	 * JPQL Query - findProgramByProgramName
	 *
	 */
	public Program findProgramByProgramName(Tswacct tswacct, String programName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProgramByLeagueYn
	 *
	 */
	public Set<Program> findProgramByLeagueYn(Integer leagueYn) throws DataAccessException;

	/**
	 * JPQL Query - findProgramByLeagueYn
	 *
	 */
	public Set<Program> findProgramByLeagueYn(Integer leagueYn, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProgramByProgramId
	 *
	 */
	public Program findProgramByProgramId(Integer programId_1) throws DataAccessException;

	/**
	 * JPQL Query - findProgramByProgramId
	 *
	 */
	public Program findProgramByProgramId(Integer programId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProgramByTotalPaid
	 *
	 */
	public Set<Program> findProgramByTotalPaid(Integer totalPaid) throws DataAccessException;

	/**
	 * JPQL Query - findProgramByTotalPaid
	 *
	 */
	public Set<Program> findProgramByTotalPaid(Integer totalPaid, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProgramByPublishYn
	 *
	 */
	public Set<Program> findProgramByPublishYn(Integer publishYn) throws DataAccessException;

	/**
	 * JPQL Query - findProgramByPublishYn
	 *
	 */
	public Set<Program> findProgramByPublishYn(Integer publishYn, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProgramByPrice
	 *
	 */
	public Set<Program> findProgramByPrice(Integer price) throws DataAccessException;

	/**
	 * JPQL Query - findProgramByPrice
	 *
	 */
	public Set<Program> findProgramByPrice(Integer price, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProgramByEndDateBefore
	 *
	 */
	public Set<Program> findProgramByEndDateBefore(java.util.Calendar endDate_2) throws DataAccessException;

	/**
	 * JPQL Query - findProgramByEndDateBefore
	 *
	 */
	public Set<Program> findProgramByEndDateBefore(Calendar endDate_2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProgramByProgramNameContaining
	 *
	 */
	public Set<Program> findProgramByProgramNameContaining(String programName_1) throws DataAccessException;

	/**
	 * JPQL Query - findProgramByProgramNameContaining
	 *
	 */
	public Set<Program> findProgramByProgramNameContaining(String programName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProgramByActiveYn
	 *
	 */
	public Set<Program> findProgramByActiveYn(Integer activeYn) throws DataAccessException;

	/**
	 * JPQL Query - findProgramByActiveYn
	 *
	 */
	public Set<Program> findProgramByActiveYn(Integer activeYn, int startResult, int maxRows) throws DataAccessException;

	Integer getMaxProgramID();

}