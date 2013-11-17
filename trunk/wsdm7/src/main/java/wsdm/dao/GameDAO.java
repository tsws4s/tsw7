package wsdm.dao;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import wsdm.domain.Game;

/**
 * DAO to manage Game entities.
 * 
 */
public interface GameDAO extends JpaDao<Game> {

	/**
	 * JPQL Query - findGameByGameDate
	 *
	 */
	public Set<Game> findGameByGameDate(java.util.Calendar gameDate) throws DataAccessException;

	/**
	 * JPQL Query - findGameByGameDate
	 *
	 */
	public Set<Game> findGameByGameDate(Calendar gameDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGameByGameDateBefore
	 *
	 */
	public Set<Game> findGameByGameDateBefore(java.util.Calendar gameDate_1) throws DataAccessException;

	/**
	 * JPQL Query - findGameByGameDateBefore
	 *
	 */
	public Set<Game> findGameByGameDateBefore(Calendar gameDate_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGameByActiveYn
	 *
	 */
	public Set<Game> findGameByActiveYn(Integer activeYn) throws DataAccessException;

	/**
	 * JPQL Query - findGameByActiveYn
	 *
	 */
	public Set<Game> findGameByActiveYn(Integer activeYn, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGameByVisitorScore
	 *
	 */
	public Set<Game> findGameByVisitorScore(Integer visitorScore) throws DataAccessException;

	/**
	 * JPQL Query - findGameByVisitorScore
	 *
	 */
	public Set<Game> findGameByVisitorScore(Integer visitorScore, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGameByHomeScore
	 *
	 */
	public Set<Game> findGameByHomeScore(Integer homeScore) throws DataAccessException;

	/**
	 * JPQL Query - findGameByHomeScore
	 *
	 */
	public Set<Game> findGameByHomeScore(Integer homeScore, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGameByRefereeFk
	 *
	 */
	public Set<Game> findGameByRefereeFk(Integer refereeFk) throws DataAccessException;

	/**
	 * JPQL Query - findGameByRefereeFk
	 *
	 */
	public Set<Game> findGameByRefereeFk(Integer refereeFk, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGameByPrimaryKey
	 *
	 */
	public Game findGameByPrimaryKey(Integer gameId) throws DataAccessException;

	/**
	 * JPQL Query - findGameByPrimaryKey
	 *
	 */
	public Game findGameByPrimaryKey(Integer gameId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGameByGameDateAfter
	 *
	 */
	public Set<Game> findGameByGameDateAfter(java.util.Calendar gameDate_2) throws DataAccessException;

	/**
	 * JPQL Query - findGameByGameDateAfter
	 *
	 */
	public Set<Game> findGameByGameDateAfter(Calendar gameDate_2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGameByGameId
	 *
	 */
	public Game findGameByGameId(Integer gameId_1) throws DataAccessException;

	/**
	 * JPQL Query - findGameByGameId
	 *
	 */
	public Game findGameByGameId(Integer gameId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllGames
	 *
	 */
	public Set<Game> findAllGames() throws DataAccessException;

	/**
	 * JPQL Query - findAllGames
	 *
	 */
	public Set<Game> findAllGames(int startResult, int maxRows) throws DataAccessException;

}