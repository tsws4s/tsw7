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

import wsdm.domain.Teamplayers;

/**
 * DAO to manage Teamplayers entities.
 * 
 */
@Repository("TeamplayersDAO")
@Transactional
public class TeamplayersDAOImpl extends AbstractJpaDao<Teamplayers> implements
		TeamplayersDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Teamplayers.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_tsw
	 *
	 */
	@PersistenceContext(unitName = "mysql_tsw")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TeamplayersDAOImpl
	 *
	 */
	public TeamplayersDAOImpl() {
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
	 * JPQL Query - findAllTeamplayerss
	 *
	 */
	@Transactional
	public Set<Teamplayers> findAllTeamplayerss() throws DataAccessException {

		return findAllTeamplayerss(-1, -1);
	}

	/**
	 * JPQL Query - findAllTeamplayerss
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Teamplayers> findAllTeamplayerss(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllTeamplayerss", startResult, maxRows);
		return new LinkedHashSet<Teamplayers>(query.getResultList());
	}

	/**
	 * JPQL Query - findTeamplayersByCaptain
	 *
	 */
	@Transactional
	public Set<Teamplayers> findTeamplayersByCaptain(Integer captain) throws DataAccessException {

		return findTeamplayersByCaptain(captain, -1, -1);
	}

	/**
	 * JPQL Query - findTeamplayersByCaptain
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Teamplayers> findTeamplayersByCaptain(Integer captain, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTeamplayersByCaptain", startResult, maxRows, captain);
		return new LinkedHashSet<Teamplayers>(query.getResultList());
	}

	/**
	 * JPQL Query - findTeamplayersByNotes
	 *
	 */
	@Transactional
	public Set<Teamplayers> findTeamplayersByNotes(String notes) throws DataAccessException {

		return findTeamplayersByNotes(notes, -1, -1);
	}

	/**
	 * JPQL Query - findTeamplayersByNotes
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Teamplayers> findTeamplayersByNotes(String notes, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTeamplayersByNotes", startResult, maxRows, notes);
		return new LinkedHashSet<Teamplayers>(query.getResultList());
	}

	/**
	 * JPQL Query - findTeamplayersByGroup2Containing
	 *
	 */
	@Transactional
	public Set<Teamplayers> findTeamplayersByGroup2Containing(String group2) throws DataAccessException {

		return findTeamplayersByGroup2Containing(group2, -1, -1);
	}

	/**
	 * JPQL Query - findTeamplayersByGroup2Containing
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Teamplayers> findTeamplayersByGroup2Containing(String group2, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTeamplayersByGroup2Containing", startResult, maxRows, group2);
		return new LinkedHashSet<Teamplayers>(query.getResultList());
	}

	/**
	 * JPQL Query - findTeamplayersByNotesContaining
	 *
	 */
	@Transactional
	public Set<Teamplayers> findTeamplayersByNotesContaining(String notes) throws DataAccessException {

		return findTeamplayersByNotesContaining(notes, -1, -1);
	}

	/**
	 * JPQL Query - findTeamplayersByNotesContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Teamplayers> findTeamplayersByNotesContaining(String notes, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTeamplayersByNotesContaining", startResult, maxRows, notes);
		return new LinkedHashSet<Teamplayers>(query.getResultList());
	}

	/**
	 * JPQL Query - findTeamplayersByTeamPlayersId
	 *
	 */
	@Transactional
	public Teamplayers findTeamplayersByTeamPlayersId(Integer teamPlayersId) throws DataAccessException {

		return findTeamplayersByTeamPlayersId(teamPlayersId, -1, -1);
	}

	/**
	 * JPQL Query - findTeamplayersByTeamPlayersId
	 *
	 */

	@Transactional
	public Teamplayers findTeamplayersByTeamPlayersId(Integer teamPlayersId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTeamplayersByTeamPlayersId", startResult, maxRows, teamPlayersId);
			return (wsdm.domain.Teamplayers) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTeamplayersBySignedWaiverYn
	 *
	 */
	@Transactional
	public Set<Teamplayers> findTeamplayersBySignedWaiverYn(Integer signedWaiverYn) throws DataAccessException {

		return findTeamplayersBySignedWaiverYn(signedWaiverYn, -1, -1);
	}

	/**
	 * JPQL Query - findTeamplayersBySignedWaiverYn
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Teamplayers> findTeamplayersBySignedWaiverYn(Integer signedWaiverYn, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTeamplayersBySignedWaiverYn", startResult, maxRows, signedWaiverYn);
		return new LinkedHashSet<Teamplayers>(query.getResultList());
	}

	/**
	 * JPQL Query - findTeamplayersByGroup2
	 *
	 */
	@Transactional
	public Set<Teamplayers> findTeamplayersByGroup2(String group2) throws DataAccessException {

		return findTeamplayersByGroup2(group2, -1, -1);
	}

	/**
	 * JPQL Query - findTeamplayersByGroup2
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Teamplayers> findTeamplayersByGroup2(String group2, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTeamplayersByGroup2", startResult, maxRows, group2);
		return new LinkedHashSet<Teamplayers>(query.getResultList());
	}

	/**
	 * JPQL Query - findTeamplayersByOtherAmtPaid
	 *
	 */
	@Transactional
	public Set<Teamplayers> findTeamplayersByOtherAmtPaid(java.math.BigDecimal otherAmtPaid) throws DataAccessException {

		return findTeamplayersByOtherAmtPaid(otherAmtPaid, -1, -1);
	}

	/**
	 * JPQL Query - findTeamplayersByOtherAmtPaid
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Teamplayers> findTeamplayersByOtherAmtPaid(java.math.BigDecimal otherAmtPaid, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTeamplayersByOtherAmtPaid", startResult, maxRows, otherAmtPaid);
		return new LinkedHashSet<Teamplayers>(query.getResultList());
	}

	/**
	 * JPQL Query - findTeamplayersByPrimaryKey
	 *
	 */
	@Transactional
	public Teamplayers findTeamplayersByPrimaryKey(Integer teamPlayersId) throws DataAccessException {

		return findTeamplayersByPrimaryKey(teamPlayersId, -1, -1);
	}

	/**
	 * JPQL Query - findTeamplayersByPrimaryKey
	 *
	 */

	@Transactional
	public Teamplayers findTeamplayersByPrimaryKey(Integer teamPlayersId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTeamplayersByPrimaryKey", startResult, maxRows, teamPlayersId);
			return (wsdm.domain.Teamplayers) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTeamplayersBySportPositionFk
	 *
	 */
	@Transactional
	public Set<Teamplayers> findTeamplayersBySportPositionFk(Integer sportPositionFk) throws DataAccessException {

		return findTeamplayersBySportPositionFk(sportPositionFk, -1, -1);
	}

	/**
	 * JPQL Query - findTeamplayersBySportPositionFk
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Teamplayers> findTeamplayersBySportPositionFk(Integer sportPositionFk, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTeamplayersBySportPositionFk", startResult, maxRows, sportPositionFk);
		return new LinkedHashSet<Teamplayers>(query.getResultList());
	}

	/**
	 * JPQL Query - findTeamplayersByAmtPaid
	 *
	 */
	@Transactional
	public Set<Teamplayers> findTeamplayersByAmtPaid(java.math.BigDecimal amtPaid) throws DataAccessException {

		return findTeamplayersByAmtPaid(amtPaid, -1, -1);
	}

	/**
	 * JPQL Query - findTeamplayersByAmtPaid
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Teamplayers> findTeamplayersByAmtPaid(java.math.BigDecimal amtPaid, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTeamplayersByAmtPaid", startResult, maxRows, amtPaid);
		return new LinkedHashSet<Teamplayers>(query.getResultList());
	}

	/**
	 * JPQL Query - findTeamplayersByActiveYn
	 *
	 */
	@Transactional
	public Set<Teamplayers> findTeamplayersByActiveYn(Integer activeYn) throws DataAccessException {

		return findTeamplayersByActiveYn(activeYn, -1, -1);
	}

	/**
	 * JPQL Query - findTeamplayersByActiveYn
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Teamplayers> findTeamplayersByActiveYn(Integer activeYn, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTeamplayersByActiveYn", startResult, maxRows, activeYn);
		return new LinkedHashSet<Teamplayers>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Teamplayers entity) {
		return true;
	}
}
