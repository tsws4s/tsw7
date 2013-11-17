package wsdm.dao;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import wsdm.domain.Proggengames;

/**
 * DAO to manage Proggengames entities.
 * 
 */
public interface ProggengamesDAO extends JpaDao<Proggengames> {

	/**
	 * JPQL Query - findProggengamesByProgGenGamesId
	 *
	 */
	public Proggengames findProggengamesByProgGenGamesId(Integer progGenGamesId) throws DataAccessException;

	/**
	 * JPQL Query - findProggengamesByProgGenGamesId
	 *
	 */
	public Proggengames findProggengamesByProgGenGamesId(Integer progGenGamesId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProggengamesByProgramId
	 *
	 */
	public Set<Proggengames> findProggengamesByProgramId(Integer programId) throws DataAccessException;

	/**
	 * JPQL Query - findProggengamesByProgramId
	 *
	 */
	public Set<Proggengames> findProggengamesByProgramId(Integer programId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProggengamesByPrimaryKey
	 *
	 */
	public Proggengames findProggengamesByPrimaryKey(Integer progGenGamesId_1) throws DataAccessException;

	/**
	 * JPQL Query - findProggengamesByPrimaryKey
	 *
	 */
	public Proggengames findProggengamesByPrimaryKey(Integer progGenGamesId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProggengamesByStartDate
	 *
	 */
	public Set<Proggengames> findProggengamesByStartDate(java.util.Calendar startDate) throws DataAccessException;

	/**
	 * JPQL Query - findProggengamesByStartDate
	 *
	 */
	public Set<Proggengames> findProggengamesByStartDate(Calendar startDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllProggengamess
	 *
	 */
	public Set<Proggengames> findAllProggengamess() throws DataAccessException;

	/**
	 * JPQL Query - findAllProggengamess
	 *
	 */
	public Set<Proggengames> findAllProggengamess(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProggengamesByProgramName
	 *
	 */
	public Set<Proggengames> findProggengamesByProgramName(String programName) throws DataAccessException;

	/**
	 * JPQL Query - findProggengamesByProgramName
	 *
	 */
	public Set<Proggengames> findProggengamesByProgramName(String programName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProggengamesByProgramNameContaining
	 *
	 */
	public Set<Proggengames> findProggengamesByProgramNameContaining(String programName_1) throws DataAccessException;

	/**
	 * JPQL Query - findProggengamesByProgramNameContaining
	 *
	 */
	public Set<Proggengames> findProggengamesByProgramNameContaining(String programName_1, int startResult, int maxRows) throws DataAccessException;

}