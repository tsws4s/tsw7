package pm7.dao;

import java.math.BigDecimal;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import pm7.domain.Project;

/**
 * DAO to manage Project entities.
 * 
 */
public interface ProjectDAO extends JpaDao<Project> {

	/**
	 * JPQL Query - findProjectByStartDate
	 *
	 */
	public Set<Project> findProjectByStartDate(java.util.Calendar startDate) throws DataAccessException;

	/**
	 * JPQL Query - findProjectByStartDate
	 *
	 */
	public Set<Project> findProjectByStartDate(Calendar startDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProjectByProjectType
	 *
	 */
	public Set<Project> findProjectByProjectType(String projectType) throws DataAccessException;

	/**
	 * JPQL Query - findProjectByProjectType
	 *
	 */
	public Set<Project> findProjectByProjectType(String projectType, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProjectByCompleteDate
	 *
	 */
	public Set<Project> findProjectByCompleteDate(java.util.Calendar completeDate) throws DataAccessException;

	/**
	 * JPQL Query - findProjectByCompleteDate
	 *
	 */
	public Set<Project> findProjectByCompleteDate(Calendar completeDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProjectByPrimaryKey
	 *
	 */
	public Project findProjectByPrimaryKey(Integer projectId) throws DataAccessException;

	/**
	 * JPQL Query - findProjectByPrimaryKey
	 *
	 */
	public Project findProjectByPrimaryKey(Integer projectId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProjectByProjectTypeContaining
	 *
	 */
	public Set<Project> findProjectByProjectTypeContaining(String projectType_1) throws DataAccessException;

	/**
	 * JPQL Query - findProjectByProjectTypeContaining
	 *
	 */
	public Set<Project> findProjectByProjectTypeContaining(String projectType_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProjectByActiveYn
	 *
	 */
	public Set<Project> findProjectByActiveYn(Integer activeYn) throws DataAccessException;

	/**
	 * JPQL Query - findProjectByActiveYn
	 *
	 */
	public Set<Project> findProjectByActiveYn(Integer activeYn, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProjectByProjectName
	 *
	 */
	public Set<Project> findProjectByProjectName(String projectName) throws DataAccessException;

	/**
	 * JPQL Query - findProjectByProjectName
	 *
	 */
	public Set<Project> findProjectByProjectName(String projectName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProjectByEstimateHrs
	 *
	 */
	public Set<Project> findProjectByEstimateHrs(Integer estimateHrs) throws DataAccessException;

	/**
	 * JPQL Query - findProjectByEstimateHrs
	 *
	 */
	public Set<Project> findProjectByEstimateHrs(Integer estimateHrs, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProjectByHrRate
	 *
	 */
	public Set<Project> findProjectByHrRate(java.math.BigDecimal hrRate) throws DataAccessException;

	/**
	 * JPQL Query - findProjectByHrRate
	 *
	 */
	public Set<Project> findProjectByHrRate(BigDecimal hrRate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProjectByDueDate
	 *
	 */
	public Set<Project> findProjectByDueDate(java.util.Calendar dueDate) throws DataAccessException;

	/**
	 * JPQL Query - findProjectByDueDate
	 *
	 */
	public Set<Project> findProjectByDueDate(Calendar dueDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProjectByProjectNameContaining
	 *
	 */
	public Set<Project> findProjectByProjectNameContaining(String projectName_1) throws DataAccessException;

	/**
	 * JPQL Query - findProjectByProjectNameContaining
	 *
	 */
	public Set<Project> findProjectByProjectNameContaining(String projectName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProjectByProjectDesc
	 *
	 */
	public Set<Project> findProjectByProjectDesc(String projectDesc) throws DataAccessException;

	/**
	 * JPQL Query - findProjectByProjectDesc
	 *
	 */
	public Set<Project> findProjectByProjectDesc(String projectDesc, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProjectByProjectId
	 *
	 */
	public Project findProjectByProjectId(Integer projectId_1) throws DataAccessException;

	/**
	 * JPQL Query - findProjectByProjectId
	 *
	 */
	public Project findProjectByProjectId(Integer projectId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProjectByActualHrs
	 *
	 */
	public Set<Project> findProjectByActualHrs(Integer actualHrs) throws DataAccessException;

	/**
	 * JPQL Query - findProjectByActualHrs
	 *
	 */
	public Set<Project> findProjectByActualHrs(Integer actualHrs, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProjectByProjectDescContaining
	 *
	 */
	public Set<Project> findProjectByProjectDescContaining(String projectDesc_1) throws DataAccessException;

	/**
	 * JPQL Query - findProjectByProjectDescContaining
	 *
	 */
	public Set<Project> findProjectByProjectDescContaining(String projectDesc_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllProjects
	 *
	 */
	public Set<Project> findAllProjects() throws DataAccessException;

	/**
	 * JPQL Query - findAllProjects
	 *
	 */
	public Set<Project> findAllProjects(int startResult, int maxRows) throws DataAccessException;

	public Integer getMaxProjectId();
}