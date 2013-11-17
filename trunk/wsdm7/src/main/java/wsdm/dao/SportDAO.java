package wsdm.dao;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import wsdm.domain.Sport;

/**
 * DAO to manage Sport entities.
 * 
 */
public interface SportDAO extends JpaDao<Sport> {

	/**
	 * JPQL Query - findSportBySportNameContaining
	 *
	 */
	public Set<Sport> findSportBySportNameContaining(String sportName) throws DataAccessException;

	/**
	 * JPQL Query - findSportBySportNameContaining
	 *
	 */
	public Set<Sport> findSportBySportNameContaining(String sportName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSportByNormalSeason
	 *
	 */
	public Set<Sport> findSportByNormalSeason(String normalSeason) throws DataAccessException;

	/**
	 * JPQL Query - findSportByNormalSeason
	 *
	 */
	public Set<Sport> findSportByNormalSeason(String normalSeason, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSportByWikiUrlContaining
	 *
	 */
	public Set<Sport> findSportByWikiUrlContaining(String wikiUrl) throws DataAccessException;

	/**
	 * JPQL Query - findSportByWikiUrlContaining
	 *
	 */
	public Set<Sport> findSportByWikiUrlContaining(String wikiUrl, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllSports
	 *
	 */
	public Set<Sport> findAllSports() throws DataAccessException;

	/**
	 * JPQL Query - findAllSports
	 *
	 */
	public Set<Sport> findAllSports(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSportByWikiUrl
	 *
	 */
	public Set<Sport> findSportByWikiUrl(String wikiUrl_1) throws DataAccessException;

	/**
	 * JPQL Query - findSportByWikiUrl
	 *
	 */
	public Set<Sport> findSportByWikiUrl(String wikiUrl_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSportBySportId
	 *
	 */
	public Sport findSportBySportId(Integer sportId) throws DataAccessException;

	/**
	 * JPQL Query - findSportBySportId
	 *
	 */
	public Sport findSportBySportId(Integer sportId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSportByNormalSeasonContaining
	 *
	 */
	public Set<Sport> findSportByNormalSeasonContaining(String normalSeason_1) throws DataAccessException;

	/**
	 * JPQL Query - findSportByNormalSeasonContaining
	 *
	 */
	public Set<Sport> findSportByNormalSeasonContaining(String normalSeason_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSportByNumTeamRoster
	 *
	 */
	public Set<Sport> findSportByNumTeamRoster(Integer numTeamRoster) throws DataAccessException;

	/**
	 * JPQL Query - findSportByNumTeamRoster
	 *
	 */
	public Set<Sport> findSportByNumTeamRoster(Integer numTeamRoster, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSportByNumGamePlayers
	 *
	 */
	public Set<Sport> findSportByNumGamePlayers(Integer numGamePlayers) throws DataAccessException;

	/**
	 * JPQL Query - findSportByNumGamePlayers
	 *
	 */
	public Set<Sport> findSportByNumGamePlayers(Integer numGamePlayers, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSportByPrimaryKey
	 *
	 */
	public Sport findSportByPrimaryKey(Integer sportId_1) throws DataAccessException;

	/**
	 * JPQL Query - findSportByPrimaryKey
	 *
	 */
	public Sport findSportByPrimaryKey(Integer sportId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSportByActiveYn
	 *
	 */
	public Set<Sport> findSportByActiveYn(Integer activeYn) throws DataAccessException;

	/**
	 * JPQL Query - findSportByActiveYn
	 *
	 */
	public Set<Sport> findSportByActiveYn(Integer activeYn, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSportBySportName
	 *
	 */
	public Set<Sport> findSportBySportName(String sportName_1) throws DataAccessException;

	/**
	 * JPQL Query - findSportBySportName
	 *
	 */
	public Set<Sport> findSportBySportName(String sportName_1, int startResult, int maxRows) throws DataAccessException;

}