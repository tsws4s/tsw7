package pm7.dao;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import pm7.domain.Statusupdate;

/**
 * DAO to manage Statusupdate entities.
 * 
 */
public interface StatusupdateDAO extends JpaDao<Statusupdate> {

	/**
	 * JPQL Query - findStatusupdateByEstHrsLeft
	 *
	 */
	public Set<Statusupdate> findStatusupdateByEstHrsLeft(Integer estHrsLeft) throws DataAccessException;

	/**
	 * JPQL Query - findStatusupdateByEstHrsLeft
	 *
	 */
	public Set<Statusupdate> findStatusupdateByEstHrsLeft(Integer estHrsLeft, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllStatusupdates
	 *
	 */
	public Set<Statusupdate> findAllStatusupdates() throws DataAccessException;

	/**
	 * JPQL Query - findAllStatusupdates
	 *
	 */
	public Set<Statusupdate> findAllStatusupdates(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStatusupdateByPrimaryKey
	 *
	 */
	public Statusupdate findStatusupdateByPrimaryKey(Integer statusId) throws DataAccessException;

	/**
	 * JPQL Query - findStatusupdateByPrimaryKey
	 *
	 */
	public Statusupdate findStatusupdateByPrimaryKey(Integer statusId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStatusupdateByRiskGyrContaining
	 *
	 */
	public Set<Statusupdate> findStatusupdateByRiskGyrContaining(String riskGyr) throws DataAccessException;

	/**
	 * JPQL Query - findStatusupdateByRiskGyrContaining
	 *
	 */
	public Set<Statusupdate> findStatusupdateByRiskGyrContaining(String riskGyr, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStatusupdateByRiskGyr
	 *
	 */
	public Set<Statusupdate> findStatusupdateByRiskGyr(String riskGyr_1) throws DataAccessException;

	/**
	 * JPQL Query - findStatusupdateByRiskGyr
	 *
	 */
	public Set<Statusupdate> findStatusupdateByRiskGyr(String riskGyr_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStatusupdateByStatusDateBefore
	 *
	 */
	public Set<Statusupdate> findStatusupdateByStatusDateBefore(java.util.Calendar statusDate) throws DataAccessException;

	/**
	 * JPQL Query - findStatusupdateByStatusDateBefore
	 *
	 */
	public Set<Statusupdate> findStatusupdateByStatusDateBefore(Calendar statusDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStatusupdateByStatusUpdateDescContaining
	 *
	 */
	public Set<Statusupdate> findStatusupdateByStatusUpdateDescContaining(String statusUpdateDesc) throws DataAccessException;

	/**
	 * JPQL Query - findStatusupdateByStatusUpdateDescContaining
	 *
	 */
	public Set<Statusupdate> findStatusupdateByStatusUpdateDescContaining(String statusUpdateDesc, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStatusupdateByStatusDateAfter
	 *
	 */
	public Set<Statusupdate> findStatusupdateByStatusDateAfter(java.util.Calendar statusDate_1) throws DataAccessException;

	/**
	 * JPQL Query - findStatusupdateByStatusDateAfter
	 *
	 */
	public Set<Statusupdate> findStatusupdateByStatusDateAfter(Calendar statusDate_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStatusupdateByStatusUpdateDesc
	 *
	 */
	public Set<Statusupdate> findStatusupdateByStatusUpdateDesc(String statusUpdateDesc_1) throws DataAccessException;

	/**
	 * JPQL Query - findStatusupdateByStatusUpdateDesc
	 *
	 */
	public Set<Statusupdate> findStatusupdateByStatusUpdateDesc(String statusUpdateDesc_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStatusupdateByStatusId
	 *
	 */
	public Statusupdate findStatusupdateByStatusId(Integer statusId_1) throws DataAccessException;

	/**
	 * JPQL Query - findStatusupdateByStatusId
	 *
	 */
	public Statusupdate findStatusupdateByStatusId(Integer statusId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStatusupdateByStatusDate
	 *
	 */
	public Set<Statusupdate> findStatusupdateByStatusDate(java.util.Calendar statusDate_2) throws DataAccessException;

	/**
	 * JPQL Query - findStatusupdateByStatusDate
	 *
	 */
	public Set<Statusupdate> findStatusupdateByStatusDate(Calendar statusDate_2, int startResult, int maxRows) throws DataAccessException;

	public Integer getMaxStatusupdateId();
}