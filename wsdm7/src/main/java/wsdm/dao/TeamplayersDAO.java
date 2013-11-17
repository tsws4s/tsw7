package wsdm.dao;

import java.math.BigDecimal;

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
	 * JPQL Query - findTeamplayersByCaptain
	 *
	 */
	public Set<Teamplayers> findTeamplayersByCaptain(Integer captain) throws DataAccessException;

	/**
	 * JPQL Query - findTeamplayersByCaptain
	 *
	 */
	public Set<Teamplayers> findTeamplayersByCaptain(Integer captain, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTeamplayersByNotes
	 *
	 */
	public Set<Teamplayers> findTeamplayersByNotes(String notes) throws DataAccessException;

	/**
	 * JPQL Query - findTeamplayersByNotes
	 *
	 */
	public Set<Teamplayers> findTeamplayersByNotes(String notes, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTeamplayersByGroup2Containing
	 *
	 */
	public Set<Teamplayers> findTeamplayersByGroup2Containing(String group2) throws DataAccessException;

	/**
	 * JPQL Query - findTeamplayersByGroup2Containing
	 *
	 */
	public Set<Teamplayers> findTeamplayersByGroup2Containing(String group2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTeamplayersByNotesContaining
	 *
	 */
	public Set<Teamplayers> findTeamplayersByNotesContaining(String notes_1) throws DataAccessException;

	/**
	 * JPQL Query - findTeamplayersByNotesContaining
	 *
	 */
	public Set<Teamplayers> findTeamplayersByNotesContaining(String notes_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTeamplayersByTeamPlayersId
	 *
	 */
	public Teamplayers findTeamplayersByTeamPlayersId(Integer teamPlayersId) throws DataAccessException;

	/**
	 * JPQL Query - findTeamplayersByTeamPlayersId
	 *
	 */
	public Teamplayers findTeamplayersByTeamPlayersId(Integer teamPlayersId, int startResult, int maxRows) throws DataAccessException;

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

	/**
	 * JPQL Query - findTeamplayersByGroup2
	 *
	 */
	public Set<Teamplayers> findTeamplayersByGroup2(String group2_1) throws DataAccessException;

	/**
	 * JPQL Query - findTeamplayersByGroup2
	 *
	 */
	public Set<Teamplayers> findTeamplayersByGroup2(String group2_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTeamplayersByOtherAmtPaid
	 *
	 */
	public Set<Teamplayers> findTeamplayersByOtherAmtPaid(java.math.BigDecimal otherAmtPaid) throws DataAccessException;

	/**
	 * JPQL Query - findTeamplayersByOtherAmtPaid
	 *
	 */
	public Set<Teamplayers> findTeamplayersByOtherAmtPaid(BigDecimal otherAmtPaid, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTeamplayersByPrimaryKey
	 *
	 */
	public Teamplayers findTeamplayersByPrimaryKey(Integer teamPlayersId_1) throws DataAccessException;

	/**
	 * JPQL Query - findTeamplayersByPrimaryKey
	 *
	 */
	public Teamplayers findTeamplayersByPrimaryKey(Integer teamPlayersId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTeamplayersBySportPositionFk
	 *
	 */
	public Set<Teamplayers> findTeamplayersBySportPositionFk(Integer sportPositionFk) throws DataAccessException;

	/**
	 * JPQL Query - findTeamplayersBySportPositionFk
	 *
	 */
	public Set<Teamplayers> findTeamplayersBySportPositionFk(Integer sportPositionFk, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTeamplayersByAmtPaid
	 *
	 */
	public Set<Teamplayers> findTeamplayersByAmtPaid(java.math.BigDecimal amtPaid) throws DataAccessException;

	/**
	 * JPQL Query - findTeamplayersByAmtPaid
	 *
	 */
	public Set<Teamplayers> findTeamplayersByAmtPaid(BigDecimal amtPaid, int startResult, int maxRows) throws DataAccessException;

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

}