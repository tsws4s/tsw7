package tsw.dao;

import tsw.domain.ProgGenGames;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage ProgGenGames entities.
 * 
 */
public interface ProggengamesDAO extends JpaDao<ProgGenGames> {

	/**
	 * JPQL Query - findAllProggengamess
	 *
	 */
	public Set<ProgGenGames> findAllProggengamess() throws DataAccessException;

	/**
	 * JPQL Query - findAllProggengamess
	 *
	 */
	public Set<ProgGenGames> findAllProggengamess(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProggengamesByPrimaryKey
	 *
	 */
	public ProgGenGames findProggengamesByPrimaryKey(Integer progGenGamesId) throws DataAccessException;

	/**
	 * JPQL Query - findProggengamesByPrimaryKey
	 *
	 */
	public ProgGenGames findProggengamesByPrimaryKey(Integer progGenGamesId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProggengamesByProgramName
	 *
	 */
	public Set<ProgGenGames> findProggengamesByProgramName(String programName) throws DataAccessException;

	/**
	 * JPQL Query - findProggengamesByProgramName
	 *
	 */
	public Set<ProgGenGames> findProggengamesByProgramName(String programName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProggengamesByStartDate
	 *
	 */
	public Set<ProgGenGames> findProggengamesByStartDate(java.util.Calendar startDate) throws DataAccessException;

	/**
	 * JPQL Query - findProggengamesByStartDate
	 *
	 */
	public Set<ProgGenGames> findProggengamesByStartDate(Calendar startDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProggengamesByProgramId
	 *
	 */
	public Set<ProgGenGames> findProggengamesByProgramId(Integer programId) throws DataAccessException;

	/**
	 * JPQL Query - findProggengamesByProgramId
	 *
	 */
	public Set<ProgGenGames> findProggengamesByProgramId(Integer programId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProggengamesByProgramNameContaining
	 *
	 */
	public Set<ProgGenGames> findProggengamesByProgramNameContaining(String programName_1) throws DataAccessException;

	/**
	 * JPQL Query - findProggengamesByProgramNameContaining
	 *
	 */
	public Set<ProgGenGames> findProggengamesByProgramNameContaining(String programName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProggengamesByProgGenGamesId
	 *
	 */
	public ProgGenGames findProggengamesByProgGenGamesId(Integer progGenGamesId_1) throws DataAccessException;

	/**
	 * JPQL Query - findProggengamesByProgGenGamesId
	 *
	 */
	public ProgGenGames findProggengamesByProgGenGamesId(Integer progGenGamesId_1, int startResult, int maxRows) throws DataAccessException;

}