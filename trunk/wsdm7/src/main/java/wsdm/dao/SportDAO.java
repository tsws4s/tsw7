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
	 * JPQL Query - findSportByPrimaryKey
	 *
	 */
	public Sport findSportByPrimaryKey(Integer sportId) throws DataAccessException;

	/**
	 * JPQL Query - findSportByPrimaryKey
	 *
	 */
	public Sport findSportByPrimaryKey(Integer sportId, int startResult, int maxRows) throws DataAccessException;

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

}