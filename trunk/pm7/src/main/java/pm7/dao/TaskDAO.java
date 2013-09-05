package pm7.dao;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import pm7.domain.Task;

/**
 * DAO to manage Task entities.
 * 
 */
public interface TaskDAO extends JpaDao<Task> {

	/**
	 * JPQL Query - findTaskByStartDate
	 *
	 */
	public Set<Task> findTaskByStartDate(java.util.Calendar startDate) throws DataAccessException;

	/**
	 * JPQL Query - findTaskByStartDate
	 *
	 */
	public Set<Task> findTaskByStartDate(Calendar startDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTaskByStatus
	 *
	 */
	public Set<Task> findTaskByStatus(String status) throws DataAccessException;

	/**
	 * JPQL Query - findTaskByStatus
	 *
	 */
	public Set<Task> findTaskByStatus(String status, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTaskByTargetDateAfter
	 *
	 */
	public Set<Task> findTaskByTargetDateAfter(java.util.Calendar targetDate) throws DataAccessException;

	/**
	 * JPQL Query - findTaskByTargetDateAfter
	 *
	 */
	public Set<Task> findTaskByTargetDateAfter(Calendar targetDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTaskByTaskNameContaining
	 *
	 */
	public Set<Task> findTaskByTaskNameContaining(String taskName) throws DataAccessException;

	/**
	 * JPQL Query - findTaskByTaskNameContaining
	 *
	 */
	public Set<Task> findTaskByTaskNameContaining(String taskName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTaskByPrimaryKey
	 *
	 */
	public Task findTaskByPrimaryKey(Integer taskId) throws DataAccessException;

	/**
	 * JPQL Query - findTaskByPrimaryKey
	 *
	 */
	public Task findTaskByPrimaryKey(Integer taskId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllTasks
	 *
	 */
	public Set<Task> findAllTasks() throws DataAccessException;

	/**
	 * JPQL Query - findAllTasks
	 *
	 */
	public Set<Task> findAllTasks(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTaskByCompleteDate
	 *
	 */
	public Set<Task> findTaskByCompleteDate(java.util.Calendar completeDate) throws DataAccessException;

	/**
	 * JPQL Query - findTaskByCompleteDate
	 *
	 */
	public Set<Task> findTaskByCompleteDate(Calendar completeDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTaskByTaskDescriptionContaining
	 *
	 */
	public Set<Task> findTaskByTaskDescriptionContaining(String taskDescription) throws DataAccessException;

	/**
	 * JPQL Query - findTaskByTaskDescriptionContaining
	 *
	 */
	public Set<Task> findTaskByTaskDescriptionContaining(String taskDescription, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTaskByActualHrs
	 *
	 */
	public Set<Task> findTaskByActualHrs(Integer actualHrs) throws DataAccessException;

	/**
	 * JPQL Query - findTaskByActualHrs
	 *
	 */
	public Set<Task> findTaskByActualHrs(Integer actualHrs, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTaskByTaskType
	 *
	 */
	public Set<Task> findTaskByTaskType(String taskType) throws DataAccessException;

	/**
	 * JPQL Query - findTaskByTaskType
	 *
	 */
	public Set<Task> findTaskByTaskType(String taskType, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTaskByCompleteDateBefore
	 *
	 */
	public Set<Task> findTaskByCompleteDateBefore(java.util.Calendar completeDate_1) throws DataAccessException;

	/**
	 * JPQL Query - findTaskByCompleteDateBefore
	 *
	 */
	public Set<Task> findTaskByCompleteDateBefore(Calendar completeDate_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTaskByCompleteDateAfter
	 *
	 */
	public Set<Task> findTaskByCompleteDateAfter(java.util.Calendar completeDate_2) throws DataAccessException;

	/**
	 * JPQL Query - findTaskByCompleteDateAfter
	 *
	 */
	public Set<Task> findTaskByCompleteDateAfter(Calendar completeDate_2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTaskByTaskName
	 *
	 */
	public Set<Task> findTaskByTaskName(String taskName_1) throws DataAccessException;

	/**
	 * JPQL Query - findTaskByTaskName
	 *
	 */
	public Set<Task> findTaskByTaskName(String taskName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTaskByStatusContaining
	 *
	 */
	public Set<Task> findTaskByStatusContaining(String status_1) throws DataAccessException;

	/**
	 * JPQL Query - findTaskByStatusContaining
	 *
	 */
	public Set<Task> findTaskByStatusContaining(String status_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTaskByTargetDate
	 *
	 */
	public Set<Task> findTaskByTargetDate(java.util.Calendar targetDate_1) throws DataAccessException;

	/**
	 * JPQL Query - findTaskByTargetDate
	 *
	 */
	public Set<Task> findTaskByTargetDate(Calendar targetDate_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTaskByTargetDateBefore
	 *
	 */
	public Set<Task> findTaskByTargetDateBefore(java.util.Calendar targetDate_2) throws DataAccessException;

	/**
	 * JPQL Query - findTaskByTargetDateBefore
	 *
	 */
	public Set<Task> findTaskByTargetDateBefore(Calendar targetDate_2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTaskByEstimateHrs
	 *
	 */
	public Set<Task> findTaskByEstimateHrs(Integer estimateHrs) throws DataAccessException;

	/**
	 * JPQL Query - findTaskByEstimateHrs
	 *
	 */
	public Set<Task> findTaskByEstimateHrs(Integer estimateHrs, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTaskByTaskDescription
	 *
	 */
	public Set<Task> findTaskByTaskDescription(String taskDescription_1) throws DataAccessException;

	/**
	 * JPQL Query - findTaskByTaskDescription
	 *
	 */
	public Set<Task> findTaskByTaskDescription(String taskDescription_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTaskByPercentComplete
	 *
	 */
	public Set<Task> findTaskByPercentComplete(Integer percentComplete) throws DataAccessException;

	/**
	 * JPQL Query - findTaskByPercentComplete
	 *
	 */
	public Set<Task> findTaskByPercentComplete(Integer percentComplete, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTaskByTaskId
	 *
	 */
	public Task findTaskByTaskId(Integer taskId_1) throws DataAccessException;

	/**
	 * JPQL Query - findTaskByTaskId
	 *
	 */
	public Task findTaskByTaskId(Integer taskId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTaskByTaskTypeContaining
	 *
	 */
	public Set<Task> findTaskByTaskTypeContaining(String taskType_1) throws DataAccessException;

	/**
	 * JPQL Query - findTaskByTaskTypeContaining
	 *
	 */
	public Set<Task> findTaskByTaskTypeContaining(String taskType_1, int startResult, int maxRows) throws DataAccessException;

	public Integer getMaxTaskId();
}