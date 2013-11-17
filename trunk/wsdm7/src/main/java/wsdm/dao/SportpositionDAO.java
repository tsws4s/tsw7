package wsdm.dao;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import wsdm.domain.Sportposition;

/**
 * DAO to manage Sportposition entities.
 * 
 */
public interface SportpositionDAO extends JpaDao<Sportposition> {

	/**
	 * JPQL Query - findSportpositionByPrimaryKey
	 *
	 */
	public Sportposition findSportpositionByPrimaryKey(Integer sportPositionId) throws DataAccessException;

	/**
	 * JPQL Query - findSportpositionByPrimaryKey
	 *
	 */
	public Sportposition findSportpositionByPrimaryKey(Integer sportPositionId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSportpositionByNumTeamPlayers
	 *
	 */
	public Set<Sportposition> findSportpositionByNumTeamPlayers(Integer numTeamPlayers) throws DataAccessException;

	/**
	 * JPQL Query - findSportpositionByNumTeamPlayers
	 *
	 */
	public Set<Sportposition> findSportpositionByNumTeamPlayers(Integer numTeamPlayers, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSportpositionByNumGamePlayers
	 *
	 */
	public Set<Sportposition> findSportpositionByNumGamePlayers(Integer numGamePlayers) throws DataAccessException;

	/**
	 * JPQL Query - findSportpositionByNumGamePlayers
	 *
	 */
	public Set<Sportposition> findSportpositionByNumGamePlayers(Integer numGamePlayers, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSportpositionBySportPositionId
	 *
	 */
	public Sportposition findSportpositionBySportPositionId(Integer sportPositionId_1) throws DataAccessException;

	/**
	 * JPQL Query - findSportpositionBySportPositionId
	 *
	 */
	public Sportposition findSportpositionBySportPositionId(Integer sportPositionId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSportpositionBySportPositionNameContaining
	 *
	 */
	public Set<Sportposition> findSportpositionBySportPositionNameContaining(String sportPositionName) throws DataAccessException;

	/**
	 * JPQL Query - findSportpositionBySportPositionNameContaining
	 *
	 */
	public Set<Sportposition> findSportpositionBySportPositionNameContaining(String sportPositionName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllSportpositions
	 *
	 */
	public Set<Sportposition> findAllSportpositions() throws DataAccessException;

	/**
	 * JPQL Query - findAllSportpositions
	 *
	 */
	public Set<Sportposition> findAllSportpositions(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSportpositionBySportPositionName
	 *
	 */
	public Set<Sportposition> findSportpositionBySportPositionName(String sportPositionName_1) throws DataAccessException;

	/**
	 * JPQL Query - findSportpositionBySportPositionName
	 *
	 */
	public Set<Sportposition> findSportpositionBySportPositionName(String sportPositionName_1, int startResult, int maxRows) throws DataAccessException;

}