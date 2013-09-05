package tsw.dao;

import tsw.domain.GenGame;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage GenGame entities.
 * 
 */
public interface GengameDAO extends JpaDao<GenGame> {

	/**
	 * JPQL Query - findGengameByVisitorTeamId
	 *
	 */
	public Set<GenGame> findGengameByVisitorTeamId(Integer visitorTeamId) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByVisitorTeamId
	 *
	 */
	public Set<GenGame> findGengameByVisitorTeamId(Integer visitorTeamId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByResourceNameContaining
	 *
	 */
	public Set<GenGame> findGengameByResourceNameContaining(String resourceName) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByResourceNameContaining
	 *
	 */
	public Set<GenGame> findGengameByResourceNameContaining(String resourceName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByPrimaryKey
	 *
	 */
	public GenGame findGengameByPrimaryKey(Integer genGameId) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByPrimaryKey
	 *
	 */
	public GenGame findGengameByPrimaryKey(Integer genGameId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByGenGameId
	 *
	 */
	public GenGame findGengameByGenGameId(Integer genGameId_1) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByGenGameId
	 *
	 */
	public GenGame findGengameByGenGameId(Integer genGameId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByHomeTeamName
	 *
	 */
	public Set<GenGame> findGengameByHomeTeamName(String homeTeamName) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByHomeTeamName
	 *
	 */
	public Set<GenGame> findGengameByHomeTeamName(String homeTeamName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByGameDateTime
	 *
	 */
	public Set<GenGame> findGengameByGameDateTime(java.util.Calendar gameDateTime) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByGameDateTime
	 *
	 */
	public Set<GenGame> findGengameByGameDateTime(Calendar gameDateTime, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByVisitorTeamName
	 *
	 */
	public Set<GenGame> findGengameByVisitorTeamName(String visitorTeamName) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByVisitorTeamName
	 *
	 */
	public Set<GenGame> findGengameByVisitorTeamName(String visitorTeamName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByHomeTeamNameContaining
	 *
	 */
	public Set<GenGame> findGengameByHomeTeamNameContaining(String homeTeamName_1) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByHomeTeamNameContaining
	 *
	 */
	public Set<GenGame> findGengameByHomeTeamNameContaining(String homeTeamName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllGengames
	 *
	 */
	public Set<GenGame> findAllGengames() throws DataAccessException;

	/**
	 * JPQL Query - findAllGengames
	 *
	 */
	public Set<GenGame> findAllGengames(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByHomeTeamId
	 *
	 */
	public Set<GenGame> findGengameByHomeTeamId(Integer homeTeamId) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByHomeTeamId
	 *
	 */
	public Set<GenGame> findGengameByHomeTeamId(Integer homeTeamId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByGameNum
	 *
	 */
	public Set<GenGame> findGengameByGameNum(Integer gameNum) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByGameNum
	 *
	 */
	public Set<GenGame> findGengameByGameNum(Integer gameNum, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByResourceId
	 *
	 */
	public Set<GenGame> findGengameByResourceId(Integer resourceId) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByResourceId
	 *
	 */
	public Set<GenGame> findGengameByResourceId(Integer resourceId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByRefereeNameContaining
	 *
	 */
	public Set<GenGame> findGengameByRefereeNameContaining(String refereeName) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByRefereeNameContaining
	 *
	 */
	public Set<GenGame> findGengameByRefereeNameContaining(String refereeName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByRefereeName
	 *
	 */
	public Set<GenGame> findGengameByRefereeName(String refereeName_1) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByRefereeName
	 *
	 */
	public Set<GenGame> findGengameByRefereeName(String refereeName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByResourceName
	 *
	 */
	public Set<GenGame> findGengameByResourceName(String resourceName_1) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByResourceName
	 *
	 */
	public Set<GenGame> findGengameByResourceName(String resourceName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByVisitorTeamNameContaining
	 *
	 */
	public Set<GenGame> findGengameByVisitorTeamNameContaining(String visitorTeamName_1) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByVisitorTeamNameContaining
	 *
	 */
	public Set<GenGame> findGengameByVisitorTeamNameContaining(String visitorTeamName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByRefereeId
	 *
	 */
	public Set<GenGame> findGengameByRefereeId(Integer refereeId) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByRefereeId
	 *
	 */
	public Set<GenGame> findGengameByRefereeId(Integer refereeId, int startResult, int maxRows) throws DataAccessException;

}