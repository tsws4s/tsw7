package wsdm.dao;

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
	 * JPQL Query - findAllParticipants
	 *
	 */
	public Set<Participant> findAllParticipants() throws DataAccessException;

	/**
	 * JPQL Query - findAllParticipants
	 *
	 */
	public Set<Participant> findAllParticipants(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findParticipantByPrimaryKey
	 *
	 */
	public Participant findParticipantByPrimaryKey(Integer participantId) throws DataAccessException;

	/**
	 * JPQL Query - findParticipantByPrimaryKey
	 *
	 */
	public Participant findParticipantByPrimaryKey(Integer participantId, int startResult, int maxRows) throws DataAccessException;

}