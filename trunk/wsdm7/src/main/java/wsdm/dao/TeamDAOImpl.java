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

import wsdm.domain.Team;

/**
 * DAO to manage Team entities.
 * 
 */
@Repository("TeamDAO")
@Transactional
public class TeamDAOImpl extends AbstractJpaDao<Team> implements TeamDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Team.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_tsw
	 *
	 */
	@PersistenceContext(unitName = "mysql_tsw")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TeamDAOImpl
	 *
	 */
	public TeamDAOImpl() {
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
	 * JPQL Query - findTeamByTeamNameContaining
	 *
	 */
	@Transactional
	public Set<Team> findTeamByTeamNameContaining(String teamName) throws DataAccessException {

		return findTeamByTeamNameContaining(teamName, -1, -1);
	}

	/**
	 * JPQL Query - findTeamByTeamNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Team> findTeamByTeamNameContaining(String teamName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTeamByTeamNameContaining", startResult, maxRows, teamName);
		return new LinkedHashSet<Team>(query.getResultList());
	}

	/**
	 * JPQL Query - findTeamByAmtPaid
	 *
	 */
	@Transactional
	public Set<Team> findTeamByAmtPaid(java.math.BigDecimal amtPaid) throws DataAccessException {

		return findTeamByAmtPaid(amtPaid, -1, -1);
	}

	/**
	 * JPQL Query - findTeamByAmtPaid
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Team> findTeamByAmtPaid(java.math.BigDecimal amtPaid, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTeamByAmtPaid", startResult, maxRows, amtPaid);
		return new LinkedHashSet<Team>(query.getResultList());
	}

	/**
	 * JPQL Query - findTeamByLosses
	 *
	 */
	@Transactional
	public Set<Team> findTeamByLosses(Integer losses) throws DataAccessException {

		return findTeamByLosses(losses, -1, -1);
	}

	/**
	 * JPQL Query - findTeamByLosses
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Team> findTeamByLosses(Integer losses, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTeamByLosses", startResult, maxRows, losses);
		return new LinkedHashSet<Team>(query.getResultList());
	}

	/**
	 * JPQL Query - findTeamByTeamId
	 *
	 */
	@Transactional
	public Team findTeamByTeamId(Integer teamId) throws DataAccessException {

		return findTeamByTeamId(teamId, -1, -1);
	}

	/**
	 * JPQL Query - findTeamByTeamId
	 *
	 */

	@Transactional
	public Team findTeamByTeamId(Integer teamId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTeamByTeamId", startResult, maxRows, teamId);
			return (wsdm.domain.Team) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTeamByGroup3Containing
	 *
	 */
	@Transactional
	public Set<Team> findTeamByGroup3Containing(String group3) throws DataAccessException {

		return findTeamByGroup3Containing(group3, -1, -1);
	}

	/**
	 * JPQL Query - findTeamByGroup3Containing
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Team> findTeamByGroup3Containing(String group3, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTeamByGroup3Containing", startResult, maxRows, group3);
		return new LinkedHashSet<Team>(query.getResultList());
	}

	/**
	 * JPQL Query - findTeamByWins
	 *
	 */
	@Transactional
	public Set<Team> findTeamByWins(Integer wins) throws DataAccessException {

		return findTeamByWins(wins, -1, -1);
	}

	/**
	 * JPQL Query - findTeamByWins
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Team> findTeamByWins(Integer wins, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTeamByWins", startResult, maxRows, wins);
		return new LinkedHashSet<Team>(query.getResultList());
	}

	/**
	 * JPQL Query - findTeamByNotesContaining
	 *
	 */
	@Transactional
	public Set<Team> findTeamByNotesContaining(String notes) throws DataAccessException {

		return findTeamByNotesContaining(notes, -1, -1);
	}

	/**
	 * JPQL Query - findTeamByNotesContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Team> findTeamByNotesContaining(String notes, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTeamByNotesContaining", startResult, maxRows, notes);
		return new LinkedHashSet<Team>(query.getResultList());
	}

	/**
	 * JPQL Query - findTeamByGroup3
	 *
	 */
	@Transactional
	public Set<Team> findTeamByGroup3(String group3) throws DataAccessException {

		return findTeamByGroup3(group3, -1, -1);
	}

	/**
	 * JPQL Query - findTeamByGroup3
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Team> findTeamByGroup3(String group3, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTeamByGroup3", startResult, maxRows, group3);
		return new LinkedHashSet<Team>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllTeams
	 *
	 */
	@Transactional
	public Set<Team> findAllTeams() throws DataAccessException {

		return findAllTeams(-1, -1);
	}

	/**
	 * JPQL Query - findAllTeams
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Team> findAllTeams(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllTeams", startResult, maxRows);
		return new LinkedHashSet<Team>(query.getResultList());
	}

	/**
	 * JPQL Query - findTeamByNotes
	 *
	 */
	@Transactional
	public Set<Team> findTeamByNotes(String notes) throws DataAccessException {

		return findTeamByNotes(notes, -1, -1);
	}

	/**
	 * JPQL Query - findTeamByNotes
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Team> findTeamByNotes(String notes, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTeamByNotes", startResult, maxRows, notes);
		return new LinkedHashSet<Team>(query.getResultList());
	}

	/**
	 * JPQL Query - findTeamByTies
	 *
	 */
	@Transactional
	public Set<Team> findTeamByTies(Integer ties) throws DataAccessException {

		return findTeamByTies(ties, -1, -1);
	}

	/**
	 * JPQL Query - findTeamByTies
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Team> findTeamByTies(Integer ties, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTeamByTies", startResult, maxRows, ties);
		return new LinkedHashSet<Team>(query.getResultList());
	}

	/**
	 * JPQL Query - findTeamByActiveYn
	 *
	 */
	@Transactional
	public Set<Team> findTeamByActiveYn(Integer activeYn) throws DataAccessException {

		return findTeamByActiveYn(activeYn, -1, -1);
	}

	/**
	 * JPQL Query - findTeamByActiveYn
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Team> findTeamByActiveYn(Integer activeYn, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTeamByActiveYn", startResult, maxRows, activeYn);
		return new LinkedHashSet<Team>(query.getResultList());
	}

	/**
	 * JPQL Query - findTeamByColorContaining
	 *
	 */
	@Transactional
	public Set<Team> findTeamByColorContaining(String color) throws DataAccessException {

		return findTeamByColorContaining(color, -1, -1);
	}

	/**
	 * JPQL Query - findTeamByColorContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Team> findTeamByColorContaining(String color, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTeamByColorContaining", startResult, maxRows, color);
		return new LinkedHashSet<Team>(query.getResultList());
	}

	/**
	 * JPQL Query - findTeamByPublishYn
	 *
	 */
	@Transactional
	public Set<Team> findTeamByPublishYn(Integer publishYn) throws DataAccessException {

		return findTeamByPublishYn(publishYn, -1, -1);
	}

	/**
	 * JPQL Query - findTeamByPublishYn
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Team> findTeamByPublishYn(Integer publishYn, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTeamByPublishYn", startResult, maxRows, publishYn);
		return new LinkedHashSet<Team>(query.getResultList());
	}

	/**
	 * JPQL Query - findTeamByPrimaryKey
	 *
	 */
	@Transactional
	public Team findTeamByPrimaryKey(Integer teamId) throws DataAccessException {

		return findTeamByPrimaryKey(teamId, -1, -1);
	}

	/**
	 * JPQL Query - findTeamByPrimaryKey
	 *
	 */

	@Transactional
	public Team findTeamByPrimaryKey(Integer teamId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTeamByPrimaryKey", startResult, maxRows, teamId);
			return (wsdm.domain.Team) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTeamByColor
	 *
	 */
	@Transactional
	public Set<Team> findTeamByColor(String color) throws DataAccessException {

		return findTeamByColor(color, -1, -1);
	}

	/**
	 * JPQL Query - findTeamByColor
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Team> findTeamByColor(String color, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTeamByColor", startResult, maxRows, color);
		return new LinkedHashSet<Team>(query.getResultList());
	}

	/**
	 * JPQL Query - findTeamByTeamName
	 *
	 */
	@Transactional
	public Set<Team> findTeamByTeamName(String teamName) throws DataAccessException {

		return findTeamByTeamName(teamName, -1, -1);
	}

	/**
	 * JPQL Query - findTeamByTeamName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Team> findTeamByTeamName(String teamName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTeamByTeamName", startResult, maxRows, teamName);
		return new LinkedHashSet<Team>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Team entity) {
		return true;
	}
}
