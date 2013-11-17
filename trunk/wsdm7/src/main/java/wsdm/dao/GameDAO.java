package wsdm.dao;

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