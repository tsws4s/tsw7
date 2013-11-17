package wsdm.dao;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import wsdm.domain.Teamplayers;

/**
 * DAO to manage Teamplayers entities.
 * 
 */
public interface TeamplayersDAO extends JpaDao<Teamplayers> {

	/**
	 * JPQL Query - findAllTeamplayerss
	 *
	 */
	public Set<Teamplayers> findAllTeamplayerss() throws DataAccessException;

	/**
	 * JPQL Query - findAllTeamplayerss
	 *
	 */
	public Set<Teamplayers> findAllTeamplayerss(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTeamplayersByPrimaryKey
	 *
	 */
	public Teamplayers findTeamplayersByPrimaryKey(Integer teamPlayersId) throws DataAccessException;

	/**
	 * JPQL Query - findTeamplayersByPrimaryKey
	 *
	 */
	public Teamplayers findTeamplayersByPrimaryKey(Integer teamPlayersId, int startResult, int maxRows) throws DataAccessException;

}