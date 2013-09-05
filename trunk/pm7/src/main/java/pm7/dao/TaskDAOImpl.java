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

import pm7.domain.Task;

/**
 * DAO to manage Task entities.
 * 
 */
@Repository("TaskDAO")
@Transactional
public class TaskDAOImpl extends AbstractJpaDao<Task> implements TaskDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Task.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mySql_pm7
	 *
	 */
	@PersistenceContext(unitName = "mySql_pm7")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TaskDAOImpl
	 *
	 */
	public TaskDAOImpl() {
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
	 * JPQL Query - findTaskByStartDate
	 *
	 */
	@Transactional
	public Set<Task> findTaskByStartDate(java.util.Calendar startDate) throws DataAccessException {

		return findTaskByStartDate(startDate, -1, -1);
	}

	/**
	 * JPQL Query - findTaskByStartDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Task> findTaskByStartDate(java.util.Calendar startDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTaskByStartDate", startResult, maxRows, startDate);
		return new LinkedHashSet<Task>(query.getResultList());
	}

	/**
	 * JPQL Query - findTaskByStatus
	 *
	 */
	@Transactional
	public Set<Task> findTaskByStatus(String status) throws DataAccessException {

		return findTaskByStatus(status, -1, -1);
	}

	/**
	 * JPQL Query - findTaskByStatus
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Task> findTaskByStatus(String status, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTaskByStatus", startResult, maxRows, status);
		return new LinkedHashSet<Task>(query.getResultList());
	}

	/**
	 * JPQL Query - findTaskByTargetDateAfter
	 *
	 */
	@Transactional
	public Set<Task> findTaskByTargetDateAfter(java.util.Calendar targetDate) throws DataAccessException {

		return findTaskByTargetDateAfter(targetDate, -1, -1);
	}

	/**
	 * JPQL Query - findTaskByTargetDateAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Task> findTaskByTargetDateAfter(java.util.Calendar targetDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTaskByTargetDateAfter", startResult, maxRows, targetDate);
		return new LinkedHashSet<Task>(query.getResultList());
	}

	/**
	 * JPQL Query - findTaskByTaskNameContaining
	 *
	 */
	@Transactional
	public Set<Task> findTaskByTaskNameContaining(String taskName) throws DataAccessException {

		return findTaskByTaskNameContaining(taskName, -1, -1);
	}

	/**
	 * JPQL Query - findTaskByTaskNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Task> findTaskByTaskNameContaining(String taskName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTaskByTaskNameContaining", startResult, maxRows, taskName);
		return new LinkedHashSet<Task>(query.getResultList());
	}

	/**
	 * JPQL Query - findTaskByPrimaryKey
	 *
	 */
	@Transactional
	public Task findTaskByPrimaryKey(Integer taskId) throws DataAccessException {

		return findTaskByPrimaryKey(taskId, -1, -1);
	}

	/**
	 * JPQL Query - findTaskByPrimaryKey
	 *
	 */

	@Transactional
	public Task findTaskByPrimaryKey(Integer taskId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTaskByPrimaryKey", startResult, maxRows, taskId);
			return (pm7.domain.Task) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAllTasks
	 *
	 */
	@Transactional
	public Set<Task> findAllTasks() throws DataAccessException {

		return findAllTasks(-1, -1);
	}

	/**
	 * JPQL Query - findAllTasks
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Task> findAllTasks(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllTasks", startResult, maxRows);
		return new LinkedHashSet<Task>(query.getResultList());
	}

	/**
	 * JPQL Query - findTaskByCompleteDate
	 *
	 */
	@Transactional
	public Set<Task> findTaskByCompleteDate(java.util.Calendar completeDate) throws DataAccessException {

		return findTaskByCompleteDate(completeDate, -1, -1);
	}

	/**
	 * JPQL Query - findTaskByCompleteDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Task> findTaskByCompleteDate(java.util.Calendar completeDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTaskByCompleteDate", startResult, maxRows, completeDate);
		return new LinkedHashSet<Task>(query.getResultList());
	}

	/**
	 * JPQL Query - findTaskByTaskDescriptionContaining
	 *
	 */
	@Transactional
	public Set<Task> findTaskByTaskDescriptionContaining(String taskDescription) throws DataAccessException {

		return findTaskByTaskDescriptionContaining(taskDescription, -1, -1);
	}

	/**
	 * JPQL Query - findTaskByTaskDescriptionContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Task> findTaskByTaskDescriptionContaining(String taskDescription, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTaskByTaskDescriptionContaining", startResult, maxRows, taskDescription);
		return new LinkedHashSet<Task>(query.getResultList());
	}

	/**
	 * JPQL Query - findTaskByActualHrs
	 *
	 */
	@Transactional
	public Set<Task> findTaskByActualHrs(Integer actualHrs) throws DataAccessException {

		return findTaskByActualHrs(actualHrs, -1, -1);
	}

	/**
	 * JPQL Query - findTaskByActualHrs
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Task> findTaskByActualHrs(Integer actualHrs, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTaskByActualHrs", startResult, maxRows, actualHrs);
		return new LinkedHashSet<Task>(query.getResultList());
	}

	/**
	 * JPQL Query - findTaskByTaskType
	 *
	 */
	@Transactional
	public Set<Task> findTaskByTaskType(String taskType) throws DataAccessException {

		return findTaskByTaskType(taskType, -1, -1);
	}

	/**
	 * JPQL Query - findTaskByTaskType
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Task> findTaskByTaskType(String taskType, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTaskByTaskType", startResult, maxRows, taskType);
		return new LinkedHashSet<Task>(query.getResultList());
	}

	/**
	 * JPQL Query - findTaskByCompleteDateBefore
	 *
	 */
	@Transactional
	public Set<Task> findTaskByCompleteDateBefore(java.util.Calendar completeDate) throws DataAccessException {

		return findTaskByCompleteDateBefore(completeDate, -1, -1);
	}

	/**
	 * JPQL Query - findTaskByCompleteDateBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Task> findTaskByCompleteDateBefore(java.util.Calendar completeDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTaskByCompleteDateBefore", startResult, maxRows, completeDate);
		return new LinkedHashSet<Task>(query.getResultList());
	}

	/**
	 * JPQL Query - findTaskByCompleteDateAfter
	 *
	 */
	@Transactional
	public Set<Task> findTaskByCompleteDateAfter(java.util.Calendar completeDate) throws DataAccessException {

		return findTaskByCompleteDateAfter(completeDate, -1, -1);
	}

	/**
	 * JPQL Query - findTaskByCompleteDateAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Task> findTaskByCompleteDateAfter(java.util.Calendar completeDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTaskByCompleteDateAfter", startResult, maxRows, completeDate);
		return new LinkedHashSet<Task>(query.getResultList());
	}

	/**
	 * JPQL Query - findTaskByTaskName
	 *
	 */
	@Transactional
	public Set<Task> findTaskByTaskName(String taskName) throws DataAccessException {

		return findTaskByTaskName(taskName, -1, -1);
	}

	/**
	 * JPQL Query - findTaskByTaskName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Task> findTaskByTaskName(String taskName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTaskByTaskName", startResult, maxRows, taskName);
		return new LinkedHashSet<Task>(query.getResultList());
	}

	/**
	 * JPQL Query - findTaskByStatusContaining
	 *
	 */
	@Transactional
	public Set<Task> findTaskByStatusContaining(String status) throws DataAccessException {

		return findTaskByStatusContaining(status, -1, -1);
	}

	/**
	 * JPQL Query - findTaskByStatusContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Task> findTaskByStatusContaining(String status, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTaskByStatusContaining", startResult, maxRows, status);
		return new LinkedHashSet<Task>(query.getResultList());
	}

	/**
	 * JPQL Query - findTaskByTargetDate
	 *
	 */
	@Transactional
	public Set<Task> findTaskByTargetDate(java.util.Calendar targetDate) throws DataAccessException {

		return findTaskByTargetDate(targetDate, -1, -1);
	}

	/**
	 * JPQL Query - findTaskByTargetDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Task> findTaskByTargetDate(java.util.Calendar targetDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTaskByTargetDate", startResult, maxRows, targetDate);
		return new LinkedHashSet<Task>(query.getResultList());
	}

	/**
	 * JPQL Query - findTaskByTargetDateBefore
	 *
	 */
	@Transactional
	public Set<Task> findTaskByTargetDateBefore(java.util.Calendar targetDate) throws DataAccessException {

		return findTaskByTargetDateBefore(targetDate, -1, -1);
	}

	/**
	 * JPQL Query - findTaskByTargetDateBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Task> findTaskByTargetDateBefore(java.util.Calendar targetDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTaskByTargetDateBefore", startResult, maxRows, targetDate);
		return new LinkedHashSet<Task>(query.getResultList());
	}

	/**
	 * JPQL Query - findTaskByEstimateHrs
	 *
	 */
	@Transactional
	public Set<Task> findTaskByEstimateHrs(Integer estimateHrs) throws DataAccessException {

		return findTaskByEstimateHrs(estimateHrs, -1, -1);
	}

	/**
	 * JPQL Query - findTaskByEstimateHrs
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Task> findTaskByEstimateHrs(Integer estimateHrs, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTaskByEstimateHrs", startResult, maxRows, estimateHrs);
		return new LinkedHashSet<Task>(query.getResultList());
	}

	/**
	 * JPQL Query - findTaskByTaskDescription
	 *
	 */
	@Transactional
	public Set<Task> findTaskByTaskDescription(String taskDescription) throws DataAccessException {

		return findTaskByTaskDescription(taskDescription, -1, -1);
	}

	/**
	 * JPQL Query - findTaskByTaskDescription
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Task> findTaskByTaskDescription(String taskDescription, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTaskByTaskDescription", startResult, maxRows, taskDescription);
		return new LinkedHashSet<Task>(query.getResultList());
	}

	/**
	 * JPQL Query - findTaskByPercentComplete
	 *
	 */
	@Transactional
	public Set<Task> findTaskByPercentComplete(Integer percentComplete) throws DataAccessException {

		return findTaskByPercentComplete(percentComplete, -1, -1);
	}

	/**
	 * JPQL Query - findTaskByPercentComplete
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Task> findTaskByPercentComplete(Integer percentComplete, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTaskByPercentComplete", startResult, maxRows, percentComplete);
		return new LinkedHashSet<Task>(query.getResultList());
	}

	/**
	 * JPQL Query - findTaskByTaskId
	 *
	 */
	@Transactional
	public Task findTaskByTaskId(Integer taskId) throws DataAccessException {

		return findTaskByTaskId(taskId, -1, -1);
	}

	/**
	 * JPQL Query - findTaskByTaskId
	 *
	 */

	@Transactional
	public Task findTaskByTaskId(Integer taskId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTaskByTaskId", startResult, maxRows, taskId);
			return (pm7.domain.Task) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTaskByTaskTypeContaining
	 *
	 */
	@Transactional
	public Set<Task> findTaskByTaskTypeContaining(String taskType) throws DataAccessException {

		return findTaskByTaskTypeContaining(taskType, -1, -1);
	}

	/**
	 * JPQL Query - findTaskByTaskTypeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Task> findTaskByTaskTypeContaining(String taskType, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTaskByTaskTypeContaining", startResult, maxRows, taskType);
		return new LinkedHashSet<Task>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Task entity) {
		return true;
	}
	
	public Integer getMaxTaskId() {
		Object obj = executeQuerySingleResult("select max(taskId) from Task");
		return (Integer)obj;
	}
}
