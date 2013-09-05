package pm7.dao;

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

import pm7.domain.Projectteam;

/**
 * DAO to manage Projectteam entities.
 * 
 */
@Repository("ProjectteamDAO")
@Transactional
public class ProjectteamDAOImpl extends AbstractJpaDao<Projectteam> implements
		ProjectteamDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Projectteam.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mySql_pm7
	 *
	 */
	@PersistenceContext(unitName = "mySql_pm7")
	private EntityManager entityManager;

	/**
	 * Instantiates a new ProjectteamDAOImpl
	 *
	 */
	public ProjectteamDAOImpl() {
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
	 * JPQL Query - findProjectteamByProjectRole
	 *
	 */
	@Transactional
	public Set<Projectteam> findProjectteamByProjectRole(String projectRole) throws DataAccessException {

		return findProjectteamByProjectRole(projectRole, -1, -1);
	}

	/**
	 * JPQL Query - findProjectteamByProjectRole
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Projectteam> findProjectteamByProjectRole(String projectRole, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProjectteamByProjectRole", startResult, maxRows, projectRole);
		return new LinkedHashSet<Projectteam>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllProjectteams
	 *
	 */
	@Transactional
	public Set<Projectteam> findAllProjectteams() throws DataAccessException {

		return findAllProjectteams(-1, -1);
	}

	/**
	 * JPQL Query - findAllProjectteams
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Projectteam> findAllProjectteams(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllProjectteams", startResult, maxRows);
		return new LinkedHashSet<Projectteam>(query.getResultList());
	}

	/**
	 * JPQL Query - findProjectteamByPersonProjectActualHrs
	 *
	 */
	@Transactional
	public Set<Projectteam> findProjectteamByPersonProjectActualHrs(Integer personProjectActualHrs) throws DataAccessException {

		return findProjectteamByPersonProjectActualHrs(personProjectActualHrs, -1, -1);
	}

	/**
	 * JPQL Query - findProjectteamByPersonProjectActualHrs
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Projectteam> findProjectteamByPersonProjectActualHrs(Integer personProjectActualHrs, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProjectteamByPersonProjectActualHrs", startResult, maxRows, personProjectActualHrs);
		return new LinkedHashSet<Projectteam>(query.getResultList());
	}

	/**
	 * JPQL Query - findProjectteamByPersonProjectEstHrs
	 *
	 */
	@Transactional
	public Set<Projectteam> findProjectteamByPersonProjectEstHrs(Integer personProjectEstHrs) throws DataAccessException {

		return findProjectteamByPersonProjectEstHrs(personProjectEstHrs, -1, -1);
	}

	/**
	 * JPQL Query - findProjectteamByPersonProjectEstHrs
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Projectteam> findProjectteamByPersonProjectEstHrs(Integer personProjectEstHrs, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProjectteamByPersonProjectEstHrs", startResult, maxRows, personProjectEstHrs);
		return new LinkedHashSet<Projectteam>(query.getResultList());
	}

	/**
	 * JPQL Query - findProjectteamByProjectTeamId
	 *
	 */
	@Transactional
	public Projectteam findProjectteamByProjectTeamId(Integer projectTeamId) throws DataAccessException {

		return findProjectteamByProjectTeamId(projectTeamId, -1, -1);
	}

	/**
	 * JPQL Query - findProjectteamByProjectTeamId
	 *
	 */

	@Transactional
	public Projectteam findProjectteamByProjectTeamId(Integer projectTeamId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findProjectteamByProjectTeamId", startResult, maxRows, projectTeamId);
			return (pm7.domain.Projectteam) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findProjectteamByProjectRoleContaining
	 *
	 */
	@Transactional
	public Set<Projectteam> findProjectteamByProjectRoleContaining(String projectRole) throws DataAccessException {

		return findProjectteamByProjectRoleContaining(projectRole, -1, -1);
	}

	/**
	 * JPQL Query - findProjectteamByProjectRoleContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Projectteam> findProjectteamByProjectRoleContaining(String projectRole, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProjectteamByProjectRoleContaining", startResult, maxRows, projectRole);
		return new LinkedHashSet<Projectteam>(query.getResultList());
	}

	/**
	 * JPQL Query - findProjectteamByPrimaryKey
	 *
	 */
	@Transactional
	public Projectteam findProjectteamByPrimaryKey(Integer projectTeamId) throws DataAccessException {

		return findProjectteamByPrimaryKey(projectTeamId, -1, -1);
	}

	/**
	 * JPQL Query - findProjectteamByPrimaryKey
	 *
	 */

	@Transactional
	public Projectteam findProjectteamByPrimaryKey(Integer projectTeamId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findProjectteamByPrimaryKey", startResult, maxRows, projectTeamId);
			return (pm7.domain.Projectteam) query.getSingleResult();
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
	public boolean canBeMerged(Projectteam entity) {
		return true;
	}
	
	public Integer getMaxProjectteamId() {
		Object obj = executeQuerySingleResult("select max(projectTeamId) from Projectteam");
		if(obj!=null){
			return (Integer)obj;
		}
		return 0;
	}
}
