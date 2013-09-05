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

import pm7.domain.Project;

/**
 * DAO to manage Project entities.
 * 
 */
@Repository("ProjectDAO")
@Transactional
public class ProjectDAOImpl extends AbstractJpaDao<Project> implements
		ProjectDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Project.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mySql_pm7
	 *
	 */
	@PersistenceContext(unitName = "mySql_pm7")
	private EntityManager entityManager;

	/**
	 * Instantiates a new ProjectDAOImpl
	 *
	 */
	public ProjectDAOImpl() {
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
	 * JPQL Query - findProjectByStartDate
	 *
	 */
	@Transactional
	public Set<Project> findProjectByStartDate(java.util.Calendar startDate) throws DataAccessException {

		return findProjectByStartDate(startDate, -1, -1);
	}

	/**
	 * JPQL Query - findProjectByStartDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Project> findProjectByStartDate(java.util.Calendar startDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProjectByStartDate", startResult, maxRows, startDate);
		return new LinkedHashSet<Project>(query.getResultList());
	}

	/**
	 * JPQL Query - findProjectByProjectType
	 *
	 */
	@Transactional
	public Set<Project> findProjectByProjectType(String projectType) throws DataAccessException {

		return findProjectByProjectType(projectType, -1, -1);
	}

	/**
	 * JPQL Query - findProjectByProjectType
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Project> findProjectByProjectType(String projectType, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProjectByProjectType", startResult, maxRows, projectType);
		return new LinkedHashSet<Project>(query.getResultList());
	}

	/**
	 * JPQL Query - findProjectByCompleteDate
	 *
	 */
	@Transactional
	public Set<Project> findProjectByCompleteDate(java.util.Calendar completeDate) throws DataAccessException {

		return findProjectByCompleteDate(completeDate, -1, -1);
	}

	/**
	 * JPQL Query - findProjectByCompleteDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Project> findProjectByCompleteDate(java.util.Calendar completeDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProjectByCompleteDate", startResult, maxRows, completeDate);
		return new LinkedHashSet<Project>(query.getResultList());
	}

	/**
	 * JPQL Query - findProjectByPrimaryKey
	 *
	 */
	@Transactional
	public Project findProjectByPrimaryKey(Integer projectId) throws DataAccessException {

		return findProjectByPrimaryKey(projectId, -1, -1);
	}

	/**
	 * JPQL Query - findProjectByPrimaryKey
	 *
	 */

	@Transactional
	public Project findProjectByPrimaryKey(Integer projectId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findProjectByPrimaryKey", startResult, maxRows, projectId);
			return (pm7.domain.Project) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findProjectByProjectTypeContaining
	 *
	 */
	@Transactional
	public Set<Project> findProjectByProjectTypeContaining(String projectType) throws DataAccessException {

		return findProjectByProjectTypeContaining(projectType, -1, -1);
	}

	/**
	 * JPQL Query - findProjectByProjectTypeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Project> findProjectByProjectTypeContaining(String projectType, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProjectByProjectTypeContaining", startResult, maxRows, projectType);
		return new LinkedHashSet<Project>(query.getResultList());
	}

	/**
	 * JPQL Query - findProjectByActiveYn
	 *
	 */
	@Transactional
	public Set<Project> findProjectByActiveYn(Integer activeYn) throws DataAccessException {

		return findProjectByActiveYn(activeYn, -1, -1);
	}

	/**
	 * JPQL Query - findProjectByActiveYn
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Project> findProjectByActiveYn(Integer activeYn, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProjectByActiveYn", startResult, maxRows, activeYn);
		return new LinkedHashSet<Project>(query.getResultList());
	}

	/**
	 * JPQL Query - findProjectByProjectName
	 *
	 */
	@Transactional
	public Set<Project> findProjectByProjectName(String projectName) throws DataAccessException {

		return findProjectByProjectName(projectName, -1, -1);
	}

	/**
	 * JPQL Query - findProjectByProjectName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Project> findProjectByProjectName(String projectName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProjectByProjectName", startResult, maxRows, projectName);
		return new LinkedHashSet<Project>(query.getResultList());
	}

	/**
	 * JPQL Query - findProjectByEstimateHrs
	 *
	 */
	@Transactional
	public Set<Project> findProjectByEstimateHrs(Integer estimateHrs) throws DataAccessException {

		return findProjectByEstimateHrs(estimateHrs, -1, -1);
	}

	/**
	 * JPQL Query - findProjectByEstimateHrs
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Project> findProjectByEstimateHrs(Integer estimateHrs, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProjectByEstimateHrs", startResult, maxRows, estimateHrs);
		return new LinkedHashSet<Project>(query.getResultList());
	}

	/**
	 * JPQL Query - findProjectByHrRate
	 *
	 */
	@Transactional
	public Set<Project> findProjectByHrRate(java.math.BigDecimal hrRate) throws DataAccessException {

		return findProjectByHrRate(hrRate, -1, -1);
	}

	/**
	 * JPQL Query - findProjectByHrRate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Project> findProjectByHrRate(java.math.BigDecimal hrRate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProjectByHrRate", startResult, maxRows, hrRate);
		return new LinkedHashSet<Project>(query.getResultList());
	}

	/**
	 * JPQL Query - findProjectByDueDate
	 *
	 */
	@Transactional
	public Set<Project> findProjectByDueDate(java.util.Calendar dueDate) throws DataAccessException {

		return findProjectByDueDate(dueDate, -1, -1);
	}

	/**
	 * JPQL Query - findProjectByDueDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Project> findProjectByDueDate(java.util.Calendar dueDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProjectByDueDate", startResult, maxRows, dueDate);
		return new LinkedHashSet<Project>(query.getResultList());
	}

	/**
	 * JPQL Query - findProjectByProjectNameContaining
	 *
	 */
	@Transactional
	public Set<Project> findProjectByProjectNameContaining(String projectName) throws DataAccessException {

		return findProjectByProjectNameContaining(projectName, -1, -1);
	}

	/**
	 * JPQL Query - findProjectByProjectNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Project> findProjectByProjectNameContaining(String projectName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProjectByProjectNameContaining", startResult, maxRows, projectName);
		return new LinkedHashSet<Project>(query.getResultList());
	}

	/**
	 * JPQL Query - findProjectByProjectDesc
	 *
	 */
	@Transactional
	public Set<Project> findProjectByProjectDesc(String projectDesc) throws DataAccessException {

		return findProjectByProjectDesc(projectDesc, -1, -1);
	}

	/**
	 * JPQL Query - findProjectByProjectDesc
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Project> findProjectByProjectDesc(String projectDesc, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProjectByProjectDesc", startResult, maxRows, projectDesc);
		return new LinkedHashSet<Project>(query.getResultList());
	}

	/**
	 * JPQL Query - findProjectByProjectId
	 *
	 */
	@Transactional
	public Project findProjectByProjectId(Integer projectId) throws DataAccessException {

		return findProjectByProjectId(projectId, -1, -1);
	}

	/**
	 * JPQL Query - findProjectByProjectId
	 *
	 */

	@Transactional
	public Project findProjectByProjectId(Integer projectId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findProjectByProjectId", startResult, maxRows, projectId);
			return (pm7.domain.Project) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findProjectByActualHrs
	 *
	 */
	@Transactional
	public Set<Project> findProjectByActualHrs(Integer actualHrs) throws DataAccessException {

		return findProjectByActualHrs(actualHrs, -1, -1);
	}

	/**
	 * JPQL Query - findProjectByActualHrs
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Project> findProjectByActualHrs(Integer actualHrs, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProjectByActualHrs", startResult, maxRows, actualHrs);
		return new LinkedHashSet<Project>(query.getResultList());
	}

	/**
	 * JPQL Query - findProjectByProjectDescContaining
	 *
	 */
	@Transactional
	public Set<Project> findProjectByProjectDescContaining(String projectDesc) throws DataAccessException {

		return findProjectByProjectDescContaining(projectDesc, -1, -1);
	}

	/**
	 * JPQL Query - findProjectByProjectDescContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Project> findProjectByProjectDescContaining(String projectDesc, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProjectByProjectDescContaining", startResult, maxRows, projectDesc);
		return new LinkedHashSet<Project>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllProjects
	 *
	 */
	@Transactional
	public Set<Project> findAllProjects() throws DataAccessException {

		return findAllProjects(-1, -1);
	}

	/**
	 * JPQL Query - findAllProjects
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Project> findAllProjects(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllProjects", startResult, maxRows);
		return new LinkedHashSet<Project>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Project entity) {
		return true;
	}
	
	public Integer getMaxProjectId() {
		Object obj = executeQuerySingleResult("select max(projectId) from Project");
		if(obj!=null){
			return (Integer)obj;
		}
		return 0;
	}
}
