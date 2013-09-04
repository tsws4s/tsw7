package tsw.dao;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.joda.time.MutableDateTime;
import org.skyway.spring.util.dao.AbstractJpaDao;

import org.springframework.dao.DataAccessException;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import tsw.domain.Event;
import tsw.web.UsersController;

/**
 * DAO to manage Event entities.
 * 
 */
@Repository("EventDAO")
@Transactional
public class EventDAOImpl extends AbstractJpaDao<Event> implements EventDAO {
	
	int defaultMaxRows = UsersController.getDefaultMaxRows();

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Event.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_tsw4
	 *
	 */
	@PersistenceContext(unitName = "tsws4s_4")
	private EntityManager entityManager;

	/**
	 * Instantiates a new EventDAOImpl
	 *
	 */
	public EventDAOImpl() {
		super();
	}

	/**
	 * Get the entity manager that manages persistence unit 
	 *
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Returns the set of entity classes managed by this DAO.
	 *
	 */
	public Set<Class<?>> getTypes() {
		return dataTypes;
	}

	/**
	 * JPQL Query - findEventByEventName
	 *
	 */
	@Transactional
	public Set<Event> findEventByEventName(String eventName) throws DataAccessException {

		return findEventByEventName(eventName, -1, -1);
	}

	/**
	 * JPQL Query - findEventByEventName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Event> findEventByEventName(String eventName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findEventByEventName", startResult, maxRows, eventName);
		return new LinkedHashSet<Event>(query.getResultList());
	}

	/**
	 * JPQL Query - findEventByPrimaryKey
	 *
	 */
	@Transactional
	public Event findEventByPrimaryKey(Integer eventId) throws DataAccessException {

		return findEventByPrimaryKey(eventId, -1, -1);
	}

	/**
	 * JPQL Query - findEventByPrimaryKey
	 *
	 */

