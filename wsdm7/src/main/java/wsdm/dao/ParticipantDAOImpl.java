package wsdm.dao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.skyway.spring.util.dao.AbstractJpaDao;

import org.springframework.dao.DataAccessException;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import wsdm.domain.Participant;

/**
 * DAO to manage Participant entities.
 * 
 */
@Repository("ParticipantDAO")
@Transactional
public class ParticipantDAOImpl extends AbstractJpaDao<Participant> implements
		ParticipantDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Participant.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_tsw
	 *
	 */
	@PersistenceContext(unitName = "mysql_tsw")
	private EntityManager entityManager;

	/**
	 * Instantiates a new ParticipantDAOImpl
	 *
	 */
	public ParticipantDAOImpl() {
		super();
	}

	/**
	 * Get the entity manager that manages persistence unit 
	 *
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Returns the set of entity classes managed by this DAO.
	 *
	 */
	public Set<Class<?>> getTypes() {
		return dataTypes;
	}

	/**
	 * JPQL Query - findParticipantByParticipantId
	 *
	 */
	@Transactional
	public Participant findParticipantByParticipantId(Integer participantId) throws DataAccessException {

		return findParticipantByParticipantId(participantId, -1, -1);
	}

	/**
	 * JPQL Query - findParticipantByParticipantId
	 *
	 */

	@Transactional
	public Participant findParticipantByParticipantId(Integer participantId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findParticipantByParticipantId", startResult, maxRows, participantId);
			return (wsdm.domain.Participant) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findParticipantByPrimaryKey
	 *
	 */
	@Transactional
	public Participant findParticipantByPrimaryKey(Integer participantId) throws DataAccessException {

		return findParticipantByPrimaryKey(participantId, -1, -1);
	}

	/**
	 * JPQL Query - findParticipantByPrimaryKey
	 *
	 */

	@Transactional
	public Participant findParticipantByPrimaryKey(Integer participantId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findParticipantByPrimaryKey", startResult, maxRows, participantId);
			return (wsdm.domain.Participant) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findParticipantByAmtPaid
	 *
	 */
	@Transactional
	public Set<Participant> findParticipantByAmtPaid(java.math.BigDecimal amtPaid) throws DataAccessException {

		return findParticipantByAmtPaid(amtPaid, -1, -1);
	}

	/**
	 * JPQL Query - findParticipantByAmtPaid
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Participant> findParticipantByAmtPaid(java.math.BigDecimal amtPaid, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findParticipantByAmtPaid", startResult, maxRows, amtPaid);
		return new LinkedHashSet<Participant>(query.getResultList());
	}

	/**
	 * JPQL Query - findParticipantByGroup1Containing
	 *
	 */
	@Transactional
	public Set<Participant> findParticipantByGroup1Containing(String group1) throws DataAccessException {

		return findParticipantByGroup1Containing(group1, -1, -1);
	}

	/**
	 * JPQL Query - findParticipantByGroup1Containing
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Participant> findParticipantByGroup1Containing(String group1, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findParticipantByGroup1Containing", startResult, maxRows, group1);
		return new LinkedHashSet<Participant>(query.getResultList());
	}

	/**
	 * JPQL Query - findParticipantByGroup1
	 *
	 */
	@Transactional
	public Set<Participant> findParticipantByGroup1(String group1) throws DataAccessException {

		return findParticipantByGroup1(group1, -1, -1);
	}

	/**
	 * JPQL Query - findParticipantByGroup1
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Participant> findParticipantByGroup1(String group1, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findParticipantByGroup1", startResult, maxRows, group1);
		return new LinkedHashSet<Participant>(query.getResultList());
	}

	/**
	 * JPQL Query - findParticipantBySignedWaiverYn
	 *
	 */
	@Transactional
	public Set<Participant> findParticipantBySignedWaiverYn(Integer signedWaiverYn) throws DataAccessException {

		return findParticipantBySignedWaiverYn(signedWaiverYn, -1, -1);
	}

	/**
	 * JPQL Query - findParticipantBySignedWaiverYn
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Participant> findParticipantBySignedWaiverYn(Integer signedWaiverYn, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findParticipantBySignedWaiverYn", startResult, maxRows, signedWaiverYn);
		return new LinkedHashSet<Participant>(query.getResultList());
	}

	/**
	 * JPQL Query - findParticipantByNotes
	 *
	 */
	@Transactional
	public Set<Participant> findParticipantByNotes(String notes) throws DataAccessException {

		return findParticipantByNotes(notes, -1, -1);
	}

	/**
	 * JPQL Query - findParticipantByNotes
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Participant> findParticipantByNotes(String notes, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findParticipantByNotes", startResult, maxRows, notes);
		return new LinkedHashSet<Participant>(query.getResultList());
	}

	/**
	 * JPQL Query - findParticipantByActiveYn
	 *
	 */
	@Transactional
	public Set<Participant> findParticipantByActiveYn(Integer activeYn) throws DataAccessException {

		return findParticipantByActiveYn(activeYn, -1, -1);
	}

	/**
	 * JPQL Query - findParticipantByActiveYn
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Participant> findParticipantByActiveYn(Integer activeYn, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findParticipantByActiveYn", startResult, maxRows, activeYn);
		return new LinkedHashSet<Participant>(query.getResultList());
	}

	/**
	 * JPQL Query - findParticipantByNotesContaining
	 *
	 */
	@Transactional
	public Set<Participant> findParticipantByNotesContaining(String notes) throws DataAccessException {

		return findParticipantByNotesContaining(notes, -1, -1);
	}

	/**
	 * JPQL Query - findParticipantByNotesContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Participant> findParticipantByNotesContaining(String notes, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findParticipantByNotesContaining", startResult, maxRows, notes);
		return new LinkedHashSet<Participant>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllParticipants
	 *
	 */
	@Transactional
	public Set<Participant> findAllParticipants() throws DataAccessException {

		return findAllParticipants(-1, -1);
	}

	/**
	 * JPQL Query - findAllParticipants
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Participant> findAllParticipants(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllParticipants", startResult, maxRows);
		return new LinkedHashSet<Participant>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Participant entity) {
		return true;
	}
}
