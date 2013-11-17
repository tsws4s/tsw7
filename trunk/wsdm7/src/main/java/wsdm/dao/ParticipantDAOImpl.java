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
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Participant entity) {
		return true;
	}
}
