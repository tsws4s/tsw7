package wsdm.dao;

import java.math.BigDecimal;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import wsdm.domain.Team;

/**
 * DAO to manage Team entities.
 * 
 */
public interface TeamDAO extends JpaDao<Team> {

	/**
	 * JPQL Query - findTeamByNotesContaining
	 *
	 */
	public Set<Team> findTeamByNotesContaining(String notes) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByNotesContaining
	 *
	 */
	public Set<Team> findTeamByNotesContaining(String notes, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByColorContaining
	 *
	 */
	public Set<Team> findTeamByColorContaining(String color) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByColorContaining
	 *
	 */
	public Set<Team> findTeamByColorContaining(String color, int startResult, int maxRows) throws DataAccessException;

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
	 * JPQL Query - findTeamByTeamName
	 *
	 */
	public Set<Team> findTeamByTeamName(String teamName) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByTeamName
	 *
	 */
	public Set<Team> findTeamByTeamName(String teamName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllTeams
	 *
	 */
	public Set<Team> findAllTeams() throws DataAccessException;

	/**
	 * JPQL Query - findAllTeams
	 *
	 */
	public Set<Team> findAllTeams(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByGroup3Containing
	 *
	 */
	public Set<Team> findTeamByGroup3Containing(String group3) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByGroup3Containing
	 *
	 */
	public Set<Team> findTeamByGroup3Containing(String group3, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByColor
	 *
	 */
	public Set<Team> findTeamByColor(String color_1) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByColor
	 *
	 */
	public Set<Team> findTeamByColor(String color_1, int startResult, int maxRows) throws DataAccessException;

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
	 * JPQL Query - findTeamByNotes
	 *
	 */
	public Set<Team> findTeamByNotes(String notes_1) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByNotes
	 *
	 */
	public Set<Team> findTeamByNotes(String notes_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByGroup3
	 *
	 */
	public Set<Team> findTeamByGroup3(String group3_1) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByGroup3
	 *
	 */
	public Set<Team> findTeamByGroup3(String group3_1, int startResult, int maxRows) throws DataAccessException;

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
	 * JPQL Query - findTeamByPublishYn
	 *
	 */
	public Set<Team> findTeamByPublishYn(Integer publishYn) throws DataAccessException;

	/**
	 * JPQL Query - findTeamByPublishYn
	 *
	 */
	public Set<Team> findTeamByPublishYn(Integer publishYn, int startResult, int maxRows) throws DataAccessException;

}