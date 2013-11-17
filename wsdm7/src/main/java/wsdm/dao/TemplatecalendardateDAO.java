package wsdm.dao;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import wsdm.domain.Templatecalendardate;

/**
 * DAO to manage Templatecalendardate entities.
 * 
 */
public interface TemplatecalendardateDAO extends JpaDao<Templatecalendardate> {

	/**
	 * JPQL Query - findTemplatecalendardateByPrimaryKey
	 *
	 */
	public Templatecalendardate findTemplatecalendardateByPrimaryKey(Integer calDateId) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatecalendardateByPrimaryKey
	 *
	 */
	public Templatecalendardate findTemplatecalendardateByPrimaryKey(Integer calDateId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatecalendardateByDailyTemplateFk
	 *
	 */
	public Set<Templatecalendardate> findTemplatecalendardateByDailyTemplateFk(Integer dailyTemplateFk) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatecalendardateByDailyTemplateFk
	 *
	 */
	public Set<Templatecalendardate> findTemplatecalendardateByDailyTemplateFk(Integer dailyTemplateFk, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatecalendardateByCalDateId
	 *
	 */
	public Templatecalendardate findTemplatecalendardateByCalDateId(Integer calDateId_1) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatecalendardateByCalDateId
	 *
	 */
	public Templatecalendardate findTemplatecalendardateByCalDateId(Integer calDateId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllTemplatecalendardates
	 *
	 */
	public Set<Templatecalendardate> findAllTemplatecalendardates() throws DataAccessException;

	/**
	 * JPQL Query - findAllTemplatecalendardates
	 *
	 */
	public Set<Templatecalendardate> findAllTemplatecalendardates(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatecalendardateByDate
	 *
	 */
	public Set<Templatecalendardate> findTemplatecalendardateByDate(java.util.Calendar date) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatecalendardateByDate
	 *
	 */
	public Set<Templatecalendardate> findTemplatecalendardateByDate(Calendar date, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatecalendardateByDateAfter
	 *
	 */
	public Set<Templatecalendardate> findTemplatecalendardateByDateAfter(java.util.Calendar date_1) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatecalendardateByDateAfter
	 *
	 */
	public Set<Templatecalendardate> findTemplatecalendardateByDateAfter(Calendar date_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatecalendardateByResourceFk
	 *
	 */
	public Set<Templatecalendardate> findTemplatecalendardateByResourceFk(Integer resourceFk) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatecalendardateByResourceFk
	 *
	 */
	public Set<Templatecalendardate> findTemplatecalendardateByResourceFk(Integer resourceFk, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatecalendardateByDateBefore
	 *
	 */
	public Set<Templatecalendardate> findTemplatecalendardateByDateBefore(java.util.Calendar date_2) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatecalendardateByDateBefore
	 *
	 */
	public Set<Templatecalendardate> findTemplatecalendardateByDateBefore(Calendar date_2, int startResult, int maxRows) throws DataAccessException;

}