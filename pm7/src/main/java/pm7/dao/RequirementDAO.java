package pm7.dao;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import pm7.domain.Requirement;

/**
 * DAO to manage Requirement entities.
 * 
 */
public interface RequirementDAO extends JpaDao<Requirement> {

	/**
	 * JPQL Query - findRequirementByReqmtPriorityContaining
	 *
	 */
	public Set<Requirement> findRequirementByReqmtPriorityContaining(String reqmtPriority) throws DataAccessException;

	/**
	 * JPQL Query - findRequirementByReqmtPriorityContaining
	 *
	 */
	public Set<Requirement> findRequirementByReqmtPriorityContaining(String reqmtPriority, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRequirementByPrimaryKey
	 *
	 */
	public Requirement findRequirementByPrimaryKey(Integer reqmtId) throws DataAccessException;

	/**
	 * JPQL Query - findRequirementByPrimaryKey
	 *
	 */
	public Requirement findRequirementByPrimaryKey(Integer reqmtId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRequirementByStatusContaining
	 *
	 */
	public Set<Requirement> findRequirementByStatusContaining(String status) throws DataAccessException;

	/**
	 * JPQL Query - findRequirementByStatusContaining
	 *
	 */
	public Set<Requirement> findRequirementByStatusContaining(String status, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRequirementByReqmtId
	 *
	 */
	public Requirement findRequirementByReqmtId(Integer reqmtId_1) throws DataAccessException;

	/**
	 * JPQL Query - findRequirementByReqmtId
	 *
	 */
	public Requirement findRequirementByReqmtId(Integer reqmtId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRequirementByStatus
	 *
	 */
	public Set<Requirement> findRequirementByStatus(String status_1) throws DataAccessException;

	/**
	 * JPQL Query - findRequirementByStatus
	 *
	 */
	public Set<Requirement> findRequirementByStatus(String status_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRequirementByReqmtCodeContaining
	 *
	 */
	public Set<Requirement> findRequirementByReqmtCodeContaining(String reqmtCode) throws DataAccessException;

	/**
	 * JPQL Query - findRequirementByReqmtCodeContaining
	 *
	 */
	public Set<Requirement> findRequirementByReqmtCodeContaining(String reqmtCode, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRequirementByReqmtNameContaining
	 *
	 */
	public Set<Requirement> findRequirementByReqmtNameContaining(String reqmtName) throws DataAccessException;

	/**
	 * JPQL Query - findRequirementByReqmtNameContaining
	 *
	 */
	public Set<Requirement> findRequirementByReqmtNameContaining(String reqmtName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRequirementByReqmtStoryDescription
	 *
	 */
	public Set<Requirement> findRequirementByReqmtStoryDescription(String reqmtStoryDescription) throws DataAccessException;

	/**
	 * JPQL Query - findRequirementByReqmtStoryDescription
	 *
	 */
	public Set<Requirement> findRequirementByReqmtStoryDescription(String reqmtStoryDescription, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRequirementByReqmtStoryDescriptionContaining
	 *
	 */
	public Set<Requirement> findRequirementByReqmtStoryDescriptionContaining(String reqmtStoryDescription_1) throws DataAccessException;

	/**
	 * JPQL Query - findRequirementByReqmtStoryDescriptionContaining
	 *
	 */
	public Set<Requirement> findRequirementByReqmtStoryDescriptionContaining(String reqmtStoryDescription_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRequirementByReqmtCode
	 *
	 */
	public Set<Requirement> findRequirementByReqmtCode(String reqmtCode_1) throws DataAccessException;

	/**
	 * JPQL Query - findRequirementByReqmtCode
	 *
	 */
	public Set<Requirement> findRequirementByReqmtCode(String reqmtCode_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRequirementByReqmtName
	 *
	 */
	public Set<Requirement> findRequirementByReqmtName(String reqmtName_1) throws DataAccessException;

	/**
	 * JPQL Query - findRequirementByReqmtName
	 *
	 */
	public Set<Requirement> findRequirementByReqmtName(String reqmtName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRequirementByReqmtPriority
	 *
	 */
	public Set<Requirement> findRequirementByReqmtPriority(String reqmtPriority_1) throws DataAccessException;

	/**
	 * JPQL Query - findRequirementByReqmtPriority
	 *
	 */
	public Set<Requirement> findRequirementByReqmtPriority(String reqmtPriority_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllRequirements
	 *
	 */
	public Set<Requirement> findAllRequirements() throws DataAccessException;

	/**
	 * JPQL Query - findAllRequirements
	 *
	 */
	public Set<Requirement> findAllRequirements(int startResult, int maxRows) throws DataAccessException;

	public Integer getMaxRequirementId();
}