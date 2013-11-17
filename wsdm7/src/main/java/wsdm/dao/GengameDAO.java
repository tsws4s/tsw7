package wsdm.dao;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import wsdm.domain.Gengame;

/**
 * DAO to manage Gengame entities.
 * 
 */
public interface GengameDAO extends JpaDao<Gengame> {

	/**
	 * JPQL Query - findGengameByPrimaryKey
	 *
	 */
	public Gengame findGengameByPrimaryKey(Integer genGameId) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByPrimaryKey
	 *
	 */
	public Gengame findGengameByPrimaryKey(Integer genGameId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByGameNum
	 *
	 */
	public Set<Gengame> findGengameByGameNum(Integer gameNum) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByGameNum
	 *
	 */
	public Set<Gengame> findGengameByGameNum(Integer gameNum, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByGameDateTime
	 *
	 */
	public Set<Gengame> findGengameByGameDateTime(java.util.Calendar gameDateTime) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByGameDateTime
	 *
	 */
	public Set<Gengame> findGengameByGameDateTime(Calendar gameDateTime, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByVisitorTeamName
	 *
	 */
	public Set<Gengame> findGengameByVisitorTeamName(String visitorTeamName) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByVisitorTeamName
	 *
	 */
	public Set<Gengame> findGengameByVisitorTeamName(String visitorTeamName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByHomeTeamNameContaining
	 *
	 */
	public Set<Gengame> findGengameByHomeTeamNameContaining(String homeTeamName) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByHomeTeamNameContaining
	 *
	 */
	public Set<Gengame> findGengameByHomeTeamNameContaining(String homeTeamName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByHomeTeamId
	 *
	 */
	public Set<Gengame> findGengameByHomeTeamId(Integer homeTeamId) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByHomeTeamId
	 *
	 */
	public Set<Gengame> findGengameByHomeTeamId(Integer homeTeamId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByVisitorTeamId
	 *
	 */
	public Set<Gengame> findGengameByVisitorTeamId(Integer visitorTeamId) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByVisitorTeamId
	 *
	 */
	public Set<Gengame> findGengameByVisitorTeamId(Integer visitorTeamId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByResourceId
	 *
	 */
	public Set<Gengame> findGengameByResourceId(Integer resourceId) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByResourceId
	 *
	 */
	public Set<Gengame> findGengameByResourceId(Integer resourceId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByHomeTeamName
	 *
	 */
	public Set<Gengame> findGengameByHomeTeamName(String homeTeamName_1) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByHomeTeamName
	 *
	 */
	public Set<Gengame> findGengameByHomeTeamName(String homeTeamName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByVisitorTeamNameContaining
	 *
	 */
	public Set<Gengame> findGengameByVisitorTeamNameContaining(String visitorTeamName_1) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByVisitorTeamNameContaining
	 *
	 */
	public Set<Gengame> findGengameByVisitorTeamNameContaining(String visitorTeamName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByGenGameId
	 *
	 */
	public Gengame findGengameByGenGameId(Integer genGameId_1) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByGenGameId
	 *
	 */
	public Gengame findGengameByGenGameId(Integer genGameId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByResourceName
	 *
	 */
	public Set<Gengame> findGengameByResourceName(String resourceName) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByResourceName
	 *
	 */
	public Set<Gengame> findGengameByResourceName(String resourceName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByResourceNameContaining
	 *
	 */
	public Set<Gengame> findGengameByResourceNameContaining(String resourceName_1) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByResourceNameContaining
	 *
	 */
	public Set<Gengame> findGengameByResourceNameContaining(String resourceName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByRefereeName
	 *
	 */
	public Set<Gengame> findGengameByRefereeName(String refereeName) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByRefereeName
	 *
	 */
	public Set<Gengame> findGengameByRefereeName(String refereeName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByRefereeId
	 *
	 */
	public Set<Gengame> findGengameByRefereeId(Integer refereeId) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByRefereeId
	 *
	 */
	public Set<Gengame> findGengameByRefereeId(Integer refereeId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByRefereeNameContaining
	 *
	 */
	public Set<Gengame> findGengameByRefereeNameContaining(String refereeName_1) throws DataAccessException;

	/**
	 * JPQL Query - findGengameByRefereeNameContaining
	 *
	 */
	public Set<Gengame> findGengameByRefereeNameContaining(String refereeName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllGengames
	 *
	 */
	public Set<Gengame> findAllGengames() throws DataAccessException;

	/**
	 * JPQL Query - findAllGengames
	 *
	 */
	public Set<Gengame> findAllGengames(int startResult, int maxRows) throws DataAccessException;

}