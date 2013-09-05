package pm7.dao;

import java.math.BigDecimal;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import pm7.domain.Timeentry;

/**
 * DAO to manage Timeentry entities.
 * 
 */
public interface TimeentryDAO extends JpaDao<Timeentry> {

	/**
	 * JPQL Query - findTimeentryByDescriptionContaining
	 *
	 */
	public Set<Timeentry> findTimeentryByDescriptionContaining(String description) throws DataAccessException;

	/**
	 * JPQL Query - findTimeentryByDescriptionContaining
	 *
	 */
	public Set<Timeentry> findTimeentryByDescriptionContaining(String description, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTimeentryByDescription
	 *
	 */
	public Set<Timeentry> findTimeentryByDescription(String description_1) throws DataAccessException;

	/**
	 * JPQL Query - findTimeentryByDescription
	 *
	 */
	public Set<Timeentry> findTimeentryByDescription(String description_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTimeentryByPrimaryKey
	 *
	 */
	public Timeentry findTimeentryByPrimaryKey(Integer timeEntryId) throws DataAccessException;

	/**
	 * JPQL Query - findTimeentryByPrimaryKey
	 *
	 */
	public Timeentry findTimeentryByPrimaryKey(Integer timeEntryId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTimeentryByTimeHrs
	 *
	 */
	public Set<Timeentry> findTimeentryByTimeHrs(Integer timeHrs) throws DataAccessException;

	/**
	 * JPQL Query - findTimeentryByTimeHrs
	 *
	 */
	public Set<Timeentry> findTimeentryByTimeHrs(Integer timeHrs, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTimeentryByDate
	 *
	 */
	public Set<Timeentry> findTimeentryByDate(java.util.Calendar date) throws DataAccessException;

	/**
	 * JPQL Query - findTimeentryByDate
	 *
	 */
	public Set<Timeentry> findTimeentryByDate(Calendar date, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTimeentryByRateAmt
	 *
	 */
	public Set<Timeentry> findTimeentryByRateAmt(java.math.BigDecimal rateAmt) throws DataAccessException;

	/**
	 * JPQL Query - findTimeentryByRateAmt
	 *
	 */
	public Set<Timeentry> findTimeentryByRateAmt(BigDecimal rateAmt, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTimeentryByTimeEntryId
	 *
	 */
	public Timeentry findTimeentryByTimeEntryId(Integer timeEntryId_1) throws DataAccessException;

	/**
	 * JPQL Query - findTimeentryByTimeEntryId
	 *
	 */
	public Timeentry findTimeentryByTimeEntryId(Integer timeEntryId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllTimeentrys
	 *
	 */
	public Set<Timeentry> findAllTimeentrys() throws DataAccessException;

	/**
	 * JPQL Query - findAllTimeentrys
	 *
	 */
	public Set<Timeentry> findAllTimeentrys(int startResult, int maxRows) throws DataAccessException;

	public Integer getMaxTimeentryId();
}