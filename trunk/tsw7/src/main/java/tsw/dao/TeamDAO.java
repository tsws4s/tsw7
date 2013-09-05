package tsw.dao;

import java.math.BigDecimal;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import tsw.domain.Program;
import tsw.domain.Team;
import tsw.domain.Tswacct;

/**
 * DAO to manage Team entities.
 * 
 */
public interface TeamDAO extends JpaDao<Team> {

	/**
	 * JPQL Query - findTeamByGroup3
	 *
	 */
	public Set<Team> findTeamByGroup3(String group3) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByGroup3
	 *
	 */
	public Set<Team> findTeamByGroup3(String group3, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByNotes
	 *
	 */
	public Set<Team> findTeamByNotes(String notes) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByNotes
	 *
	 */
	public Set<Team> findTeamByNotes(String notes, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByLosses
	 *
	 */
	public Set<Team> findTeamByLosses(Integer losses) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByLosses
	 *
	 */
	public Set<Team> findTeamByLosses(Integer losses, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByTeamName
	 *
	 */
	public Team findTeamByTeamName(Tswacct tswacct, Program pgm, String teamName) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByTeamName
	 *
	 */
	public Team findTeamByTeamName(Tswacct tswacct, Program pgm, String teamName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByNotesContaining
	 *
	 */
	public Set<Team> findTeamByNotesContaining(String notes_1) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByNotesContaining
	 *
	 */
	public Set<Team> findTeamByNotesContaining(String notes_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByActiveYn
	 *
	 */
	public Set<Team> findTeamByActiveYn(Integer activeYn) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByActiveYn
	 *
	 */
	public Set<Team> findTeamByActiveYn(Integer activeYn, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByGroup3Containing
	 *
	 */
	public Set<Team> findTeamByGroup3Containing(String group3_1) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByGroup3Containing
	 *
	 */
	public Set<Team> findTeamByGroup3Containing(String group3_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByPrimaryKey
	 *
	 */
	public Team findTeamByPrimaryKey(Integer teamId) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByPrimaryKey
	 *
	 */
	public Team findTeamByPrimaryKey(Integer teamId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByTeamNameContaining
	 *
	 */
	public Set<Team> findTeamByTeamNameContaining(String teamName_1) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByTeamNameContaining
	 *
	 */
	public Set<Team> findTeamByTeamNameContaining(String teamName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByColor
	 *
	 */
	public Set<Team> findTeamByColor(String color) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByColor
	 *
	 */
	public Set<Team> findTeamByColor(String color, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByTies
	 *
	 */
	public Set<Team> findTeamByTies(Integer ties) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByTies
	 *
	 */
	public Set<Team> findTeamByTies(Integer ties, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByPublishYn
	 *
	 */
	public Set<Team> findTeamByPublishYn(Integer publishYn) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByPublishYn
	 *
	 */
	public Set<Team> findTeamByPublishYn(Integer publishYn, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByColorContaining
	 *
	 */
	public Set<Team> findTeamByColorContaining(String color_1) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByColorContaining
	 *
	 */
	public Set<Team> findTeamByColorContaining(String color_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByAmtPaid
	 *
	 */
	public Set<Team> findTeamByAmtPaid(java.math.BigDecimal amtPaid) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByAmtPaid
	 *
	 */
	public Set<Team> findTeamByAmtPaid(BigDecimal amtPaid, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllTeams
	 *
	 */
	public Set<Team> findAllTeams4tsw(Integer tswId) throws DataAccessException;

	/**
	 * JPQL Query - findAllTeams
	 *
	 */
	public Set<Team> findAllTeams4tsw(Integer tswId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByTeamId
	 *
	 */
	public Team findTeamByTeamId(Integer teamId_1) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByTeamId
	 *
	 */
	public Team findTeamByTeamId(Integer teamId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByWins
	 *
	 */
	public Set<Team> findTeamByWins(Integer wins) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByWins
	 *
	 */
	public Set<Team> findTeamByWins(Integer wins, int startResult, int maxRows) throws DataAccessException;

	public Integer getMaxTeamID();

}