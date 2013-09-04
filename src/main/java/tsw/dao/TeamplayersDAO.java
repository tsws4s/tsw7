package tsw.dao;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import tsw.domain.Teamplayers;

/**
 * DAO to manage Teamplayers entities.
 * 
 */
public interface TeamplayersDAO extends JpaDao<Teamplayers> {

	/**
	 * JPQL Query - findTeamplayersByActiveYn
	 *
	 */
	public Set<Teamplayers> findTeamplayersByActiveYn(Integer activeYn) throws DataAccessException;

	/**
	 * JPQL Query - findTeamplayersByActiveYn
	 *
	 */
	public Set<Teamplayers> findTeamplayersByActiveYn(Integer activeYn, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTeamplayersByNotesContaining
	 *
	 */
	public Set<Teamplayers> findTeamplayersByNotesContaining(String notes) throws DataAccessException;

	/**
	 * JPQL Query - findTeamplayersByNotesContaining
	 *
	 */
	public Set<Teamplayers> findTeamplayersByNotesContaining(String notes, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTeamplayersByNotes
	 *
	 */
	public Set<Teamplayers> findTeamplayersByNotes(String notes_1) throws DataAccessException;

	/**
	 * JPQL Query - findTeamplayersByNotes
	 *
	 */
	public Set<Teamplayers> findTeamplayersByNotes(String notes_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTeamplayersByAmtPaid
	 *
	 */
	public Set<Teamplayers> findTeamplayersByAmtPaid(Integer amtPaid) throws DataAccessException;

	/**
	 * JPQL Query - findTeamplayersByAmtPaid
	 *
	 */
	public Set<Teamplayers> findTeamplayersByAmtPaid(Integer amtPaid, int startResult, int maxRows) throws DataAccessException;

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

	/**
	 * JPQL Query - findTeamplayersByGroup2
	 *
	 */
	public Set<Teamplayers> findTeamplayersByGroup2(String group2) throws DataAccessException;

	/**
	 * JPQL Query - findTeamplayersByGroup2
	 *
	 */
	public Set<Teamplayers> findTeamplayersByGroup2(String group2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTeamplayersByGroup2Containing
	 *
	 */
	public Set<Teamplayers> findTeamplayersByGroup2Containing(String group2_1) throws DataAccessException;

	/**
	 * JPQL Query - findTeamplayersByGroup2Containing
	 *
	 */
	public Set<Teamplayers> findTeamplayersByGroup2Containing(String group2_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllTeamplayerss
	 *
	 */
	public Set<Teamplayers> findAllTeamplayerss4tsw(Integer tswId) throws DataAccessException;

	/**
	 * JPQL Query - findAllTeamplayerss
	 *
	 */
	public Set<Teamplayers> findAllTeamplayerss4tsw(Integer tswId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTeamplayersByTeamPlayersId
	 *
	 */
	public Teamplayers findTeamplayersByTeamPlayersId(Integer teamPlayersId_1) throws DataAccessException;

	/**
	 * JPQL Query - findTeamplayersByTeamPlayersId
	 *
	 */
	public Teamplayers findTeamplayersByTeamPlayersId(Integer teamPlayersId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTeamplayersBySignedWaiverYn
	 *
	 */
	public Set<Teamplayers> findTeamplayersBySignedWaiverYn(Integer signedWaiverYn) throws DataAccessException;

	/**
	 * JPQL Query - findTeamplayersBySignedWaiverYn
	 *
	 */
	public Set<Teamplayers> findTeamplayersBySignedWaiverYn(Integer signedWaiverYn, int startResult, int maxRows) throws DataAccessException;

	public Integer getMaxTeamplayersID();

}