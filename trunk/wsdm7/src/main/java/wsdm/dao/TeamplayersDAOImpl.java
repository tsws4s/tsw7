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
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Teamplayers entity) {
		return true;
	}
}
