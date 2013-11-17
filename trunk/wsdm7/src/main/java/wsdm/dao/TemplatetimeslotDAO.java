package wsdm.dao;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import wsdm.domain.Templatetimeslot;

/**
 * DAO to manage Templatetimeslot entities.
 * 
 */
public interface TemplatetimeslotDAO extends JpaDao<Templatetimeslot> {

	/**
	 * JPQL Query - findTemplatetimeslotByPriceFk
	 *
	 */
	public Set<Templatetimeslot> findTemplatetimeslotByPriceFk(Integer priceFk) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatetimeslotByPriceFk
	 *
	 */
	public Set<Templatetimeslot> findTemplatetimeslotByPriceFk(Integer priceFk, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatetimeslotByStartTime
	 *
	 */
	public Set<Templatetimeslot> findTemplatetimeslotByStartTime(java.util.Calendar startTime) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatetimeslotByStartTime
	 *
	 */
	public Set<Templatetimeslot> findTemplatetimeslotByStartTime(Calendar startTime, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllTemplatetimeslots
	 *
	 */
	public Set<Templatetimeslot> findAllTemplatetimeslots() throws DataAccessException;

	/**
	 * JPQL Query - findAllTemplatetimeslots
	 *
	 */
	public Set<Templatetimeslot> findAllTemplatetimeslots(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatetimeslotBySlotNum
	 *
	 */
	public Set<Templatetimeslot> findTemplatetimeslotBySlotNum(Integer slotNum) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatetimeslotBySlotNum
	 *
	 */
	public Set<Templatetimeslot> findTemplatetimeslotBySlotNum(Integer slotNum, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatetimeslotByDailyTemplateFk
	 *
	 */
	public Set<Templatetimeslot> findTemplatetimeslotByDailyTemplateFk(Integer dailyTemplateFk) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatetimeslotByDailyTemplateFk
	 *
	 */
	public Set<Templatetimeslot> findTemplatetimeslotByDailyTemplateFk(Integer dailyTemplateFk, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatetimeslotByTimeSlotId
	 *
	 */
	public Templatetimeslot findTemplatetimeslotByTimeSlotId(Integer timeSlotId) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatetimeslotByTimeSlotId
	 *
	 */
	public Templatetimeslot findTemplatetimeslotByTimeSlotId(Integer timeSlotId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatetimeslotByEndTime
	 *
	 */
	public Set<Templatetimeslot> findTemplatetimeslotByEndTime(java.util.Calendar endTime) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatetimeslotByEndTime
	 *
	 */
	public Set<Templatetimeslot> findTemplatetimeslotByEndTime(Calendar endTime, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatetimeslotByPrimaryKey
	 *
	 */
	public Templatetimeslot findTemplatetimeslotByPrimaryKey(Integer timeSlotId_1) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatetimeslotByPrimaryKey
	 *
	 */
	public Templatetimeslot findTemplatetimeslotByPrimaryKey(Integer timeSlotId_1, int startResult, int maxRows) throws DataAccessException;

}