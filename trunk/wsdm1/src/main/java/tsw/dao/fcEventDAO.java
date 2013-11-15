package tsw.dao;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import tsw.domain.fcEvent;

/**
 * DAO to manage fcEvent entities.
 * 
 */
public interface fcEventDAO extends JpaDao<fcEvent> {

	/**
	 * JPQL Query - findfcEventByTitleContaining
	 *
	 */
	public Set<fcEvent> findfcEventByTitleContaining(String title) throws DataAccessException;

	/**
	 * JPQL Query - findfcEventByTitleContaining
	 *
	 */
	public Set<fcEvent> findfcEventByTitleContaining(String title, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllfcEvents
	 *
	 */
	public Set<fcEvent> findAllfcEvents4tsw(Integer tswId) throws DataAccessException;
	public Set<fcEvent> findAllfcEvents4tswResource(Integer tswId, Integer resId) throws DataAccessException;
	/**
	 * JPQL Query - findAllfcEvents
	 *
	 */
	public Set<fcEvent> findAllfcEvents4tsw(Integer tswId, int startResult, int maxRows) throws DataAccessException;
	public Set<fcEvent> findAllfcEvents4tswResource(Integer tswId, Integer resId, int startResult, int maxRows) throws DataAccessException;
	/**
	 * JPQL Query - findfcEventByUrl
	 *
	 */
	public Set<fcEvent> findfcEventByUrl(String url) throws DataAccessException;

	/**
	 * JPQL Query - findfcEventByUrl
	 *
	 */
	public Set<fcEvent> findfcEventByUrl(String url, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findfcEventByEnd
	 *
	 */
	public Set<fcEvent> findfcEventByEnd(java.util.Calendar end) throws DataAccessException;

	/**
	 * JPQL Query - findfcEventByEnd
	 *
	 */
	public Set<fcEvent> findfcEventByEnd(Calendar end, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findfcEventByUrlContaining
	 *
	 */
	public Set<fcEvent> findfcEventByUrlContaining(String url_1) throws DataAccessException;

	/**
	 * JPQL Query - findfcEventByUrlContaining
	 *
	 */
	public Set<fcEvent> findfcEventByUrlContaining(String url_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findfcEventByTitle
	 *
	 */
	public Set<fcEvent> findfcEventByTitle(String title_1) throws DataAccessException;

	/**
	 * JPQL Query - findfcEventByTitle
	 *
	 */
	public Set<fcEvent> findfcEventByTitle(String title_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findfcEventByAllDay
	 *
	 */
	public Set<fcEvent> findfcEventByAllDay(Boolean allDay) throws DataAccessException;

	/**
	 * JPQL Query - findfcEventByAllDay
	 *
	 */
	public Set<fcEvent> findfcEventByAllDay(Boolean allDay, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findfcEventByClassNameContaining
	 *
	 */
	public Set<fcEvent> findfcEventByClassNameContaining(String className) throws DataAccessException;

	/**
	 * JPQL Query - findfcEventByClassNameContaining
	 *
	 */
	public Set<fcEvent> findfcEventByClassNameContaining(String className, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findfcEventByColorContaining
	 *
	 */
	public Set<fcEvent> findfcEventByColorContaining(String color) throws DataAccessException;

	/**
	 * JPQL Query - findfcEventByColorContaining
	 *
	 */
	public Set<fcEvent> findfcEventByColorContaining(String color, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findfcEventByClassName
	 *
	 */
	public Set<fcEvent> findfcEventByClassName(String className_1) throws DataAccessException;

	/**
	 * JPQL Query - findfcEventByClassName
	 *
	 */
	public Set<fcEvent> findfcEventByClassName(String className_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findfcEventByEditable
	 *
	 */
	public Set<fcEvent> findfcEventByEditable(Boolean editable) throws DataAccessException;

	/**
	 * JPQL Query - findfcEventByEditable
	 *
	 */
	public Set<fcEvent> findfcEventByEditable(Boolean editable, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findfcEventByColor
	 *
	 */
	public Set<fcEvent> findfcEventByColor(String color_1) throws DataAccessException;

	/**
	 * JPQL Query - findfcEventByColor
	 *
	 */
	public Set<fcEvent> findfcEventByColor(String color_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findfcEventByPrimaryKey
	 *
	 */
	public fcEvent findfcEventByPrimaryKey(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findfcEventByPrimaryKey
	 *
	 */
	public fcEvent findfcEventByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findfcEventByStart
	 *
	 */
	public Set<fcEvent> findfcEventByStart(java.util.Calendar start) throws DataAccessException;

	/**
	 * JPQL Query - findfcEventByStart
	 *
	 */
	public Set<fcEvent> findfcEventByStart(Calendar start, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findfcEventById
	 *
	 */
	public fcEvent findfcEventById(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findfcEventById
	 *
	 */
	public fcEvent findfcEventById(Integer id_1, int startResult, int maxRows) throws DataAccessException;

	public Set<fcEvent> findfcEventByResourceDateAfterBefore(Integer resource_id, Calendar afterDate, Calendar beforeDate);

}