	@Transactional
	public Event findEventByPrimaryKey(Integer eventId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findEventByPrimaryKey", startResult, maxRows, eventId);
			return (tsw.domain.Event) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findEventByEventUrlContaining
	 *
	 */
	@Transactional
	public Set<Event> findEventByEventUrlContaining(String eventUrl) throws DataAccessException {

		return findEventByEventUrlContaining(eventUrl, -1, -1);
	}

	/**
	 * JPQL Query - findEventByEventUrlContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Event> findEventByEventUrlContaining(String eventUrl, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findEventByEventUrlContaining", startResult, maxRows, eventUrl);
		return new LinkedHashSet<Event>(query.getResultList());
	}

	/**
	 * JPQL Query - findEventByStartTime
	 *
	 */
	@Transactional
	public Set<Event> findEventByStartTime(java.util.Calendar startTime) throws DataAccessException {

		return findEventByStartTime(startTime, -1, -1);
	}

	/**
	 * JPQL Query - findEventByStartTime
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Event> findEventByStartTime(java.util.Calendar startTime, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findEventByStartTime", startResult, maxRows, startTime);
		return new LinkedHashSet<Event>(query.getResultList());
	}

	/**
	 * JPQL Query - findEventByEventColorContaining
	 *
	 */
	@Transactional
	public Set<Event> findEventByEventColorContaining(String eventColor) throws DataAccessException {

		return findEventByEventColorContaining(eventColor, -1, -1);
	}

	/**
	 * JPQL Query - findEventByEventColorContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Event> findEventByEventColorContaining(String eventColor, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findEventByEventColorContaining", startResult, maxRows, eventColor);
		return new LinkedHashSet<Event>(query.getResultList());
	}

	/**
	 * JPQL Query - findEventByEventId
	 *
	 */
	@Transactional
	public Event findEventByEventId(Integer eventId) throws DataAccessException {

		return findEventByEventId(eventId, -1, -1);
	}

	/**
	 * JPQL Query - findEventByEventId
	 *
	 */

	@Transactional
	public Event findEventByEventId(Integer eventId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findEventByEventId", startResult, maxRows, eventId);
			return (tsw.domain.Event) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}
	
	@Transactional
	public Event findEventByGameId(Integer gameId) throws DataAccessException {
		try {
			Query query = createNamedQuery("findEventByGameId", -1, -1, gameId);
			return (tsw.domain.Event) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}
	
	/**
	 * JPQL Query - findEventByEndTime
	 *
	 */
	@Transactional
	public Set<Event> findEventByEndTime(java.util.Calendar endTime) throws DataAccessException {

		return findEventByEndTime(endTime, -1, -1);
	}

	/**
	 * JPQL Query - findEventByEndTime
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Event> findEventByEndTime(java.util.Calendar endTime, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findEventByEndTime", startResult, maxRows, endTime);
		return new LinkedHashSet<Event>(query.getResultList());
	}

	/**
	 * JPQL Query - findEventByDescriptionContaining
	 *
	 */
	@Transactional
	public Set<Event> findEventByDescriptionContaining(String description) throws DataAccessException {

		return findEventByDescriptionContaining(description, -1, -1);
	}

	/**
	 * JPQL Query - findEventByDescriptionContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Event> findEventByDescriptionContaining(String description, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findEventByDescriptionContaining", startResult, maxRows, description);
		return new LinkedHashSet<Event>(query.getResultList());
	}

	/**
	 * JPQL Query - findEventByEventType
	 *
	 */
	@Transactional
	public Set<Event> findEventByEventType(String eventType) throws DataAccessException {

		return findEventByEventType(eventType, -1, -1);
	}

	/**
	 * JPQL Query - findEventByEventType
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Event> findEventByEventType(String eventType, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findEventByEventType", startResult, maxRows, eventType);
		return new LinkedHashSet<Event>(query.getResultList());
	}

	/**
	 * JPQL Query - findEventByEventColor
	 *
	 */
	@Transactional
	public Set<Event> findEventByEventColor(String eventColor) throws DataAccessException {

		return findEventByEventColor(eventColor, -1, -1);
	}

	/**
	 * JPQL Query - findEventByEventColor
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Event> findEventByEventColor(String eventColor, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findEventByEventColor", startResult, maxRows, eventColor);
		return new LinkedHashSet<Event>(query.getResultList());
	}

	/**
	 * JPQL Query - findEventByAllDay
	 *
	 */
	@Transactional
	public Set<Event> findEventByAllDay(Boolean allDay) throws DataAccessException {

		return findEventByAllDay(allDay, -1, -1);
	}

	/**
	 * JPQL Query - findEventByAllDay
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Event> findEventByAllDay(Boolean allDay, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findEventByAllDay", startResult, maxRows, allDay);
		return new LinkedHashSet<Event>(query.getResultList());
	}

	/**
	 * JPQL Query - findEventByEventNameContaining
	 *
	 */
	@Transactional
	public Set<Event> findEventByEventNameContaining(String eventName) throws DataAccessException {

		return findEventByEventNameContaining(eventName, -1, -1);
	}

	/**
	 * JPQL Query - findEventByEventNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Event> findEventByEventNameContaining(String eventName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findEventByEventNameContaining", startResult, maxRows, eventName);
		return new LinkedHashSet<Event>(query.getResultList());
	}

	/**
	 * JPQL Query - findEventByEventTypeContaining
	 *
	 */
	@Transactional
	public Set<Event> findEventByEventTypeContaining(String eventType) throws DataAccessException {

		return findEventByEventTypeContaining(eventType, -1, -1);
	}

	/**
	 * JPQL Query - findEventByEventTypeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Event> findEventByEventTypeContaining(String eventType, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findEventByEventTypeContaining", startResult, maxRows, eventType);
		return new LinkedHashSet<Event>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllEvents
	 *
	 */
	@Transactional
	public Set<Event> findAllEvents() throws DataAccessException {

		return findAllEvents(-1, -1);
	}

	/**
	 * JPQL Query - findAllEvents
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Event> findAllEvents(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllEvents", startResult, maxRows);
		return new LinkedHashSet<Event>(query.getResultList());
	}

	/**
	 * JPQL Query - findEventByEventUrl
	 *
	 */
	@Transactional
	public Set<Event> findEventByEventUrl(String eventUrl) throws DataAccessException {

		return findEventByEventUrl(eventUrl, -1, -1);
	}

	/**
	 * JPQL Query - findEventByEventUrl
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Event> findEventByEventUrl(String eventUrl, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findEventByEventUrl", startResult, maxRows, eventUrl);
		return new LinkedHashSet<Event>(query.getResultList());
	}

	/**
	 * JPQL Query - findEventByDescription
	 *
	 */
	@Transactional
	public Set<Event> findEventByDescription(String description) throws DataAccessException {

		return findEventByDescription(description, -1, -1);
	}

	/**
	 * JPQL Query - findEventByDescription
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Event> findEventByDescription(String description, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findEventByDescription", startResult, maxRows, description);
		return new LinkedHashSet<Event>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Event entity) {
		return true;
	}
	
	public Integer getMaxEventID() {
		Object obj = executeQuerySingleResult("select max(eventId) from Event");
		return (Integer)obj;
	}

	@Override
	public Set<Event> findEventByDateAfter(Integer resourceId,	Calendar afterDate, int indexFrom) {
		return findEventByDateAfter(resourceId, afterDate, indexFrom, defaultMaxRows);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Event> findEventByDateAfter(Integer resourceId, Calendar afterDate, int startResult, int maxRows) throws DataAccessException {

		if(afterDate==null){
			MutableDateTime dt = MutableDateTime.now();
			dt.setDayOfMonth(1);
			dt.addDays(-1);
			afterDate = dt.toGregorianCalendar();			
		}
//		Query query = createNamedQuery("findEventByDateAfter", startResult, maxRows, resourceId, afterDate);
		Query query = createNamedQuery("findEventByDateAfter", startResult, maxRows, resourceId);
		return new LinkedHashSet<Event>(query.getResultList());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<? extends Event> findAllEvents4tsw(Integer startResult, Integer maxRows, Integer tswId) {
		Query query = createNamedQuery("findAllEvents4tsw", startResult, maxRows, tswId);
		return new LinkedHashSet<Event>(query.getResultList());
	}
	
}
