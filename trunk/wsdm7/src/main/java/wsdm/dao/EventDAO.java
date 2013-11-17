package wsdm.dao;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import wsdm.domain.Event;

/**
 * DAO to manage Event entities.
 * 
 */
public interface EventDAO extends JpaDao<Event> {

	/**
	 * JPQL Query - findEventByEventColorContaining
	 *
	 */
	public Set<Event> findEventByEventColorContaining(String eventColor) throws DataAccessException;

	/**
	 * JPQL Query - findEventByEventColorContaining
	 *
	 */
	public Set<Event> findEventByEventColorContaining(String eventColor, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEventByEventNameContaining
	 *
	 */
	public Set<Event> findEventByEventNameContaining(String eventName) throws DataAccessException;

	/**
	 * JPQL Query - findEventByEventNameContaining
	 *
	 */
	public Set<Event> findEventByEventNameContaining(String eventName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEventByAllDay
	 *
	 */
	public Set<Event> findEventByAllDay(Boolean allDay) throws DataAccessException;

	/**
	 * JPQL Query - findEventByAllDay
	 *
	 */
	public Set<Event> findEventByAllDay(Boolean allDay, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllEvents
	 *
	 */
	public Set<Event> findAllEvents() throws DataAccessException;

	/**
	 * JPQL Query - findAllEvents
	 *
	 */
	public Set<Event> findAllEvents(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEventByEventType
	 *
	 */
	public Set<Event> findEventByEventType(String eventType) throws DataAccessException;

	/**
	 * JPQL Query - findEventByEventType
	 *
	 */
	public Set<Event> findEventByEventType(String eventType, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEventByEventUrl
	 *
	 */
	public Set<Event> findEventByEventUrl(String eventUrl) throws DataAccessException;

	/**
	 * JPQL Query - findEventByEventUrl
	 *
	 */
	public Set<Event> findEventByEventUrl(String eventUrl, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEventByEventColor
	 *
	 */
	public Set<Event> findEventByEventColor(String eventColor_1) throws DataAccessException;

	/**
	 * JPQL Query - findEventByEventColor
	 *
	 */
	public Set<Event> findEventByEventColor(String eventColor_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEventByEventId
	 *
	 */
	public Event findEventByEventId(Integer eventId) throws DataAccessException;

	/**
	 * JPQL Query - findEventByEventId
	 *
	 */
	public Event findEventByEventId(Integer eventId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEventByStartTime
	 *
	 */
	public Set<Event> findEventByStartTime(java.util.Calendar startTime) throws DataAccessException;

	/**
	 * JPQL Query - findEventByStartTime
	 *
	 */
	public Set<Event> findEventByStartTime(Calendar startTime, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEventByEventName
	 *
	 */
	public Set<Event> findEventByEventName(String eventName_1) throws DataAccessException;

	/**
	 * JPQL Query - findEventByEventName
	 *
	 */
	public Set<Event> findEventByEventName(String eventName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEventByEndTime
	 *
	 */
	public Set<Event> findEventByEndTime(java.util.Calendar endTime) throws DataAccessException;

	/**
	 * JPQL Query - findEventByEndTime
	 *
	 */
	public Set<Event> findEventByEndTime(Calendar endTime, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEventByPrimaryKey
	 *
	 */
	public Event findEventByPrimaryKey(Integer eventId_1) throws DataAccessException;

	/**
	 * JPQL Query - findEventByPrimaryKey
	 *
	 */
	public Event findEventByPrimaryKey(Integer eventId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEventByEventTypeContaining
	 *
	 */
	public Set<Event> findEventByEventTypeContaining(String eventType_1) throws DataAccessException;

	/**
	 * JPQL Query - findEventByEventTypeContaining
	 *
	 */
	public Set<Event> findEventByEventTypeContaining(String eventType_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEventByDescriptionContaining
	 *
	 */
	public Set<Event> findEventByDescriptionContaining(String description) throws DataAccessException;

	/**
	 * JPQL Query - findEventByDescriptionContaining
	 *
	 */
	public Set<Event> findEventByDescriptionContaining(String description, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEventByEventUrlContaining
	 *
	 */
	public Set<Event> findEventByEventUrlContaining(String eventUrl_1) throws DataAccessException;

	/**
	 * JPQL Query - findEventByEventUrlContaining
	 *
	 */
	public Set<Event> findEventByEventUrlContaining(String eventUrl_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEventByDescription
	 *
	 */
	public Set<Event> findEventByDescription(String description_1) throws DataAccessException;

	/**
	 * JPQL Query - findEventByDescription
	 *
	 */
	public Set<Event> findEventByDescription(String description_1, int startResult, int maxRows) throws DataAccessException;

}