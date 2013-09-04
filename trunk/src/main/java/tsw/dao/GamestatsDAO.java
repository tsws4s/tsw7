package tsw.dao;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import tsw.domain.Gamestats;

/**
 * DAO to manage Gamestats entities.
 * 
 */
public interface GamestatsDAO extends JpaDao<Gamestats> {

	/**
	 * JPQL Query - findGamestatsByGameStatValue
	 *
	 */
	public Set<Gamestats> findGamestatsByGameStatValue(Integer gameStatValue) throws DataAccessException;

	/**
	 * JPQL Query - findGamestatsByGameStatValue
	 *
	 */
	public Set<Gamestats> findGamestatsByGameStatValue(Integer gameStatValue, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGamestatsByGameStatsId
	 *
	 */
	public Gamestats findGamestatsByGameStatsId(Integer gameStatsId) throws DataAccessException;

	/**
	 * JPQL Query - findGamestatsByGameStatsId
	 *
	 */
	public Gamestats findGamestatsByGameStatsId(Integer gameStatsId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGamestatsBySportStatTypeFk
	 *
	 */
	public Set<Gamestats> findGamestatsBySportStatTypeFk(Integer sportStatTypeFk) throws DataAccessException;

	/**
	 * JPQL Query - findGamestatsBySportStatTypeFk
	 *
	 */
	public Set<Gamestats> findGamestatsBySportStatTypeFk(Integer sportStatTypeFk, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGamestatsByPrimaryKey
	 *
	 */
	public Gamestats findGamestatsByPrimaryKey(Integer gameStatsId_1) throws DataAccessException;

	/**
	 * JPQL Query - findGamestatsByPrimaryKey
	 *
	 */
	public Gamestats findGamestatsByPrimaryKey(Integer gameStatsId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllGamestatss
	 *
	 */
	public Set<Gamestats> findAllGamestatss() throws DataAccessException;

	/**
	 * JPQL Query - findAllGamestatss
	 *
	 */
	public Set<Gamestats> findAllGamestatss(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGamestatsByGameStatTime
	 *
	 */
	public Set<Gamestats> findGamestatsByGameStatTime(java.util.Calendar gameStatTime) throws DataAccessException;

	/**
	 * JPQL Query - findGamestatsByGameStatTime
	 *
	 */
	public Set<Gamestats> findGamestatsByGameStatTime(Calendar gameStatTime, int startResult, int maxRows) throws DataAccessException;
	public Integer getGamestatsMaxId();
}