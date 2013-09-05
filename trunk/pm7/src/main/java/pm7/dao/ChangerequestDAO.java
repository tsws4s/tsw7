package pm7.dao;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import pm7.domain.Changerequest;

/**
 * DAO to manage Changerequest entities.
 * 
 */
public interface ChangerequestDAO extends JpaDao<Changerequest> {

	/**
	 * JPQL Query - findChangerequestByChangePriorityContaining
	 *
	 */
	public Set<Changerequest> findChangerequestByChangePriorityContaining(String changePriority) throws DataAccessException;

	/**
	 * JPQL Query - findChangerequestByChangePriorityContaining
	 *
	 */
	public Set<Changerequest> findChangerequestByChangePriorityContaining(String changePriority, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findChangerequestByStatusContaining
	 *
	 */
	public Set<Changerequest> findChangerequestByStatusContaining(String status) throws DataAccessException;

	/**
	 * JPQL Query - findChangerequestByStatusContaining
	 *
	 */
	public Set<Changerequest> findChangerequestByStatusContaining(String status, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findChangerequestByChangeDescription
	 *
	 */
	public Set<Changerequest> findChangerequestByChangeDescription(String changeDescription) throws DataAccessException;

	/**
	 * JPQL Query - findChangerequestByChangeDescription
	 *
	 */
	public Set<Changerequest> findChangerequestByChangeDescription(String changeDescription, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findChangerequestByChangeDescriptionContaining
	 *
	 */
	public Set<Changerequest> findChangerequestByChangeDescriptionContaining(String changeDescription_1) throws DataAccessException;

	/**
	 * JPQL Query - findChangerequestByChangeDescriptionContaining
	 *
	 */
	public Set<Changerequest> findChangerequestByChangeDescriptionContaining(String changeDescription_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findChangerequestByStatus
	 *
	 */
	public Set<Changerequest> findChangerequestByStatus(String status_1) throws DataAccessException;

	/**
	 * JPQL Query - findChangerequestByStatus
	 *
	 */
	public Set<Changerequest> findChangerequestByStatus(String status_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllChangerequests
	 *
	 */
	public Set<Changerequest> findAllChangerequests() throws DataAccessException;

	/**
	 * JPQL Query - findAllChangerequests
	 *
	 */
	public Set<Changerequest> findAllChangerequests(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findChangerequestByChangeCode
	 *
	 */
	public Set<Changerequest> findChangerequestByChangeCode(String changeCode) throws DataAccessException;

	/**
	 * JPQL Query - findChangerequestByChangeCode
	 *
	 */
	public Set<Changerequest> findChangerequestByChangeCode(String changeCode, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findChangerequestByChangeName
	 *
	 */
	public Set<Changerequest> findChangerequestByChangeName(String changeName) throws DataAccessException;

	/**
	 * JPQL Query - findChangerequestByChangeName
	 *
	 */
	public Set<Changerequest> findChangerequestByChangeName(String changeName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findChangerequestByChangeCodeContaining
	 *
	 */
	public Set<Changerequest> findChangerequestByChangeCodeContaining(String changeCode_1) throws DataAccessException;

	/**
	 * JPQL Query - findChangerequestByChangeCodeContaining
	 *
	 */
	public Set<Changerequest> findChangerequestByChangeCodeContaining(String changeCode_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findChangerequestByChangeId
	 *
	 */
	public Changerequest findChangerequestByChangeId(Integer changeId) throws DataAccessException;

	/**
	 * JPQL Query - findChangerequestByChangeId
	 *
	 */
	public Changerequest findChangerequestByChangeId(Integer changeId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findChangerequestByChangeNameContaining
	 *
	 */
	public Set<Changerequest> findChangerequestByChangeNameContaining(String changeName_1) throws DataAccessException;

	/**
	 * JPQL Query - findChangerequestByChangeNameContaining
	 *
	 */
	public Set<Changerequest> findChangerequestByChangeNameContaining(String changeName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findChangerequestByChangePriority
	 *
	 */
	public Set<Changerequest> findChangerequestByChangePriority(String changePriority_1) throws DataAccessException;

	/**
	 * JPQL Query - findChangerequestByChangePriority
	 *
	 */
	public Set<Changerequest> findChangerequestByChangePriority(String changePriority_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findChangerequestByPrimaryKey
	 *
	 */
	public Changerequest findChangerequestByPrimaryKey(Integer changeId_1) throws DataAccessException;

	/**
	 * JPQL Query - findChangerequestByPrimaryKey
	 *
	 */
	public Changerequest findChangerequestByPrimaryKey(Integer changeId_1, int startResult, int maxRows) throws DataAccessException;

	public Integer getMaxChangeId();
}