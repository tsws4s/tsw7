package wsdm.dao;

import java.math.BigDecimal;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import wsdm.domain.Participant;

/**
 * DAO to manage Participant entities.
 * 
 */
public interface ParticipantDAO extends JpaDao<Participant> {

	/**
	 * JPQL Query - findParticipantByParticipantId
	 *
	 */
	public Participant findParticipantByParticipantId(Integer participantId) throws DataAccessException;

	/**
	 * JPQL Query - findParticipantByParticipantId
	 *
	 */
	public Participant findParticipantByParticipantId(Integer participantId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findParticipantByPrimaryKey
	 *
	 */
	public Participant findParticipantByPrimaryKey(Integer participantId_1) throws DataAccessException;

	/**
	 * JPQL Query - findParticipantByPrimaryKey
	 *
	 */
	public Participant findParticipantByPrimaryKey(Integer participantId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findParticipantByAmtPaid
	 *
	 */
	public Set<Participant> findParticipantByAmtPaid(java.math.BigDecimal amtPaid) throws DataAccessException;

	/**
	 * JPQL Query - findParticipantByAmtPaid
	 *
	 */
	public Set<Participant> findParticipantByAmtPaid(BigDecimal amtPaid, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findParticipantByGroup1Containing
	 *
	 */
	public Set<Participant> findParticipantByGroup1Containing(String group1) throws DataAccessException;

	/**
	 * JPQL Query - findParticipantByGroup1Containing
	 *
	 */
	public Set<Participant> findParticipantByGroup1Containing(String group1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findParticipantByGroup1
	 *
	 */
	public Set<Participant> findParticipantByGroup1(String group1_1) throws DataAccessException;

	/**
	 * JPQL Query - findParticipantByGroup1
	 *
	 */
	public Set<Participant> findParticipantByGroup1(String group1_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findParticipantBySignedWaiverYn
	 *
	 */
	public Set<Participant> findParticipantBySignedWaiverYn(Integer signedWaiverYn) throws DataAccessException;

	/**
	 * JPQL Query - findParticipantBySignedWaiverYn
	 *
	 */
	public Set<Participant> findParticipantBySignedWaiverYn(Integer signedWaiverYn, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findParticipantByNotes
	 *
	 */
	public Set<Participant> findParticipantByNotes(String notes) throws DataAccessException;

	/**
	 * JPQL Query - findParticipantByNotes
	 *
	 */
	public Set<Participant> findParticipantByNotes(String notes, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findParticipantByActiveYn
	 *
	 */
	public Set<Participant> findParticipantByActiveYn(Integer activeYn) throws DataAccessException;

	/**
	 * JPQL Query - findParticipantByActiveYn
	 *
	 */
	public Set<Participant> findParticipantByActiveYn(Integer activeYn, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findParticipantByNotesContaining
	 *
	 */
	public Set<Participant> findParticipantByNotesContaining(String notes_1) throws DataAccessException;

	/**
	 * JPQL Query - findParticipantByNotesContaining
	 *
	 */
	public Set<Participant> findParticipantByNotesContaining(String notes_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllParticipants
	 *
	 */
	public Set<Participant> findAllParticipants() throws DataAccessException;

	/**
	 * JPQL Query - findAllParticipants
	 *
	 */
	public Set<Participant> findAllParticipants(int startResult, int maxRows) throws DataAccessException;

}