package wsdm.dao;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import wsdm.domain.Level;

/**
 * DAO to manage Level entities.
 * 
 */
public interface LevelDAO extends JpaDao<Level> {

	/**
	 * JPQL Query - findLevelByLevelName
	 *
	 */
	public Set<Level> findLevelByLevelName(String levelName) throws DataAccessException;

	/**
	 * JPQL Query - findLevelByLevelName
	 *
	 */
	public Set<Level> findLevelByLevelName(String levelName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findLevelByLevelCode
	 *
	 */
	public Set<Level> findLevelByLevelCode(String levelCode) throws DataAccessException;

	/**
	 * JPQL Query - findLevelByLevelCode
	 *
	 */
	public Set<Level> findLevelByLevelCode(String levelCode, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findLevelByLevelCodeContaining
	 *
	 */
	public Set<Level> findLevelByLevelCodeContaining(String levelCode_1) throws DataAccessException;

	/**
	 * JPQL Query - findLevelByLevelCodeContaining
	 *
	 */
	public Set<Level> findLevelByLevelCodeContaining(String levelCode_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findLevelByActiveYn
	 *
	 */
	public Set<Level> findLevelByActiveYn(Integer activeYn) throws DataAccessException;

	/**
	 * JPQL Query - findLevelByActiveYn
	 *
	 */
	public Set<Level> findLevelByActiveYn(Integer activeYn, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllLevels
	 *
	 */
	public Set<Level> findAllLevels() throws DataAccessException;

	/**
	 * JPQL Query - findAllLevels
	 *
	 */
	public Set<Level> findAllLevels(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findLevelByPrimaryKey
	 *
	 */
	public Level findLevelByPrimaryKey(Integer levelId) throws DataAccessException;

	/**
	 * JPQL Query - findLevelByPrimaryKey
	 *
	 */
	public Level findLevelByPrimaryKey(Integer levelId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findLevelByLevelId
	 *
	 */
	public Level findLevelByLevelId(Integer levelId_1) throws DataAccessException;

	/**
	 * JPQL Query - findLevelByLevelId
	 *
	 */
	public Level findLevelByLevelId(Integer levelId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findLevelByAgeHigh
	 *
	 */
	public Set<Level> findLevelByAgeHigh(Integer ageHigh) throws DataAccessException;

	/**
	 * JPQL Query - findLevelByAgeHigh
	 *
	 */
	public Set<Level> findLevelByAgeHigh(Integer ageHigh, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findLevelByAgeLow
	 *
	 */
	public Set<Level> findLevelByAgeLow(Integer ageLow) throws DataAccessException;

	/**
	 * JPQL Query - findLevelByAgeLow
	 *
	 */
	public Set<Level> findLevelByAgeLow(Integer ageLow, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findLevelByLevelNameContaining
	 *
	 */
	public Set<Level> findLevelByLevelNameContaining(String levelName_1) throws DataAccessException;

	/**
	 * JPQL Query - findLevelByLevelNameContaining
	 *
	 */
	public Set<Level> findLevelByLevelNameContaining(String levelName_1, int startResult, int maxRows) throws DataAccessException;

}