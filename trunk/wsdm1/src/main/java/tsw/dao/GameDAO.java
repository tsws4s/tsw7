package tsw.dao;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import tsw.domain.Game;

/**
 * DAO to manage Game entities.
 * 
 */
public interface GameDAO extends JpaDao<Game> {

	/**
	 * JPQL Query - findGameByGameDateAfter
	 *
	 */
	public Set<Game> findGameByGameDateAfter(java.util.Calendar gameDate) throws DataAccessException;

	/**
	 * JPQL Query - findGameByGameDateAfter
	 *
	 */
	public Set<Game> findGameByGameDateAfter(Calendar gameDate, int startResult, int maxRows) throws DataAccessException;

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
	 * JPQL Query - findAllGames
	 *
	 */
	public Set<Game> findAllGames4tsw(Integer tswId) throws DataAccessException;

	/**
	 * JPQL Query - findAllGames
	 *
	 */
	public Set<Game> findAllGames4tsw(Integer tswId, int startResult, int maxRows) throws DataAccessException;

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
	 * JPQL Query - findGameByGameDate
	 *
	 */
	public Set<Game> findGameByGameDate(java.util.Calendar gameDate_1) throws DataAccessException;

	/**
	 * JPQL Query - findGameByGameDate
	 *
	 */
	public Set<Game> findGameByGameDate(Calendar gameDate_1, int startResult, int maxRows) throws DataAccessException;

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
	 * JPQL Query - findGameByGameDateBefore
	 *
	 */
	public Set<Game> findGameByGameDateBefore(java.util.Calendar gameDate_2) throws DataAccessException;

	/**
	 * JPQL Query - findGameByGameDateBefore
	 *
	 */
	public Set<Game> findGameByGameDateBefore(Calendar gameDate_2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGameByGameId
	 *
	 */
	public Game findGameByGameId(Integer gameId) throws DataAccessException;

	/**
	 * JPQL Query - findGameByGameId
	 *
	 */
	public Game findGameByGameId(Integer gameId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGameByPrimaryKey
	 *
	 */
	public Game findGameByPrimaryKey(Integer gameId_1) throws DataAccessException;

	/**
	 * JPQL Query - findGameByPrimaryKey
	 *
	 */
	public Game findGameByPrimaryKey(Integer gameId_1, int startResult, int maxRows) throws DataAccessException;

	public Integer getMaxGameID();

}