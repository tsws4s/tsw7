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
	 * JPQL Query - findAllLevels
	 *
	 */
	public Set<Level> findAllLevels() throws DataAccessException;

	/**
	 * JPQL Query - findAllLevels
	 *
	 */
	public Set<Level> findAllLevels(int startResult, int maxRows) throws DataAccessException;

}